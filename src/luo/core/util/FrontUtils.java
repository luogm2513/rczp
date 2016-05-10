package luo.core.util;

import static luo.core.web.ProcessTimeFilter.START_TIME;
import static luo.core.Constants.LOGIN_URL;
import static luo.core.Constants.REDIRECT_PAGE;
import static luo.core.Constants.TPLDIR_COMMON;
import static luo.core.Constants.TPL_SUFFIX;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.context.MessageSource;

import luo.core.util.ConfigProperties;
import luo.common.pojo.Authentication;
import luo.core.util.RequestUtils;
import luo.core.web.URLHelper;
import luo.core.web.WebErrors;
import luo.core.web.URLHelper.PageInfo;
import freemarker.core.Environment;
import freemarker.template.AdapterTemplateModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * 前台工具类
 */
public class FrontUtils {

	/**
	 * 页面没有找到
	 */
	public static final String PAGE_NOT_FOUND = "404";
	/**
	 * 操作成功页面
	 */
	public static final String SUCCESS_PAGE = "success_page";
	/**
	 * 操作失败页面
	 */
	public static final String ERROR_PAGE = "error_page";
	/**
	 * 信息提示页面
	 */
	public static final String MESSAGE_PAGE = "message_page";
	
	/**
	 * 模板资源路径
	 */
	public static final String RES_TPL = "res";
	/**
	 * 模板资源表达式
	 */
	public static final String RES_EXP = "${res}";
	/**
	 * 部署路径
	 */
	public static final String BASE = "base";
	
	/*
	 * 图片文件根路径
	 */
	public static final String IMG_ROOT = "imgRoot";
	
	/*
	 * css文件根路径
	 */
	public static final String CSS_ROOT = "cssRoot";
	
	/*
	 * js文件根路径
	 */
	public static final String JS_ROOT = "jsRoot";
	
	/**
	 * 站点
	 */
	//public static final String SITE = "site";
	/**
	 * 用户
	 */
	public static final String USER = "_user";
	
	/**
	 * 用户KEY
	 */
	public static final String USER_KEY = "_user";
	
	/**
	 * 用户认证信息KEY
	 */
	public static final String AUTH_KEY = "_auth_key";
	
	/**
	 * 页码
	 */
	public static final String PAGE_NO = "pageNo";
	/**
	 * 总条数
	 */
	public static final String COUNT = "count";
	/**
	 * 起始条数
	 */
	public static final String FIRST = "first";

	/**
	 * 页面完整地址
	 */
	public static final String LOCATION = "location";
	/**
	 * 页面翻页地址
	 */
	public static final String HREF = "href";
	/**
	 * href前半部（相对于分页）
	 */
	public static final String HREF_FORMER = "hrefFormer";
	/**
	 * href后半部（相对于分页）
	 */
	public static final String HREF_LATTER = "hrefLatter";

	/**
	 * 传入参数，列表样式。
	 */
	public static final String PARAM_STYLE_LIST = "styleList";
	/**
	 * 传入参数，系统预定义翻页。
	 */
	public static final String PARAM_SYS_PAGE = "sysPage";
	/**
	 * 传入参数，用户自定义翻页。
	 */
	public static final String PARAM_USER_PAGE = "userPage";

	/**
	 * 返回页面
	 */
	public static final String RETURN_URL = "returnUrl";


	/**
	 * 获得模板路径。不对模板文件进行本地化处理。
	 * 	
	 * @param dir
	 *            模板目录。不本地化处理。
	 * @param name
	 *            模板名称。不本地化处理。
	 * @return
	 */
	public static String getTplPath(String dir, String name) {
		return dir + "/" + name;
	}

	/**
	 * 页面没有找到
	 * 
	 * @param request
	 * @param response
	 * @return 返回“页面没有找到”的模板
	 */
	public static String pageNotFound(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> model) {
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		//CmsSite site = CmsUtils.getSite(request);
		frontData(request, model);
		return getTplPath(TPLDIR_COMMON, PAGE_NOT_FOUND);
	}

	/**
	 * 成功提示页面
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	public static String showSuccess(HttpServletRequest request,
			Map<String, Object> model, String nextUrl) {
		//CmsSite site = CmsUtils.getSite(request);
		frontData(request, model);
		if (!StringUtils.isBlank(nextUrl)) {
			model.put("nextUrl", nextUrl);
		}
		return getTplPath(TPLDIR_COMMON, SUCCESS_PAGE);
	}

	/**
	 * 错误提示页面
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	public static String showError(HttpServletRequest request,
			Map<String, Object> model,
			WebErrors errors) {
		//CmsSite site = CmsUtils.getSite(request);
		frontData(request, model);
		errors.toModel(model);
		return getTplPath(TPLDIR_COMMON, ERROR_PAGE);
	}

	/**
	 * 显示登录页面
	 * 
	 * @param request
	 * @param model
	 * @param site
	 * @param message
	 * @return
	 */
	public static String showLogin(HttpServletRequest request,
			Map<String, Object> model, String message) {
		StringBuilder buff = new StringBuilder("redirect:");
		buff.append(LOGIN_URL).append("?");
		buff.append(RETURN_URL).append("=");
		buff.append(RequestUtils.getLocation(request));
		//if (!StringUtils.isBlank(site.getProcessUrl())) {
		//	buff.append("&").append(PROCESS_URL).append(site.getProcessUrl());
		//}
		return buff.toString();
	}

	/**
	 * 显示登录页面
	 * 
	 * @param request
	 * @param model
	 * @param site
	 * @return
	 */
	public static String showLogin(HttpServletRequest request,
			Map<String, Object> model) {
		return showLogin(request, model, "true");
	}
	
	public static String redirectLogin(HttpServletRequest request,
			Map<String, Object> model) {
		StringBuilder buff = new StringBuilder("redirect:");
		buff.append(LOGIN_URL).append("?");
		buff.append(RETURN_URL).append("=");
		buff.append(RequestUtils.getLocation(request));
		
		model.put("type", "0");
		model.put("url", buff.toString());
		return REDIRECT_PAGE;
	}
	
	public static Map<String, Object> msgResult(int code, String msg){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("message", msg);
		return map;
	}

	/**
	 * 为前台模板设置公用数据
	 * 
	 * @param request
	 * @param model
	 */
	public static void frontData(HttpServletRequest request,
			Map<String, Object> map) {
		String location = RequestUtils.getLocation(request);
		Long startTime = (Long) request.getAttribute(START_TIME);
		map.put(BASE, ConfigProperties.get("baseAddr", "localhost/rczp"));
		map.put(CSS_ROOT, ConfigProperties.get("cssAddr", "localhost/css"));
		map.put(IMG_ROOT, ConfigProperties.get("imgAddr", "localhost/images"));
		map.put(JS_ROOT, ConfigProperties.get("jsAddr", "localhost/js"));
		frontData(map, location, startTime);
	}

	public static void frontData(Map<String, Object> map, 
			 String location, Long startTime) {
		if (startTime != null) {
			map.put(START_TIME, startTime);
		}
		//map.put(SITE, site);
		//String ctx = site.getContextPath() == null ? "" : site.getContextPath();
		//map.put(BASE, "");
		//map.put(RES_SYS, ctx + RES_PATH);
		//String res = ctx + RES_PATH + "/" + site.getPath() + "/" + site.getTplSolution();
		// res路径需要去除第一个字符'/'
		//map.put(RES_TPL, res.substring(1));
		map.put(LOCATION, location);
	}

	public static void putLocation(Map<String, Object> map, String location) {
		map.put(LOCATION, location);
	}

	/**
	 * 为前台模板设置分页相关数据
	 * 
	 * @param request
	 * @param map
	 */
	public static void frontPageData(HttpServletRequest request,
			Map<String, Object> map) {
		int pageNo = URLHelper.getPageNo(request);
		PageInfo info = URLHelper.getPageInfo(request);
		String href = info.getHref();
		String hrefFormer = info.getHrefFormer();
		String hrefLatter = info.getHrefLatter();
		frontPageData(pageNo, href, hrefFormer, hrefLatter, map);
	}

	/**
	 * 为前台模板设置分页相关数据
	 * 
	 * @param pageNo
	 * @param href
	 * @param urlFormer
	 * @param urlLatter
	 * @param map
	 */
	public static void frontPageData(int pageNo, String href,
			String hrefFormer, String hrefLatter, Map<String, Object> map) {
		map.put(PAGE_NO, pageNo);
		map.put(HREF, href);
		map.put(HREF_FORMER, hrefFormer);
		map.put(HREF_LATTER, hrefLatter);
	}

	/**
	 * 获得用户
	 * 
	 * @param request
	 * @return
	 */
	public static Authentication getAuth(HttpServletRequest request) {
		return (Authentication) request.getAttribute(AUTH_KEY);
	}
	
	/**
	 * 设置用户
	 * 
	 * @param request
	 * @param user
	 */
	public static void setAuth(HttpServletRequest request, Authentication auth) {
		request.setAttribute(AUTH_KEY, auth);
	}

}
