package luo.rczp.core.dao;

import java.io.Serializable;
import java.util.List;

import luo.rczp.base.BaseDao;
import luo.rczp.core.model.CompProfile;

public interface CompProfileDao extends BaseDao<CompProfile,java.lang.Long> {
	public CompProfile getByCompName(String LoginName);
}