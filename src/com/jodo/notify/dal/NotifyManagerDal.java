/**
 * @(#)Jodo, 2014年1月25日
 */
package com.jodo.notify.dal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.jodo.notify.dao.NotifyManagerDao;
import com.jodo.notify.model.AdminSimpleProductModel;
import com.jodo.notify.model.NameValueModel;
import com.jodo.notify.sqlhelper.ConfigManager;
import com.jodo.notify.util.ApplicationHelper;

/**
 * 通知類管理器，例如通知管理員等
 * 
 * @author treemanz
 */
public class NotifyManagerDal {

	public static final NotifyManagerDal instance = new NotifyManagerDal();

	private static final ApplicationHelper APPLICATION_HELPER = ApplicationHelper
			.getInstance(NotifyManagerDal.class);

	private NotifyManagerDal() {

	}

	public static volatile boolean enableNotifyThread = true;

	private Thread asyncSendThread = null;

	private volatile boolean asyncSendThread_forcedStopped = false;

	private BlockingQueue<SendRecord> sendRecordQueue = new LinkedBlockingQueue<NotifyManagerDal.SendRecord>();

	public void init() {
		asyncSendThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!asyncSendThread_forcedStopped) {
					try {
						if (enableNotifyThread) {
							SendRecord sendRecord = sendRecordQueue.poll(5L,
									TimeUnit.SECONDS);
							if (null != sendRecord) {
								realDoSend(sendRecord);
							}
						} else {
							Thread.sleep(10000L);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		asyncSendThread.start();
		System.out.println("notify thread started");
	}

	public void shutdown() {
		asyncSendThread_forcedStopped = true;
		asyncSendThread.interrupt();
		sendRecordQueue.clear();
		asyncSendThread = null;
	}

	private static final int LOG_LEVEL_DEBUG = 5;
	private static final int LOG_LEVEL_FATE = 4;
	private static final int LOG_LEVEL_ERROR = 3;
	private static final int LOG_LEVEL_INFO = 2;
	private static final int LOG_LEVEL_WARN = 1;

	private static class SendRecord {
		private String title;

		private String content;

		private List<String> mailReceivers;

		private List<NameValueModel> wxReceivers;

		private List<String> smsReceivers;

		private String platformAccount;

		private String platformPassword;

		public SendRecord(String title, String content,
				List<String> mailReceivers, List<NameValueModel> wxReceivers,
				List<String> smsReceivers) {
			this.title = title;
			this.content = content;
			this.mailReceivers = mailReceivers;
			this.wxReceivers = wxReceivers;
			this.smsReceivers = smsReceivers;
		}

	}

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private boolean realDoSend(SendRecord record) {
		boolean totalSuccess = true;
		// send by mail
		if (null != record.mailReceivers && record.mailReceivers.size() > 0) {
			if (!NotifyEmailDal.sendEmail(record.title, record.content,
					record.mailReceivers)) {
				totalSuccess = false;
			}
		}
		// send by weixin
		if (ConfigManager.instance.isEnvOnline() && null != record.wxReceivers
				&& record.wxReceivers.size() > 0) {
			if (!NotifyWeixinDal.sendWeixin(record.title, record.content,
					record.wxReceivers)) {
				totalSuccess = false;
			}
		}
		// send by sms
		if (ConfigManager.instance.isEnvOnline() && null != record.smsReceivers
				&& record.smsReceivers.size() > 0) {
			if (!NotifySmsDal.sendSms(record.content, record.smsReceivers)) {
				totalSuccess = false;
			}
		}

		return totalSuccess;
	}

	public void choice_rule(String title, String content, String userid,
			String platform, String product, String tag, String level) {
		List<AdminSimpleProductModel> simple_products = NotifyManagerDao
				.Simpleproduct_a_product(product, level);
		List<String> ruleList = new ArrayList<String>();
		String rule = tag;
		String tmp_rule = new String();
		for (int i = 0; i < simple_products.size(); i++) {
			int begin_count = simple_products.get(i).getAggr();
			String methodlabel = simple_products.get(i).getMethodlabel();
			int get_count = NotifyManagerDao.Simplelogger_count(product,
					methodlabel);
			if (begin_count > get_count) {
				// 打logs
				// 入库
				NotifyManagerDao.Simplelogger_insert(product, methodlabel,
						title, content, get_count + 1);
			} else if (begin_count <= get_count) {
				// 打logs
				NotifyManagerDao.Simplelogger_insert(product, methodlabel,
						title, content, 1);
				// 发送汇总信息
				// rule
			}

			/*
			 * if(tmp_rule.isEmpty()){ if(this_tag.equals("*")){
			 * ruleList.add(tmp_rule); tmp_rule=this_rule; } }else
			 * if(this_rule.equals(rule)){ tmp_rule=this_rule; }
			 */
		}
	}

	public boolean notifySend(String title, String content, String userid,
			String platform, String product, String tag, String level) {
		
		choice_rule(title, content, userid, platform, product, tag, level);
		List<String> mailReceivers = new ArrayList<String>();
		List<NameValueModel> wxReceivers = new ArrayList<NameValueModel>();
		List<String> smsReceivers = new ArrayList<String>();
		if (null == userid) {
			List<NameValueModel> basicNameValuePairs = NotifyManagerDao
					.getSeceviers(product, tag, level);
			for (int i = 0; i < basicNameValuePairs.size(); i++) {
				String user = basicNameValuePairs.get(i).getName();
				String sendmethod = basicNameValuePairs.get(i).getValue();
				if (sendmethod.equals("mail")) {
					mailReceivers.add(user);
				} else if (sendmethod.equals("sms")) {
					smsReceivers.add(user);
				} else {
					wxReceivers.add(new NameValueModel(user, sendmethod));
				}
			}
		} else {
			if (platform.equals("mail")) {
				mailReceivers.add(userid);
			} else if (platform.equals("sms")) {
				smsReceivers.add(userid);
			} else {
				wxReceivers.add(new NameValueModel(userid, platform));
			}
		}
		return sendRecordQueue.add(new SendRecord(title, content,
				mailReceivers, wxReceivers, smsReceivers));
	}

	/*
	 * public boolean notifyAdminCardNotEnough(int yuan) { String subject =
	 * "卡片不足 @" + sdf.format(new Date()); String content = "面額：" + yuan +
	 * "<br/><br/>請<a href=\"http://d98c7576c8c6693c.1fpay.com/manage/orderList\">登錄訂單管理頁面</a>處理。<br/>請<a href=\"http://d98c7576c8c6693c.1fpay.com/manage/uploadCard\">登錄卡密上傳頁面</a>處理"
	 * ; return doSend(subject, content, null, Constants.adminWxs,
	 * LOG_LEVEL_ERROR); }
	 */

}
