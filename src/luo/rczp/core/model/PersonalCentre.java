package luo.rczp.core.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "b_personal_centre", catalog = "rczp") 
public class PersonalCentre implements
		java.io.Serializable {

	// Fields

	private Long userId;
	private Integer msgCount;
	private Integer jobCollectCount;
	private Integer jobApplyCount;
	private Integer inviteCount;
	private Integer resCount;
	private Integer resViewCount;

	// Constructors

	/** default constructor */
	public PersonalCentre() {
	}

	/** minimal constructor */
	public PersonalCentre(Long userId) {
		this.userId = userId;
	}

	/** full constructor */
	public PersonalCentre(Long userId, Integer msgCount,
			Integer jobCollectCount, Integer jobApplyCount, Integer inviteCount,
			Integer resCount, Integer resViewCount) {
		this.userId = userId;
		this.msgCount = msgCount;
		this.jobCollectCount = jobCollectCount;
		this.jobApplyCount = jobApplyCount;
		this.inviteCount = inviteCount;
		this.resCount = resCount;
		this.resViewCount = resViewCount;
	}

	// Property accessors

	@Id
	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "msg_count")
	public Integer getMsgCount() {
		return this.msgCount;
	}

	public void setMsgCount(Integer msgCount) {
		this.msgCount = msgCount;
	}

	@Column(name = "job_collect_count")
	public Integer getJobCollectCount() {
		return this.jobCollectCount;
	}

	public void setJobCollectCount(Integer jobCollectCount) {
		this.jobCollectCount = jobCollectCount;
	}

	@Column(name = "job_apply_count")
	public Integer getJobApplyCount() {
		return this.jobApplyCount;
	}

	public void setJobApplyCount(Integer jobApplyCount) {
		this.jobApplyCount = jobApplyCount;
	}

	@Column(name = "invit_count")
	public Integer getInviteCount() {
		return this.inviteCount;
	}

	public void setInviteCount(Integer inviteCount) {
		this.inviteCount = inviteCount;
	}

	@Column(name = "res_count")
	public Integer getResCount() {
		return this.resCount;
	}

	public void setResCount(Integer resCount) {
		this.resCount = resCount;
	}

	@Column(name = "res_view_count")
	public Integer getResViewCount() {
		return this.resViewCount;
	}

	public void setResViewCount(Integer resViewCount) {
		this.resViewCount = resViewCount;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PersonalCentre))
			return false;
		PersonalCentre castOther = (PersonalCentre) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getMsgCount() == castOther.getMsgCount()) || (this
						.getMsgCount() != null
						&& castOther.getMsgCount() != null && this
						.getMsgCount().equals(castOther.getMsgCount())))
				&& ((this.getJobCollectCount() == castOther
						.getJobCollectCount()) || (this.getJobCollectCount() != null
						&& castOther.getJobCollectCount() != null && this
						.getJobCollectCount().equals(
								castOther.getJobCollectCount())))
				&& ((this.getJobApplyCount() == castOther.getJobApplyCount()) || (this
						.getJobApplyCount() != null
						&& castOther.getJobApplyCount() != null && this
						.getJobApplyCount()
						.equals(castOther.getJobApplyCount())))
				&& ((this.getInviteCount() == castOther.getInviteCount()) || (this
						.getInviteCount() != null
						&& castOther.getInviteCount() != null && this
						.getInviteCount().equals(castOther.getInviteCount())))
				&& ((this.getResCount() == castOther.getResCount()) || (this
						.getResCount() != null
						&& castOther.getResCount() != null && this
						.getResCount().equals(castOther.getResCount())))
				&& ((this.getResViewCount() == castOther.getResViewCount()) || (this
						.getResViewCount() != null
						&& castOther.getResViewCount() != null && this
						.getResViewCount().equals(castOther.getResViewCount())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getMsgCount() == null ? 0 : this.getMsgCount().hashCode());
		result = 37
				* result
				+ (getJobCollectCount() == null ? 0 : this.getJobCollectCount()
						.hashCode());
		result = 37
				* result
				+ (getJobApplyCount() == null ? 0 : this.getJobApplyCount()
						.hashCode());
		result = 37
				* result
				+ (getInviteCount() == null ? 0 : this.getInviteCount()
						.hashCode());
		result = 37 * result
				+ (getResCount() == null ? 0 : this.getResCount().hashCode());
		result = 37
				* result
				+ (getResViewCount() == null ? 0 : this.getResViewCount()
						.hashCode());
		return result;
	}

}