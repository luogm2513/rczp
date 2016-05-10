package luo.rczp.colla.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import luo.rczp.base.BaseService;
import luo.rczp.colla.dao.RecruitDao;
import luo.rczp.colla.dao.ResumeDao;
import luo.rczp.colla.dao.ResumeReceiveDao;
import luo.rczp.colla.model.Invite;
import luo.rczp.colla.model.Recruit;
import luo.rczp.colla.model.Resume;
import luo.rczp.colla.model.ResumeReceive;
import luo.rczp.core.model.CompProfile;
import luo.rczp.core.model.PersonalProfile;
import luo.rczp.core.service.CompCentreService;
import luo.rczp.core.service.CompProfileService;
import luo.rczp.core.service.PersonalCentreService;
import luo.rczp.core.service.PersonalProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("applyService")
@Transactional
public class ApplyService extends BaseService<ResumeReceive, java.lang.Long> {

	@Autowired
	private ResumeReceiveDao resumeReceiveDao;
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private RecruitDao recruitDao;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private CompProfileService profileService;
	@Autowired
	private PersonalProfileService personalProfileService;
	@Autowired
	private PersonalCentreService personalCentreService;
	@Autowired
	private CompCentreService compCentreService;
	
	public ResumeReceiveDao getDao() {
		return this.resumeReceiveDao;
	}
	public ResumeDao getResumeDao() {
		return this.resumeDao;
	}
	public RecruitDao getRecruitDao() {
		return this.recruitDao;
	}
	/**
	 * 申请职位并提交简历（个人操作）
	 * @param resumeId
	 * @param recruitId
	 * @param userId
	 * @return
	 */
	public Map<String, Object> apply(Long resumeId, Long recruitId, Long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(!hasApply(recruitId, userId)){
			ResumeReceive resumeReceive = new ResumeReceive();
			resumeReceive.setRecruit(getRecruitDao().get(recruitId));
			resumeReceive.setResume(getResumeDao().get(resumeId));
			resumeReceive.setIsRemoved(0);
			resumeReceive.setIsViewed(0);
			resumeReceive.setReceiveTime(new Date());
			getDao().save(resumeReceive);
			
			Resume resume = getResumeDao().get(resumeId);
			resume.setSubmitCount(resume.getSubmitCount()+1);
			getDao().update(resume);
			
			Recruit recruit = getRecruitDao().get(recruitId);
			recruit.setResumeCount(recruit.getResumeCount()+1);
			getRecruitDao().update(recruit);
			
			Integer applyCount = personalCentreService.postResume(userId);
			compCentreService.recieveResume(getRecruitDao().get(recruitId).getCompany().getUserId());
			
			map.put("applyCount", applyCount);
			map.put("applySuccess", true);
			return map;
		}else{
			map.put("applySuccess", false);
			return map;
		}
	}
	
	/**
	 * 删除职位申请记录（企业个人均可操作）
	 * @param recordId
	 * @return
	 */
	public Map<String, Object> delRecord(Long recordId) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		ResumeReceive resumeReceive = getDao().get(recordId);
		resumeReceive.setIsRemoved(1);
		getDao().update(resumeReceive);
		
		Integer applyCount = personalCentreService.delApply(resumeReceive.getResume().getPerson().getUserId());
		compCentreService.delApply(resumeReceive.getRecruit().getCompany().getUserId());
		
		map.put("applyCount", applyCount);
		map.put("delSuccess", true);
		return map;
	}
	
	public Boolean viewApply(Long recordId){
		ResumeReceive resumeReceive = getDao().get(recordId);
		resumeReceive.setIsViewed(1);
		return getDao().update(resumeReceive)!=null;
	}
	
	
	public Boolean hasApply(Long recruitId, Long userId) {
		Integer count = getApplyCount(recruitId, userId);
		return count>0;
	}
	
	/**
	 * 获取此简历所申请的次数（用来判断是否对应已经申请）
	 */
	public Integer getApplyCount(Long recruitId, Long userId) {
		List<Resume> rList = getResumeDao().getListByUserId(userId);
		Integer count = 0;
		for(int i = 0; i < rList.size(); i++){
			Long resumeId = rList.get(i).getResumeId();
			count = count+getDao().count(recruitId, resumeId);
		}
		return count;
	}
	
	
	/**
	 * 获取接收到的简历列表（企业操作）
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> getApplyList4C(Long userId) {
		List<Map<String, Object>> resumeList = new ArrayList<Map<String, Object>>();
		List<ResumeReceive> recordList = getDao().getRecordListByRecUId(userId);
		for(int j = 0; j < recordList.size(); j++){
			Resume resume = recordList.get(j).getResume();
			Map<String, Object> map = new HashMap<String, Object>();
			PersonalProfile personalProfile = personalProfileService.getById(resume.getPerson().getUserId());
			map = personalProfileService.getProfileParams(map, personalProfile);
			map = resumeService.getResumeParams(map, resume);
            map.put("record", recordList.get(j));
			resumeList.add(map);
		}
		return resumeList;
	}
	
	
	/**
	 * 获取我所申请的职位以及公司的相关内容列表
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> getApplyList4P(Long userId){
		List<Map<String, Object>> recruitList = new ArrayList<Map<String, Object>>();
		List<ResumeReceive> recordList = getDao().getRecordListByResUId(userId);
		//System.out.println("RecordListByResUId:"+JSON.toJSON(recordList));
		for (int i = 0; i < recordList.size(); i++) {
			Recruit recruit = recordList.get(i).getRecruit();
			Map<String, Object> map = new HashMap<String, Object>();
			CompProfile compProfile = profileService.getById(recruit.getCompany().getUserId());
            map = profileService.getProfileParams(map, compProfile);
            map = recruitService.getRecruitParams(map, recruit);
            map.put("record", recordList.get(i));
			recruitList.add(map);
		}
		return recruitList;
	}

}