package vaannila.getset;

import vaannila.helper.PasswordHelper;

public class Login {

	private String name;
	private String username;
	private String password;
	private String primaryPrivilege;

	public String getPrimaryPrivilege() {
//		System.out.println("getPrimaryPrivilege: "+primaryPrivilege);
		return primaryPrivilege;
	}
	public void setPrimaryPrivilege(String primaryPrivilege) {
//		System.out.println("setPrimaryPrivilege: "+primaryPrivilege);
		this.primaryPrivilege = primaryPrivilege;
	}
	public String getName(){
//		System.out.println("getName: "+name);
		return name;
	}
	public void setName(String name){
//		System.out.println("setName: "+name);
		this.name=name;
	}
	public String getUsername() {
//		System.out.println("getUsername: "+username);
		return username;
	}

	public void setUsername(String username) {
//		System.out.println("setUsername: "+username);
		this.username = username;
	}

	public String getPassword() {
//		System.out.println("setPassword: "+password);
		return password;
	}

	public void setPassword(String password) throws Exception{
//		System.out.println("setPassword: "+password);
		System.out.println(": "+password);
		this.password=PasswordHelper.byteArrayToHexString
				(PasswordHelper.computeHash(password));
			
	}
}
