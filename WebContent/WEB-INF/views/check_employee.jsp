<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<!-- <!doctype html> -->
<html lang="us">
<head>
<%@taglib uri="/struts-tags" prefix="s"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<title>Employee Details</title>

<link href="css/smoothness/jquery-ui-1.10.0.custom.css" rel="stylesheet">
<script src="js/jquery-1.9.0.js"></script>
<script src="js/jquery-ui-1.10.0.custom.js"></script>
<script>
	$(function() {

		$("#homePage").button();
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
	/* margin: 50px; */
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

	<button id="homePage">Home</button>
	<button id="logout">LogOut</button>
	<div id="tabs">
		<ul>
			<li><a href="#personalDetails"><span>Personal Details</span></a></li>
			<li><a href="#schedule">Schedule</a></li>
		</ul>
		<!-- 		tab for pt schedule -->
		<div id="createNewEmployee">
			<s:form action="EmployeeFormActionUpdate" method="post">
				<!-- 				main table -->
				<table cellspacing="0" cellpadding="5">
					<tr>
						<td width="50%">

							<table width="100%" border="0" cellspacing="0" cellpadding="1">

								<tr>
									<td width="25%">Username</td>
									<td><input type="text" value="${employeeFormBean.username} "
										name="employeeFormBean.username" tabindex="1" size="25"></td>
								</tr>
								
								<tr>
									<td width="25%">Last Name</td>
									<td><input type="text" value="${employeeFormBean.lastName}"
										name="employeeFormBean.lastName" tabindex="1" size="25"></td>
								</tr>
								<tr>
									<td width="25%">First Name</td>
									<td><input type="text" value="${employeeFormBean.firstName}"
										name="employeeFormBean.firstName" tabindex="1" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Employee ID</td>
									<td><input type="text" value="${employeeFormBean.employeeID}"
										name="employeeFormBean.employeeID" tabindex="1" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Age</td>
									<td><input type="text" value="${employeeFormBean.age}"
										name="employeeFormBean.age" tabindex="2" size="25"></td>
								</tr>
								<!-- 				checkbox -->
								<tr>
									<td width="25%">Gender</td>
									<td><input type="text" value="${employeeFormBean.gender}"
										name="employeeFormBean.gender" tabindex="2" size="25"></td>
								</tr>

								<tr>
									<td width="25%">Marital Status</td>
									<td><input type="text" value="${employeeFormBean.maritalStatus}"
										name="employeeFormBean.maritalStatus" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">D.O.B.</td>
									<td><input type="text" value="${employeeFormBean.DOB}"
										name="employeeFormBean.DOB" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Race</td>
									<td><input type="text" value="${employeeFormBean.race}"
										name="employeeFormBean.race" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Ethnicity</td>
									<td><input type="text" value="${employeeFormBean.ethnicity}"
										name="employeeFormBean.ethnicity" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Language</td>
									<td><input type="text" value="${employeeFormBean.language}"
										name="employeeFormBean.language" tabindex="2" size="25"></td>
								</tr>

								<tr>
									<td width="25%">Picture</td>
									<td><input type="text" value="${employeeFormBean.picture}"
										name="employeeFormBean.picture" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Home Phone</td>
									<td><input type="text" value="${employeeFormBean.homePhone}"
										name="employeeFormBean.homePhone" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Cell Phone</td>
									<td width="100%"><input type="text" value="${employeeFormBean.cellPhone}"
										name="employeeFormBean.cellPhone" tabindex="2" size="25"></td>
								</tr>

							</table>
						<td width="50%">
							<!-- Table on right side -->
							<table width="100%" border="0" cellspacing="0" cellpadding="1"
								align="right">
								<tr>
									<td width="25%">Email</td>
									<td><input type="text" value="${employeeFormBean.email}"
										name="employeeFormBean.email" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Residential Street</td>
									<td><input type="text" value="${employeeFormBean.residentialStreet}"
										name="employeeFormBean.residentialStreet" tabindex="2"
										size="25"></td>
								</tr>
								<tr>
									<td width="25%">Residential City</td>
									<td><input type="text" value="${employeeFormBean.residentialCity}"
										name="employeeFormBean.residentialCity" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Residential State</td>
									<td><input type="text" value="${employeeFormBean.residentialState}"
										name="employeeFormBean.residentialState" tabindex="2"
										size="25"></td>
								</tr>
								<tr>
									<td width="25%">Residential Zipcode</td>
									<td><input type="text" value="${employeeFormBean.residentialZipcode}"
										name="employeeFormBean.residentialZipcode" tabindex="2"
										size="25"></td>
								</tr>
								<tr>
									<td width="25%">Mail Street</td>
									<td><input type="text" value="${employeeFormBean.mailStreet}"
										name="employeeFormBean.mailStreet" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Mail City</td>
									<td><input type="text" value="${employeeFormBean.mailCity}"
										name="employeeFormBean.mailCity" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Mail State</td>
									<td><input type="text" value="${employeeFormBean.mailState}"
										name="employeeFormBean.mailState" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">Mail Zipcode</td>
									<td><input type="text" value="${employeeFormBean.mailZipcode}"
										name="employeeFormBean.mailZipcode" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">SSN</td>
									<td><input type="text" value="${employeeFormBean.SSN}"
										name="employeeFormBean.SSN" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">ID 1</td>
									<td><input type="text" value="${employeeFormBean.PTID1}"
										name="employeeFormBean.PTID1" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">ID 2</td>
									<td><input type="text" value="${employeeFormBean.PTID2}"
										name="employeeFormBean.PTID2" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">ID 3</td>
									<td><input type="text" value="${employeeFormBean.PTID3}"
										name="employeeFormBean.PTID3" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="25%">ID 4</td>
									<td><input type="text" value="${employeeFormBean.PTID4}"
										name="employeeFormBean.PTID4" tabindex="2" size="25"></td>
								</tr>
								<tr>
									<td width="100%">ID 5</td>
									<td><input type="text" value="${employeeFormBean.PTID5}"
										name="employeeFormBean.PTID5" tabindex="2" size="25"></td>
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
		<div id="schedule"></div>
	</div>
</body>
</html>
