package luo.rczp.colla.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import luo.rczp.base.BaseService;
import luo.rczp.colla.dao.ResumeDao;
import luo.rczp.colla.model.Resume;
import luo.rczp.core.model.PersonalProfile;
import luo.rczp.core.service.PersonalCentreService;
import luo.rczp.core.service.PersonalProfileService;
import luo.rczp.others.model.ResumeTag;
import luo.rczp.others.service.AreaService;
import luo.rczp.others.service.DicService;
import luo.rczp.others.service.FunctionService;
import luo.rczp.others.service.MajorService;
import luo.rczp.others.service.ProvinceService;
import luo.rczp.others.service.ResTagService;
import luo.rczp.others.service.SchoolService;
import luo.rczp.others.service.TradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("resumeService")
@Transactional
public class ResumeService extends BaseService<Resume, java.lang.Long> {

	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private TradeService tradeService;
	@Autowired
	private FunctionService functionService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private DicService dicService;
	@Autowired
	private ResTagService resTagService;
	@Autowired
	private PersonalProfileService personalProfileService;
	@Autowired
	private PersonalCentreService personalCentreService;
	
	public ResumeDao getDao() {
		return this.resumeDao;
	}
	
	/**
	 * 展示最新简历（可能通过搜索）列表（企业操作、首页专区展示）
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> getNewResumeList(Integer count) {
		List<Map<String, Object>> resumeList = new ArrayList<Map<String, Object>>();
		List<Resume> rList = getDao().getNewResumeList(count);
		for (int i = 0; i < rList.size(); i++) {
			Resume resume = rList.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			PersonalProfile personalProfile = personalProfileService.getById(resume.getPerson().getUserId());
			map = personalProfileService.getProfileParams(map, personalProfile);
			map = getResumeParams(map, resume);
			resumeList.add(map);
		}
		return resumeList;
	}
	
	/**
	 * 展示最新简历（可能通过搜索）列表（基督徒专区）
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> getNewResumeList4C(Integer count) {
		List<Map<String, Object>> resumeList = new ArrayList<Map<String, Object>>();
		List<Resume> rList = getDao().getNewResumeList4C(count);
		for (int i = 0; i < rList.size(); i++) {
			Resume resume = rList.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			PersonalProfile personalProfile = personalProfileService.getById(resume.getPerson().getUserId());
			map = personalProfileService.getProfileParams(map, personalProfile);
			map = getResumeParams(map, resume);
			resumeList.add(map);
		}
		return resumeList;
	}
	
	/**
	 * 展示最新简历（可能通过搜索）列表（企业操作、首页专区展示）
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> getList(Map<String, Object> params) {
		List<Map<String, Object>> resumeList = new ArrayList<Map<String, Object>>();
		List<Resume> rList = getDao().getList(params);
		for (int i = 0; i < rList.size(); i++) {
			Resume resume = rList.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			PersonalProfile personalProfile = personalProfileService.getById(resume.getPerson().getUserId());
			map = personalProfileService.getProfileParams(map, personalProfile);
			map = getResumeParams(map, resume);
			resumeList.add(map);
		}
		return resumeList;
	}
	
	/**
	 * 获取个人简历列表（个人操作）
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> getListByUserId(Long userId) {
		List<Map<String, Object>> resumeList = new ArrayList<Map<String, Object>>();
		List<Resume> rList = getDao().getListByUserId(userId);
		PersonalProfile personalProfile = personalProfileService.getById(userId);
		for (int i = 0; i < rList.size(); i++) {
			Resume resume = rList.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			map = personalProfileService.getProfileParams(map, personalProfile);
			map = getResumeParams(map, resume);
			resumeList.add(map);
		}
		// System.out.println("resumeList:"+JSON.toJSONString(resumeList));
		return resumeList;
	}
	
	/**
	 * 获取简历详细内容（企业、个人操作）
	 * @param map
	 * @param resume
	 * @return
	 */
	public Map<String, Object> getResumeParams(Map<String, Object> map, Resume resume){
		if(resume.getSchool() != null) {
			String schoolName = schoolService.getById(resume.getSchool()).getSchoolName();
			String provinceName = provinceService.getProById(schoolService.getById(resume.getSchool()).getSchoolProId()).getProvinceName();
			map.put("schoolName", schoolName);
			map.put("provinceName", provinceName);
		}
		String majorName = majorService.getMajorName(resume.getGrandMajor(), resume.getParentMajor(), resume.getMajor());
		String targetAreaName = areaService.getAreaName(resume.getTargetProvince(), resume.getTargetCity(), resume.getTargetCounty());
		String functionName = functionService.getFunctionName(resume.getTargetGrandFunction(), resume.getTargetParentFunction(), resume.getTargetFunction());
		String tradeName = tradeService.getTradeName(resume.getTargetParentTrade(), resume.getTargetTrade());
		String awardName = dicService.getAwardName(resume.getAward());
		String workYear = dicService.getWorkYear(resume.getWorkYear());
		String jobTypeName = dicService.getJobTypeName(resume.getJobType());
		String targetSalary = dicService.getTargetSalary(resume.getTargetSalary());
		List<ResumeTag> tags = resTagService.getResTag(resume);
		map.put("resume", resume);
		map.put("majorName", majorName);
		map.put("tradeName", tradeName);
		map.put("functionName", functionName);
		map.put("awardName", awardName);
		map.put("workYear", workYear);
		map.put("targetAreaName", targetAreaName);
		map.put("jobTypeName", jobTypeName);
		map.put("targetSalary", targetSalary);
		map.put("tags", tags);
		return map;
	}

	/**
	 * 新增简历（个人操作）
	 */
	public Resume save(Resume resume, String tag1, String tag2) {
		personalCentreService.addResume(resume.getPerson().getUserId());
		Resume res = getDao().save(resume);
		resTagService.addTag4Res(res, tag1, tag2);
		return res;
	}

	/**
	 * 初始化简历部分信息（个人在新建简历时调用）
	 */
	public Resume init(Resume resume) {
		if(resume.getIsPosted() == null) {
			resume.setIsPosted(0);
		}
		resume.setViewedCount(0);
		resume.setSubmitCount(0);
		resume.setIsDisabled(0);
		resume.setCreatTime(new Date());
		resume.setModifyTime(new Date());
		return resume;
	}

	/**
	 * 删除简历（个人操作）
	 */
	public Map<String, Object> delete(Long resumeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Resume resume = getDao().get(resumeId);
		resume.setIsDisabled(1);
		getDao().update(resume);
		map.put("resumeCount", personalCentreService.delResume(resume.getPerson().getUserId()));
		map.put("delSuccess", true);
		return map;
	}

	/**
	 * 更新（置顶）简历时间（个人操作）
	 */
	public Map<String, Object> refresh(Long resumeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Resume resume = getDao().get(resumeId);
		resume.setModifyTime(new Date());
		getDao().update(resume);
		map.put("modifyTime", resume.getModifyTime());
		map.put("refreshSuccess", true);
		return map;
	}

	/**
	 * 公开简历(个人操作)
	 */
	public Integer openResume(Long resumeId) {
		Resume resume = getDao().get(resumeId);
		resume.setIsPosted(1);
		getDao().update(resume);
		return 1;
	}
	/**
	 * 不公开简历(个人操作)
	 */
	public Integer closeResume(Long resumeId) {
		Resume resume = getDao().get(resumeId);
		resume.setIsPosted(0);
		getDao().update(resume);
		return 1;
	}
	/**
	 * 职位信息被浏览
	 */
	public Integer view(Long resumeId) {
		Resume resume = getDao().get(resumeId);
		resume.setViewedCount(resume.getViewedCount()+1);
		getDao().update(resume);
		
		personalCentreService.resumeBeViewed(resume.getPerson().getUserId());
		return 1;
	}
}