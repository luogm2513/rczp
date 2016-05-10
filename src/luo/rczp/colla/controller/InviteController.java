
package luo.rczp.colla.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import luo.core.util.RequestUtils;
import luo.rczp.base.FrontController;
import luo.rczp.colla.model.Invite;
import luo.rczp.colla.service.InviteService;
import luo.rczp.colla.service.RecruitService;
import luo.rczp.colla.service.ResumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/invite")
public class InviteController extends FrontController {
	
	/**
	 * 发出面试/录取邀请(企业操作)
	 */
	@RequestMapping(value = "/doInvite")
	@ResponseBody
	public Map<String, Object> invite(Invite invite, String time2meet, HttpServletRequest request){
		Map<String, Object> map  = inviteService.invite(invite, time2meet, RequestUtils.getCookieUserId(request));
		return  map;
	}
	/**
	 * 获取我发送邀请对应的个人简历列表(企业操作)
	 */
	@RequestMapping("/getInviteListByC")
	public ModelAndView getRecordResumeList(HttpServletRequest request){
		List<Map<String, Object>> resumeList = inviteService.getInviteList4C(RequestUtils.getCookieUserId(request));
		return new ModelAndView("invite/inviteList4comp", "resumeList", resumeList);
	}
	
	/**
	 * 删除邀请信息(企业操作)
	 */
	@RequestMapping(value = "/delInviteByC")
	@ResponseBody
	public Map<String, Object> delInviteByC(Long recordId, HttpServletRequest request){
		Map<String, Object> map = inviteService.delInvite(recordId, 0);
		return  map;
	}
	/**
	 * 获取我收到的邀请的详细信息(个人操作)
	 */
	@RequestMapping("/getInviteListByP")
	public ModelAndView getInviteList(HttpServletRequest request){
		List<Map<String, Object>> inviteList = inviteService.getInviteList4P(RequestUtils.getCookieUserId(request));
		return new ModelAndView("invite/inviteList4pers", "inviteList", inviteList);
	}
	
	/**
	 * 删除邀请信息(个人操作)
	 */
	@RequestMapping(value = "/delInviteByP")
	@ResponseBody
	public Map<String, Object> delInviteByP(Long recordId, HttpServletRequest request){
		Map<String, Object> map  = inviteService.delInvite(recordId, 1);
		return  map;
	}
	
	/**
	 * 浏览邀请信息(个人操作)
	 */
	@RequestMapping(value = "/viewInvite")
	@ResponseBody
	public Map<String, Object> viewInvite(Long recordId, HttpServletRequest request){
		Boolean result  = inviteService.viewInvite(recordId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("viewSuccess", result);
		return  map;
	}
	
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private InviteService inviteService;
}