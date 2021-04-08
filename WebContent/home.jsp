<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web04 Member System **</title>
<link rel="stylesheet" type="text/css" href="./myLib/myStyle.css">
</head>
<body>
<h2>** Web04 Member System **</h2>
<c:if test="${message!=null}">
${message}
</c:if>
<c:if test="${loginID!=null}">
=> ${loginID} 님 안녕하세요 !!! ~~<br>
</c:if>
<hr>
<img src="./image/summersea.jpg" width="300" height="200">
<hr>
<c:if test="${loginID!=null}">
	<a href="/Web04/mdetail?id=${loginID}">MyInfo</a>
	<a href="/Web04/mlogout">Logout</a>
	<a href="/Web04/mdelete">Delete</a>
</c:if>
<c:if test="${empty loginID}">
<a href="./member/joinForm.jsp">Join</a>&nbsp;
<a href="./login/loginForm.jsp">Login</a>&nbsp;
</c:if>
<br><hr>
<a href="/Web04/mlist">mList</a><br>
</body>
</html>