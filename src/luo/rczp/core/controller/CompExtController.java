package luo.rczp.core.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import luo.common.pojo.Authentication;
import luo.common.service.AuthService;
import luo.common.web.session.SessionProvider;
import luo.core.util.RequestUtils;
import luo.rczp.base.FrontController;
import luo.rczp.core.model.CompProfile;
import luo.rczp.core.model.UserAcount;
import luo.rczp.core.service.CompProfileService;
import luo.rczp.core.service.UserAcountService;
import luo.rczp.others.service.AreaService;
import luo.rczp.others.service.TradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/compExt")
public class CompExtController extends FrontController{

	/**
	 * @return 我的企业基础信息展示页面
	 */
	@RequestMapping(value = "/getMyProfileView")
	public ModelAndView getMyProfileView(HttpServletRequest request){
		CompProfile comp = compProfileService.getById(RequestUtils.getCookieUserId(request));
		if (comp != null) {
			 Map<String,Object> map = compProfileService.getProfileParams(new HashMap<String,Object>(), comp);
			return new ModelAndView("compProfile/profileView", "map", map);
		} else {
			return new ModelAndView("compProfile/profileAdd");
		}
	}
	/**
	 * @return 企业基础信息编辑页面
	 */
	@RequestMapping(value = "/getProfileEdit")
	public ModelAndView getProfileEdit(HttpServletRequest request){
		return new ModelAndView("compProfile/profileEdit");
	}
	/**
	 * @return 企业基础信息添加页面
	 */
	@RequestMapping(value = "/getProfileAdd")
	public ModelAndView getProfileAdd(HttpServletRequest request){
		return new ModelAndView("compProfile/profileAdd");
	}
	/**
	 * 添加企业基础信息
	 * 
	 * @return 企业中心基础信息页
	 */
	@RequestMapping(value = "/doProfileAdd", method = RequestMethod.POST)
	public ModelAndView doProfileAdd(CompProfile comp, HttpServletRequest request) {
		comp.setUserId(RequestUtils.getCookieUserId(request));
		comp.setIsPassed(0);
		compProfileService.save(comp);
		return new ModelAndView("redirect:/company/compCentre.htm", "code", 1);
	}
	@Autowired
	private CompProfileService compProfileService;
	@Autowired
	private UserAcountService userAcountService;
	@Autowired
	private  AreaService areaService;
    @Autowired
    private TradeService tradeService;
}
