package luo.rczp.others.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import luo.rczp.base.FrontController;
import luo.rczp.others.model.Function;
import luo.rczp.others.service.FunctionService;


@Controller
@RequestMapping("/func")
public class FunctionAjaxController extends FrontController {
/**
 * @param parentId
 * @param request
 * @return JSon格式的List
 */
	@RequestMapping("/jsonArray")
	@ResponseBody
	public List<Function> getJsonList(Long parentId, HttpServletRequest request){
		List<Function> list = functionService.getListByParentId(parentId);		
     //System.out.println(JSON.toJSONString(list));
		return list;
	}
	
	@Autowired
	private FunctionService functionService;
}
