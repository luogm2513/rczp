package luo.rczp.others.dao;

import java.util.List;

import luo.rczp.base.BaseDao;
import luo.rczp.others.model.Province;

public interface ProvinceDao extends BaseDao<Province,java.lang.Long> {
	public List<Province> getList();

	public Province getById(Integer provinceId);
}