
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

import vaannila.getset.Employee;
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
			String sql = "select u.primary_privilege, u.name from users u where u.username = ? and u.password=? and u.active=1";
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
			//				document.setContentType(rs.getString("ContentType"));
			patientFormBean.setLastName(rs.getString("last_name"));
			patientFormBean.setFirstName(rs.getString("first_name"));
			patientFormBean.setAge(rs.getString("age"));
			patientFormBean.setGender(rs.getString("gender"));
			patientFormBean.setMaritalStatus(rs.getString("marital_status"));
			patientFormBean.setEmpStatus(rs.getString("emp_status"));
			patientFormBean.setTreatingProvider(rs.getString("treating_provider"));
			patientFormBean.setReferringProvider(rs.getString("referring_provider"));
			patientFormBean.setRelationGuarantor(rs.getString("relation_guarantor"));
			patientFormBean.setPatientDOB(rs.getString("DOB"));
			patientFormBean.setPatientRace(rs.getString("race"));
			patientFormBean.setPatientEthinicity(rs.getString("ethnicity"));
			patientFormBean.setPatientLanguage(rs.getString("language"));
			patientFormBean.setMothersMaiden(rs.getString("mothers_maiden"));
			patientFormBean.setPatientSSN(rs.getString("SSN"));
			patientFormBean.setPatientDOO(rs.getString("DOO"));
			patientFormBean.setResidentialStreet(rs.getString("res_street"));
			patientFormBean.setResidentialCity(rs.getString("res_city"));
			patientFormBean.setResidentialState(rs.getString("res_state"));
			patientFormBean.setResidentialZipcode(rs.getString("res_zip"));
			patientFormBean.setMailStreet(rs.getString("mail_street"));
			patientFormBean.setMailCity(rs.getString("mail_city"));
			patientFormBean.setMailState(rs.getString("mail_state"));
			patientFormBean.setMailZipcode(rs.getString("mail_zip"));
			patientFormBean.setLastVisitDate(rs.getString("last_visit"));
			patientFormBean.setHomePhone(rs.getString("home_ph"));
			patientFormBean.setWorkPhone(rs.getString("work_ph"));
			patientFormBean.setCellPhone(rs.getString("cell_ph"));
			patientFormBean.setPatientEmail(rs.getString("email"));
			patientFormBean.setReminderMethod(rs.getString("recall_method"));
			patientFormBean.setDemographicsNotes(rs.getString("free_text_main"));
			patientFormBean.setConfidentialStatus(rs.getString("conf_status"));
			patientFormBean.setConfidentialSetBy(rs.getString("conf_set_by"));
			patientFormBean.setConfidentialDate(rs.getString("conf_date"));
			patientFormBean.setTreatmentDate(rs.getString("treatment_date"));
			patientFormBean.setOnsetDate(rs.getString("onset_date"));
			patientFormBean.setDischargeDate(rs.getString("discharge_date"));
			patientFormBean.setFacilityName(rs.getString("facility_name"));
			patientFormBean.setEmailConsent(rs.getString("email_consent"));
			patientFormBean.setBodyPart(rs.getString("body_part"));
			patientFormBean.setAdditionalInformationNotes(rs.getString("free_text_additional_info"));
			patientFormBean.setPatientConsent(rs.getString("patient_consent"));
			patientFormBean.setConsentDateSet(rs.getString("consent_date_set"));
			patientFormBean.setConsentNotes(rs.getString("consent_notes"));
			patientFormBean.setPrimaryInsuranceProvider(rs.getString("insurance_provider"));
			patientFormBean.setPrimaryInsuranceIdNumber(rs.getString("insurance_id_no"));
			patientFormBean.setPrimaryGroupIdNumber(rs.getString("insurance_group_id_no"));
			patientFormBean.setPrimaryPolicyProviderName(rs.getString("policy_provider_name"));
			patientFormBean.setPrimaryProviderDOB(rs.getString("policy_provider_DOB"));
			patientFormBean.setPatientAilment(rs.getString("ailment"));
			patientFormBean.setSecondaryInsurance(rs.getString("secondary_insurance"));
			patientFormBean.setSecondaryInsuranceProvider(rs.getString("secondary_insurance_provider"));
			patientFormBean.setSecondaryInsuranceIdNumber(rs.getString("secondary_insurance_id_no"));
			patientFormBean.setSecondaryGroupIdNumber(rs.getString("secondary_insurance_group_no"));
			patientFormBean.setSecondaryPolicyProviderName(rs.getString("secondary_policy_provider_name"));
			patientFormBean.setSecondaryProviderDOB(rs.getString("secondary_policy_provider_DOB"));
			patientFormBean.setTertiaryInsurance(rs.getString("tertiary_insurance"));
			patientFormBean.setTertiaryInsuranceProvider(rs.getString("tertiary_insurance_provider"));
			patientFormBean.setTertiaryInsuranceIdNumber(rs.getString("tertiary_insurance_id_no"));
			patientFormBean.setTertiaryGroupIdNumber(rs.getString("tertiary_insurance_group_no"));
			patientFormBean.setTertiaryPolicyProviderName(rs.getString("tertiary_policy_provider_name"));
			patientFormBean.setTertiaryProviderDOB(rs.getString("tertiary_policy_provider_DOB"));
			patientFormBean.setInsurancePhoneNumber(rs.getString("insurance_ph_number"));
			patientFormBean.setAuthorisedVisits(rs.getString("authorised_visits"));
			patientFormBean.setValidityDates(rs.getString("validity_date"));
			patientFormBean.setPatientCoPay(rs.getString("copay"));
			patientFormBean.setPatientCoInsurance(rs.getString("coinsurance"));
			patientFormBean.setPatientDeductible(rs.getString("deductible"));
			patientFormBean.setThirdPartyPayer(rs.getString("third_party_payer"));
			patientFormBean.setScriptRequired(rs.getString("script_required"));
			patientFormBean.setPaymentNotes(rs.getString("big_free_text"));
			patientFormBean.setPatientPhoto(rs.getString("picture"));
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	@SuppressWarnings("rawtypes")



	public static void patientEntryUpdateDemographicsTab(
			PatientForm patientFormBean, Map m) {
		System.out.println("In patientEntryUpdateDemographicsTab");

		try{
			Connection conn = null;
			String url = "jdbc:mysql://127.0.0.1:3306/";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String pass = "tachsec";
			System.out.println("post db initialize in patient EntryUPdate Demographics");
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
					",free_text_main='" +patientFormBean.getDemographicsNotes()+ "'" + 
					"where patient_no='"+patientFormBean.getPatientID()+ "'";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			System.out.println(sql);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}			
	}



	@SuppressWarnings("rawtypes")
	public static void patientEntryUpdatePaymentTab(
			PatientForm patientFormBean, Map m) {
		System.out.println("In patientEntryUpdatePaymentTab");

		try{
			Connection conn = null;
			String url = "jdbc:mysql://127.0.0.1:3306/";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String pass = "tachsec";
			System.out.println("post db initialize in patient EntryUPdate Payment");
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
			String sql = "UPDATE patient_form set patient_consent='" +patientFormBean.getPatientConsent()+ "'" +
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
					"where patient_no='"+patientFormBean.getPatientID()+ "'";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			System.out.println(sql);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}			
	}




	@SuppressWarnings("rawtypes")
	public static void patientEntryUpdateAdditionalTab(
			PatientForm patientFormBean, Map m) {
		System.out.println("In patientEntryUpdateAdditionalTab");

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
			String sql = "UPDATE patient_form set conf_status='" +patientFormBean.getConfidentialStatus()+ "'" +
					",conf_set_by='" +patientFormBean.getConfidentialSetBy()+ "'" +
					",conf_date='" +patientFormBean.getConfidentialDate()+ "'" +
					",treatment_date='" +patientFormBean.getTreatmentDate()+ "'" +
					",onset_date='" +patientFormBean.getOnsetDate()+ "'" +
					",discharge_date='" +patientFormBean.getDischargeDate()+ "'" +
					",facility_name='" +patientFormBean.getFacilityName()+ "'" +
					",email_consent='" +patientFormBean.getEmailConsent()+ "'," +
					"body_part='" +patientFormBean.getBodyPart()+ "'" +
					",free_text_additional_info='" +patientFormBean.getAdditionalInformationNotes()+ "'" +
					"where patient_no='"+patientFormBean.getPatientID()+ "'";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			System.out.println(sql);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}			
	}



	@SuppressWarnings("rawtypes")
	public static void patientEntryDemographicsTab(PatientForm patientFormBean,
			Map m) {
		System.out.println("In patientEntry demographics");

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
					"mail_state,mail_zip,last_visit,home_ph,work_ph,cell_ph,email,recall_method,free_text_main" +
					")   VALUES('"
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



	@SuppressWarnings("rawtypes")
	public static void patientEntryAdditionalTab(PatientForm patientFormBean,
			Map m) {
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
			String sql = "INSERT INTO patient_form(conf_status,conf_set_by,conf_date,treatment_date,onset_date,discharge_date,facility_name,email_consent," +
					"body_part,free_text_additional_info)   VALUES('"
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



	@SuppressWarnings("rawtypes")
	public static void patientEntryPaymentTab(PatientForm patientFormBean, Map m) {
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
			String sql = "INSERT INTO patient_form(patient_consent,consent_date_set,consent_notes," +
					"insurance_provider,insurance_id_no,insurance_group_id_no,policy_provider_name,policy_provider_DOB,ailment" +
					",secondary_insurance,secondary_insurance_provider," +
					"secondary_insurance_id_no,secondary_insurance_group_no,secondary_policy_provider_name," +
					"secondary_policy_provider_DOB,tertiary_insurance," +
					"tertiary_insurance_provider,tertiary_insurance_id_no,tertiary_insurance_group_no," +
					"tertiary_policy_provider_name,tertiary_policy_provider_DOB," +
					"insurance_ph_number,authorised_visits,validity_date,copay,coinsurance,deductible,third_party_payer," +
					"script_required,big_free_text,picture)   VALUES('"
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



	@SuppressWarnings("rawtypes")
	public static void employeeEntryOther(Employee employeeFormBean, Map m) {
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
				System.out.println("test first name"+employeeFormBean.getPrimaryRole());
				Class.forName(driver).newInstance();
				conn = (Connection) DriverManager.getConnection(url + m.get("domain"), userName, pass);
				System.out.println("after connection");
			} catch (Exception e) {
				System.out.println("exception " + e);
			}
			String sql1 = "INSERT INTO users(username,password,name,primary_privilege,active" +
					")   VALUES('"
					+ employeeFormBean.getUsername()
					+ "','"
					+ employeeFormBean.getPassword()
					+ "','"
					+ employeeFormBean.getFirstName()+" "+employeeFormBean.getLastName()
					+ "','"
					+ employeeFormBean.getPrimaryRole()
					+ "','1')";
			PreparedStatement ps1 = (PreparedStatement) conn.prepareStatement(sql1);
			System.out.println(sql1);
			ps1.executeUpdate();	


			String sql = "INSERT INTO employee(username,password,last_name,first_name,employee_id,age," +
					"gender,marital_status,DOB,race,ethnicity,language,picture,home_ph,cell_ph,email," +
					"res_street,res_city,res_state,res_zipcode,mail_street,mail_city," +
					"mail_state,mail_zipcode,SSN,primary_role,pt_privilege,fo_privilege,bi_privilege,hr_privilege" +
					")   VALUES('"
					+ employeeFormBean.getUsername()
					+ "','"
					+ employeeFormBean.getPassword()
					+ "','"
					+ employeeFormBean.getLastName()
					+ "','"
					+ employeeFormBean.getFirstName()
					+ "','"
					+ employeeFormBean.getEmployeeID()
					+ "','"
					+ employeeFormBean.getAge()
					+ "','"
					+ employeeFormBean.getGender()
					+ "','"
					+ employeeFormBean.getMaritalStatus()
					+ "','"
					+ employeeFormBean.getDOB()
					+ "','"
					+ employeeFormBean.getRace()
					+ "','"
					+ employeeFormBean.getEthnicity()
					+ "','"
					+ employeeFormBean.getLanguage()
					+ "','"
					+ employeeFormBean.getPicture()
					+ "','"
					+ employeeFormBean.getHomePhone()
					+ "','"
					+ employeeFormBean.getCellPhone()
					+ "','"
					+ employeeFormBean.getEmail()
					+ "','"
					+ employeeFormBean.getResidentialStreet()
					+ "','"
					+ employeeFormBean.getResidentialCity()
					+ "','"
					+ employeeFormBean.getResidentialState()
					+ "','"
					+ employeeFormBean.getResidentialZipcode()
					+ "','"
					+ employeeFormBean.getMailStreet()
					+ "','"
					+ employeeFormBean.getMailCity()
					+ "','"
					+ employeeFormBean.getMailState()
					+ "','"
					+ employeeFormBean.getMailZipcode()
					+ "','"
					+ employeeFormBean.getSSN()
					+ "','"
					+ employeeFormBean.getPrimaryRole()
					+ "','"
					+ employeeFormBean.isPtPrivilege()
					+ "','"
					+ employeeFormBean.isFoPrivilege()
					+ "','"
					+ employeeFormBean.isBiPrivilege()
					+ "','"
					+ employeeFormBean.isHrPrivilege()
					+ "')";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			System.out.println(sql);
			ps.executeUpdate();	

		}catch(Exception e){
			e.printStackTrace();
		}		

	}



	@SuppressWarnings("rawtypes")
	public static void employeeEntryPT(Employee employeeFormBean, Map m) {
		System.out.println("In Employee Entry");

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
				System.out.println("test first name"+employeeFormBean.getPrimaryRole());
				Class.forName(driver).newInstance();
				conn = (Connection) DriverManager.getConnection(url + m.get("domain"), userName, pass);
				System.out.println("after connection");
			} catch (Exception e) {
				System.out.println("exception " + e);
			}
			String sql1 = "INSERT INTO users(username,password,name,primary_privilege,active" +
					")   VALUES('"
					+ employeeFormBean.getUsername()
					+ "','"
					+ employeeFormBean.getPassword()
					+ "','"
					+ employeeFormBean.getFirstName()+" "+employeeFormBean.getLastName()
					+ "','"
					+ employeeFormBean.getPrimaryRole()
					+ "','1')";
			PreparedStatement ps1 = (PreparedStatement) conn.prepareStatement(sql1);
			System.out.println(sql1);
			ps1.executeUpdate();	


			String sql = "INSERT INTO employee(username,password,last_name,first_name,employee_id,age," +
					"gender,marital_status,DOB,race,ethnicity,language,picture,home_ph,cell_ph,email," +
					"res_street,res_city,res_state,res_zipcode,mail_street,mail_city," +
					"mail_state,mail_zipcode,SSN,PTID1,PTID2,PTID3,PTID4,PTID5," +
					"primary_role,pt_privilege,fo_privilege,bi_privilege,hr_privilege" +
					")   VALUES('"
					+ employeeFormBean.getUsername()
					+ "','"
					+ employeeFormBean.getPassword()
					+ "','"
					+ employeeFormBean.getLastName()
					+ "','"
					+ employeeFormBean.getFirstName()
					+ "','"
					+ employeeFormBean.getEmployeeID()
					+ "','"
					+ employeeFormBean.getAge()
					+ "','"
					+ employeeFormBean.getGender()
					+ "','"
					+ employeeFormBean.getMaritalStatus()
					+ "','"
					+ employeeFormBean.getDOB()
					+ "','"
					+ employeeFormBean.getRace()
					+ "','"
					+ employeeFormBean.getEthnicity()
					+ "','"
					+ employeeFormBean.getLanguage()
					+ "','"
					+ employeeFormBean.getPicture()
					+ "','"
					+ employeeFormBean.getHomePhone()
					+ "','"
					+ employeeFormBean.getCellPhone()
					+ "','"
					+ employeeFormBean.getEmail()
					+ "','"
					+ employeeFormBean.getResidentialStreet()
					+ "','"
					+ employeeFormBean.getResidentialCity()
					+ "','"
					+ employeeFormBean.getResidentialState()
					+ "','"
					+ employeeFormBean.getResidentialZipcode()
					+ "','"
					+ employeeFormBean.getMailStreet()
					+ "','"
					+ employeeFormBean.getMailCity()
					+ "','"
					+ employeeFormBean.getMailState()
					+ "','"
					+ employeeFormBean.getMailZipcode()
					+ "','"
					+ employeeFormBean.getSSN()
					+ "','"
					+ employeeFormBean.getPTID1()
					+ "','"
					+ employeeFormBean.getPTID2()
					+ "','"
					+ employeeFormBean.getPTID3()
					+ "','"
					+ employeeFormBean.getPTID4()
					+ "','"
					+ employeeFormBean.getPTID5()
					+ "','"
					+ employeeFormBean.getPrimaryRole()
					+ "','"
					+ employeeFormBean.isPtPrivilege()
					+ "','"
					+ employeeFormBean.isFoPrivilege()
					+ "','"
					+ employeeFormBean.isBiPrivilege()
					+ "','"
					+ employeeFormBean.isHrPrivilege()
					+ "')";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			System.out.println(sql);
			ps.executeUpdate();	

		}catch(Exception e){
			e.printStackTrace();
		}		

	}



	@SuppressWarnings("rawtypes")
	public static void retrieveEmployeeForm(Employee employeeFormBean, Map m) {
		// TODO Auto-generated method stub
		
	}

}