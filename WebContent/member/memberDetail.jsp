<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web03 MemberDetail **</title>
<link rel="stylesheet" type="text/css" href="./myLib/myStyle.css">
</head>
<body>
<h2>** Web03 MemberDetail **</h2>
<c:if test="${message!=null}">
=> ${message}
<hr>
</c:if>
<h2><pre>
* I  D    : ${Apple.id}
* Password: ${Apple.password}
* N a m e : ${Apple.name}
* Level	  : ${Apple.lev}
* BirthDay: ${Apple.birthd}
* Point	  : ${Apple.point}
* Weight  : ${Apple.weight}
* 추천인  : ${Apple.rid}
</pre></h2>
<hr>
<c:if test="${Apple.id==loginID}">
	<a href="/Web04/mdetail?id=${Apple.id}&jcode=U">Updatef</a>
	<a href="/Web04/mdelete">Delete</a>
	<a href="/Web04/mlogout">Logout</a>
</c:if>
<br><hr>
	<a href="/Web04/mlist">mList</a>
	<a href="/Web04/home.jsp">Home</a>
</body>
</html>