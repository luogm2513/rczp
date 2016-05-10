package luo.rczp.others.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luo.rczp.base.BaseService;
import luo.rczp.others.dao.SchoolDao;
import luo.rczp.others.model.Area;
import luo.rczp.others.model.School;

@Service("schoolService")
@Transactional
public class SchoolService extends BaseService<School, java.lang.Long>{

	@Autowired
	private SchoolDao schoolDao;
	
	@SuppressWarnings("unchecked")
	public SchoolDao getDao() {
		return this.schoolDao;
	}
	
	public School getById(Integer schoolId){
		return getDao().getById(schoolId);
	}
	
	public List<School> getListByProvinceId(Integer provinceId) {
		return getDao().getListByProvinceId(provinceId);
	}

}