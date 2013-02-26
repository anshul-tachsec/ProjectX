package vaannila.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import vaannila.getset.PatientFormSearch;

import com.opensymphony.xwork2.ActionSupport;


public class PatientFormActionAdvancedSearchPaymentTab extends ActionSupport implements SessionAware{

	@SuppressWarnings("rawtypes")
	Map m;  

	public void setSession(@SuppressWarnings("rawtypes") Map m)
	{
		this.m=m;
	}
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	ArrayList<PatientFormSearch> al=new ArrayList();
	public PatientFormSearch patientFormSearch;

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
		System.out.println("lastname " +patientFormSearch.getLastName());

		try{
			stmt = conn.createStatement();


			String check1="SELECT * FROM patient_form WHERE (patient_no = "+patientFormSearch.getPatientID()+"";
			String c40;// forgot c45
			String c41,c42,c43,c44,c46,c47,c48,c49,c50;
			String c51,c52,c53,c54,c55,c56,c57,c58,c59,c60;
			String c61,c62,c63,c64,c65,c66,c67,c68,c69,c70;
			

			if( patientFormSearch.getPatientConsent().toCharArray().length!=0 && patientFormSearch.getPatientConsent() !=null){ c40=" or  patient_consent= '"+patientFormSearch.getPatientConsent()+"'"; } else{ c40=""; }

			if( patientFormSearch.getConsentDateSet().toCharArray().length!=0 && patientFormSearch.getConsentDateSet() !=null){ c41=" or  consent_date_set= '"+patientFormSearch.getConsentDateSet()+"'"; } else{ c41=""; }

			if( patientFormSearch.getConsentNotes().toCharArray().length!=0 && patientFormSearch.getConsentNotes() !=null){ c42=" or  consent_notes= '"+patientFormSearch.getConsentNotes()+"'"; } else{ c42=""; }

			if( patientFormSearch.getPrimaryInsuranceProvider().toCharArray().length!=0 && patientFormSearch.getPrimaryInsuranceProvider() !=null){ c43=" or  insurance_provider= '"+patientFormSearch.getPrimaryInsuranceProvider()+"'"; } else{ c43=""; }

			if( patientFormSearch.getPrimaryInsuranceIdNumber().toCharArray().length!=0 && patientFormSearch.getPrimaryInsuranceIdNumber() !=null){ c44=" or  insurance_id_no= '"+patientFormSearch.getPrimaryInsuranceIdNumber()+"'"; } else{ c44=""; }

			if( patientFormSearch.getPrimaryGroupIdNumber().toCharArray().length!=0 && patientFormSearch.getPrimaryGroupIdNumber() !=null){ c46=" or insurance_group_id_no = '"+patientFormSearch.getPrimaryGroupIdNumber()+"'"; } else{ c46=""; }

			if( patientFormSearch.getPrimaryPolicyProviderName().toCharArray().length!=0 && patientFormSearch.getPrimaryPolicyProviderName() !=null){ c47=" or  policy_provider_name= '"+patientFormSearch.getPrimaryPolicyProviderName()+"'"; } else{ c47=""; }

			if( patientFormSearch.getPrimaryProviderDOB().toCharArray().length!=0 && patientFormSearch.getPrimaryProviderDOB() !=null){ c48=" or  policy_provider_DOB= '"+patientFormSearch.getPrimaryProviderDOB()+"'"; } else{ c48=""; }

			if( patientFormSearch.getPatientAilment().toCharArray().length!=0 && patientFormSearch.getPatientAilment() !=null){ c49=" or  ailment= '"+patientFormSearch.getPatientAilment()+"'"; } else{ c49=""; }

			if( patientFormSearch.getSecondaryInsurance().toCharArray().length!=0 && patientFormSearch.getSecondaryInsurance() !=null){ c50=" or  secondary_insurance= '"+patientFormSearch.getSecondaryInsuranceIdNumber()+"'"; } else{ c50=""; }

			if( patientFormSearch.getSecondaryInsuranceProvider().toCharArray().length!=0 && patientFormSearch.getSecondaryInsuranceProvider() !=null){ c51=" or  secondary_insurance_provider= '"+patientFormSearch.getSecondaryInsuranceProvider()+"'"; } else{ c51=""; }

			if( patientFormSearch.getSecondaryInsuranceIdNumber().toCharArray().length!=0 && patientFormSearch.getSecondaryInsuranceIdNumber() !=null){ c52=" or  secondary_insurance_id_no= '"+patientFormSearch.getSecondaryInsuranceIdNumber()+"'"; } else{ c52=""; }

			if( patientFormSearch.getSecondaryGroupIdNumber().toCharArray().length!=0 && patientFormSearch.getSecondaryGroupIdNumber() !=null){ c53=" or  secondary_insurance_group_id_no= '"+patientFormSearch.getSecondaryGroupIdNumber()+"'"; } else{ c53=""; }

			if( patientFormSearch.getSecondaryPolicyProviderName().toCharArray().length!=0 && patientFormSearch.getSecondaryPolicyProviderName() !=null){ c54=" or  secondary_policy_provider_name= '"+patientFormSearch.getSecondaryPolicyProviderName()+"'"; } else{ c54=""; }

			if( patientFormSearch.getSecondaryProviderDOB().toCharArray().length!=0 && patientFormSearch.getSecondaryProviderDOB() !=null){ c55=" or  secondary_policy_provider_DOB= '"+patientFormSearch.getSecondaryProviderDOB()+"'"; } else{ c55=""; }

			if( patientFormSearch.getTertiaryInsurance().toCharArray().length!=0 && patientFormSearch.getTertiaryInsurance() !=null){ c56=" or  tertiary_insurance= '"+patientFormSearch.getTertiaryInsurance()+"'"; } else{ c56=""; }

			if( patientFormSearch.getTertiaryInsuranceProvider().toCharArray().length!=0 && patientFormSearch.getTertiaryInsuranceProvider() !=null){ c57=" or  tertiary_insurance_provider= '"+patientFormSearch.getTertiaryInsuranceProvider()+"'"; } else{ c57=""; }

			if( patientFormSearch.getTertiaryInsuranceIdNumber().toCharArray().length!=0 && patientFormSearch.getTertiaryInsuranceIdNumber() !=null){ c58=" or  tertiary_insurance_id_no= '"+patientFormSearch.getTertiaryInsuranceIdNumber()+"'"; } else{ c58=""; }

			if( patientFormSearch.getTertiaryGroupIdNumber().toCharArray().length!=0 && patientFormSearch.getTertiaryGroupIdNumber() !=null){ c59=" or  tertiary_insurance_group_id_no= '"+patientFormSearch.getTertiaryGroupIdNumber()+"'"; } else{ c59=""; }

			if( patientFormSearch.getTertiaryPolicyProviderName().toCharArray().length!=0 && patientFormSearch.getTertiaryPolicyProviderName() !=null){ c60=" or  tertiary_policy_provider_name= '"+patientFormSearch.getTertiaryPolicyProviderName()+"'"; } else{ c60=""; }

			if( patientFormSearch.getTertiaryProviderDOB().toCharArray().length!=0 && patientFormSearch.getTertiaryProviderDOB() !=null){ c61=" or  tertiary_policy_provider_name= '"+patientFormSearch.getTertiaryProviderDOB()+"'"; } else{ c61=""; }

			if( patientFormSearch.getInsurancePhoneNumber().toCharArray().length!=0 && patientFormSearch.getInsurancePhoneNumber() !=null){ c62=" or  insurance_ph_number= '"+patientFormSearch.getInsurancePhoneNumber()+"'"; } else{ c62=""; }

			if( patientFormSearch.getAuthorisedVisits().toCharArray().length!=0 && patientFormSearch.getAuthorisedVisits() !=null){ c63=" or  authorised_visits= '"+patientFormSearch.getAuthorisedVisits()+"'"; } else{ c63=""; }

			if( patientFormSearch.getValidityDates().toCharArray().length!=0 && patientFormSearch.getValidityDates() !=null){ c64=" or  validity_date= '"+patientFormSearch.getValidityDates()+"'"; } else{ c64=""; }

			if( patientFormSearch.getPatientCoPay().toCharArray().length!=0 && patientFormSearch.getPatientCoPay() !=null){ c65=" or  copay= '"+patientFormSearch.getPatientCoPay()+"'"; } else{ c65=""; }

			if( patientFormSearch.getPatientCoInsurance().toCharArray().length!=0 && patientFormSearch.getPatientCoInsurance() !=null){ c66=" or coinsurance = '"+patientFormSearch.getPatientCoInsurance()+"'"; } else{ c66=""; }

			if( patientFormSearch.getPatientDeductible().toCharArray().length!=0 && patientFormSearch.getPatientDeductible() !=null){ c67=" or  deductible= '"+patientFormSearch.getPatientDeductible()+"'"; } else{ c67=""; }

			if( patientFormSearch.getThirdPartyPayer().toCharArray().length!=0 && patientFormSearch.getThirdPartyPayer() !=null){ c68=" or  third_party_payer= '"+patientFormSearch.getThirdPartyPayer()+"'"; } else{ c68=""; }

			if( patientFormSearch.getScriptRequired().toCharArray().length!=0 && patientFormSearch.getScriptRequired() !=null){ c69=" or  script_required= '"+patientFormSearch.getScriptRequired()+"'"; } else{ c69=""; }

			if( patientFormSearch.getPaymentNotes().toCharArray().length!=0 && patientFormSearch.getPaymentNotes()!=null){ c70=" or  big_free_text= '"+patientFormSearch.getPaymentNotes()+"'"; } else{ c70=""; }

			String check7=")";
			String check = ""+check1+c40+
					c41+c42+c43+c44+c46+c47+c48+c49+c50+
					c51+c52+c53+c54+c55+c56+c57+c58+c59+c60+
					c61+c62+c63+c64+c65+c66+c67+c68+c69+c70+check7+"";



			System.out.println(check);
			stmt.execute(check);
			rs = stmt.getResultSet();
			if(rs!=null){
				System.out.println("in set mode");
				while(rs.next()){
					patientFormSearch= new PatientFormSearch();
					patientFormSearch.setPatientID(rs.getInt("patient_no"));
					patientFormSearch.setLastName(rs.getString("last_name"));
					patientFormSearch.setFirstName(rs.getString("first_name"));
					patientFormSearch.setPatientDOB(rs.getString("DOB"));
					patientFormSearch.setCellPhone(rs.getString("cell_ph"));
					patientFormSearch.setPatientEmail(rs.getString("email"));
					al.add(patientFormSearch);
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

		return "patient_form_advanced_search";
	}

	public PatientFormSearch getPatientFormSearch() {
		return patientFormSearch;
	}

	public void setPatientFormSearch(PatientFormSearch patientFormSearch) {
		this.patientFormSearch = patientFormSearch;
	}
}
