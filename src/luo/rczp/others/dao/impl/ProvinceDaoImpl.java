package luo.rczp.others.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.others.dao.ProvinceDao;
import luo.rczp.others.model.Province;
import luo.rczp.others.model.School;

@Repository
public class ProvinceDaoImpl extends BaseDaoImpl<Province, java.lang.Long>
		implements ProvinceDao {

	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return Province.class;
	}

	public List<Province> getList() {
			return findAll();
	}
	
	public Province getById(Integer provinceId) {
		return findUniqueByProperty("provinceId", provinceId);
	}

}