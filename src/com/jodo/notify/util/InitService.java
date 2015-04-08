package com.jodo.notify.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.owasp.validator.html.PolicyException;

import com.jodo.notify.dal.NotifyManagerDal;
import com.jodo.notify.sqlhelper.ConfigManager;
import com.jodo.notify.sqlhelper.DbManager;


public class InitService implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("init began");
        ConfigManager.instance.init();
        System.out.println("ConfigManager init success");
        MailSenderHelper.init();
        System.out.println("MailSenderHelper init executed");
        try {
			AntiSamyUtil.init();
			NotifyManagerDal.instance.init();
		} catch (PolicyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("init ended");
    }
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        ConfigManager.instance.shutdown();
        System.out.println("ConfigManager destory success");
        NotifyManagerDal.instance.shutdown();
        System.out.println("NotifyManager destroy success");
        DbManager.destryAll();
    }

}
