package luo.rczp.colla.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luo.core.util.RequestUtils;
import luo.rczp.base.BaseService;
import luo.rczp.colla.service.UserLogService;
import luo.rczp.colla.dao.UserLogDao;
import luo.rczp.colla.model.UserLog;

@Service("userLogService")
@Transactional
public class UserLogService extends BaseService<UserLog,java.lang.Long>{

	@Autowired
	private UserLogDao userLogDao;
	
	public UserLogDao getDao() {
		return this.userLogDao;
	}
	
	public void add(Short opUserType, Long opUserId, String opUserName,
	Integer opType, Integer targetType, Long targetId, String opUserIp){
		UserLog log = new UserLog();
		log.setOpUserType(opUserType);
		log.setOpType(opType);
		log.setOpUserId(opUserId);
		log.setOpUserName(opUserName);
		log.setTargetType(targetType);
		log.setTargetId(targetId);
		log.setOpTime( new Date());
		log.setOpUserIp(opUserIp);
		getDao().save(log);
	}
	
	public void add(Short opUserType, Long opUserId, String opUserName,
	Integer opType, Integer targetType, Long targetId,HttpServletRequest request ){
		UserLog log = new UserLog();
		log.setOpUserType(opUserType);
		log.setOpType(opType);
		log.setOpUserId(opUserId);
		log.setOpUserName(opUserName);
		log.setTargetType(targetType);
		log.setTargetId(targetId);
		log.setOpTime( new Date());
		log.setOpUserIp(RequestUtils.getIpAddr(request));
		getDao().save(log);
	}

}