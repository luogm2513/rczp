package luo.rczp.admin.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AdminLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "s_admin_log", catalog = "rczp")
public class AdminLog implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer opUserType;
	private Long opUserId;
	private Date opTime;
	private Integer opType;
	private Integer targetType;
	private Long targetUserId;
	private String opIp;

	// Constructors

	/** default constructor */
	public AdminLog() {
	}

	/** minimal constructor */
	public AdminLog(Long id) {
		this.id = id;
	}

	/** full constructor */
	public AdminLog(Long id, Integer opUserType, Long opUserId,
			Date opTime, Integer opType, Integer targetType,
			Long targetUserId, String opIp) {
		this.id = id;
		this.opUserType = opUserType;
		this.opUserId = opUserId;
		this.opTime = opTime;
		this.opType = opType;
		this.targetType = targetType;
		this.targetUserId = targetUserId;
		this.opIp = opIp;
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

	@Column(name = "op_user_type")
	public Integer getOpUserType() {
		return this.opUserType;
	}

	public void setOpUserType(Integer opUserType) {
		this.opUserType = opUserType;
	}

	@Column(name = "op_user_id")
	public Long getOpUserId() {
		return this.opUserId;
	}

	public void setOpUserId(Long opUserId) {
		this.opUserId = opUserId;
	}

	@Column(name = "op_time", length = 19)
	public Date getOpTime() {
		return this.opTime;
	}

	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}

	@Column(name = "op_type")
	public Integer getOpType() {
		return this.opType;
	}

	public void setOpType(Integer opType) {
		this.opType = opType;
	}

	@Column(name = "target_type")
	public Integer getTargetType() {
		return this.targetType;
	}

	public void setTargetType(Integer targetType) {
		this.targetType = targetType;
	}

	@Column(name = "target_user_id")
	public Long getTargetUserId() {
		return this.targetUserId;
	}

	public void setTargetUserId(Long targetUserId) {
		this.targetUserId = targetUserId;
	}

	@Column(name = "op_ip", length = 30)
	public String getOpIp() {
		return this.opIp;
	}

	public void setOpIp(String opIp) {
		this.opIp = opIp;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AdminLog))
			return false;
		AdminLog castOther = (AdminLog) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getOpUserType() == castOther.getOpUserType()) || (this
						.getOpUserType() != null
						&& castOther.getOpUserType() != null && this
						.getOpUserType().equals(castOther.getOpUserType())))
				&& ((this.getOpUserId() == castOther.getOpUserId()) || (this
						.getOpUserId() != null
						&& castOther.getOpUserId() != null && this
						.getOpUserId().equals(castOther.getOpUserId())))
				&& ((this.getOpTime() == castOther.getOpTime()) || (this
						.getOpTime() != null && castOther.getOpTime() != null && this
						.getOpTime().equals(castOther.getOpTime())))
				&& ((this.getOpType() == castOther.getOpType()) || (this
						.getOpType() != null && castOther.getOpType() != null && this
						.getOpType().equals(castOther.getOpType())))
				&& ((this.getTargetType() == castOther.getTargetType()) || (this
						.getTargetType() != null
						&& castOther.getTargetType() != null && this
						.getTargetType().equals(castOther.getTargetType())))
				&& ((this.getTargetUserId() == castOther.getTargetUserId()) || (this
						.getTargetUserId() != null
						&& castOther.getTargetUserId() != null && this
						.getTargetUserId().equals(castOther.getTargetUserId())))
				&& ((this.getOpIp() == castOther.getOpIp()) || (this.getOpIp() != null
						&& castOther.getOpIp() != null && this.getOpIp()
						.equals(castOther.getOpIp())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getOpUserType() == null ? 0 : this.getOpUserType()
						.hashCode());
		result = 37 * result
				+ (getOpUserId() == null ? 0 : this.getOpUserId().hashCode());
		result = 37 * result
				+ (getOpTime() == null ? 0 : this.getOpTime().hashCode());
		result = 37 * result
				+ (getOpType() == null ? 0 : this.getOpType().hashCode());
		result = 37
				* result
				+ (getTargetType() == null ? 0 : this.getTargetType()
						.hashCode());
		result = 37
				* result
				+ (getTargetUserId() == null ? 0 : this.getTargetUserId()
						.hashCode());
		result = 37 * result
				+ (getOpIp() == null ? 0 : this.getOpIp().hashCode());
		return result;
	}

}