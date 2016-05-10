package luo.rczp.others.dao;

import java.util.List;

import luo.rczp.base.BaseDao;
import luo.rczp.colla.model.Recruit;
import luo.rczp.others.model.RecruitTag;

public interface RecTagDao extends BaseDao<RecruitTag,java.lang.Long> {
	public List<RecruitTag>getTagByRec(Recruit recruit);
}