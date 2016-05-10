package luo.rczp.others.dao;

import java.io.Serializable;
import java.util.List;

import luo.rczp.base.BaseDao;
import luo.rczp.others.model.Major;

public interface MajorDao extends BaseDao<Major,java.lang.Long> {

	public List<Major> getListByParentId(Integer parentId);

	public Major getById(Integer majorId);
}