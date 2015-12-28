package org.baidu;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

/**
 * 百度登录SERVICE.
 * @author 新昵称Belen
 * @version 1.0 2015-1-27整理。
 * @since 1.0
 */
public class BaiduLoginService {

	private BaiduConnectService bc = BaiduConnectService.getInstance();
	private static final String BAIDU_URL = "http://www.baidu.com";
	private static final String TOKEN_GET_URL = "https://passport.baidu.com/v2/api/?getapi&tpl=mn&apiver=v3&class=login&logintype=dialogLogin";
	private static final String LOGIN_POST_URL = "https://passport.baidu.com/v2/api/?login";
	private String username;
	private String password;
	private String verifycode;
	private String codestring;
	private String token;
	
	public BaiduLoginService(String username,String password,String verifycode,String codestring){
		this.username = username;
		this.password = password;
		this.verifycode = verifycode;
		this.codestring = codestring;
	}
	
	// test
	public static void main(String[] args) throws Exception{
		// 请确保你在www.baidu.com可以登录成功。
		new BaiduLoginService("yuanlin8910", "y0love","","").login();
		// 下载百度文库。
//		new BaiduDownloadService("http://wenku.baidu.com/view/71ce3ec60c22590102029dd1.html").download();
	}
	
	public void login() throws Exception{
		System.out.println("准备登录 . Usename:"+username);
		// 预登录，获取cookie以便获取token.
		bc.execute(BAIDU_URL);
		this.initToken();
		System.out.println("正在登录。");
		HttpResponse response = bc.execute(LOGIN_POST_URL, produceFormEntity());
		String result = EntityUtils.toString(response.getEntity());
		String statusCode = this.substring(result, "error=", "'");
		System.out.println("百度返回的状态码：" + statusCode);
		// 自动识别验证码。
		// tools.autoCode(codestring);
		EntityUtils.consume(response.getEntity());
		System.out.println("--------------------------------");
		if(!checkLogin()){
			System.out.println("登录异常或频繁，需要验证码，codeString为：" + this.substring(result, "codestring=", "&"));
			System.out.println("登录结果:" + username + " 登录失败.");	
		}else{
			System.out.println("登录结果:" + " 登录成功.");
		}
	}
	
	public NodeList getNodeByName(String content,String tag,String name){
		Parser parser = Parser.createParser(content, "utf-8");
		AndFilter filter = new AndFilter(new TagNameFilter(tag),new HasAttributeFilter("name",name));
		try {
			return parser.parse(filter);
		} catch (ParserException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 登录POST参数
	private List<NameValuePair> produceFormEntity() throws UnsupportedEncodingException{
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("tt", ""+System.currentTimeMillis()));
		list.add(new BasicNameValuePair("tpl", "mn"));
		list.add(new BasicNameValuePair("token", token));
		list.add(new BasicNameValuePair("isPhone", ""));
		list.add(new BasicNameValuePair("username", username));
		list.add(new BasicNameValuePair("password", password));
		list.add(new BasicNameValuePair("verifycode", verifycode));
		list.add(new BasicNameValuePair("codestring", codestring));
		return list;
	}
	
	private void initToken() throws Exception{
		System.out.println("获取百度Token...");
		HttpResponse response = bc.execute(TOKEN_GET_URL);
		String str = EntityUtils.toString(response.getEntity());
		Pattern pattern = Pattern.compile("token\" : \"(.*?)\"");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()){
			token = matcher.group(1);
		}
		System.out.println("Token已获取:"+token);
	}
	
	private boolean checkLogin() throws Exception{
		HttpResponse response = bc.execute(BAIDU_URL);
		boolean res = false;
		String content = EntityUtils.toString(response.getEntity());
		if(!content.contains("登录")){
			res = true;
		}
		EntityUtils.consume(response.getEntity());
		return res;
	}
	
	public static String substring(String str, String s1, String s2) {
		// 1、先获得0-s1的字符串，得到新的字符串sb1
		// 2、从sb1中开始0-s2获得最终的结果。
		try {
			StringBuffer sb = new StringBuffer(str);
			String sb1 = sb.substring(sb.indexOf(s1) + s1.length());
			return String.valueOf(sb1.substring(0, sb1.indexOf(s2)));
		} catch (StringIndexOutOfBoundsException e) {
			return str;
		}
	}
}
