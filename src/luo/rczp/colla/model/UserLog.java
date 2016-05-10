package luo.rczp.colla.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c_user_log", catalog = "rczp")
public class UserLog implements java.io.Serializable {

	// Fields
	private Long id;
	private Short opUserType;
	private Long opUserId;
	private String opUserName;
	private Date opTime;
	private Integer opType;
	private Integer targetType;
	private Long targetId;
	private String opUserIp;
	
    public static int LOG_TYPE_LOGIN = 101;
    public static int LOG_TYPE_LOGOUT = 102;
    public static int LOG_TYPE_REGISTER = 103;

	// Constructors

	/** default constructor */
	public UserLog() {
	}

	/** full constructor */
	public UserLog(Long id, Short opUserType, Long opUserId, String opUserName,
			Date opTime, Integer opType, Integer targetType,
			Long targetId, String opUserIp) {
		this.id = id;
		this.opUserType = opUserType;
		this.opUserId = opUserId;
		this.opUserName = opUserName;
		this.opTime = opTime;
		this.opType = opType;
		this.targetType = targetType;
		this.targetId = targetId;
		this.opUserIp = opUserIp;
	}

	// Property accessors

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "op_user_type")
	public Short getOpUserType() {
		return this.opUserType;
	}

	public void setOpUserType(Short opUserType) {
		this.opUserType = opUserType;
	}

	@Column(name = "op_user_id")
	public Long getOpUserId() {
		return this.opUserId;
	}

	public void setOpUserId(Long opUserId) {
		this.opUserId = opUserId;
	}

	@Column(name = "op_user_name")
	public String getOpUserName() {
		return opUserName;
	}

	public void setOpUserName(String opUserName) {
		this.opUserName = opUserName;
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

	@Column(name = "target_id")
	public Long getTargetId() {
		return this.targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	@Column(name = "op_user_ip", length = 30)
	public String getOpUserIp() {
		return this.opUserIp;
	}

	public void setOpUserIp(String opUserIp) {
		this.opUserIp = opUserIp;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserLog))
			return false;
		UserLog castOther = (UserLog) other;

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
				&& ((this.getTargetId() == castOther.getTargetId()) || (this
						.getTargetId() != null
						&& castOther.getTargetId() != null && this
						.getTargetId().equals(castOther.getTargetId())))
				&& ((this.getOpUserIp() == castOther.getOpUserIp()) || (this
						.getOpUserIp() != null
						&& castOther.getOpUserIp() != null && this
						.getOpUserIp().equals(castOther.getOpUserIp())));
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
		result = 37 * result
				+ (getTargetId() == null ? 0 : this.getTargetId().hashCode());
		result = 37 * result
				+ (getOpUserIp() == null ? 0 : this.getOpUserIp().hashCode());
		return result;
	}

}