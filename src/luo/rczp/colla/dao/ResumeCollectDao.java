package luo.rczp.colla.dao;

import java.io.Serializable;
import java.util.List;

import luo.rczp.base.BaseDao;
import luo.rczp.colla.model.RecruitCollect;
import luo.rczp.colla.model.ResumeCollect;

public interface ResumeCollectDao extends BaseDao<ResumeCollect,java.lang.Long> {
	public List<ResumeCollect>getListByUserId(Long userId);
	public Integer count(Long resumeId, Long userId);
}