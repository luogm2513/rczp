package  luo.rczp.others.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.others.dao.MajorDao;
import luo.rczp.others.model.Function;
import luo.rczp.others.model.Major;
import luo.rczp.others.model.School;

@Repository
public class MajorDaoImpl extends BaseDaoImpl<Major, java.lang.Long>
	implements MajorDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return Major.class;
	}
	
	public List<Major> getListByParentId(Integer parentId) {
		if(parentId == null ){
			Finder f = Finder.create("from Major where parentId is null");
			return find(f);
		}else{
			Finder f = Finder.create("from Major where parentId = :parentId");
			f.setParam("parentId", parentId);
			return find(f);
		}
	}
	
	public Major getById(Integer majorId) {
		return findUniqueByProperty("majorId", majorId);
	}
}