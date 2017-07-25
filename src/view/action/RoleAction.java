package view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import base.BaseAction;
import domain.Role;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	/** 列表 */
	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		roleService.save(model);
		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		Role role = roleService.getById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		roleService.update(role);
		return "toList";
	}
}
