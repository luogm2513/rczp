package luo.rczp.core.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import luo.core.util.FrontUtils;
import luo.core.util.RequestUtils;
import luo.rczp.base.FrontController;
import luo.rczp.core.model.UserAcount;
import luo.rczp.core.service.UserAcountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import luo.core.Constants;
import luo.core.web.WebErrors;
import luo.core.util.StrUtils;

@Controller
@RequestMapping("/member")
public class RegisterController extends FrontController{
	
	@RequestMapping(value = "/register")
	public ModelAndView register(HttpServletRequest request, ModelMap model){
		return new ModelAndView("register/register");
	}
	
    @RequestMapping(value = "/doRegister")
	public ModelAndView doRegister(HttpServletRequest request, 
			ModelMap model, UserAcount userAcount){
    	String uniqueId = request.getParameter("email");
		FrontUtils.frontData(request, model);
		model.put("uniqueId", uniqueId);
		WebErrors errors = WebErrors.create(request);
		if(uniqueId == null){
			errors.addErrorCode("error.exceptionParams");
			errors.toModel(model);
			return new ModelAndView("/register/register");
		}
		if(StrUtils.checkEmail(uniqueId)) {
			if(userAcountService.emailExist(uniqueId)){
				errors.addErrorCode("error.emailExist");
				errors.toModel(model);
				return new ModelAndView("/register/register");
			}
			}
    	   
		  if(userAcount.getIsCrisitian()==null){
			  userAcount.setIsCrisitian(0); }
	      userAcount.setRegisterIp(RequestUtils.getIpAddr(request));
	      userAcountService.save(userAcount);
		 return new ModelAndView("redirect:/member/login.htm", "code", 1);
	}
	@Autowired
	private UserAcountService userAcountService;
	}
