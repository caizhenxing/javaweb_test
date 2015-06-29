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

public class SamNoticControllerTest extends CommonUtils{


	/**
	 * ֪ͨ��Ϣ(�ͻ����ڴ��?�ֲ���ʱ�����ô˽ӿڱ��������������)
	 */
	@Test
	public void insertSamNotic() {
		postMethod = new PostMethod(samurl + "samNoticController");
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {

					new NameValuePair("title", "money"),
					new NameValuePair("userName", "yangxuan"),
					new NameValuePair("content", "how much system"),
					new NameValuePair("noticType", "system notic"),
					new NameValuePair("deviceType", "S"),
					new NameValuePair("uItel", "110002")};
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
	 * �鿴ϵͳ��Ϣ�б�
	 */
	@Test
	public void getNoticList() {
		getMethod = new GetMethod(samurl + "samNoticController/queryForWhereAnd");
		try {
			getMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("pageIndex", "0"),
					new NameValuePair("pageMax", "2"),
					new NameValuePair("fields[uItel]", "158302480")
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
	
	
	/**
	 * 删除消息通知
	 */
	@Test
	public void deleteSamNotic() {
		postMethod = new PostMethod(samurl + "samNoticController/deleteNotics");
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("ids", "fe983b61-6218-4f71-831b-729160871fel9"),
					new NameValuePair("ids", "fe983b61-6218-4f71-831b-729160871fel8")};
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
