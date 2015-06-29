package com.sun.test;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;

public class AccountCount {
	
	Connection cloudCon;// 云电话
	Connection samCon;// 云电话

	/*private String cloudCommunityURL = "jdbc:mysql://211.149.144.15:3306/account_iteldb?useUnicode=true&characterEncoding=utf8";
	private String cloudName = "root";
	private String cloudPwd = "m6f6i6";*/
	private String cloudCommunityURL = "jdbc:mysql://192.168.1.88:3306/account_iteldb?useUnicode=true&characterEncoding=utf8";
	private String cloudName = "root";
	private String cloudPwd = "itel789456";
	
	
	
	/*private String samURL = "jdbc:mysql://121.199.46.52:3306/sam?useUnicode=true&characterEncoding=utf8";
	private String samName = "root";
	private String samPwd = "sz_mysql";*/
	private String samURL = "jdbc:mysql://192.168.1.88:3306/sam?useUnicode=true&characterEncoding=utf8";
	private String samName = "root";
	private String samPwd = "itel789456";
	
	
	private void initCloud(){
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载数据库驱动
			System.out.println("账号服务器数据库驱动加载成功");
			cloudCon = DriverManager.getConnection(cloudCommunityURL, cloudName,
					cloudPwd); // 获取数据库连接
			if (cloudCon != null) {
				System.out.println("账号服务器数据库连接成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void samCloud(){
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载数据库驱动
			System.out.println("监控服务器数据库驱动加载成功");
			samCon = DriverManager.getConnection(samURL, samName,samPwd); // 获取数据库连接
			if (samCon != null) {
				System.out.println("监控服务器数据库连接成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Before
	public void init() {
		initCloud();
		samCloud();
	}
	@Test
	public void count(){
		System.out.println("账号服务器数据查询中.....");
		List<String> cloudList = getCloudAccount();
		System.out.println("账号服务器数据查询中完毕");
		System.out.println("监控服务器数据查询中.....");
		List<String> samList = getSamAccount();
		System.out.println("监控服务器数据查询中完毕");
		if(cloudList.removeAll(samList)){
//			System.out.println(cloudList.size());
			try {
				writeFile(cloudList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("筛选账号完毕");
		
	}
	
	private void writeFile(List<String> list)throws Exception{
		File file = new File("C:\\account.txt");
		FileOutputStream out = new FileOutputStream(file);
		out.write("-----可注册账号-----".getBytes());
		out.write("\r\n".getBytes());
		for(String username : list){
			out.write(username.getBytes());
			out.write("\r\n".getBytes());
		}
	}
	
	
	private List<String> getCloudAccount(){
		Statement statement;
		List<String> usernameList = new ArrayList<String>();
		try {
			statement = cloudCon.createStatement(); // 获取Statement对象
			/*String sql = " ";
			statement.execute(sql); // 执行添加数据操作
*/			ResultSet res = statement.executeQuery("select username from `user` where username like'0901%'"); // 查询所有记录
			while (res.next()) {
				String username = res.getString("username");
				System.out.println("cloud:"+username);
				usernameList.add(username);
			}
			// 关闭连接
			res.close();
			statement.close();
			cloudCon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usernameList;
	}
	
	
	private List<String> getSamAccount(){
		Statement statement;
		List<String> usernameList = new ArrayList<String>();
		try {
			statement = samCon.createStatement(); // 获取Statement对象
			/*String sql = " ";
			statement.execute(sql); // 执行添加数据操作
*/			ResultSet res = statement.executeQuery("select var_pitel from `itel_sam_device`"); // 查询所有记录
			while (res.next()) {
				String username = res.getString("var_pitel");
				System.out.println("sam:"+username);
				usernameList.add(username);
			}
			// 关闭连接
			res.close();
			statement.close();
			samCon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usernameList;
	}
	

}
