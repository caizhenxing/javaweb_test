package com.sun.test;

import java.io.IOException;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class CommonUtils {
	protected HttpClient client = null;
	protected GetMethod getMethod = null;
	protected PostMethod postMethod = null;
//	protected String samurl = "http://localhost:8080/itel/";

	// protected String samurl = "http://192.168.1.88:8080/itel/";
	 protected String samurl = "http://121.199.46.52:8085/itel/";

//	 protected String samurl = "http://121.199.46.52:8090/itel/";

	public CommonUtils() {
		client = new HttpClient();
	}
	
	
	protected String excuteGetMethod(String url,NameValuePair[] list) {
		getMethod = new GetMethod(url);
		try {
			getMethod.setRequestHeader("Accept", "application/json");
			getMethod.setQueryString(list);
			int state = client.executeMethod(getMethod);
			System.out.println("state:" + state);
			String result = getMethod.getResponseBodyAsString();
			System.out.println(result);
			return result;
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	protected String excutePostMethod(String url,NameValuePair[] list) {
		postMethod = new PostMethod(url);
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			postMethod.addParameters(list);
			int state = client.executeMethod(postMethod);
			System.out.println("state:" + state);
			String result = postMethod.getResponseBodyAsString();
			System.out.println(result);
			return result;
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
