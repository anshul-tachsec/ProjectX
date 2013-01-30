package vaannila.action;

import vaannila.getset.Patient;
import vaannila.DAO.PatientDAO;
import com.opensymphony.xwork2.ActionSupport;

public class PatientAction extends ActionSupport {


	private static final long serialVersionUID = 1L;
	public Patient patientLoginBean;
	public Patient getPatientLoginBean(){
		return patientLoginBean;
	}
	public PatientAction()
	{
		this.patientLoginBean=new Patient();
	}
	public void setPatientLoginBean(Patient patient) {

		this.patientLoginBean = patient;
	}
	public String execute() throws Exception{
		System.out.println("In PatientLogin Action");
		try{
			String patientResult=PatientDAO.validatePatientLogin(patientLoginBean);
			if(patientResult.equals("patient_login")){
				return "patient_login";
			}
			else{
				return "login_error";
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return "login_error";

		}
	}
}



