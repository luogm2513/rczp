package luo.rczp.colla.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "c_resume_receive", catalog = "rczp")
public class ResumeReceive implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Resume resume;
	private Recruit recruit;
	private Date receiveTime;
	private Integer isViewed;
	private Integer isRemoved;

	// Constructors

	/** default constructor */
	public ResumeReceive() {
	}

	/** minimal constructor */
	public ResumeReceive(Long id) {
		this.id = id;
	}

	/** full constructor */
	public ResumeReceive(Long id, Resume resume, Recruit recruit,
			Date receiveTime, Integer isViewed, Integer isRemoved) {
		this.id = id;
		this.resume = resume;
		this.recruit = recruit;
		this.receiveTime = receiveTime;
		this.isViewed = isViewed;
		this.isRemoved = isRemoved;
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

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "resume_id")
	public Resume getResume() {
		return this.resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "recruit_id")
	public Recruit getRecruit() {
		return this.recruit;
	}

	public void setRecruit(Recruit recruit) {
		this.recruit = recruit;
	}

	@Column(name = "receive_time", length = 19)
	public Date getReceiveTime() {
		return this.receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	@Column(name = "is_viewed")
	public Integer getIsViewed() {
		return this.isViewed;
	}

	public void setIsViewed(Integer isViewed) {
		this.isViewed = isViewed;
	}

	@Column(name = "is_removed")
	public Integer getIsRemoved() {
		return this.isRemoved;
	}

	public void setIsRemoved(Integer isRemoved) {
		this.isRemoved = isRemoved;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ResumeReceive))
			return false;
		ResumeReceive castOther = (ResumeReceive) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getReceiveTime() == castOther.getReceiveTime()) || (this
						.getReceiveTime() != null
						&& castOther.getReceiveTime() != null && this
						.getReceiveTime().equals(castOther.getReceiveTime())))
				&& ((this.getIsViewed() == castOther.getIsViewed()) || (this
						.getIsViewed() != null
						&& castOther.getIsViewed() != null && this
						.getIsViewed().equals(castOther.getIsViewed())))
				&& ((this.getIsRemoved() == castOther.getIsRemoved()) || (this
						.getIsRemoved() != null
						&& castOther.getIsRemoved() != null && this
						.getIsRemoved().equals(castOther.getIsRemoved())));
	}

	public int hashCode() {
		int result = 17;
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result + (getReceiveTime() == null ? 0 : this.getReceiveTime().hashCode());
		result = 37 * result
				+ (getIsViewed() == null ? 0 : this.getIsViewed().hashCode());
		result = 37 * result
				+ (getIsRemoved() == null ? 0 : this.getIsRemoved().hashCode());
		return result;
	}

}