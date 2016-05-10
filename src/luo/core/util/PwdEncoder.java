package luo.core.util;

public interface PwdEncoder {
	/**
	 * �������
	 * 
	 * @param rawPass
	 *            δ��������
	 * @return ���ܺ�����
	 */
	public String encodePassword(String rawPass);

	/**
	 * ��֤�����Ƿ���ȷ
	 * 
	 * @param encPass
	 *            ��������
	 * @param rawPass
	 *            δ��������
	 * @return
	 */
	public boolean isPasswordValid(String encPass, String rawPass);
}
