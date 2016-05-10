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
@Table(name = "c_invite", catalog = "rczp")
public class Invite implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Long id;
	private Long userId;
	private Date sentTime;
	private Integer inviteType;
	private Long targetUserId;
	private Long resumeId;
	private Date time;
	private String address;
	private String hrName;
	private String tel;
	private Integer isViewed;
	private Integer isRefused;
	private Integer isDeleted;
	private Integer isDisabled;

	// Constructors

	/** default constructor */
	public Invite() {
	}

	/** minimal constructor */
	public Invite(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Invite(Long id, Long userId, Date sentTime,
			Integer inviteType, Long targetUserId, Long resumeId, Date time,
			String address, String hrName, String tel, Integer isViewed,
			Integer isRefused, Integer isDeleted, Integer isDisabled) {
		this.id = id;
		this.userId = userId;
		this.sentTime = sentTime;
		this.inviteType = inviteType;
		this.targetUserId = targetUserId;
		this.resumeId = resumeId;
		this.time = time;
		this.address = address;
		this.hrName = hrName;
		this.tel = tel;
		this.isViewed = isViewed;
		this.isRefused = isRefused;
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

	@Column(name = "sent_time", length = 19)
	public Date getSentTime() {
		return this.sentTime;
	}

	public void setSentTime(Date sentTime) {
		this.sentTime = sentTime;
	}

	@Column(name = "invite_type")
	public Integer getInviteType() {
		return this.inviteType;
	}

	public void setInviteType(Integer inviteType) {
		this.inviteType = inviteType;
	}

	@Column(name = "target_user_id")
	public Long getTargetUserId() {
		return this.targetUserId;
	}

	public void setTargetUserId(Long targetUserId) {
		this.targetUserId = targetUserId;
	}

	@Column(name = "resume_id")
	public Long getResumeId() {
		return this.resumeId;
	}

	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}

	@Column(name = "time", length = 19)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "hr_name", length = 30)
	public String getHrName() {
		return this.hrName;
	}

	public void setHrName(String hrName) {
		this.hrName = hrName;
	}

	@Column(name = "tel", length = 20)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "is_viewed")
	public Integer getIsViewed() {
		return this.isViewed;
	}

	public void setIsViewed(Integer isViewed) {
		this.isViewed = isViewed;
	}

	@Column(name = "is_refused")
	public Integer getIsRefused() {
		return this.isRefused;
	}

	public void setIsRefused(Integer isRefused) {
		this.isRefused = isRefused;
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
		if (!(other instanceof Invite))
			return false;
		Invite castOther = (Invite) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getSentTime() == castOther.getSentTime()) || (this
						.getSentTime() != null
						&& castOther.getSentTime() != null && this
						.getSentTime().equals(castOther.getSentTime())))
				&& ((this.getInviteType() == castOther.getInviteType()) || (this
						.getInviteType() != null
						&& castOther.getInviteType() != null && this
						.getInviteType().equals(castOther.getInviteType())))
				&& ((this.getTargetUserId() == castOther.getTargetUserId()) || (this
						.getTargetUserId() != null
						&& castOther.getTargetUserId() != null && this
						.getTargetUserId().equals(castOther.getTargetUserId())))
				&& ((this.getResumeId() == castOther.getResumeId()) || (this
						.getResumeId() != null && castOther.getResumeId() != null && this
						.getResumeId().equals(castOther.getResumeId())))
				&& ((this.getTime() == castOther.getTime()) || (this.getTime() != null
						&& castOther.getTime() != null && this.getTime()
						.equals(castOther.getTime())))
				&& ((this.getAddress() == castOther.getAddress()) || (this
						.getAddress() != null && castOther.getAddress() != null && this
						.getAddress().equals(castOther.getAddress())))
				&& ((this.getHrName() == castOther.getHrName()) || (this
						.getHrName() != null && castOther.getHrName() != null && this
						.getHrName().equals(castOther.getHrName())))
				&& ((this.getTel() == castOther.getTel()) || (this.getTel() != null
						&& castOther.getTel() != null && this.getTel().equals(
						castOther.getTel())))
				&& ((this.getIsViewed() == castOther.getIsViewed()) || (this
						.getIsViewed() != null
						&& castOther.getIsViewed() != null && this
						.getIsViewed().equals(castOther.getIsViewed())))
				&& ((this.getIsRefused() == castOther.getIsRefused()) || (this
						.getIsRefused() != null
						&& castOther.getIsRefused() != null && this
						.getIsRefused().equals(castOther.getIsRefused())))
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
				+ (getSentTime() == null ? 0 : this.getSentTime().hashCode());
		result = 37
				* result
				+ (getInviteType() == null ? 0 : this.getInviteType()
						.hashCode());
		result = 37
				* result
				+ (getTargetUserId() == null ? 0 : this.getTargetUserId()
						.hashCode());
		result = 37 * result
				+ (getResumeId() == null ? 0 : this.getResumeId().hashCode());
		result = 37 * result
				+ (getTime() == null ? 0 : this.getTime().hashCode());
		result = 37 * result
				+ (getAddress() == null ? 0 : this.getAddress().hashCode());
		result = 37 * result
				+ (getHrName() == null ? 0 : this.getHrName().hashCode());
		result = 37 * result
				+ (getTel() == null ? 0 : this.getTel().hashCode());
		result = 37 * result
				+ (getIsViewed() == null ? 0 : this.getIsViewed().hashCode());
		result = 37 * result
				+ (getIsRefused() == null ? 0 : this.getIsRefused().hashCode());
		result = 37 * result
				+ (getIsDeleted() == null ? 0 : this.getIsDeleted().hashCode());
		result = 37
				* result
				+ (getIsDisabled() == null ? 0 : this.getIsDisabled()
						.hashCode());
		return result;
	}

}