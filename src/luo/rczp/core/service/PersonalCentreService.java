package luo.rczp.core.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luo.rczp.base.BaseService;
import luo.rczp.core.service.PersonalCentreService;
import luo.rczp.core.dao.PersonalCentreDao;
import luo.rczp.core.model.CompCentre;
import luo.rczp.core.model.PersonalCentre;

@Service("personalCentreService")
@Transactional
public class PersonalCentreService extends BaseService<PersonalCentre,java.lang.Long>{

	@Autowired
	private PersonalCentreDao personalCentreDao;
	
	public PersonalCentreDao getDao() {
		return this.personalCentreDao;
	}
	
	public Map<String, Object> getPersData(Map<String, Object> persData, Long userId) {
		PersonalCentre pers = getDao().get(userId);
		persData.put("resumeCount", pers.getResCount());
		persData.put("applyCount", pers.getJobApplyCount());
		persData.put("inviteCount", pers.getInviteCount());
		persData.put("collectCount", pers.getJobCollectCount());
		persData.put("messageCount", pers.getMsgCount());
		return persData;
		
	}
	
	public void initPersCentre(Long userId){
		PersonalCentre personalCentre = new PersonalCentre();
		personalCentre.setUserId(userId);
		personalCentre.setInviteCount(0);
		personalCentre.setJobApplyCount(0);
		personalCentre.setJobCollectCount(0);
		personalCentre.setMsgCount(0);
		personalCentre.setResCount(0);
		personalCentre.setResViewCount(0);
		getDao().save(personalCentre);
	}
	
	public void addResume(Long userId){
		PersonalCentre personalCentre = getDao().get(userId);
		personalCentre.setResCount(personalCentre.getResCount()+1);
		getDao().update(personalCentre);
	}
	
	public Integer delResume(Long userId){
		PersonalCentre personalCentre = getDao().get(userId);
		personalCentre.setResCount(personalCentre.getResCount()-1);
		getDao().update(personalCentre);
		return personalCentre.getResCount();
	}
	
	public Integer postResume(Long userId){
		PersonalCentre personalCentre = getDao().get(userId);
		personalCentre.setJobApplyCount(personalCentre.getJobApplyCount()+1);
		getDao().update(personalCentre);
		return personalCentre.getJobApplyCount();
	}
	
	public Integer delApply(Long userId){
		PersonalCentre personalCentre = getDao().get(userId);
		personalCentre.setJobApplyCount(personalCentre.getJobApplyCount()-1);
		getDao().update(personalCentre);
		return personalCentre.getJobApplyCount();
	}
	
	public Integer collectRecruit(Long userId){
		PersonalCentre personalCentre = getDao().get(userId);
		personalCentre.setJobCollectCount(personalCentre.getJobCollectCount()+1);
		getDao().update(personalCentre);
		return personalCentre.getJobCollectCount(); 
	}
	
	public Integer delCollect(Long userId){
		PersonalCentre personalCentre = getDao().get(userId);
		personalCentre.setJobCollectCount(personalCentre.getJobCollectCount()-1);
		getDao().update(personalCentre);
		return personalCentre.getJobCollectCount(); 
	}
	
	public void invite(Long userId){
		PersonalCentre personalCentre = getDao().get(userId);
		personalCentre.setInviteCount(personalCentre.getInviteCount()+1);
		getDao().update(personalCentre);
	}
	
	public Integer delInvite(Long userId){
		PersonalCentre personalCentre = getDao().get(userId);
		personalCentre.setInviteCount(personalCentre.getInviteCount()-1);
		getDao().update(personalCentre);
		return personalCentre.getJobApplyCount(); 
	}
	
	public void resumeBeViewed(Long userId){
		PersonalCentre personalCentre = getDao().get(userId);
		personalCentre.setResViewCount(personalCentre.getResViewCount()+1);
		getDao().update(personalCentre);
	}
	
	public void receiveMsg(Long userId){
		PersonalCentre personalCentre = getDao().get(userId);
		personalCentre.setMsgCount(personalCentre.getMsgCount()+1);
		getDao().update(personalCentre);
	}
	
	public Integer delMsg(Long userId){
		PersonalCentre personalCentre = getDao().get(userId);
		personalCentre.setMsgCount(personalCentre.getMsgCount()-1);
		getDao().update(personalCentre);
		return personalCentre.getMsgCount();
	}


}