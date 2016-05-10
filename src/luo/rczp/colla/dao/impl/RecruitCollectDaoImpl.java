package luo.rczp.colla.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.colla.dao.RecruitCollectDao;
import luo.rczp.colla.model.RecruitCollect;

@Repository
public class RecruitCollectDaoImpl extends BaseDaoImpl<RecruitCollect,java.lang.Long>
	implements RecruitCollectDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return RecruitCollect.class;
	}
	
	public String getMapperName() {
		return "rczp.mapper.RecruitCollectMapper";
	}
	
	public List<RecruitCollect>getListByUserId(Long userId){
		Finder f = Finder.create("from RecruitCollect where isDisabled =0 and userId= :uId order by collectTime desc");
		f.setParam("uId", userId);
		return find(f);
	}
	
    public Integer count(Long recruitId, Long userId){
		Finder f = Finder.create("from RecruitCollect rc where rc.recruitId= :rcId and rc.userId = :uId");
		f.setParam("rcId", recruitId);
		f.setParam("uId", userId);
		return countQueryResult(f);
    }

}