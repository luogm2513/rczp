package luo.rczp.core.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luo.rczp.base.BaseService;
import luo.rczp.core.service.CompProfileService;
import luo.rczp.core.dao.CompProfileDao;
import luo.rczp.core.model.CompProfile;
import luo.rczp.core.model.PersonalProfile;
import luo.rczp.others.service.AreaService;
import luo.rczp.others.service.DicService;
import luo.rczp.others.service.TradeService;

@Service("compProfileService")
@Transactional
public class CompProfileService extends
		BaseService<CompProfile, java.lang.Long> {

	@Autowired
	private CompProfileDao compProfileDao;
	@Autowired
	private DicService dicService;
	@Autowired
	private TradeService tradeService;
	@Autowired
	private AreaService areaService;

	public CompProfileDao getDao() {
		return this.compProfileDao;
	}

	public CompProfile save(CompProfile company) {
		CompProfile user = getDao().save(company);
		return user;
	}

	public CompProfile getById(Long userId) {
		CompProfile user = getDao().findUniqueByProperty("userId", userId);
		return user;
	}
	
	public CompProfile getByCompName(String loginName){
		CompProfile user = getDao().getByCompName(loginName);
		return user;
	}
	
	public Map<String, Object> getProfileParams(Map<String, Object> map, CompProfile profile){
		String tradeName = tradeService.getTradeName(profile.getParentTrade(),profile.getTrade());
		String areaName = areaService.getAreaName(profile.getProvince(), profile.getCity(), profile.getCounty());
		String compTypeName = dicService.getCompTypeName(profile.getCompType());
		String compScale = dicService.getCompScale(profile.getCompScale());
		String creatTime = dicService.getCreatTime(profile.getCreatTime());
		map.put("compProfile", profile);
		map.put("tradeName", tradeName);
		map.put("areaName", areaName);
		map.put("compTypeName", compTypeName);
		map.put("compScale", compScale);
		map.put("creatTime", creatTime);
		return map;
	}
}