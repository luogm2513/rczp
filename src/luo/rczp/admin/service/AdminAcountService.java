package luo.rczp.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luo.rczp.base.BaseService;
import luo.rczp.admin.service.AdminAcountService;
import luo.rczp.admin.dao.AdminAcountDao;
import luo.rczp.admin.model.AdminAcount;

@Service("adminAcountService")
@Transactional
public class AdminAcountService extends BaseService<AdminAcount,java.lang.Long>{

	@Autowired
	private AdminAcountDao adminAcountDao;
	
	@SuppressWarnings("unchecked")
	public AdminAcountDao getDao() {
		return this.adminAcountDao;
	}

}