package luo.rczp.colla.dao;

import java.io.Serializable;
import java.util.List;

import luo.rczp.base.BaseDao;
import luo.rczp.colla.model.Recruit;
import luo.rczp.colla.model.ResumeReceive;

public interface ResumeReceiveDao extends BaseDao<ResumeReceive,java.lang.Long> {
	public List<ResumeReceive>getRecordListByResUId(Long userId);
	public List<ResumeReceive>getRecordListByRecUId(Long userId);
	public Integer count(Long recruitId, Long resumeId);
}