package luo.rczp.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "b_user_acount", catalog = "rczp")
public class UserAcount implements java.io.Serializable {
	
	public final static int STATUS_IS_DISABLED = 1;

	// Fields

	private Long userId;
	private Integer userType;
	private Integer isCrisitian;
	private String email;
	private String password;
	private Date registerTime;
	private String registerIp;
	private Date lastLoginTime;
	private String lastLoginIp;
	private Integer loginCount;
	private Date errorTime;
	private Integer errorCount;
	private String errorIp;
	private Integer isDisabled;

	// Constructors

	/** default constructor */
	public UserAcount() {
	}

	/** minimal constructor */
	public UserAcount(Long userId) {
		this.userId = userId;
	}

	/** full constructor */
	public UserAcount(Long userId, Integer userType, Integer isCrisitian,
			String email, String password,
			Date registerTime, String registerIp, Date lastLoginTime,
			String lastLoginIp, Integer loginCount, Date errorTime,
			Integer errorCount, String errorIp, String activeCode,
			Date activeCreatTime, Date activeTime, Integer isDisabled) {
		this.userId = userId;
		this.userType = userType;
		this.isCrisitian = isCrisitian;
		this.email = email;
		this.password = password;
		this.registerTime = registerTime;
		this.registerIp = registerIp;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.loginCount = loginCount;
		this.errorTime = errorTime;
		this.errorCount = errorCount;
		this.errorIp = errorIp;
		this.isDisabled = isDisabled;
	}

	// Property accessors
	
	@Id
	@Column(name = "user_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY) //一种自动生成主键ID的策略
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "user_type")
	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	@Column(name = "is_crisitian")
	public Integer getIsCrisitian() {
		return this.isCrisitian;
	}

	public void setIsCrisitian(Integer isCrisitian) {
		this.isCrisitian = isCrisitian;
	}

	@Column(name = "email", length = 80)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", length = 40)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "register_time", length = 19)
	public Date getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	@Column(name = "register_ip", length = 30)
	public String getRegisterIp() {
		return this.registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	@Column(name = "last_login_time", length = 19)
	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "last_login_ip", length = 30)
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Column(name = "login_count")
	public Integer getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	@Column(name = "error_time", length = 19)
	public Date getErrorTime() {
		return this.errorTime;
	}

	public void setErrorTime(Date errorTime) {
		this.errorTime = errorTime;
	}

	@Column(name = "error_count")
	public Integer getErrorCount() {
		return this.errorCount;
	}

	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}

	@Column(name = "error_ip", length = 30)
	public String getErrorIp() {
		return this.errorIp;
	}

	public void setErrorIp(String errorIp) {
		this.errorIp = errorIp;
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
		if (!(other instanceof UserAcount))
			return false;
		UserAcount castOther = (UserAcount) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getUserType() == null ? 0 : this.getUserType().hashCode());
		result = 37
				* result
				+ (getIsCrisitian() == null ? 0 : this.getIsCrisitian()
						.hashCode());
		result = 37 * result
				+ (getEmail() == null ? 0 : this.getEmail().hashCode());
		result = 37 * result
				+ (getPassword() == null ? 0 : this.getPassword().hashCode());
		result = 37
				* result
				+ (getRegisterTime() == null ? 0 : this.getRegisterTime()
						.hashCode());
		result = 37
				* result
				+ (getRegisterIp() == null ? 0 : this.getRegisterIp()
						.hashCode());
		result = 37
				* result
				+ (getLastLoginTime() == null ? 0 : this.getLastLoginTime()
						.hashCode());
		result = 37
				* result
				+ (getLastLoginIp() == null ? 0 : this.getLastLoginIp()
						.hashCode());
		result = 37
				* result
				+ (getLoginCount() == null ? 0 : this.getLoginCount()
						.hashCode());
		result = 37 * result
				+ (getErrorTime() == null ? 0 : this.getErrorTime().hashCode());
		result = 37
				* result
				+ (getErrorCount() == null ? 0 : this.getErrorCount()
						.hashCode());
		result = 37 * result
				+ (getErrorIp() == null ? 0 : this.getErrorIp().hashCode());
		result = 37
				* result
				+ (getIsDisabled() == null ? 0 : this.getIsDisabled()
						.hashCode());
		return result;
	}

}