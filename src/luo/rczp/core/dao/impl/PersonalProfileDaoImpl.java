package luo.rczp.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.core.dao.PersonalProfileDao;
import luo.rczp.core.model.PersonalProfile;

@Repository
public class PersonalProfileDaoImpl extends BaseDaoImpl<PersonalProfile,java.lang.Long>
	implements PersonalProfileDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return PersonalProfile.class;
	}
	
	public String getMapperName() {
		return "rczp.mapper.PersonalProfileMapper";
	}

	public PersonalProfile getByRealName(String loginName) {
		return findUniqueByProperty("realName", loginName);
	}
}