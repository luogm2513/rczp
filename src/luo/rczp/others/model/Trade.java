package luo.rczp.others.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "d_trade", catalog = "rczp")
public class Trade implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Long id;
	private Long parentId;
	private String tradeName;
	private Integer grand;
	private Integer isActive;

	// Constructors

	/** default constructor */
	public Trade() {
	}

	/** minimal constructor */
	public Trade(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Trade(Long id, Long parentId, String tradeName, Integer grand,
			Integer isActive) {
		this.id = id;
		this.parentId = parentId;
		this.tradeName = tradeName;
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

	@Column(name = "trade_name", length = 30)
	public String getTradeName() {
		return this.tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
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