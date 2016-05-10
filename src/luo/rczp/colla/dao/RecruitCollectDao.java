package luo.rczp.colla.dao;

import java.io.Serializable;
import java.util.List;

import luo.rczp.base.BaseDao;
import luo.rczp.colla.model.RecruitCollect;
import luo.rczp.colla.model.ResumeReceive;

public interface RecruitCollectDao extends BaseDao<RecruitCollect,java.lang.Long> {
	public List<RecruitCollect>getListByUserId(Long userId);
	public Integer count(Long recruitId, Long userId);
}