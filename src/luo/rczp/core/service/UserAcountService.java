package luo.rczp.core.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import luo.common.security.BadCredentialsException;
import luo.common.security.RealNameNotFoundException;
import luo.core.Constants;
import luo.core.security.encoder.PwdEncoder;
import luo.core.util.StrUtils;
import luo.rczp.base.BaseService;
import luo.rczp.core.dao.UserAcountDao;
import luo.rczp.core.model.UserAcount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

@Service("userAcountService")
@Transactional
public class UserAcountService extends BaseService<UserAcount, java.lang.Long> {

	
	@Autowired
	private PwdEncoder pwdEncoder;
	@Autowired
	private UserAcountDao userAcountDao;
	@Autowired
	private CompCentreService compCentreService;
	@Autowired
	private PersonalCentreService persCentreService;
	@Autowired
	private PersonalProfileService persService;
	@Autowired
	private CompProfileService compService;

	public UserAcountDao getDao() {
		return this.userAcountDao;
	}

	public UserAcount save(UserAcount userAcount) {
		userAcount.setPassword(pwdEncoder.encodePassword(userAcount.getPassword()));
		userAcount.setRegisterTime(new Date());
		userAcount.setLoginCount(0);
		userAcount.setIsDisabled(0);
		userAcount = getDao().save(userAcount);
		if(userAcount.getUserType() == 0){
			compCentreService.initCompCentre(userAcount.getUserId());
		}else if(userAcount.getUserType() == 1){
			persCentreService.initPersCentre(userAcount.getUserId());
		}
		return userAcount;
	}

	public UserAcount login(Integer userType, String loginName, String password, String ip)
			throws RealNameNotFoundException, BadCredentialsException {
		UserAcount user = null;
		if(StrUtils.checkEmail(loginName)){
			user = getByEmail(loginName);
			if (user == null) {
				throw new RealNameNotFoundException("error.usernameNotExist");
			}else if (!user.getUserType().equals(userType)){
				throw new BadCredentialsException("error.userTypeNotRight");
			}
		}else{
			if(userType == 0){
				 if(compService.getByCompName(loginName) != null){
						user = findById(compService.getByCompName(loginName).getUserId());
				    }else{
				    	throw new RealNameNotFoundException("error.usernameNotExist");
				    }
			}
			else if(userType == 1){
				 if(persService.getByRealName(loginName) != null){
						user = findById(persService.getByRealName(loginName).getUserId());
				    }else{
				    	throw new RealNameNotFoundException("error.usernameNotExist");
				    }
			}
		}

		if (!pwdEncoder.isPasswordValid(user.getPassword(), password)) {
			updateLoginError(user.getUserId(), ip);
			throw new BadCredentialsException("error.passwordInvalid");
		}
		if (user.getIsDisabled() == UserAcount.STATUS_IS_DISABLED) {
			throw new BadCredentialsException("error.userIsDisabled");
		}
		updateLoginSuccess(user.getUserId(), ip);
		return user;
	}

	public void updateLoginSuccess(Long userId, String ip) {
		UserAcount user = findById(userId);
		Date now = new Date(System.currentTimeMillis());

		user.setLoginCount(user.getLoginCount() + 1);
		user.setLastLoginIp(ip);
		user.setLastLoginTime(now);

		user.setErrorCount(0);
		user.setErrorTime(null);
		user.setErrorIp(null);
	}

	public void updateLoginError(Long userId, String ip) {
		UserAcount user = findById(userId);
		Date now = new Date(System.currentTimeMillis());
		// OrgSetting orgSetting = orgSettingDao.getByUserId(userId);
		int errorInterval = Constants.ERROR_INTERVAL;
		Date errorTime = user.getErrorTime();

		user.setErrorIp(ip);
		if (errorTime == null
				|| errorTime.getTime() + errorInterval * 60 * 1000 < now
						.getTime()) {
			user.setErrorTime(now);
			user.setErrorCount(1);
		} else {
			user.setErrorCount(user.getErrorCount() + 1);
		}
	}

	public UserAcount getByEmail(String email){
		return getDao().getByEmail(email);
	}

	@Transactional(readOnly = true)
	public UserAcount findById(Long id) {
		UserAcount entity = getDao().get(id);
		return entity;
	}

	public UserAcount activeLogin(UserAcount user, String ip) {
		updateLoginSuccess(user.getUserId(), ip);
		return user;
	}

	public boolean emailExist(String email) {
		return getDao().getByEmail(email) != null;
	}
	
	public UserAcount initUser(UserAcount user) {
	      return user;
	}
	
	public Map<String, Object> getUserData(Long userId, Integer userType) {
		Map<String, Object> userData = new HashMap<String, Object>();
        if(userType == 0){
        	userData = compCentreService.getCompData(userData, userId);
        }else{
        	userData = persCentreService.getPersData(userData, userId);
        }
		return userData;
	}

}