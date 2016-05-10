package luo.rczp.colla.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.rczp.base.BaseDaoImpl;
import luo.rczp.colla.dao.UserLogDao;
import luo.rczp.colla.model.UserLog;

@Repository
public class UserLogDaoImpl extends BaseDaoImpl<UserLog,java.lang.Long>
	implements UserLogDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return UserLog.class;
	}

}