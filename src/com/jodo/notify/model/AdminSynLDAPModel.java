package com.jodo.notify.model;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.jodo.notify.util.ResultObjectBuilder;

public class AdminSynLDAPModel {

	private static long serialVersionUID = 5454155825314635342L;

	private java.lang.String uid;
	private java.lang.String cn;	
	private java.lang.String sn;	
	private java.lang.String mail;
	private java.lang.String displayName;
	private java.lang.String userPassword;

	public AdminSynLDAPModel() {
		
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		AdminSynLDAPModel.serialVersionUID = serialVersionUID;
	}

	public java.lang.String getUid() {
		return uid;
	}

	public void setUid(java.lang.String uid) {
		this.uid = uid;
	}

	public java.lang.String getCn() {
		return cn;
	}

	public void setCn(java.lang.String cn) {
		this.cn = cn;
	}

	public java.lang.String getSn() {
		return sn;
	}

	public void setSn(java.lang.String sn) {
		this.sn = sn;
	}

	public java.lang.String getMail() {
		return mail;
	}

	public void setMail(java.lang.String mail) {
		this.mail = mail;
	}

	public java.lang.String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(java.lang.String displayName) {
		this.displayName = displayName;
	}

	public java.lang.String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(java.lang.String userPassword) {
		this.userPassword = userPassword;
	}

	public static ResultObjectBuilder<AdminSynLDAPModel> getBuilder() {
		return builder;
	}

	public static void setBuilder(ResultObjectBuilder<AdminSynLDAPModel> builder) {
		AdminSynLDAPModel.builder = builder;
	}

	@Override
	public String toString() {
		return "AdminSynLDAPModel [uid=" + uid + ", cn=" + cn + ", sn=" + sn
				+ ", mail=" + mail + ", displayName=" + displayName
				+ ", userPassword=" + userPassword + "]";
	}

	public AdminSynLDAPModel(String uid, String cn, String sn, String mail,
			String displayName, String userPassword) {
		super();
		this.uid = uid;
		this.cn = cn;
		this.sn = sn;
		this.mail = mail;
		this.displayName = displayName;
		this.userPassword = userPassword;
	}

	public static ResultObjectBuilder<AdminSynLDAPModel> builder = new ResultObjectBuilder<AdminSynLDAPModel>() {
		@Override
		public AdminSynLDAPModel build(ResultSet rs) throws SQLException {
			ResultSetMetaData metaData = rs.getMetaData();
			AdminSynLDAPModel tmp = new AdminSynLDAPModel();
			
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
