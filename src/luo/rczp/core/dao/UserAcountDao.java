package luo.rczp.core.dao;

import luo.rczp.core.model.UserAcount;
import luo.rczp.base.BaseDao;

public interface UserAcountDao extends BaseDao<UserAcount,java.lang.Long> {
	
	public UserAcount getByEmail(String email);
	
}