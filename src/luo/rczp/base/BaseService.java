package luo.rczp.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import luo.common.hibernate3.Condition;
import luo.common.hibernate3.OrderBy;
import luo.common.hibernate3.Updater;
import luo.common.page.Pagination;

@Transactional
public abstract class BaseService<T, PK extends Serializable> {
	protected Logger log = LoggerFactory.getLogger(getClass());
	private BaseDao<T, PK> dao;

	public void setDao(BaseDao<T, PK> dao) {
		this.dao = dao;
	}

	protected BaseDao<T, PK> getDao() {
		return this.dao;
	}
	/**
	 * 通过ID查找对象
	 * 
	 * @param id
	 *            记录的ID
	 * @return 实体对象
	 */
	@Transactional(readOnly = true)
	public T findById(PK id) {
		return dao.get(id);
	}

	@Transactional(readOnly = true)
	public T load(PK id) {
		return dao.load(id);
	}

	/**
	 * 查找所有对象
	 * 
	 * @return 对象列表
	 */
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return dao.findAll();
	}

	@Transactional(readOnly = true)
	public Pagination findAll(int pageNo, int pageSize, OrderBy... orders) {
		return dao.findAll(pageNo, pageSize, orders);
	}

	/**
	 * 通过示例对象查找对象列表
	 * 
	 * @param eg
	 *            示例对象
	 * @param anyWhere
	 *            是否模糊查询。默认false。
	 * @param conds
	 *            排序及is null。分别为OrderBy和String。
	 * @param exclude
	 *            排除属性
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<T> findByEgList(T eg, boolean anywhere, Condition[] conds,
			String... exclude) {
		return dao.findByEgList(eg, anywhere, conds, exclude);
	}

	@Transactional(readOnly = true)
	public List<T> findByEgList(T eg, boolean anywhere, String... exclude) {
		return this.findByEgList(eg, anywhere, null, exclude);
	}

	@Transactional(readOnly = true)
	public List<T> findByEgList(T eg, Condition[] conds, String... exclude) {
		return this.findByEgList(eg, false, conds, exclude);
	}

	@Transactional(readOnly = true)
	public List<T> findByEgList(T eg, boolean anywhere, Condition[] conds,
			int firstResult, int maxResult, String... exclude) {
		return dao.findByEgList(eg, anywhere, conds, firstResult, maxResult,
				exclude);
	}

	@Transactional(readOnly = true)
	public List<T> findByEgList(T eg, boolean anywhere, int firstResult,
			int maxResult, String... exclude) {
		return this.findByEgList(eg, anywhere, null, firstResult, maxResult,
				exclude);
	}

	@Transactional(readOnly = true)
	public List<T> findByEgList(T eg, Condition[] conds, int firstResult,
			int maxResult, String... exclude) {
		return this.findByEgList(eg, false, conds, firstResult, maxResult,
				exclude);
	}

	@Transactional(readOnly = true)
	public List<T> findByEgList(T eg, String... exclude) {
		return this.findByEgList(eg, false, null, exclude);
	}

	@Transactional(readOnly = true)
	public Pagination findByEg(T eg, boolean anywhere, Condition[] conds,
			int pageNo, int pageSize, String... exclude) {
		return dao.findByEg(eg, anywhere, conds, pageNo, pageSize, exclude);
	}

	@Transactional(readOnly = true)
	public Pagination findByEg(T eg, boolean anywhere, int pageNo,
			int pageSize, String... exclude) {
		return this.findByEg(eg, anywhere, null, pageNo, pageSize, exclude);
	}

	@Transactional(readOnly = true)
	public Pagination findByEg(T eg, Condition[] conds, int pageNo,
			int pageSize, String... exclude) {
		return this.findByEg(eg, false, conds, pageNo, pageSize, exclude);
	}

	@Transactional(readOnly = true)
	public Pagination findByEg(T eg, int pageNo, int pageSize,
			String... exclude) {
		return this.findByEg(eg, false, null, pageNo, pageSize, exclude);
	}

	/**
	 * 根据Updater更新对象
	 * 
	 * @param updater
	 */
	public Object updateByUpdater(Updater updater) {
		return dao.updateByUpdater(updater);
	}

	public Object updateDefault(Object entity) {
		return updateByUpdater(Updater.create(entity));
	}

	/**
	 * 保存对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 操作信息
	 */
	public T save(T entity) {
		return dao.save(entity);
	}

	public Object update(Object o) {
		return getDao().update(o);
	}

	public Object saveOrUpdate(Object o) {
		return getDao().saveOrUpdate(o);
	}

	public void delete(Object o) {
		getDao().delete(o);
	}
	


	public Object merge(Object o) {
		return getDao().merge(o);
	}

	/**
	 * 根据ID删除记录
	 * 
	 * @param id
	 *            记录ID
	 */
	public T deleteById(PK id) {
		if (id == null) {
			return null;
		}
		return dao.deleteById(id);
	}

	/**
	 * 根据ID数组删除记录，当发生异常时，操作终止并回滚
	 * 
	 * @param ids
	 *            记录ID数组
	 * @return 删除的对象
	 */
	public List<T> deleteById(PK[] ids) {
		List<T> dts = new ArrayList<T>();
		T del = null;
		if (ids != null && ids.length > 0) {
			for (PK id : ids) {
				del = deleteById(id);
				if (del != null) {
					dts.add(del);
				}
			}
		}
		return dts;
	}

	/**
	 * 保存并刷新对象，避免many-to-one属性不完整
	 * 
	 * @param entity
	 */
	public T saveAndRefresh(T entity) {
		this.save(entity);
		getDao().refresh(entity);
		return entity;
	}
}
