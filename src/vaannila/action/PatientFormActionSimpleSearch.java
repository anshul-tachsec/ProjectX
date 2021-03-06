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


public class PatientFormActionSimpleSearch extends ActionSupport implements SessionAware{

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
			String check2;
			String check3;
			String check4;
			String check5;
			String check6;
					
			if(patientFormSearch.getLastName().toCharArray().length!=0 ){
				 check2=" or last_name = '"+patientFormSearch.getLastName()+"'";
				 System.out.println("last"+patientFormSearch.getLastName());
			}
			else{
				check2="";
			}
			if(patientFormSearch.getFirstName().toCharArray().length!=0 ){
				 check3=" or first_name = '"+patientFormSearch.getFirstName()+"'";
				 System.out.println("first"+patientFormSearch.getFirstName());
			}
			else{
				check3="";
			}
			
			if(patientFormSearch.getPatientDOB()!=null ){
				 check4=" or DOB = '"+patientFormSearch.getPatientDOB()+"'";
				 System.out.println("dob"+patientFormSearch.getPatientDOB());
			}
			else{
				 check4="";
			}
			if(patientFormSearch.getCellPhone().toCharArray().length!=0 ){
				check5=" or cell_ph = '"+patientFormSearch.getCellPhone()+"'";
				 System.out.println("cell"+patientFormSearch.getCellPhone());
			}
			else{
				check5="";
			}
			if(patientFormSearch.getPatientEmail()!=null ){
				 check6=" or email = '"+patientFormSearch.getPatientEmail()+"'";
				 System.out.println("email"+patientFormSearch.getPatientEmail());
			}
			else{
				 check6="";
			}
			String check7=")";
			String check = ""+check1+check2+check3+check4+check5+check6+check7+"";
		
			

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

		return "patient_form_simple_search";
	}

	public PatientFormSearch getPatientFormSearch() {
		return patientFormSearch;
	}

	public void setPatientFormSearch(PatientFormSearch patientFormSearch) {
		this.patientFormSearch = patientFormSearch;
	}
}
