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

	/** 列表 */
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

	/** 删除 */
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		Department parent = departmentService.getById(parentId);
		// 更新父部门信息
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

	/** 修改页面 */
	public String editUI() throws Exception {
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		// 准备回显的数据
		Department department = departmentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(department);
		if (department.getParent() != null) {
			parentId = department.getParent().getId();
		}
		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 从数据库取出原对象
		Department department = departmentService.getById(model.getId());
		// 设置要修改的属性
		// 更新父部门信息
		if (parentId != null) {
			// 原父部门
			Department oldParent = departmentService.getById(department.getParent().getId());
			Set<Department> oldParentChildren = oldParent.getChildren();
			oldParentChildren.remove(department);
			// 新父部门
			Department newParent = departmentService.getById(parentId);
			Set<Department> newParentChildren = newParent.getChildren();
			newParentChildren.add(department);

			department.setParent(newParent);
			// 更新到数据库中
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
