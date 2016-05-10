package luo.rczp.others.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import luo.rczp.colla.model.Recruit;

@Entity
@Table(name = "d_recruit_tag", catalog = "rczp")
public class RecruitTag implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields

	private Long tagId;
	private String tagName;
	private Integer tagType;
	private Recruit recruit;
	private Integer isActive;

	// Constructors

	/** default constructor */
	public RecruitTag() {
	}

	/** minimal constructor */
	public RecruitTag(Long tagId) {
		this.tagId = tagId;
	} 

	/** full constructor */
	public RecruitTag(Long tagId, String tagName, Integer tagType, Recruit recruit, Integer isActive) {
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagType = tagType;
		this.recruit = recruit;
		this.isActive = isActive;
	}

	// Property accessors
	
	@Id
	@Column(name = "tag_id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getTagId() {
		return this.tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	@Column(name = "tag_name", length = 50)
	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Column(name = "tag_type", length = 50)
	public Integer getTagType() {
		return this.tagType;
	}
	
	public void setTagType(Integer tagType) {
		this.tagType = tagType;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "relate_id")
	public Recruit getRecruit() {
		return this.recruit;
	}

	public void setRecruit(Recruit recruit) {
		this.recruit = recruit;
	}

	@Column(name = "is_active")
	public Integer getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}