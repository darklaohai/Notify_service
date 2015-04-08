package com.jodo.notify.model;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.jodo.notify.util.ResultObjectBuilder;

public class AdminSimpleUserModel {
	private static final long serialVersionUID = 5454155825314635342L;
	private Integer  uid;
	private String  userid;
	private String  username;
	private String  usericon;
	
	public AdminSimpleUserModel() {
		
	}
	
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
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

	@Override
	public String toString() {
		return "AdminSimpleUserModel [uid=" + uid + ", userid=" + userid
				+ ", username=" + username + ", usericon=" + usericon + "]";
	}

	public AdminSimpleUserModel(Integer uid, String userid, String username,
			String usericon) {
		super();
		this.uid = uid;
		this.userid = userid;
		this.username = username;
		this.usericon = usericon;
	}

	public static ResultObjectBuilder<AdminSimpleUserModel> builder = new ResultObjectBuilder<AdminSimpleUserModel>() {
		@Override
		public AdminSimpleUserModel build(ResultSet rs) throws SQLException {
			ResultSetMetaData metaData = rs.getMetaData();
			AdminSimpleUserModel tmp = new AdminSimpleUserModel();
			
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
