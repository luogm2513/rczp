package luo.rczp.colla.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.colla.dao.LeavemsgDao;
import luo.rczp.colla.model.Leavemsg;

@Repository
public class LeavemsgDaoImpl extends BaseDaoImpl<Leavemsg,java.lang.Long>
	implements LeavemsgDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return Leavemsg.class;
	}
	
	public String getMapperName() {
		return "rczp.mapper.LeavemsgMapper";
	}

	public List<Leavemsg> getByUserId(Long userId) {
		Finder f = Finder.create("from Leavemsg where targetUserId =:uId and isDisabled =0 and isDeleted =0 order by leaveTime desc");
		f.setParam("uId", userId);
		return find(f);
	} 
}