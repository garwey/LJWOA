package serviceImpl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import base.DaoSupportImpl;
import domain.Department;
import service.DepartmentService;
import service.UserService;

@SuppressWarnings("unchecked")
@Transactional
@Service
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {
	@Resource
	private UserService userService;
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Department> findTopList() {
		return sessionFactory.getCurrentSession().createQuery("FROM Department d WHERE d.parent IS NULL").list();
	}

	@Override
	public List<Department> findChildren(Long parentId) {
		return sessionFactory.getCurrentSession().createQuery("FROM Department d WHERE d.parent.id=?")
				.setParameter(0, parentId).list();
	}

	@Override
	public void delete(Long id) {
		Department d = getById(id);
		// 先删子部门
		Set<Department> children = d.getChildren();
		if (children != null) {
			for (Department temp : children) {
				getSession().delete(getById(temp.getId()));
			}
		}
		// 删父部门中的相关记录
		Department parent = d.getParent();
		if (parent != null)
			parent.getChildren().remove(d);
		// 最后删除目标
		getSession().delete(d);
	}

}
