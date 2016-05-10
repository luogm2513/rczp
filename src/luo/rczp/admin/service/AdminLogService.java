package luo.rczp.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luo.rczp.base.BaseService;
import luo.rczp.admin.service.AdminLogService;
import luo.rczp.admin.dao.AdminLogDao;
import luo.rczp.admin.model.AdminLog;

@Service("adminLogService")
@Transactional
public class AdminLogService extends BaseService<AdminLog,java.lang.Long>{

	@Autowired
	private AdminLogDao adminLogDao;
	
	@SuppressWarnings("unchecked")
	public AdminLogDao getDao() {
		return this.adminLogDao;
	}

}