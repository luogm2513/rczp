package luo.rczp.colla.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import luo.core.util.RequestUtils;
import luo.rczp.base.FrontController;
import luo.rczp.colla.service.CollectService;
import luo.rczp.colla.service.RecruitService;
import luo.rczp.colla.service.ResumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/collect")
public class CollectController extends FrontController {
	
	/**
	 * 收藏职位信息（个人操作）
	 */
	@RequestMapping("/collectRecruit")
	@ResponseBody
	public Map<String, Object> collectRecruit(Long recruitId, HttpServletRequest request){
		Long userId = RequestUtils.getCookieUserId(request);
		Map<String, Object> map = collectService.collectRecruit(recruitId, userId);
		return  map;
	}
	
	/**
	 * 删除收藏的职位(个人操作)
	 */
	@RequestMapping(value = "/delRecruitCollect")
	@ResponseBody
	public Map<String, Object> delRecruitCollect(Long collectId, HttpServletRequest request){
		Map<String, Object> map = collectService.delRecruitCollect(collectId);
		return  map;
	}

	/**
	 * 获取我收藏的招聘信息列表（个人操作）
	 */
	@RequestMapping("/getCollectRecruitList")
	public ModelAndView getCollectRecruitList(HttpServletRequest request){
		List<Map<String, Object>> recruitList = collectService.getCollectRecruitList(RequestUtils.getCookieUserId(request));
		return new ModelAndView("collect/collectRecruitList", "recruitList", recruitList);
	}
	
	/**
	 * 收藏简历（企业操作）
	 */
	@RequestMapping("/collectResume")
	@ResponseBody
	public Map<String, Object> collectResume(Long resumeId, HttpServletRequest request){
		Long userId = RequestUtils.getCookieUserId(request);
		Map<String, Object> map = collectService.collectResume(resumeId, userId);
		return  map;
	}
	
	/**
	 * 删除收藏的简历(企业操作)
	 */
	@RequestMapping(value = "/delResumeCollect")
	@ResponseBody
	public Map<String, Object> delResumeCollect(Long collectId, HttpServletRequest request){
		Map<String, Object> map = collectService.delResumeCollect(collectId);
		return  map;
	}
	
	/**
	 * 获取我收藏的简历列表（企业操作）
	 */
	@RequestMapping("/getCollectResumeList")
	public ModelAndView getCollectResumeList(HttpServletRequest request){
		List<Map<String, Object>> resumeList = collectService.getCollectResumeList(RequestUtils.getCookieUserId(request));
		return new ModelAndView("collect/collectResumeList", "resumeList", resumeList);
	}
	
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private CollectService collectService;
}