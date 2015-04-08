/**
 * @(#)Jodo, 2013年11月26日
 */
package com.jodo.notify.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.jodo.notify.util.ApplicationHelper;
import com.jodo.notify.util.HttpClientUtil;
import com.jodo.notify.util.JacksonUtil;






/**
 * @author treemanz
 */
public class NotifySmsDao {
    
	
	private static final ApplicationHelper APPLICATION_HELPER = ApplicationHelper.getInstance(NotifySmsDao.class);
	
	//1.查账户信息 : URL：http://yunpian.com/v1/user/get.json 
    public static String checkAccountinfo(String apikey) {
        String url = String
                .format("http://yunpian.com/v1/user/get.json"); 
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("apikey",apikey));
        String result =postUrl(nvps, url, "checkAccountinfo");
        return result;
    }
   

    //2.修改账户信息 : URL：http://yunpian.com/v1/user/set.json 
    public static String updateAccountinfo(String apikey,String emergency_contact,String emergency_mobile,String alarm_balance) {
        String url = String
                .format("http://yunpian.com/v1/user/set.json");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("apikey",apikey));
        nvps.add(new BasicNameValuePair("emergency_contact",emergency_contact));
        nvps.add(new BasicNameValuePair("emergency_mobile",emergency_mobile));
        nvps.add(new BasicNameValuePair("alarm_balance",alarm_balance));
        String result =postUrl(nvps, url, "updateAccountinfo");
        return result;
    }
    
    //3.取默认模板 URL：http://yunpian.com/v1/tpl/get_default.json
    public static String getdefaultTemplate(String apikey,String tpl_id) {
        String url = String
                .format("http://yunpian.com/v1/tpl/get_default.json");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("apikey",apikey));
        nvps.add(new BasicNameValuePair("apikey",tpl_id));
        String result =postUrl(nvps, url, "getdefaultTemplate");
        return result;
    }
    
    //4.添加模板 URL：URL：http://yunpian.com/v1/tpl/add.json 
    public static String addTemplate(String apikey,String tpl_content,String notify_type) {
        String url = String
                .format("http://yunpian.com/v1/user/add.json");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("apikey",apikey));
        nvps.add(new BasicNameValuePair("apikey",tpl_content));
        nvps.add(new BasicNameValuePair("apikey",notify_type));
        String result =postUrl(nvps, url, "addTemplate");
        return result;
    }
    
    //5.取模板 URL：URL：http://yunpian.com/v1/tpl/set.json
    public static String getTemplate(String apikey,String tpl_id) {
        String url = String
                .format("http://yunpian.com/v1/user/set.json");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("apikey",apikey));
        nvps.add(new BasicNameValuePair("tpl_id",tpl_id));
        String result =postUrl(nvps, url, "getTemplate");
        return result;
    }
    
    //6.修改模板 URL：URL：http://yunpian.com/v1/tpl/update.json
    public static String updateTemplate(String apikey,String tpl_id,String tpl_content) {
        String url = String
                .format("http://yunpian.com/v1/tpl/update.json");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("apikey",apikey));
        nvps.add(new BasicNameValuePair("tpl_id",tpl_id));
        nvps.add(new BasicNameValuePair("tpl_content",tpl_content));
        String result =postUrl(nvps, url, "updateTemplate");
        return result;
    }
    
    //7.删除模板 URL：http://yunpian.com/v1/tpl/del.json  
    public static String deleteTemplate(String apikey,String tpl_id) {
        String url = String
                .format("http://yunpian.com/v1/tpl/del.json");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("apikey",apikey));
        nvps.add(new BasicNameValuePair("tpl_id",tpl_id));
        String result =postUrl(nvps, url, "deleteTemplate");
        return result;
    }
    
    //8.发短信（通用接口） URL：http://yunpian.com/v1/sms/send.json 
   /* public static String sendSms(String apikey,String mobile,String text,String extend,String uid) {*/
    public static String sendSms(String apikey,String mobile,String text) {
        String url = String
                .format("http://yunpian.com/v1/sms/send.json");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("apikey",apikey));
        nvps.add(new BasicNameValuePair("mobile",mobile));
        text=text.replace(".<br>", "!");
        text=text.replace(".<br />", "!");
        System.out.println(text);
        nvps.add(new BasicNameValuePair("text",text));
        String result =postUrl(nvps, url, "sendSms");
        return result;
    }
    //9.短信模板发送（模板接口） URL：http://yunpian.com/v1/sms/tpl_send.json 
    public static String sendTplSms(String apikey,String mobile,String tpl_value,String extend,String uid) {
        String url = String
                .format("http://yunpian.com/v1/sms/tpl_send.json");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("apikey",apikey));
        nvps.add(new BasicNameValuePair("mobile",mobile));
        nvps.add(new BasicNameValuePair("tpl_value",tpl_value));
        nvps.add(new BasicNameValuePair("extend",extend));
        nvps.add(new BasicNameValuePair("uid",uid));
        String result =postUrl(nvps, url, "sendTplSms");
        return result;
    }
    //10.短信获取状态报告 URL：http://yunpian.com/v1/sms/pull_status.json 
    public static String pullStatus(String apikey,String page_size) {
        String url = String
                .format("http://yunpian.com/v1/sms/pull_status.json");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("apikey",apikey));
        nvps.add(new BasicNameValuePair("page_size",page_size));
        String result =postUrl(nvps, url, "pullStatus");
        return result;
    }
    //11.获取回复短信 URL：http://yunpian.com/v1/sms/pull_reply.json
    public static String pullReply(String apikey,String page_size) {
        String url = String
                .format("http://yunpian.com/v1/sms/pull_reply.json");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("apikey",apikey));
        nvps.add(new BasicNameValuePair("page_size",page_size));
        String result =postUrl(nvps, url, "pullReply");
        return result;
    }
    
    //12.推送状态报告
    
    //13.推送回复短信
    
    //14.查屏蔽词 URL：http://yunpian.com/v1/sms/get_black_word.json 
    public static String getBlackword(String apikey,String text) {
        String url = String
                .format("http://yunpian.com/v1/sms/get_black_word.json",
                		apikey,text);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("apikey",apikey));
        nvps.add(new BasicNameValuePair("text",text));
        String result =postUrl(nvps, url, "checkAccountinfo");
        return result;
    }
    //15.查回复的短信 URL：http://yunpian.com/v1/sms/get_reply.json 
    public static String getReply(String apikey,String start_time,String end_time,String page_num,String page_size,String mobile,String return_fields,String sort_fields) {
        String url = String
                .format("http://yunpian.com/v1/sms/get_reply.json");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("apikey",apikey));
        nvps.add(new BasicNameValuePair("start_time",start_time));
        nvps.add(new BasicNameValuePair("end_time",end_time));
        nvps.add(new BasicNameValuePair("page_num",page_num));
        nvps.add(new BasicNameValuePair("page_size",page_size));
        nvps.add(new BasicNameValuePair("mobile",mobile));
        nvps.add(new BasicNameValuePair("return_fields",return_fields));
        nvps.add(new BasicNameValuePair("sort_fields",sort_fields));
        String result =postUrl(nvps, url, "checkAccountinfo");
        return result;
    }
       
    public static String postUrl(List<NameValuePair> nvps,String url,String opt) {

        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
        
        try {
            HttpResponse httpResponse = HttpClientUtil.getHttpClient().execute(
                    httpPost);
            int code = httpResponse.getStatusLine().getStatusCode();
            if (200 == code) {
                String result = HttpClientUtil.readResultAsString(httpResponse);
                ApplicationHelper.getInstance(NotifySmsDao.class).info(
                        String.format("opt:%s,code:%s,result:%s",
                                opt,code, result));
                return result;
            } else {
            	APPLICATION_HELPER.info(
                        String.format("opt:%s,code:%s", opt,code));
                return null;
            }
        } catch (Exception e) {
        	APPLICATION_HELPER.error(
                    String.format("opt:%s,errmsg:%s",
                            opt,e.getMessage()), e);
            return null;
        } finally {
            httpPost.releaseConnection();

        } 
        
    }
         
    public static void main(String[] args) {
    	
/*    	String test = "三国無双传:在台湾;googleplay;Top下线了.<br>";
    	test=test.replaceAll(".<br>", "!");
    	test="【下线监控】"+test;
    	System.out.println(test);
    	String apikey="2ec7a1c6957ac441e540f35983b4483b";
    	String result = checkAccountinfo("2ec7a1c6957ac441e540f35983b4483b1");
		//System.out.println(result);
		result = getdefaultTemplate(apikey, "1");
		System.out.println(result);
		
		Map<String,Object> jsond = JacksonUtil.toJava(result, Map.class);
		System.out.println(jsond.get("msg"));
    result = getdefaultTemplate("2ec7a1c6957ac441e540f35983b4483b", "1");
		System.out.println(result);*/
		
		//发短信调用示例  
		System.out.println(sendSms("2ec7a1c6957ac441e540f35983b4483b", "13662419500","【下线监控】真仙奇缘:在新加坡;googleplay;Top new下线了.<br />" ));
	}
	
}
