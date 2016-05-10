package luo.rczp.colla.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.colla.dao.ResumeReceiveDao;
import luo.rczp.colla.model.ResumeReceive;

@Repository
public class ResumeReceiveDaoImpl extends BaseDaoImpl<ResumeReceive,java.lang.Long>
	implements ResumeReceiveDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return ResumeReceive.class;
	}
	
	public String getMapperName() {
		return "rczp.mapper.ResumeReceiveMapper";
	}
	
	public List<ResumeReceive> getRecordListByResUId(Long userId){
		Finder f = Finder.create("select rr from ResumeReceive rr inner join rr.resume res inner join res.person pers where pers.userId = :rId and rr.isRemoved =0 order by rr.receiveTime desc");
		f.setParam("rId", userId);
		return find(f);
	}
	
	public List<ResumeReceive> getRecordListByRecUId(Long userId){
		Finder f = Finder.create("select rr from ResumeReceive rr inner join rr.recruit rec inner join rec.company comp where comp.userId = :rId and rr.isRemoved =0 order by rr.receiveTime desc");
		f.setParam("rId", userId);
		return find(f);
	}
	
    public Integer count(Long recruitId, Long resumeId){
		Finder f = Finder.create("from ResumeReceive rr inner join rr.resume res inner join rr.recruit rec where res.resumeId= :rsId and rec.id = :rcId");
		f.setParam("rsId", resumeId);
		f.setParam("rcId", recruitId);
		return countQueryResult(f);
    }
}