package com.sun.test;

import java.io.IOException;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;
public class SamAuthorControllerTest extends CommonUtils{

	/**
	 * 隐私安全-绑定设置-添加用户
	 */
	@Test
	public void insertSamAuthor() {
		postMethod = new PostMethod(samurl + "samAuthorController/addSamAuthor");
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {

					new NameValuePair("varPitel", "09010020"),//设备itel号
					new NameValuePair("varUitel", "321"),//需要绑定的itel号
					new NameValuePair("backName", "lisi")/*备注名*/}; 
			postMethod.addParameters(list);
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
	 * 隐私安全-用户列表
	 */
	@Test
	public void getSamAuthorByPitel() {
		getMethod = new GetMethod(samurl + "samAuthorController/getSamAuthorByPitel");
		try {
			getMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("varPitel", "8888888819")//设备itel号
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
	 * 隐私安全-绑定设置-修改绑定用户信息
	 */
	@Test
	public void updateSamAuthor() {
		postMethod = new PostMethod(samurl + "samAuthorController/updateSamAuthor");
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {

					new NameValuePair("varPitel", "6667777"),//设备itel号
					new NameValuePair("varUitel", "158302480"),//修改用户itel号
					new NameValuePair("backName", "zhangsanfeng")/*备注名*/};
			postMethod.addParameters(list);
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
	 * 隐私安全-绑定设置-删除绑定用户
	 */
	@Test
	public void deleteSamAuthor() {
		postMethod = new PostMethod(samurl + "samAuthorController/deleteSamAuthor");
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {

					new NameValuePair("varPitel", "09010002"),//设备itel号 
					new NameValuePair("varUitel", "15989420162")//绑定用户itel号 
					 
					};
			postMethod.addParameters(list);
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
	 * �鿴���������б�
	 */
	@Test
	public void getHelpCenterList() {
		getMethod = new GetMethod(samurl + "samHelpCenterController/queryForWhereAnd");
		try {
			getMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("fileds[version]", "1.1")
			};
			getMethod.setQueryString(list);
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
 
	
 

}
