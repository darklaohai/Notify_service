/**
 * @(#)Jodo, 2013-5-2
 */
package com.jodo.notify.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Treeman
 */
public class UrlUtil {

    public static String getBasePath(HttpServletRequest req) {
        String path = req.getContextPath().replaceAll("/$", "");
        String basePath = req.getScheme() + "://" + req.getServerName()
                + (req.getServerPort() != 80 ? ":" + req.getServerPort() : "")
                + path;
        return basePath;
    }

    public static String getSubPath(HttpServletRequest req) {
        return req.getServletPath();
    }

    public static String getFullPath(HttpServletRequest req) {
        return getBasePath(req) + getSubPath(req);
    }

    public static String getHost(HttpServletRequest req) {
        String basePath = getBasePath(req);
        String host = "";
        if (basePath.contains("1fpay.com")) {
            host = ".1fPay.com";
        } else if (basePath.contains("pay.getapk.cn")) {
            host = ".pay.getapk.cn";
        } else if (basePath.contains("payapi2.getapk.cn")) {
            host = ".payapi2.getapk.cn";
        } else if (basePath.contains("tttest-1.getapk.cn")) {
            host = ".tttest-1.getapk.cn";
        } else if (basePath.contains("tttest-2.getapk.cn")) {
            host = ".tttest-2.getapk.cn";
        } else if (basePath.contains("tttest-3.getapk.cn")) {
            host = ".tttest-3.getapk.cn";
        } else if (basePath.contains("locatest.com")) {
            host = ".localtest.com";
        }
        return host;
    }

    public static String getCdnPrefix(HttpServletRequest req) {
        String basePath = getBasePath(req);
        return basePath;
//        String prefix = "";
//        if (basePath.contains("1fpay.com")) {
//            prefix = "http://did5tobbkhneg.cloudfront.net";
//        } else {
//            prefix = basePath;
//        }
//        return prefix;
    }

    /**dilian CDN*/
    public static String getCdn2Prefix(HttpServletRequest req) {
        String basePath = getBasePath(req);
      String prefix = "";
      if (basePath.contains("1fpay.com")) {
          prefix = "http://dl.jodoplay.com/file";
      } else {
          prefix = basePath;
      }
      return prefix;
    }
}
