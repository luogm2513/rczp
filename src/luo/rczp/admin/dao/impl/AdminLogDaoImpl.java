package luo.rczp.admin.dao.impl;

import luo.rczp.admin.dao.AdminLogDao;
import luo.rczp.admin.model.AdminLog;
import luo.rczp.base.BaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository
public class AdminLogDaoImpl extends BaseDaoImpl<AdminLog,java.lang.Long>
	implements AdminLogDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return AdminLog.class;
	}
	
	public String getMapperName() {
		return "rczp.mapper.AdminLogMapper";
	}

}