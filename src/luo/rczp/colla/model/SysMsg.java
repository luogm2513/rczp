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
@Table(name = "s_sys_msg", catalog = "rczp")
public class SysMsg implements java.io.Serializable {

	// Fields

	private Long id;
	private String content;
	private Date sendTime;
	private Long sender;
	private Long receiver;
	private Integer isViewed;
	private Integer isDeleted;
	private Integer isDisabled;

	// Constructors

	/** default constructor */
	public SysMsg() {
	}

	/** minimal constructor */
	public SysMsg(Long id) {
		this.id = id;
	}

	/** full constructor */
	public SysMsg(Long id, String content, Date sendTime, Long sender,
			Long receiver, Integer isViewed, Integer isDeleted, Integer isDisabled) {
		this.id = id;
		this.content = content;
		this.sendTime = sendTime;
		this.sender = sender;
		this.receiver = receiver;
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

	@Column(name = "content", length = 300)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "send_time", length = 19)
	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "sender")
	public Long getSender() {
		return this.sender;
	}

	public void setSender(Long sender) {
		this.sender = sender;
	}

	@Column(name = "receiver")
	public Long getReceiver() {
		return this.receiver;
	}

	public void setReceiver(Long receiver) {
		this.receiver = receiver;
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
		if (!(other instanceof SysMsg))
			return false;
		SysMsg castOther = (SysMsg) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getContent() == castOther.getContent()) || (this
						.getContent() != null && castOther.getContent() != null && this
						.getContent().equals(castOther.getContent())))
				&& ((this.getSendTime() == castOther.getSendTime()) || (this
						.getSendTime() != null
						&& castOther.getSendTime() != null && this
						.getSendTime().equals(castOther.getSendTime())))
				&& ((this.getSender() == castOther.getSender()) || (this
						.getSender() != null && castOther.getSender() != null && this
						.getSender().equals(castOther.getSender())))
				&& ((this.getReceiver() == castOther.getReceiver()) || (this
						.getReceiver() != null
						&& castOther.getReceiver() != null && this
						.getReceiver().equals(castOther.getReceiver())))
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
				+ (getContent() == null ? 0 : this.getContent().hashCode());
		result = 37 * result
				+ (getSendTime() == null ? 0 : this.getSendTime().hashCode());
		result = 37 * result
				+ (getSender() == null ? 0 : this.getSender().hashCode());
		result = 37 * result
				+ (getReceiver() == null ? 0 : this.getReceiver().hashCode());
		result = 37 * result
				+ (getIsViewed() == null ? 0 : this.getIsViewed().hashCode());
		result = 37 * result
				+ (getIsDeleted() == null ? 0 : this.getIsDeleted().hashCode());
		result = 37
				* result
				+ (getIsDisabled() == null ? 0 : this.getIsDisabled()
						.hashCode());
		return result;
	}

}