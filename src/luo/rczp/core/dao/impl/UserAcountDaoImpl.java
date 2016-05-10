package luo.rczp.core.dao.impl;

import org.springframework.stereotype.Repository;

import luo.rczp.base.BaseDaoImpl;
import luo.rczp.core.dao.UserAcountDao;
import luo.rczp.core.model.UserAcount;

@Repository
public class UserAcountDaoImpl extends BaseDaoImpl<UserAcount,java.lang.Long>
	implements UserAcountDao{
	
	public Class<UserAcount> getEntityClass() {
		return UserAcount.class;
	}

	public UserAcount getByEmail(String email) {
		return findUniqueByProperty("email", email);
	}

}