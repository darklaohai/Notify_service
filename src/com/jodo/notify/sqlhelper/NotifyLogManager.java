/**
 * @(#)Jodo, 2014年6月19日
 */
package com.jodo.notify.sqlhelper;

import org.apache.log4j.Logger;

/**
 * @author zhangsuiwen
 */
public class NotifyLogManager {

    private static final Logger LOGGER = Logger
            .getLogger(NotifyLogManager.class);

    public static void log(String subject, String content) {
        LOGGER.info(String.format("\n%s\n----\n%s\n====", subject, content));
    }

}
