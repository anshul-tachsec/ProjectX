

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>No Privilege Assigned Page</title>
</head>
<body>
	<h1>Login ERROR</h1>
	NO employee privilege found. Contact ADMIN.
	<s:property value="username" />
	<br>
	<h3><a href="logoutsuccess.jsp">Log Out</a></h3>
</body>
</html>
