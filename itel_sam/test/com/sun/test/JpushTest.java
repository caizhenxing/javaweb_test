package com.sun.test;

import java.io.IOException;
import java.net.URLEncoder;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Before;
import org.junit.Test;

import cn.jpush.api.utils.Base64;
import cn.jpush.api.utils.StringUtils;

public class JpushTest {

	private HttpClient client = null;
	private GetMethod getMethod = null;
	private PostMethod postMethod = null;
	private final String url = "https://api.jpush.cn/v3/push";
	private final String pushV2 = "http://api.jpush.cn:8800/v2/push";

	@Before
	public void init() {
		client = new HttpClient();
	}
	@Test
	public void pushNotification()throws Exception{
		char[] base64 = Base64.encode(("3259f0dbb3b30b010de8e25f"+":"+"bfa29d1a23557cea8aa2c221").getBytes());
		System.out.println(base64);
		
//		
		String str = "{\"notification\" : {\"ios\" : {\"alert\" : \"hello, JPush!\",\"sound\" : \"happy\",\"badge\" : 1,\"extras\" : {\"news_id\" : 134,\"my_key\" : \"a value\"}}}}";
		System.out.println(str);
		postMethod = new PostMethod(url+"?"+str);
		try {
			postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			postMethod.setRequestHeader("Authorization", base64+"");
			/*NameValuePair nameValuePair = new NameValuePair();
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("sendno", Random.class.newInstance().nextInt(10000000)+""),
					new NameValuePair("app_key", "3259f0dbb3b30b010de8e25f"),
					new NameValuePair("receiver_type", "4"),
					new NameValuePair("msg_type", "1")};
			postMethod.addParameters(list);*/
			int state = client.executeMethod(postMethod);
			System.out.println("state:" + state);
			String result = postMethod.getResponseBodyAsString();
			System.out.println(result);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void pushNotification2()throws Exception{
		char[] base64 = Base64.encode(("3259f0dbb3b30b010de8e25f"+":"+"bfa29d1a23557cea8aa2c221").getBytes());
		int sendno = 3321;
		int receiverType = 2;
		String receiverValue = "";
		String masterSecret = "bfa29d1a23557cea8aa2c221"; //极光推送portal 上分配的 appKey 的验证串(masterSecret)
		String input = String.valueOf(sendno) + receiverType + receiverValue + masterSecret;
		String verificationCode = URLEncoder.encode(StringUtils.toMD5(input));
		
		String str = "sendno=3321" +
				"&receiver_type=4" +
				"&msg_type=1" +
				"&verificationCode="+verificationCode+"" +
						"&msg_content="+"{n_builder_id:\"100\",n_title:\"title\",n_content:\"content\"}"+"" +
								"&platform=android,ios";
		System.out.println(URLEncoder.encode(str));
		postMethod = new PostMethod(pushV2);
		try {
			postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("sendno","3321"),
					new NameValuePair("app_key", "3259f0dbb3b30b010de8e25f"),
					new NameValuePair("receiver_type", "4"),
					new NameValuePair("msg_type", "1"),
					new NameValuePair("verificationCode", verificationCode),
					new NameValuePair("msg_content", "{n_builder_id:\"100\",n_title:\"title\",n_content:\"content\"}"),
					new NameValuePair("platform", "android, ios"),};
//			String str = "sendno=3321&app_key=3259f0dbb3b30b010de8e25f&receiver_type=4&msg_type=1&verificationCode="+verificationCode+"&msg_content="+"{n_builder_id:\"100\",n_title:\"title\",n_content:\"content\"}"+"&platform=android,ios";
//			postMethod.addParameters(list);
			int state = client.executeMethod(postMethod);
			System.out.println("state:" + state);
			String result = postMethod.getResponseBodyAsString();
			System.out.println(result);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 
	 
}
