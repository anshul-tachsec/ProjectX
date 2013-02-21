package vaannila.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import vaannila.DAO.LoginDAO;
import vaannila.getset.PatientFormSearch;
public class PatientFormActionSimpleSearch extends ActionSupport implements SessionAware{ 

	@SuppressWarnings("rawtypes")
	Map m;  

	public void setSession(@SuppressWarnings("rawtypes") Map m)
	{
		this.m=m;
	}
	private static final long serialVersionUID = 1L;
	public PatientFormSearch patientFormBean;
	public PatientFormSearch getPatientFormBean(){
		return patientFormBean;
	}
	public PatientFormActionSimpleSearch()
	{
		this.patientFormBean=new PatientFormSearch();
	}
	public void setPatientFormBean(PatientFormSearch patientForm) {

		this.patientFormBean = patientForm;
	}
	public String execute() throws Exception{
		System.out.println("In PatientFormAction AdditionalTab");

		System.out.println("username via session"+m.get("username"));	
		System.out.println("domain via session"+m.get("domain"));

		LoginDAO.patientEntrySimpleSearch(patientFormBean , m );
		return "patient_form_simple_search";
	}
}