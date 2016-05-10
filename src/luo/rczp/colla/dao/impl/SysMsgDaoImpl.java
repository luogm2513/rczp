package luo.rczp.colla.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.rczp.base.BaseDaoImpl;
import luo.rczp.colla.dao.SysMsgDao;
import luo.rczp.colla.model.SysMsg;

@Repository
public class SysMsgDaoImpl extends BaseDaoImpl<SysMsg,java.lang.Long>
	implements SysMsgDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return SysMsg.class;
	}
	
	public String getMapperName() {
		return "rczp.mapper.SysMsgMapper";
	}

}