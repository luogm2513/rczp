package luo.common.security;

/**
 * 用户名没有找到异常
 */
@SuppressWarnings("serial")
public class RealNameNotFoundException extends AuthenticationException {
	public RealNameNotFoundException() {
	}

	public RealNameNotFoundException(String msg) {
		super(msg);
	}
}