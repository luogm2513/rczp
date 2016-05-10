package luo.rczp.others.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luo.rczp.base.BaseService;
import luo.rczp.others.dao.ProvinceDao;
import luo.rczp.others.model.Province;

@Service("provinceService")
@Transactional
public class ProvinceService extends BaseService<Province, java.lang.Long> {

	@Autowired
	private ProvinceDao provinceDao;

	@SuppressWarnings("unchecked")
	public ProvinceDao getDao() {
		return this.provinceDao;
	}

	public List<Province> getList() {
		return getDao().getList();
	}

	public Province getProById(Integer provinceId) {
		return getDao().getById(provinceId);
	}
}