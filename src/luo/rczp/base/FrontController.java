package luo.rczp.base;

import luo.common.page.Pagination;

public abstract class FrontController extends BaseController{

	protected Pagination pagination;
	
	protected int checkPageSize(int count) {
		if (count > 200) {
			count = 200;
		}
		if (count < 1) {
			count = 1;
		}
		return count;
	}
	
}
