package luo.rczp.core.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import luo.common.pojo.Authentication;
import luo.common.security.BadCredentialsException;
import luo.common.security.RealNameNotFoundException;
import luo.common.service.AuthService;
import luo.common.web.session.SessionProvider;
import luo.core.util.FrontUtils;
import luo.core.util.RequestUtils;
import luo.core.web.WebErrors;
import luo.rczp.base.FrontController;
import luo.rczp.colla.service.UserLogService;
import luo.rczp.core.dao.UserAcountDao;
import luo.rczp.core.model.UserAcount;
import luo.rczp.core.service.UserAcountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/member")
public class LoginController extends FrontController{
	
	@Autowired
	private UserAcountDao userDao;
	
	public UserAcountDao getUserDao(){
		return this.userDao;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView input(HttpServletRequest request, Integer code) {	
		
		Authentication auth = authService.get(request, session);
		if (auth != null) {
			  UserAcount user = userAcountService.findById(auth.getUid());
			  if(user.getUserType() == 0){
				  return new ModelAndView("redirect:/company/compCentre.htm");
			  }else{
				  return new ModelAndView("redirect:/personal/persCentre.htm");
			  }
		}
		if(code != null){
			Map<String, Object> userData = new HashMap<String, Object>();
			userData.put("code", code);
			return new ModelAndView("login/login", "userData", userData);
		}
		return new ModelAndView("login/login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(Integer userType, String loginName, String password, 
			HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		WebErrors errors = validateSubmit(loginName, password, request);

		if (!errors.hasErrors()) {
			try {
				Authentication auth = authService.login(userType, loginName, password,
						RequestUtils.getIpAddr(request), request, response, session);
				if(userType == 1){
					return "redirect:/personal/persCentre.htm";
				}else if(userType == 0){
					return "redirect:/company/compCentre.htm";
					}
			} catch (RealNameNotFoundException e) {
				errors.addErrorCode(e.getMessage());
			} catch (BadCredentialsException e) {
				errors.addErrorCode(e.getMessage());
			}
		}

		System.out.println("ERRORS:"+JSON.toJSONString(errors.getErrors()));
		errors.toModel(model);
		FrontUtils.frontData(request, model);
		return "/login/login";
	}
	
	
	private WebErrors validateSubmit(String loginName, String password,HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		if (errors.ifOutOfLength(loginName, "loginName", 2, 30)) {
			return errors;
		}
		if (errors.ifOutOfLength(password, "password", 3, 20)) {
			return errors;
		}
		return errors;
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = authService.get(request, session);
		if (auth != null) {
			String sessionId = RequestUtils.getCookieSessionId(request);
			Long userId = auth.getUid();
			session.logout(request, response);
		}
		return new  ModelAndView("redirect:/member/login.htm");
	}
	@Autowired
	private AuthService authService;
	@Autowired
	private UserAcountService userAcountService;
	@Autowired
	private UserLogService userLogService;
	@Autowired
	private SessionProvider session;
	
}
