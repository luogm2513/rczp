package luo.rczp.colla.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import luo.core.util.RequestUtils;
import luo.rczp.base.FrontController;
import luo.rczp.colla.service.ApplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/apply")
public class ApplyController extends FrontController {
	
	/**
	 * 申请职位并提交简历提交个人简历(个人操作)
	 */
	@RequestMapping(value="/doApply")
	@ResponseBody
	public Map<String, Object> apply(Long resumeId, Long recruitId, HttpServletRequest request){
		Map<String, Object> map= applyService.apply(resumeId, recruitId, RequestUtils.getCookieUserId(request));
		return  map;
	}
	
	/**
	 * 获取我申请的职位信息列表(个人操作)
	 * @param request
	 * @return
	 */
	@RequestMapping("/getApplyListByP")
	public ModelAndView getApplyListByP(HttpServletRequest request){
		List<Map<String, Object>> recruitList = applyService.getApplyList4P(RequestUtils.getCookieUserId(request));
		return new ModelAndView("apply/applyList4pers", "recruitList", recruitList);
	}
	
	/**
	 *删除职位申请记录(个人操作)
	 */
	@RequestMapping(value="/delApply")
	@ResponseBody
	public Map<String, Object> delApplyByP(Long recordId, HttpServletRequest request){
		Map<String, Object> map = applyService.delRecord(recordId);
		return  map;
	}
	
	/**
	 * 获取接收到的简历列表(企业操作)
	 */
	@RequestMapping(value="/getApplyListByC")
	public ModelAndView getApplyListByC(HttpServletRequest request){
		List<Map<String, Object>> resumeList = applyService.getApplyList4C(RequestUtils.getCookieUserId(request));
		return new ModelAndView("apply/applyList4comp", "resumeList", resumeList);
	}
	
	/**
	 * 浏览申请信息(企业操作)
	 */
	@RequestMapping(value = "/viewApply")
	@ResponseBody
	public Map<String, Object> viewApply(Long recordId, HttpServletRequest request){
		Boolean result  = applyService.viewApply(recordId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("viewSuccess", result);
		return  map;
	}
	
	@Autowired
	private ApplyService applyService;
}