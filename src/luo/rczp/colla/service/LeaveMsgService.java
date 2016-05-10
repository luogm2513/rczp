package luo.rczp.colla.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import luo.rczp.base.BaseService;
import luo.rczp.colla.dao.LeavemsgDao;
import luo.rczp.colla.model.Leavemsg;
import luo.rczp.core.model.CompProfile;
import luo.rczp.core.model.PersonalProfile;
import luo.rczp.core.service.CompCentreService;
import luo.rczp.core.service.CompProfileService;
import luo.rczp.core.service.PersonalCentreService;
import luo.rczp.core.service.PersonalProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("leavemsgService")
@Transactional
public class LeaveMsgService extends BaseService<Leavemsg,java.lang.Long>{

	@Autowired
	private CompProfileService comProfileService;
	@Autowired
	private PersonalProfileService persprofileService;
	@Autowired
	private PersonalCentreService personalCentreService;
	@Autowired
	private CompCentreService compCentreService;
	@Autowired
	private LeavemsgDao leavemsgDao;
	
	public LeavemsgDao getDao() {
		return this.leavemsgDao;
	}
	
	public Map<String, Object> LeaveMsg(Leavemsg msg, Integer targetUserType, Long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		msg.setUserId(userId);
		init(msg);
		getDao().save(msg);
		if(targetUserType == 0){
			compCentreService.receiveMsg(msg.getTargetUserId());
		}else{
			personalCentreService.receiveMsg(msg.getTargetUserId());
		}
		map.put("leaveMsgSuccess", true);
		return map;
	}
	
	public List<Map<String, Object>> getMsgList4P(Long userId) {
		List<Map<String, Object>> msgList = new ArrayList<Map<String, Object>>();
		List<Leavemsg> mList = getDao().getByUserId(userId);
		for (int i = 0; i < mList.size(); i++) {
			Leavemsg msg = mList.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			CompProfile compProfile = comProfileService.getById(msg.getUserId());
			map=comProfileService.getProfileParams(map, compProfile);
			map.put("message", msg);
			msgList.add(map);
		}
		return msgList;
	}
	
	public List<Map<String, Object>> getMsgList4C(Long userId) {
		List<Map<String, Object>> msgList = new ArrayList<Map<String, Object>>();
		List<Leavemsg> mList = getDao().getByUserId(userId);
		for (int i = 0; i < mList.size(); i++) {
			Leavemsg msg = mList.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			PersonalProfile persProfile = persprofileService.getById(msg.getUserId());
			map=persprofileService.getProfileParams(map, persProfile);
			map.put("message", msg);
			msgList.add(map);
		}
		return msgList;
	}
	
	public Boolean view(Long msgId){
		Leavemsg msg = getDao().get(msgId);
		msg.setIsViewed(1);
		return getDao().update(msg)!=null;
	}
	
	public Map<String, Object> delete(Long msgId, Integer userType, Long userId){
		Map<String, Object> map = new HashMap<String, Object>();
		Leavemsg msg = getDao().get(msgId);
		msg.setIsDeleted(1);
		Integer msgCount = 0;
		if(userType == 0){
			msgCount =compCentreService.delMsg(userId);
		}else{
			msgCount = personalCentreService.delMsg(userId);
		}
		map.put("msgCount", msgCount);
		map.put("delSuccess", true);
		return map;
	}
	
	public Leavemsg init(Leavemsg msg){
		msg.setIsDeleted(0);
		msg.setIsDisabled(0);
		msg.setIsViewed(0);
		msg.setLeaveTime(new Date());
		return msg;
	}

}