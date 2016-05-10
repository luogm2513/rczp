
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
@RequestMapping("/personal")
public class PersController extends FrontController {
	/**
	 * 个人中心操作入口
	 * 操作类型：
	 * 1：查看个人资料、消息、邀请、个人简历、操作记录
	 * 2：职位搜索
	 */
	@RequestMapping(value = "/persCentre")
	public ModelAndView enterPersCentre(HttpServletRequest request, Integer code) {
		
		Authentication auth = authService.get(request, session);
		if (auth == null) {
				return new ModelAndView("redirect:/member/login.htm");
		}else{
			  UserAcount user = userAcountService.findById(auth.getUid());
			  if(user.getUserType() == 1) {
				  Map<String, Object> userData = userAcountService.getUserData(user.getUserId(), user.getUserType());
				  userData.put("userName", auth.getUserName());
				  if(code == null){
					  userData.put("code", 0);
				  }else{
					  userData.put("code", code);
				  }

				  return new ModelAndView("personal/persCentre", "userData", userData);
			  }else {
				  return new ModelAndView("redirect:/member/login.htm");
			  }
		}
		}
	
	@RequestMapping(value = "/getRecruit")
	public ModelAndView getRecruit(HttpServletRequest request){
		return new ModelAndView("personal/pers_recruit");
	}
	
	@RequestMapping(value = "/getProfile")
	public ModelAndView getProfile(HttpServletRequest request){
		return new ModelAndView("personal/pers_profile");
	}
	
	@RequestMapping(value = "/getResume")
	public ModelAndView getResume(HttpServletRequest request){
		return new ModelAndView("personal/pers_resume");
	}
	
	@RequestMapping(value = "/getInvite")
	public ModelAndView getInvite(HttpServletRequest request){
		return new ModelAndView("personal/pers_invite");
	}
	
	@RequestMapping(value = "/getRecord")
	public ModelAndView getRecord(HttpServletRequest request){
		return new ModelAndView("personal/pers_record");
	}
	
	@RequestMapping(value = "/getCollect")
	public ModelAndView getCollect(HttpServletRequest request){
		return new ModelAndView("personal/pers_collect");
	}
	
	@RequestMapping(value = "/getMessage")
	public ModelAndView getMessage(HttpServletRequest request){
		return new ModelAndView("personal/pers_message");
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