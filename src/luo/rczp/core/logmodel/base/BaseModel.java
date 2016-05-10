package luo.rczp.core.logmodel.base;

import java.io.Serializable;

import luo.rczp.core.logmodel.Login;
import luo.rczp.core.logmodel.Logout;
import luo.rczp.core.logmodel.Register;
import luo.rczp.colla.model.UserLog;

public class BaseModel implements Serializable{
	
	private int type = 0;

	public BaseModel() {
		super();
		if(this instanceof Login){
			this.type = UserLog.LOG_TYPE_LOGIN;
		}else if(this instanceof Logout){
			this.type = UserLog.LOG_TYPE_LOGOUT;
		}else if(this instanceof Register){
			this.type = UserLog.LOG_TYPE_REGISTER;
		}
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
}
