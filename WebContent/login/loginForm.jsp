<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web04 Member Login **</title>
<link rel="stylesheet" type="text/css" href="../myLib/myStyle.css">
<script src="../myLib/jquery-3.2.1.min.js"></script>
<script src="../myLib/inCheck.js"></script>
<script>
//	1. 전역변수 정의
//	=> 오류확인을 위한 switch 변수들
var iCheck=false;
var pCheck=false;
//	2. 각 Tag의 focusout 을 이용한 무결성점검
$(function(){
	$('#id').focus();
	$('#id').focusout(function(){
		iCheck=idCheck();
	});// id
	// Password
	$('#password').focusout(function(){
		pCheck=pwCheck();
	});// password
	
});//ready

//	3. submit을 위한 function inCheck()
function inCheck(){
	// 모든 Switch변수가 true면 전송 (submit)
	// 아니면 message 출력 후 재입력
	if(iCheck==false){
		$('#iMessage').html(' ID를 확인 하세요 ~~');
		$('#id').focus();
	}
	if(pCheck==false){
		$('#pMessage').html(' Password를 확인 하세요 ~~');
		$('#password').focus();
	}
	if (iCheck==true && pCheck==true){
			if(confirm('~~ 입력 완료, 로그인 하시겠습니까?')==true){
			    return true;	// submit 실행
			}else{
				$('#id').focus();
			    return false;	// submit 무효화
			}
	}else{
		return false; // submit 무효화
	}
}// inCheck
</script>
</head>
<body>
<h2>** Web03 Member Login **</h2>
<form action="/Web04/mlogin" method="get">
<table>
   <tr><td><label for="id">I D :</label></td>
      <td><input type="text" name="id" id="id" ><br>
      <span id="iMessage" class="message"></span></td>
   </tr>
   <tr><td><label for="pw">Password:</label></td>
      <td><input type="password" name="password" id="password" ><br>
      <span id="pMessage" class="message"></span></td>
   </tr>
   <tr><td></td>
      <td><input type="submit" value="Login" onclick="return inCheck()">
      <input type="reset" value="Reset"></td>
   </tr>
</table>
</form>
<c:if test="${message != null}">
   <hr><br>
   => ${message}
</c:if>
<br>
<a href="/Web04/home.jsp">Home</a>
</body>
</html>