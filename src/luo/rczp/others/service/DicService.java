package luo.rczp.others.service;

import org.springframework.stereotype.Service;
import luo.rczp.others.service.DicService;

@Service("dicService")
public class DicService {

	public String getAwardName(Integer award) {
		String awardName = null;
		if (award != null) {
			switch (award) {
			case 0:
				awardName = "初中";
				break;
			case 1:
				awardName = "高中/高职";
				break;
			case 2:
				awardName = "专科";
				break;
			case 3:
				awardName = "本科";
				break;
			case 4:
				awardName = "硕士";
				break;
			case 5:
				awardName = "博士";
				break;
			case 6:
				awardName = "海归";
				break;
			case 7:
				awardName = "其他";
			}
		}
		return awardName;
	}

	public String getWorkYear(Integer workYear) {
		String workYearName = null;
		if (workYear != null) {
			switch (workYear) {
			case 1:
				workYearName = "不到1年";
				break;
			case 2:
				workYearName = "1-3年";
				break;
			case 3:
				workYearName = "3-5年";
				break;
			case 4:
				workYearName = "5-10年";
				break;
			case 5:
				workYearName = "10-30年";
				break;
			case 6:
				workYearName = "30年以上";
			}
		}
		return workYearName;
	}

	public String getJobTypeName(Integer jobType) {
		String jobTypeName = null;
		if (jobType != null) {
			switch (jobType) {
			case 0:
				jobTypeName = "兼职";
				break;
			case 1:
				jobTypeName = "实习";
				break;
			case 2:
				jobTypeName = "全职";
			}
		}
		return jobTypeName;
	}

	public String getTargetSalary(Integer targetSalary) {
		String targetSalaryName = "面谈";
		if (targetSalary != null) {
			switch (targetSalary) {
			case 1:
				targetSalaryName = "0-1499";
				break;
			case 2:
				targetSalaryName = "1500-1999";
				break;
			case 3:
				targetSalaryName = "2000-2999";
				break;
			case 4:
				targetSalaryName = "3000-3999";
				break;
			case 5:
				targetSalaryName = "4000-4999";
				break;
			case 6:
				targetSalaryName = "5000-6999";
				break;
			case 7:
				targetSalaryName = "7000-9999";
				break;
			case 8:
				targetSalaryName = "10000-14999";
				break;
			case 9:
				targetSalaryName = "15000-19999";
				break;
			case 10:
				targetSalaryName = "20000-29999";
				break;
			case 11:
				targetSalaryName = "30000+";
			}
		}
		return targetSalaryName;
	}

	public String getCompTypeName(Integer compType) {
		String compTypeName = null;
		if(compType != null) {
			switch (compType) {
			case 1:
				compTypeName = "国企";
				break;
			case 2:
				compTypeName = "民营";
				break;
			case 3:
				compTypeName = "合资";
				break;
			case 4:
				compTypeName = "外企";
				break;
			case 5:
				compTypeName = "事业单位";
				break;
			case 6:
				compTypeName = "政府机关";
				break;
			case 7:
				compTypeName = "其他";
			}
		}
		return compTypeName;
	}

	public String getCompScale(Integer scale) {
		String compScale = null;
		if(scale != null) {
			switch (scale) {
			case 1:
				compScale = "7人以下";
				break;
			case 2:
				compScale = "7-20人";
				break;
			case 3:
				compScale = "21-50人";
				break;
			case 4:
				compScale = "51-200人";
				break;
			case 5:
				compScale = "201-1000人";
				break;
			case 6:
				compScale = "1000人以上";
			}
		}
		return compScale;
	}

	public String getCreatTime(Integer cTime) {
		String creatTime = null;
		if(cTime != null) {
			switch (cTime) {
			case 1:
				creatTime = "不到1年";
				break;
			case 2:
				creatTime = "1-3年";
				break;
			case 3:
				creatTime = "3-5年";
				break;
			case 4:
				creatTime = "5-10年";
				break;
			case 5:
				creatTime = "10-30年";
				break;
			case 6:
				creatTime = "30年以上";
			}
		}
		return creatTime;
	}

	public String getNumRequire(Integer num) {
		String numRequire = null;
		if(num != null) {
			switch (num) {
			case 1:
				numRequire = "1人";
				break;
			case 2:
				numRequire = "2-5人";
				break;
			case 3:
				numRequire = "5-10人";
				break;
			case 4:
				numRequire = "10-20人";
				break;
			case 5:
				numRequire = "20人以上";
			}
		}
		return numRequire;
	}

	public String getExperience(Integer exp) {
		String experience = "不限";
		if(exp != null) {
			switch (exp) {
			case 1:
				experience = "不到1年";
				break;
			case 2:
				experience = "1-3年";
				break;
			case 3:
				experience = "3-5年";
				break;
			case 4:
				experience = "5-10年";
				break;
			case 5:
				experience = "10-30年";
				break;
			case 6:
				experience = "30年以上";
				break;
			case 7:
				experience = "不限";
			}
		}
		return experience;
	}

}