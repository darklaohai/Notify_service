/**
 * @(#)Jodo, 2014年4月9日
 */
package com.jodo.notify.bll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jodo.notify.util.ApplicationHelper;


/**
 * @author treemanz
 */
public class LogServlet extends MyHttpServlet {

    private static final ApplicationHelper applicationHelper = ApplicationHelper
            .getInstance(LogServlet.class);

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

      
    }

}
