package luo.rczp.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "b_comp_profile", catalog = "rczp")
public class CompProfile implements java.io.Serializable {

	// Fields

	private Long userId;
	private String compName;
	private String compLogo;
	private Long parentTrade;
	private Long trade;
	private Integer compType;
	private Integer compScale;
	private Integer creatTime;
	private Long province;
	private Long city;
	private Long county;
	private String address;
	private String compWebsite;
	private String tel;
	private String email;
	private Integer isPassed;

	// Constructors

	/** default constructor */
	public CompProfile() {
	}

	/** minimal constructor */
	public CompProfile(Long userId) {
		this.userId = userId;
	}

	/** full constructor */
	public CompProfile(Long userId, String compName, String compLogo,
			Long parentTrade, Long trade, Integer compType, Integer compScale,
			Integer creatTime, Long province, Long city, Long county, String address, String compWebsite,
			String tel, String email, Integer isPassed) {
		this.userId = userId;
		this.compName = compName;
		this.compLogo = compLogo;
		this.parentTrade = parentTrade;
		this.trade = trade;
		this.compType = compType;
		this.compScale = compScale;
		this.creatTime = creatTime;
		this.province = province;
		this.city = city;
		this.county = county;
		this.address = address;
		this.compWebsite = compWebsite;
		this.tel = tel;
		this.email = email;
		this.isPassed = isPassed;
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

	@Column(name = "comp_name", length = 30)
	public String getCompName() {
		return this.compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	@Column(name = "comp_logo", length = 100)
	public String getCompLogo() {
		return this.compLogo;
	}

	public void setCompLogo(String compLogo) {
		this.compLogo = compLogo;
	}

	@Column(name = "parent_trade")
	public Long getParentTrade() {
		return this.parentTrade;
	}

	public void setParentTrade(Long parentTrade) {
		this.parentTrade = parentTrade;
	}
	
	@Column(name = "trade")
	public Long getTrade() {
		return this.trade;
	}

	public void setTrade(Long trade) {
		this.trade = trade;
	}

	@Column(name = "comp_type")
	public Integer getCompType() {
		return this.compType;
	}

	public void setCompType(Integer compType) {
		this.compType = compType;
	}

	@Column(name = "comp_scale")
	public Integer getCompScale() {
		return this.compScale;
	}

	public void setCompScale(Integer compScale) {
		this.compScale = compScale;
	}

	@Column(name = "creat_time")
	public Integer getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Integer creatTime) {
		this.creatTime = creatTime;
	}

	@Column(name = "province")
	public Long getProvince() {
		return this.province;
	}

	public void setProvince(Long province) {
		this.province = province;
	}
	
	@Column(name = "city")
	public Long getCity() {
		return this.city;
	}

	public void setCity(Long city) {
		this.city = city;
	}
	
	@Column(name = "county")
	public Long getCounty() {
		return this.county;
	}

	public void setCounty(Long county) {
		this.county = county;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "comp_website", length = 100)
	public String getCompWebsite() {
		return this.compWebsite;
	}

	public void setCompWebsite(String compWebsite) {
		this.compWebsite = compWebsite;
	}

	@Column(name = "tel", length = 20)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "email", length = 80)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "is_passed")
	public Integer getIsPassed() {
		return this.isPassed;
	}

	public void setIsPassed(Integer isPassed) {
		this.isPassed = isPassed;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CompProfile))
			return false;
		CompProfile castOther = (CompProfile) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getCompName() == castOther.getCompName()) || (this
						.getCompName() != null
						&& castOther.getCompName() != null && this
						.getCompName().equals(castOther.getCompName())))
				&& ((this.getCompLogo() == castOther.getCompLogo()) || (this
						.getCompLogo() != null
						&& castOther.getCompLogo() != null && this
						.getCompLogo().equals(castOther.getCompLogo())))
				&& ((this.getTrade() == castOther.getTrade()) || (this
						.getTrade() != null
						&& castOther.getTrade() != null && this
						.getTrade().equals(castOther.getTrade())))
				&& ((this.getCompType() == castOther.getCompType()) || (this
						.getCompType() != null
						&& castOther.getCompType() != null && this
						.getCompType().equals(castOther.getCompType())))
				&& ((this.getCompScale() == castOther.getCompScale()) || (this
						.getCompScale() != null
						&& castOther.getCompScale() != null && this
						.getCompScale().equals(castOther.getCompScale())))
				&& ((this.getCreatTime() == castOther.getCreatTime()) || (this
						.getCreatTime() != null
						&& castOther.getCreatTime() != null && this
						.getCreatTime().equals(castOther.getCreatTime())))
				&& ((this.getAddress() == castOther.getAddress()) || (this
						.getAddress() != null && castOther.getAddress() != null && this
						.getAddress().equals(castOther.getAddress())))
				&& ((this.getCompWebsite() == castOther.getCompWebsite()) || (this
						.getCompWebsite() != null
						&& castOther.getCompWebsite() != null && this
						.getCompWebsite().equals(castOther.getCompWebsite())))
				&& ((this.getTel() == castOther.getTel()) || (this.getTel() != null
						&& castOther.getTel() != null && this.getTel().equals(
						castOther.getTel())))
				&& ((this.getEmail() == castOther.getEmail()) || (this
						.getEmail() != null && castOther.getEmail() != null && this
						.getEmail().equals(castOther.getEmail())))
				&& ((this.getIsPassed() == castOther.getIsPassed()) || (this
						.getIsPassed() != null
						&& castOther.getIsPassed() != null && this
						.getIsPassed().equals(castOther.getIsPassed())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getCompName() == null ? 0 : this.getCompName().hashCode());
		result = 37 * result
				+ (getCompLogo() == null ? 0 : this.getCompLogo().hashCode());
		result = 37 * result
				+ (getTrade() == null ? 0 : this.getTrade().hashCode());
		result = 37 * result
				+ (getCompType() == null ? 0 : this.getCompType().hashCode());
		result = 37 * result
				+ (getCompScale() == null ? 0 : this.getCompScale().hashCode());
		result = 37 * result
				+ (getCreatTime() == null ? 0 : this.getCreatTime().hashCode());
		result = 37 * result
				+ (getAddress() == null ? 0 : this.getAddress().hashCode());
		result = 37 * result
				+ (getCompWebsite() == null ? 0 : this.getCompWebsite().hashCode());
		result = 37 * result
				+ (getTel() == null ? 0 : this.getTel().hashCode());
		result = 37 * result
				+ (getEmail() == null ? 0 : this.getEmail().hashCode());
		result = 37 * result
				+ (getIsPassed() == null ? 0 : this.getIsPassed().hashCode());
		return result;
	}

}