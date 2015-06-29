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

public class SamHelpCenterControllerTest extends CommonUtils{


	@Before
	public void init() {
		client = new HttpClient();
	}

	@Test
	public void insertSamHelperCenter() {
		postMethod = new PostMethod(samurl + "samHelpCenterController");
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {

					new NameValuePair("title", "about help center"),
					new NameValuePair("content", "www.baidu.com"),
					new NameValuePair("version", "1.1")};
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
 
	/**
	 * 查看帮助中心列表
	 */
	@Test
	public void getHelpCenterList() {
		getMethod = new GetMethod(samurl + "samHelpCenterController/queryForWhereAnd");
		try {
			getMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("fields[version]", "1.0"), //版本
					new NameValuePair("fields[type]", "IOS") //设备平台
			};
			getMethod.setQueryString(list);
			int state = client.executeMethod(getMethod);
			System.out.println("state:" + state);
			String result = getMethod.getResponseBodyAsString();
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
	public void SamHelpCenter() {
		getMethod = new GetMethod(samurl + "samHelpCenterController/SamHelpCenter");
		try {
//			getMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("fields[version]", "1.1"), //版本
					new NameValuePair("fields[type]", "IOS") //设备平台
			};
			getMethod.setQueryString(list);
			int state = client.executeMethod(getMethod);
			System.out.println("state:" + state);
			String result = getMethod.getResponseBodyAsString();
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
