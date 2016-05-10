package luo.rczp.colla.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RespectBinding;

import luo.core.util.RequestUtils;
import luo.rczp.base.FrontController;
import luo.rczp.colla.model.Leavemsg;
import luo.rczp.colla.service.LeaveMsgService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.xpath.internal.operations.Bool;

@Controller
@RequestMapping("/message")
public class MessageController extends FrontController {
	
	@RequestMapping("/leaveMsg")
	@ResponseBody
	public Map<String, Object> leaveMsg(Leavemsg msg, Integer targetUserType, HttpServletRequest request){
		Map<String, Object> map = leaveMsgService.LeaveMsg(msg, targetUserType, RequestUtils.getCookieUserId(request));
		return  map;
	}
	
	@RequestMapping("/getMsgList4P")
	public ModelAndView getMsgList4P(HttpServletRequest request){
		List<Map<String, Object>> messageList= leaveMsgService.getMsgList4P(RequestUtils.getCookieUserId(request));
		return new ModelAndView("message/msgList4P", "messageList", messageList);
	}
	
	@RequestMapping("/getMsgList4C")
	public ModelAndView getMsgList4C(HttpServletRequest request){
		List<Map<String, Object>> messageList= leaveMsgService.getMsgList4C(RequestUtils.getCookieUserId(request));
		return new ModelAndView("message/msgList4C", "messageList", messageList);
	}
	
	@RequestMapping("/viewMsg")
	@ResponseBody
	public Map<String, Object> viewMsg(Long messageId, HttpServletRequest request){
		Boolean result  = leaveMsgService.view(messageId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("viewSuccess", result);
		return  map;
	}
	
	@RequestMapping("delMsg")
	@ResponseBody
	public Map<String, Object> delMsg(Long messageId, Integer userType,  HttpServletRequest request){
		Map<String, Object> map =  leaveMsgService.delete(messageId, userType, RequestUtils.getCookieUserId(request));
		return  map;
	}
	
	@Autowired
	private LeaveMsgService leaveMsgService;
	
}