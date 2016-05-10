package luo.rczp.colla.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import luo.common.pojo.Authentication;
import luo.common.service.AuthService;
import luo.common.web.session.SessionProvider;
import luo.rczp.base.FrontController;
import luo.rczp.colla.service.RecruitService;
import luo.rczp.colla.service.ResumeService;
import luo.rczp.core.service.UserAcountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/guide")
public class GuideController extends FrontController {

	/**
	 * rczp招聘网站首页
	 */
	@RequestMapping(value = "/getIndex")
	public ModelAndView getIndex(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Authentication auth = authService.get(request, session);
		List<Map<String, Object>> recruitList = recruitService.getNewRecruitList(10);
		List<Map<String, Object>> resumeList = resumeService.getNewResumeList(10);
		map.put("recruitList", recruitList);
		map.put("resumeList", resumeList);
		if (auth == null) {
			return new ModelAndView("common/dashboard", "map", map);
		} else {
			map.put("auth", auth);
			return new ModelAndView("common/dashboard", "map", map);
		}
	}
	
	/**
	 * rczp招聘网站首页
	 */
	@RequestMapping(value = "/getIndex4C")
	public ModelAndView getIndex4C(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Authentication auth = authService.get(request, session);
		List<Map<String, Object>> recruitList = recruitService.getNewRecruitList4C(10);
		List<Map<String, Object>> resumeList = resumeService.getNewResumeList4C(10);
		map.put("recruitList", recruitList);
		map.put("resumeList", resumeList);
		if (auth == null) {
			return new ModelAndView("chiristian/christianCentre", "map", map);
		} else {
			map.put("auth", auth);
			return new ModelAndView("chiristian/christianCentre", "map", map);
		}
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
}