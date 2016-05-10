package luo.rczp.others.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.others.dao.AreaDao;
import luo.rczp.others.model.Area;

@Repository
public class AreaDaoImpl extends BaseDaoImpl<Area,java.lang.Long>
	implements AreaDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return Area.class;
	}

	public List<Area> getListByParentId(Long parentId) {
		if(parentId == null ){
			Finder f = Finder.create("from Area where parentAreaId is null");
			return find(f);
		}else{
			Finder f = Finder.create("from Area where parentAreaId = :parentId");
			f.setParam("parentId", parentId);
			return find(f);
		}
	}
}