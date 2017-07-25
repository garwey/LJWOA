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
	/** �б� */
	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	/** ɾ�� */
	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}

	/** ���ҳ�� */
	public String addUI() throws Exception {
		return "saveUI";
	}

	/** ��� */
	public String add() throws Exception {
		roleService.save(model);
		return "toList";
	}

	/** �޸�ҳ�� */
	public String editUI() throws Exception {
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}

	/** �޸� */
	public String edit() throws Exception {
		Role role = roleService.getById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		roleService.update(role);
		return "toList";
	}
}
