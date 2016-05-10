package luo.rczp.others.dao;

import java.io.Serializable;
import java.util.List;

import luo.rczp.base.BaseDao;
import luo.rczp.others.model.Area;

public interface AreaDao extends BaseDao<Area,java.lang.Long> {
	public List<Area> getListByParentId(Long parentId);
}