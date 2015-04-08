package com.jodo.notify.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jodo.notify.model.AdminConfPlatformModel;
import com.jodo.notify.model.AdminConfUserModel;
import com.jodo.notify.model.AdminSimpleGroupModel;
import com.jodo.notify.model.AdminSimpleProductModel;
import com.jodo.notify.model.AdminSimpleUserModel;
import com.jodo.notify.model.AdminSynLDAPModel;
import com.jodo.notify.model.Admin_GroupProductRSModel;
import com.jodo.notify.model.Admin_GroupUserRSModel;
import com.jodo.notify.model.NameValueModel;
import com.jodo.notify.sqlhelper.DbManager;
import com.jodo.notify.sqlhelper.DbManager.DB_NAME;
import com.jodo.notify.sqlhelper.LDAPManager;
import com.jodo.notify.util.Base64Utils;

public class NotifyAdminDao {
	
    public static final NotifyAdminDao instance = new NotifyAdminDao();
    
    private NotifyAdminDao() {
    	
    }
   
    /**
     *  人员配置
     */
    private static final String SELECT_ALL_USERINFO = "select * from simple_user where userid=? ";   
    private static final String SELECT_ALL_GROUP = "select * from simple_group ";
    private static final String SELECT_ALL_PLATFORM = "select * from simple_notice_platform ";
    private static final String SELECT_ALL_CONF = "select * from notice_user where userid=? ";   
    private static final String SELECT_ALL_MSG = " select c.product,c.tag,c.methodlabel,c.minlevel,c.aggr from  (select a.*,b.groupid from   simple_product  a  join group_product_rs b  on   a.productid=b.productid) c    join   (select  aa.uid,aa.username,aa.userid,aa.usericon,bb.groupid from simple_user aa join group_user_rs bb on aa.uid=bb.uid)  d  on d.groupid=c.groupid   where d.userid=?  ";
    private static final String UPDATE_CONF = "update  notice_user set useraccount=? where userid=? and methodlabel=?";
    //1
    public static final AdminSimpleUserModel ConfUser_User(String userid) throws Throwable{
		AdminSimpleUserModel confuser_user = DbManager.getInstnace().executeScalerObject(SELECT_ALL_USERINFO, new Object[]{userid}, AdminSimpleUserModel.builder);
    	return confuser_user;
    }
    //2
    public static final List<AdminSimpleGroupModel>  ConfUser_Group(){
    	List<AdminSimpleGroupModel> confuser_group = DbManager.getInstnace().executeQuery_ObjcetList(SELECT_ALL_GROUP, new Object[]{}, AdminSimpleGroupModel.builder);
    	return confuser_group;
    }
    //3
    public static final List<AdminConfPlatformModel> Confuser_Platform(){
    	List<AdminConfPlatformModel> confuser_platform = DbManager.getInstnace().executeQuery_ObjcetList(SELECT_ALL_PLATFORM, new Object[]{}, AdminConfPlatformModel.builder);
    	return confuser_platform;
    }
    //4
    public static final List<AdminConfUserModel>  ConUser_Confuser(String userid){
    	List<AdminConfUserModel> conuser_confuser = DbManager.getInstnace().executeQuery_ObjcetList(SELECT_ALL_CONF, new Object[]{userid}, AdminConfUserModel.builder);
    	return conuser_confuser;
    }
    //5
    public static final List<AdminSimpleProductModel> Confuser_Msg(String userid){
    	List<AdminSimpleProductModel> confuser_msg = DbManager.getInstnace().executeQuery_ObjcetList(SELECT_ALL_MSG, new Object[]{userid}, AdminSimpleProductModel.builder);
    	return confuser_msg;
    }
    //6修改配置信息
    public static final void Confuser_Change(String userid,String var,String val){
    	DbManager.getInstnace().executeCommand(UPDATE_CONF, new Object[]{val,userid,var});
    }
    
    /**
     *  MYSQL-LDAP 人员同步
     */ 
    private static final String SELECT_MY_USER = " select a.userid uid, a.username sn, b.useraccount mail from  simple_user a left join (select * from notice_user where methodlabel='mail') b on a.userid=b.userid;";
    private static final String SELECT_LDAP_USER = " select uid,sn,mail from dc=biee,dc=zd ";
    
    public static final void  syn_mysql_ldap_user() throws Exception{
    	List<AdminSynLDAPModel> adminSynLDAPModels = DbManager.getInstnace().executeQuery_ObjcetList(SELECT_MY_USER, null,AdminSynLDAPModel.builder);
    	List<AdminSynLDAPModel> adminUserSynModels1 = LDAPManager.getInstnace().executeQuery_ObjcetList(SELECT_LDAP_USER, null,AdminSynLDAPModel.builder);
    	Set<String> userSet = new HashSet<String>();
    	Set<String> userSet1 = new HashSet<String>();
    	Map<String, AdminSynLDAPModel> adminuserMap = new HashMap<String, AdminSynLDAPModel>();
    	Map<String, AdminSynLDAPModel> adminuserMap1 = new HashMap<String, AdminSynLDAPModel>();
    	for (int i = 0; i < adminSynLDAPModels.size(); i++) {
    		if(adminSynLDAPModels.get(i).getUid().isEmpty()){
    			continue;
    		}
    		System.out.println("mysq1:"+adminSynLDAPModels.get(i).getUid());
    		userSet.add(adminSynLDAPModels.get(i).getUid());
    		adminuserMap.put(adminSynLDAPModels.get(i).getUid(),adminSynLDAPModels.get(i));
		}
    	for (int i = 0; i < adminUserSynModels1.size(); i++) {
    		if(adminUserSynModels1.get(i).getUid().isEmpty()){
    			continue;
    		}
    		System.out.println("ldap:"+adminUserSynModels1.get(i).getUid());
    		userSet1.add(adminUserSynModels1.get(i).getUid());
    		adminuserMap1.put(adminUserSynModels1.get(i).getUid(),adminUserSynModels1.get(i));
    	}
    	Set<String> tmp = new HashSet<String>(userSet);
    	Set<String> tmp1 = new HashSet<String>(userSet1);
    	//差集；
    	tmp1.removeAll(userSet);
    	for (String tmpString:tmp1 ) {
    		if(tmpString.isEmpty()){
    			continue;
    		}
    		System.out.println("1:"+tmpString);
    		DbManager.getInstnace().executeCommand("insert into simple_user (userid,username) values (?,?)", new Object[]{adminuserMap1.get(tmpString).getUid(),Base64Utils.decode(adminuserMap1.get(tmpString).getSn())});
    		DbManager.getInstnace().executeCommand("replace into notice_user (methodlabel,userid,useraccount) values ('mail',?,?)", new Object[]{adminuserMap1.get(tmpString).getUid(),adminuserMap1.get(tmpString).getMail()});
    	}
    	//差集；
    	tmp.removeAll(userSet1);
    	for (String tmpString:tmp ) {
    		if(tmpString.isEmpty()){
    			continue;
    		}
    		System.out.println("2:"+tmpString);
    		DbManager.getInstnace().executeCommand("delete form simple_user where  userid=? and username=? ", new Object[]{adminuserMap.get(tmpString).getUid(),adminuserMap.get(tmpString).getSn()});
    		DbManager.getInstnace().executeCommand("delete form notice_user where  userid=? and methodlabel='mail' ", new Object[]{adminuserMap.get(tmpString).getUid()});
		}    	 	
    }
    
    /**
     *  group管理
     */ 
    private static final String SELECT_Admin_Group = "select a.groupid,a.groupname,count(b.uid) usercount from simple_group a left join group_user_rs b on a.groupid=b.groupid group by a.groupname order by groupid desc";
    private static final String INSERT_SIMPLE_GROUP = " insert into simple_group (groupname) values (?) ";
    private static final String DELETE_SIMPLE_GROUP = " delete from simple_group where groupid=? ";
    private static final String DELETE_GROUP_USER = " delete from group_user_rs where groupid=? and uid=? ";
    private static final String SELECT_GROUP_USER_RS = " select a.groupid,b.uid,b.userid,b.username,b.usericon from group_user_rs a right join simple_user b on a.uid=b.uid where a.groupid=? ";
    private static final String SELECT_GROUP_USER_RS_NOT = "  select a.uid,a.userid,a.username,a.usericon from simple_user a  where a.uid not in (select uid from group_user_rs where groupid=? )";
    private static final String INSERT_GROUP_USER_RS = " insert into group_user_rs values (?,?) ";
    private static final String UPDATE_SIMPLE_GROUP = " update simple_group set groupname=? where groupid=?";
    private static final String SELECT_Admin_Group_Name = " select groupname from simple_group where groupid= ? ";
    
    //1
    public static final List<Admin_GroupUserRSModel> Simplegroup_List(){
    	List<Admin_GroupUserRSModel> simplegroup_list = DbManager.getInstnace().executeQuery_ObjcetList(SELECT_Admin_Group, new Object[]{}, Admin_GroupUserRSModel.builder);
    	return simplegroup_list;
    }
    //2
    public static final void Simplegroup_Add(String groupname){
    	DbManager.getInstnace().executeCommand(INSERT_SIMPLE_GROUP, new Object[]{groupname});
    }
    //3
    public static final void Simplegroup_Delete(int groupid){
    	DbManager.getInstnace().executeCommand(DELETE_SIMPLE_GROUP, new Object[]{groupid});
    }
    //4
    public static final List<AdminSimpleUserModel> Simplegroup_Userlist(int groupid){
    	return DbManager.getInstnace().executeQuery_ObjcetList(SELECT_GROUP_USER_RS, new Object[]{groupid}, AdminSimpleUserModel.builder);
    }
    //5
    public static final List<AdminSimpleUserModel> Simplegroup_Userlistn(int groupid){
    	return DbManager.getInstnace().executeQuery_ObjcetList(SELECT_GROUP_USER_RS_NOT, new Object[]{groupid}, AdminSimpleUserModel.builder);
    }
    //6
    public static final void Simplegroup_Adduser(int groupid,int uid){
    	DbManager.getInstnace().executeCommand(INSERT_GROUP_USER_RS, new Object[]{groupid,uid});
    }
    //7
    public static final void Simplegroup_Deleteuser(int groupid,int uid){
    	DbManager.getInstnace().executeCommand(DELETE_GROUP_USER, new Object[]{groupid,uid});
	}
    //8
    public static final void Simplegroup_Updategroup(int groupid ,String groupname){
    	DbManager.getInstnace().executeCommand(UPDATE_SIMPLE_GROUP, new Object[]{groupname,groupid});
    }
    //9
    public static final String Simplegroup_Groupname(int groupid ){	
    	List<String> aa = DbManager.getInstnace().executeQuery_oneList(SELECT_Admin_Group_Name, new Object[]{groupid},"groupname");
    	String bb = aa.get(0);
    	return bb;
    }
    
    /**
     *  product管理
     */ 
    private static final String SELECT_Admin_Product = "select a.productid,a.product,count(*) productcount from simple_product a  group by a.product ";    
    private static final String SELECT_Group_Product = " select a.productid,a.product,a.tag,a.methodlabel,a.minlevel,count(groupid) countgroup from simple_product a left join group_product_rs b on a.productid=b.productid where product=? group by productid;  ";
    private static final String SELECT_Product_Group = "select a.groupid,a.groupname,a.groupicon from  simple_group a join (select * from group_product_rs where productid=?) b on a.groupid = b.groupid ";
    private static final String SELECT_Product_Group_RS = "select a.groupid,a.groupname,a.groupicon from simple_group a where a.groupid not in ( select groupid from group_product_rs where productid=?) ";
    private static final String INSERT_SIMPLE_PRODUCT = " insert into simple_product (product,tag,methodlabel,minlevel) values (?,?,?,?) "; 
    private static final String DELETE_SIMPLE_PRODUCT = "delete from simple_product where productid=? ";
    private static final String DELETE_PRODUCT_GROUP = "delete from group_product_rs where productid=? ";
    private static final String INSERT_GROUP_PRODUCT_RS = "insert into group_product_rs (groupid,productid) values (?,?) ";
    private static final String DELETE_GROUP_PRODUCT = "delete from group_product_rs where groupid=? and productid=? ";
    private static final String UPDATE_SIMPLE_PRODUCT = " update simple_product set product=?,tag=?,methodlabel=?,minlevel=? where productid=?";
    
    public static final List<AdminSimpleProductModel> Simpleproduct_List(){
    	List<AdminSimpleProductModel> simpleproduct_list = DbManager.getInstnace().executeQuery_ObjcetList(SELECT_Admin_Product, new Object[]{}, AdminSimpleProductModel.builder);
    	return simpleproduct_list;
    }
    //2
    public static final List<Admin_GroupProductRSModel> Simpleproduct_Infolist(String product){
    	return DbManager.getInstnace().executeQuery_ObjcetList(SELECT_Group_Product, new Object[]{product}, Admin_GroupProductRSModel.builder);
    }
    //3
    public static final List<Admin_GroupProductRSModel> Simpleproduct_Grouplist(int productid){
    	return DbManager.getInstnace().executeQuery_ObjcetList(SELECT_Product_Group, new Object[]{productid}, Admin_GroupProductRSModel.builder);
    }
    //4
    public static final List<Admin_GroupProductRSModel> Simpleproduct_Grouplistn(int productid){
    	return DbManager.getInstnace().executeQuery_ObjcetList(SELECT_Product_Group_RS, new Object[]{productid}, Admin_GroupProductRSModel.builder);
    }
    //5
    public static final void Simpleproduct_Addproduct(String product,String tag,String methodlabel,String minlevel){
    	DbManager.getInstnace().executeCommand(INSERT_SIMPLE_PRODUCT, new Object[]{product,tag,methodlabel,minlevel});
    } 
    //6
    public static final void Simpleproduct_Deleteproduct(int productid){
    	DbManager.getInstnace().executeCommand(DELETE_SIMPLE_PRODUCT, new Object[]{productid});
    	DbManager.getInstnace().executeCommand(DELETE_PRODUCT_GROUP, new Object[]{productid});
    } 
    //7
    public static final void Simpleproduct_Addgroup(int groupid,int productid){
    	DbManager.getInstnace().executeCommand(INSERT_GROUP_PRODUCT_RS, new Object[]{groupid,productid});
    }
    //8
    public static final void Simpleproduct_Deletegroup(int groupid,int productid){
    	DbManager.getInstnace().executeCommand(DELETE_GROUP_PRODUCT, new Object[]{groupid,productid});
    }
    //9
    public static final void Simpleproduct_Updateproduct(int productid ,String product,String tag,String methodlabel,String minlevel){
    	DbManager.getInstnace().executeCommand(UPDATE_SIMPLE_PRODUCT, new Object[]{product,tag, methodlabel, minlevel,productid});
    }
    
    /**
     *  platform管理
     */ 
    private static final String SELECT_Admin_Platfrom = " select a.*,count(distinct b.userid) methodcount from simple_notice_platform a left join notice_user b on a.methodlabel=b.methodlabel group by methodlabel";
    private static final String INSERT_SIMPLE_NOTICE_PLATFORM = " insert into simple_notice_platform () values (?,?,?,?,?,?) ";
    private static final String SELECT_Platform_USER = "  select '1' groupid,b.uid,b.userid,b.username,b.usericon from (select distinct userid from notice_user where methodlabel=? )a join simple_user b  on a.userid = b.userid ";
    private static final String SELECT_Platform_USER_RS = " select * from  (select b.groupid from  (select productid from simple_product where methodlabel=?) a  join group_product_rs b  on   a.productid=b.productid) c    join   (select  aa.uid,aa.username,aa.userid,aa.usericon,bb.groupid from simple_user aa join group_user_rs bb on aa.uid=bb.uid)  d  on d.groupid=c.groupid   where d.userid  not in   (select distinct userid from  notice_user where methodlabel=?)";
    private static final String DELETE_NOTICE_USER = "delete from notice_user where methodlabel=? ";
    private static final String DELETE_NOTICE_PLATFORM = " delete from simple_notice_platform where methodlabel=? ";
   
    public static final List<AdminConfPlatformModel> Confplatform_List(){
    	List<AdminConfPlatformModel> confplatform_list = new ArrayList<AdminConfPlatformModel>();
    	confplatform_list = DbManager.getInstnace().executeQuery_ObjcetList(SELECT_Admin_Platfrom, new Object[]{}, AdminConfPlatformModel.builder);
    	return confplatform_list;
    }
    //2
    public static final void Confplatform_Addplatform(String methodlabel,String methodname,String username,String password,String url,String port){
    	DbManager.getInstnace().executeCommand(INSERT_SIMPLE_NOTICE_PLATFORM, new Object[]{methodlabel,methodname,username,password,url,port});
    }
    //3
    public static final List<AdminSimpleUserModel> Confplatform_Userlist(String methodlabel){
    	return DbManager.getInstnace().executeQuery_ObjcetList(SELECT_Platform_USER, new Object[]{methodlabel}, AdminSimpleUserModel.builder);
    }
    //4
    public static final List<AdminSimpleUserModel> Confplatform_Userlistn(String methodlabel){
    	return DbManager.getInstnace().executeQuery_ObjcetList(SELECT_Platform_USER_RS, new Object[]{methodlabel,methodlabel}, AdminSimpleUserModel.builder);
    }
    //5
    public static final void Confplatform_Deleteplatform(String methodlabel){
    	DbManager.getInstnace().executeCommand(DELETE_NOTICE_PLATFORM, new Object[]{methodlabel});
    	DbManager.getInstnace().executeCommand(DELETE_NOTICE_USER, new Object[]{methodlabel});
    }
    /**
     *  pkgmine管理
     */ 
    private static final String SELECT_Admin_Pkgmine = " select pn name,concat(gamename,'-',gametype) value from  pkgmine ";
    private static final String INSERT_PKGMINE = " insert into pkgmine (pn,gamename,gametype,status) values (?,?,?,1) ";
    private static final String DELETE_PKGMINE = "delete from pkgmine where pn=?";
    
    public static final List<NameValueModel> Pkgmine_List(){
    	return DbManager.getInstnace(DB_NAME.googleplay).executeQuery_ObjcetList(SELECT_Admin_Pkgmine, new Object[]{}, NameValueModel.builder);
    }
    //2
    public static final void Pkgmine_Addpkg(String pn,String gamename,String game_type){
    	DbManager.getInstnace(DB_NAME.googleplay).executeCommand(INSERT_PKGMINE, new Object[]{pn,gamename,game_type});
    }
    //3
    public static final void Pkgmine_Deletepkg(String pn){
    	DbManager.getInstnace(DB_NAME.googleplay).executeCommand(DELETE_PKGMINE, new Object[]{pn});
    }
    
}
