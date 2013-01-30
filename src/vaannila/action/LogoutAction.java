package vaannila.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception { 
		ServletActionContext.getRequest().getSession().invalidate();
		  return "logout_success";
	}
}
