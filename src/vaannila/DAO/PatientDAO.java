package vaannila.DAO;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import vaannila.getset.Patient;

public class PatientDAO {

	public static String validatePatientLogin(Patient patientLoginBean){
		System.out.println("In patientlogindao");
		String SSN=patientLoginBean.getSSN();
		String DOB=patientLoginBean.getDOB();
		System.out.println("SSN: "+SSN+"\nDOB "+DOB);

		try{
			Connection conn = null;
			String url = "jdbc:mysql://127.0.0.1:3306/";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String pass = "tachsec";
			System.out.println("post db initialize in patient");
			/*using pass as database name just for time being.
			 * 
			 */
			try {
				Class.forName(driver).newInstance();
				conn = (Connection) DriverManager.getConnection(url + "tach", userName, pass);
				System.out.println("after connection");
			} catch (Exception e) {
				System.out.println("exception " + e);
			}
			
			String sql = "select * from patient p where p.ssn = ? and p.dob=?";
			System.out.println(sql);
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1,SSN);
			System.out.println(patientLoginBean.getSSN());
			System.out.println(patientLoginBean.getDOB());
			ps.setString(2,DOB);
			ResultSetImpl rs = (ResultSetImpl) ps.executeQuery();
			if (rs.next()) {
				System.out.println("success");
				return "patient_login";
			}
			else
				System.out.println("error");
			return "login_error";
		}catch(Exception e){
			System.out.println("catch error");

			e.printStackTrace();
			return "login_error";
		}
	}
}
