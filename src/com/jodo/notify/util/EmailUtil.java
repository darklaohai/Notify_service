/**
 * @(#)Jodo, 2014年2月20日
 */
package com.jodo.notify.util;

import java.util.regex.Pattern;

/**
 * @author treemanz
 */
public class EmailUtil {

    private static final Pattern EMAIL = Pattern
            .compile("^([\\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$");

    public static boolean checkValid(String email) {
        if (null == email) {
            return false;
        }
        return EMAIL.matcher(email).matches();
    }

    /**
     * 隱藏部份字符
     * 
     * @param email e.g. 123456@qq.com
     * @return 隱藏首2和最后一個字符 12***6@qq.com 
     * 
     * */
    public static String encropytEmail(String email) {
        int index = email.indexOf("@");
        if(index < 0) {
            return email;
        }
        String name = email.substring(0, index);
        if(name.length() < 3) {
            return email;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(name.substring(0, 2));
        for ( int i=0; i<name.length() - 3; i++) {
            sb.append("*");
        }
        sb.append(name.substring(name.length()- 1, name.length()));
        sb.append(email.substring(index));
        return sb.toString();
    }
}
