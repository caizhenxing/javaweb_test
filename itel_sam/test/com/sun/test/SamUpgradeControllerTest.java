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

public class SamUpgradeControllerTest extends CommonUtils{
 

	@Test
	public void insertSamUpgrade() {
		postMethod = new PostMethod(samurl + "samUpgradeController");
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {

			new NameValuePair("upgradeId", "113"),
					new NameValuePair("name", "sam"),
					new NameValuePair("samurl", "www.baidu.com"),
					new NameValuePair("decription", "add menu"),
					new NameValuePair("varPassWord", "demoname"),
					new NameValuePair("version", "1.2") };
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
	public void updateUpgradeDevice() {
		postMethod = new PostMethod(samurl + "samUpgradeController/modify");
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {

			new NameValuePair("upgradeId", "111"),
					new NameValuePair("name", "sam111"),
					new NameValuePair("samurl", "www.baidu.com"),
					new NameValuePair("decription", "add menu"),
					new NameValuePair("varPassWord", "demoname"),
					new NameValuePair("version", "1.0") };
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
	 * 获取最新版本
	 */
	@Test
	public void getLastVersion() {
		getMethod = new GetMethod(samurl + "samUpgradeController/getLastVersion");
		try {
			getMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] { new NameValuePair(
					"platform", "IOS")};
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
	public void getVersionAll() {
		getMethod = new GetMethod(samurl + "samUpgradeController/getVersionAll");
		try {
			getMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] { new NameValuePair(
					"platform", "IOS")};
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
	
	
	/**
	 * 通过平台获取版本信息列表
	 */
	@Test
	public void getVersionAllByType() {
		getMethod = new GetMethod(samurl + "samUpgradeController/getVersionAllByType/Android");
		try {
			getMethod.setRequestHeader("Accept", "application/json");
			/*NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("fields[version]", "1.1"),
					new NameValuePair("fields[type]", "Android")
			};
			getMethod.setQueryString(list);*/
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
