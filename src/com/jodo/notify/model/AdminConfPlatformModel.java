package com.jodo.notify.model;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.jodo.notify.util.ResultObjectBuilder;

public class AdminConfPlatformModel {
	private static final long serialVersionUID = 5454155825314635342L;
	private String  methodlabel;
	private String  methodname;
	private String  username;
	private String  password;
	private String  url;
	private String  port;
	private String  methodcount;
	
	public AdminConfPlatformModel() {
		
	}

	public String getMethodlabel() {
		return methodlabel;
	}

	public void setMethodlabel(String methodlabel) {
		this.methodlabel = methodlabel;
	}

	public String getMethodname() {
		return methodname;
	}

	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getMethodcount() {
		return methodcount;
	}

	public void setMethodcount(String methodcount) {
		this.methodcount = methodcount;
	}

	public AdminConfPlatformModel(String methodlabel, String methodname,
			String username, String password, String url, String port,
			String methodcount) {
		super();
		this.methodlabel = methodlabel;
		this.methodname = methodname;
		this.username = username;
		this.password = password;
		this.url = url;
		this.port = port;
		this.methodcount = methodcount;
	}

	@Override
	public String toString() {
		return "AdminConfPlatformModel [methodlabel=" + methodlabel
				+ ", methodname=" + methodname + ", username=" + username
				+ ", password=" + password + ", url=" + url + ", port=" + port
				+ ", methodcount=" + methodcount + "]";
	}

	public static ResultObjectBuilder<AdminConfPlatformModel> builder = new ResultObjectBuilder<AdminConfPlatformModel>() {
		@Override
		
		public AdminConfPlatformModel build(ResultSet rs) throws SQLException {
			ResultSetMetaData metaData = rs.getMetaData();
			AdminConfPlatformModel tmp = new AdminConfPlatformModel();
			
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
	/*	public AdminConfPlatformModel build(ResultSet rs) throws SQLException {
			return new AdminConfPlatformModel(rs.getString("methodlabel"),rs.getString("methodname"),rs.getString("username"),rs.getString("password"),rs.getString("url"),rs.getString("port"));
		}*/
	};
}
