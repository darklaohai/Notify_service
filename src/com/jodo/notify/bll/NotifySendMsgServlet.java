package com.jodo.notify.bll;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jodo.notify.dal.NotifyManagerDal;



public class NotifySendMsgServlet extends MyHttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = getStringValue(req, "title", null);
        String content = getStringValue(req, "content", null);
        String userid = getStringValue(req, "userid", null);
        String platform = getStringValue(req, "platform", null);
        String product = getStringValue(req, "product", null);
        String tag  = getStringValue(req, "tag", null);
        String level = getStringValue(req, "level", null);
        
        if (null == title || null == content ) {
            resp.setStatus(400);
            resp.getWriter().append("param error");
            resp.getWriter().close();
            return;
        }      
        if ((null == platform || null == userid ) && (null == product || null == tag )){
            resp.setStatus(400);
            resp.getWriter().append("param error");
            resp.getWriter().close();
            return;
        }
        try { 
            if (NotifyManagerDal.instance.notifySend(title, content, userid, platform, product, tag, level)) {
                resp.getWriter().append("send msg success");
                resp.getWriter().close();
            } else {
                resp.setStatus(201);
                resp.getWriter().append("send msg failed");
                resp.getWriter().close();
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
            resp.getWriter().append("system error");
            resp.getWriter().close();
            return;
        }		
    }
	
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doGet(req, resp);
    }
}
