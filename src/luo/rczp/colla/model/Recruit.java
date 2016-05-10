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
@Table(name = "c_recruit", catalog = "rczp")
public class Recruit implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Long id;
	private UserAcount company;
	private Long parentTrade;
	private Long trade;
	private Long grandFunction;
	private Long parentFunction;
	private Long function;
	private Long province;
	private Long city;
	private Long county;
	private Integer numRequire;
	private Integer experience;
	private Integer jobType;
	private Integer salary;
	private String discription;
	private Date postTime;
	private Integer viewCount;
	private Integer resumeCount;
	private Integer msgCount;
	private Integer isDisabled;

	// Constructors

	/** default constructor */
	public Recruit() {
	}

	/** minimal constructor */
	public Recruit(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Recruit(Long id, UserAcount company, Long parentTrade, Long trade, 
			Long grandFunction, Long parentFunction, Long function, Long province, Long city, Long county,
			Integer numRequire, Integer experience,
			Integer jobType, Integer salary, String discription,
			Date postTime, Integer viewCount, Integer resumeCount,
			Integer msgCount, Integer isDisabled) {
		this.id = id;
		this.company = company;
		this.trade = trade;
		this.grandFunction = grandFunction;
		this.parentFunction = parentFunction;
		this.function = function;
		this.province = province;
		this.city = city;
		this.county = county;
		this.numRequire = numRequire;
		this.experience = experience;
		this.jobType = jobType;
		this.salary = salary;
		this.discription = discription;
		this.postTime = postTime;
		this.viewCount = viewCount;
		this.resumeCount = resumeCount;
		this.msgCount = msgCount;
		this.isDisabled = isDisabled;
	}

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "comp_id")
	public UserAcount getCompany() {
		return this.company;
	}

	public void setCompany(UserAcount company) {
		this.company = company;
	}

	@Column(name = "parent_trade")
	public Long getParentTrade() {
		return this.parentTrade;
	}

	public void setParentTrade(Long parentTrade) {
		this.parentTrade = parentTrade;
	}

	@Column(name = "trade")
	public Long getTrade() {
		return this.trade;
	}

	public void setTrade(Long trade) {
		this.trade = trade;
	}

	@Column(name = "grand_function")
	public Long getGrandFunction() {
		return this.grandFunction;
	}

	public void setGrandFunction(Long grandFunction) {
		this.grandFunction = grandFunction;
	}
	
	@Column(name = "parent_function")
	public Long getParentFunction() {
		return this.parentFunction;
	}

	public void setParentFunction(Long parentFunction) {
		this.parentFunction = parentFunction;
	}
	
	@Column(name = "function")
	public Long getFunction() {
		return this.function;
	}

	public void setFunction(Long function) {
		this.function = function;
	}
	
	@Column(name = "province")
	public Long getProvince() {
		return this.province;
	}

	public void setProvince(Long province) {
		this.province = province;
	}
	
	@Column(name = "city")
	public Long getCity() {
		return this.city;
	}

	public void setCity(Long city) {
		this.city = city;
	}
	
	@Column(name = "county")
	public Long getCounty() {
		return this.county;
	}

	public void setCounty(Long county) {
		this.county = county;
	}

	@Column(name = "num_require")
	public Integer getNumRequire() {
		return this.numRequire;
	}

	public void setNumRequire(Integer numRequire) {
		this.numRequire = numRequire;
	}

	@Column(name = "experience")
	public Integer getExperience() {
		return this.experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	@Column(name = "job_type")
	public Integer getJobType() {
		return this.jobType;
	}

	public void setJobType(Integer jobType) {
		this.jobType = jobType;
	}

	@Column(name = "salary")
	public Integer getSalary() {
		return this.salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Column(name = "discription", length = 600)
	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Column(name = "post_time", length = 19)
	public Date getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	@Column(name = "view_count")
	public Integer getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	@Column(name = "resume_count")
	public Integer getResumeCount() {
		return this.resumeCount;
	}

	public void setResumeCount(Integer resumeCount) {
		this.resumeCount = resumeCount;
	}

	@Column(name = "msg_count")
	public Integer getMsgCount() {
		return this.msgCount;
	}

	public void setMsgCount(Integer msgCount) {
		this.msgCount = msgCount;
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
		if (!(other instanceof Recruit))
			return false;
		Recruit castOther = (Recruit) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getCompany() == castOther.getCompany()) || (this
						.getCompany() != null && castOther.getCompany() != null && this
						.getCompany().equals(castOther.getCompany())))
				&& ((this.getTrade() == castOther.getTrade()) || (this
						.getTrade() != null && castOther.getTrade() != null && this
						.getTrade().equals(castOther.getTrade())))
				&& ((this.getFunction() == castOther.getFunction()) || (this
						.getFunction() != null
						&& castOther.getFunction() != null && this
						.getFunction().equals(castOther.getFunction())))
				&& ((this.getNumRequire() == castOther.getNumRequire()) || (this
						.getNumRequire() != null
						&& castOther.getNumRequire() != null && this
						.getNumRequire().equals(castOther.getNumRequire())))
				&& ((this.getExperience() == castOther.getExperience()) || (this
						.getExperience() != null
						&& castOther.getExperience() != null && this
						.getExperience().equals(castOther.getExperience())))
				&& ((this.getJobType() == castOther.getJobType()) || (this
						.getJobType() != null && castOther.getJobType() != null && this
						.getJobType().equals(castOther.getJobType())))
				&& ((this.getSalary() == castOther.getSalary()) || (this
						.getSalary() != null && castOther.getSalary() != null && this
						.getSalary().equals(castOther.getSalary())))
				&& ((this.getDiscription() == castOther.getDiscription()) || (this
						.getDiscription() != null
						&& castOther.getDiscription() != null && this
						.getDiscription().equals(castOther.getDiscription())))
				&& ((this.getPostTime() == castOther.getPostTime()) || (this
						.getPostTime() != null
						&& castOther.getPostTime() != null && this
						.getPostTime().equals(castOther.getPostTime())))
				&& ((this.getViewCount() == castOther.getViewCount()) || (this
						.getViewCount() != null
						&& castOther.getViewCount() != null && this
						.getViewCount().equals(castOther.getViewCount())))
				&& ((this.getResumeCount() == castOther.getResumeCount()) || (this
						.getResumeCount() != null
						&& castOther.getResumeCount() != null && this
						.getResumeCount().equals(castOther.getResumeCount())))
				&& ((this.getMsgCount() == castOther.getMsgCount()) || (this
						.getMsgCount() != null
						&& castOther.getMsgCount() != null && this
						.getMsgCount().equals(castOther.getMsgCount())))
				&& ((this.getIsDisabled() == castOther.getIsDisabled()) || (this
						.getIsDisabled() != null
						&& castOther.getIsDisabled() != null && this
						.getIsDisabled().equals(castOther.getIsDisabled())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getCompany() == null ? 0 : this.getCompany().hashCode());
		result = 37 * result
				+ (getTrade() == null ? 0 : this.getTrade().hashCode());
		result = 37 * result
				+ (getFunction() == null ? 0 : this.getFunction().hashCode());
		result = 37 * result
				+ (getNumRequire() == null ? 0 : this.getNumRequire()
						.hashCode());
		result = 37
				* result
				+ (getExperience() == null ? 0 : this.getExperience()
						.hashCode());
		result = 37 * result
				+ (getJobType() == null ? 0 : this.getJobType().hashCode());
		result = 37 * result
				+ (getSalary() == null ? 0 : this.getSalary().hashCode());
		result = 37
				* result
				+ (getDiscription() == null ? 0 : this.getDiscription()
						.hashCode());
		result = 37 * result
				+ (getPostTime() == null ? 0 : this.getPostTime().hashCode());
		result = 37 * result
				+ (getViewCount() == null ? 0 : this.getViewCount().hashCode());
		result = 37
				* result
				+ (getResumeCount() == null ? 0 : this.getResumeCount()
						.hashCode());
		result = 37 * result
				+ (getMsgCount() == null ? 0 : this.getMsgCount().hashCode());
		result = 37
				* result
				+ (getIsDisabled() == null ? 0 : this.getIsDisabled()
						.hashCode());
		return result;
	}

}