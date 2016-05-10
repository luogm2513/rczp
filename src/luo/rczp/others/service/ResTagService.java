package luo.rczp.others.service;

import java.util.List;

import luo.rczp.base.BaseService;
import luo.rczp.colla.model.Resume;
import luo.rczp.core.service.CompProfileService;
import luo.rczp.others.dao.FunctionDao;
import luo.rczp.others.dao.ResTagDao;
import luo.rczp.others.dao.SchoolDao;
import luo.rczp.others.dao.TradeDao;
import luo.rczp.others.model.ResumeTag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("resTagService")
@Transactional
public class ResTagService extends BaseService<ResumeTag,java.lang.Long>{

	@Autowired
	private ResTagDao tagDao;
	@Autowired
	private TradeDao tradeDao;
	@Autowired
	private FunctionDao funcDao;
	@Autowired
	private SchoolDao schoolDao;
	@Autowired
	private CompProfileService compService;
	
	@SuppressWarnings("unchecked")
	public ResTagDao getResDao() {
		return this.tagDao;
	}
	
	public TradeDao getTradeDao() {
		return this.tradeDao;
	}
	
	public FunctionDao getFuncDao() {
		return this.funcDao;
	}
	
	public SchoolDao getSchoolDao() {
		return this.schoolDao;
	}

	/**
	 * 为新创建的简历信息添加标签
	 */
	public void addTag4Res(Resume res, String tag1, String tag2){
		if(res.getSchool() != null){
			add(getSchoolDao().getById(res.getSchool()).getSchoolName(), res, 0);
		}
		if(res.getTargetParentTrade() != null){
			add(getTradeDao().get(res.getTargetParentTrade()).getTradeName(), res, 0);
		}
		if(res.getTargetTrade() != null){
			add(getTradeDao().get(res.getTargetTrade()).getTradeName(), res, 0);
		}
		if(res.getTargetGrandFunction() != null){
			add(getFuncDao().get(res.getTargetGrandFunction()).getFuncName(), res, 0);
		}
		if(res.getTargetParentFunction() != null){
			add(getFuncDao().get(res.getTargetParentFunction()).getFuncName(), res, 0);
		}
		if(res.getTargetFunction() != null){
			add(getFuncDao().get(res.getTargetFunction()).getFuncName(), res, 0);
		}
		if(tag1 != null){
			add(tag1, res,1);
		}
        if(tag2 != null){
    		add(tag2, res, 1);
        }
	}
	
	public void add(String tagName, Resume resume, Integer tagType){
		ResumeTag tag = new ResumeTag(null, tagName, tagType, resume, 1);
		getResDao().save(tag);
	}
	
	public List<ResumeTag> getResTag(Resume res){
		List<ResumeTag> resTag = getResDao().getTagByRes(res);
		return resTag;
	}
	
}