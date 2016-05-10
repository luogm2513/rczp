package luo.rczp.core.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luo.rczp.base.BaseService;
import luo.rczp.core.service.CompCentreService;
import luo.rczp.core.dao.CompCentreDao;
import luo.rczp.core.model.CompCentre;

@Service("compCentreService")
@Transactional
public class CompCentreService extends BaseService<CompCentre,java.lang.Long>{

	@Autowired
	private CompCentreDao compCentreDao;
	
	public CompCentreDao getDao() {
		return this.compCentreDao;
	}
	
	public Map<String, Object> getCompData(Map<String, Object> compData, Long userId) {
		CompCentre comp = getDao().get(userId);
		compData.put("recruitCount", comp.getRecruitCount());
		compData.put("receiveCount", comp.getResumeReceive());
		compData.put("inviteCount", comp.getInviteCount());
		compData.put("collectCount", comp.getResumeCollect());
		compData.put("messageCount", comp.getMsgCount());
		return compData;
	}
	
	public CompCentre initCompCentre(Long userId){
		CompCentre compCentre = new CompCentre();
		compCentre.setUserId(userId);
		compCentre.setInviteCount(0);
		compCentre.setMsgCount(0);
		compCentre.setRecruitCount(0);
		compCentre.setRecruitViewCount(0);
		compCentre.setResumeCollect(0);
		compCentre.setResumeReceive(0);
		return getDao().save(compCentre);
	}
	
	public void addRecruit(Long userId){
		CompCentre compCentre = getDao().get(userId);
		compCentre.setRecruitCount(compCentre.getRecruitCount()+1);
		getDao().update(compCentre);
	}
	
	public Integer delRecruit(Long userId){
		CompCentre compCentre = getDao().get(userId);
		compCentre.setRecruitCount(compCentre.getRecruitCount()-1);
		getDao().update(compCentre);
		return compCentre.getRecruitCount();
	}
	
	public void recruitBeViewed(Long userId){
		CompCentre compCentre = getDao().get(userId);
		compCentre.setRecruitViewCount(compCentre.getRecruitViewCount()+1);
		getDao().update(compCentre);
	}
	
	public void recieveResume(Long userId){
		CompCentre compCentre = getDao().get(userId);
		compCentre.setResumeReceive(compCentre.getResumeReceive()+1);
		getDao().update(compCentre);
	}
	
	public Integer collectResume(Long userId){
		CompCentre compCentre = getDao().get(userId);
		compCentre.setResumeCollect(compCentre.getResumeCollect()+1);
		getDao().update(compCentre);
		return compCentre.getResumeCollect();
	}
	
	public Integer delCollect(Long userId){
		CompCentre compCentre = getDao().get(userId);
		compCentre.setResumeCollect(compCentre.getResumeCollect()-1);
		getDao().update(compCentre);
		return compCentre.getResumeCollect();
	}
	
	public Integer invite(Long userId){
		CompCentre compCentre = getDao().get(userId);
		compCentre.setInviteCount(compCentre.getInviteCount()+1);
		getDao().update(compCentre);
		return compCentre.getInviteCount();
	}
	
	public Integer delInvite(Long userId){
		CompCentre compCentre = getDao().get(userId);
		compCentre.setInviteCount(compCentre.getInviteCount()-1);
		getDao().update(compCentre);
		return compCentre.getInviteCount();
	}
	
	public Boolean delApply(Long userId){
		CompCentre compCentre = getDao().get(userId);
		compCentre.setResumeReceive(compCentre.getResumeReceive()-1);
		return getDao().update(compCentre)!=null;
	}
	
	public void receiveMsg(Long userId){
		CompCentre compCentre = getDao().get(userId);
		compCentre.setMsgCount(compCentre.getMsgCount()+1);
		getDao().update(compCentre);
	}
	
	public Integer delMsg(Long userId){
		CompCentre compCentre = getDao().get(userId);
		compCentre.setMsgCount(compCentre.getMsgCount()-1);
		getDao().update(compCentre);
		return compCentre.getMsgCount();
	}
}