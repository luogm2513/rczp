package luo.rczp.admin.dao.impl;

import luo.rczp.admin.dao.AdminAcountDao;
import luo.rczp.admin.model.AdminAcount;
import luo.rczp.base.BaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository
public class AdminAcountDaoImpl extends BaseDaoImpl<AdminAcount,java.lang.Long>
	implements AdminAcountDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return AdminAcount.class;
	}
	
	public String getMapperName() {
		return "rczp.mapper.AdminAcountMapper";
	}

}