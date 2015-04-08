package com.jodo.notify.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jodo.notify.util.ResultObjectBuilder;

public class NameValueModel {
	private String name;
	private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "NameValueModel [name=" + name + ", value=" + value + "]";
	}
	public NameValueModel(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	public static ResultObjectBuilder<NameValueModel> builder = new ResultObjectBuilder<NameValueModel>() {
		@Override
		public NameValueModel build(ResultSet rs) throws SQLException {
			return new NameValueModel(rs.getString("name"),rs.getString("value"));
		}
	};
}
