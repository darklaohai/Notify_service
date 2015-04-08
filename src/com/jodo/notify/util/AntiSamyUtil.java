/**
 * @(#)Jodo, 2014年2月20日
 */
package com.jodo.notify.util;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.PolicyException;

import com.jodo.notify.sqlhelper.ConfigManager;



/**
 * @author treemanz
 */
public final class AntiSamyUtil {

    private static Policy policy;

    public static final void init() throws PolicyException {
        String POLICY_FILE_LOCATION = "antisamy-ebay-1.4.4.xml";
        policy = Policy.getInstance(getConfigPath(POLICY_FILE_LOCATION));
    }

    public static final String getCleanValue(String raw) {
        if (null == raw) {
            return null;
        }
        try {
            AntiSamy as = new AntiSamy();
            CleanResults cr = as.scan(raw, policy, AntiSamy.SAX);
            return cr.getCleanHTML();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getConfigPath(String fileName) {
        String path = ConfigManager.class.getResource("/").getPath();
        path = path.replace("classes", "conf");
        return path + fileName;
    }

    public static void main(String[] args) throws PolicyException {
        init();
        System.out.println(getCleanValue("sw.zh@qq.com"));
    }

}
