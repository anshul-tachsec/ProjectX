<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staff Login Page</title>
</head>
<body>
	<div style="float: right;">
		<h3>Staff Login</h3>
		<s:form action="LoginAction" method="post">
			<s:textfield name="loginBean.username" label="User Name" />
			<s:password name="loginBean.password" label="Password" />
			<s:submit value="Submit" />
		</s:form>
	</div>

	<div style="float: left;">
		<h3>Patient Login</h3>
		-
		<s:form action="PatientAction" method="post">
			<s:textfield name="patientLoginBean.SSN" label="SSN" />
			<s:textfield name="patientLoginBean.DOB" label="DOB" />
			<s:submit value="Submit" />
		</s:form>
	</div>
</body>
</html>


