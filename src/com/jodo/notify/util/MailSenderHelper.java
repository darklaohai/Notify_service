/**
 * @(#)Jodo, 2014年1月25日
 */
package com.jodo.notify.util;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.internet.MimeUtility;

import cn.gd.gz.treemanz.toolbox.mailsender.ConnectionParams;
import cn.gd.gz.treemanz.toolbox.mailsender.SendJob;
import cn.gd.gz.treemanz.toolbox.mailsender.helper.ConnectionPool;
import cn.gd.gz.treemanz.toolbox.mailsender.helper.MailSender;
import cn.gd.gz.treemanz.toolbox.mailsender.helper.impl.PooledMailSender;

import com.jodo.notify.dao.NotifyManagerDao;
import com.jodo.notify.model.NameValueModel;
import com.jodo.notify.sqlhelper.ConfigManager;



/**
 * @author treemanz
 */
public class MailSenderHelper {

    public static final MailSender instance = new PooledMailSender();

    private MailSenderHelper() {

    }

    public static void sendEmail(String subject, String content, String...receiverList) throws Exception {
        SendJob sendJob = new SendJob();
        sendJob.setContentEncoding("UTF-8");
        sendJob.setSubjectEncoding("UTF-8");
        sendJob.setAddressEncoding("UTF-8");
        try {
            sendJob.setSubject(MimeUtility.encodeText((ConfigManager.instance.isEnvOnline() ? "" : "[test]") + subject,
                    "UTF-8", "B"));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        sendJob.setContent(content);
        for (String email: receiverList) {
            sendJob.addTo(email);
        }

        instance.send(sendJob);
        return;
    }

    public static void init() {
        new Thread(new Runnable() {
            @Override
            public void run() {
            	List<NameValueModel> listplatformEntry = NotifyManagerDao.getplatformEntry("mail");
            	String email=listplatformEntry.get(0).getName();
            	String psw=listplatformEntry.get(0).getValue();
                ConnectionParams connectionParams = new ConnectionParams();
                connectionParams.setEnvelopeFrom(email);
                connectionParams.setHeloName("1fPay管理員");
                connectionParams.setHost("smtp.exmail.qq.com");
                connectionParams.setNeedAuth(true);
                connectionParams.setPassword(psw);
                connectionParams.setProtocol("smtp");
                connectionParams.setPort(465);
                connectionParams.setMailProvider("gmail");
                ConnectionPool connectionPool = new ConnectionPool();
                connectionPool.setConnectionParams(connectionParams);
                connectionPool.setMaxPoolSize(20);
                connectionPool.setMaxUsePerConn(10000);
                connectionPool.setTimeout(50000);
                connectionPool.setInitPoolSize(5);
                connectionPool.setWaitingTimeout(120000);
                ((PooledMailSender) instance).setConnectionPool(connectionPool);
                System.out.println("MailSenderHelper init success");
            }
        }).start();
    }

}
