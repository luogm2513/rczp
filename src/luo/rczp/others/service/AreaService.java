package luo.rczp.others.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luo.rczp.base.BaseService;
import luo.rczp.others.service.AreaService;
import luo.rczp.others.dao.AreaDao;
import luo.rczp.others.model.Area;

@Service("areaService")
@Transactional
public class AreaService extends BaseService<Area, java.lang.Long> {

	@Autowired
	private AreaDao areaDao;

	public AreaDao getDao() {
		return this.areaDao;
	}

	public List<Area> getListByParentId(Long parentId) {
		return getDao().getListByParentId(parentId);
	}

	public Area getById(Long areaId) {
		return getDao().get(areaId);
	}

	public String getAreaName(Long province, Long city, Long county) {
		String areaName = null;
		if(province != null){
			areaName = getById(province).getAreaName();
			if(city != null){
				areaName = areaName+"-"+getById(city).getAreaName();
				if(county != null){
					areaName = areaName+"-"+getById(county).getAreaName();
				}
			}
		}
		return areaName;
	}
}