package com.jodo.notify.model;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.jodo.notify.util.ResultObjectBuilder;

public class AdminConfUserModel {
	private static final long serialVersionUID = 5454155825314635342L;
	private String  methodlabel;
	private String  userid;
	private String  useraccount;
	
	public AdminConfUserModel() {
		
	}

	public String getMethodlabel() {
		return methodlabel;
	}

	public void setMethodlabel(String methodlabel) {
		this.methodlabel = methodlabel;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	@Override
	public String toString() {
		return "AdminConfUserModel [methodlabel=" + methodlabel + ", userid="
				+ userid + ", useraccount=" + useraccount + "]";
	}

	public AdminConfUserModel(String methodlabel, String userid,
			String useraccount) {
		super();
		this.methodlabel = methodlabel;
		this.userid = userid;
		this.useraccount = useraccount;
	}

	public static ResultObjectBuilder<AdminConfUserModel> builder = new ResultObjectBuilder<AdminConfUserModel>() {
		@Override
		public AdminConfUserModel build(ResultSet rs) throws SQLException {
			ResultSetMetaData metaData = rs.getMetaData();
			AdminConfUserModel tmp = new AdminConfUserModel();
			
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
/*		public AdminConfUserModel build(ResultSet rs) throws SQLException {
			return new AdminConfUserModel(rs.getString("methodlabel"),rs.getString("userid"),rs.getString("useraccount"));
		}*/
	};
}
