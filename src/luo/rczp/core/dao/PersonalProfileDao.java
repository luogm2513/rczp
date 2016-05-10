package luo.rczp.core.dao;

import java.io.Serializable;
import java.util.List;

import luo.rczp.base.BaseDao;
import luo.rczp.core.model.PersonalProfile;

public interface PersonalProfileDao extends BaseDao<PersonalProfile,java.lang.Long> {
	public PersonalProfile getByRealName(String realName);
}