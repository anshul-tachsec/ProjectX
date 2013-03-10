package vaannila.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import vaannila.DAO.LoginDAO;
import vaannila.getset.Employee;
public class EmployeeFormActionUpdate extends ActionSupport implements SessionAware{ 

	@SuppressWarnings("rawtypes")
	Map m;  

	public void setSession(@SuppressWarnings("rawtypes") Map m)
	{
		this.m=m;
	}
	private static final long serialVersionUID = 1L;
	public Employee employeeFormBean;
	public Employee getEmployeeBean(){
		return employeeFormBean;
	}
	public EmployeeFormActionUpdate(){
		this.employeeFormBean=new Employee();
	}
	public void setEmployeeBean(Employee employeeFormBean) {

		this.employeeFormBean = employeeFormBean;
	}
	public String execute() throws Exception{
		System.out.println("In EmployeeActionUpdate");

		System.out.println("username via session"+m.get("username"));	
		System.out.println("domain via session"+m.get("domain"));
		System.out.println("before patiententry update Additional Tab");
		LoginDAO.updateEmployee(employeeFormBean , m );
		System.out.println("before patient retrieval Additional tab ");

		LoginDAO.retrieveEmployeeForm(employeeFormBean, m);
		return "employee_form_success";
	}
}