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


public class PatientFormActionAdvancedSearchDemographicsTab extends ActionSupport implements SessionAware{

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
			String cc1,cc2,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
			String c11,c12,c13,c14,c15,c16,c17,c18,c19,c20;
			String c21,c22,c23,c24,c25,c26,c27,c28,c29;

			if(patientFormSearch.getLastName()!=null && patientFormSearch.getLastName().toCharArray().length!=0 ){
				cc1=" or last_name = '"+patientFormSearch.getLastName()+"'";
				System.out.println("last"+patientFormSearch.getLastName());
			}
			else{
				cc1="";
			}
			if(patientFormSearch.getFirstName().toCharArray().length!=0 && patientFormSearch.getFirstName() !=null ){
				cc2=" or first_name = '"+patientFormSearch.getFirstName()+"'";
				System.out.println("first"+patientFormSearch.getFirstName());
			}
			else{
				cc2="";
			}
			if(patientFormSearch.getAge().toCharArray().length!=0 && patientFormSearch.getAge() !=null){
				c1=" or  age= '"+patientFormSearch.getAge()+"'"; }
			else{
				c1=""; 
				}

			if( patientFormSearch.getGender().toCharArray().length!=0 && patientFormSearch.getGender() !=null){
				c2=" or  gender= '"+patientFormSearch.getGender()+"'";
				} 
			else{ 
					c2="";
				}

			if( patientFormSearch.getMaritalStatus().toCharArray().length!=0 && patientFormSearch.getMaritalStatus() !=null){
				
				c3=" or  marital_status= '"+patientFormSearch.getMaritalStatus()+"'"; 
				} 
			else{ 
				c3="";
				}

			if( patientFormSearch.getEmpStatus().toCharArray().length!=0 && patientFormSearch.getEmpStatus() !=null){ c4=" or  emp_status= '"+patientFormSearch.getEmpStatus()+"'"; } else{ c4=""; }

			if( patientFormSearch.getTreatingProvider().toCharArray().length!=0 && patientFormSearch.getTreatingProvider() !=null){ c5=" or  treating_provider= '"+patientFormSearch.getTreatingProvider()+"'"; } else{ c5=""; }

			if( patientFormSearch.getReferringProvider().toCharArray().length!=0 && patientFormSearch.getReferringProvider() !=null){ c6=" or  referring_provider= '"+patientFormSearch.getReferringProvider()+"'"; } else{ c6=""; }

			if( patientFormSearch.getRelationGuarantor().toCharArray().length!=0 && patientFormSearch.getRelationGuarantor() !=null){ c7=" or  relation_guarantor= '"+patientFormSearch.getRelationGuarantor()+"'"; } else{ c7=""; }

			if( patientFormSearch.getPatientDOB().toCharArray().length!=0 && patientFormSearch.getPatientDOB() !=null){ c8=" or  DOB= '"+patientFormSearch.getPatientDOB()+"'"; } else{ c8=""; }

			if( patientFormSearch.getPatientRace().toCharArray().length!=0 && patientFormSearch.getPatientRace() !=null){ c9=" or  race= '"+patientFormSearch.getPatientRace()+"'"; } else{ c9=""; }

			if( patientFormSearch.getPatientEthinicity().toCharArray().length!=0 && patientFormSearch.getPatientEthinicity() !=null){ c10=" or  ethnicity= '"+patientFormSearch.getPatientEthinicity()+"'"; } else{ c10=""; }

			if( patientFormSearch.getPatientLanguage().toCharArray().length!=0 && patientFormSearch.getPatientLanguage() !=null){ c11=" or  language= '"+patientFormSearch.getPatientLanguage()+"'"; } else{ c11=""; }

			if( patientFormSearch.getMothersMaiden().toCharArray().length!=0 && patientFormSearch.getMothersMaiden() !=null){ c12=" or  mothers_maiden= '"+patientFormSearch.getMothersMaiden()+"'"; } else{ c12=""; }

			if( patientFormSearch.getPatientSSN().toCharArray().length!=0 && patientFormSearch.getPatientSSN() !=null){ c13=" or  SSN= '"+patientFormSearch.getPatientSSN()+"'"; } else{ c13=""; }

			if( patientFormSearch.getPatientDOO().toCharArray().length!=0 && patientFormSearch.getPatientDOO() !=null){ c14=" or  DOO= '"+patientFormSearch.getPatientDOO()+"'"; } else{ c14=""; }

			if( patientFormSearch.getResidentialStreet().toCharArray().length!=0 && patientFormSearch.getResidentialStreet() !=null){ c15=" or  res_street= '"+patientFormSearch.getResidentialStreet()+"'"; } else{ c15=""; }

			if( patientFormSearch.getResidentialCity().toCharArray().length!=0 && patientFormSearch.getResidentialCity() !=null){ c16=" or  res_city= '"+patientFormSearch.getResidentialCity()+"'"; } else{ c16=""; }

			if( patientFormSearch.getResidentialState().toCharArray().length!=0 && patientFormSearch.getResidentialState() !=null){ c17=" or  res_state= '"+patientFormSearch.getResidentialState()+"'"; } else{ c17=""; }

			if( patientFormSearch.getResidentialZipcode().toCharArray().length!=0 && patientFormSearch.getResidentialZipcode() !=null){ c18=" or  res_zip= '"+patientFormSearch.getResidentialZipcode()+"'"; } else{ c18=""; }

			if( patientFormSearch.getMailStreet().toCharArray().length!=0 && patientFormSearch.getMailStreet() !=null){ c19=" or  mail_street= '"+patientFormSearch.getMailStreet()+"'"; } else{ c19=""; }

			if( patientFormSearch.getMailCity().toCharArray().length!=0 && patientFormSearch.getMailCity() !=null){ c20=" or  mail_city= '"+patientFormSearch.getMailCity()+"'"; } else{ c20=""; }

			if( patientFormSearch.getMailState().toCharArray().length!=0 && patientFormSearch.getMailState() !=null){ c21=" or  mail_state= '"+patientFormSearch.getMailState()+"'"; } else{ c21=""; }

			if( patientFormSearch.getMailZipcode().toCharArray().length!=0 && patientFormSearch.getMailZipcode() !=null){ c22=" or  mail_zip= '"+patientFormSearch.getMailZipcode()+"'"; } else{ c22=""; }

			if( patientFormSearch.getLastVisitDate().toCharArray().length!=0 && patientFormSearch.getLastVisitDate() !=null){ c23=" or  last_visit= '"+patientFormSearch.getLastVisitDate()+"'"; } else{ c23=""; }

			if( patientFormSearch.getHomePhone().toCharArray().length!=0 && patientFormSearch.getHomePhone() !=null){ c24=" or  home_ph= '"+patientFormSearch.getHomePhone()+"'"; } else{ c24=""; }

			if( patientFormSearch.getWorkPhone().toCharArray().length!=0 && patientFormSearch.getWorkPhone() !=null){ c25=" or  work_ph= '"+patientFormSearch.getWorkPhone()+"'"; } else{ c25=""; }

			if( patientFormSearch.getCellPhone().toCharArray().length!=0 && patientFormSearch.getCellPhone() !=null){ c26=" or  cell_ph= '"+patientFormSearch.getCellPhone()+"'"; } else{ c26=""; }

			if( patientFormSearch.getPatientEmail().toCharArray().length!=0 && patientFormSearch.getPatientEmail() !=null){ c27=" or  email= '"+patientFormSearch.getPatientEmail()+"'"; } else{ c27=""; }

			if( patientFormSearch.getReminderMethod().toCharArray().length!=0 && patientFormSearch.getReminderMethod() !=null){ c28=" or  recall_method= '"+patientFormSearch.getReminderMethod()+"'"; } else{ c28=""; }

			if( patientFormSearch.getDemographicsNotes().toCharArray().length!=0 && patientFormSearch.getDemographicsNotes() !=null){ c29=" or  free_text_main= '"+patientFormSearch.getDemographicsNotes()+"'"; } else{ c29=""; }

			String check7=")";
			String check = ""+check1+cc1+cc2+c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+
					c11+c12+c13+c14+c15+c16+c17+c18+c19+c20+
					c21+c22+c23+c24+c25+c26+c27+c28+c29+check7+"";



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
