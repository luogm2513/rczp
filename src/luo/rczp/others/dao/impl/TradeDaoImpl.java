package luo.rczp.others.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.others.dao.TradeDao;
import luo.rczp.others.model.Trade;

@Repository
public class TradeDaoImpl extends BaseDaoImpl<Trade,java.lang.Long>
	implements TradeDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return Trade.class;
	}
	
	public List<Trade> getListByParentId(Long parentId) {
		if(parentId == null ){
			Finder f = Finder.create("from Trade where parentId is null");
			return find(f);
		}else{
			Finder f = Finder.create("from Trade where parentId = :parentId");
			f.setParam("parentId", parentId);
			return find(f);
		}
	}

}