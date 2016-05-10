package luo.rczp.colla.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import luo.core.util.DateUtil;
import luo.rczp.base.BaseService;
import luo.rczp.colla.dao.InviteDao;
import luo.rczp.colla.dao.ResumeDao;
import luo.rczp.colla.model.Invite;
import luo.rczp.colla.model.Resume;
import luo.rczp.core.model.CompProfile;
import luo.rczp.core.model.PersonalProfile;
import luo.rczp.core.service.CompCentreService;
import luo.rczp.core.service.CompProfileService;
import luo.rczp.core.service.PersonalCentreService;
import luo.rczp.core.service.PersonalProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("inviteService")
@Transactional
public class InviteService extends BaseService<Invite,java.lang.Long>{

	@Autowired
	private InviteDao inviteDao;
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private CompProfileService profileService;
	@Autowired
	private PersonalProfileService personalProfileService;
	@Autowired
	private PersonalCentreService personalCentreService;
	@Autowired
	private CompCentreService compCentreService;
	
	public InviteDao getDao() {
		return this.inviteDao;
	}
	public ResumeDao getResumeDao() {
		return this.resumeDao;
	}
	
	
	/**
	 * 获取邀请对象的简历列表（企业操作）
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> getInviteList4C(Long userId){
		List<Map<String, Object>> resumeList = new ArrayList<Map<String, Object>>();
		List<Invite> recordList = getDao().getInviteListByCompId(userId);
		//System.out.println("RecordListByResUId:"+JSON.toJSON(recordList));
		for (int i = 0; i < recordList.size(); i++) {
			Resume resume = getResumeDao().get(recordList.get(i).getResumeId());
			Map<String, Object> map = new HashMap<String, Object>();
			PersonalProfile personalProfile = personalProfileService.getById(resume.getPerson().getUserId());
			map = personalProfileService.getProfileParams(map, personalProfile);
            map = resumeService.getResumeParams(map, resume);
            map.put("record", recordList.get(i));
			resumeList.add(map);
		}
		return resumeList;
	}
	
	/**
	 * 获取企业邀请的详细信息列表（企业操作）
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> getInviteList4P(Long userId){
		List<Map<String, Object>> inviteList = new ArrayList<Map<String, Object>>();
		List<Invite> recordList = getDao().getInviteListByUserId(userId);
		//System.out.println("RecordListByResUId:"+JSON.toJSON(recordList));
		for (int i = 0; i < recordList.size(); i++) {
			Resume resume = getResumeDao().get(recordList.get(i).getResumeId());
			Map<String, Object> map = new HashMap<String, Object>();
			CompProfile compProfile = profileService.getById(recordList.get(i).getUserId());
			map = resumeService.getResumeParams(map, resume);
            map = profileService.getProfileParams(map, compProfile);
            map.put("record", recordList.get(i));
			inviteList.add(map);
		}
		return inviteList;
	}
	
	public Invite init(Invite invite) {
		invite.setIsDeleted(0);
		invite.setIsDisabled(0);
		invite.setIsRefused(0);
		invite.setIsViewed(0);
		invite.setSentTime(new Date());
		return invite;
	}
	
	public Map<String, Object> invite(Invite invite, String time2meet, Long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(!hasInvite(invite.getInviteType(), invite.getTargetUserId(), userId)){
			invite = init(invite);
			invite.setUserId(userId);
			invite.setTime(DateUtil.parseDate(time2meet, "yyyy-mm-dd HH:mm"));
			getDao().save(invite);
			
			personalCentreService.invite(invite.getTargetUserId());
			Integer inviteCount = compCentreService.invite(userId);
			
			map.put("inviteCount", inviteCount);
			map.put("inviteSuccess", true);
			return map;
		}else{
			map.put("inviteSuccess", false);
			return map;
		}
	}	
	
	/**
	 * 判断是否已经邀请过此人
	 */
	
	public Boolean hasInvite(Integer inviteType, Long targetUserId, Long userId) {
		return getDao().count(inviteType, targetUserId, userId)>0;
	}
	
	public Boolean viewInvite(Long inviteId){
		Invite invite = getDao().get(inviteId);
		invite.setIsViewed(1);
		return getDao().update(invite)!=null;
	}
	
	public Map<String, Object> delInvite(Long inviteId, Integer uType){
		Map<String, Object> map = new HashMap<String, Object>();
		Invite invite = getDao().get(inviteId);
		if(uType == 0){
			invite.setIsDisabled(1);
			Integer inviteCount = compCentreService.delInvite(invite.getUserId());
			personalCentreService.delInvite(invite.getTargetUserId());
			map.put("inviteCount", inviteCount);
		}else if(uType == 1){
			invite.setIsDeleted(1);
			Integer inviteCount = personalCentreService.delInvite(invite.getTargetUserId());
			map.put("inviteCount", inviteCount);
		}
		getDao().update(invite);
		map.put("delSuccess", true);
		return map;
	}

}