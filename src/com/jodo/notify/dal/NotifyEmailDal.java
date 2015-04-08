/**
 * @(#)Jodo, 2013年11月26日
 */
package com.jodo.notify.dal;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeUtility;

import cn.gd.gz.treemanz.toolbox.mailsender.SendJob;

import com.jodo.notify.dao.NotifyEmailDao;
import com.jodo.notify.dao.NotifyManagerDao;
import com.jodo.notify.sqlhelper.ConfigManager;
import com.jodo.notify.util.MailSenderHelper;

/**
 * @author treemanz
 */
public class NotifyEmailDal {

    public static boolean sendEmail(String title,String content,List<String> mailReceivers) {
    	List<String> receivers = new ArrayList<String>();
    	Map<String,String> mailuserEntryMap = NotifyManagerDao.getuserEntry("mail");
    	for(String receiver:mailReceivers){
    		if(receiver.equals("googleplaycrawler")){
    			receivers.add("wujianhai@jodogame.com");
    		}else{
    			String emailString = mailuserEntryMap.get(receiver);
    			receivers.add(emailString);
    		}
    	}
    	return NotifyEmailDao.sendEmail(title, content, receivers);
    } 
    
    public static void main(String[] args) {
    	
    	ConfigManager.instance.init();
    	MailSenderHelper.init();
    	List<String> receivers = new ArrayList<String>();
    	receivers.add("googleplay-monitor@jodogame.com");
    	NotifyEmailDao.sendEmail("test1", "test1",receivers );
	}
}
