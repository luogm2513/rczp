package luo.common.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Authentication implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public void init() {
		Date now = new Timestamp(System.currentTimeMillis());
		setLoginTime(now);
		setUpdateTime(now);
	}
	
	// constructors
	public Authentication () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public Authentication (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public Authentication (
		java.lang.String id,
		java.lang.Long uid,
		java.lang.String username,
		java.util.Date loginTime,
		java.lang.String loginIp,
		java.util.Date updateTime) {

		this.setId(id);
		this.setUid(uid);
		this.setUsername(username);
		this.setLoginTime(loginTime);
		this.setLoginIp(loginIp);
		this.setUpdateTime(updateTime);
		initialize();
	}
		
	protected void initialize () {}


	private int hashCode = Integer.MIN_VALUE;
	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Long uid;
	private java.lang.String userName;
	private java.lang.String email;
	private java.util.Date loginTime;
	private java.lang.String loginIp;
	private java.util.Date updateTime;

	
	
	
	
	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.Long getUid() {
		return uid;
	}

	public void setUid(java.lang.Long uid) {
		this.uid = uid;
	}

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUsername(java.lang.String userName) {
		this.userName = userName;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.util.Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(java.util.Date loginTime) {
		this.loginTime = loginTime;
	}

	public java.lang.String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(java.lang.String loginIp) {
		this.loginIp = loginIp;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof Authentication)) return false;
		else {
			Authentication authentication = (Authentication) obj;
			if (null == this.getId() || null == authentication.getId()) return false;
			else return (this.getId().equals(authentication.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}

}
