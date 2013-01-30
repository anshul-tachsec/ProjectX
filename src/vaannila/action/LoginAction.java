package vaannila.action;

import java.util.Date;
import vaannila.helper.PasswordHelper;
import java.util.Map;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import vaannila.getset.Login;
import vaannila.DAO.LoginDAO;
public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
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
		System.out.println("before hashin: "+loginBean.getPassword());
//		loginBean.setPassword(PasswordHelper
//				.byteArrayToHexString(PasswordHelper.computeHash(loginBean.getPassword())));
//		System.out.println("after hashing: "+loginBean.getPassword());
//		loginBean.setPassword(PasswordHelper
//				.byteArrayToHexString(PasswordHelper.computeHash(loginBean.getPassword())));
//		System.out.println("again after hashing: "+loginBean.getPassword());

		String domain="";
		System.out.println("In Login Action");
		System.out.println("hash hashin: "+loginBean.getPassword());
		if(loginBean.getUsername().contains("@") && loginBean.getUsername().contains(".")){
			String[] EMAIL = loginBean.getUsername().split("@");
			System.out.println(EMAIL[0]);
			loginBean.setUsername(EMAIL[0]);
			domain=EMAIL[1].split("\\.")[0];
			System.out.println(domain);		
		}
		else{
			return "login_error";
		}		//string split
		LoginDAO.validateLogin(loginBean,domain);
		loginBean.getPrimaryPrivilege();
		try{
			if(loginBean.getPrimaryPrivilege().equals("pt")){
				ServletActionContext.getRequest().getSession().setAttribute("loggedInUser", loginBean.getUsername());
				System.out.println("in pt");
				return "login_success_pt";
			}
			else if(loginBean.getPrimaryPrivilege().equals("hr")){
				ServletActionContext.getRequest().getSession().setAttribute("loggedInUser", loginBean.getUsername());
				System.out.println("in hr");
				return "login_success_hr";
			}
			else if(loginBean.getPrimaryPrivilege().equals("fo")){
				ServletActionContext.getRequest().getSession().setAttribute("loggedInUser", loginBean.getUsername());
				System.out.println("in fo");
				//				test
				return "login_success_fo";
			}
			else if(loginBean.getPrimaryPrivilege().equals("bi")){
				ServletActionContext.getRequest().getSession().setAttribute("loggedInUser", loginBean.getUsername());
				System.out.println("in bi");
				return "login_success_bi";
			}
			else if(loginBean.getPrimaryPrivilege().equals("er")){
				ServletActionContext.getRequest().getSession().setAttribute("loggedInUser", loginBean.getUsername());
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