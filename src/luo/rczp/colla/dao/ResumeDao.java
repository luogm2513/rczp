package luo.rczp.colla.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import luo.rczp.base.BaseDao;
import luo.rczp.colla.model.Recruit;
import luo.rczp.colla.model.Resume;

public interface ResumeDao extends BaseDao<Resume,java.lang.Long> {
	public List<Resume> getList(Map<String, Object> params);
	public List<Resume> getListByUserId(Long userId);
	public List<Resume> getNewResumeList(Integer count);
	public List<Resume> getNewResumeList4C(Integer count);
}