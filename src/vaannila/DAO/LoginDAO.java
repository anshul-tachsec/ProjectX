
package vaannila.DAO;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;

import vaannila.getset.Login;

public class LoginDAO {

	public static void validateLogin(Login loginBean,String domain){
		System.out.println("In logindao");
		String username=loginBean.getUsername();
		String password=loginBean.getPassword();
				System.out.println("username: "+username+"\npassword: "+password);

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
				conn = (Connection) DriverManager.getConnection(url + domain, userName, pass);
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
		}
	}
}
