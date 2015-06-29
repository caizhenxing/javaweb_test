package com.sun.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

public class JdbcTest {
	Connection con;

	@Before
	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载数据库驱动
			System.out.println("数据库驱动加载成功");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sam?useUnicode=true&characterEncoding=utf8", "root", ""); // 获取数据库连接
			if (con != null) {
				System.out.println("数据库连接成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertDevice() {
		Statement statement;
		try {
			statement = con.createStatement(); // 获取Statement对象
			String sql = " insert into itel_sam_device(var_pitel,var_type,var_password,var_uitel,var_title) values('99900','S','321132','2222','我就是中文')";
			statement.execute(sql); // 执行添加数据操作
			ResultSet res = statement.executeQuery("select * from itel_sam_device"); // 查询所有记录
			while (res.next()) {
				String var_title = res.getString("var_title");
				System.out.println(var_title);
			}
			// 关闭连接
			res.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

}
