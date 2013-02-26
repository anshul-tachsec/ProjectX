package vaannila.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import vaannila.DAO.LoginDAO;
import vaannila.getset.PatientForm;
public class PatientFormActionSearchHyperlink extends ActionSupport implements SessionAware{ 

	@SuppressWarnings("rawtypes")
	Map m;  

	public void setSession(@SuppressWarnings("rawtypes") Map m)
	{
		this.m=m;
	}
	private static final long serialVersionUID = 1L;
	public PatientForm patientFormBean;
	public PatientForm getPatientFormBean(){
		return patientFormBean;
	}
	public PatientFormActionSearchHyperlink(){
		this.patientFormBean=new PatientForm();
	}
	public void setPatientFormBean(PatientForm patientForm) {

		this.patientFormBean = patientForm;
	}
	public String execute() throws Exception{
		System.out.println("In SearchHyperlink Redirect");

		System.out.println("username via session"+m.get("username"));	
		System.out.println("domain via session"+m.get("domain"));
		System.out.println("Search patientID"+patientFormBean.getPatientID());
		LoginDAO.retrievePatientForm(patientFormBean, m);
		return "patient_form_search_hyperlink";
	}
}