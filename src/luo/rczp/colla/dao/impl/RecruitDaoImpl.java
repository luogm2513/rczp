package luo.rczp.colla.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import luo.common.hibernate3.Finder;
import luo.rczp.base.BaseDaoImpl;
import luo.rczp.colla.dao.RecruitDao;
import luo.rczp.colla.model.Recruit;
import luo.rczp.colla.model.Resume;

@Repository
public class RecruitDaoImpl extends BaseDaoImpl<Recruit, java.lang.Long>
		implements RecruitDao {

	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return Recruit.class;
	}

	public String getMapperName() {
		return "rczp.mapper.RecruitMapper";
	}

	/**
	 * 根据参数搜索简历列表
	 * 
	 * @param params
	 * @return List<Recruit>
	 */
	public List<Recruit> getList(Map<String, Object> params) {
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
		Integer compType = (Integer) params.get("compType");
		Integer jobType = (Integer) params.get("jobType");
		Integer salary = (Integer) params.get("salary");
		String keyword = (String) params.get("keyword");
		Finder f = Finder.create("select distinct rc from RecruitTag rct inner join rct.recruit rc where rc.isDisabled =0 ");
		if (count != null) {
			f.setMaxResults(count);
		}
		if (isCrisitian != null) {
			f.append("and rc.isCrisitian= :isCrisitian ");
			f.setParam("isCrisitian", isCrisitian);
		}
		if (county != null) {
			f.append("and rc.county= :county ");
			f.setParam("county", county);
		} else if (city != null) {
			f.append("and rc.city= :city ");
			f.setParam("city", city);
		} else if (province != null) {
			f.append("and rc.province= :province ");
			f.setParam("province", province);
		}
		if (func != null) {
			f.append("and rc.function= :func ");
			f.setParam("func", func);
		} else if (pFunc != null) {
			f.append("and rc.parentFunction= :pFunc ");
			f.setParam("pFunc", pFunc);
		} else if (gFunc != null) {
			f.append("and rc.grandFunction= :gFunc ");
			f.setParam("gFunc", gFunc);
		}
		if (trade != null) {
			f.append("and rc.trade= :trade ");
			f.setParam("trade", trade);
		} else if (pTrade != null) {
			f.append("and rc.parentTrade= :pTrade ");
			f.setParam("pTrade", pTrade);
		}
		if(jobType != null){
			f.append("and rc.jobType= :jobType ");
			f.setParam("jobType", jobType);
		}
		if(salary != null){
			f.append("and rc.salary= :salary ");
			f.setParam("salary", salary);
		}
		if(keyword != null){
			f.append("and rct.tagName like '%"+keyword+"%' ");
		}
		f.append("order by rc.postTime desc");
		return find(f);
	}

	/**
	 * 根据compId来获取企业招聘列表
	 * 
	 * @return List<Recruit>
	 */
	public List<Recruit> getListByUserId(Long compId) {
		Finder f = Finder.create("select rc from Recruit rc inner join rc.company comp where rc.isDisabled =0 and comp.userId= :cId order by rc.postTime desc");
		f.setParam("cId", compId);
		return find(f);
	}

	/**
	 * 获取最新的招聘信息列表
	 * 
	 * @return List<Recruit>
	 */
	public List<Recruit> getNewRecruitList(Integer count) {
		Finder f = Finder.create("from Recruit where isDisabled =0 order by postTime desc");
		if (count != null) {
			f.setMaxResults(count);
		}
		return find(f);
	}
	
	/**
	 * 获取最新的招聘信息列表(基督徒专区)
	 * 
	 * @return List<Recruit>
	 */
	public List<Recruit> getNewRecruitList4C(Integer count) {
		Finder f = Finder.create("select rc from Recruit rc inner join rc.company comp where comp.isCrisitian =1 and rc.isDisabled =0 order by rc.postTime desc");
		if (count != null) {
			f.setMaxResults(count);
		}
		return find(f);
	}
}