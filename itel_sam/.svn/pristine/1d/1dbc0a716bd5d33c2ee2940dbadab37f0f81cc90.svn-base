package com.sun.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SamPushControllerTest extends CommonUtils{
	@Test
	public void insertSamPush() {
		postMethod = new PostMethod(samurl + "samPushController");
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {

					new NameValuePair("channel", "113"),//极光推送注册id
					new NameValuePair("uitel", "sam"),//极光推送设置alias,设置为itel账号
					new NameValuePair("type", "Android"),//手机平台
					new NameValuePair("devicetype", "S")//可选设备类型;
					};
			postMethod.addParameters(list);
			int state = client.executeMethod(postMethod);
			System.out.println("state:" + state);
			String result = postMethod.getResponseBodyAsString();
			System.out.println(result);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@Test
	public void push() {
		postMethod = new PostMethod(samurl + "samPushController/pushMessage");
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {

					new NameValuePair("type", "PUSH_Message"),//极光推送注册id
					new NameValuePair("all", "Y"),//极光推送设置alias,设置为itel账号
					new NameValuePair("title", "j u nit"),//手机平台
					new NameValuePair("content", "Sssss")//可选设备类型;
					};
			postMethod.addParameters(list);
			int state = client.executeMethod(postMethod);
			System.out.println("state:" + state);
			String result = postMethod.getResponseBodyAsString();
			System.out.println(result);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
 
 

}
