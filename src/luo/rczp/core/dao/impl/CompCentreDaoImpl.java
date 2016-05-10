package luo.rczp.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.rczp.base.BaseDaoImpl;
import luo.rczp.core.dao.CompCentreDao;
import luo.rczp.core.model.CompCentre;

@Repository
public class CompCentreDaoImpl extends BaseDaoImpl<CompCentre,java.lang.Long>
	implements CompCentreDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return CompCentre.class;
	}
	
	public String getMapperName() {
		return "rczp.mapper.CompCentreMapper";
	}

}