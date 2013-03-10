package vaannila.getset;

import vaannila.helper.PasswordHelper;

public class Employee {


	
	private String lastName;	
	private String firstName;
	private String age;	
	private String gender;	
	private String maritalStatus;	
	private String DOB;	
	private String race;	
	private String ethnicity;	
	private String language;	
	private String picture;	
	private String homePhone;	
	private String cellPhone;	
	private String email;	
	private String residentialStreet;	
	private String residentialCity;	
	private String residentialState;	
	private String residentialZipcode;	
	private String mailStreet;	
	private String mailCity;	
	private String mailState;	
	private String mailZipcode;
	private String SSN;
	private String username;
	private String password;
	private String primaryRole;
	private String PTID1;
	private String PTID2;
	private String PTID3;
	private String PTID4;
	private String PTID5;
	private int employeeID;
	private boolean hrPrivilege;
	private boolean biPrivilege;
	private boolean ptPrivilege;
	private boolean foPrivilege;
	private boolean active;
	private boolean blocked;


	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	
	public boolean isHrPrivilege() {
		return hrPrivilege;
	}

	public void setHrPrivilege(boolean hrPrivilege) {
		this.hrPrivilege = hrPrivilege;
	}

	public boolean isBiPrivilege() {
		return biPrivilege;
	}

	public void setBiPrivilege(boolean biPrivilege) {
		this.biPrivilege = biPrivilege;
	}

	public boolean isPtPrivilege() {
		return ptPrivilege;
	}

	public void setPtPrivilege(boolean ptPrivilege) {
		this.ptPrivilege = ptPrivilege;
	}

	public boolean isFoPrivilege() {
		return foPrivilege;
	}

	public void setFoPrivilege(boolean foPrivilege) {
		this.foPrivilege = foPrivilege;
	}

	

	public String getPrimaryRole() {
		return primaryRole;
	}

	public void setPrimaryRole(String primaryRole) {
		this.primaryRole = primaryRole;
	}

	public String getPTID1() {
		return PTID1;
	}

	public void setPTID1(String pTID1) {
		PTID1 = pTID1;
	}

	public String getPTID2() {
		return PTID2;
	}

	public void setPTID2(String pTID2) {
		PTID2 = pTID2;
	}

	public String getPTID3() {
		return PTID3;
	}

	public void setPTID3(String pTID3) {
		PTID3 = pTID3;
	}

	public String getPTID4() {
		return PTID4;
	}

	public void setPTID4(String pTID4) {
		PTID4 = pTID4;
	}

	public String getPTID5() {
		return PTID5;
	}

	public void setPTID5(String pTID5) {
		PTID5 = pTID5;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResidentialStreet() {
		return residentialStreet;
	}

	public void setResidentialStreet(String residentialStreet) {
		this.residentialStreet = residentialStreet;
	}

	public String getResidentialCity() {
		return residentialCity;
	}

	public void setResidentialCity(String residentialCity) {
		this.residentialCity = residentialCity;
	}

	public String getResidentialState() {
		return residentialState;
	}

	public void setResidentialState(String residentialState) {
		this.residentialState = residentialState;
	}

	public String getResidentialZipcode() {
		return residentialZipcode;
	}

	public void setResidentialZipcode(String residentialZipcode) {
		this.residentialZipcode = residentialZipcode;
	}

	public String getMailStreet() {
		return mailStreet;
	}

	public void setMailStreet(String mailStreet) {
		this.mailStreet = mailStreet;
	}

	public String getMailCity() {
		return mailCity;
	}

	public void setMailCity(String mailCity) {
		this.mailCity = mailCity;
	}

	public String getMailState() {
		return mailState;
	}

	public void setMailState(String mailState) {
		this.mailState = mailState;
	}

	public String getMailZipcode() {
		return mailZipcode;
	}

	public void setMailZipcode(String mailZipcode) {
		this.mailZipcode = mailZipcode;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws Exception{
//		System.out.println("setPassword: "+password);
		System.out.println(": "+password);
		this.password=PasswordHelper.byteArrayToHexString
				(PasswordHelper.computeHash(password));
			
	}
	
}
