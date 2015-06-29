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

public class SamDeviceControllerTest extends CommonUtils{

	/**
	 * 添加设备
	 */
	@Test
	public void insertSamDevice() {
		NameValuePair[] list = new NameValuePair[] {
				new NameValuePair("varPitel", "09010031"),// 设备Itel号
				new NameValuePair("varType", "S"),// 设备类型,后期可能扩展至猫眼
				new NameValuePair("varTitle", "监控测试"),// 设备标题
				new NameValuePair("varPassWord", "~UM?$2%4T4#?34?##~3:~M38!&M!AA%~"),// 设备密码
				new NameValuePair("varUiTel", "361911854") // 用户iTel号
		};
		excutePostMethod(UrlValue.SamDevice_insertSamDevice, list);
	}

	/**
	 * 添加已有设备
	 */
	@Test
	public void addExistDevice() {
		NameValuePair[] list = new NameValuePair[] {
				new NameValuePair("varPitel", "09010011"),// 设备Itel号
				new NameValuePair("varTitle", "yangxuan"),// 备注名
				new NameValuePair("varPassWord", "~UM?$2%4T4#?34?##~3:~M38!&M!AA%~"),// 设备Itel密码
				new NameValuePair("varUiTel", "18627540357") // 当前操作用户iTel号
		};
		excutePostMethod(UrlValue.SamDevice_addExistDevice, list);
	}
	
	
	/**
	 * 隐私安全-允许所有人绑定
	 */
	@Test
	public void setAllUserBind() {
		NameValuePair[] list = new NameValuePair[] {
				new NameValuePair("varPitel", "09010002"),// 设备Itel号
				new NameValuePair("userbind", "Y"),// 设备Itel密码
				new NameValuePair("varUiTel", "13365811177") // 当前操作用户iTel号
		};
		excutePostMethod(UrlValue.SamDevice_setAllUserBind, list);

	}
 

	/**
	 * 修改设备标题
	 */
	@Test
	public void updateTitle() {
		NameValuePair[] list = new NameValuePair[] {
				new NameValuePair("varPitel", "45651561"),
				new NameValuePair("varTitle", "我的摄像头1"),
				new NameValuePair("varUiTel", "1583024801") };
		excutePostMethod(UrlValue.SamDevice_updateTitle, list);
	}

	/**
	 * 设置摄像头公开
	 */
	@Test
	public void setDeviceShare() {
		NameValuePair[] list = new NameValuePair[] {
				new NameValuePair("varPitel", "666"),
				new NameValuePair("flagShare", "N") };
		excutePostMethod(UrlValue.SamDevice_setDeviceShare, list);
	}

	/**
	 * 设备列表-解除绑定
	 */
	@Test
	public void deleteSamDevice() {
		postMethod = new PostMethod(samurl + "samDeviceController/deleteDevice");
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("varPitel", "09010031"),
					new NameValuePair("varUiTel", "361911854") };
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
	public void querySamDevice() {
		postMethod = new PostMethod(samurl + "samDeviceController/querySamDevice");
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("varPitel", "222222"),
					new NameValuePair("varType", "dem2222"),
					new NameValuePair("varTitle", "demoname"),
					new NameValuePair("varDeviceId", "demoname"),
					new NameValuePair("varPassWord", "demoname"),
					new NameValuePair("varUiTel", "demoname"),
					new NameValuePair("varRemark", "demoname"),
					new NameValuePair("flagShare", "N"),
					new NameValuePair("flagIsDel", "N") };
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
	public void querySamDeviceById() throws Exception {
		getMethod = new GetMethod(samurl
				+ "samDeviceController/querySamDeviceById/855");
		getMethod.setRequestHeader("Accept", "application/json");
		/*
		 * NameValuePair[] list = new NameValuePair[] { new
		 * NameValuePair("start", "0"), new NameValuePair("limit", "10") };
		 * getMethod.setQueryString(list);
		 */
		client.executeMethod(getMethod);
		byte[] res = getMethod.getResponseBody();
		System.out.println(new String(res, "UTF-8"));
	}

	@Test
	public void queryAllSamDevice() throws Exception {
		getMethod = new GetMethod(samurl + "samDeviceController/queryAllSamDevice");
		getMethod.setRequestHeader("Accept", "application/json");
		/*
		 * NameValuePair[] list = new NameValuePair[] { new
		 * NameValuePair("start", "0"), new NameValuePair("limit", "10") };
		 * getMethod.setQueryString(list);
		 */
		client.executeMethod(getMethod);
		byte[] res = getMethod.getResponseBody();
		System.out.println(new String(res, "UTF-8"));
	}

	@Test
	public void queryForWhereOr() {
		getMethod = new GetMethod(samurl + "login/queryForWhereOr");
		try {
			getMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("pageIndex", "0"),
					new NameValuePair("pageMax", "2"),
					new NameValuePair("fileds[varPitel]", "0901001") };
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
	 * ��������ͷ��ѯ
	 */
	@Test
	public void queryShareDevicce() {
		getMethod = new GetMethod(samurl + "samDeviceController/queryForWhereAnd");
		try {
			getMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("pageIndex", "0"),
					new NameValuePair("pageMax", "20"),
					new NameValuePair("fields[flagShare]", "Y"),
					new NameValuePair("fields[flagIsDel]", "N") };
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
	 * 获取我的设备列表
	 */
	@Test
	public void queryOwerDevicce() {
		/*
		getMethod = new GetMethod(samurl + "samDeviceController/getOwerDevice");
		try {
			getMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("pageIndex", "0"),
					new NameValuePair("pageMax", "20"),
					new NameValuePair("fields[varUiTel]", "18627540357") };
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
	*/
		NameValuePair[] list = new NameValuePair[] {
				new NameValuePair("pageIndex", "0"),
				new NameValuePair("pageMax", "20"),
				new NameValuePair("fields[varUiTel]", "18627540357") };
		excuteGetMethod(UrlValue.SamDevice_queryOwerDevicce, list);
	}

	@Test
	public void sendMail() {
		for (int i = 0; i < 100; i++) {
			getMethod = new GetMethod(
					"http://192.168.1.9:7090/CloudCommunity/user/sendEmailCode.json?itel=222222&toEmail=381766286@qq.com");
			try {
				getMethod.setRequestHeader("Accept", "application/json");
				NameValuePair[] list = new NameValuePair[] {
						new NameValuePair("pageIndex", "0"),
						new NameValuePair("pageMax", "20"),
						new NameValuePair("fields[varUiTel]", "158302480") };
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
	
	/**
	 * 校验itel是否在本系统注册
	 */
	@Test
	public void querySamDeviceUitel() {
		postMethod = new PostMethod(samurl + "samDeviceController/querySamDeviceUitel");
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("varUiTel", "09010003")};
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
	public void queryAllDevicce() {
		getMethod = new GetMethod(samurl + "samDeviceController/queryForWhereAnd");
		try {
			getMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("pageIndex", "0"),
					new NameValuePair("pageMax", "100"),
					new NameValuePair("fields[flagIsDel]", "N") };
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
	 * 摄像头列表模糊查询
	 */
	@Test
	public void queryShareDeviceByLike() {
		getMethod = new GetMethod(samurl + "samDeviceController/queryShareDeviceByLike");
		try {
			getMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("pageIndex", "0"),
					new NameValuePair("pageMax", "20"),
					new NameValuePair("likeValue", "09") };
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
	 * 通过账号密码校验是否存在设备
	 */
	@Test
	public void queryDevicceByPitel2Pwd() {
		getMethod = new GetMethod(samurl + "samDeviceController/queryForWhereAnd");
		try {
			getMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("pageIndex", "0"),
					new NameValuePair("pageMax", "20"),
					new NameValuePair("fields[varPitel]", "09010001"),
					new NameValuePair("fields[varPassWord]", "~UM?$2%4T4#?34?##~3:~M38!&M!AA%~") };
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
	 * 通过账号密码校验是否存在设备
	 */
	@Test
	public void queryDevicceByPitel2PwdPost() {
		postMethod = new PostMethod(samurl + "samDeviceController/queryForWhereAnd");
		try {
			postMethod.setRequestHeader("Accept", "application/json");
			NameValuePair[] list = new NameValuePair[] {
					new NameValuePair("pageIndex", "0"),
					new NameValuePair("pageMax", "20"),
					new NameValuePair("fields[varPitel]", "09010001"),
					new NameValuePair("fields[varPassWord]", "~UM?$2%4T4#?34?##~3:~M38!&M!AA%~") };
			postMethod.setQueryString(list);
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
	 * 查询设备是否存在（采集端初始化）
	 */
	@Test
	public void queryDevicebyId() {
		getMethod = new GetMethod(samurl + "samDeviceController/queryDevice/0901000");
		try {
			getMethod.setRequestHeader("Accept", "application/json");
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
