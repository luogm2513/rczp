package luo.common.service;

import static luo.core.Constants.USER_COOKIE;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import luo.common.pojo.Authentication;
import luo.common.security.BadCredentialsException;
import luo.common.security.RealNameNotFoundException;
import luo.common.web.session.SessionProvider;
import luo.rczp.core.model.CompProfile;
import luo.rczp.core.model.PersonalProfile;
import luo.rczp.core.model.UserAcount;
import luo.rczp.core.service.CompProfileService;
import luo.rczp.core.service.PersonalProfileService;
import luo.rczp.core.service.UserAcountService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

@Service("authService")
@Transactional
public class AuthService {
	/**
	 * 认证信息session key
	 */
	public static final String AUTH_KEY = "rczp_auth";	
	
	@Autowired
	private UserAcountService userAcountService;
	@Autowired
	private PersonalProfileService persService;
	@Autowired
	private CompProfileService compService;

	public Authentication login(Integer userType, String loginName, String password, String ip,
			HttpServletRequest request, HttpServletResponse response,
			SessionProvider session) throws RealNameNotFoundException,
			BadCredentialsException {
		UserAcount user = userAcountService.login(userType, loginName, password, ip);
		Authentication auth = new Authentication();
		auth.setUid(user.getUserId());
		if(userType == 1){
			if(persService.getById(user.getUserId()) != null){
				PersonalProfile pers = persService.getById(user.getUserId());
				auth.setUsername(pers.getRealName());
			}else{
				auth.setUsername(user.getEmail());
			}
		} else{
			if(compService.getById(user.getUserId()) != null){
				CompProfile comp = compService.getById(user.getUserId());
	            auth.setUsername(comp.getCompName());		
			}else{
				auth.setUsername(user.getEmail());
			}
		} 
		auth.setEmail(user.getEmail());
		auth.setLoginIp(ip);
		save(session, request, response, auth);
		//session.setAttribute(request, response, AUTH_KEY, auth);
		response.addCookie(createCookie(request,USER_COOKIE,user.getUserId().toString()));
		return auth;
	}
	
	public Authentication activeLogin(UserAcount user, String ip,
			HttpServletRequest request, HttpServletResponse response,
			SessionProvider session) {
		userAcountService.activeLogin(user, ip);
		Authentication auth = new Authentication();
		auth.setUid(user.getUserId());
		if(user.getUserType() == 1){
			if(persService.getById(user.getUserId()) != null){
				PersonalProfile pers = persService.getById(user.getUserId());
				auth.setUsername(pers.getRealName());
			}else{
				auth.setUsername(user.getEmail());
			}
		} else{
			if(compService.getById(user.getUserId()) != null){
				CompProfile comp = compService.getById(user.getUserId());
	            auth.setUsername(comp.getCompName());		
			}else{
				auth.setUsername(user.getEmail());
			}
		} 
		auth.setEmail(user.getEmail());
		auth.setLoginIp(ip);
		save(session, request, response, auth);
		//session.setAttribute(request, response, AUTH_KEY, auth);
		response.addCookie(createCookie(request,USER_COOKIE,user.getUserId().toString()));
		return auth;
	}
	
	public Authentication get(HttpServletRequest request, SessionProvider session) {
		Serializable object = session.getAttribute(request, AUTH_KEY);
		//System.out.println("AuthService.get:"+JSON.toJSONString(object));
		//if(object!=null)
		//	System.out.println(object.getClass());
		Authentication auth=null;
		if(object!=null){
			auth = JSON.parseObject(object.toString(), Authentication.class);			
		}
		return auth;
	}

	public Authentication retrieve(HttpServletRequest request, SessionProvider session) {
		long current = System.currentTimeMillis();
		// 是否刷新数据库
		/*if (refreshTime < current) {
			refreshTime = getNextRefreshTime(current, interval);
			int count = dao.deleteExpire(new Date(current - timeout));
			log.info("refresh Authentication, delete count: "+ count);
		}*/
		Serializable object = session.getAttribute(request, AUTH_KEY);
		//System.out.println("AuthService.retrieve:"+object);		
		Authentication auth=null;
		if(object!=null){
			auth = JSON.parseObject(object.toString(), Authentication.class);			
			if (auth != null && auth.getUpdateTime().getTime() + timeout > current) {
				auth.setUpdateTime(new Date(current));
				return auth;
			}
		}		
		return null;
	}

	public Long retrieveUserIdFromSession(SessionProvider session,
			HttpServletRequest request) {
		/*String authId = (String) session.getAttribute(request, AUTH_KEY);
		if (authId == null) {
			return null;
		}*/
		Authentication auth = retrieve(request,session);
		if (auth == null) {
			return null;
		}
		return auth.getUid();
	}

	public void storeAuthToSession(SessionProvider session,
			HttpServletRequest request, HttpServletResponse response,
			Authentication auth) {
		auth.setUpdateTime(new Date(System.currentTimeMillis()));
		session.setAttribute(request, response, AUTH_KEY, JSON.toJSONString(auth));
	}
	
	public Authentication save(SessionProvider session,
			HttpServletRequest request, HttpServletResponse response, Authentication auth) {
		auth.setId(StringUtils.remove(UUID.randomUUID().toString(), '-'));
		//auth.setId(new RedisSessionIdGenerator().get());
		auth.init();
		session.setAttribute(request, response, AUTH_KEY, JSON.toJSONString(auth));
		return auth;
	}
	
	/*@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Authentication findById(String id) {
		Authentication entity = dao.findById(id);
		return entity;
	}

	public Authentication save(Authentication bean) {
		//bean.setId(StringUtils.remove(UUID.randomUUID().toString(), '-'));
		bean.setId(new RedisSessionIdGenerator().get());
		bean.init();
		dao.save(bean);
		return bean;
	}

	public Authentication deleteById(String id) {
		Authentication bean = dao.deleteById(id);
		return bean;
	}

	public Authentication[] deleteByIds(String[] ids) {
		Authentication[] beans = new Authentication[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}*/

	// 过期时间
	private int timeout = 30 * 60 * 1000; // 30分钟

	// 间隔时间
	private int interval = 4 * 60 * 60 * 1000; // 4小时

	// 刷新时间。
	private long refreshTime = getNextRefreshTime(System.currentTimeMillis(),
			this.interval);

	
	/**
	 * 设置认证过期时间。默认30分钟。
	 * 
	 * @param timeout
	 *            单位分钟
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout * 60 * 1000;
	}

	/**
	 * 设置刷新数据库时间。默认4小时。
	 * 
	 * @param interval
	 *            单位分钟
	 */
	public void setInterval(int interval) {
		this.interval = interval * 60 * 1000;
		this.refreshTime = getNextRefreshTime(System.currentTimeMillis(),
				this.interval);
	}

	/**
	 * 获得下一个刷新时间。
	 * 
	 * 
	 * 
	 * @param current
	 * @param interval
	 * @return 随机间隔时间
	 */
	private long getNextRefreshTime(long current, int interval) {
		return current + interval;
		// 为了防止多个应用同时刷新，间隔时间=interval+RandomUtils.nextInt(interval/4);
		// return current + interval + RandomUtils.nextInt(interval / 4);
	}
	
	private Cookie createCookie(HttpServletRequest request, String key, String value) {
		Cookie cookie = new Cookie(key, value);
		String ctx = request.getContextPath();
		cookie.setPath(StringUtils.isBlank(ctx) ? "/" : ctx);
		return cookie;
	}
	
}