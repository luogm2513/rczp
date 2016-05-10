package luo.rczp.core.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "b_comp_centre", catalog = "rczp")
public class CompCentre implements java.io.Serializable {

	private Long userId;
	private Integer msgCount;
	private Integer recruitCount;
	private Integer resumeReceive;
	private Integer resumeCollect;
	private Integer inviteCount;
	private Integer recruitViewCount;

	// Constructors

	/** default constructor */
	public CompCentre() {
	}

	/** full constructor */
	public CompCentre(Long userId, Integer msgCount, Integer recruitCount,
			Integer resumeReceive, Integer resumeCollect, Integer inviteCount,
			Integer recruitViewCount) {
		this.userId = userId;
		this.msgCount = msgCount;
		this.recruitCount = recruitCount;
		this.resumeReceive = resumeReceive;
		this.resumeCollect = resumeCollect;
		this.inviteCount = inviteCount;
		this.recruitViewCount = recruitViewCount;
	}

	// Property accessors

	@Id
	@Column(name = "user_id")
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

	@Column(name = "recruit_count")
	public Integer getRecruitCount() {
		return this.recruitCount;
	}

	public void setRecruitCount(Integer recruitCount) {
		this.recruitCount = recruitCount;
	}

	@Column(name = "resume_receive")
	public Integer getResumeReceive() {
		return this.resumeReceive;
	}

	public void setResumeReceive(Integer resumeReceive) {
		this.resumeReceive = resumeReceive;
	}

	@Column(name = "resume_collect")
	public Integer getResumeCollect() {
		return this.resumeCollect;
	}

	public void setResumeCollect(Integer resumeCollect) {
		this.resumeCollect = resumeCollect;
	}

	@Column(name = "invit_count")
	public Integer getInviteCount() {
		return this.inviteCount;
	}

	public void setInviteCount(Integer inviteCount) {
		this.inviteCount = inviteCount;
	}

	@Column(name = "recruit_view_count")
	public Integer getRecruitViewCount() {
		return this.recruitViewCount;
	}

	public void setRecruitViewCount(Integer recruitViewCount) {
		this.recruitViewCount = recruitViewCount;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CompCentre))
			return false;
		CompCentre castOther = (CompCentre) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getMsgCount() == castOther.getMsgCount()) || (this
						.getMsgCount() != null
						&& castOther.getMsgCount() != null && this
						.getMsgCount().equals(castOther.getMsgCount())))
				&& ((this.getRecruitCount() == castOther.getRecruitCount()) || (this
						.getRecruitCount() != null
						&& castOther.getRecruitCount() != null && this
						.getRecruitCount().equals(castOther.getRecruitCount())))
				&& ((this.getResumeReceive() == castOther.getResumeReceive()) || (this
						.getResumeReceive() != null
						&& castOther.getResumeReceive() != null && this
						.getResumeReceive()
						.equals(castOther.getResumeReceive())))
				&& ((this.getResumeCollect() == castOther.getResumeCollect()) || (this
						.getResumeCollect() != null
						&& castOther.getResumeCollect() != null && this
						.getResumeCollect()
						.equals(castOther.getResumeCollect())))
				&& ((this.getInviteCount() == castOther.getInviteCount()) || (this
						.getInviteCount() != null
						&& castOther.getInviteCount() != null && this
						.getInviteCount().equals(castOther.getInviteCount())))
				&& ((this.getRecruitViewCount() == castOther
						.getRecruitViewCount()) || (this.getRecruitViewCount() != null
						&& castOther.getRecruitViewCount() != null && this
						.getRecruitViewCount().equals(
								castOther.getRecruitViewCount())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getMsgCount() == null ? 0 : this.getMsgCount().hashCode());
		result = 37
				* result
				+ (getRecruitCount() == null ? 0 : this.getRecruitCount()
						.hashCode());
		result = 37
				* result
				+ (getResumeReceive() == null ? 0 : this.getResumeReceive()
						.hashCode());
		result = 37
				* result
				+ (getResumeCollect() == null ? 0 : this.getResumeCollect()
						.hashCode());
		result = 37
				* result
				+ (getInviteCount() == null ? 0 : this.getInviteCount()
						.hashCode());
		result = 37
				* result
				+ (getRecruitViewCount() == null ? 0 : this
						.getRecruitViewCount().hashCode());
		return result;
	}

}