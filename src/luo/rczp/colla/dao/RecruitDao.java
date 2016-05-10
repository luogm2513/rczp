package luo.rczp.colla.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import luo.rczp.base.BaseDao;
import luo.rczp.colla.model.Recruit;
import luo.rczp.colla.model.Resume;
import luo.rczp.others.model.Area;

public interface RecruitDao extends BaseDao<Recruit,java.lang.Long> {
	public List<Recruit> getList(Map<String,Object> params);
	public List<Recruit> getListByUserId(Long compId);
	public List<Recruit> getNewRecruitList(Integer count);
	public List<Recruit> getNewRecruitList4C(Integer count);
}