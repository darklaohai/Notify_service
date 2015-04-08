package com.jodo.notify.model;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.jodo.notify.util.ResultObjectBuilder;

public class Admin_GroupProductRSModel {
	private static final long serialVersionUID = 5454155825314635342L;
	
	private Integer  groupid;
	private Integer  productid;
	private String  groupname;
	private String  groupicon;
	private String  product;
	private String  tag;
	private String  methodlabel;
	private String  minlevel;
	private String  coutngroup;
	
	public Admin_GroupProductRSModel() {
		
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
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

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getMethodlabel() {
		return methodlabel;
	}

	public void setMethodlabel(String methodlabel) {
		this.methodlabel = methodlabel;
	}

	public String getMinlevel() {
		return minlevel;
	}

	public void setMinlevel(String minlevel) {
		this.minlevel = minlevel;
	}

	public String getCoutngroup() {
		return coutngroup;
	}

	public void setCoutngroup(String coutngroup) {
		this.coutngroup = coutngroup;
	}

	@Override
	public String toString() {
		return "Admin_GroupProductRSModel [groupid=" + groupid + ", productid="
				+ productid + ", groupname=" + groupname + ", groupicon="
				+ groupicon + ", product=" + product + ", tag=" + tag
				+ ", methodlabel=" + methodlabel + ", minlevel=" + minlevel
				+ ", coutngroup=" + coutngroup + "]";
	}

	public Admin_GroupProductRSModel(Integer groupid, Integer productid,
			String groupname, String groupicon, String product, String tag,
			String methodlabel, String minlevel, String coutngroup) {
		super();
		this.groupid = groupid;
		this.productid = productid;
		this.groupname = groupname;
		this.groupicon = groupicon;
		this.product = product;
		this.tag = tag;
		this.methodlabel = methodlabel;
		this.minlevel = minlevel;
		this.coutngroup = coutngroup;
	}

	public static ResultObjectBuilder<Admin_GroupProductRSModel> builder = new ResultObjectBuilder<Admin_GroupProductRSModel>() {
		@Override
		public Admin_GroupProductRSModel build(ResultSet rs) throws SQLException {
			ResultSetMetaData metaData = rs.getMetaData();
			Admin_GroupProductRSModel tmp = new Admin_GroupProductRSModel();
			
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
//			return new Admin_GroupProductRSModel(rs.getInt("productid"),rs.getString("product"),rs.getString("tag"),rs.getString("methodlabel"),rs.getString("minlevel"));
			
		}
	};
}
