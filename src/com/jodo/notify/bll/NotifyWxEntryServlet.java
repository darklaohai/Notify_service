/**
 * @(#)Jodo, 2014年3月18日
 */
package com.jodo.notify.bll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jodo.notify.model.JsonTextMsgModel;
import com.jodo.notify.model.JsonWxMsgModel;
import com.jodo.notify.util.ReqParamUtil;
import com.jodo.notify.util.ResponseUtil;
import com.jodo.notify.util.SHA1EncryptUtil;



/**
 * @author treemanz
 */
public class NotifyWxEntryServlet extends MyHttpServlet {

    /**
	 * 
	 */
	public static final String WEIXIN_TOKEN = "nimazheshitianxiama174";
	 
    private static final long serialVersionUID = 1L;

    private boolean checkWeixinSignature(String signature, String timestamp,
            String nonce) {
        StringBuilder sb =	 new StringBuilder();

        // 将token、timestamp、nonce三个参数进行字典序排序
        if (WEIXIN_TOKEN.compareTo(timestamp) < 0) {
            if (WEIXIN_TOKEN.compareTo(nonce) < 0) {
                if (timestamp.compareTo(nonce) < 0) {
                    sb.append(WEIXIN_TOKEN).append(timestamp)
                            .append(nonce);
                } else {
                    sb.append(WEIXIN_TOKEN).append(nonce)
                            .append(timestamp);
                }
            } else {
                sb.append(nonce).append(WEIXIN_TOKEN)
                        .append(timestamp);
            }
        } else {
            if (timestamp.compareTo(nonce) < 0) {
                if (WEIXIN_TOKEN.compareTo(nonce) < 0) {
                    sb.append(timestamp).append(WEIXIN_TOKEN)
                            .append(nonce);
                } else {
                    sb.append(timestamp).append(nonce)
                            .append(WEIXIN_TOKEN);
                }
            } else {
                sb.append(nonce).append(timestamp)
                        .append(WEIXIN_TOKEN);
            }
        }

        String sha1 = SHA1EncryptUtil.instance.encrypt(sb.toString());
        return sha1.equals(signature);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String signature = getStringValue(req, "signature", null);
        String timestamp = getStringValue(req, "timestamp", null);
        String nonce = getStringValue(req, "nonce", null);
        String echostr = getStringValue(req, "echostr", null);

        if (null == signature || null == timestamp || null == nonce
                || null == echostr) {
            resp.setStatus(400);
            resp.getWriter().append("param error");
            resp.getWriter().close();
            return;
        }

        int result;

        try {
            result = checkWeixinSignature(signature, timestamp, nonce) ? 1 : 0;
            if (1 == result) {
                resp.getWriter().append(echostr);
                resp.getWriter().close();
            } else {
                resp.setStatus(201);
                resp.getWriter().append("auth failed");
                resp.getWriter().close();
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
            resp.setStatus(500);
            resp.getWriter().append("error");
            resp.getWriter().close();
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	doGet(req, resp);
       

    }

    public void responseWithTextMsg(HttpServletResponse resp, JsonWxMsgModel srcMsg,
            String content) throws IOException {

    }

}
