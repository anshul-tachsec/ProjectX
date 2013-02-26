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



<title>Biller Home Page</title>

<link href="css/smoothness/jquery-ui-1.10.0.custom.css" rel="stylesheet">
<script src="js/jquery-1.9.0.js"></script>
<script src="js/jquery-ui-1.10.0.custom.js"></script>
<script>
	$(function() {

		$("#frontofficeMode").button();
		$("#billerMode").button();
		$("#PTMode").button();

		$("#logout").button();
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

				<s:form action="PatientFormActionDemographicsTab" method="post">
					<!-- 				main table -->
					<table cellspacing="0" cellpadding="5">
						<tr>
							<td width="50%">
								<table width="100%" border="0" cellspacing="0" cellpadding="1">
									<tr>
										<td width="25%">Last Name</td>
										<td><input type="text" name="patientFormBean.lastName"
											tabindex="1" size="25"></td>
									</tr>
									<tr>
										<td width="25%">First Name</td>
										<td><input type="text" name="patientFormBean.firstName"
											tabindex="1" size="25"></td>
									</tr>
									<tr>
										<td width="25%">Age</td>
										<td><input type="text" name="patientFormBean.age"
											tabindex="2" size="25"></td>
									</tr>
									<!-- 				radio -->
									<tr>
										<td width="25%">Gender</td>
										<td><input type="text" name="patientFormBean.gender"
											tabindex="2" size="25"></td>
									</tr>

									<tr>
										<td width="25%">Marital Status</td>
										<td><input type="text"
											name="patientFormBean.maritalStatus" tabindex="2" size="25"></td>
									</tr>
									<tr>
										<td width="25%">D.O.B.</td>
										<td><input type="text" name="patientFormBean.patientDOB"
											tabindex="2" size="25"></td>
									</tr>
									<tr>
										<td width="25%">Race</td>
										<td><input type="text" name="patientFormBean.PatientRace"
											tabindex="2" size="25"></td>
									</tr>
									<tr>
										<td width="25%">Ethnicity</td>
										<td><input type="text"
											name="patientFormBean.patientEthinicity" tabindex="2"
											size="25"></td>
									</tr>
									<tr>
										<td width="25%">Language</td>
										<td><input type="text"
											name="patientFormBean.patientLanguage" tabindex="2" size="25"></td>
									</tr>
									<tr>
										<td width="25%">SSN</td>
										<td><input type="text" name="patientFormBean.patientSSN"
											tabindex="2" size="25"></td>
									</tr>
									<tr>
										<td width="25%">PT Licence Number</td>
										<td><input type="text" name="patientFormBean.PTLicenceNumber"
											tabindex="2" size="25"></td>
									</tr>
									<tr>
										<td width="25%">Picture</td>
										<td><input type="text" name="patientFormBean.employeePicture"
											tabindex="2" size="25"></td>
									</tr>
								</table>
							<td width="50%">
								<!-- Table on right side -->
								<table width="100%" border="0" cellspacing="0" cellpadding="1"
									align="right">

									<tr>
										<td width="25%">Residential Street</td>
										<td><input type="text"
											name="patientFormBean.residentialStreet" tabindex="2"
											size="25"></td>
									</tr>
									<tr>
										<td width="25%">Residential City</td>
										<td><input type="text"
											name="patientFormBean.residentialCity" tabindex="2" size="25"></td>
									</tr>
									<tr>
										<td width="25%">Residential State</td>
										<td><input type="text"
											name="patientFormBean.residentialState" tabindex="2"
											size="25"></td>
									</tr>
									<tr>
										<td width="25%">Residential Zipcode</td>
										<td><input type="text"
											name="patientFormBean.residentialZipcode" tabindex="2"
											size="25"></td>
									</tr>
									<tr>
										<td width="25%">Mail Street</td>
										<td><input type="text" name="patientFormBean.mailStreet"
											tabindex="2" size="25"></td>
									</tr>
									<tr>
										<td width="25%">Mail City</td>
										<td><input type="text" name="patientFormBean.mailCity"
											tabindex="2" size="25"></td>
									</tr>
									<tr>
										<td width="25%">Mail State</td>
										<td><input type="text" name="patientFormBean.mailState"
											tabindex="2" size="25"></td>
									</tr>
									<tr>
										<td width="25%">Mail Zipcode</td>
										<td><input type="text" name="patientFormBean.mailZipcode"
											tabindex="2" size="25"></td>
									</tr>

									<tr>
										<td width="25%">Home Phone</td>
										<td><input type="text" name="patientFormBean.homePhone"
											tabindex="2" size="25"></td>
									</tr>
									<tr>
										<td width="25%">Cell Phone</td>
										<td><input type="text" name="patientFormBean.cellPhone"
											tabindex="2" size="25"></td>
									</tr>
									<tr>
										<td width="25%">Email</td>
										<td><input type="text"
											name="patientFormBean.patientEmail" tabindex="2" size="25"></td>
									</tr>
									<tr><td>Type of Employee</td></tr>
									<tr>
										<td width="45%"><input type="checkbox" id="check1" /> <label
											for="check1" >Front-Office</label></td>
									</tr>
									<tr>
										<td><input type="checkbox" id="check2" /> <label
											for="check2">PT</label></td>
									</tr>
									<tr>
										<td><input type="checkbox" id="check3" /> <label
											for="check3">Biller</label></td>
									</tr>
									<tr>
										<td><input type="checkbox" id="check3" /> <label
											for="check3" size="45">Contractual PT</label></td>
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
		<div id="revokeEmployeeAccess"></div>
		<div id="checkEmployeeAccount"></div>
		<div id="faxIn"></div>
		<div id="faxOut"></div>
	</div>
</body>
</html>
