package luo.rczp.others.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "d_major", catalog = "rczp")
public class Major implements java.io.Serializable {

	// Fields

	private Integer majorId;
	private Integer parentId;
	private String majorName;
	private String code;
	private Integer grand;
	private Integer isActive;

	// Constructors

	/** default constructor */
	public Major() {
	}

	/** minimal constructor */
	public Major(Integer majorId, Integer isActive) {
		this.majorId = majorId;
		this.isActive = isActive;
	}

	/** full constructor */
	public Major(Integer majorId, Integer parentId, String majorName, String code, Integer grand,
			Integer isActive) {
		this.majorId = majorId;
		this.parentId = parentId;
		this.majorName = majorName;
		this.code = code;
		this.grand = grand;
		this.isActive = isActive;
	}

	// Property accessors
	
	@Id
	@Column(name = "major_id", unique = true, nullable = false)
	public Integer getMajorId() {
		return this.majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "major_name", length = 30)
	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	@Column(name = "code", length = 8)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "grand")
	public Integer getGrand() {
		return this.grand;
	}

	public void setGrand(Integer grand) {
		this.grand = grand;
	}

	@Column(name = "is_active")
	public Integer getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}


}