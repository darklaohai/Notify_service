package com.jodo.notify.bll;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.List;

import javax.security.auth.login.LoginContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jodo.notify.dal.NotifyAdminDal;
import com.jodo.notify.dao.NotifyAdminDao;
import com.jodo.notify.model.AdminConfPlatformModel;
import com.jodo.notify.model.AdminConfUserModel;
import com.jodo.notify.model.AdminSimpleGroupModel;
import com.jodo.notify.model.AdminSimpleProductModel;
import com.jodo.notify.model.AdminSimpleUserModel;
import com.jodo.notify.model.Admin_GroupProductRSModel;
import com.jodo.notify.model.Admin_GroupUserRSModel;
import com.jodo.notify.model.NameValueModel;
import com.jodo.notify.util.CookieUtil;

public class NotifyAdminServlet extends MyHttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = getStringValue(req, "page", null);      
        if(null==page){
        	this.getServletContext()
			.getRequestDispatcher("/WEB-INF/jsps/notifyadmin/index.jsp")
			.forward(req, resp);
        }else if(page.equals("product")){
        	String product = getStringValue(req, "product", null);
        	int productid = getIntValue(req, "productid", (int)0);
        	int display = 0;
        	int display1 = 0;
        	if(null!=product){
        		display=1;
        	}
        	if(productid!=0){
        		display1=1;
        	}
        	List<AdminSimpleProductModel> adminProductModels = NotifyAdminDal.instance.Simpleproduct_List();
			List<Admin_GroupProductRSModel> adminProductGroupModels = NotifyAdminDal.instance.Simpleproduct_Infolist(product);
			List<Admin_GroupProductRSModel> adminProductGroupDetailModels = NotifyAdminDal.Simpleproduct_Grouplist(productid);
			List<Admin_GroupProductRSModel> adminProductGroupDetailModels1 = NotifyAdminDal.Simpleproduct_Grouplistn(productid);
        	req.setAttribute("adminProductModels",adminProductModels);
        	req.setAttribute("adminProductGroupModels", adminProductGroupModels);
        	req.setAttribute("adminProductGroupDetailModels", adminProductGroupDetailModels);
        	req.setAttribute("adminProductGroupDetailModels1", adminProductGroupDetailModels1);
        	req.setAttribute("product", product);
        	req.setAttribute("productid", productid);
        	req.setAttribute("display", display);
        	req.setAttribute("display1", display1);
			this.getServletContext()
			.getRequestDispatcher("/WEB-INF/jsps/notifyadmin/EditProduct.jsp")
			.forward(req, resp);
		}else if(page.equals("group")){
			List<Admin_GroupUserRSModel> adminGroupModels = NotifyAdminDal.instance.Simplegroup_List();
			req.setAttribute("adminGroupModels",adminGroupModels);
			int groupid = getIntValue(req, "groupid", (int)1);
			int display = getIntValue(req, "groupid", (int)0);		
			String groupname = NotifyAdminDal.instance.Simplegroup_Groupname(groupid);
				List<AdminSimpleUserModel> adminUserModels = NotifyAdminDal.instance.Simplegroup_Userlist(groupid);
				List<AdminSimpleUserModel> adminUserModels1 = NotifyAdminDal.instance.Simplegroup_Userlistn(groupid);
				req.setAttribute("adminUserModels", adminUserModels);
				req.setAttribute("adminUserModels1", adminUserModels1);
				req.setAttribute("groupid", groupid);
				req.setAttribute("groupname", groupname);
				req.setAttribute("page", page);
				req.setAttribute("display", display);			
			this.getServletContext()
			.getRequestDispatcher("/WEB-INF/jsps/notifyadmin/EditGroup.jsp")
			.forward(req, resp);
		}else if(page.equals("platform")){
			String methodlabel = getStringValue(req, "methodlabel",null);
			String add = getStringValue(req, "method",null);
			int display=0;
			int display1=0;
			if(null!=add){
				display=1;
			}
			if(null!=methodlabel){
				display1=1;
			}
			List<AdminConfPlatformModel> adminPlatformlModels = NotifyAdminDal.instance.Confplatform_List();
			List<AdminSimpleUserModel> adminUserModels = NotifyAdminDal.Confplatform_Userlist(methodlabel);
			List<AdminSimpleUserModel> adminUserModels1 = NotifyAdminDal.Confplatform_Userlistn(methodlabel);
			req.setAttribute("methodlabel", methodlabel);
			req.setAttribute("adminPlatformlModels", adminPlatformlModels);
			req.setAttribute("adminUserModels",adminUserModels);
			req.setAttribute("adminUserModels1",adminUserModels1);
			req.setAttribute("display",display);
			req.setAttribute("display1",display1);
			this.getServletContext()
			.getRequestDispatcher("/WEB-INF/jsps/notifyadmin/EditPlatform.jsp")
			.forward(req, resp);
		}else if(page.equals("pkgmine")){
			List<NameValueModel> pkgminelistList = NotifyAdminDal.Pkgmine_List();
			req.setAttribute("pkgminelistList", pkgminelistList);
			this.getServletContext()
			.getRequestDispatcher("/WEB-INF/jsps/notifyadmin/EditPkgmine.jsp")
			.forward(req, resp);
		}else if(page.equals("userinfo")){	
			String userid = getStringValue(req, "userid",null);
    		if(null == userid){
    			return;
    		}
    		
    		try {
    			AdminSimpleUserModel  confuser_user = NotifyAdminDal.ConfUser_User(userid);
    			List<AdminSimpleGroupModel> confuser_group = NotifyAdminDal.ConfUser_Group();
    			List<AdminConfPlatformModel> confuser_platform = NotifyAdminDal.Confuser_Platform();
    			List<AdminConfUserModel> conuser_confuser = NotifyAdminDal.ConUser_Confuser(userid);
    			List<AdminSimpleProductModel> confuser_msg = NotifyAdminDal.Confuser_Msg(userid);
	    		req.setAttribute("confuser_user",confuser_user);
	    		req.setAttribute("confuser_group",confuser_group);
	    		req.setAttribute("confuser_platform",confuser_platform);
	    		req.setAttribute("conuser_confuser",conuser_confuser);
	    		req.setAttribute("confuser_msg",confuser_msg);
				this.getServletContext()
				.getRequestDispatcher("/WEB-INF/jsps/notifyadmin/EditUserinfo.jsp")
				.forward(req, resp);
	    		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		

    	}else if(page.equals("logout")){
			req.setAttribute("tmethodlist",null);
			this.getServletContext()
			.getRequestDispatcher("/WEB-INF/jsps/login/login.jsp")
			.forward(req, resp);
			req.getSession().setAttribute("_verified_", false);
		}else if(page.equals("test")){
			this.getServletContext()
			.getRequestDispatcher("/WEB-INF/jsps/notifyadmin/test.jsp")
			.forward(req, resp);
		}else if(page.equals("index")){
			String method = getStringValue(req, "method",null);
						
			if(null!=method && method.equals("syn")){
				try {
					NotifyAdminDal.syn_mysql_ldap_user();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null!=method && method.equals("jihuo")){
				
				try {
					NotifyAdminDal.syn_mysql_ldap_user();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.getServletContext()
			.getRequestDispatcher("/WEB-INF/jsps/notifyadmin/index.jsp")
			.forward(req, resp);
		}
	
    }
	
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String page = getStringValue(req, "page", null);
    	String method = getStringValue(req, "method", null);
    	if(null == page){
    	
    	}else if(page.equals("group")){	
			int groupid = getIntValue(req,"groupid", (int)0);
    		if (method.equals("add_user")){ 
    			String uidString = getStringValue(req,"uidstring", null); 
    			String[] uidlist=uidString.split("_"); 
    			for (int i = 0; i < uidlist.length; i++) {
    				Integer uid = Integer.parseInt(uidlist[i]);
					NotifyAdminDal.instance.Simplegroup_Adduser(groupid,uid);
				}
    			resp.getWriter().append("{\"msg\":\"success\"}");
    			return; 			
    		}else if (method.equals("delete_user")){
    			String uidString = getStringValue(req,"uidstring", null); 
    			String[] uidlist=uidString.split("_"); 
    			for (int i = 0; i < uidlist.length; i++) {
    				Integer uid = Integer.parseInt(uidlist[i]);
					NotifyAdminDal.instance.Simplegroup_Deleteuser(groupid, uid);;
				}
    			resp.getWriter().append("{\"msg\":\"success\"}");
    			return; 
    		}else if (method.equals("update")){
    			String groupname = getStringValue(req, "groupname", null);
    			NotifyAdminDal.instance.Simplegroup_Updategroup(groupid, groupname);
    			resp.getWriter().append("{\"msg\":\"success\"}");
    			return;
    		}else if (method.equals("delete")){ 
    			NotifyAdminDal.instance.Simplegroup_Delete(groupid);
    			resp.getWriter().append("{\"msg\":\"success\"}");
    			return;
    		}else if (method.equals("add")){ 
    			String groupname = getStringValue(req, "groupname", null);
    			NotifyAdminDal.instance.Simplegroup_Add(groupname);;
    			resp.sendRedirect("/notify/notifyadmin?page=group");
    			return;
    		}
    		

    	}else if(page.equals("product")){	
			int productid = getIntValue(req, "productid", (int)0);
    		if (method.equals("add_group")){ 
    			String groupidString = getStringValue(req,"groupidstring", null); 
    			String[] groupidlist=groupidString.split("_"); 
    			for (int i = 0; i < groupidlist.length; i++) {
    				Integer groupid = Integer.parseInt(groupidlist[i]);
					NotifyAdminDal.instance.Simpleproduct_Addgroup(groupid, productid);
				}
    			resp.getWriter().append("{\"msg\":\"success\"}");
    			return; 			
    		}else if (method.equals("delete_group")){
    			String groupidString = getStringValue(req,"groupidstring", null); 
    			String[] groupidlist=groupidString.split("_"); 
    			for (int i = 0; i < groupidlist.length; i++) {
    				Integer groupid = Integer.parseInt(groupidlist[i]);
					NotifyAdminDal.instance.Simpleproduct_Deletegroup(groupid, productid);
				}
    			resp.getWriter().append("{\"msg\":\"success\"}");
    			return; 
    		}else if (method.equals("update")){
    			String product = getStringValue(req, "product", null);
    			String tag = getStringValue(req, "tag", null);
    			String methodlabel = getStringValue(req, "methodlabel", null);
    			String minlevel = getStringValue(req, "minlevel", null);
    			NotifyAdminDal.instance.Simpleproduct_Updateproduct(productid, product, tag, methodlabel, minlevel);
    			resp.sendRedirect("/notify/notifyadmin?page=product");
    			return;
    		}else if (method.equals("delete")){ 
    			NotifyAdminDal.instance.Simpleproduct_Deleteproduct(productid);
    			resp.getWriter().append("{\"msg\":\"success\"}");
    			return;
    		}else if (method.equals("add")){ 
    			String product = getStringValue(req, "product_add", null);
    			String tag = getStringValue(req, "tag_add", null);
    			String methodlabel = getStringValue(req, "methodlabel_add", null);
    			String minlevel = getStringValue(req, "minlevel_add", null);   			
    			NotifyAdminDal.instance.Simpleproduct_Addproduct(product, tag, methodlabel, minlevel);
    			resp.sendRedirect("/notify/notifyadmin?page=product&method=add");
    			return;
    		}
    		
  
    		
    	}else if(page.equals("platform")){	
			String methodlabel = getStringValue(req, "methodlabel",null);
    		if (method.equals("delete")){  
    			NotifyAdminDal.Confplatform_Deleteplatform(methodlabel);
    			resp.getWriter().append("{\"msg\":\"success\"}");
    			return; 			
    		}else if(method.equals("add")){
    			String methodname = getStringValue(req, "methodname", null);
    			String username = getStringValue(req, "username", null);
    			String password = getStringValue(req, "password", null);
    			String url = getStringValue(req, "url", null);
    			String port = getStringValue(req, "port", null);
    			NotifyAdminDal.instance.Confplatform_Addplatform(methodlabel, methodname, username, password, url, port);
    			resp.sendRedirect("/notify/notifyadmin?page=platform");
    			return;
    		}
    		
  		
    	}else if(page.equals("pkgmine")){	
			String pn = getStringValue(req, "pn",null);
    		if (method.equals("add")){
    			String gamename = getStringValue(req, "gamename", null);
    			String game_type = getStringValue(req, "game_type", null);
    			NotifyAdminDal.Pkgmine_Addpkg(pn, gamename,game_type);
    			resp.sendRedirect("/notify/notifyadmin?page=pkgmine");
    			return;
    		}else if(method.equals("delete")){
    			NotifyAdminDal.Pkgmine_Deletepkg(pn);
    			resp.getWriter().append("{\"msg\":\"success\"}");
    			return;
    		}
    
    		
    	}else if(page.equals("userinfo")){	
			String userid = getStringValue(req, "userid", null);
			String var = getStringValue(req, "var", null);
			String val = getStringValue(req, "val", null);
			NotifyAdminDal.Confuser_Change(userid, var, val);
			resp.sendRedirect("/notify/notifyadmin?page=index&userid="+userid);
    		return;
    	}else if(page.equals("login")){	
			String username = getStringValue(req, "username", null);
			String password = getStringValue(req, "password", null);
			String email = getStringValue(req, "mail", null);
    		if(method.equals("login")){
    			if(username.equals("admin")&&password.equals("admin")){  				
    				resp.sendRedirect("/notifyadmin?page=index");
    				return;
    			}
    		}else if (method.equals("recover")){ 		
    			resp.getWriter().append("{\"msg\":\"success\"}");
    			return;
    		}
 
    	}else if(page.equals("test")){	
			String username = getStringValue(req, "username", null);
			String password = getStringValue(req, "password", null);
			
    		if(method.equals("login")){
    			if(username.equals("admin")&&password.equals("admin")){  				
    				resp.sendRedirect("/notify/notifyadmin?page=index");
    				return;
    			}
    		}else if (method.equals("recover")){ 		
    			resp.getWriter().append("{\"msg\":\"success\"}");
    			return;
    		}
    	}else{
    		
    	}
    }
}
