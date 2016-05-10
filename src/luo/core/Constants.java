package luo.core;

import java.io.File;

import luo.core.util.ConfigProperties;

/**
 * 系统常量
 */
public abstract class Constants {
	
	/*
	 * 默认间隔30分钟
	 */
	public static final int ERROR_INTERVAL = 30;

	/**
	 * 路径分隔符
	 */
	public static final String SPT = "/";
	
	/**
	 * 系统路径分隔符
	 */
	public static final char FILE_SPT = File.separatorChar;
	
	/**
	 * UTF-8编码
	 */
	public static final String UTF8 = "UTF-8";
	
	/**
	 * 用户授权模块:登录、退出
	 */
	public static final String SYS_AUTH = "01";
	public static final String LOGIN_URL = "/login/login.htm";
	public static final String REDIRECT_PAGE = "common/redirect";
	
	/**
	 * 用户注册模块
	 */
	public static final String SYS_REG = "02";
	
	/**
	 * 用户中心模块
	 */
	public static final String SYS_MEM = "03";

	 //以下是web常量
	public static final int SESSION_TIMEOUT = Integer.parseInt(ConfigProperties.get("session_timeout", "30"));
	/**
	 * cookie中的SESSIONID名称
	 */
	public static final String SESSION_COOKIE = "SESSIONID";
	
	/**
	 * cookie中的userId名称
	 */
	public static final String USER_COOKIE = "_p_user";
	
	/**
	 * cookie中的JSESSIONID名称
	 */
	public static final String JSESSION_COOKIE = "JSESSIONID";
	/**
	 * url中的jsessionid名称
	 */
	public static final String JSESSION_URL = "jsessionid";
	
	/**
	 * session中登录状态
	 */
	public static final String ONLINE_SESSION = "_online";
	
	/**
	 * session中用户信息
	 */
	public static final String USER_SESSION = "_p_user";
	
	/**
	 * HTTP POST请求
	 */
	public static final String POST = "POST";
	/**
	 * HTTP GET请求
	 */
	public static final String GET = "GET";
	/**
	 * 公用模板
	 */
	public static final String TPLDIR_COMMON = "common";
	/**
	 * 模板后缀
	 */
	public static final String TPL_SUFFIX = ".html";
	/**
	 * 页面错误
	 */
	public static final String ERROR_MESSAGE = "common/error_message";
}
