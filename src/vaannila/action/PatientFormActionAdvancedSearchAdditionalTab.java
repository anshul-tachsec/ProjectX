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


public class PatientFormActionAdvancedSearchAdditionalTab extends ActionSupport implements SessionAware{

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
			String c30;
			String c31,c32,c33,c34,c35,c36,c37,c38,c39;// forgot c45


			if( patientFormSearch!=null && patientFormSearch.getConfidentialStatus().toCharArray().length!=0){ c30=" or  conf_status= '"+patientFormSearch.getConfidentialStatus()+"'"; } else{ c30=""; }

			if( patientFormSearch.getConfidentialSetBy().toCharArray().length!=0 && patientFormSearch.getConfidentialSetBy() !=null){ c31=" or  conf_set_by= '"+patientFormSearch.getConfidentialSetBy()+"'"; } else{ c31=""; }

			if( patientFormSearch.getConfidentialDate().toCharArray().length!=0 && patientFormSearch.getConfidentialDate() !=null){ c32=" or  conf_date= '"+patientFormSearch.getConfidentialDate()+"'"; } else{ c32=""; }

			if( patientFormSearch.getTreatmentDate().toCharArray().length!=0 && patientFormSearch.getTreatmentDate() !=null){ c33=" or  treatment_date= '"+patientFormSearch.getTreatmentDate()+"'"; } else{ c33=""; }

			if( patientFormSearch.getOnsetDate().toCharArray().length!=0 && patientFormSearch.getOnsetDate() !=null){ c34=" or  onset_date= '"+patientFormSearch.getOnsetDate()+"'"; } else{ c34=""; }

			if( patientFormSearch.getDischargeDate().toCharArray().length!=0 && patientFormSearch.getDischargeDate() !=null){ c35=" or  discharge_date= '"+patientFormSearch.getDischargeDate()+"'"; } else{ c35=""; }

			if( patientFormSearch.getFacilityName().toCharArray().length!=0 && patientFormSearch.getFacilityName() !=null){ c36=" or  facility_name= '"+patientFormSearch.getFacilityName()+"'"; } else{ c36=""; }

			if( patientFormSearch.getEmailConsent().toCharArray().length!=0 && patientFormSearch.getEmailConsent() !=null){ c37=" or  email_consent= '"+patientFormSearch.getEmailConsent()+"'"; } else{ c37=""; }

			if( patientFormSearch.getBodyPart().toCharArray().length!=0 && patientFormSearch.getBodyPart() !=null){ c38=" or  body_part= '"+patientFormSearch.getBodyPart()+"'"; } else{ c38=""; }

			if( patientFormSearch.getAdditionalInformationNotes().toCharArray().length!=0 && patientFormSearch.getAdditionalInformationNotes() !=null){ c39=" or  free_text_additional_info= '"+patientFormSearch.getAdditionalInformationNotes()+"'"; } else{ c39=""; }
			String check7=")";
			String check = ""+check1+c30+
					c31+c32+c33+c34+c35+c36+c37+c38+c39+check7+"";



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
