package view.action;

import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import Util.DepartmentUtils;
import base.BaseAction;
import domain.Department;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	private Long parentId;

	/** �б� */
	public String list() throws Exception {
		List<Department> departmentList = null;
		if (parentId == null)
			departmentList = departmentService.findTopList();
		else {
			departmentList = departmentService.findChildren(parentId);
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("departmentList", parent);
		}
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}

	/** ɾ�� */
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}

	/** ���ҳ�� */
	public String addUI() throws Exception {
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		return "saveUI";
	}

	/** ��� */
	public String add() throws Exception {
		Department parent = departmentService.getById(parentId);
		// ���¸�������Ϣ
		if (parent != null) {
			parent.getChildren().add(model);
			model.setParent(parent);
			departmentService.save(model);
			departmentService.update(parent);
		} else {
			departmentService.save(model);
		}
		return "toList";
	}

	/** �޸�ҳ�� */
	public String editUI() throws Exception {
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		// ׼�����Ե�����
		Department department = departmentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(department);
		if (department.getParent() != null) {
			parentId = department.getParent().getId();
		}
		return "saveUI";
	}

	/** �޸� */
	public String edit() throws Exception {
		// �����ݿ�ȡ��ԭ����
		Department department = departmentService.getById(model.getId());
		// ����Ҫ�޸ĵ�����
		// ���¸�������Ϣ
		if (parentId != null) {
			// ԭ������
			Department oldParent = departmentService.getById(department.getParent().getId());
			Set<Department> oldParentChildren = oldParent.getChildren();
			oldParentChildren.remove(department);
			// �¸�����
			Department newParent = departmentService.getById(parentId);
			Set<Department> newParentChildren = newParent.getChildren();
			newParentChildren.add(department);

			department.setParent(newParent);
			// ���µ����ݿ���
			departmentService.update(oldParent);
			departmentService.update(newParent);
		}
		department.setName(model.getName());
		department.setDescription(model.getDescription());

		departmentService.update(department);
		return "toList";
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
