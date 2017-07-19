package view.action;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import base.BaseAction;
import domain.User;

@SuppressWarnings("serial")
@Controller
public class UserAction extends BaseAction<User> {
	/** �б� */
	public String list() throws Exception {
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}

	/** ɾ�� */
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}

	/** ���ҳ�� */
	public String addUI() throws Exception {
		return "saveUI";
	}

	/** ��� */
	public String add() throws Exception {
		return "toList";
	}

	/** �޸�ҳ�� */
	public String editUI() throws Exception {
		return "saveUI";
	}

	/** �޸� */
	public String edit() throws Exception {
		return "toList";
	}

}
