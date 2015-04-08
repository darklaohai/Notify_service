package com.jodo.notify.model;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.jodo.notify.util.ResultObjectBuilder;

public class AdminSimpleGroupModel {
	private static final long serialVersionUID = 5454155825314635342L;
	private Integer  groupid;
	private String  groupname;
	private String  groupicon;
	
	public AdminSimpleGroupModel() {
	}
	
	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
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

	@Override
	public String toString() {
		return "AdminSimpleGroupModel [groupid=" + groupid + ", groupname="
				+ groupname + ", groupicon=" + groupicon + "]";
	}

	public AdminSimpleGroupModel(Integer groupid, String groupname,
			String groupicon) {
		super();
		this.groupid = groupid;
		this.groupname = groupname;
		this.groupicon = groupicon;
	}

	public static ResultObjectBuilder<AdminSimpleGroupModel> builder = new ResultObjectBuilder<AdminSimpleGroupModel>() {
		@Override
		public AdminSimpleGroupModel build(ResultSet rs) throws SQLException {
			ResultSetMetaData metaData = rs.getMetaData();
			AdminSimpleGroupModel tmp = new AdminSimpleGroupModel();
			
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
