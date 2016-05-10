package luo.rczp.others.service;

import java.util.List;

import luo.rczp.base.BaseService;
import luo.rczp.colla.model.Recruit;
import luo.rczp.colla.model.Resume;
import luo.rczp.core.service.CompProfileService;
import luo.rczp.others.dao.FunctionDao;
import luo.rczp.others.dao.SchoolDao;
import luo.rczp.others.dao.RecTagDao;
import luo.rczp.others.dao.TradeDao;
import luo.rczp.others.model.RecruitTag;
import luo.rczp.others.model.ResumeTag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("recTagService")
@Transactional
public class RecTagService extends BaseService<RecruitTag,java.lang.Long>{

	@Autowired
	private RecTagDao tagDao;
	@Autowired
	private TradeDao tradeDao;
	@Autowired
	private FunctionDao funcDao;
	@Autowired
	private SchoolDao schoolDao;
	@Autowired
	private CompProfileService compService;
	
	@SuppressWarnings("unchecked")
	public RecTagDao getRecDao() {
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
	 * 为新创建的职位信息添加标签
	 */
	public void addTag4Rec(Recruit rec, String tag1, String tag2){
		add(compService.getById(rec.getCompany().getUserId()).getCompName(), rec, 0);
		if(rec.getParentTrade() != null){
			add(getTradeDao().get(rec.getParentTrade()).getTradeName(), rec, 0);
		}
		if(rec.getTrade() != null){
			add(getTradeDao().get(rec.getTrade()).getTradeName(), rec, 0);
		}
		if(rec.getGrandFunction() != null){
			add(getFuncDao().get(rec.getGrandFunction()).getFuncName(), rec, 0);
		}
		if(rec.getParentFunction() != null){
			add(getFuncDao().get(rec.getParentFunction()).getFuncName(), rec, 0);
		}
        if(rec.getFunction() != null){
        	add(getFuncDao().get(rec.getFunction()).getFuncName(), rec, 0);
        }
		if(tag1 != null){
			add(tag1, rec, 1);
		}
        if(tag2 != null){
    		add(tag2, rec, 1);
        }
	}

	public void add(String tagName, Recruit recruit, Integer tagType){
		RecruitTag tag = new RecruitTag(null, tagName, tagType, recruit, 1);
		getRecDao().save(tag);
	}
	
	public List<RecruitTag> getRecTag(Recruit rec){
		List<RecruitTag> recTag = getRecDao().getTagByRec(rec);
		return recTag;
	}
}