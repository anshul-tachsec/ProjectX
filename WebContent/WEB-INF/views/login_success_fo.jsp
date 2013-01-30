<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<!-- <!doctype html> -->
<html lang="us">
<head>
<%@taglib uri="/struts-tags" prefix="s"%>

<meta http-equiv="cache-control" content="no-cache">
<!-- tells browser not to cache -->
<meta http-equiv="expires" content="0">
<!-- says that the cache expires 'now' -->
<meta http-equiv="pragma" content="no-cache">
<!-- says not to use cached stuff, if there is any -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta charset="utf-8">
<title>Front Office Home Page</title>

<link href="css/smoothness/jquery-ui-1.10.0.custom.css" rel="stylesheet">
<script src="js/jquery-1.9.0.js"></script>
<script src="js/jquery-ui-1.10.0.custom.js"></script>
<script>
	$(function() {

		$("#billerMode").button();
		$("#logout").button().click(function() {
			window.location.href="<%=request.getContextPath()%>/LogoutAction.do";
						});
		$("#tabs").tabs();
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
	float: left;
	margin: 0 4px;
}

.fakewindowcontain .ui-widget-overlay {
	position: absolute;
}
</style>
</head>
<body>
	<h4>
		Hello :
		<%=session.getAttribute("loggedInUser").toString()%>
	</h4>
	<button id="billerMode">Biller Mode</button>
	<button id="logout">LogOut</button>
	<!-- 		<a href="LogoutAction.action" class="logout" button id="logout">Logout</a> -->

	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">PT Schedule</a></li>
			<li><a href="#tabs-2">Open Record</a></li>
			<li><a href="#tabs-3">New Record</a></li>
			<li><a href="#tabs-4">Check-In</a></li>
			<li><a href="#tabs-5">Fax-In</a></li>
			<li><a href="#tabs-6">Fax-Out</a></li>

		</ul>
		<div id="tabs-1"></div>
		<div id="tabs-2"></div>
		<div id="tabs-3"></div>
		<div id="tabs-4"></div>
		<div id="tabs-5"></div>
		<div id="tabs-6"></div>
	</div>
	<h3>Patient Entry Form</h3>
		<form action="PatientFormAction" method="post">
			<textfield name="loginBean.username" label="User Name" />
			<password name="loginBean.password" label="Password" />
			<submit value="Submit" />
		</form>
</body>
</html>
