
package vaannila.DAO;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import com.mysql.jdbc.ResultSetImpl;
import vaannila.getset.Login;
import vaannila.getset.PatientForm;

public class LoginDAO {

	public static void validateLogin(Login loginBean){

		System.out.println("In logindao");
		String username=loginBean.getUsername();
		String password=loginBean.getPassword();
		System.out.println("username: "+username+"\npassword: "+password);
		System.out.println("domain: "+loginBean.getDomain());

		try{
			Connection conn = null;
			String url = "jdbc:mysql://127.0.0.1:3306/";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String pass = "tachsec";
			System.out.println("post db initialize");
			/*domain contains name of database.	
			 * 
			 */
			try {
				Class.forName(driver).newInstance();
				conn = (Connection) DriverManager.getConnection(url + loginBean.getDomain(), userName, pass);
				System.out.println("after connection");
			} catch (Exception e) {
				System.out.println("exception " + e);
			}
			String sql = "select u.primary_privilege, u.name from users u where u.username = ? and u.password=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSetImpl rs = (ResultSetImpl) ps.executeQuery();
			if (rs.next()) {
				loginBean.setPrimaryPrivilege(rs.getString(1));
				System.out.println("set "+rs.getString(1));
				System.out.println("get "+loginBean.getPrimaryPrivilege());
				loginBean.setName(rs.getString(2));
				System.out.println(rs.getString(2));
				loginBean.setPrimaryPrivilege(rs.getString(1));
			}
			System.out.println("username: "+username+"\npassword: "+password);
		}catch(Exception e){
			e.printStackTrace();
		}	}
	public static void patientEntry(PatientForm patientFormBean,@SuppressWarnings("rawtypes") Map m ) {
		System.out.println("In patientEntry");

		try{
			Connection conn = null;
			String url = "jdbc:mysql://127.0.0.1:3306/";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String pass = "tachsec";
			System.out.println("post db initialize in patient Entry");
			System.out.println("Domain Name DAO: "+m.get("domain"));
			System.out.println();
			/*domain contains name of database.	
			 * 
			 */
			try {
				System.out.println("test first name"+patientFormBean.getFirstName());
				Class.forName(driver).newInstance();
				conn = (Connection) DriverManager.getConnection(url + m.get("domain"), userName, pass);
				System.out.println("after connection");
			} catch (Exception e) {
				System.out.println("exception " + e);
			}
			String sql = "INSERT INTO patient_form(  last_name,first_name,age,gender,marital_status" +
					",emp_status,treating_provider,referring_provider,relation_guarantor,DOB,race,ethnicity," +
					"language,mothers_maiden,SSN,DOO,res_street,res_city,res_state,res_zip,mail_street,mail_city," +
					"mail_state,mail_zip,last_visit,home_ph,work_ph,cell_ph,email,recall_method,free_text_main," +
					"conf_status,conf_set_by,conf_date,treatment_date,onset_date,discharge_date,facility_name,email_consent," +
					"body_part,free_text_additional_info,patient_consent,consent_date_set,consent_notes," +
					"insurance_provider,insurance_id_no,insurance_group_id_no,policy_provider_name,policy_provider_DOB,ailment" +
					",secondary_insurance,secondary_insurance_provider," +
					"secondary_insurance_id_no,secondary_insurance_group_no,secondary_policy_provider_name," +
					"secondary_policy_provider_DOB,tertiary_insurance," +
					"tertiary_insurance_provider,tertiary_insurance_id_no,tertiary_insurance_group_no," +
					"tertiary_policy_provider_name,tertiary_policy_provider_DOB," +
					"insurance_ph_number,authorised_visits,validity_date,copay,coinsurance,deductible,third_party_payer," +
					"script_required,big_free_text,picture)   VALUES('"
					+ patientFormBean.getLastName()
					+ "','"
					+ patientFormBean.getFirstName()
					+ "','"
					+ patientFormBean.getAge()
					+ "','"
					+ patientFormBean.getGender()
					+ "','"
					+ patientFormBean.getMaritalStatus()
					+ "','"
					+ patientFormBean.getEmpStatus()
					+ "','"
					+ patientFormBean.getTreatingProvider()
					+ "','"
					+ patientFormBean.getReferringProvider()
					+ "','"
					+ patientFormBean.getRelationGuarantor()
					+ "','"
					+ patientFormBean.getPatientDOB()
					+ "','"
					+ patientFormBean.getPatientRace()
					+ "','"
					+ patientFormBean.getPatientEthinicity()
					+ "','"
					+ patientFormBean.getPatientLanguage()
					+ "','"
					+ patientFormBean.getMothersMaiden()
					+ "','"
					+ patientFormBean.getPatientSSN()
					+ "','"
					+ patientFormBean.getPatientDOO()
					+ "','"
					+ patientFormBean.getResidentialStreet()
					+ "','"
					+ patientFormBean.getResidentialCity()
					+ "','"
					+ patientFormBean.getResidentialState()
					+ "','"
					+ patientFormBean.getResidentialZipcode()
					+ "','"
					+ patientFormBean.getMailStreet()
					+ "','"
					+ patientFormBean.getMailCity()
					+ "','"
					+ patientFormBean.getMailState()
					+ "','"
					+ patientFormBean.getMailZipcode()
					+ "','"
					+ patientFormBean.getLastVisitDate()
					+ "','"
					+ patientFormBean.getHomePhone()
					+ "','"
					+ patientFormBean.getWorkPhone()
					+ "','"
					+ patientFormBean.getCellPhone()
					+ "','"
					+ patientFormBean.getPatientEmail()
					+ "','"
					+ patientFormBean.getReminderMethod()
					+ "','"
					+ patientFormBean.getDemographicsNotes()
					+ "','"
					+ patientFormBean.getConfidentialStatus()
					+ "','"
					+ patientFormBean.getConfidentialSetBy()
					+ "','"
					+ patientFormBean.getConfidentialDate()
					+ "','"
					+ patientFormBean.getTreatmentDate()
					+ "','"
					+ patientFormBean.getOnsetDate()
					+ "','"
					+ patientFormBean.getDischargeDate()
					+ "','"
					+ patientFormBean.getFacilityName()
					+ "','"
					+ patientFormBean.getEmailConsent()
					+ "','"
					+ patientFormBean.getBodyPart()
					+ "','"
					+ patientFormBean.getAdditionalInformationNotes()
					+ "','"
					+ patientFormBean.getPatientConsent()
					+ "','"
					+ patientFormBean.getConsentDateSet()
					+ "','"
					+ patientFormBean.getConsentNotes()
					+ "','"
					+ patientFormBean.getPrimaryInsuranceProvider()
					+ "','"
					+ patientFormBean.getPrimaryInsuranceIdNumber()
					+ "','"
					+ patientFormBean.getPrimaryGroupIdNumber()
					+ "','"
					+ patientFormBean.getPrimaryPolicyProviderName()
					+ "','"
					+ patientFormBean.getPrimaryProviderDOB()
					+ "','"
					+ patientFormBean.getPatientAilment()
					+ "','"
					+ patientFormBean.getSecondaryInsurance()
					+ "','"
					+ patientFormBean.getSecondaryInsuranceProvider()
					+ "','"
					+ patientFormBean.getSecondaryInsuranceIdNumber()
					+ "','"
					+ patientFormBean.getSecondaryGroupIdNumber()
					+ "','"
					+ patientFormBean.getSecondaryPolicyProviderName()
					+ "','"
					+ patientFormBean.getSecondaryProviderDOB()
					+ "','"
					+ patientFormBean.getTertiaryInsurance()
					+ "','"
					+ patientFormBean.getTertiaryInsuranceProvider()
					+ "','"
					+ patientFormBean.getTertiaryInsuranceIdNumber()
					+ "','"
					+ patientFormBean.getTertiaryGroupIdNumber()
					+ "','"
					+ patientFormBean.getTertiaryPolicyProviderName()
					+ "','"
					+ patientFormBean.getTertiaryProviderDOB()
					+ "','"
					+ patientFormBean.getInsurancePhoneNumber()
					+ "','"
					+ patientFormBean.getAuthorisedVisits()
					+ "','"
					+ patientFormBean.getValidityDates()
					+ "','"
					+ patientFormBean.getPatientCoPay()
					+ "','"
					+ patientFormBean.getPatientCoInsurance()
					+ "','"
					+ patientFormBean.getPatientDeductible()
					+ "','"
					+ patientFormBean.getThirdPartyPayer()
					+ "','"
					+ patientFormBean.getScriptRequired()
					+ "','"
					+ patientFormBean.getPaymentNotes()
					+ "','"
					+ patientFormBean.getPatientPhoto()
					+ "')";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			System.out.println(sql);
			ps.executeUpdate();
			/*
			 * to test last_insert_id functionality.
			 */
			//Thread.sleep(100000);
			/*
			 * for retrieving last updated Primary key;
			 */
			String check = "SELECT LAST_INSERT_ID()";
			ps.execute(check);
			ResultSet rs = ps.getResultSet();
			rs.next();
			patientFormBean.setPatientID(rs.getInt(1));			

		}catch(Exception e){
			e.printStackTrace();
		}

	}
	public static void patientEntryUpdate(PatientForm patientFormBean,
			@SuppressWarnings("rawtypes") Map m) {
		System.out.println("In patientEntryUpdate");

		try{
			Connection conn = null;
			String url = "jdbc:mysql://127.0.0.1:3306/";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String pass = "tachsec";
			System.out.println("post db initialize in patient EntryUPdate");
			System.out.println("Domain Name DAO: "+m.get("domain"));
			System.out.println();
			/*domain contains name of database.	
			 * 
			 */
			try {
				System.out.println("test "+patientFormBean.getPatientID());
				Class.forName(driver).newInstance();
				conn = (Connection) DriverManager.getConnection(url + m.get("domain"), userName, pass);
				System.out.println("after connection");
			} catch (Exception e) {
				System.out.println("exception " + e);
			}
			String sql = "UPDATE patient_form set last_name ='" +patientFormBean.getLastName()+ "'" +
					",first_name='" +patientFormBean.getFirstName()+ "'" +
					",age='" +patientFormBean.getAge()+ "'" +
					",gender='" +patientFormBean.getGender()+ "'" +
					",marital_status ='" +patientFormBean.getMaritalStatus()+ "'" +
					",emp_status='" +patientFormBean.getEmpStatus()+ "'" +
					",treating_provider='" +patientFormBean.getTreatingProvider()+ "'" +
					",referring_provider='" +patientFormBean.getReferringProvider()+ "'" +
					",relation_guarantor='" +patientFormBean.getRelationGuarantor()+ "'" +
					",DOB='" +patientFormBean.getPatientDOB()+ "'" +
					",race='" +patientFormBean.getPatientRace()+ "'" +
					",ethnicity='" +patientFormBean.getPatientEthinicity()+ "'," +
					"language='" +patientFormBean.getPatientLanguage()+ "'" +
					",mothers_maiden='" +patientFormBean.getMothersMaiden()+ "'" +
					",SSN='" +patientFormBean.getPatientSSN()+ "'" +
					",DOO='" +patientFormBean.getPatientDOO()+ "'" +
					",res_street='" +patientFormBean.getResidentialStreet()+ "'" +
					",res_city='" +patientFormBean.getResidentialCity()+ "'" +
					",res_state='" +patientFormBean.getResidentialState()+ "'" +
					",res_zip='" +patientFormBean.getResidentialZipcode()+ "'" +
					",mail_street='" +patientFormBean.getMailStreet()+ "'" +
					",mail_city='" +patientFormBean.getMailCity()+ "'," +
					"mail_state='" +patientFormBean.getMailState()+ "'" +
					",mail_zip='" +patientFormBean.getMailZipcode()+ "'" +
					",last_visit='" +patientFormBean.getLastVisitDate()+ "'" +
					",home_ph='" +patientFormBean.getHomePhone()+ "'" +
					",work_ph='" +patientFormBean.getWorkPhone()+ "'" +
					",cell_ph='" +patientFormBean.getCellPhone()+ "'" +
					",email='" +patientFormBean.getPatientEmail()+ "'" +
					",recall_method='" +patientFormBean.getReminderMethod()+ "'" +
					",free_text_main='" +patientFormBean.getDemographicsNotes()+ "'," +
					"conf_status='" +patientFormBean.getConfidentialStatus()+ "'" +
					",conf_set_by='" +patientFormBean.getConfidentialSetBy()+ "'" +
					",conf_date='" +patientFormBean.getConfidentialDate()+ "'" +
					",treatment_date='" +patientFormBean.getTreatmentDate()+ "'" +
					",onset_date='" +patientFormBean.getOnsetDate()+ "'" +
					",discharge_date='" +patientFormBean.getDischargeDate()+ "'" +
					",facility_name='" +patientFormBean.getFacilityName()+ "'" +
					",email_consent='" +patientFormBean.getEmailConsent()+ "'," +
					"body_part='" +patientFormBean.getBodyPart()+ "'" +
					",free_text_additional_info='" +patientFormBean.getAdditionalInformationNotes()+ "'" +
					",patient_consent='" +patientFormBean.getPatientConsent()+ "'" +
					",consent_date_set='" +patientFormBean.getConsentDateSet()+ "'" +
					",consent_notes='" +patientFormBean.getConsentNotes()+ "'," +
					"insurance_provider='" +patientFormBean.getPrimaryInsuranceProvider()+ "'" +
					",insurance_id_no='" +patientFormBean.getPrimaryInsuranceIdNumber()+ "'" +
					",insurance_group_id_no='" +patientFormBean.getPrimaryGroupIdNumber()+ "'" +
					",policy_provider_name='" +patientFormBean.getPrimaryPolicyProviderName()+ "'" +
					",policy_provider_DOB='" +patientFormBean.getPrimaryProviderDOB()+ "'" +
					",ailment='" +patientFormBean.getPatientAilment()+ "'" +
					",secondary_insurance='" +patientFormBean.getSecondaryInsurance()+ "'" +
					",secondary_insurance_provider='" +patientFormBean.getSecondaryInsuranceProvider()+ "'," +
					"secondary_insurance_id_no='" +patientFormBean.getSecondaryInsuranceIdNumber()+ "'" +
					",secondary_insurance_group_no='" +patientFormBean.getSecondaryGroupIdNumber()+ "'" +
					",secondary_policy_provider_name='" +patientFormBean.getSecondaryPolicyProviderName()+ "'," +
					"secondary_policy_provider_DOB='" +patientFormBean.getSecondaryProviderDOB()+ "'" +
					",tertiary_insurance='" +patientFormBean.getTertiaryInsurance()+ "'," +
					"tertiary_insurance_provider='" +patientFormBean.getTertiaryInsuranceProvider()+ "'" +
					",tertiary_insurance_id_no='" +patientFormBean.getTertiaryInsuranceIdNumber()+ "'" +
					",tertiary_insurance_group_no='" +patientFormBean.getTertiaryGroupIdNumber()+ "'," +
					"tertiary_policy_provider_name='" +patientFormBean.getTertiaryPolicyProviderName()+ "'" +
					",tertiary_policy_provider_DOB='" +patientFormBean.getTertiaryProviderDOB()+ "'," +
					"insurance_ph_number='" +patientFormBean.getInsurancePhoneNumber()+ "'" +
					",authorised_visits='" +patientFormBean.getAuthorisedVisits()+ "'" +
					",validity_date='" +patientFormBean.getValidityDates()+ "'" +
					",copay='" +patientFormBean.getPatientCoPay()+ "'" +
					",coinsurance='" +patientFormBean.getPatientCoInsurance()+ "'" +
					",deductible='" +patientFormBean.getPatientDeductible()+ "'" +
					",third_party_payer='" +patientFormBean.getThirdPartyPayer()+ "'," +
					"script_required='" +patientFormBean.getScriptRequired()+ "'" +
					",big_free_text='" +patientFormBean.getPaymentNotes()+ "'" +
					",picture='" +patientFormBean.getPatientPhoto()+ "'"+ 
					"where patient_no='"+patientFormBean.getPatientID()+ "'";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			System.out.println(sql);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	@SuppressWarnings("rawtypes")
	public static void retrievePatientForm(PatientForm patientFormBean, Map m) {
		System.out.println("In retrieve patient");

		try{

			Statement stmt = null;
			ResultSet rs = null;
			Connection conn = null;
			String url = "jdbc:mysql://127.0.0.1:3306/";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String pass = "tachsec";
			System.out.println("post db initialize in patient EntryUPdate");
			System.out.println("Domain Name DAO: "+m.get("domain"));
			System.out.println();
			/*domain contains name of database.	
			 * 
			 */
			try {
				System.out.println("test "+patientFormBean.getPatientID());
				Class.forName(driver).newInstance();
				conn = (Connection) DriverManager.getConnection(url + m.get("domain"), userName, pass);
				System.out.println("after connection");
			} catch (Exception e) {
				System.out.println("exception " + e);
			}

			stmt = conn.createStatement();
			String check = "SELECT * FROM patient_form WHERE patient_no="+patientFormBean.getPatientID();
			stmt.execute(check);
			rs = stmt.getResultSet();
			rs.next();
			patientFormBean.g
			//				document.setContentType(rs.getString("ContentType"));
			//				document.setFileSize(rs.getInt("FileSize"));

		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}

