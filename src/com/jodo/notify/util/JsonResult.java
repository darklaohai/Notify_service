package com.jodo.notify.util;

import java.util.HashMap;
import java.util.Map;

public class JsonResult {

	Map<String, Object> state;

	Map<String, Object> data;

	public JsonResult() {
		state = new HashMap<String, Object>();
		data = new HashMap<String, Object>();
	}

	public JsonResult(int code, String msg) {
		this();
		this.setState(code, msg);
	}

	public void setState(int code, String msg) {
		this.state.put("code", code);
		this.state.put("msg", msg);
	}

	public void putData(String key, Object value) {
		this.data.put(key, value);
	}

	public Map<String, Object> getState() {
		return state;
	}

	public void setState(Map<String, Object> state) {
		this.state = state;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
