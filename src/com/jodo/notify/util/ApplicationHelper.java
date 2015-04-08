package com.jodo.notify.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.jodo.notify.dal.NotifyManagerDal;

public class ApplicationHelper {

    private static Map<Class<?>, ApplicationHelper> instanceMap = new ConcurrentHashMap<Class<?>, ApplicationHelper>();

    private static Object lock = new Object();

    public static ApplicationHelper getInstance(Class<?> clazz) {
        ApplicationHelper instance = instanceMap.get(clazz);
        if (null == instance) {
            synchronized (lock) {
                if (null == instance) {
                    instance = new ApplicationHelper(clazz);
                    instanceMap.put(clazz, instance);
                }
            }
        }
        return instance;
    }

    private Logger logger = null;

    private String clzzName;

    private ApplicationHelper(Class<?> clazz) {
        this.logger = Logger.getLogger(clazz);
        clzzName = clazz.getName();
    }

    public void error(String msg, Throwable t) {
        logger.error(msg, t);
    }

    public void error(String msg) {
        logger.error(msg);
        if (msg.contains("cpay state is not orderPageViewable")) {
            return;
        }
        if (msg.contains("cpay state is not orderCreatable")) {
            return;
        }

    }

    public void info(String msg) {
        logger.info(msg);
    }
    
    public void debug(String msg) {
        logger.debug(msg);
    }

}
