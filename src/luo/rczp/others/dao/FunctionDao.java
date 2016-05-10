package luo.rczp.others.dao;

import java.io.Serializable;
import java.util.List;

import luo.rczp.base.BaseDao;
import luo.rczp.others.model.Function;

public interface FunctionDao extends BaseDao<Function,java.lang.Long> {
	public List<Function> getListByParentId(Long parentId);
}