package luo.rczp.colla.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c_resume_collect", catalog = "rczp")
public class ResumeCollect implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields

	private Long id;
	private Long resumeId;
	private Long compId;
	private Date collectTime;
	private Integer isDisabled;

	// Constructors

	/** default constructor */
	public ResumeCollect() {
	}

	/** minimal constructor */
	public ResumeCollect(Long id) {
		this.id = id;
	}

	/** full constructor */
	public ResumeCollect(Long id, Long resumeId, Long compId,
			Date collectTime, Integer isDisabled) {
		this.id = id;
		this.resumeId = resumeId;
		this.compId = compId;
		this.collectTime = collectTime;
		this.isDisabled = isDisabled;
	}

	// Property accessors

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "resume_id")
	public Long getResumeId() {
		return this.resumeId;
	}

	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}

	@Column(name = "comp_id")
	public Long getCompId() {
		return this.compId;
	}

	public void setCompId(Long compId) {
		this.compId = compId;
	}

	@Column(name = "collect_time", length = 19)
	public Date getCollectTime() {
		return this.collectTime;
	}

	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
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
		if (!(other instanceof ResumeCollect))
			return false;
		ResumeCollect castOther = (ResumeCollect) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getResumeId() == castOther.getResumeId()) || (this
						.getResumeId() != null
						&& castOther.getResumeId() != null && this
						.getResumeId().equals(castOther.getResumeId())))
				&& ((this.getCompId() == castOther.getCompId()) || (this
						.getCompId() != null && castOther.getCompId() != null && this
						.getCompId().equals(castOther.getCompId())))
				&& ((this.getCollectTime() == castOther.getCollectTime()) || (this
						.getCollectTime() != null
						&& castOther.getCollectTime() != null && this
						.getCollectTime().equals(castOther.getCollectTime())))
				&& ((this.getIsDisabled() == castOther.getIsDisabled()) || (this
						.getIsDisabled() != null
						&& castOther.getIsDisabled() != null && this
						.getIsDisabled().equals(castOther.getIsDisabled())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getResumeId() == null ? 0 : this.getResumeId().hashCode());
		result = 37 * result
				+ (getCompId() == null ? 0 : this.getCompId().hashCode());
		result = 37
				* result
				+ (getCollectTime() == null ? 0 : this.getCollectTime()
						.hashCode());
		result = 37
				* result
				+ (getIsDisabled() == null ? 0 : this.getIsDisabled()
						.hashCode());
		return result;
	}

}