package com.jodo.notify.model;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.jodo.notify.util.ResultObjectBuilder;

public class Admin_GroupUserRSModel {
	private static final long serialVersionUID = 5454155825314635342L;
	
	private Integer  groupid;
	private Integer  uid;
	private String  groupname;
	private String  groupicon;
	private String  userid;
	private String  username;
	private String  usericon;
	private String  usercount;
	
	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getGroupicon() {
		return groupicon;
	}

	public void setGroupicon(String groupicon) {
		this.groupicon = groupicon;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsericon() {
		return usericon;
	}

	public void setUsericon(String usericon) {
		this.usericon = usericon;
	}

	public String getUsercount() {
		return usercount;
	}

	public void setUsercount(String usercount) {
		this.usercount = usercount;
	}


	public Admin_GroupUserRSModel(Integer groupid, Integer uid,
			String groupname, String groupicon, String userid, String username,
			String usericon, String usercount) {
		super();
		this.groupid = groupid;
		this.uid = uid;
		this.groupname = groupname;
		this.groupicon = groupicon;
		this.userid = userid;
		this.username = username;
		this.usericon = usericon;
		this.usercount = usercount;
	}
	
	public Admin_GroupUserRSModel() {

	}


	public static ResultObjectBuilder<Admin_GroupUserRSModel> builder = new ResultObjectBuilder<Admin_GroupUserRSModel>() {
		@Override
		public Admin_GroupUserRSModel build(ResultSet rs) throws SQLException {
			ResultSetMetaData metaData = rs.getMetaData();
			Admin_GroupUserRSModel tmp = new Admin_GroupUserRSModel();
			
			Method[] methods = tmp.getClass().getDeclaredMethods();
			for(int i=1; i<=metaData.getColumnCount(); i++) {
				String columnLabel = metaData.getColumnLabel(i);
				String setterName = "set" + columnLabel;
				try {
					for(Method m : methods) {
						if(setterName.equalsIgnoreCase(m.getName())) {
							Class<?>[] parameterTypes = m.getParameterTypes();
							if(parameterTypes.length > 0) {
								Class<?> clazz = parameterTypes[0];
								if(clazz == Integer.class) {
									m.invoke(tmp, rs.getInt(i));
								} else if (clazz == String.class) {
									m.invoke(tmp, rs.getString(i));		
								}
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}  
				
			}
			return tmp;
		}
	};
}
