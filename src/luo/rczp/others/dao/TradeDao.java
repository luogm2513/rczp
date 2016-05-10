package luo.rczp.others.dao;

import java.util.List;

import luo.rczp.base.BaseDao;
import luo.rczp.others.model.Trade;

public interface TradeDao extends BaseDao<Trade,java.lang.Long> {
	public List<Trade> getListByParentId(Long parentId);
}