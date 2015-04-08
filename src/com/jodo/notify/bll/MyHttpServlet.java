/**
 * @(#)Jodo, 2014年2月18日
 */
package com.jodo.notify.bll;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.jodo.notify.util.AntiSamyUtil;
import com.jodo.notify.util.CookieUtil;



/**
 * @author treemanz
 */
public abstract class MyHttpServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected Short getShortValue(HttpServletRequest req, String key,
            Short defaultValue) {
        String incomeValue = req.getParameter(key);
        if (StringUtils.isNotBlank(incomeValue)) {
            try {
                return Short.parseShort(incomeValue);
            } catch (NumberFormatException e) {
            }
        }
        return defaultValue;
    }
    
    protected Integer getIntValue(HttpServletRequest req, String key,
            Integer defaultValue) {
        String incomeValue = req.getParameter(key);
        if (StringUtils.isNotBlank(incomeValue)) {
            try {
                return Integer.parseInt(incomeValue);
            } catch (NumberFormatException e) {}
        }
        return defaultValue;
    }

    protected String getStringValuenoclean(HttpServletRequest req, String key,
            String defaultValue) {
        String incomeValue = req.getParameter(key);
        if ((StringUtils.isNotBlank(incomeValue)) &&(!incomeValue.equals("null")) && (incomeValue != null)) {
            try {
                return incomeValue;
            } catch (NumberFormatException e) {}
        }
        return defaultValue;
    }
    
    protected String getStringValue(HttpServletRequest req, String key,
            String defaultValue) {
        String incomeValue = req.getParameter(key);
        return StringUtils.isNotBlank(incomeValue) ? AntiSamyUtil
                .getCleanValue(incomeValue) : defaultValue;
    }

    protected static String getStringValueFromCookie(HttpServletRequest req,
            String key, String defaultValue) {
        Cookie cookie = CookieUtil.getCookie(req, key);
        String incomeValue = null == cookie ? null : cookie.getValue();
        return StringUtils.isNotBlank(incomeValue) ? AntiSamyUtil
                .getCleanValue(incomeValue) : defaultValue;
    }
    
    protected Boolean getBooleanValue(HttpServletRequest req, String key,
            Boolean defaultValue) {
        String incomeValue = req.getParameter(key);
        if (StringUtils.isBlank(incomeValue)) {
            return defaultValue;
        }
        return "true".equalsIgnoreCase(incomeValue);
    }

    protected void forward2ErrorPage(HttpServletRequest req,
            HttpServletResponse resp, String errMsg) throws Exception {
        req.setAttribute("msg", errMsg);
        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/error.jsp")
                .forward(req, resp);
    }

}
