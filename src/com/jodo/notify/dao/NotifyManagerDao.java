package com.jodo.notify.dao;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.jodo.notify.model.AdminSimpleLoggerModel;
import com.jodo.notify.model.AdminSimpleProductModel;
import com.jodo.notify.model.NameValueModel;
import com.jodo.notify.sqlhelper.DbManager;
import com.jodo.notify.sqlhelper.LDAPManager;
import com.jodo.notify.util.DateUtil;



public class NotifyManagerDao {


    public static final NotifyManagerDao instance = new NotifyManagerDao();
    
    private NotifyManagerDao() {

    }
    
    private static final String SELECT_SECEVIERS = "select f.userid name,e.methodlabel value from (select c.methodlabel,d.uid from (select a.methodlabel,b.groupid from (select productid,methodlabel from simple_product where product=? and tag=? and minlevel<=?)a join group_product_rs b on a.productid=b.productid)c join group_user_rs d on c.groupid=d.groupid)e join simple_user f on e.uid=f.uid ";		
	private static final String SELECT_PLATFORM_NOT_MAIL = "select userid,useraccount from notice_user where methodlabel=? ";
    private static final String SELECT_PLATFORM = "select uid,mail from dc=biee,dc=zd ";
	private static final String SELECT_NOTICE_USER = "select username name,password value from simple_notice_platform where methodlabel=? ";
	
	private static final String SIMPLE_PRODUCT_A_PRODUCT = "select * from simple_product where product=?  and minlevel<=? ";
	
	private static final String SIMPLE_LOGGER_COUNT_LOGGER = "select * from simple_logger where product=? and methodlabel=? order by time desc limit 1";
    
	private static final String SIMPLE_LOGGER_INSERT = "insert into simple_logger (product,methodlabel,title,content,time,count) values (?,?,?,?,?,?)";
	  
	
    public static final List<NameValueModel> getSeceviers(String product,String tag,String level) {
		return DbManager.getInstnace().executeQuery_ObjcetList(SELECT_SECEVIERS, new Object[]{product, tag, level},NameValueModel.builder);
    }
    public static final Map<String, String> getuserEntry(String platform ) {
    	if(platform.equals("mail")){
    		return LDAPManager.getInstnace().executeQuery_twoList(SELECT_PLATFORM, null,"uid","mail");
    	}else{
    		return DbManager.getInstnace().executeQuery_twoList(SELECT_PLATFORM_NOT_MAIL, new Object[]{platform},"userid","useraccount");
    	}	
    }
    public static final List<NameValueModel> getplatformEntry(String platform ) {
		return DbManager.getInstnace().executeQuery_ObjcetList(SELECT_NOTICE_USER, new Object[]{platform},NameValueModel.builder);
		
    }

    public static final List<AdminSimpleProductModel> Simpleproduct_a_product(String product,String minlevel) {
		return DbManager.getInstnace().executeQuery_ObjcetList(SIMPLE_PRODUCT_A_PRODUCT, new Object[]{product,minlevel}, AdminSimpleProductModel.builder);
	}
    
    public static final int Simplelogger_count(String product,String methodlabel) {
    	if(DbManager.getInstnace().executeQuery_ObjcetList(SIMPLE_LOGGER_COUNT_LOGGER, new Object[]{product,methodlabel},AdminSimpleLoggerModel.builder).size()==0){
    		return 0;
    	}else {
    		int count =  DbManager.getInstnace().executeQuery_ObjcetList(SIMPLE_LOGGER_COUNT_LOGGER, new Object[]{product,methodlabel},AdminSimpleLoggerModel.builder).get(0).getCount() ;
    		return count;
    	}
    }
    
    public static final int Simplelogger_insert(String product,String methodlabel,String title,String content,int count) {
    	String time = DateUtil.formatYMDHMS(new Date());
		return DbManager.getInstnace().executeCommand(SIMPLE_LOGGER_INSERT, new Object[]{product,methodlabel,title,content,time,count});
	}
    
    
    public static void main(String[] args) {
		Map<String, String> eecMap = getuserEntry("mail");	
		for (Entry<String, String> dddmapEntry :eecMap.entrySet()) {
			System.out.println(dddmapEntry.getKey());
		}
 	}

}
