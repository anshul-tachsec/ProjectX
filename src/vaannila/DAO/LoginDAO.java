
package vaannila.DAO;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import java.sql.DriverManager;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
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
					+ patientFormBean.getScripequired()
					+ "','"
					+ patientFormBean.getPaymentNotes()
					+ "','"
					+ patientFormBean.getPatientPhoto()
					+ "')";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			System.out.println(sql);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
