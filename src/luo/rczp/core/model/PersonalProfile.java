package luo.rczp.core.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "b_personal_profile", catalog = "rczp")
public class PersonalProfile implements
		java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private String realName;

	private Integer gender;
	
	private Date birthday;
	private Integer marriage;
	
	private Long presentProvince;
	private Long presentCity;
	private Long presentCounty;
	private Long nativeProvince;
	private Long nativeCity;
	private Long nativeCounty;
	private String address;
	
	private String mobile;
    private String email;
	private String smallPhoto;

	// Constructors

	/** default constructor */
	public PersonalProfile() {
	}

	/** minimal constructor */
	public PersonalProfile(Long userId) {
		this.userId = userId;
	}

	/** full constructor */
	public PersonalProfile(Long userId, String realName, 
			Integer gender, Date birthday, Integer marriage, Long presentProvince, Long presentCity, Long presentCounty,
			Long nativeProvince, Long nativeCity, Long nativeCounty, String address, String mobile, String email,String smallPhoto) {
		this.userId = userId;
		this.realName = realName;
		this.smallPhoto = smallPhoto;
		this.gender = gender;
		this.birthday = birthday;
		this.marriage = marriage;
		this.presentProvince = presentProvince;
		this.presentCity = presentCity;
		this.presentCounty = presentCounty;
		this.nativeProvince = nativeProvince;
		this.nativeCity = nativeCity;
		this.nativeCounty = nativeCounty;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
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

	@Column(name = "real_name", length = 30)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "gender", length = 1)
	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "birthday")
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Column(name = "marriage")
	public Integer getMarriage() {
		return this.marriage;
	}

	public void setMarriage(Integer marriage) {
		this.marriage = marriage;
	}
	
	@Column(name = "present_province", length = 11)
	public Long getPresentProvince() {
		return presentProvince;
	}

	public void setPresentProvince(Long presentProvince) {
		this.presentProvince = presentProvince;
	}

	@Column(name = "present_city", length = 11)
	public Long getPresentCity() {
		return presentCity;
	}

	public void setPresentCity(Long presentCity) {
		this.presentCity = presentCity;
	}
	
	@Column(name = "present_county", length = 11)
	public Long getPresentCounty() {
		return presentCounty;
	}

	public void setPresentCounty(Long presentCounty) {
		this.presentCounty = presentCounty;
	}

	@Column(name = "native_province", length = 11)
	public Long getNativeProvince() {
		return nativeProvince;
	}

	public void setNativeProvince(Long nativeProvince) {
		this.nativeProvince = nativeProvince;
	}
	
	@Column(name = "native_city", length = 11)
	public Long getNativeCity() {
		return nativeCity;
	}

	public void setNativeCity(Long nativeCity) {
		this.nativeCity = nativeCity;
	}
	
	@Column(name = "native_county", length = 11)
	public Long getNativeCounty() {
		return nativeCounty;
	}

	public void setNativeCounty(Long nativeCounty) {
		this.nativeCounty = nativeCounty;
	}

	@Column(name = "mobile", length = 11)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Column(name = "email", length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "small_photo", length = 80)
	public String getSmallPhoto() {
		return this.smallPhoto;
	}

	public void setSmallPhoto(String smallPhoto) {
		this.smallPhoto = smallPhoto;
	}
}