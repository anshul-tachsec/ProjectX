package vaannila.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import vaannila.getset.Login;
import vaannila.DAO.LoginDAO;
public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	// For SessionAware
	  Map<String, Object> session;
	  @Override
	  public void setSession(Map<String, Object> session) {
	    this.session = session;
	  }
	  
	private static final long serialVersionUID = 1L;
	public Login loginBean;
	public Login getLoginBean(){
		return loginBean;
	}
	public LoginAction()
	{
		this.loginBean=new Login();
	}
	public void setLoginBean(Login login) {

		this.loginBean = login;
	}
	public String execute() throws Exception{

		System.out.println("In Login Action");
		String domain="";
		if(loginBean.getUsername().contains("@") && loginBean.getUsername().contains(".")){
			String[] email = loginBean.getUsername().split("@");
			loginBean.setUsername(email[0]);
			domain=email[1].split("\\.")[0];
			loginBean.setDomain(domain);

		}
		else{
			return "login_error";
		}		//string split
		LoginDAO.validateLogin(loginBean);
		loginBean.getPrimaryPrivilege();
		try{
			if(loginBean.getPrimaryPrivilege().equals("pt")){
				session.put("username", loginBean.getUsername());
				session.put("domain", loginBean.getDomain());
				System.out.println("in pt");
				return "login_success_pt";
			}
			else if(loginBean.getPrimaryPrivilege().equals("hr")){
				session.put("username", loginBean.getUsername());
				session.put("domain", loginBean.getDomain());
				System.out.println("in hr");
				return "login_success_hr";
			}
			else if(loginBean.getPrimaryPrivilege().equals("fo")){
				session.put("username", loginBean.getUsername());
				session.put("domain", loginBean.getDomain());
				System.out.println("in fo");
				//				test
				return "login_success_fo";
			}
			else if(loginBean.getPrimaryPrivilege().equals("bi")){
				session.put("username", loginBean.getUsername());
				session.put("domain", loginBean.getDomain());
				System.out.println("in bi");
				return "login_success_bi";
			}
			else if(loginBean.getPrimaryPrivilege().equals("er")){
				System.out.println("Login Error no_privilege found");
				return "login_error_nopvg";
			}
			else{
				return "login_error";
			}

		}
		catch(Exception e){
			e.printStackTrace();
			return "master_error";
		}
		//return "login_error";
	}
}