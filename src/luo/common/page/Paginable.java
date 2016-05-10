package luo.common.page;

/**
 * �ɷ�ҳ�ӿ�
 * 
 * 
 * 
 */
public interface Paginable {
	/**
	 * �ܼ�¼��
	 * 
	 * @return
	 */
	public int getTotalCount();

	/**
	 * ��ҳ��
	 * 
	 * @return
	 */
	public int getTotalPage();

	/**
	 * ÿҳ��¼��
	 * 
	 * @return
	 */
	public int getPageSize();

	/**
	 * ��ǰҳ��
	 * 
	 * @return
	 */
	public int getPageNo();

	/**
	 * �Ƿ��һҳ
	 * 
	 * @return
	 */
	public boolean isFirstPage();

	/**
	 * �Ƿ����һҳ
	 * 
	 * @return
	 */
	public boolean isLastPage();

	/**
	 * ������ҳ��ҳ��
	 */
	public int getNextPage();

	/**
	 * ������ҳ��ҳ��
	 */
	public int getPrePage();
}
