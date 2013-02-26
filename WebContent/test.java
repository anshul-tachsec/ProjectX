package vaannila.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import vaannila.getset.PatientForm;

import com.opensymphony.xwork2.ActionSupport;


public class PatientFormActionAdvancedSearchAdditionalTab extends ActionSupport implements SessionAware{

	@SuppressWarnings("rawtypes")
	Map m;  

	public void setSession(@SuppressWarnings("rawtypes") Map m)
	{
		this.m=m;
	}
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	ArrayList<PatientForm> al=new ArrayList();
	public PatientForm patientFormBean;

	@SuppressWarnings("rawtypes")
	public ArrayList getAl() {
		return al;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setAl(ArrayList al) {
		this.al = al;
	}


	@SuppressWarnings("rawtypes")
	public String execute()throws Exception
	{
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String pass = "tachsec";
		if(m.get("domain")!=null) System.out.println("yes");
		else System.out.println("no");
		System.out.println("search");

		System.out.println("Domain Name DAO: "+m.get("domain"));
		System.out.println();

		try {
			Class.forName(driver).newInstance();
			System.out.println("map "+m.get("domain"));
			conn = (Connection) DriverManager.getConnection(url + m.get("domain"), userName, pass);
		} catch (Exception e) {
			System.out.println("exception " + e);
		}
		System.out.println("lastname " +patientFormBean.getLastName());

		try{
			stmt = conn.createStatement();


			String check1="SELECT * FROM patient_form WHERE (patient_no = "+patientFormBean.getPatientID()+"";
			String cc1,cc2,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
			String c11,c12,c13,c14,c15,c16,c17,c18,c19,c20;
			String c21,c22,c23,c24,c25,c26,c27,c28,c29,c30;
			String c31,c32,c33,c34,c35,c36,c37,c38,c39,c40;// forgot c45
			String c41,c42,c43,c44,c46,c47,c48,c49,c50;
			String c51,c52,c53,c54,c55,c56,c57,c58,c59,c60;
			String c61,c62,c63,c64,c65,c66,c67,c68,c69,c70;
			String c71;

			if(patientFormBean.getLastName().toCharArray().length!=0 ){
				cc1=" or last_name = '"+patientFormBean.getLastName()+"'";
				System.out.println("last"+patientFormBean.getLastName());
			}
			else{
				cc1="";
			}
			if(patientFormBean.getFirstName().toCharArray().length!=0 ){
				cc2=" or first_name = '"+patientFormBean.getFirstName()+"'";
				System.out.println("first"+patientFormBean.getFirstName());
			}
			else{
				cc2="";
			}
			if(patientFormBean.getAge()!=null){
				c1=" or  age= '"+patientFormBean.getAge()+"'"; }
			else{
				c1=""; 
				}

			if( patientFormBean.getGender()!=null){
				c2=" or  gender= '"+patientFormBean.getGender()+"'";
				} 
			else{ 
					c2="";
				}

			if( patientFormBean.getMaritalStatus()!=null){
				
				c3=" or  marital_status= '"+patientFormBean.getMaritalStatus()+"'"; 
				} 
			else{ 
				c3="";
				}

			if( patientFormBean.getEmpStatus()!=null){ c4=" or  emp_status= '"+patientFormBean.getEmpStatus()+"'"; } else{ c4=""; }

			if( patientFormBean.getTreatingProvider()!=null){ c5=" or  treating_provider= '"+patientFormBean.getTreatingProvider()+"'"; } else{ c5=""; }

			if( patientFormBean.getReferringProvider()!=null){ c6=" or  referring_provider= '"+patientFormBean.getReferringProvider()+"'"; } else{ c6=""; }

			if( patientFormBean.getRelationGuarantor()!=null){ c7=" or  relation_guarantor= '"+patientFormBean.getRelationGuarantor()+"'"; } else{ c7=""; }

			if( patientFormBean.getPatientDOB()!=null){ c8=" or  DOB= '"+patientFormBean.getPatientDOB()+"'"; } else{ c8=""; }

			if( patientFormBean.getPatientRace()!=null){ c9=" or  race= '"+patientFormBean.getPatientRace()+"'"; } else{ c9=""; }

			if( patientFormBean.getPatientEthinicity()!=null){ c10=" or  ethnicity= '"+patientFormBean.getPatientEthinicity()+"'"; } else{ c10=""; }

			if( patientFormBean.getPatientLanguage()!=null){ c11=" or  language= '"+patientFormBean.getPatientLanguage()+"'"; } else{ c11=""; }

			if( patientFormBean.getMothersMaiden()!=null){ c12=" or  mothers_maiden= '"+patientFormBean.getMothersMaiden()+"'"; } else{ c12=""; }

			if( patientFormBean.getPatientSSN()!=null){ c13=" or  SSN= '"+patientFormBean.getPatientSSN()+"'"; } else{ c13=""; }

			if( patientFormBean.getPatientDOO()!=null){ c14=" or  DOO= '"+patientFormBean.getPatientDOO()+"'"; } else{ c14=""; }

			if( patientFormBean.getResidentialStreet()!=null){ c15=" or  res_street= '"+patientFormBean.getResidentialStreet()+"'"; } else{ c15=""; }

			if( patientFormBean.getResidentialCity()!=null){ c16=" or  res_city= '"+patientFormBean.getResidentialCity()+"'"; } else{ c16=""; }

			if( patientFormBean.getResidentialState()!=null){ c17=" or  res_state= '"+patientFormBean.getResidentialState()+"'"; } else{ c17=""; }

			if( patientFormBean.getResidentialZipcode()!=null){ c18=" or  res_zip= '"+patientFormBean.getResidentialZipcode()+"'"; } else{ c18=""; }

			if( patientFormBean.getMailStreet()!=null){ c19=" or  mail_street= '"+patientFormBean.getMailStreet()+"'"; } else{ c19=""; }

			if( patientFormBean.getMailCity()!=null){ c20=" or  mail_city= '"+patientFormBean.getMailCity()+"'"; } else{ c20=""; }

			if( patientFormBean.getMailState()!=null){ c21=" or  mail_state= '"+patientFormBean.getMailState()+"'"; } else{ c21=""; }

			if( patientFormBean.getMailZipcode()!=null){ c22=" or  mail_zip= '"+patientFormBean.getMailZipcode()+"'"; } else{ c22=""; }

			if( patientFormBean.getLastVisitDate()!=null){ c23=" or  last_visit= '"+patientFormBean.getLastVisitDate()+"'"; } else{ c23=""; }

			if( patientFormBean.getHomePhone()!=null){ c24=" or  home_ph= '"+patientFormBean.getHomePhone()+"'"; } else{ c24=""; }

			if( patientFormBean.getWorkPhone()!=null){ c25=" or  work_ph= '"+patientFormBean.getWorkPhone()+"'"; } else{ c25=""; }

			if( patientFormBean.getCellPhone()!=null){ c26=" or  cell_ph= '"+patientFormBean.getCellPhone()+"'"; } else{ c26=""; }

			if( patientFormBean.getPatientEmail()!=null){ c27=" or  email= '"+patientFormBean.getPatientEmail()+"'"; } else{ c27=""; }

			if( patientFormBean.getReminderMethod()!=null){ c28=" or  recall_method= '"+patientFormBean.getReminderMethod()+"'"; } else{ c28=""; }

			if( patientFormBean.getDemographicsNotes()!=null){ c29=" or  free_text_main= '"+patientFormBean.getDemographicsNotes()+"'"; } else{ c29=""; }

			if( patientFormBean.getConfidentialStatus()!=null){ c30=" or  conf_status= '"+patientFormBean.getConfidentialStatus()+"'"; } else{ c30=""; }

			if( patientFormBean.getConfidentialSetBy()!=null){ c31=" or  conf_set_by= '"+patientFormBean.getConfidentialSetBy()+"'"; } else{ c31=""; }

			if( patientFormBean.getConfidentialDate()!=null){ c32=" or  conf_date= '"+patientFormBean.getConfidentialDate()+"'"; } else{ c32=""; }

			if( patientFormBean.getTreatmentDate()!=null){ c33=" or  treatment_date= '"+patientFormBean.getTreatmentDate()+"'"; } else{ c33=""; }

			if( patientFormBean.getOnsetDate()!=null){ c34=" or  onset_date= '"+patientFormBean.getOnsetDate()+"'"; } else{ c34=""; }

			if( patientFormBean.getDischargeDate()!=null){ c35=" or  discharge_date= '"+patientFormBean.getDischargeDate()+"'"; } else{ c35=""; }

			if( patientFormBean.getFacilityName()!=null){ c36=" or  facility_name= '"+patientFormBean.getFacilityName()+"'"; } else{ c36=""; }

			if( patientFormBean.getEmailConsent()!=null){ c37=" or  email_consent= '"+patientFormBean.getEmailConsent()+"'"; } else{ c37=""; }

			if( patientFormBean.getBodyPart()!=null){ c38=" or  body_part= '"+patientFormBean.getBodyPart()+"'"; } else{ c38=""; }

			if( patientFormBean.getAdditionalInformationNotes()!=null){ c39=" or  free_text_additional_info= '"+patientFormBean.getAdditionalInformationNotes()+"'"; } else{ c39=""; }

			if( patientFormBean.getPatientConsent()!=null){ c40=" or  patient_consent= '"+patientFormBean.getPatientConsent()+"'"; } else{ c40=""; }

			if( patientFormBean.getConsentDateSet()!=null){ c41=" or  consent_date_set= '"+patientFormBean.getConsentDateSet()+"'"; } else{ c41=""; }

			if( patientFormBean.getConsentNotes()!=null){ c42=" or  consent_notes= '"+patientFormBean.getConsentNotes()+"'"; } else{ c42=""; }

			if( patientFormBean.getPrimaryInsuranceProvider()!=null){ c43=" or  insurance_provider= '"+patientFormBean.getPrimaryInsuranceProvider()+"'"; } else{ c43=""; }

			if( patientFormBean.getPrimaryInsuranceIdNumber()!=null){ c44=" or  insurance_id_no= '"+patientFormBean.getPrimaryInsuranceIdNumber()+"'"; } else{ c44=""; }

			if( patientFormBean.getPrimaryGroupIdNumber()!=null){ c46=" or insurance_group_id_no = '"+patientFormBean.getPrimaryGroupIdNumber()+"'"; } else{ c46=""; }

			if( patientFormBean.getPrimaryPolicyProviderName()!=null){ c47=" or  policy_provider_name= '"+patientFormBean.getPrimaryPolicyProviderName()+"'"; } else{ c47=""; }

			if( patientFormBean.getPrimaryProviderDOB()!=null){ c48=" or  policy_provider_DOB= '"+patientFormBean.getPrimaryProviderDOB()+"'"; } else{ c48=""; }

			if( patientFormBean.getPatientAilment()!=null){ c49=" or  ailment= '"+patientFormBean.getPatientAilment()+"'"; } else{ c49=""; }

			if( patientFormBean.getSecondaryInsurance()!=null){ c50=" or  secondary_insurance= '"+patientFormBean.getSecondaryInsuranceIdNumber()+"'"; } else{ c50=""; }

			if( patientFormBean.getSecondaryInsuranceProvider()!=null){ c51=" or  secondary_insurance_provider= '"+patientFormBean.getSecondaryInsuranceProvider()+"'"; } else{ c51=""; }

			if( patientFormBean.getSecondaryInsuranceIdNumber()!=null){ c52=" or  secondary_insurance_id_no= '"+patientFormBean.getSecondaryInsuranceIdNumber()+"'"; } else{ c52=""; }

			if( patientFormBean.getSecondaryGroupIdNumber()!=null){ c53=" or  secondary_insurance_group_id_no= '"+patientFormBean.getSecondaryGroupIdNumber()+"'"; } else{ c53=""; }

			if( patientFormBean.getSecondaryPolicyProviderName()!=null){ c54=" or  secondary_policy_provider_name= '"+patientFormBean.getSecondaryPolicyProviderName()+"'"; } else{ c54=""; }

			if( patientFormBean.getSecondaryProviderDOB()!=null){ c55=" or  secondary_policy_provider_DOB= '"+patientFormBean.getSecondaryProviderDOB()+"'"; } else{ c55=""; }

			if( patientFormBean.getTertiaryInsurance()!=null){ c56=" or  tertiary_insurance= '"+patientFormBean.getTertiaryInsurance()+"'"; } else{ c56=""; }

			if( patientFormBean.getTertiaryInsuranceProvider()!=null){ c57=" or  tertiary_insurance_provider= '"+patientFormBean.getTertiaryInsuranceProvider()+"'"; } else{ c57=""; }

			if( patientFormBean.getTertiaryInsuranceIdNumber()!=null){ c58=" or  tertiary_insurance_id_no= '"+patientFormBean.getTertiaryInsuranceIdNumber()+"'"; } else{ c58=""; }

			if( patientFormBean.getTertiaryGroupIdNumber()!=null){ c59=" or  tertiary_insurance_group_id_no= '"+patientFormBean.getTertiaryGroupIdNumber()+"'"; } else{ c59=""; }

			if( patientFormBean.getTertiaryPolicyProviderName()!=null){ c60=" or  tertiary_policy_provider_name= '"+patientFormBean.getTertiaryPolicyProviderName()+"'"; } else{ c60=""; }

			if( patientFormBean.getTertiaryProviderDOB()!=null){ c61=" or  tertiary_policy_provider_name= '"+patientFormBean.getTertiaryProviderDOB()+"'"; } else{ c61=""; }

			if( patientFormBean.getInsurancePhoneNumber()!=null){ c62=" or  insurance_ph_number= '"+patientFormBean.getInsurancePhoneNumber()+"'"; } else{ c62=""; }

			if( patientFormBean.getAuthorisedVisits()!=null){ c63=" or  authorised_visits= '"+patientFormBean.getAuthorisedVisits()+"'"; } else{ c63=""; }

			if( patientFormBean.getValidityDates()!=null){ c64=" or  validity_date= '"+patientFormBean.getValidityDates()+"'"; } else{ c64=""; }

			if( patientFormBean.getPatientCoPay()!=null){ c65=" or  copay= '"+patientFormBean.getPatientCoPay()+"'"; } else{ c65=""; }

			if( patientFormBean.getPatientCoInsurance()!=null){ c66=" or coinsurance = '"+patientFormBean.getPatientCoInsurance()+"'"; } else{ c66=""; }

			if( patientFormBean.getPatientDeductible()!=null){ c67=" or  deductible= '"+patientFormBean.getPatientDeductible()+"'"; } else{ c67=""; }

			if( patientFormBean.getThirdPartyPayer()!=null){ c68=" or  third_party_payer= '"+patientFormBean.getThirdPartyPayer()+"'"; } else{ c68=""; }

			if( patientFormBean.getScriptRequired()!=null){ c69=" or  script_required= '"+patientFormBean.getScriptRequired()+"'"; } else{ c69=""; }

			if( patientFormBean.getPaymentNotes()!=null){ c70=" or  big_free_text= '"+patientFormBean.getPaymentNotes()+"'"; } else{ c70=""; }

			if( patientFormBean.getPatientPhoto()!=null){ c71=" or  picture= '"+patientFormBean.getPatientPhoto()+"'"; } else{ c71=""; }

			String check7=")";
			String check = ""+check1+cc1+cc2+c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+
					c11+c12+c13+c14+c15+c16+c17+c18+c19+c20+
					c21+c22+c23+c24+c25+c26+c27+c28+c29+c30+
					c31+c32+c33+c34+c35+c36+c37+c38+c39+c40+
					c41+c42+c43+c44+c46+c47+c48+c49+c50+
					c51+c52+c53+c54+c55+c56+c57+c58+c59+c60+
					c61+c62+c63+c64+c65+c66+c67+c68+c69+c70+
					c71+check7+"";



			System.out.println(check);
			stmt.execute(check);
			rs = stmt.getResultSet();
			if(rs!=null){
				System.out.println("in set mode");
				while(rs.next()){
					patientFormBean= new PatientForm();
					patientFormBean.setPatientID(rs.getInt("patient_no"));
					patientFormBean.setLastName(rs.getString("last_name"));
					patientFormBean.setFirstName(rs.getString("first_name"));
					patientFormBean.setPatientDOB(rs.getString("DOB"));
					patientFormBean.setCellPhone(rs.getString("cell_ph"));
					patientFormBean.setPatientEmail(rs.getString("email"));
					al.add(patientFormBean);
				}
			}
			System.out.println("in display --mode LOginDAO");
			ListIterator itr=al.listIterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}

		return "patient_form_simple_search";
	}

	public PatientForm getPatientFormSearch() {
		return patientFormBean;
	}

	public void setPatientFormSearch(PatientForm patientFormSearch) {
		this.patientFormBean = patientFormSearch;
	}
}
