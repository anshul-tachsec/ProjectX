package vaannila.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import vaannila.getset.EmployeeFormSearch;

import com.opensymphony.xwork2.ActionSupport;


public class EmployeeFormActionSimpleSearch extends ActionSupport implements SessionAware{

	@SuppressWarnings("rawtypes")
	Map m;  

	public void setSession(@SuppressWarnings("rawtypes") Map m)
	{
		this.m=m;
	}
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	ArrayList<EmployeeFormSearch> al=new ArrayList();
	public EmployeeFormSearch employeeFormSearch;

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
		System.out.println("get username " +employeeFormSearch.getUsername());

		try{
			stmt = conn.createStatement();
	

			String check1="SELECT * FROM patient_form WHERE (username = "+employeeFormSearch.getUsername()+"";
			String check2;
			String check3;
			String check4;
			String check5;
			String check6;
					
			if(employeeFormSearch.getLastName().toCharArray().length!=0 ){
				 check2=" or last_name = '"+employeeFormSearch.getLastName()+"'";
				 System.out.println("last"+employeeFormSearch.getLastName());
			}
			else{
				check2="";
			}
			if(employeeFormSearch.getFirstName().toCharArray().length!=0 ){
				 check3=" or first_name = '"+employeeFormSearch.getFirstName()+"'";
				 System.out.println("first"+employeeFormSearch.getFirstName());
			}
			else{
				check3="";
			}
			
			if(employeeFormSearch.getPrimaryRole()!=null ){
				 check4=" or DOB = '"+employeeFormSearch.getPrimaryRole()+"'";
				 System.out.println("dob"+employeeFormSearch.getPrimaryRole());
			}
			else{
				 check4="";
			}
			if(employeeFormSearch.getCellPhone().toCharArray().length!=0 ){
				check5=" or cell_ph = '"+employeeFormSearch.getCellPhone()+"'";
				 System.out.println("cell"+employeeFormSearch.getCellPhone());
			}
			else{
				check5="";
			}
			if(employeeFormSearch.getEmail()!=null ){
				 check6=" or email = '"+employeeFormSearch.getEmail()+"'";
				 System.out.println("email"+employeeFormSearch.getEmail());
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
					employeeFormSearch= new EmployeeFormSearch();
					employeeFormSearch.setUsername(rs.getString("username"));
					employeeFormSearch.setLastName(rs.getString("last_name"));
					employeeFormSearch.setFirstName(rs.getString("first_name"));
					employeeFormSearch.setDOB(rs.getString("DOB"));
					employeeFormSearch.setCellPhone(rs.getString("cell_ph"));
					employeeFormSearch.setPrimaryRole(rs.getString("primary_privilege"));
					employeeFormSearch.setEmail(rs.getString("email"));
					al.add(employeeFormSearch);
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

		return "employee_form_simple_search";
	}

	public EmployeeFormSearch getEmployeeFormSearch() {
		return employeeFormSearch;
	}

	public void setEmployeeFormSearch(EmployeeFormSearch employeeFormSearch) {
		this.employeeFormSearch = employeeFormSearch;
	}
}
