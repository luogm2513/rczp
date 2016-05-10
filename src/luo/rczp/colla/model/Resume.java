package luo.rczp.colla.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import luo.rczp.core.model.UserAcount;

@Entity
@Table(name = "c_resume", catalog = "rczp")
public class Resume implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long resumeId;
	private UserAcount person;
	
	private Integer school;
	private Integer grandMajor;
	private Integer parentMajor;
	private Integer major;
	private Integer award;
	private String language;
	
	private Integer workYear;
	private String workExperience;
	
	private String faith;
	private String selfIntroduction;
	private String photo;
	
	private Long targetParentTrade;
	private Long targetTrade;
	private Long targetGrandFunction;
	private Long targetParentFunction;
	private Long targetFunction;
	private Long targetProvince;
	private Long targetCity;
	private Long targetCounty;
	private Integer jobType;
	private Integer targetSalary;


	private Date creatTime;
	private Date modifyTime;
	private Integer viewedCount;
	private Integer submitCount;
	private Integer isPosted;
	private Integer isDisabled;

	// Constructors

	/** default constructor */
	public Resume() {
	}

	/** full constructor */
	public Resume(Long resumeId, UserAcount person, Integer school, Integer grandMajor, Integer parentMajor, Integer major, Integer award,
			String language, Integer workYear, String workExperience, String faith, String selfIntroduction, String photo,
			Long targetParentTrade, Long targetTrade, Long targetGrandFunction, Long targetParentFunction, Long targetFunction,
			Long targetProvince, Long targetCity, Long targetCounty, Integer jobType, Integer targetSalary,
			Date creatTime, Date modifyTime, Integer viewedCount,
			Integer submitCount, Integer isPosted, Integer isDisabled) {
		this.resumeId = resumeId;
		this.person = person;
		this.grandMajor = grandMajor;
		this.parentMajor = parentMajor;
		this.major = major;
		this.award = award;
		this.school = school;
		this.language = language;
		this.workYear = workYear;
		this.targetParentTrade = targetParentTrade;
		this.targetTrade = targetTrade;
		this.targetGrandFunction = targetGrandFunction;
		this.targetParentFunction = targetParentFunction;
		this.targetFunction = targetFunction;
		this.targetProvince = targetProvince;
		this.targetCity = targetCity;
		this.targetCounty = targetCounty;
		this.jobType = jobType;
		this.targetSalary = targetSalary;
		this.workExperience = workExperience;
		this.faith = faith;
		this.selfIntroduction = selfIntroduction;
		this.photo = photo;
		this.creatTime = creatTime;
		this.modifyTime = modifyTime;
		this.viewedCount = viewedCount;
		this.submitCount = submitCount;
		this.isPosted = isPosted;
		this.isDisabled = isDisabled;
	}

	@Id
	@Column(name = "resume_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getResumeId() {
		return this.resumeId;
	}

	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public UserAcount getPerson() {
		return this.person;
	}

	public void setPerson(UserAcount person) {
		this.person = person;
	}

	@Column(name = "school", length = 11)
	public Integer getSchool() {
		return this.school;
	}

	public void setSchool(Integer school) {
		this.school = school;
	}
	
	@Column(name = "grand_major", length = 20)
	public Integer getGrandMajor() {
		return this.grandMajor;
	}

	public void setGrandMajor(Integer grandMajor) {
		this.grandMajor = grandMajor;
	}
	
	@Column(name = "parent_major", length = 20)
	public Integer getParentMajor() {
		return this.parentMajor;
	}

	public void setParentMajor(Integer parentMajor) {
		this.parentMajor = parentMajor;
	}
	
	@Column(name = "major", length = 20)
	public Integer getMajor() {
		return this.major;
	}

	public void setMajor(Integer major) {
		this.major = major;
	}

	@Column(name = "award")
	public Integer getAward() {
		return this.award;
	}

	public void setAward(Integer award) {
		this.award = award;
	}

	@Column(name = "language", length = 30)
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "work_year")
	public Integer getWorkYear() {
		return this.workYear;
	}
	
	public void setWorkYear(Integer workYear) {
		this.workYear = workYear;
	}
	
	@Column(name = "work_experience", length = 600)
	public String getWorkExperience() {
		return this.workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	
	@Column(name = "self_introduction", length = 300)
	public String getSelfIntroduction() {
		return this.selfIntroduction;
	}

	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}

	@Column(name = "faith", length = 600)
	public String getFaith() {
		return this.faith;
	}

	public void setFaith(String faith) {
		this.faith = faith;
	}

	@Column(name = "photo", length = 300)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Column(name = "target_parentTrade")
	public Long getTargetParentTrade() {
		return this.targetParentTrade;
	}

	public void setTargetParentTrade(Long targetParentTrade) {
		this.targetParentTrade = targetParentTrade;
	}
	
	@Column(name = "target_trade")
	public Long getTargetTrade() {
		return this.targetTrade;
	}

	public void setTargetTrade(Long targetTrade) {
		this.targetTrade = targetTrade;
	}
	
	@Column(name = "target_GrandFunction")
	public Long getTargetGrandFunction() {
		return this.targetGrandFunction;
	}

	public void setTargetGrandFunction(Long targetGrandFunction) {
		this.targetGrandFunction = targetGrandFunction;
	}
	
	@Column(name = "target_ParentFunction")
	public Long getTargetParentFunction() {
		return this.targetParentFunction;
	}

	public void setTargetParentFunction(Long targetParentFunction) {
		this.targetParentFunction = targetParentFunction;
	}

	@Column(name = "target_function")
	public Long getTargetFunction() {
		return this.targetFunction;
	}

	public void setTargetFunction(Long targetFunction) {
		this.targetFunction = targetFunction;
	}
	
	@Column(name = "target_province")
	public Long getTargetProvince() {
		return this.targetProvince;
	}

	public void setTargetProvince(Long targetProvince) {
		this.targetProvince = targetProvince;
	}
	
	@Column(name = "target_city")
	public Long getTargetCity() {
		return this.targetCity;
	}

	public void setTargetCity(Long targetCity) {
		this.targetCity = targetCity;
	}

	@Column(name = "target_county")
	public Long getTargetCounty() {
		return this.targetCounty;
	}

	public void setTargetCounty(Long targetCounty) {
		this.targetCounty = targetCounty;
	}

	@Column(name = "job_type")
	public Integer getJobType() {
		return this.jobType;
	}

	public void setJobType(Integer jobType) {
		this.jobType = jobType;
	}

	@Column(name = "target_salary")
	public Integer getTargetSalary() {
		return this.targetSalary;
	}

	public void setTargetSalary(Integer targetSalary) {
		this.targetSalary = targetSalary;
	}

	@Column(name = "creat_time", length = 19)
	public Date getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	@Column(name = "modify_time", length = 19)
	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Column(name = "viewed_count")
	public Integer getViewedCount() {
		return this.viewedCount;
	}

	public void setViewedCount(Integer viewedCount) {
		this.viewedCount = viewedCount;
	}

	@Column(name = "submit_count")
	public Integer getSubmitCount() {
		return this.submitCount;
	}

	public void setSubmitCount(Integer submitCount) {
		this.submitCount = submitCount;
	}

	@Column(name = "is_posted")
	public Integer getIsPosted() {
		return this.isPosted;
	}

	public void setIsPosted(Integer isPosted) {
		this.isPosted = isPosted;
	}

	@Column(name = "is_disabled")
	public Integer getIsDisabled() {
		return this.isDisabled;
	}

	public void setIsDisabled(Integer isDisabled) {
		this.isDisabled = isDisabled;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Resume))
			return false;
		Resume castOther = (Resume) other;

		return ((this.getResumeId() == castOther.getResumeId()) || (this
				.getResumeId() != null && castOther.getResumeId() != null && this
				.getResumeId().equals(castOther.getResumeId())))
				&& ((this.getPerson() == castOther.getPerson()) || (this
						.getPerson() != null && castOther.getPerson() != null && this
						.getPerson().equals(castOther.getPerson())))
				&& ((this.getMajor() == castOther.getMajor()) || (this
						.getMajor() != null && castOther.getMajor() != null && this
						.getMajor().equals(castOther.getMajor())))
				&& ((this.getAward() == castOther.getAward()) || (this
						.getAward() != null && castOther.getAward() != null && this
						.getAward().equals(castOther.getAward())))
				&& ((this.getSchool() == castOther.getSchool()) || (this
						.getSchool() != null && castOther.getSchool() != null && this
						.getSchool().equals(castOther.getSchool())))
				&& ((this.getLanguage() == castOther.getLanguage()) || (this
						.getLanguage() != null
						&& castOther.getLanguage() != null && this
						.getLanguage().equals(castOther.getLanguage())))
				&& ((this.getWorkYear() == castOther.getWorkYear()) || (this
						.getWorkYear() != null
						&& castOther.getWorkYear() != null && this
						.getWorkYear().equals(castOther.getWorkYear())))
				&& ((this.getTargetTrade() == castOther.getTargetTrade()) || (this
						.getTargetTrade() != null
						&& castOther.getTargetTrade() != null && this
						.getTargetTrade().equals(castOther.getTargetTrade())))
				&& ((this.getTargetFunction() == castOther.getTargetFunction()) || (this
						.getTargetFunction() != null
						&& castOther.getTargetFunction() != null && this
						.getTargetFunction().equals(
								castOther.getTargetFunction())))
				&& ((this.getJobType() == castOther.getJobType()) || (this
						.getJobType() != null && castOther.getJobType() != null && this
						.getJobType().equals(castOther.getJobType())))
				&& ((this.getTargetSalary() == castOther.getTargetSalary()) || (this
						.getTargetSalary() != null
						&& castOther.getTargetSalary() != null && this
						.getTargetSalary().equals(castOther.getTargetSalary())))
				&& ((this.getWorkExperience() == castOther.getWorkExperience()) || (this
						.getWorkExperience() != null
						&& castOther.getWorkExperience() != null && this
						.getWorkExperience().equals(
								castOther.getWorkExperience())))
				&& ((this.getFaith() == castOther.getFaith()) || (this
						.getFaith() != null && castOther.getFaith() != null && this
						.getFaith().equals(castOther.getFaith())))
				&& ((this.getSelfIntroduction() == castOther
						.getSelfIntroduction()) || (this.getSelfIntroduction() != null
						&& castOther.getSelfIntroduction() != null && this
						.getSelfIntroduction().equals(
								castOther.getSelfIntroduction())))
				&& ((this.getPhoto() == castOther.getPhoto()) || (this
						.getPhoto() != null && castOther.getPhoto() != null && this
						.getPhoto().equals(castOther.getPhoto())))
				&& ((this.getCreatTime() == castOther.getCreatTime()) || (this
						.getCreatTime() != null
						&& castOther.getCreatTime() != null && this
						.getCreatTime().equals(castOther.getCreatTime())))
				&& ((this.getModifyTime() == castOther.getModifyTime()) || (this
						.getModifyTime() != null
						&& castOther.getModifyTime() != null && this
						.getModifyTime().equals(castOther.getModifyTime())))
				&& ((this.getViewedCount() == castOther.getViewedCount()) || (this
						.getViewedCount() != null
						&& castOther.getViewedCount() != null && this
						.getViewedCount().equals(castOther.getViewedCount())))
				&& ((this.getSubmitCount() == castOther.getSubmitCount()) || (this
						.getSubmitCount() != null
						&& castOther.getSubmitCount() != null && this
						.getSubmitCount().equals(castOther.getSubmitCount())))
				&& ((this.getIsPosted() == castOther.getIsPosted()) || (this
						.getIsPosted() != null
						&& castOther.getIsPosted() != null && this
						.getIsPosted().equals(castOther.getIsPosted())))
				&& ((this.getIsDisabled() == castOther.getIsDisabled()) || (this
						.getIsDisabled() != null
						&& castOther.getIsDisabled() != null && this
						.getIsDisabled().equals(castOther.getIsDisabled())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getResumeId() == null ? 0 : this.getResumeId().hashCode());
		result = 37 * result
				+ (getPerson() == null ? 0 : this.getPerson().hashCode());
		result = 37 * result
				+ (getMajor() == null ? 0 : this.getMajor().hashCode());
		result = 37 * result
				+ (getAward() == null ? 0 : this.getAward().hashCode());
		result = 37 * result
				+ (getSchool() == null ? 0 : this.getSchool().hashCode());
		result = 37 * result
				+ (getLanguage() == null ? 0 : this.getLanguage().hashCode());
		result = 37 * result
				+ (getWorkYear() == null ? 0 : this.getWorkYear().hashCode());
		result = 37 * result
				+ (getTargetTrade() == null ? 0 : this.getTargetTrade().hashCode());
		result = 37 * result
				+ (getTargetFunction() == null ? 0 : this.getTargetFunction().hashCode());
		result = 37 * result
				+ (getJobType() == null ? 0 : this.getJobType().hashCode());
		result = 37 * result
				+ (getTargetSalary() == null ? 0 : this.getTargetSalary().hashCode());
		result = 37 * result
				+ (getWorkExperience() == null ? 0 : this.getWorkExperience().hashCode());
		result = 37 * result
				+ (getFaith() == null ? 0 : this.getFaith().hashCode());
		result = 37 * result
				+ (getSelfIntroduction() == null ? 0 : this.getSelfIntroduction().hashCode());
		result = 37 * result
				+ (getPhoto() == null ? 0 : this.getPhoto().hashCode());
		result = 37 * result
				+ (getCreatTime() == null ? 0 : this.getCreatTime().hashCode());
		result = 37 * result
				+ (getModifyTime() == null ? 0 : this.getModifyTime().hashCode());
		result = 37 * result
				+ (getViewedCount() == null ? 0 : this.getViewedCount().hashCode());
		result = 37 * result
				+ (getSubmitCount() == null ? 0 : this.getSubmitCount().hashCode());
		result = 37 * result
				+ (getIsPosted() == null ? 0 : this.getIsPosted().hashCode());
		result = 37 * result
				+ (getIsDisabled() == null ? 0 : this.getIsDisabled().hashCode());
		return result;
	}

}