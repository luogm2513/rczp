package luo.rczp.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.rczp.base.BaseDaoImpl;
import luo.rczp.core.dao.CompProfileDao;
import luo.rczp.core.model.CompProfile;
import luo.rczp.core.model.PersonalProfile;

@Repository
public class CompProfileDaoImpl extends BaseDaoImpl<CompProfile,java.lang.Long>
	implements CompProfileDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return CompProfile.class;
	}

	public CompProfile getByCompName(String loginName) {
		return findUniqueByProperty("compName", loginName);
	}
}