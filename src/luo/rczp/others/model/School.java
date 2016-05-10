package luo.rczp.others.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "d_school", catalog = "rczp")
public class School implements java.io.Serializable {
	
	private Integer schoolId;
	private String schoolName;
	private Integer schoolProId;
	private Integer schoolTypeId;
	
	public School(){
	}
	
	public School( Integer schoolId, String schoolName, Integer schoolProId, Integer schoolTypeId){
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.schoolProId = schoolProId;
		this.schoolTypeId = schoolTypeId;
	}
	@Id
	@Column(name = "school_id", unique = true, nullable = false)
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	
	@Column(name = "school_name")
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	@Column(name = "school_pro_id")
	public Integer getSchoolProId() {
		return schoolProId;
	}
	public void setSchoolProId(Integer schoolProId) {
		this.schoolProId = schoolProId;
	}
	
	@Column(name = "school_type_id")
	public Integer getSchoolTypeId() {
		return schoolTypeId;
	}
	public void setSchoolTypeId(Integer schoolTypeId) {
		this.schoolTypeId = schoolTypeId;
	}
	
	
}