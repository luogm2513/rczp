package luo.rczp.colla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luo.rczp.base.BaseService;
import luo.rczp.colla.service.SysMsgService;
import luo.rczp.colla.dao.SysMsgDao;
import luo.rczp.colla.model.SysMsg;

@Service("sysMsgService")
@Transactional
public class SysMsgService extends BaseService<SysMsg,java.lang.Long>{

	@Autowired
	private SysMsgDao sysMsgDao;
	
	@SuppressWarnings("unchecked")
	public SysMsgDao getDao() {
		return this.sysMsgDao;
	}

}