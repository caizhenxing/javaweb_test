package com.sun.test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class CloudCommunityTest {
	private HttpClient client = null;
	private GetMethod getMethod = null;
	private PostMethod postMethod = null;
	private final String url = "http://192.168.1.9:7090/CloudCommunity/";

	@Before
	public void init() {
		client = new HttpClient();
	}
	@Test
	public void checkedEmailCode(){
		getMethod = new GetMethod(url + "user/checkedEmailCode.json?itel=18627540357&code=762002");
		try {
			 
			int state = client.executeMethod(getMethod);
			System.out.println("state:" + state);
			String result = getMethod.getResponseBodyAsString();
			System.out.println(result);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkItelPassword(){
		postMethod = new PostMethod(url + "user/checkItelPassword.json");//
		try {
			postMethod.addRequestHeader("Accept-Language", "zh-CN");
//			postMethod.addRequestHeader("Accept", "application/json");
//			postMethod.addRequestHeader("Content-Type", "appl ication/x-www-form-urlencoded");
			postMethod.addRequestHeader("Content-Type", "application/json;charset=utf-8");
			postMethod.addRequestHeader("Content-length", "111");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("itel", "6667777888999"),//设备Itel号
					new NameValuePair("password", "Sss"),
					new NameValuePair("sessiontoken", "18627540357_surveillance-android_00000000-7cae-42f5-0033-c5870033c587_6485581406109451526")
					};
			postMethod.addParameters(list);
//			postMethod.setRequestBody("sessiontoken=18627540357_surveillance-android_00000000-7cae-42f5-0033-c5870033c587_6485581406109451526&itel=23921&password=sds");
//			postMethod.setRequestBody("sessiontoken=18627540357_surveillance-android_00000000-7cae-42f5-0033-c5870033c587_6485581406109451526");
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
	
	
	
	 
	/**
	 * 发送Post json
	 * @param xmlInfo
	 * @param URL
	 * @return
	 */
	public static String sendPostJson(String xmlInfo,String URL){        
	     System.out.println("发起的数据:"+xmlInfo);      
	     byte[] xmlData = xmlInfo.getBytes();           
	     InputStream instr  = null;
	     java.io.ByteArrayOutputStream out = null;             
	      try{                         
	             URL url = new URL(URL);               
	             URLConnection urlCon = url.openConnection();              
	             urlCon.setDoOutput(true);             
	             urlCon.setDoInput(true);              
	             urlCon.setUseCaches(false);       
	             urlCon.setRequestProperty("Content-Type", "application/json;charset=utf-8"); 
	             urlCon.setRequestProperty("Accept-Language", "zh-CN");      
	             urlCon.setRequestProperty("Content-length",String.valueOf(xmlData.length));
	             System.out.println(String.valueOf(xmlData.length));
	             DataOutputStream printout = new DataOutputStream(urlCon.getOutputStream());           
	             printout.write(xmlData);              
	             printout.flush();             
	             printout.close();             
	             instr = urlCon.getInputStream();  
	             byte[] bis = IOUtils.toByteArray(instr);
	             String ResponseString = new String(bis, "UTF-8"); 
	            if ((ResponseString == null) || ("".equals(ResponseString.trim()))) {
	                 System.out.println("返回空");
	                }
	           System.out.println("返回数据为:" + ResponseString);
	          return ResponseString;   
	      }catch(Exception e){             
	             e.printStackTrace();
	            return "0";
	      }            
	      finally {            
	             try {         
	                    out.close();  
	                    instr.close(); 
	                     
	             }catch (Exception ex) {     
	                    return "0";
	                 }                 
	             }                 
	      }  
	
	public String setValue(Map<String,String> map){
		JSONObject jsonObject = new JSONObject();
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			jsonObject.put(key, map.get(key));
		}
		return jsonObject.toString();
	}
	
	@Test
	public void login(){
		String url = "http://account.itelland.com/CloudCommunity/login.json";
		String value = "{\"itel\":\"1004064\",\"password\":\"~UM?$2%4T4#?34?##~3:~M38!&M!AA%~\"}";
		Map<String,String> map = new HashMap<String,String>();
		map.put("itel", "1004064");
		map.put("password", "~UM?$2%4T4#?34?##~3:~M38!&M!AA%~");
		map.put("type", "surveillance-android");
		map.put("onlymark", "00000000-4767-1cd7-69e1-bf207d8be151");
		
		sendPostJson(value,url);
		
	}
	
	
	@Test
	public void checkImgCodeItel(){
		while(true){
		String url = "http://211.149.144.15:8080/CloudCommunity/safety/checkImgCodeItel.json";
//		String value = "{\"itel\":\"18627540357\",\"verifycode\":\"cv7V\",\"token\":\"18627540357_surveillance-android_ffffffff-f019-6a2a-ba07-18000033c587_4618311408952367674\"}";
		String value = "{\"itel\":\"18627540357\",\"verifycode\":\"cv7V\"}";
		Map<String,String> map = new HashMap<String,String>();
		map.put("itel", "18627540357");
		map.put("verifycode", "RnQA");
		map.put("token", "18627540357_surveillance-android_ffffffff-f019-6a2a-ba07-18000033c587_4618311408952367674");
		
		sendPostJson(value,url);
		}
		
	}

	
	public static void main(String[] args){
		
		/*String url = "http://192.168.1.9:7090/CloudCommunity/user/checkItelPassword.json?sessiontoken=158302480_surveillance-ios_B8BABF32-2E66-4B64-A9AB-9A7856E19113_1244031406168762667";
		String value = "{\"itel\":\"18627540357\",\"password\":\"~UM?$2%4T4#?34?##~3:~M38!&M!AA%~\"}";
		System.out.println(sendPostJson(value,url));*/
		
		String url = "http://211.149.144.15:8080/CloudCommunity/user/checkItel.json?sessiontoken=83110571_ecommerce-ios_2070158B-53AD-45AD-B64D-E7442BA2E9B7_1847211394105701272";
		String value = "{\"itel\":\"186275403571\"}";
		System.out.println(sendPostJson(value,url));
		 
	}

}
