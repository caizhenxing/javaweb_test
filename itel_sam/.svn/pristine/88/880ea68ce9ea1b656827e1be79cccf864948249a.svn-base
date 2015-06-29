package com.itel.filter;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;


public class SessionTokenFilter implements Filter{
	
	private String sessionTokenUrl;
	

	public String getSessionTokenUrl() {
		return sessionTokenUrl;
	}

	public void setSessionTokenUrl(String sessionTokenUrl) {
		this.sessionTokenUrl = sessionTokenUrl;
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

	
	public static void main(String[] args){
		String url = "http://192.168.1.9:7090/CloudCommunity/com/checkSeesionToken.json";
		String value = "{\"itel\":\"4491449\",\"type\":\"surveillance-android\",\"sessiontoken\":\"4491449_surveillance-android_00000000-6e8f-bc55-9097-14f20033c587_1694351406085097890\"}";
		System.out.println(sendPostJson(value,url));
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		System.out.println(getClass().getName()+":doFilter");
		/*BufferedReader   bf  = new   BufferedReader(new InputStreamReader(request.getInputStream()));  
		String line = null; 
		line=bf.readLine();
		request.getRequestURI();
		request.getParameter("logSession");*/
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
