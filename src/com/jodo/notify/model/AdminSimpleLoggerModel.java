package com.jodo.notify.model;

import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.jodo.notify.util.ResultObjectBuilder;

public class AdminSimpleLoggerModel {
	private static final long serialVersionUID = 5454155825314635342L;
	private String  product;
	private String  methodlabel;
	private String  title;
	private String  content;
	private Date  time;
	private Integer  count;
	
	public AdminSimpleLoggerModel() {
		
	}
	
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getMethodlabel() {
		return methodlabel;
	}

	public void setMethodlabel(String methodlabel) {
		this.methodlabel = methodlabel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AdminSimpleLoggerModel [product=" + product + ", methodlabel="
				+ methodlabel + ", title=" + title + ", content=" + content
				+ ", time=" + time + ", count=" + count + "]";
	}

	public AdminSimpleLoggerModel(String product, String methodlabel,
			String title, String content, Date time, Integer count) {
		super();
		this.product = product;
		this.methodlabel = methodlabel;
		this.title = title;
		this.content = content;
		this.time = time;
		this.count = count;
	}

	public static ResultObjectBuilder<AdminSimpleLoggerModel> builder = new ResultObjectBuilder<AdminSimpleLoggerModel>() {
		@Override
		public AdminSimpleLoggerModel build(ResultSet rs) throws SQLException {
			ResultSetMetaData metaData = rs.getMetaData();
			AdminSimpleLoggerModel tmp = new AdminSimpleLoggerModel();
			
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
