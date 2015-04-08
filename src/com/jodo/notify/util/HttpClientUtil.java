/**
 * @(#)Jodo, 2013年10月11日
 */
package com.jodo.notify.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

/**
 * @author treemanz
 */
@SuppressWarnings("deprecation")
public class HttpClientUtil {

    private static HttpClient __instance = null;

    static {
        try {
            TrustManager easyTrustManager = new X509TrustManager() {

                @Override
                public void checkClientTrusted(X509Certificate[] chain,
                        String authType) throws CertificateException {
                    // Oh, I am easy!
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain,
                        String authType) throws CertificateException {
                    // Oh, I am easy!
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };

            SchemeRegistry registry = new SchemeRegistry();// 創建schema

            SSLContext sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(null, new TrustManager[] {
                easyTrustManager
            }, null);

            SSLSocketFactory sslFactory = new SSLSocketFactory(sslcontext,
                    SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            registry.register(new Scheme("http", 80, PlainSocketFactory
                    .getSocketFactory()));// http 80 端口
            registry.register(new Scheme("https", 443, sslFactory));// https
                                                                    // 443端口

            PoolingClientConnectionManager cm = new PoolingClientConnectionManager(
                    registry);// 創建connectionManager

            cm.setDefaultMaxPerRoute(20);// 對每個指定連接的服務器（指定的ip）可以創建並發20
                                         // socket進行訪問
            cm.setMaxTotal(200);// 創建socket的上線是200

            __instance = new DefaultHttpClient(cm);

            HttpParams params = __instance.getParams();
            HttpConnectionParams.setSoTimeout(params, 20 * 1000);// 設定連接等待時間
            HttpConnectionParams.setConnectionTimeout(params, 20 * 1000);// 設定超時時間

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HttpClient getHttpClient() {
        return __instance;
    }
    
    public static String readResultAsString(HttpResponse httpResponse)
            throws IllegalStateException, IOException {
        // InputStream is = httpResponse.getEntity().getContent();
        // try {
        // byte[] buffer = new byte[1024];
        // ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // int len;
        // while ((len = is.read(buffer)) > -1) {
        // baos.write(buffer, 0, len);
        // }
        // return new String(baos.toByteArray(), "utf-8");
        // } finally {
        // if (null != is) {
        // is.close();
        // }
        // }
        return EntityUtils.toString(httpResponse.getEntity(),
                Charset.forName("utf-8"));
    }

}
