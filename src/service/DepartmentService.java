package service;

import java.util.List;

import base.DaoSupport;
import domain.Department;

public interface DepartmentService extends DaoSupport<Department> {
	/*
	 * ��ѯ���������б�
	 */
	List<Department> findTopList();

	/**
	 * ��ѯ�Ӳ����б�
	 * 
	 * @param parentId
	 * @return
	 */
	List<Department> findChildren(Long parentId);

}
