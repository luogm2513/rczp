package luo.rczp.core.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luo.core.util.BrowseTool;
import luo.rczp.base.BaseService;
import luo.core.util.RequestUtils;
import luo.rczp.core.service.UserLoginService;
import luo.rczp.core.dao.UserLoginDao;
import luo.rczp.core.model.UserLogin;

@Service("userLoginService")
@Transactional
public class UserLoginService extends BaseService<UserLogin,java.lang.String>{

	public void offline(List<String> sessionIds) {
		for(String sessId:sessionIds){
			getDao().deleteById(sessId);
		}
	}
	
	public void online(UserLogin ulogin) {
		getDao().save(ulogin);
	}
	
	public void online(String sessionId, Long userId, HttpServletRequest request) {		
		online(sessionId, userId, RequestUtils.getIpAddr(request), BrowseTool.getOS(request), BrowseTool.getBrowser(request));
	}
	
	public void online(String sessionId, Long userId, String ipAddr, String client, String browser) {
		if(getDao().get(sessionId)==null){
			UserLogin ul = new UserLogin();
			ul.setSessionId(sessionId);
			ul.setUserId(userId);
			ul.setLoginTime((Date) new Date());
			ul.setLastTime((Date) new Date());
			ul.setIpAddr(ipAddr);
			ul.setClient(client);
			ul.setBrowser(browser);
			ul.setOnline(1);
			getDao().save(ul);
		}else{
			UserLogin ul = new UserLogin();
			ul.setSessionId(sessionId);
			ul.setLastTime((Date) new Date());
			ul.setClient(client);
			ul.setBrowser(browser);
			ul.setOnline(1);
			getDao().update(ul);
		}
	}
		
	@Autowired
	private UserLoginDao userLoginDao;
	
	@SuppressWarnings("unchecked")
	public UserLoginDao getDao() {
		return this.userLoginDao;
	}

}