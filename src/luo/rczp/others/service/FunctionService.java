package luo.rczp.others.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luo.rczp.base.BaseService;
import luo.rczp.others.service.FunctionService;
import luo.rczp.others.dao.FunctionDao;
import luo.rczp.others.model.Function;
import luo.rczp.others.model.Trade;

@Service("functionService")
@Transactional
public class FunctionService extends BaseService<Function,java.lang.Long>{

	@Autowired
	private FunctionDao functionDao;
	
	@SuppressWarnings("unchecked")
	public FunctionDao getDao() {
		return this.functionDao;
	}

	public List<Function> getListByParentId(Long parentId) {
		return getDao().getListByParentId(parentId);
	}
	
	public Function getById(Long id) {
		return getDao().get(id);
	}
	
	public String getFunctionName(Long gFunc, Long pFunc, Long func) {
		String funcName = null;
		if(gFunc != null){
			funcName = getById(gFunc).getFuncName();
			if(pFunc != null){
				funcName = getById(pFunc).getFuncName();
				if(func != null){
					String name = getById(func).getFuncName();
					if(!name.equals("其他")){
						funcName = name;
					}
				}
			}
		}
		return funcName;
	}
}