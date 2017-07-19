package view.action;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import base.BaseAction;
import domain.User;

@SuppressWarnings("serial")
@Controller
public class UserAction extends BaseAction<User> {
	/** 列表 */
	public String list() throws Exception {
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		return "toList";
	}

}
