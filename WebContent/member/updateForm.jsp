<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** UpdateForm **</title>
<link rel="stylesheet" type="text/css" href="/Web04/myLib/myStyle.css">
<script src="/Web04/myLib/jquery-3.2.1.min.js"></script>
<script src="/Web04/myLib/inCheck.js"></script>
<script>

//** 입력 오류 확인 ( inCheck )
//1. 개별적 오류 확인을 위한 switch 변수 정의
var pCheck=false;
var nCheck=false;
var bCheck=false;
var poCheck=false;
var wCheck=false;
//2. 개별적 focusout 이벤트리스너 function 작성 : JQuery,
$(function(){
	// update에선 idCheck 필요 없음
	// Password
	$('#password').focusout(function(){
		pCheck=pwCheck();
	});// password
	$('#name').focusout(function(){
		nCheck=nmCheck();
	});// name
	$('#birthd').focusout(function(){
		bCheck=bdCheck();
	});// birthd
	$('#point').focusout(function(){
		poCheck=pointCheck();
	});// point
	$('#weight').focusout(function(){
		wCheck=weCheck();
	});// weight
});//ready
//3. 전체적으로 입력 오류 가 없음을 확인하고 submit 여부를 판단
function inCheck(){
	// 모든 Switch변수가 true면 전송 (submit)
	// 아니면 message 출력 후 재입력
	if(pCheck==false){
		$('#pMessage').html(' Password를 확인 하세요 ~~');
		$('#password').focus();
	}
	if(nCheck==false){
		$('#nMessage').html(' Name을 확인 하세요 ~~');
		$('#name').focus();
	}
	if(bCheck==false){
		$('#bMessage').html(' Birthd를 확인 하세요 ~~');
		$('#birthd').focus();
	}
	if(poCheck==false){
		$('#poMessage').html(' Point를 확인 하세요 ~~');
		$('#point').focus();
	}
	if(wCheck==false){
		$('#wMessage').html(' Weight를 확인 하세요 ~~');
		$('#weight').focus();
	}
	if (pCheck==true && bCheck==true && poCheck==true && nCheck==true
			 && wCheck==true){
			if(confirm('~~ 입력 완료, 회원가입 하시겠습니까?')==true){
			    return true;	// submit 실행
			}else{
				$('#name').focus();
			    return false;	// submit 무효화
			}
	}else{	// 하나라도 안맞을 시 submit 무효화
		return false;
	}
}// inCheck

</script>
</head>
<body>
<h2>** Web04 UpdateForm **</h2>
<form action="/Web04/mupdate" method="post"><table>
  <tr height="40"><td bgcolor="aqua">I  D</td>
       <td><input type="text" name="id" id="id" readonly value="${Apple.id}"></td>
 		<!-- disabled : value가 서버로 전송되지 않음, readonly: value가 서버로 전송됨-->
  </tr>
  <tr height="40"><td bgcolor="aqua">Password</td>
       <td><input type="password" name="password" id="password" size="10" value="${Apple.password}"><br>
      <span  id="pMessage" class="message"></span></td>
  </tr>
  <tr height="40"><td bgcolor="aqua">Name</td>
   <td><input type="text" name="name" id="name" value="${Apple.name}" size="10"><br>
      <span  id="nMessage" class="message"></span></td>
   </tr>
  </tr>
  <tr height="40"><td bgcolor="aqua">Level</td>
       <!-- lev의 값에 따라 selected 설정하기 -->
       <td><c:choose>
       		<c:when test="${Apple.lev=='A'}">
       			<select name="lev" id="lev">
            		<option value="A" selected>관리자</option>
            		<option value="B">나무</option>
          			<option value="C">잎새</option>
           			<option value="D">새싹</option>
           		</select>
       		</c:when>
       		<c:when test="${Apple.lev=='B'}">
       			<select name="lev" id="lev">
            		<option value="A">관리자</option>
            		<option value="B" selected>나무</option>
          			<option value="C">잎새</option>
           			<option value="D">새싹</option>
           		</select>
       		</c:when>
       		<c:when test="${Apple.lev=='C'}">
       			<select name="lev" id="lev">
            		<option value="A">관리자</option>
            		<option value="B">나무</option>
          			<option value="C" selected>잎새</option>
           			<option value="D">새싹</option>
           		</select>
       		</c:when>
       		<c:otherwise>
       			<select name="lev" id="lev">
            		<option value="A">관리자</option>
            		<option value="B">나무</option>
          			<option value="C">잎새</option>
           			<option value="D" selected>새싹</option>
           		</select>
       		</c:otherwise>
       </c:choose></td>
  </tr>
  <tr height="40"><td bgcolor="aqua">BirthDay</td>
   <td><input type="date" name="birthd" id="birthd" value="${Apple.birthd}"><br>
      <span id="bMessage" class="message"></span></td>
  </tr>
  <tr height="40"><td bgcolor="aqua">Point</td>
       <td><input type="text" name="point" id="point" value="${Apple.point}" size="10"><br>
      <span id="poMessage" class="message"></span></td>
  </tr>
  <tr height="40"><td bgcolor="aqua">Weight</td>
       <td><input type="text" name="weight" id="weight" value="${Apple.weight}"size="10"><br>
        <span id="wMessage" class="message"></span></td>
  </tr>
  <tr height="40"><td bgcolor="aqua">추천인</td>
       <td><input type="text" name="rid" id="rid" value="${Apple.rid}"></td>
  </tr>
  
  <tr height="40"><td></td>
       <td><input type="submit" value="전송" onclick="return inCheck()">&nbsp;&nbsp;
           <input type="reset" value="취소">&nbsp;&nbsp;
  </tr>
</table></form>
<c:if test="${message != null}">
   <hr><br>
   => ${message}
</c:if>
<hr>
<a href="/Web04/home.jsp">[Home]</a>
</body>
</html>