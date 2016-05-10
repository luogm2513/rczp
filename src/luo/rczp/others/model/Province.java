package luo.rczp.others.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "d_province", catalog = "rczp")
public class Province implements java.io.Serializable {
	
	private Integer provinceId;
	private String provinceName;
	
	public Province(){
	}
	
	public Province( Integer provinceId, String provinceName){
		this.provinceId = provinceId;
		this.provinceName = provinceName;
	}
	@Id
	@Column(name = "province_id", unique = true, nullable = false)
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
	@Column(name = "province_name")
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
}