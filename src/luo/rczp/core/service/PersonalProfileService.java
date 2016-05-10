package luo.rczp.core.service;

import java.util.Map;

import luo.core.util.DateUtil;
import luo.rczp.base.BaseService;
import luo.rczp.core.dao.PersonalProfileDao;
import luo.rczp.core.model.PersonalProfile;
import luo.rczp.others.service.AreaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("personalProfileService")
@Transactional
public class PersonalProfileService extends BaseService<PersonalProfile,java.lang.Long>{

	@Autowired
	private PersonalProfileDao personalProfileDao;
	@Autowired
	private AreaService areaService;
	
	public PersonalProfileDao getDao() {
		return this.personalProfileDao;
	}
	
	public PersonalProfile save(PersonalProfile person, String birth){
		person.setBirthday(DateUtil.parseDate(birth, "yyyy-mm-dd"));
		PersonalProfile user = getDao().save(person);
		return user;
	}
	
	public PersonalProfile getById(Long userId){
		PersonalProfile user = getDao().findUniqueByProperty("userId" ,userId);
		return user;
	}
	
	public PersonalProfile getByRealName(String loginName){
		PersonalProfile user = getDao().getByRealName(loginName);
		return user;
	}
	
	public Map<String, Object> getProfileParams(Map<String, Object> map, PersonalProfile profile){
		String NAreaName = areaService.getAreaName(profile.getNativeProvince(), profile.getNativeCity(), profile.getNativeCounty());
		String PAreaName = areaService.getAreaName(profile.getPresentProvince(), profile.getPresentCity(), profile.getPresentCounty());
		map.put("personalProfile", profile);
		map.put("NAreaName", NAreaName);
		map.put("PAreaName", PAreaName);
		return map;
	}
}