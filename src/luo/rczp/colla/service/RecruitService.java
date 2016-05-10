package luo.rczp.colla.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import luo.rczp.base.BaseService;
import luo.rczp.colla.dao.InviteDao;
import luo.rczp.colla.dao.RecruitCollectDao;
import luo.rczp.colla.dao.RecruitDao;
import luo.rczp.colla.dao.ResumeDao;
import luo.rczp.colla.dao.ResumeReceiveDao;
import luo.rczp.colla.model.Recruit;
import luo.rczp.core.model.CompProfile;
import luo.rczp.core.service.CompCentreService;
import luo.rczp.core.service.CompProfileService;
import luo.rczp.core.service.PersonalCentreService;
import luo.rczp.others.model.RecruitTag;
import luo.rczp.others.service.AreaService;
import luo.rczp.others.service.DicService;
import luo.rczp.others.service.FunctionService;
import luo.rczp.others.service.RecTagService;
import luo.rczp.others.service.TradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("recruitService")
@Transactional
public class RecruitService extends BaseService<Recruit,java.lang.Long>{

	@Autowired
	private RecruitDao recruitDao;
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private InviteDao inviteDao;
	@Autowired
	private RecruitCollectDao recruitCollectDao;
	@Autowired
	private ResumeReceiveDao resumeReceiveDao;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private CompProfileService profileService;
	@Autowired
	private TradeService tradeService;
	@Autowired
	private FunctionService functionService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private DicService dicService;
	@Autowired
	private RecTagService recTagService;
	@Autowired
	private PersonalCentreService personalCentreService;
	@Autowired
	private CompCentreService compCentreService;
	
	public RecruitDao getDao() {
		return this.recruitDao;
	}
	
	public ResumeDao getResumeDao() {
		return this.resumeDao;
	}
	
	public InviteDao getInviteDao() {
		return this.inviteDao;
	} 
	
	public RecruitCollectDao getRecruitCollectDao() {
		return this.recruitCollectDao;
	}
	
	public ResumeReceiveDao getResumeReceiveDao() {
		return this.resumeReceiveDao;
	}
	
	/**
	 * 通过搜索得到对应的招聘信息
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> getList(Map<String,Object> params){
		List<Map<String, Object>> recruitList = new ArrayList<Map<String, Object>>();
		List<Recruit> rList = getDao().getList(params);
		for (int i = 0; i < rList.size(); i++) {
			Recruit recruit = rList.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			CompProfile compProfile = profileService.getById(recruit.getCompany().getUserId());
            map = profileService.getProfileParams(map, compProfile);
            map = getRecruitParams(map, recruit);
			recruitList.add(map);
		}
		return recruitList;
	}
	
	/**
	 * 获取最新的职位信息列表
	 * @param count
	 * @return
	 */
	public List<Map<String, Object>> getNewRecruitList(Integer count ){
		List<Map<String, Object>> recruitList = new ArrayList<Map<String, Object>>();
		List<Recruit> rList = getDao().getNewRecruitList(count);
		for (int i = 0; i < rList.size(); i++) {
			Recruit recruit = rList.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			CompProfile compProfile = profileService.getById(recruit.getCompany().getUserId());
            map = profileService.getProfileParams(map, compProfile);
            map = getRecruitParams(map, recruit);
			recruitList.add(map);
		}
		return recruitList;
	}
	
	/**
	 * 获取最新的职位信息列表
	 * @param count
	 * @return
	 */
	public List<Map<String, Object>> getNewRecruitList4C(Integer count ){
		List<Map<String, Object>> recruitList = new ArrayList<Map<String, Object>>();
		List<Recruit> rList = getDao().getNewRecruitList4C(count);
		for (int i = 0; i < rList.size(); i++) {
			Recruit recruit = rList.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			CompProfile compProfile = profileService.getById(recruit.getCompany().getUserId());
            map = profileService.getProfileParams(map, compProfile);
            map = getRecruitParams(map, recruit);
			recruitList.add(map);
		}
		return recruitList;
	}

    /**
     * 获取企业自己发布的职位信息列表
     * @param compId
     * @return
     */
	public List<Map<String, Object>> getListByUserId(Long compId) {
		List<Map<String, Object>> recruitList = new ArrayList<Map<String, Object>>();
		List<Recruit> rList = getDao().getListByUserId(compId);
		CompProfile compProfile = profileService.getById(compId);
		for (int i = 0; i < rList.size(); i++) {
			Recruit recruit = rList.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
            map = profileService.getProfileParams(map, compProfile);
            map = getRecruitParams(map, recruit);
			recruitList.add(map);
		}
		return recruitList;
	}
	
	/**
	 * 获取职位相关的内容
	 * @param map
	 * @param recruit
	 * @return
	 */
	public Map<String, Object> getRecruitParams(Map<String, Object> map, Recruit recruit){
		String jobAreaName = areaService.getAreaName(recruit.getProvince(), recruit.getCity(), recruit.getCounty());
		String functionName = functionService.getFunctionName(recruit.getGrandFunction(), recruit.getParentFunction(), recruit.getFunction());
		String tradeName = tradeService.getTradeName(recruit.getParentTrade(), recruit.getTrade());		
		String numRequire = dicService.getNumRequire(recruit.getNumRequire());
		String experience = dicService.getExperience(recruit.getExperience());
		String jobTypeName = dicService.getJobTypeName(recruit.getJobType());
		String salary = dicService.getTargetSalary(recruit.getSalary());
		List<RecruitTag> tags = recTagService.getRecTag(recruit);
		map.put("recruit", recruit);
		map.put("jobAreaName", jobAreaName);
		map.put("functionName", functionName);
		map.put("recruitTradeName", tradeName);
		map.put("numRequire", numRequire);
		map.put("experience", experience);
		map.put("jobTypeName", jobTypeName);
		map.put("salary", salary);
		map.put("tags", tags);
		return map;
	}
	
	/**
	 * 保存一条职位信息
	 */
	public Recruit save(Recruit recruit, String tag1, String tag2) {
		compCentreService.addRecruit(recruit.getCompany().getUserId());
		Recruit rec = getDao().save(recruit);
		recTagService.addTag4Rec(rec,  tag1, tag2);
		return rec;
	}
	
	/**
	 * 初始化职位信息（在企业新增一条职位信息时调用）
	 * @param recruit
	 * @return
	 */
	public Recruit init(Recruit recruit) {
		recruit.setPostTime(new Date());
		recruit.setResumeCount(0);
		recruit.setMsgCount(0);
		recruit.setViewCount(0);
		recruit.setIsDisabled(0);
		return recruit;
	}
	
	/**
	 * 删除职位信息（企业操作）
	 */
	public Map<String, Object> delete(Long recruitId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Recruit recruit = getDao().get(recruitId);
		recruit.setIsDisabled(1);
		getDao().update(recruit);
		map.put("recruitCount", compCentreService.delRecruit(recruit.getCompany().getUserId()));
		map.put("delSuccess", true);
		return map;
		
	}

	/**
	 * 刷新招聘信息（置顶）（企业操作）
	 * @param recruitId
	 */
	public Map<String, Object> refresh(Long recruitId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Recruit recruit = getDao().get(recruitId);
		recruit.setPostTime(new Date());
		getDao().update(recruit);
		map.put("postTime", recruit.getPostTime());
		map.put("refreshSuccess", true);
		return map;
	}
	
	/**
	 * 职位信息被浏览
	 */
	public Integer view(Long recruitId) {
		Recruit recruit = getDao().get(recruitId);
		recruit.setViewCount(recruit.getViewCount()+1);
		getDao().update(recruit);
		
		compCentreService.recruitBeViewed(recruit.getCompany().getUserId());
		return 1;
	}

}