package com.zqw.common;

import com.zqw.entity.JsonEntity;

import net.sf.json.JSONObject;

public class ReJson {
	//将后端的数据解析成JSON对象
	public static JsonEntity reJson(String msg) {
		JSONObject json = JSONObject.fromObject(msg); 
		JsonEntity je=new JsonEntity();
		je.setState(json.getString("state"));
		je.setMessage(json.getString("message"));
		je.setData(json.getString("data"));
		return je;
	}
	//将data转成JSON对象  测试用
	public static String toJson(String msg) {
		JSONObject json = JSONObject.fromObject(msg); 
		return json.getString("cardNo");
	}
}
