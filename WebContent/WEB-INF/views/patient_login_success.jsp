<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="ww"%>
<html>
<head>
<meta http-equiv="cache-control" content="no-cache"> <!-- tells browser not to cache -->
<meta http-equiv="expires" content="0"> <!-- says that the cache expires 'now' -->
<meta http-equiv="pragma" content="no-cache"> <!-- says not to use cached stuff, if there is any -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Patients Home Page</title>
</head>
<body>
	<h1>LoginAction Success for Patient</h1>
	<h3>Welcome to patient's page</h3>
<%-- 	<ww:property value="#session.context" /> --%>
	<br />
	<br />
	<br />
	<a href="<%=request.getContextPath()%>/LogoutAction.action">Logout</a>
</body>

</body>
</html>

