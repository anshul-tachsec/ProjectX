package vaannila.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import vaannila.DAO.LoginDAO;
import vaannila.getset.Employee;
public class EmployeeFormAction extends ActionSupport implements SessionAware{ 

	@SuppressWarnings("rawtypes")
	Map m;  

	public void setSession(@SuppressWarnings("rawtypes") Map m)
	{
		this.m=m;
	}
	private static final long serialVersionUID = 1L;
	public Employee employeeFormBean;

	public Employee getEmployeeFormBean() {
		return employeeFormBean;
	}

	public void setEmployeeFormBean(Employee employeeFormBean) {
		this.employeeFormBean = employeeFormBean;
	}

	public EmployeeFormAction()
	{
		this.employeeFormBean=new Employee();
	}

	public String execute() throws Exception{
		System.out.println("In Employee Form");

		System.out.println("username via session"+m.get("username"));	
		System.out.println("domain via session"+m.get("domain"));
		
		System.out.println(employeeFormBean.getPrimaryRole()+"<----primary role");
		System.out.println(employeeFormBean.isHrPrivilege()+"<----hr");

		System.out.println(employeeFormBean.isPtPrivilege()+"<----pt");

		System.out.println(employeeFormBean.isFoPrivilege()+"<----fo");
		System.out.println(employeeFormBean.isBiPrivilege()+"<----bi");

		if(employeeFormBean.getPrimaryRole().equals("pt")){
			LoginDAO.employeeEntryPT(employeeFormBean , m );
		}
		if(employeeFormBean.getPrimaryRole().equals("fo")||employeeFormBean.getPrimaryRole().equals("hr")||employeeFormBean.getPrimaryRole().equals("bi")){
			LoginDAO.employeeEntryOther(employeeFormBean , m );

		}

		return "employee_form_success";
	}
}