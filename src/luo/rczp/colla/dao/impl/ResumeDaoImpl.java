package luo.rczp.colla.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.colla.dao.ResumeDao;
import luo.rczp.colla.model.Recruit;
import luo.rczp.colla.model.Resume;

@Repository
public class ResumeDaoImpl extends BaseDaoImpl<Resume,java.lang.Long>
	implements ResumeDao{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return Resume.class;
	}

	public List<Resume> getList(Map<String, Object> params) {
		Integer count = (Integer) params.get("count");
		Integer isCrisitian = (Integer) params.get("isCrisitian");
		Long province = (Long) params.get("province");
		Long city = (Long) params.get("city");
		Long county = (Long) params.get("county");
		Long gFunc = (Long) params.get("gFunc");
		Long pFunc = (Long) params.get("pFunc");
		Long func = (Long) params.get("func");
		Long pTrade = (Long) params.get("pTrade");
		Long trade = (Long) params.get("trade");
		Integer award = (Integer) params.get("award");
		Integer workYear = (Integer) params.get("workYear");
		String keyword = (String) params.get("keyword");
		Finder f = Finder.create("select distinct rs from ResumeTag rst inner join rst.resume rs where rs.isDisabled =0 and rs.isPosted = 1 ");
		if(count != null){
			f.setMaxResults(count);
		}
		if (isCrisitian != null) {
			f.append("and rs.isCrisitian= :isCrisitian ");
			f.setParam("isCrisitian", isCrisitian);
		}
		if (county != null) {
			f.append("and rs.targetCounty= :county ");
			f.setParam("county", county);
		} else if (city != null) {
			f.append("and rs.targetCity= :city ");
			f.setParam("city", city);
		} else if (province != null) {
			f.append("and rs.targetProvince= :province ");
			f.setParam("province", province);
		}
		if (func != null) {
			f.append("and rs.targetFunction= :func ");
			f.setParam("func", func);
		} else if (pFunc != null) {
			f.append("and rs.targetParentFunction= :pFunc ");
			f.setParam("pFunc", pFunc);
		} else if (gFunc != null) {
			f.append("and rs.targetGrandFunction= :gFunc ");
			f.setParam("gFunc", gFunc);
		}
		if (trade != null) {
			f.append("and rs.targetTrade= :trade ");
			f.setParam("trade", trade);
		} else if (pTrade != null) {
			f.append("and rs.targetParentTrade= :pTrade ");
			f.setParam("pTrade", pTrade);
		}
		if(award != null){
			f.append("and rs.award= :award ");
			f.setParam("award", award);
		}
		if(workYear != null){
			f.append("and rs.workYear= :workYear ");
			f.setParam("workYear", workYear);
		}
		if(keyword != null){
			f.append("and rst.tagName like '%"+keyword+"%' ");
		}
		f.append("order by rs.modifyTime desc");
		return find(f);
		}
/**	
 * 根据userId来获取个人简历列表
 */
	public List<Resume> getListByUserId(Long userId){
		Finder f = Finder.create("select rs from Resume rs inner join rs.person pers where rs.isDisabled =0 and pers.userId= :uId order by rs.modifyTime desc");
		f.setParam("uId", userId);
		return find(f);
	}
	
	/**
	 * 
	 * @return List<Recruit>
	 */
	public List<Resume> getNewResumeList(Integer count) {
		Finder f = Finder.create("from Resume where isDisabled =0 and isPosted =1 order by modifyTime desc");
		if (count != null) {
			f.setMaxResults(count);
		}
		return find(f);
	}
	
	/**
	 * 获取最新的招聘信息列表
	 * 
	 * @return List<Recruit>
	 */
	public List<Resume> getNewResumeList4C(Integer count) {
		Finder f = Finder.create("select rs from Resume rs inner join rs.person pers where pers.isCrisitian =1 and rs.isDisabled =0 and rs.isPosted =1 order by rs.modifyTime desc");
		if (count != null) {
			f.setMaxResults(count);
		}
		return find(f);
	}
}