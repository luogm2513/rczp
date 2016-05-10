package luo.rczp.others.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luo.rczp.base.BaseService;
import luo.rczp.others.service.TradeService;
import luo.rczp.others.dao.TradeDao;
import luo.rczp.others.model.Area;
import luo.rczp.others.model.Major;
import luo.rczp.others.model.Trade;

@Service("tradeService")
@Transactional
public class TradeService extends BaseService<Trade,java.lang.Long>{

	@Autowired
	private TradeDao tradeDao;
	
	@SuppressWarnings("unchecked")
	public TradeDao getDao() {
		return this.tradeDao;
	}
	
	public List<Trade> getListByParentId(Long parentId) {
		return getDao().getListByParentId(parentId);
	}

	public Trade getById(Long tradeId) {
		return getDao().get(tradeId);
	}
	
	public String getTradeName(Long parentTrade, Long trade) {
		String tradeName = null;
		if(parentTrade != null){
			tradeName = getById(parentTrade).getTradeName();
			if(trade != null){
				tradeName = getById(trade).getTradeName();
				//tradeName = tradeName+"-"+getById(trade).getTradeName();
			}
		}
		return tradeName;
	}
}