package com.jodo.notify.bll;


import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jodo.appif.common.IService;
import com.jodo.notify.util.UrlUtil;



public class NotifyAdminLoginServlet extends MyHttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlt = req.getParameter("verify");
        if (null == urlt || urlt.equals("")) {
            this.getServletContext()
            .getRequestDispatcher("/WEB-INF/jsps/login/login.jsp")
            .forward(req, resp);
            return;
        }
        Boolean verified = (Boolean) req.getSession()
                .getAttribute("_verified_");
        if (null != verified && verified) {
            resp.sendRedirect(urlt);
        }
        req.setAttribute("t", urlt);
        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/login/login.jsp")
                .forward(req, resp);
    }
	

	
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = req.getParameter("username");
        String t = req.getParameter("t");
        String p = req.getParameter("password");
        if (null == a || null==p) {         
            redirectToSelf(req, resp, t);
            return;
        }
        if (!a.equals("admin")) {
            redirectToSelf(req, resp, t);
            return;
        }
        if (!p.equals("admin")) {
            redirectToSelf(req, resp, t);
            return;
        }
        if(null == t || t.equals("")){
        	t=UrlUtil.getBasePath(req)+"/notifyadmin?page=index";
        }
        req.getSession().setAttribute("_verified_", true);
        resp.sendRedirect(t);
    }
    
    private void redirectToSelf(HttpServletRequest request,
            HttpServletResponse response, String t) throws IOException {
        String loginUrl = UrlUtil.getBasePath(request) + "/login?verify="
                + URLEncoder.encode(t, "utf-8");
        response.sendRedirect(loginUrl);	
        return;
    }
}
