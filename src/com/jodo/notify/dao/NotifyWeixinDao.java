/**
 * @(#)Jodo, 2013年11月26日
 */
package com.jodo.notify.dao;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import com.jodo.notify.model.JsonWxMsgModel;
import com.jodo.notify.util.ApplicationHelper;
import com.jodo.notify.util.HttpClientUtil;
import com.jodo.notify.util.JacksonUtil;



/**
 * @author treemanz
 */
public class NotifyWeixinDao {
    
	private static final ApplicationHelper APPLICATION_HELPER = ApplicationHelper.getInstance(NotifyWeixinDao.class);

    private static ReadWriteLock accessTokenCacheLock = new ReentrantReadWriteLock();

    private static String getAccessTokenFromCache(String wxUserid) {
        accessTokenCacheLock.readLock().lock();
        AccessTokenConfig accessToken = new  AccessTokenConfig(null, null);
        try {
            if (null != accessToken.accessTokenCache
                    && System.currentTimeMillis() - accessToken.accessTokenCacheTime < 7000000L) {
                return accessToken.accessTokenCache;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            accessTokenCacheLock.readLock().unlock();
        }
        return null;
    }

    private static void setAccessTokenToCache(String account,String password, String accessToken) {
        AccessTokenConfig tokenConfig = new AccessTokenConfig(account, password);
        tokenConfig.accessTokenCache = accessToken;
        tokenConfig.accessTokenCacheTime = System.currentTimeMillis();
    }

    protected static class AccessTokenResult {
        private String access_token;

        private Integer expires_in;

        /**
         * @return the access_token
         */
        public String getAccess_token() {
            return access_token;
        }

        /**
         * @param access_token
         *            the access_token to set
         */
        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        /**
         * @return the expires_in
         */
        public Integer getExpires_in() {
            return expires_in;
        }

        /**
         * @param expires_in
         *            the expires_in to set
         */
        public void setExpires_in(Integer expires_in) {
            this.expires_in = expires_in;
        }
    }

    public static String getAccessToken(String wxUserid,String account,String psw) {
        String accessToken = getAccessTokenFromCache(wxUserid);
        if (null != accessToken) {
            return accessToken;
        }
        accessTokenCacheLock.writeLock().lock();
        AccessTokenConfig tokenConfig = new AccessTokenConfig(account,psw);
        String url = String
                .format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",
                        tokenConfig.APP_ID, tokenConfig.APP_SECRET);
        HttpPost httpPost = new HttpPost(url);
        try {
            HttpResponse httpResponse = HttpClientUtil.getHttpClient().execute(
                    httpPost);
            int code = httpResponse.getStatusLine().getStatusCode();
            if (200 == code) {
                String result = HttpClientUtil.readResultAsString(httpResponse);
                ApplicationHelper.getInstance(NotifyWeixinDao.class).info(
                        String.format("opt:getAccessToken,code:%s,result:%s",
                                code, result));
                AccessTokenResult accessTokenResult = JacksonUtil.toJava(
                        result, AccessTokenResult.class);
                accessToken = accessTokenResult.getAccess_token();
                setAccessTokenToCache(account,psw,accessToken);
                return accessToken;
            } else {
                ApplicationHelper.getInstance(NotifyWeixinDao.class).info(
                        String.format("opt:getAccessToken,code:%s", code));
                return null;
            }
        } catch (Exception e) {
            ApplicationHelper.getInstance(NotifyWeixinDao.class).error(
                    String.format("opt:getAccessToken,errmsg:%s",
                            e.getMessage()), e);
            return null;
        } finally {
            httpPost.releaseConnection();
            accessTokenCacheLock.writeLock().unlock();
        }
    }
    
    static class AccessTokenConfig {
        
        String APP_ID;
        String APP_SECRET;
        volatile String accessTokenCache = null;
        volatile long accessTokenCacheTime = -1L;
        
        public AccessTokenConfig(String aPP_ID, String aPP_SECRET) {
            APP_ID = aPP_ID;
            APP_SECRET = aPP_SECRET;
        }
    }
    
    
    public static boolean sendWeixin(JsonWxMsgModel msg,String account,String pwd) {
        String accessToken = NotifyWeixinDao.getAccessToken(msg.getFromUserName(),account,pwd);
        if (null == accessToken) {
            throw new RuntimeException("accessToken is null");
        }
        String url = String
                .format("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%s",
                        accessToken);
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = null;
        String json = msg.toJson();
        entity = new StringEntity(json, "UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        try {
            HttpResponse httpResponse = HttpClientUtil.getHttpClient().execute(
                    httpPost);
            int code = httpResponse.getStatusLine().getStatusCode();
            EntityUtils.consume(entity);
            boolean result = 200 == code;
            ApplicationHelper.getInstance(NotifyWeixinDao.class).debug(
                    String.format("opt:sendMsg,json:%s,result:%s,", json,
                            result));
            return result;
        } catch (Exception e) {
            ApplicationHelper.getInstance(NotifyWeixinDao.class).error(
                    String.format("opt:sendMsg,json:%s,errmsg:%s", json,
                            e.getMessage()), e);
            return false;
        } finally {
            httpPost.releaseConnection();
        }
    }
}
