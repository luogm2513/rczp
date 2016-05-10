package luo.rczp.others.dao.impl;

import java.util.List;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.colla.model.Resume;
import luo.rczp.others.dao.ResTagDao;
import luo.rczp.others.model.ResumeTag;

import org.springframework.stereotype.Repository;

@Repository
public class ResTagDaoImpl extends BaseDaoImpl<ResumeTag,java.lang.Long>
	implements ResTagDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return ResumeTag.class;
	}
	
	public String getMapperName() {
		return "rczp.mapper.ResTagMapper";
	}
	
	public List<ResumeTag>getTagByRes(Resume resume){
		Finder f = Finder.create("from ResumeTag where isActive =1 and resume =:res and tagType =1");
		f.setParam("res", resume);
		return find(f);
	}

}