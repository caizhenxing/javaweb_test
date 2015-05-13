package com.y0.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.y0.model.UserModel;
import com.y0.service.LoginService;
import com.y0.service.RowMapperHelper;
import com.y0.service.dao.LoginDao;

//@Service("loginService")
public class LoginServiceImpl implements LoginService {

	private static final int List = 0;
	// @Resource
	private DataSource dataSource;
	@Resource
	private LoginDao loginDao;

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("����Դע��");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("��ʼ��");
	}

	@PreDestroy
	public void dealloc() {
		// TODO Auto-generated method stub
		System.out.println("����");
	}

	@Override
	public UserModel login(String name, String psw) {
		System.out.println("��½����");
		String sql = "select * from users where username='" + name + "'";
		UserModel model = (UserModel) jdbcTemplate.queryForObject(sql,
				new RowMapperHelper());
		if (model.getPassword().equals(psw)) {
			System.out.println("��½�ɹ�");
		} else {
			System.out.println("��½ʧ��");
		}
		return model;
	}

	@Override
	public void register(UserModel model) {
		System.out.println("ע��");
		String sql = "insert into users(username, password) values('"
				+ model.getUserName() + "','" + model.getPassword() + "');";
		System.out.println(sql);
		this.jdbcTemplate.update(sql);
		loginDao.verify();
	}

	@Override
	public List<UserModel> userList() {
		String sql = "select * from users";
		List<UserModel> user = this.jdbcTemplate.query(sql, new RowMapperHelper());
		System.out.println("�鵽���û�:" + user.size());
		return null;
	}
}
