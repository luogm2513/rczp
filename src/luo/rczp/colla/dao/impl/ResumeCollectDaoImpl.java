package luo.rczp.colla.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.colla.dao.ResumeCollectDao;
import luo.rczp.colla.model.RecruitCollect;
import luo.rczp.colla.model.ResumeCollect;

@Repository
public class ResumeCollectDaoImpl extends BaseDaoImpl<ResumeCollect,java.lang.Long>
	implements ResumeCollectDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return ResumeCollect.class;
	}
	
	public String getMapperName() {
		return "rczp.mapper.ResumeCollectMapper";
	}
	
	public List<ResumeCollect>getListByUserId(Long userId){
		Finder f = Finder.create("from ResumeCollect where isDisabled =0 and compId= :uId order by collectTime desc");
		f.setParam("uId", userId);
		return find(f);
	}
	
    public Integer count(Long resumeId, Long userId){
		Finder f = Finder.create("from ResumeCollect rc where rc.resumeId= :rsId and rc.compId = :uId");
		f.setParam("rsId", resumeId);
		f.setParam("uId", userId);
		return countQueryResult(f);
    }
}