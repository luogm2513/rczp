package luo.rczp.others.dao;

import java.util.List;
import java.util.Map;

import luo.rczp.base.BaseDao;
import luo.rczp.others.model.School;

public interface SchoolDao extends BaseDao<School,java.lang.Long> {
	public List<School> getListByProvinceId(Integer provinceId);
	public School getById(Integer schoolId);
}