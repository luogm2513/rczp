package luo.rczp.core.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import luo.rczp.base.BaseDaoImpl;
import luo.rczp.core.dao.UserLoginDao;
import luo.rczp.core.model.UserLogin;

@Repository
public class UserLoginDaoImpl extends BaseDaoImpl<UserLogin,java.lang.String>
	implements UserLoginDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return UserLogin.class;
	}
	
}