package luo.rczp.others.controller;

import java.util.Date;
import java.util.HashMap;
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
import luo.rczp.others.model.Province;
import luo.rczp.others.model.School;
import luo.rczp.others.service.SchoolService;
import luo.rczp.others.service.ProvinceService;

@Controller
@RequestMapping("/school")
public class SchoolAjaxController extends FrontController {
	/**
	 * @param parentId
	 * @param request
	 * @return JSon格式的List
	 */
	@RequestMapping("/provinceJsonArray")
	@ResponseBody
	public List<Province> getProvinceJsonList(HttpServletRequest request) {
		List<Province> provinceList = provinceService.getList();
		return provinceList;
	}

	/**
	 * @param parentId
	 * @param request
	 * @return JSon格式的List
	 */
	@RequestMapping("/schoolJsonArray")
	@ResponseBody
	public List<School> getSchoolJsonList(Integer parentId, HttpServletRequest request) {
		List<School> schoolList = schoolService.getListByProvinceId(parentId);
		System.out.println("schoolList"+JSON.toJSONString(schoolList));
		return schoolList;
	}

	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private SchoolService schoolService;
}
