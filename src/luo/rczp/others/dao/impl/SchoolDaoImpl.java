package luo.rczp.others.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.others.dao.SchoolDao;
import luo.rczp.others.model.School;

@Repository
public class SchoolDaoImpl extends BaseDaoImpl<School,java.lang.Long>
	implements SchoolDao{
	
	public Class getEntityClass() {
		return School.class;
	}
	
	public List<School> getListByProvinceId(Integer provinceId) {
		Finder f = Finder.create("from School ");
		if(provinceId != null ){
			f.append("where schoolProId =:provinceId");
			f.setParam("provinceId", provinceId);
		}
		return find(f);
	}

	public School getById(Integer schoolId) {
		return findUniqueByProperty("schoolId", schoolId);
	}

}