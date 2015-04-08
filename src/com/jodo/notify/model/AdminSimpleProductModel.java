package com.jodo.notify.model;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.jodo.notify.util.ResultObjectBuilder;

public class AdminSimpleProductModel {
	private static final long serialVersionUID = 5454155825314635342L;
	private Integer  productid;
	private String  product;
	private String  tag;
	private String  methodlabel;
	private String  minlevel;
	private String  productcount;
	private Integer  aggr;
	
	public AdminSimpleProductModel() {
		
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
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

	public String getProductcount() {
		return productcount;
	}

	public void setProductcount(String productcount) {
		this.productcount = productcount;
	}

	public Integer getAggr() {
		return aggr;
	}

	public void setAggr(Integer aggr) {
		this.aggr = aggr;
	}

	public AdminSimpleProductModel(Integer productid, String product,
			String tag, String methodlabel, String minlevel,
			String productcount, Integer aggr) {
		super();
		this.productid = productid;
		this.product = product;
		this.tag = tag;
		this.methodlabel = methodlabel;
		this.minlevel = minlevel;
		this.productcount = productcount;
		this.aggr = aggr;
	}

	@Override
	public String toString() {
		return "AdminSimpleProductModel [productid=" + productid + ", product="
				+ product + ", tag=" + tag + ", methodlabel=" + methodlabel
				+ ", minlevel=" + minlevel + ", productcount=" + productcount
				+ ", aggr=" + aggr + "]";
	}

	public static ResultObjectBuilder<AdminSimpleProductModel> builder = new ResultObjectBuilder<AdminSimpleProductModel>() {
		@Override
		public AdminSimpleProductModel build(ResultSet rs) throws SQLException {
			ResultSetMetaData metaData = rs.getMetaData();
			AdminSimpleProductModel tmp = new AdminSimpleProductModel();
			
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
