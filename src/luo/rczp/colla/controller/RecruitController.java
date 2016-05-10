package luo.rczp.colla.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import luo.common.pojo.Authentication;
import luo.common.service.AuthService;
import luo.common.web.session.SessionProvider;
import luo.core.util.RequestUtils;
import luo.rczp.base.FrontController;
import luo.rczp.colla.model.Recruit;
import luo.rczp.colla.service.RecruitService;
import luo.rczp.core.model.UserAcount;
import luo.rczp.core.service.UserAcountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recruit")
public class RecruitController extends FrontController {
	
	/**
	 * 获取最新的招聘信息列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getRecruitList")
	public ModelAndView getRecruitList(HttpServletRequest request){
		List<Map<String, Object>> recruitList = recruitService.getNewRecruitList(10);
		return new ModelAndView("recruit/recruitList", "recruitList", recruitList);
	}
	
	/**
	 * 获取最新的招聘信息列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getRecList4pers")
	public ModelAndView getRecList4pers(HttpServletRequest request){
		List<Map<String, Object>> recruitList = recruitService.getNewRecruitList(10);
		return new ModelAndView("recruit/recList4pers", "recruitList", recruitList);
	}
	
	/**
	 * 通过搜索获得招聘信息列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/chooseRecruit")
	public ModelAndView chooseRecruit(HttpServletRequest request){
		Long compId = RequestUtils.getCookieUserId(request);
		List<Map<String, Object>> myRecruitList = recruitService.getListByUserId(compId);
		return new ModelAndView("recruit/myRecruitList", "myRecruitList", myRecruitList);
	}
	
	/**
	 * 获取企业的招聘信息列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getMyRecruitList")
	public ModelAndView getMyRecruitList(HttpServletRequest request){
		Long compId = RequestUtils.getCookieUserId(request);
		List<Map<String, Object>> myRecruitList = recruitService.getListByUserId(compId);
		return new ModelAndView("recruit/myRecruitList", "myRecruitList", myRecruitList);
	}
	
	@RequestMapping("/getRecruitAdd")
	public ModelAndView getRecruitAdd(HttpServletRequest request){
		return new ModelAndView("recruit/recruitAdd");
	}
	
	@RequestMapping("/getRecruitEdit")
	public ModelAndView getRecruitEdit(HttpServletRequest request){
		return new ModelAndView("recruit/recruitEdit");
	}
	
	@RequestMapping("/getRecruitView")
	public ModelAndView getRecruitView(HttpServletRequest request){
		return new ModelAndView("recruit/recruitView");
	}
	
	@RequestMapping(value="/doRecruitAdd")
	public ModelAndView doRecruitAdd(Recruit recruit, String tag1, String tag2, HttpServletRequest request){
		  UserAcount user = userAcountService.findById(RequestUtils.getCookieUserId(request));
		  recruit.setCompany(user);
		  recruitService.init(recruit);
		  recruitService.save(recruit, tag1, tag2);
		return new ModelAndView("redirect:/company/compCentre.htm", "code", 2);
	}
	
	@RequestMapping("/delRecruit")
	@ResponseBody
	public Map<String, Object> delRecruit(Long recruitId, HttpServletRequest request){
		Map<String, Object> map = recruitService.delete(recruitId);
		return  map;
	}
	
	@RequestMapping("/refreshRecruit")
	@ResponseBody
	public Map<String, Object> refreshRecruit(Long recruitId, HttpServletRequest request){
		Map<String, Object> map = recruitService.refresh(recruitId);
		return  map;
	}
	
	@RequestMapping("/viewRecruit")
	@ResponseBody
	public Map<String, Object> viewRecruit(Long recruitId, HttpServletRequest request){
		Integer result  = recruitService.view(recruitId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", result);
		return  map;
	}
	
	
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private UserAcountService userAcountService;
	
}
