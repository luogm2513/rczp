package luo.rczp.others.dao;

import java.util.List;

import luo.rczp.base.BaseDao;
import luo.rczp.colla.model.Resume;
import luo.rczp.others.model.ResumeTag;

public interface ResTagDao extends BaseDao<ResumeTag,java.lang.Long> {
	public List<ResumeTag>getTagByRes(Resume resume);
}