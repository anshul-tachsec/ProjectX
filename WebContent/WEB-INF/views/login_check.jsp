<%@taglib uri="/struts-tags" prefix="ww"%>
<ww:if test="#session.login != 'true'">
<jsp:forward page="<%=request.getContextPath()%>/login.jsp"></jsp:forward>


</ww:if>