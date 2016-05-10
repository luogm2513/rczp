package luo.rczp.admin.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AdminAcount entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "s_admin_acount", catalog = "rczp")
public class AdminAcount implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private String adminName;
	private Integer adminRank;
	private String password;
	private Date creatTime;
	private Date loginTime;
	private String loginIp;
	private Integer loginCount;
	private Integer isDisabled;

	// Constructors

	/** default constructor */
	public AdminAcount() {
	}

	/** minimal constructor */
	public AdminAcount(Integer adminId) {
		this.adminId = adminId;
	}

	/** full constructor */
	public AdminAcount(Integer adminId, String adminName, Integer adminRank,
			String password, Date creatTime, Date loginTime,
			String loginIp, Integer loginCount, Integer isDisabled) {
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminRank = adminRank;
		this.password = password;
		this.creatTime = creatTime;
		this.loginTime = loginTime;
		this.loginIp = loginIp;
		this.loginCount = loginCount;
		this.isDisabled = isDisabled;
	}

	// Property accessors
    @Id
	@Column(name = "admin_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Column(name = "admin_name", length = 30)
	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Column(name = "admin_rank")
	public Integer getAdminRank() {
		return this.adminRank;
	}

	public void setAdminRank(Integer adminRank) {
		this.adminRank = adminRank;
	}

	@Column(name = "password", length = 40)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "creat_time", length = 19)
	public Date getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	@Column(name = "login_time", length = 19)
	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "login_ip", length = 30)
	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	@Column(name = "login_count")
	public Integer getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
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
		if (!(other instanceof AdminAcount))
			return false;
		AdminAcount castOther = (AdminAcount) other;

		return ((this.getAdminId() == castOther.getAdminId()) || (this
				.getAdminId() != null && castOther.getAdminId() != null && this
				.getAdminId().equals(castOther.getAdminId())))
				&& ((this.getAdminName() == castOther.getAdminName()) || (this
						.getAdminName() != null
						&& castOther.getAdminName() != null && this
						.getAdminName().equals(castOther.getAdminName())))
				&& ((this.getAdminRank() == castOther.getAdminRank()) || (this
						.getAdminRank() != null
						&& castOther.getAdminRank() != null && this
						.getAdminRank().equals(castOther.getAdminRank())))
				&& ((this.getPassword() == castOther.getPassword()) || (this
						.getPassword() != null
						&& castOther.getPassword() != null && this
						.getPassword().equals(castOther.getPassword())))
				&& ((this.getCreatTime() == castOther.getCreatTime()) || (this
						.getCreatTime() != null
						&& castOther.getCreatTime() != null && this
						.getCreatTime().equals(castOther.getCreatTime())))
				&& ((this.getLoginTime() == castOther.getLoginTime()) || (this
						.getLoginTime() != null
						&& castOther.getLoginTime() != null && this
						.getLoginTime().equals(castOther.getLoginTime())))
				&& ((this.getLoginIp() == castOther.getLoginIp()) || (this
						.getLoginIp() != null && castOther.getLoginIp() != null && this
						.getLoginIp().equals(castOther.getLoginIp())))
				&& ((this.getLoginCount() == castOther.getLoginCount()) || (this
						.getLoginCount() != null
						&& castOther.getLoginCount() != null && this
						.getLoginCount().equals(castOther.getLoginCount())))
				&& ((this.getIsDisabled() == castOther.getIsDisabled()) || (this
						.getIsDisabled() != null
						&& castOther.getIsDisabled() != null && this
						.getIsDisabled().equals(castOther.getIsDisabled())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAdminId() == null ? 0 : this.getAdminId().hashCode());
		result = 37 * result
				+ (getAdminName() == null ? 0 : this.getAdminName().hashCode());
		result = 37 * result
				+ (getAdminRank() == null ? 0 : this.getAdminRank().hashCode());
		result = 37 * result
				+ (getPassword() == null ? 0 : this.getPassword().hashCode());
		result = 37 * result
				+ (getCreatTime() == null ? 0 : this.getCreatTime().hashCode());
		result = 37 * result
				+ (getLoginTime() == null ? 0 : this.getLoginTime().hashCode());
		result = 37 * result
				+ (getLoginIp() == null ? 0 : this.getLoginIp().hashCode());
		result = 37
				* result
				+ (getLoginCount() == null ? 0 : this.getLoginCount()
						.hashCode());
		result = 37
				* result
				+ (getIsDisabled() == null ? 0 : this.getIsDisabled()
						.hashCode());
		return result;
	}

}