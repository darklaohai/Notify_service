/**
 * @(#)Jodo, 2013年11月26日
 */
package com.jodo.notify.dal;

import java.util.List;
import java.util.Map;

import com.jodo.notify.sqlhelper.ConfigManager;
import com.jodo.notify.dao.NotifyManagerDao;
import com.jodo.notify.dao.NotifyWeixinDao;
import com.jodo.notify.dao.NotifyWeixinProDao;
import com.jodo.notify.model.JsonTextMsgModel;
import com.jodo.notify.model.JsonTextMsgProModel;
import com.jodo.notify.model.NameValueModel;


/**
 * @author treemanz
 */
public class NotifyWeixinProDal {

	public static boolean sendWeixin(String title, String content,List<NameValueModel> wxReceivers) {
		boolean flag = true ;
		JsonTextMsgModel textMsg = new JsonTextMsgModel();
		textMsg.setContent((ConfigManager.instance.isEnvOnline() ? ""
				: "[test]")
				+ title
				+ "\r\n----\r\n"
				+ content.replace("<br/>", "\r\n"));
		boolean totalSuccess = true;
		for (NameValueModel receiver : wxReceivers) {
			List<NameValueModel> listplatformEntry = NotifyManagerDao.getplatformEntry(receiver.getValue());
			Map<String, String> mapuserEntry = NotifyManagerDao.getuserEntry(receiver.getValue());
			String receiver_notice = mapuserEntry.get(receiver.getName());
			String platformAccount =listplatformEntry.get(0).getName();
			String platformPassword =listplatformEntry.get(0).getValue();
			textMsg.setFromUserName(platformAccount);
			textMsg.setToUserName(receiver_notice);
			boolean sentSuccess = NotifyWeixinDao.sendWeixin(textMsg,platformAccount,platformPassword);
            if (!sentSuccess) {
            	totalSuccess = false;
            }
		}
		
		if (!totalSuccess) {
			flag = false;
		}
		return totalSuccess;
	}

	

}
