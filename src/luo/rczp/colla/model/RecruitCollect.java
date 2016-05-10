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
@Table(name = "c_recruit_collect", catalog = "rczp")
public class RecruitCollect implements
		java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Long id;
	private Long userId;
	private Long recruitId;
	private Date collectTime;
	private Integer isDisabled;

	// Constructors

	/** default constructor */
	public RecruitCollect() {
	}

	/** minimal constructor */
	public RecruitCollect(Long id) {
		this.id = id;
	}

	/** full constructor */
	public RecruitCollect(Long id, Long userId, Long recruitId,
			Date collectTime, Integer isDisabled) {
		this.id = id;
		this.userId = userId;
		this.recruitId = recruitId;
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

	@Column(name = "user_id")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "recruit_id")
	public Long getRecruitId() {
		return this.recruitId;
	}

	public void setRecruitId(Long recruitId) {
		this.recruitId = recruitId;
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
		if (!(other instanceof RecruitCollect))
			return false;
		RecruitCollect castOther = (RecruitCollect) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getRecruitId() == castOther.getRecruitId()) || (this
						.getRecruitId() != null
						&& castOther.getRecruitId() != null && this
						.getRecruitId().equals(castOther.getRecruitId())))
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
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getRecruitId() == null ? 0 : this.getRecruitId().hashCode());
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