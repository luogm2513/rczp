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
@Table(name = "c_leavemsg", catalog = "rczp")
public class Leavemsg implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Long id;
	private Long userId;
	private Date leaveTime;
	private Long targetUserId;
	private String content;
	private Integer isViewed;
	private Integer isDeleted;
	private Integer isDisabled;

	// Constructors

	/** default constructor */
	public Leavemsg() {
	}

	/** minimal constructor */
	public Leavemsg(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Leavemsg(Long id, Long userId, Date leaveTime,
			Long targetUserId, String content,
			Integer isViewed, Integer isDeleted, Integer isDisabled) {
		this.id = id;
		this.userId = userId;
		this.leaveTime = leaveTime;
		this.targetUserId = targetUserId;
		this.content = content;
		this.isViewed = isViewed;
		this.isDeleted = isDeleted;
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

	@Column(name = "leave_time", length = 19)
	public Date getLeaveTime() {
		return this.leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	@Column(name = "target_user_id")
	public Long getTargetUserId() {
		return this.targetUserId;
	}

	public void setTargetUserId(Long targetUserId) {
		this.targetUserId = targetUserId;
	}

	@Column(name = "content", length = 400)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "is_viewed")
	public Integer getIsViewed() {
		return this.isViewed;
	}

	public void setIsViewed(Integer isViewed) {
		this.isViewed = isViewed;
	}

	@Column(name = "is_deleted")
	public Integer getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
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
		if (!(other instanceof Leavemsg))
			return false;
		Leavemsg castOther = (Leavemsg) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getLeaveTime() == castOther.getLeaveTime()) || (this
						.getLeaveTime() != null
						&& castOther.getLeaveTime() != null && this
						.getLeaveTime().equals(castOther.getLeaveTime())))
				&& ((this.getTargetUserId() == castOther.getTargetUserId()) || (this
						.getTargetUserId() != null
						&& castOther.getTargetUserId() != null && this
						.getTargetUserId().equals(castOther.getTargetUserId())))
				&& ((this.getContent() == castOther.getContent()) || (this
						.getContent() != null && castOther.getContent() != null && this
						.getContent().equals(castOther.getContent())))
				&& ((this.getIsViewed() == castOther.getIsViewed()) || (this
						.getIsViewed() != null
						&& castOther.getIsViewed() != null && this
						.getIsViewed().equals(castOther.getIsViewed())))
				&& ((this.getIsDeleted() == castOther.getIsDeleted()) || (this
						.getIsDeleted() != null
						&& castOther.getIsDeleted() != null && this
						.getIsDeleted().equals(castOther.getIsDeleted())))
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
				+ (getLeaveTime() == null ? 0 : this.getLeaveTime().hashCode());
		result = 37 * result
				+ (getTargetUserId() == null ? 0 : this.getTargetUserId().hashCode());
		result = 37 * result
				+ (getContent() == null ? 0 : this.getContent().hashCode());
		result = 37 * result
				+ (getIsViewed() == null ? 0 : this.getIsViewed().hashCode());
		result = 37 * result
				+ (getIsDeleted() == null ? 0 : this.getIsDeleted().hashCode());
		result = 37 * result
				+ (getIsDisabled() == null ? 0 : this.getIsDisabled().hashCode());
		return result;
	}

}