package luo.rczp.core.logmodel;

import luo.rczp.core.logmodel.base.BaseModel;


public class Login extends BaseModel {

	private static final long serialVersionUID = -4232380677611766120L;
		
	public Login(String loginName, String password) {
		super();
		this.loginName = loginName;
		this.password = password;
	}
	
	public Login(String loginName, String password, String checkCode,
			int status, Integer reason) {
		super();
		this.loginName = loginName;
		this.password = password;
		this.checkCode = checkCode;
		this.status = status;
		this.reason = reason;
	}

	private String loginName;
	private String password;
	private String checkCode;
	/**
	 * 登录状态:1-成功,-1-失败
	 */
	private int status;
	/**
	 * 失败原因:1用户名不存在,2密码不正确,3系统错误
	 */
	private Integer reason;
	
	private String sessionId;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getReason() {
		return reason;
	}

	public void setReason(Integer reason) {
		this.reason = reason;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}
