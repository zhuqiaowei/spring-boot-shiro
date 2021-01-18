package com.zqw;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
public class Test {
	public static void main(String[] args) {
		System.out.println("日志查询结果：");
		System.out.println("日志保存时间：2018.04.25 14:02-2018.04.25 17:00");
		System.out.println("MP1001:访问37次，失败次数20，失败率为：55%");
		System.out.println("MP1002:访问3次，失败次数0，失败率为：0%");
//		try {
//			sendPhone();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public static void sendPhone() throws HttpException, IOException {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.api.smschinese.cn"); 
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
		NameValuePair[] data ={ new NameValuePair("Uid", "zhuqiaowei"),new NameValuePair("Key", "zhuqiaoweidemiyao"),
								new NameValuePair("smsMob","13711335177"),new NameValuePair("smsText","接口MP1001请求失败率为55%，请及时查看！！")};
		post.setRequestBody(data);

		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		for(Header h : headers)
		{
		System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
		System.out.println(result); //打印返回消息状态


		post.releaseConnection();

	}
	
	public static void showMsg() {
		System.out.println("start request: MP10001:");
		System.out.println("该次请求的流水号：flashId=20180424135535321+ea4d");
		System.out.println("请求参数为：accountNo=5ds6af5s6das5d9s8f7ds4ad,custumId=123456789");
		System.out.println("开始执行前置拦截器getSessionMessage--------->");
		System.out.println("accountNo转换成功，622222222222222");
		System.out.println("getSessionMessage执行结束------------->");
		System.out.println("开始请求：https://localhost:8080/pb/getFirmMobile");
		System.out.println("请求参数：accountNo=622222222222222&custumId=123456789");
		System.out.println("后台返回参数：tranCode=0，tranMsg=，firmMobile=13711335177");
		System.out.println("开始执行后置拦截器setSessionMessage--------->");
		System.out.println("firmMobile脱敏成功，137****5177");
		System.out.println("setSessionMessage执行结束------------->");
		System.out.println("返回结果为：tranCode=MP100001，tranMsg=，firmMobile=137****5177");
	}
	
	public static void resultMsg() {
		System.out.println("日志查询结果：");
		System.out.println("日志保存时间：2018.04.25 14:02-2018.04.25 17:00");
		System.out.println("MP1001:访问37次，失败次数20，失败率为：55%");
		System.out.println("MP1002:访问3次，失败次数0，失败率为：0%");
	}
}
