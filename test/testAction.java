import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class testAction extends ActionSupport {
	public String test() {
		ActionContext.getContext().put("info", "---> testAction.test()");
		return "success";
	}

}
