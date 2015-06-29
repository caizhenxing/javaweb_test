package com.itel.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itel.dao.LoginAccountDao;
import com.itel.dao.utils.BaseDao;
import com.itel.domain.LoginAccount;

/**
 * 登入持久层实现类
 * @author yangxuan
 *
 */
@Repository
public class LoginAccountDaoImpl implements LoginAccountDao {
	@Autowired
	private BaseDao baseDao;
	
	/**
	 * 校验账号合法性
	 */
	@Override
	public LoginAccount queryloginAccount(LoginAccount loginAccount) {
		String hql = " from LoginAccount where username = ? and password = ?";
		List<LoginAccount> list = this.baseDao.findByHql(hql, new Object[]{loginAccount.getUsername(),loginAccount.getPassword()});
		if(list.size()>0)
			return list.get(0);
		return null;
	}

}
