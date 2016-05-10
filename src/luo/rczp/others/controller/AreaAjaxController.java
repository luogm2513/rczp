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
import luo.rczp.others.model.Area;
import luo.rczp.others.service.AreaService;


@Controller
@RequestMapping("/area")
public class AreaAjaxController extends FrontController {
/**
 * 添加@ResponseBody注解，将一个对象返回为json串。
 * 需要在Spring-mvc.xml中加入<context:annotation-config /><mvc:annotation-driven />
 * 并添加两个jackson的依赖包
 * @param parentId
 * @param request
 * @return JSon格式的List
 */
	@RequestMapping("/jsonArray")
	@ResponseBody
	public List<Area> getJsonList(Long parentId, HttpServletRequest request){
		List<Area> list = areaService.getListByParentId(parentId);		
		//System.out.println(JSON.toJSONString(list));
		return list;
	}
	
	@Autowired
	private AreaService areaService;
}
