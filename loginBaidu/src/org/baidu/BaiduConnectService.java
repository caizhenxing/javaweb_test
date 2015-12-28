package org.baidu;


import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/**
 * HTTPCLIENT请求封装。
 * @author 新昵称Belen
 * @version 1.0 2015-1-27 整理。
 * @since 1.0
 */
@SuppressWarnings("deprecation")
public class BaiduConnectService {

	private CookieStore cookieStore = new BasicCookieStore();
	
	private BaiduConnectService(){}
	
	private static class BaiduConnectServiceContainer{
		private static BaiduConnectService bc = new BaiduConnectService();
	}
	
	public static BaiduConnectService getInstance(){
		System.out.println("初始化：BaiduConnectService.");
		return BaiduConnectServiceContainer.bc;
	}
	
	public HttpResponse execute(String url) throws Exception{
		return this.execute(url,null);
	}
	
	public HttpResponse execute(String url, List<NameValuePair> params) throws Exception{
		HttpClient httpClient = new DefaultHttpClient(
				new ThreadSafeClientConnManager());
		HttpResponse response = null;
		HttpUriRequest request = null;
		if (params != null) {
			HttpPost httpPost = new HttpPost(url);
			try {
				HttpEntity postBodyEnt = new UrlEncodedFormEntity(params);
				httpPost.setEntity(postBodyEnt);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request = httpPost;
		} else {
			HttpGet httpGet = new HttpGet(url);
			request = httpGet;
		}
		HttpContext localContext = new BasicHttpContext();
		localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
		response = httpClient.execute(request, localContext);
		System.out.println("[HTTP状态码:" + response.getStatusLine().getStatusCode() + "]" + "-->Request URL:" + url);
		return response;
	}

	public CookieStore getCookieStore() {
		return cookieStore;
	}

	public void setCookieStore(CookieStore cookieStore) {
		this.cookieStore = cookieStore;
	}
}
