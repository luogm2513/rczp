package luo.rczp.others.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "d_function", catalog = "rczp")
public class Function implements java.io.Serializable {

	// Fields

	private Long id;
	private Long parentId;
	private String funcName;
	private Integer grand;
	private Integer isActive;

	// Constructors

	/** default constructor */
	public Function() {
	}

	/** minimal constructor */
	public Function(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Function(Long id, Long parentId, String funcName, Integer grand,
			Integer isActive) {
		this.id = id;
		this.parentId = parentId;
		this.funcName = funcName;
		this.grand = grand;
		this.isActive = isActive;
	}

	// Property accessors
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "parent_id")
	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "func_name", length = 30)
	public String getFuncName() {
		return this.funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
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