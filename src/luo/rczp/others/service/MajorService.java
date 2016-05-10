package luo.rczp.others.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luo.rczp.base.BaseService;
import luo.rczp.others.service.MajorService;
import luo.rczp.others.dao.MajorDao;
import luo.rczp.others.model.Function;
import luo.rczp.others.model.Major;

@Service("majorService")
@Transactional
public class MajorService extends BaseService<Major, java.lang.Long> {

	@Autowired
	private MajorDao majorDao;

	@SuppressWarnings("unchecked")
	public MajorDao getDao() {
		return this.majorDao;
	}

	public List<Major> getListByParentId(Integer parentId) {
		return getDao().getListByParentId(parentId);
	}

	public Major getById(Integer majorId) {
		return getDao().getById(majorId);
	}

	public String getMajorName(Integer gMajor, Integer pMajor, Integer major) {
		String majorName = null;
		if (gMajor != null) {
			majorName = getById(gMajor).getMajorName();
			if (pMajor != null) {
				majorName = getById(pMajor).getMajorName();
				if (major != null) {
					majorName = getById(major).getMajorName();
				}
			}
		}
		return majorName;
	}
}