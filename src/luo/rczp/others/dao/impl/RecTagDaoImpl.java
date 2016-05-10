package luo.rczp.others.dao.impl;

import java.util.List;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.colla.model.Recruit;
import luo.rczp.others.dao.RecTagDao;
import luo.rczp.others.model.RecruitTag;

import org.springframework.stereotype.Repository;

@Repository
public class RecTagDaoImpl extends BaseDaoImpl<RecruitTag,java.lang.Long>
	implements RecTagDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return RecruitTag.class;
	}
	
	public String getMapperName() {
		return "rczp.mapper.RecTagMapper";
	}
	
	public List<RecruitTag>getTagByRec(Recruit recruit){
		Finder f = Finder.create("from RecruitTag where isActive =1 and recruit =:rec and tagType =1");
		f.setParam("rec", recruit);
		return find(f);
	}
}