/**
 * @(#)Jodo, 2013年11月26日
 */
package com.jodo.notify.dao;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.internet.MimeUtility;

import cn.gd.gz.treemanz.toolbox.mailsender.SendJob;

import com.jodo.notify.sqlhelper.ConfigManager;
import com.jodo.notify.util.ApplicationHelper;
import com.jodo.notify.util.MailSenderHelper;

/**
 * @author treemanz
 */
public class NotifyEmailDao {
	private static final ApplicationHelper APPLICATION_HELPER = ApplicationHelper.getInstance(NotifyEmailDao.class);
	
    public static boolean sendEmail(String  title,String content,List<String> mailReceivers ) {		
   
    		boolean totalSuccess = true;
            SendJob sendJob = new SendJob();
            sendJob.setContentEncoding("UTF-8");
            sendJob.setSubjectEncoding("UTF-8");
            sendJob.setAddressEncoding("UTF-8");
            try {
                sendJob.setSubject(MimeUtility.encodeText(
                        (ConfigManager.instance.isEnvOnline() ? "" : "[test]")
                                + title, "UTF-8", "B"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            sendJob.setContent(content);
            for (String receiver: mailReceivers) {
                sendJob.addTo(receiver);
            }
            try {
                MailSenderHelper.instance.send(sendJob);
                APPLICATION_HELPER.debug(
                        "sendmail - status=success,sendJob="
                                + sendJob.toString());
            } catch (Exception e) {
                APPLICATION_HELPER
                        .error("sendmail - status=error,sendJob="
                                + sendJob.toString(), e);
            }
            if (!sendJob.isSuccess()) {
                totalSuccess = false;
            }
            
        return totalSuccess ;
	}

}
