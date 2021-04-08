<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web03 MemberList **</title>
<link rel="stylesheet" type="text/css" href="./myLib/myStyle.css">
</head>
<body>
<h2>** Web04_MemberList **</h2>
<c:if test="${message!=null}">
=> ${message}
</c:if>
<hr>
<table width=800 border="1" >
	<tr align="center" height="30" bgcolor="pink">
   		<th>I D</th><th>Password</th><th>Name</th><th>Level</th>
   		<th>Birthday</th><th>Point</th><th>Weight</th><th>추천인</th>
	</tr>
	<c:forEach var="row" items="${Banana}">
		<tr>
			<td><a href="/Web04/mdetail?id=${row.id}">${row.id}</a></td>
			<td>${row.password}</td><td>${row.name}</td>
			<td>${row.lev}</td><td>${row.birthd}</td><td>${row.point}</td>
			<td>${row.weight}</td><td>${row.rid}</td>
		</tr>
	</c:forEach>
</table>
<br><hr><a href="/Web04/home.jsp">Home</a>
</body>
</html>