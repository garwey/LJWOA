package base;

import java.util.List;

public interface DaoSupport<T> {
	public void save(T entity);

	public void delete(Long id);

	public void update(T entity);

	public T getById(Long id);

	public List<T> getByIds(Long[] ids);

	public List<T> findAll();

}
