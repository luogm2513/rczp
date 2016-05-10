package luo.core.util;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
*    
* 项目名称：parox   
* 类名称：HttpSessionUtil   
* 类描述：   HttpSession工具类
* 创建人：seasongs   
* 创建时间：2014年2月12日 下午1:46:16   
* 修改人：seasongs   
* 修改时间：2014年2月12日 下午1:46:16   
* 修改备注：   
* @version    
*
 */
public class HttpSessionUtil {

	public static Serializable getAttribute(HttpServletRequest request, String name) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			return (Serializable) session.getAttribute(name);
		} else {
			return null;
		}
	}

	public static void setAttribute(HttpServletRequest request,
			String name, Serializable value) {
		HttpSession session = request.getSession();
		session.setAttribute(name, value);
	}
	
	public static boolean exists(HttpServletRequest request, String name) {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute(name) != null) {
			return true;
		} else {
			return false;
		}
	}

	public static String getSessionId(HttpServletRequest request) {
		return request.getSession().getId();
	}

	public static void logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}
	
}
