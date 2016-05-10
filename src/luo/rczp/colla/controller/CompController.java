package luo.rczp.colla.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import luo.common.pojo.Authentication;
import luo.common.service.AuthService;
import luo.common.web.session.SessionProvider;
import luo.rczp.base.FrontController;
import luo.rczp.colla.service.InviteService;
import luo.rczp.colla.service.RecruitService;
import luo.rczp.colla.service.ResumeService;
import luo.rczp.core.model.UserAcount;
import luo.rczp.core.service.UserAcountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/company")
public class CompController extends FrontController {
	/**
	 * 企业个人中心操作入口
	 * 操作类型：
	 * 1：查看企业资料、系统消息、职位信息、收藏的简历
	 * 2：搜索简历
	 */	
	@RequestMapping(value = "/compCentre")
	public ModelAndView enterPersCentre(HttpServletRequest request, Integer code) {
		
		Authentication auth = authService.get(request, session);
		if (auth == null) {
				return new ModelAndView("redirect:/member/login.htm");
		}else{
			  UserAcount user = userAcountService.findById(auth.getUid());
			  if(user.getUserType() == 0) {
				  Map<String, Object> userData = userAcountService.getUserData(user.getUserId(), user.getUserType());
				  userData.put("userName", auth.getUserName());
				  if(code == null){
					  userData.put("code", 0);
				  }else{
					  userData.put("code", code);
				  }

				  return new ModelAndView("company/compCentre", "userData", userData);
			  }else {
				  return new ModelAndView("redirect:/member/login.htm");
			  }
		}
		}
	
	@RequestMapping(value = "/getResume")
	public ModelAndView getResume(HttpServletRequest request){
		return new ModelAndView("company/comp_resume");
	}
	
	@RequestMapping(value = "/getRecruit")
	public ModelAndView getRecruit(HttpServletRequest request){
		return new ModelAndView("company/comp_recruit");
	}
	
	@RequestMapping(value = "/getProfile")
	public ModelAndView getProfile(HttpServletRequest request){
		return new ModelAndView("company/comp_profile");
	}
	
	@RequestMapping(value = "/getReceive")
	public ModelAndView getReceive(HttpServletRequest request){
		return new ModelAndView("company/comp_receive");
	}
	
	@RequestMapping(value = "/getRecord")
	public ModelAndView getRecord(HttpServletRequest request){
		return new ModelAndView("company/comp_record");
	}
	
	@RequestMapping(value = "/getCollect")
	public ModelAndView getCollect(HttpServletRequest request){
		return new ModelAndView("company/comp_collect");
	}
	
	@RequestMapping(value = "/getMessage")
	public ModelAndView getMessage(HttpServletRequest request){
		return new ModelAndView("company/comp_message");
	}

	@Autowired
	private AuthService authService;
	@Autowired
	private UserAcountService userAcountService;
	@Autowired
	private SessionProvider session;
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private ResumeService resumeService;
	@Autowired
    private InviteService inviteService;
}