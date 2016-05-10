package luo.rczp.core.logmodel;

import luo.rczp.core.logmodel.base.BaseModel;

public class Logout extends BaseModel {

	private static final long serialVersionUID = 4819140853446683761L;

	private Long userId;
	private String sessionId;
	
	public Logout(Long userId, String sessionId) {
		super();
		this.userId = userId;
		this.sessionId = sessionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}	
	
}
