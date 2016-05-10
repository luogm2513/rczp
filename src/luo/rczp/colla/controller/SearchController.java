package luo.rczp.colla.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import luo.rczp.base.FrontController;
import luo.rczp.colla.service.RecruitService;
import luo.rczp.colla.service.ResumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/search")
public class SearchController extends FrontController {
	
	@RequestMapping(value = "/doRecSearch")
	public ModelAndView doRecSearch(HttpServletRequest request, Long province, Long city, Long county,
			Long gFunc, Long pFunc, Long func, Long pTrade, Long trade, Integer compType, Integer jobType, Integer salary, String keyword) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("count",10);
		params.put("province",province);
		params.put("city",city);
		params.put("county",county);
		params.put("gFunc",gFunc);
		params.put("pFunc",pFunc);
		params.put("func",func);
		params.put("pTrade",pTrade);
		params.put("trade",trade);
		params.put("compType",compType);
		params.put("jobType",jobType);
		params.put("salary",salary);
		params.put("keyword",keyword);
		List<Map<String, Object>> recruitList = recruitService.getList(params);
		return new ModelAndView("recruit/recList4pers", "recruitList", recruitList);
		}
	
	@RequestMapping(value = "/doResSearch")
	public ModelAndView getResSearch(HttpServletRequest request, Long province, Long city, Long county,
			Long gFunc, Long pFunc, Long func, Long pTrade, Long trade,  Integer award, Integer workYear, String keyword) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("count",10);
		params.put("province",province);
		params.put("city",city);
		params.put("county",county);
		params.put("gFunc",gFunc);
		params.put("pFunc",pFunc);
		params.put("func",func);
		params.put("pTrade",pTrade);
		params.put("trade",trade);
		params.put("award",award);
		params.put("workYear",workYear);
		params.put("keyword",keyword);
		List<Map<String, Object>> resumeList = resumeService.getList(params);
		return new ModelAndView("resume/resList4comp", "resumeList", resumeList);
		}
	
	@RequestMapping(value = "/getRecAdvSearch")
	public ModelAndView getRecAdvSearch(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		return new ModelAndView("recruitSearch/advanced_search", "map", map);
		}
	
	@RequestMapping(value = "/getResAdvSearch")
	public ModelAndView getResAdvSearch(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		return new ModelAndView("resumeSearch/advanced_search", "map", map);
		}
	
	@RequestMapping(value = "/getRecAdvSearch4C")
	public ModelAndView getRecAdvSearch4C(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 1);
		return new ModelAndView("recruitSearch/advanced_search", "map", map);
		}
	
	@RequestMapping(value = "/getResAdvSearch4C")
	public ModelAndView getResAdvSearch4C(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 1);
		return new ModelAndView("resumeSearch/advanced_search", "map", map);
		}
	
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private ResumeService resumeService;
}