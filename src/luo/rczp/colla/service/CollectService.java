package luo.rczp.colla.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import luo.rczp.base.BaseService;
import luo.rczp.colla.dao.RecruitCollectDao;
import luo.rczp.colla.dao.RecruitDao;
import luo.rczp.colla.dao.ResumeCollectDao;
import luo.rczp.colla.dao.ResumeDao;
import luo.rczp.colla.model.Recruit;
import luo.rczp.colla.model.RecruitCollect;
import luo.rczp.colla.model.Resume;
import luo.rczp.colla.model.ResumeCollect;
import luo.rczp.core.model.CompProfile;
import luo.rczp.core.model.PersonalProfile;
import luo.rczp.core.service.CompCentreService;
import luo.rczp.core.service.CompProfileService;
import luo.rczp.core.service.PersonalCentreService;
import luo.rczp.core.service.PersonalProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("collectService")
@Transactional
public class CollectService extends BaseService<ResumeCollect, java.lang.Long> {
	
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private CompProfileService profileService;
	@Autowired
	private PersonalProfileService personalProfileService;
	@Autowired
	private CompCentreService compCentreService;
	@Autowired
	private PersonalCentreService persCentreService;
	@Autowired
	private ApplyService applyService;
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private ResumeCollectDao resumeCollectDao;
	@Autowired
	private RecruitDao recruitDao;
	@Autowired
	private RecruitCollectDao recruitCollectDao;
	
	public ResumeDao getResumeDao() {
		return this.resumeDao;
	}
	public RecruitDao getRecruitDao() {
		return this.recruitDao;
	}
	public ResumeCollectDao getResumeCollectDao() {
		return this.resumeCollectDao;
	}
	public RecruitCollectDao getRecruitCollectDao() {
		return this.recruitCollectDao;
	}

	/**
	 * 收藏简历（企业操作）
	 */
	public Map<String, Object> collectResume(Long resumeId, Long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(!hasCollect(resumeId, userId, 0)){
			ResumeCollect resumeCollect = new ResumeCollect();
			resumeCollect.setResumeId(resumeId);
			resumeCollect.setCompId(userId);
			resumeCollect.setCollectTime(new Date());
			resumeCollect.setIsDisabled(0);
			getResumeCollectDao().save(resumeCollect);
			Integer collectCount = compCentreService.collectResume(userId);
			map.put("collectCount", collectCount);
			map.put("collectSuccess", true);
			return map;
		}else {
			map.put("collectSuccess", false);
			return map;
		}
	}
	
	/**
	 * 收藏职位（个人操作）
	 */
	public Map<String, Object> collectRecruit(Long recruitId, Long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(!hasCollect(recruitId, userId, 1)){
			RecruitCollect recruitCollect = new RecruitCollect();
			recruitCollect.setRecruitId(recruitId);
			recruitCollect.setUserId(userId);
			recruitCollect.setCollectTime(new Date());
			recruitCollect.setIsDisabled(0);
			getRecruitCollectDao().save(recruitCollect);
			Integer collectCount = persCentreService.collectRecruit(userId);
			map.put("collectCount", collectCount);
			map.put("collectSuccess", true);
			return map;
		}else {
			map.put("collectSuccess", false);
			return map;
		}
	}
	/**
	 * 获取收藏的简历的列表（企业操作）
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> getCollectResumeList(Long userId){
		List<Map<String, Object>> resumeList = new ArrayList<Map<String, Object>>();
		List<ResumeCollect> collectList = getResumeCollectDao().getListByUserId(userId);
		for(int i = 0; i < collectList.size(); i++){
			Resume resume = getResumeDao().get(collectList.get(i).getResumeId());
			Map<String, Object> map = new HashMap<String, Object>();
			PersonalProfile personalProfile = personalProfileService.getById(resume.getPerson().getUserId());
            map = personalProfileService.getProfileParams(map, personalProfile);
            map = resumeService.getResumeParams(map, resume);
            map.put("collect", collectList.get(i));
            resumeList.add(map);
		}
		return resumeList;
	}
	

	/**
	 * 获取个人收藏的职位信息列表（企业操作）
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> getCollectRecruitList(Long userId){
		List<Map<String, Object>> recruitList = new ArrayList<Map<String, Object>>();
		List<RecruitCollect> collectList = getRecruitCollectDao().getListByUserId(userId);
		for(int i = 0; i < collectList.size(); i++){
			Recruit recruit = getRecruitDao().get(collectList.get(i).getRecruitId());
			Map<String, Object> map = new HashMap<String, Object>();
			CompProfile compProfile = profileService.getById(recruit.getCompany().getUserId());
			Integer applyCount = applyService.getApplyCount(collectList.get(i).getRecruitId(), userId);
            map = profileService.getProfileParams(map, compProfile);
            map = recruitService.getRecruitParams(map, recruit);
            map.put("collect", collectList.get(i));
            map.put("applyCount", applyCount);
			recruitList.add(map);
		}
		return recruitList;
	}
	
	
	/**
	 * 获取此简历、职位被收藏次数（用来判断是否已经收藏）
	 */
	public Boolean hasCollect(Long targetId, Long userId, Integer collectType) {
		Integer count = 0;
		if(collectType == 0) {
			count = getResumeCollectDao().count(targetId, userId);
		}else if(collectType == 1) {
			count = getRecruitCollectDao().count(targetId, userId);
		}
		return count>0;
	}
	
	public Map<String, Object> delResumeCollect(Long collectId){
		Map<String, Object> map = new HashMap<String, Object>();
		ResumeCollect resumeCollect = getResumeCollectDao().get(collectId);
		resumeCollect.setIsDisabled(1);
		getResumeCollectDao().update(resumeCollect);
		Integer collectCount = compCentreService.delCollect(resumeCollect.getCompId());
		map.put("collectCount", collectCount);
		map.put("delSuccess", true);
		return map;
	}
	
	public Map<String, Object> delRecruitCollect(Long collectId){
		Map<String, Object> map = new HashMap<String, Object>();
		RecruitCollect recruitCollect = getRecruitCollectDao().get(collectId);
		recruitCollect.setIsDisabled(1);
		getRecruitCollectDao().update(recruitCollect);
		Integer collectCount = persCentreService.delCollect(recruitCollect.getUserId());
		map.put("collectCount", collectCount);
		map.put("delSuccess", true);
		return map;
	}
}