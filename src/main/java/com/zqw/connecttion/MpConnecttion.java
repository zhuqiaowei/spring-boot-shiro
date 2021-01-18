package com.zqw.connecttion;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;


import com.zqw.entity.UserInfo;

import net.sf.json.JSONObject;
public class MpConnecttion {
	static String url="http://127.0.0.1:8080/";
	public static String PostWithParas(String way,String dress,Map<String,String> sendMsg) {
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod("http://127.0.0.1:8088/"+way+"/"+dress);
		Iterator<String> iter = sendMsg.keySet().iterator();
		if(iter.hasNext()) {
			String key=iter.next();
			postMethod.setRequestBody(new NameValuePair[] {new NameValuePair(key,sendMsg.get(key))});//设置参数
		}
		String result="";
		try {
		client.executeMethod(postMethod);//执行请求
		result = postMethod.getResponseBodyAsString();//获取返回的Response
		} catch (IOException e) {
		e.printStackTrace();
		}
		postMethod.releaseConnection();//释放链接
		return result;
	}
	
	public static void main(String[] args) {
		Map<String, String> map=new HashMap<String,String>();
    	map.put("cardNo", "6201202012123654");
		System.out.println(PostWithParas("BP","MH0011",map));
		
	}
}
