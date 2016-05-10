package  luo.rczp.others.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.others.dao.FunctionDao;
import luo.rczp.others.model.Function;
import luo.rczp.others.model.Trade;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function,java.lang.Long>
	implements FunctionDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return Function.class;
	}
	
	public List<Function> getListByParentId(Long parentId) {
		if(parentId == null ){
			Finder f = Finder.create("from Function where parentId is null");
			return find(f);
		}else{
			Finder f = Finder.create("from Function where parentId = :parentId");
			f.setParam("parentId", parentId);
			return find(f);
		}
	}

}