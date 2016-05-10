package luo.rczp.colla.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import luo.rczp.base.FrontController;
import luo.rczp.colla.model.Resume;
import luo.rczp.colla.service.ResumeService;
import luo.rczp.core.model.UserAcount;
import luo.rczp.core.service.PersonalProfileService;
import luo.rczp.core.service.UserAcountService;
import luo.rczp.others.service.AreaService;
import luo.common.pojo.Authentication;
import luo.common.service.AuthService;
import luo.common.web.session.SessionProvider;
import luo.core.util.RequestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/resume")
public class ResumeController extends FrontController {
	
	/**
	 * @return 最新简历列表
	 */
	@RequestMapping(value="/getResumeList")
	public ModelAndView getResumeList(HttpServletRequest request){
		List<Map<String, Object>> resumeList = resumeService.getNewResumeList(10);
		return new ModelAndView("resume/resumeList", "resumeList", resumeList);
	}
	
	/**
	 * @return 最新简历列表
	 */
	@RequestMapping(value="/getResList4comp")
	public ModelAndView getResList4comp(HttpServletRequest request){
		List<Map<String, Object>> resumeList = resumeService.getNewResumeList(10);
		return new ModelAndView("resume/resList4comp", "resumeList", resumeList);
	}
	
	/**
	 * 获取个人用户的简历列表
	 */
	@RequestMapping(value="/getMyResumeList")
	public ModelAndView getMyResumeList(HttpServletRequest request){
		Long userId = RequestUtils.getCookieUserId(request);
		List<Map<String, Object>> myResumeList = resumeService.getListByUserId(userId);
		//System.out.println("myResumeList:"+JSON.toJSONString(myResumeList));
		return new ModelAndView("resume/myResumeList", "myResumeList", myResumeList);
	}
	
	/**
	 * @return 获取筛选过的简历列表
	 */
	@RequestMapping(value="/chooseResume")
	public ModelAndView chooseResume(HttpServletRequest request){
		Long userId = RequestUtils.getCookieUserId(request);
		List<Map<String, Object>> myResumeList = resumeService.getListByUserId(userId);
		//System.out.println("myResumeList:"+JSON.toJSONString(myResumeList));
		return new ModelAndView("resume/chooseResumeList", "myResumeList", myResumeList);
	}
	
	/**
	 * @return 个人简历新增页面
	 */
	@RequestMapping(value="getResumeAdd")
	public ModelAndView getResumeAdd(HttpServletRequest request){
		return new ModelAndView("resume/resumeAdd");
	}
	/**
	 * @return 个人简历编辑页面
	 */
	@RequestMapping(value="/getResumeEdit")
	public ModelAndView getResumeEdit(Resume resume, HttpServletRequest request){
		return new ModelAndView("resume/resumeEdit");
	}
	/**
	 * @return 个人简历展示页面
	 */
	@RequestMapping(value="/getResumeView")
	public ModelAndView getResumeView(HttpServletRequest request){
		return new ModelAndView("resume/resumeView");
	}
	/**
	 * 新增/编辑个人简历
	 */
	@RequestMapping(value="/doResumeAdd")
	public ModelAndView doResumeAdd(Resume resume, String tag1, String tag2, HttpServletRequest request){
		  UserAcount user = userAcountService.findById(RequestUtils.getCookieUserId(request));
		  resume.setPerson(user);
		  resumeService.init(resume);
		  resumeService.save(resume, tag1, tag2);
		return new ModelAndView("redirect:/personal/persCentre.htm", "code", 2);
	}

	/**
	 * 删除个人简历
	 */
	@RequestMapping("/delResume")
	@ResponseBody
	public Map<String, Object> delResume(Long resumeId, HttpServletRequest request){
		Map<String, Object> result = resumeService.delete(resumeId); 
		return  result;
	}
	
	/**
	 * 更新个人简历
	 */
	@RequestMapping("/refreshResume")
	@ResponseBody
	public Map<String, Object> refreshResume(Long resumeId, HttpServletRequest request){
		Map<String, Object> map = resumeService.refresh(resumeId);
		return  map;
	}

	/**
	 * 公开简历（个人操作）
	 */
	@RequestMapping("/openResume")
	@ResponseBody
	public Map<String, Object> openResume(Long resumeId, HttpServletRequest request){
		Integer result  = resumeService.openResume(resumeId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", result);
		return  map;
	}
	/**
	 * 不公开简历（个人操作）
	 */
	@RequestMapping("/closeResume")
	@ResponseBody
	public Map<String, Object> closeResume(Long resumeId, HttpServletRequest request){
		Integer result  = resumeService.closeResume(resumeId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", result);
		return  map;
	}
	
	/**
	 * 企业查看简历（企业操作）
	 */
	@RequestMapping("/viewResume")
	@ResponseBody
	public Map<String, Object> viewResume(Long resumeId, HttpServletRequest request){
		Integer result  = resumeService.view(resumeId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", result);
		return  map;
	}
	
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private  PersonalProfileService profileService;
	@Autowired
	private UserAcountService userAcountService;
	@Autowired
	private  AreaService areaService;
	
}
