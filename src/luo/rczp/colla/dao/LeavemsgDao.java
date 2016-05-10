package luo.rczp.colla.dao;

import java.io.Serializable;
import java.util.List;

import luo.rczp.base.BaseDao;
import luo.rczp.colla.model.Leavemsg;

public interface LeavemsgDao extends BaseDao<Leavemsg,java.lang.Long> {
	public List<Leavemsg> getByUserId(Long userId);
}