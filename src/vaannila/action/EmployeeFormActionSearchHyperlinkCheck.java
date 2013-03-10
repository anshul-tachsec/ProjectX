package vaannila.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import vaannila.DAO.LoginDAO;
import vaannila.getset.Employee;
public class EmployeeFormActionSearchHyperlinkCheck extends ActionSupport implements SessionAware{ 

	@SuppressWarnings("rawtypes")
	Map m;  

	public void setSession(@SuppressWarnings("rawtypes") Map m)
	{
		this.m=m;
	}
	private static final long serialVersionUID = 1L;
	public Employee employeeFormBean;
	
	public EmployeeFormActionSearchHyperlinkCheck(){
		this.employeeFormBean=new Employee();
	}
		public Employee getEmployeeFormBean() {
		return employeeFormBean;
	}
	public void setEmployeeFormBean(Employee employeeFormBean) {
		this.employeeFormBean = employeeFormBean;
	}
		public String execute() throws Exception{
		System.out.println("In SearchHyperlink Redirect of HR");

		System.out.println("username via session"+m.get("username"));	
		System.out.println("domain via session"+m.get("domain"));
		System.out.println("Search employee username"+employeeFormBean.getUsername());
		LoginDAO.retrieveEmployeeForm(employeeFormBean, m);
		return "employee_form_search_hyperlink";
	}
}