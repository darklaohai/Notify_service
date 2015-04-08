/**
 * @(#)ReqParamUtil.java, Apr 10, 2013. Copyright 2013 Netease, Inc. All rights
 *                        reserved. NETEASE PROPRIETARY/CONFIDENTIAL. Use is
 *                        subject to license terms.
 */
package com.jodo.notify.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import com.jodo.notify.model.JsonWxMsgModel;



/**
 * @author Treeman
 */
public class ReqParamUtil {

    /**
     * 解析请求body（xml类型）为Msg
     * 
     * @param req
     * @return
     */
    public static JsonWxMsgModel parseReq(HttpServletRequest req) {
        try {

            // System.out.println(req.getContentType()); // text/xml

            // 读取body
            InputStream is = req.getInputStream();
            byte[] buf = new byte[4 * 1024]; // 4 KB char buffer
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            int len;
            while ((len = is.read(buf, 0, buf.length)) != -1) {
                os.write(buf, 0, len);
            }
            String xml = os.toString("utf-8");
            System.out.println(xml);

            // 解析xml为Msg
            return JsonWxMsgModel.fromXml(xml);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
