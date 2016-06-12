<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>hello world</title>
  </head>
  
  <body>
    <!--<c:if test="${!empty error} ">
    	<font color="red"><c:out value="${error}"/></font>
    </c:if>-->
    <table>
    <form action="<c:url value="/Logon/loginCheck"/>" method="post">
    	username:
    	<input type="text" name="username">
    	<br>
    	password:
    	<input type="password" name="password">
    	<br>
    	<input type="submit" value="submit"/>
    	<input type="reset" value="reset"/>
    </form>
    <table>
  </body>
</html>
