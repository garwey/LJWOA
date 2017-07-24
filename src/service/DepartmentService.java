package service;

import java.util.List;

import base.DaoSupport;
import domain.Department;

public interface DepartmentService extends DaoSupport<Department> {
	/*
	 * 查询顶级部门列表
	 */
	List<Department> findTopList();

	/**
	 * 查询子部门列表
	 * 
	 * @param parentId
	 * @return
	 */
	List<Department> findChildren(Long parentId);

}
