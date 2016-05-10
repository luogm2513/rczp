package luo.rczp.core.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import luo.common.pojo.Authentication;
import luo.common.service.AuthService;
import luo.common.web.session.SessionProvider;
import luo.core.util.RequestUtils;
import luo.rczp.base.FrontController;
import luo.rczp.core.model.PersonalProfile;
import luo.rczp.core.model.UserAcount;
import luo.rczp.core.service.PersonalProfileService;
import luo.rczp.core.service.UserAcountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/persExt")
public class PersExtController extends FrontController {

	/**
	 * @return 我的个人基础信息展示页面
	 */
	@RequestMapping(value = "/getMyProfileView")
	public ModelAndView getMyProfileView(HttpServletRequest request) {
		PersonalProfile pers = personalProfileService.getById(RequestUtils.getCookieUserId(request));
		if (pers != null) {
			Map<String,Object> map = personalProfileService.getProfileParams(new HashMap<String,Object>(), pers);
			return new ModelAndView("persProfile/profileView", "map", map);
		} else {
			return new ModelAndView("persProfile/profileAdd");
		}
	}

	/**
	 * @return 查看求职者个人基础信息
	 */
	@RequestMapping(value = "/getProfileView")
	public ModelAndView getProfileView(HttpServletRequest request) {
		return new ModelAndView("persProfile/profileView");
	}

	/**
	 * @return 个人基础信息编辑页面
	 */
	@RequestMapping(value = "/getProfileEdit")
	public ModelAndView getProfileEdit(HttpServletRequest request) {
		/*
		 * PersonalProfile persProfile =
		 * personalProfileService.findById(RequestUtils
		 * .getCookieUserId(request));
		 */
		return new ModelAndView("persProfile/profileEdit");
	}

	/**
	 * @return 个人基础信息添加页面
	 */
	@RequestMapping(value = "/getProfileAdd")
	public ModelAndView getProfileAdd(HttpServletRequest request) {
		return new ModelAndView("persProfile/profileAdd");
	}

	/**
	 * 添加个人基础信息
	 * 
	 * @return 个人中心基础信息页
	 */
	@RequestMapping(value = "/doProfileAdd", method = RequestMethod.POST)
	public ModelAndView doProfileAdd(PersonalProfile persProfile, String birth, HttpServletRequest request) {
		persProfile.setUserId(RequestUtils.getCookieUserId(request));
		personalProfileService.save(persProfile, birth);
		return new ModelAndView("redirect:/personal/persCentre.htm", "code", 1);
	}

	@Autowired
	private PersonalProfileService personalProfileService;
	@Autowired
	private UserAcountService userAcountService;
}
