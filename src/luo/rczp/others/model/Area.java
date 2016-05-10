package luo.rczp.others.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "d_area", catalog = "rczp")
public class Area implements java.io.Serializable {

	// Fields

	private Long areaId;
	private Long parentAreaId;
	private String areaCode;
	private String areaName;
	private Integer grade;
	private Integer isActive;

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** minimal constructor */
	public Area(Long areaId, Integer isActive) {
		this.areaId = areaId;
		this.isActive = isActive;
	}

	/** full constructor */
	public Area(Long areaId, Long parentAreaId, String areaCode,
			String areaName, Integer grade, Integer isActive) {
		this.areaId = areaId;
		this.parentAreaId = parentAreaId;
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.grade = grade;
		this.isActive = isActive;
	}

	// Property accessors
	@Id
	@Column(name = "area_id", unique = true, nullable = false)
	public Long getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	@Column(name = "parentArea_id")
	public Long getParentAreaId() {
		return this.parentAreaId;
	}

	public void setParentAreaId(Long parentAreaId) {
		this.parentAreaId = parentAreaId;
	}

	@Column(name = "area_code", length = 20)
	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	@Column(name = "area_name", length = 50)
	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Column(name = "grade")
	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Column(name = "is_active", nullable = false)
	public Integer getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}