<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<!-- <!doctype html> -->
<html lang="us">
<head>
<%@taglib uri="/struts-tags" prefix="s"%>

<!-- <meta http-equiv="cache-control" content="no-cache"> -->
<!-- <!-- tells browser not to cache -->
<!-- <meta http-equiv="expires" content="0"> -->
<!-- <!-- says that the cache expires 'now' -->
<!-- <meta http-equiv="pragma" content="no-cache"> -->
<!-- <!-- says not to use cached stuff, if there is any -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <s:iterator value="searchArray" var="i"> --%>
<!-- 	<tr> -->
<%-- 		<td>${i.PatientFormBean.PatientID}</td> --%>
<%-- 		<td>${searchArray.getPatientFormBean().getPatientID()}</td> --%>
<%-- 		<td>${i.getPatientFormBean().getPatientID()}</td> --%>
<%-- 		<td>${i.patientDOB}</td> --%>
<%-- 		<td>${i.patientEmail}</td> --%>
<%-- 		<td>${i.cellPhone}</td> --%>
<!-- 	</tr> -->
<%-- </s:iterator> --%>



<title>User Admin Page</title>

<link href="css/smoothness/jquery-ui-1.10.0.custom.css" rel="stylesheet">
<script src="js/jquery-1.9.0.js"></script>
<script src="js/jquery-ui-1.10.0.custom.js"></script>
<script>
	$(function() {

		$("#frontofficeMode").button();
		$("#billerMode").button();
		$("#PTMode").button();
		$("#roleRadioButton").buttonset();
		$("#logout").button();
		$("#format").buttonset();
		var tabs = $("#tabs, #subtabs").tabs();
		tabs.find(".ui-tabs-nav").sortable({
			axis : "x",
			stop : function() {
				tabs.tabs("refresh");
			}
		});
	});
</script>
<style>
body {
	font: 62.5% "Trebuchet MS", sans-serif;
	margin: 50px;
}

.demoHeaders {
	margin-top: 2em;
}

#dialog-link {
	padding: .4em 1em .4em 20px;
	text-decoration: none;
	position: relative;
}

#dialog-link span.ui-icon {
	margin: 0 5px 0 0;
	position: absolute;
	left: .2em;
	top: 50%;
	margin-top: -8px;
}

#icons {
	margin: 0;
	padding: 0;
}

#icons li {
	margin: 2px;
	position: relative;
	padding: 4px 0;
	cursor: pointer;
	float: left;
	list-style: none;
}

#icons span.ui-icon {
	float: right;
	margin: 0 4px;
}

.fakewindowcontain .ui-widget-overlay {
	position: absolute;
}
</style>
</head>
<body>

	<button id="frontofficeMode">Front-Office Mode</button>
	<button id="billerMode">Biller Mode</button>
	<button id="PTMode">PT Mode</button>
	<button id="logout">LogOut</button>
	<div id="tabs">
		<ul>
			<li><a href="#createNewEmployee"><span>Create New
						Employee</span></a></li>
			<li><a href="#revokeEmployeeAccess">Revoke Employee Access</a></li>
			<li><a href="#checkEmployeeAccount">Check Employee Account</a></li>
			<li><a href="#faxIn">Fax-In</a></li>
			<li><a href="#faxOut">Fax-Out</a></li>

		</ul>
		<!-- 		tab for pt schedule -->
		<div id="createNewEmployee">
			<div id="subtabs">
				<ul>
					<li><a href="#PT" class=""> Physical Therapist</a></li>
					<li><a href="#Frontoffice">Front Office</a></li>
					<li><a href="#Biller">Biller</a></li>
					<li><a href="#Admin">Admin</a></li>


				</ul>
				<div id="PT">

					<s:form action="EmployeeFormAction" method="post">
						<!-- 				main table -->
						<table cellspacing="0" cellpadding="5">
							<tr>
								<td width="50%">

									<table width="100%" border="0" cellspacing="0" cellpadding="1">

										<tr>
											<td width="25%">Username</td>
											<td><input type="text" name="employeeFormBean.username"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Password</td>
											<td><input type="text" name="employeeFormBean.password"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Last Name</td>
											<td><input type="text" name="employeeFormBean.lastName"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">First Name</td>
											<td><input type="text" name="employeeFormBean.firstName"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Employee ID</td>
											<td><input type="text"
												name="employeeFormBean.employeeID" tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Age</td>
											<td><input type="text" name="employeeFormBean.age"
												tabindex="2" size="25"></td>
										</tr>
										<!-- 				radio -->
										<tr>
											<td width="25%">Gender</td>
											<td><input type="text" name="employeeFormBean.gender"
												tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td width="25%">Marital Status</td>
											<td><input type="text"
												name="employeeFormBean.maritalStatus" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">D.O.B.</td>
											<td><input type="text" name="employeeFormBean.DOB"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Race</td>
											<td><input type="text" name="employeeFormBean.race"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Ethnicity</td>
											<td><input type="text" name="employeeFormBean.ethnicity"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Language</td>
											<td><input type="text" name="employeeFormBean.language"
												tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td width="25%">Picture</td>
											<td><input type="text" name="employeeFormBean.picture"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Home Phone</td>
											<td><input type="text" name="employeeFormBean.homePhone"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Cell Phone</td>
											<td width="100%"><input type="text"
												name="employeeFormBean.cellPhone" tabindex="2" size="25"></td>
										</tr>

									</table>
								<td width="50%">
									<!-- Table on right side -->
									<table width="100%" border="0" cellspacing="0" cellpadding="1"
										align="right">
										<tr>
											<td width="25%">Email</td>
											<td><input type="text" name="employeeFormBean.email"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential Street</td>
											<td><input type="text"
												name="employeeFormBean.residentialStreet" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential City</td>
											<td><input type="text"
												name="employeeFormBean.residentialCity" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential State</td>
											<td><input type="text"
												name="employeeFormBean.residentialState" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential Zipcode</td>
											<td><input type="text"
												name="employeeFormBean.residentialZipcode" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail Street</td>
											<td><input type="text"
												name="employeeFormBean.mailStreet" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail City</td>
											<td><input type="text" name="employeeFormBean.mailCity"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail State</td>
											<td><input type="text" name="employeeFormBean.mailState"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail Zipcode</td>
											<td><input type="text"
												name="employeeFormBean.mailZipcode" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">SSN</td>
											<td><input type="text" name="employeeFormBean.SSN"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">ID 1</td>
											<td><input type="text" name="employeeFormBean.PTID1"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">ID 2</td>
											<td><input type="text" name="employeeFormBean.PTID2"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">ID 3</td>
											<td><input type="text" name="employeeFormBean.PTID3"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">ID 4</td>
											<td><input type="text" name="employeeFormBean.PTID4"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="100%">ID 5</td>
											<td><input type="text" name="employeeFormBean.PTID5"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td><input value="pt" style="display: none"
												name="employeeFormBean.primaryRole"></input></td>
										</tr>
										<tr>
											<td>Optional Privileges</td>
										</tr>
										<tr>
											<s:checkbox name="employeeFormBean.hrPrivilege" label="Admin">
											</s:checkbox>
										</tr>
										<tr>
											<s:checkbox name="employeeFormBean.biPrivilege"
												label="Biller">
											</s:checkbox>
										</tr>
										<tr>
											<s:checkbox name="employeeFormBean.foPrivilege"
												label="Front- office">
											</s:checkbox>
										</tr>
									</table>
								</td>


							</tr>
							<tr>
								<s:submit value="Save" />
							</tr>
						</table>
					</s:form>
				</div>
				<div id="Frontoffice">
					<s:form action="EmployeeFormAction" method="post">
						<!-- 				main table -->
						<table cellspacing="0" cellpadding="5">
							<tr>
								<td width="50%">

									<table width="100%" border="0" cellspacing="0" cellpadding="1">

										<tr>
											<td width="100%">Username</td>
											<td><input type="text" name="employeeFormBean.username"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Password</td>
											<td><input type="text" name="employeeFormBean.password"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Last Name</td>
											<td><input type="text" name="employeeFormBean.lastName"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">First Name</td>
											<td><input type="text" name="employeeFormBean.firstName"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Employee ID</td>
											<td><input type="text"
												name="employeeFormBean.employeeID" tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Age</td>
											<td><input type="text" name="employeeFormBean.age"
												tabindex="2" size="25"></td>
										</tr>
										<!-- 				radio -->
										<tr>
											<td width="25%">Gender</td>
											<td><input type="text" name="employeeFormBean.gender"
												tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td width="25%">Marital Status</td>
											<td><input type="text"
												name="employeeFormBean.maritalStatus" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">D.O.B.</td>
											<td><input type="text" name="employeeFormBean.DOB"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Race</td>
											<td><input type="text" name="employeeFormBean.race"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Ethnicity</td>
											<td><input type="text" name="employeeFormBean.ethnicity"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Language</td>
											<td><input type="text" name="employeeFormBean.language"
												tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td width="25%">Picture</td>
											<td><input type="text" name="employeeFormBean.picture"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Home Phone</td>
											<td><input type="text" name="employeeFormBean.homePhone"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Cell Phone</td>
											<td><input type="text" name="employeeFormBean.cellPhone"
												tabindex="2" size="25"></td>
										</tr>

									</table>
								<td width="50%">
									<!-- Table on right side -->
									<table width="100%" border="0" cellspacing="0" cellpadding="1"
										align="right">
										<tr>
											<td width="25%">Email</td>
											<td><input type="text" name="employeeFormBean.email"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential Street</td>
											<td><input type="text"
												name="employeeFormBean.residentialStreet" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential City</td>
											<td><input type="text"
												name="employeeFormBean.residentialCity" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential State</td>
											<td><input type="text"
												name="employeeFormBean.residentialState" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential Zipcode</td>
											<td><input type="text"
												name="employeeFormBean.residentialZipcode" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail Street</td>
											<td><input type="text"
												name="employeeFormBean.mailStreet" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail City</td>
											<td><input type="text" name="employeeFormBean.mailCity"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail State</td>
											<td><input type="text" name="employeeFormBean.mailState"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail Zipcode</td>
											<td><input type="text"
												name="employeeFormBean.mailZipcode" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="100%">SSN</td>
											<td><input type="text" name="employeeFormBean.SSN"
												tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td><input value="fo" style="display: none"
												name="employeeFormBean.primaryRole"></input></td>
										</tr>
										<tr>
											<td>Optional Privileges</td>
										</tr>
										<tr>
											<s:checkbox name="employeeFormBean.ptPrivilege" label="PT">
											</s:checkbox>
										</tr>
										<tr>
											<s:checkbox name="employeeFormBean.biPrivilege"
												label="Biller">
											</s:checkbox>
										</tr>
										<tr>
											<s:checkbox name="employeeFormBean.hrPrivilege" label="Admin">
											</s:checkbox>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<s:submit value="Save" />
							</tr>
						</table>
					</s:form>
				</div>
				<div id="Biller">
					<s:form action="EmployeeFormAction" method="post">
						<!-- 				main table -->
						<table cellspacing="0" cellpadding="5">
							<tr>
								<td width="50%">

									<table width="100%" border="0" cellspacing="0" cellpadding="1">

										<tr>
											<td width="100%">Username</td>
											<td><input type="text" name="employeeFormBean.username"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Password</td>
											<td><input type="text" name="employeeFormBean.password"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Last Name</td>
											<td><input type="text" name="employeeFormBean.lastName"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">First Name</td>
											<td><input type="text" name="employeeFormBean.firstName"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Employee ID</td>
											<td><input type="text"
												name="employeeFormBean.employeeID" tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Age</td>
											<td><input type="text" name="employeeFormBean.age"
												tabindex="2" size="25"></td>
										</tr>
										<!-- 				radio -->
										<tr>
											<td width="25%">Gender</td>
											<td><input type="text" name="employeeFormBean.gender"
												tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td width="25%">Marital Status</td>
											<td><input type="text"
												name="employeeFormBean.maritalStatus" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">D.O.B.</td>
											<td><input type="text" name="employeeFormBean.DOB"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Race</td>
											<td><input type="text" name="employeeFormBean.race"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Ethnicity</td>
											<td><input type="text" name="employeeFormBean.ethnicity"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Language</td>
											<td><input type="text" name="employeeFormBean.language"
												tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td width="25%">Picture</td>
											<td><input type="text" name="employeeFormBean.picture"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Home Phone</td>
											<td><input type="text" name="employeeFormBean.homePhone"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Cell Phone</td>
											<td><input type="text" name="employeeFormBean.cellPhone"
												tabindex="2" size="25"></td>
										</tr>

									</table>
								<td width="50%">
									<!-- Table on right side -->
									<table width="100%" border="0" cellspacing="0" cellpadding="1"
										align="right">
										<tr>
											<td width="25%">Email</td>
											<td><input type="text" name="employeeFormBean.email"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential Street</td>
											<td><input type="text"
												name="employeeFormBean.residentialStreet" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential City</td>
											<td><input type="text"
												name="employeeFormBean.residentialCity" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential State</td>
											<td><input type="text"
												name="employeeFormBean.residentialState" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential Zipcode</td>
											<td><input type="text"
												name="employeeFormBean.residentialZipcode" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail Street</td>
											<td><input type="text"
												name="employeeFormBean.mailStreet" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail City</td>
											<td><input type="text" name="employeeFormBean.mailCity"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail State</td>
											<td><input type="text" name="employeeFormBean.mailState"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail Zipcode</td>
											<td><input type="text"
												name="employeeFormBean.mailZipcode" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="100%">SSN</td>
											<td><input type="text" name="employeeFormBean.SSN"
												tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td><input value="bi" style="display: none"
												name="employeeFormBean.primaryRole"></input></td>
										</tr>
										<tr>
											<td>Optional Privileges</td>
										</tr>
										<tr>
											<s:checkbox name="employeeFormBean.ptPrivilege" label="PT">
											</s:checkbox>
										</tr>
										<tr>
											<s:checkbox name="employeeFormBean.hrPrivilege" label="Admin">
											</s:checkbox>
										</tr>
										<tr>
											<s:checkbox name="employeeFormBean.foPrivilege"
												label="Front- office">
											</s:checkbox>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<s:submit value="Save" />
							</tr>
						</table>
					</s:form>
				</div>
				<div id="Admin">
					<s:form action="EmployeeFormAction" method="post">
						<!-- 				main table -->
						<table cellspacing="0" cellpadding="5">
							<tr>
								<td width="50%">

									<table width="100%" border="0" cellspacing="0" cellpadding="1">

										<tr>
											<td width="100%">Username</td>
											<td><input type="text" name="employeeFormBean.username"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Password</td>
											<td><input type="text" name="employeeFormBean.password"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Last Name</td>
											<td><input type="text" name="employeeFormBean.lastName"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">First Name</td>
											<td><input type="text" name="employeeFormBean.firstName"
												tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Employee ID</td>
											<td><input type="text"
												name="employeeFormBean.employeeID" tabindex="1" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Age</td>
											<td><input type="text" name="employeeFormBean.age"
												tabindex="2" size="25"></td>
										</tr>
										<!-- 				radio -->
										<tr>
											<td width="25%">Gender</td>
											<td><input type="text" name="employeeFormBean.gender"
												tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td width="25%">Marital Status</td>
											<td><input type="text"
												name="employeeFormBean.maritalStatus" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">D.O.B.</td>
											<td><input type="text" name="employeeFormBean.DOB"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Race</td>
											<td><input type="text" name="employeeFormBean.race"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Ethnicity</td>
											<td><input type="text" name="employeeFormBean.ethnicity"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Language</td>
											<td><input type="text" name="employeeFormBean.language"
												tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td width="25%">Picture
											<td><input type="text"
												name="em
											ployeeFormBean.picture" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="100%">Home Phone</td>
											<td><input type="text" name="employeeFormBean.homePhone"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Cell Phone</td>
											<td><input type="text" name="employeeFormBean.cellPhone"
												tabindex="2" size="25"></td>
										</tr>

									</table>
								<td width="50%">
									<!-- Table on right side -->
									<table width="100%" border="0" cellspacing="0" cellpadding="1"
										align="right">
										<tr>
											<td width="25%">Email</td>
											<td><input type="text" name="employeeFormBean.email"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential Street</td>
											<td><input type="text"
												name="employeeFormBean.residentialStreet" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential City</td>
											<td><input type="text"
												name="employeeFormBean.residentialCity" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential State</td>
											<td><input type="text"
												name="employeeFormBean.residentialState" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Residential Zipcode</td>
											<td><input type="text"
												name="employeeFormBean.residentialZipcode" tabindex="2"
												size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail Street</td>
											<td><input type="text"
												name="employeeFormBean.mailStreet" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="100%">Mail City</td>
											<td><input type="text" name="employeeFormBean.mailCity"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail State</td>
											<td><input type="text" name="employeeFormBean.mailState"
												tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">Mail Zipcode</td>
											<td><input type="text"
												name="employeeFormBean.mailZipcode" tabindex="2" size="25"></td>
										</tr>
										<tr>
											<td width="25%">SSN</td>
											<td><input type="text" name="employeeFormBean.SSN"
												tabindex="2" size="25"></td>
										</tr>

										<tr>
											<td><input value="hr" style="display: none"
												name="employeeFormBean.primaryRole"></input></td>
										</tr>
										<tr>
											<td>Optional Privileges</td>
										</tr>
										<tr>
											<s:checkbox name="employeeFormBean.ptPrivilege" label="PT">
											</s:checkbox>
										</tr>
										<tr>
											<s:checkbox name="employeeFormBean.biPrivilege"
												label="Biller">
											</s:checkbox>
										</tr>
										<tr>
											<s:checkbox name="employeeFormBean.foPrivilege"
												label="Front- office">
											</s:checkbox>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<s:submit value="Save" />
							</tr>
						</table>
					</s:form>
				</div>


			</div>

		</div>
		<div id="revokeEmployeeAccess">
			<s:form action="EmployeeFormActionSimpleSearch" method="post">
				<!-- 				main table -->
				<table cellspacing="0" cellpadding="5">
					<tr>
						<td width="50%">
							<table width="100%" border="0" cellspacing="0" cellpadding="1">
								<tr>
									<td width="25%">Username</td>
									<td><input type="text" name="employeeFormSearch.username"
										tabindex="1" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Last Name</td>
									<td><input type="text" name="employeeFormSearch.lastName"
										tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">First Name</td>
									<td><input type="text" name="employeeFormSearch.firstName"
										tabindex="2" size="25"></td>
								</tr>


							</table>
						<td width="50%">
							<!-- Table on right side -->
							<table width="100%" border="0" cellspacing="0" cellpadding="1"
								align="right">
								<tr>
									<td width="25%">Cell Phone</td>
									<td><input type="text" name="employeeFormSearch.cellPhone"
										tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Role</td>
									<td><input type="text"
										name="employeeFormSearch.primaryPrivilege" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Email</td>
									<td><input type="text" name="employeeFormSearch.email"
										tabindex="2" size="25"></td>
								</tr>

							</table>
						</td>
					</tr>
					<tr>
						<s:submit value="Search" />
					</tr>
				</table>
			</s:form>

			<table width="100%" border="0" cellspacing="0" cellpadding="1">

				<tr>
					<td width="20%"><b>Username</b></td>
					<td width="20%"><b>Last Name</b></td>
					<td width="20%"><b>First Name</b></td>
					<td width="20%"><b>Cellphone</b></td>
					<td width="20%"><b>Role</b></td>
					<td width="20%"><b>Email</b></td>

					<s:iterator value="al" status="alStatus">
						<tr>
							<td width="20%"><a
								href="<s:url action="EmployeeFormActionSearchHyperlink">
											<s:param name="employeeFormBean.username" value="%{username}" />
										</s:url>">${username}</a></td>
							<td width="20%"><s:property value="%{lastName}" /></td>
							<td width="20%"><s:property value="%{firstName}" /></td>
							<td width="20%"><s:property value="%{cellPhone}" /></td>
							<td width="20%"><s:property value="%{primaryPrivilege}" /></td>
							<td width="20%"><s:property value="%{email}" /></td>
						</tr>
					</s:iterator>
			</table>
		</div>

		<div id="checkEmployeeAccount"></div>
		<div id="faxIn"></div>
		<div id="faxOut"></div>
	</div>
</body>
</html>
