package luo.rczp.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.rczp.base.BaseDaoImpl;
import luo.rczp.core.dao.PersonalCentreDao;
import luo.rczp.core.model.PersonalCentre;

@Repository
public class PersonalCentreDaoImpl extends BaseDaoImpl<PersonalCentre,java.lang.Long>
	implements PersonalCentreDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return PersonalCentre.class;
	}
	
	public String getMapperName() {
		return "rczp.mapper.PersonalCentreMapper";
	}

}