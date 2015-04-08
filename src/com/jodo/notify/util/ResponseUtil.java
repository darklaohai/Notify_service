/**
 * @(#)ResponseUtil.java, 2011-2-16. Copyright 2011 Jodo, Inc. All rights
 *                        reserved. JODO PROPRIETARY/CONFIDENTIAL. Use is
 *                        subject to license terms.
 */
package com.jodo.notify.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.jodo.notify.util.JacksonUtil;



/**
 * @author treemanz
 */
public class ResponseUtil {
    public static final String DEFAULT_CHARSET = "UTF-8";

    public static void setNoCache(HttpServletResponse response) {
        response.addHeader("pragma", "NO-cache");
        response.addHeader("Cache-Control", "no-cache");
        response.addDateHeader("Expries", 0);
    }

    public static void writeText(HttpServletResponse response, String text)
            throws IOException {
        response.setContentType("text/plain; charset=" + DEFAULT_CHARSET);
        setNoCache(response);
        response.getWriter().write(text);
        response.getWriter().close();
    }
    
    public static void writeJson(HttpServletResponse response, Object obj)
            throws IOException {
        response.setContentType("application/json; charset=" + DEFAULT_CHARSET);
        setNoCache(response);
        response.getWriter().write(JacksonUtil.toJson(obj));
        response.getWriter().close();
    }
}
