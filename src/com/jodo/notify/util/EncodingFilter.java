/**
 * @(#)Jodo, 2014年1月16日
 */
package com.jodo.notify.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;



/**
 *
 * @author treemanz
 *
 */
public class EncodingFilter implements Filter {

    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {

    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain filterChain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String X_Forwarded_For = httpServletRequest.getHeader("X-Forwarded-For");
        String ip = null;
        if (null == X_Forwarded_For) {
            ip = "127.0.0.1";
            X_Forwarded_For = ip;
        }
        if (X_Forwarded_For.contains(",")) {
            ip = X_Forwarded_For.split(",")[0];
        } else {
            ip = X_Forwarded_For;
        }
        if (!IpUtil.isValidIp(ip)) {
            ApplicationHelper.getInstance(EncodingFilter.class).error("ip is not valid, ip=" + ip + ", ips=" + X_Forwarded_For);
            ip = "127.0.0.1";
        }
        req.setAttribute("_ip_", ip);
        filterChain.doFilter(req, res);
    }
    
    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
