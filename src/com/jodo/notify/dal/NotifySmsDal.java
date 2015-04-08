/**
 * @(#)Jodo, 2013年11月26日
 */
package com.jodo.notify.dal;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.jodo.notify.dao.NotifyManagerDao;
import com.jodo.notify.dao.NotifySmsDao;
import com.jodo.notify.model.JsonWxMsgModel;
import com.jodo.notify.model.NameValueModel;
import com.jodo.notify.util.JacksonUtil;

/**
 * @author treemanz
 */
public class NotifySmsDal {

    public static boolean sendSms(String content,List<String> smsReceivers){
    	boolean flag = true;
    	for(String receiver : smsReceivers){
			List<NameValueModel> listplatformEntry = NotifyManagerDao.getplatformEntry("sms");
			Map<String, String> mapuserEntry = NotifyManagerDao.getuserEntry("sms");
			String receiver_notice = mapuserEntry.get(receiver);
			String platformAccount =listplatformEntry.get(0).getName();
		/*	String platformPassword =listplatformEntry.get(0).getValue();		*/	
    		String result = NotifySmsDao.sendSms(platformAccount, receiver_notice, content);    	
			Map<String,Object> jsond = JacksonUtil.toJava(result, Map.class);
			if(!jsond.get("msg").equals("OK")){
			 flag = false;
			}
    	}
		return flag;
    }
}
