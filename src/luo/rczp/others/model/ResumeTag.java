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

import luo.rczp.colla.model.Resume;

@Entity
@Table(name = "d_resume_tag", catalog = "rczp")
public class ResumeTag implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields

	private Long tagId;
	private String tagName;
	private Integer tagType;
	private Resume resume;
	private Integer isActive;

	// Constructors

	/** default constructor */
	public ResumeTag() {
	}

	/** minimal constructor */
	public ResumeTag(Long tagId) {
		this.tagId = tagId;
	}

	/** full constructor */
	public ResumeTag(Long tagId, String tagName, Integer tagType, Resume resume, Integer isActive) {
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagType = tagType;
		this.resume = resume;
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
	public Resume getResume() {
		return this.resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	@Column(name = "is_active")
	public Integer getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}