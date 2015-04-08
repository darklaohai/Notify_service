/**
 * @(#)Jodo, 2014年1月23日
 */
package com.jodo.notify.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	

/**
 * @author treemanz
 */
public class AdminFilter implements Filter {

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {

    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String fullUrl = UrlUtil.getFullPath(request);
/*        if (!fullUrl.startsWith("http://localhost")) {
            return;
        }*/
        Boolean verified = (Boolean) request.getSession().getAttribute(
                "_verified_");
        if (null == verified || !verified) {
            String url = UrlUtil.getFullPath(request);

            // 把原來的參數填回去
            int count = 0;
            for (Enumeration<String> enumeration = request.getParameterNames(); enumeration
                    .hasMoreElements();) {
                String name = enumeration.nextElement();
                url += (count == 0 ? "?" : "&") + name + "="
                        + request.getParameter(name);
                count++;
            }

            // urlencode
            url = URLEncoder.encode(url, "utf-8");
            String loginUrl = UrlUtil.getBasePath(request)
                    + "/login?verify=" + url;
            response.sendRedirect(loginUrl);
            return;
        }

        filterChain.doFilter(req, res);
    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
