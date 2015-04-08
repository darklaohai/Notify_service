/**
 * @(#)Jodo, 2014年1月25日
 */
package com.jodo.notify.dal;

import java.util.List;

import com.jodo.notify.dao.NotifyAdminDao;
import com.jodo.notify.model.AdminConfPlatformModel;
import com.jodo.notify.model.AdminConfUserModel;
import com.jodo.notify.model.AdminSimpleGroupModel;
import com.jodo.notify.model.AdminSimpleProductModel;
import com.jodo.notify.model.AdminSimpleUserModel;
import com.jodo.notify.model.Admin_GroupProductRSModel;
import com.jodo.notify.model.Admin_GroupUserRSModel;
import com.jodo.notify.model.NameValueModel;
import com.jodo.notify.sqlhelper.DbManager;

/**
 * @author treemanz
 */
public class NotifyAdminDal {
	
	public static final NotifyAdminDal instance = new NotifyAdminDal();
	
    private NotifyAdminDal() {

    }
    
    /**
     *  人员配置
     * @throws Throwable 
     */
    //1
    public static final AdminSimpleUserModel ConfUser_User(String userid) throws Throwable{
		AdminSimpleUserModel confuser_user = NotifyAdminDao.ConfUser_User(userid);
    	return confuser_user;
    }
    //2
    public static final List<AdminSimpleGroupModel>  ConfUser_Group(){
    	List<AdminSimpleGroupModel> object_confuser_group = NotifyAdminDao.ConfUser_Group();
    	return object_confuser_group;
    }
    //3
    public static final List<AdminConfPlatformModel> Confuser_Platform(){
    	List<AdminConfPlatformModel> confuser_platform = NotifyAdminDao.Confuser_Platform();
    	return confuser_platform;
    }
    //4
    public static final List<AdminConfUserModel>  ConUser_Confuser(String userid){
    	List<AdminConfUserModel> conuser_confuser = NotifyAdminDao.ConUser_Confuser(userid);
    	return conuser_confuser;
    }
    //5
    public static final List<AdminSimpleProductModel> Confuser_Msg(String userid){
    	List<AdminSimpleProductModel> confuser_msg = NotifyAdminDao.Confuser_Msg(userid);
    	return confuser_msg;
    }
    //6修改配置信息
    public static final void  Confuser_Change(String userid,String var,String val){
    	NotifyAdminDao.Confuser_Change(userid,var,val);
    }
    /**
     *  MYSQL-LDAP 人员同步
     */
    public static final void  syn_mysql_ldap_user() throws Exception{
    	NotifyAdminDao.syn_mysql_ldap_user();
    }
    
    /**
     *  Group管理
     */
    //1group人数表
    public List<Admin_GroupUserRSModel> Simplegroup_List(){
    	return NotifyAdminDao.Simplegroup_List();
    }
    
    //2新增group
    public void Simplegroup_Add(String groupname){
    	NotifyAdminDao.Simplegroup_Add(groupname);
    }
    
    //3删除group 
    public void Simplegroup_Delete(int groupid){
    	NotifyAdminDao.Simplegroup_Delete(groupid);
    }
    
    //4Group查看已有人员
    public List<AdminSimpleUserModel> Simplegroup_Userlist(int groupid){
    	return NotifyAdminDao.Simplegroup_Userlist(groupid);
    }
    
    //5Group查看未有人员
    public List<AdminSimpleUserModel> Simplegroup_Userlistn(int groupid){
    	return NotifyAdminDao.Simplegroup_Userlistn(groupid);
    }
    
    //6给group增加人
    public void Simplegroup_Adduser(int groupid,int uid){
    	NotifyAdminDao.Simplegroup_Deleteuser(groupid, uid);
    }
    
    //7给group删除人
    public void Simplegroup_Deleteuser(int groupid,int uid){
    	NotifyAdminDao.Simplegroup_Deleteuser(groupid,uid);
    }
    //8更新group名字
    public void Simplegroup_Updategroup(int groupid,String groupname){
    	NotifyAdminDao.Simplegroup_Updategroup(groupid, groupname);
    }
    //9根据id获得组名
    public String Simplegroup_Groupname(int groupid){
    	return NotifyAdminDao.Simplegroup_Groupname(groupid);
    }
    
    /**
     *  product管理
     */
    //1product_配置数表
    public List<AdminSimpleProductModel> Simpleproduct_List(){
    	return NotifyAdminDao.Simpleproduct_List();
    }
    //2product_group数表
    public List<Admin_GroupProductRSModel> Simpleproduct_Infolist(String product){
    	return NotifyAdminDao.Simpleproduct_Infolist(product);
    } 
    //3product_影响到的group表
    public static final List<Admin_GroupProductRSModel> Simpleproduct_Grouplist(int productid){
    	return NotifyAdminDao.Simpleproduct_Grouplist(productid);
    }  
    //4product_未影响的group表
    public static final List<Admin_GroupProductRSModel> Simpleproduct_Grouplistn(int productid){
    	return NotifyAdminDao.Simpleproduct_Grouplistn(productid);
    }
    //5新增product
    public void Simpleproduct_Addproduct(String product,String tag,String methodlabel,String minlevel){
    	NotifyAdminDao.Simpleproduct_Addproduct(product, tag, methodlabel, minlevel);
    }
    //6删除product
    public void Simpleproduct_Deleteproduct(int groupid){
    	NotifyAdminDao.Simpleproduct_Deleteproduct(groupid);
    }
    //7给product增加组
    public void Simpleproduct_Addgroup(int groupid,int productid){
    	NotifyAdminDao.Simpleproduct_Addgroup(groupid,productid);;
    }
    //8给product删除组
    public void Simpleproduct_Deletegroup(int groupid,int productid){
    	NotifyAdminDao.Simpleproduct_Deletegroup(groupid, productid);
    }
    //9更新product
    public void Simpleproduct_Updateproduct(int productid ,String product,String tag,String methodlabel,String minlevel){
    	NotifyAdminDao.Simpleproduct_Updateproduct(productid, product, tag, methodlabel, minlevel);
    }
    
    /**
     *  platform管理
     */
    //1platform表单
    public List<AdminConfPlatformModel> Confplatform_List(){
    	return NotifyAdminDao.Confplatform_List();
    }
    //2增加platform
    public void Confplatform_Addplatform(String methodlabel,String methodname,String username,String password,String url,String port){
    	NotifyAdminDao.Confplatform_Addplatform(methodlabel, methodname, username, password, url, port);;
    }
    //3platform已配置列表
    public static final List<AdminSimpleUserModel> Confplatform_Userlist(String methodlabel){
    	return NotifyAdminDao.Confplatform_Userlist(methodlabel) ;
    }
    //4platform未配置列表
    public static final List<AdminSimpleUserModel> Confplatform_Userlistn(String methodlabel){
    	return NotifyAdminDao.Confplatform_Userlistn(methodlabel);
    }
    //5platform删除
    public static final void Confplatform_Deleteplatform(String methodlabel){
    	NotifyAdminDao.Confplatform_Deleteplatform(methodlabel);
    }
    
    /**
     *  pkgmine管理
     */
    //1pkgmine列表
    public static final List<NameValueModel> Pkgmine_List(){
    	return NotifyAdminDao.Pkgmine_List();
    }
    //2增加pkgmine
    public static final void Pkgmine_Addpkg(String pn,String gamename,String game_type){
    	NotifyAdminDao.Pkgmine_Addpkg(pn,gamename,game_type);
    }
    //3删除pkgmine
    public static final void Pkgmine_Deletepkg(String pn){
    	NotifyAdminDao.Pkgmine_Deletepkg(pn);
    }


}
