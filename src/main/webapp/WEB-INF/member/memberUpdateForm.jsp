<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name = "memberUpdateForm" id = "memberUpdateForm">
	<h3>회원정보수정</h3>
		<table>
			<tr>
				<td class = "attribute">이름</td>
				<td><input type = "text" name = "nameWrite" id = "nameWrite" >
					<div id = "nameDivWrite" style = " color : red;"></div>
				</td>
			
			</tr>
			
			<tr>
				<td class = "attribute">아이디</td>
				<td><input type = "text" name = "idWrite" id = "idWrite" readonly="readonly">
					<input type = "button" value = "중복확인" id = "checkDuplicate" readonly="readonly" >
					<div id = "idDivWrite" style="color: red;"></div>
				</td>
			</tr>
			
			<tr>	
				<td class = "attribute">비밀번호</td>
				<td><input type = "password" name = "pwdWrite" id = "pwdWrite" placeholder = "수정할 비밀번호"></td>
			</tr>
			 	
			<tr>
				<td class = "attribute">비밀번호재확인</td>
				<td><input type = "password" name = "pwd2Write" id = "pwd2Write" placeholder = "수정할 비밀번호 재입력">
				<div id = "pwdDivWrite" style = " color : red;"></div>
			</tr>
			
			<tr>
				<td class = "attribute">성별</td>
				<td>
					 <div>
						<input type="radio" id="maleRadio" name="gender" value="male"
						checked>
						<label for="maleRadio">남자</label>
						<input type="radio" id="femaleRadio" name="gender" value="female">
						<label for="femaleRadio">여자</label>
					</div>
				</td>
			</tr>
			
			<tr>
				<td class = "attribute">이메일</td>
				<td>
					<input type = "text" name = "email1" id = "email1">
					@
					<input type = "email" list = "email2" name = "email2" placeholder = "직접입력" id = "email2">
					<datalist id = "email2">
						<option value = "gmail.com">
						<option value = "daum.net">
						<option value = "naver.com">
					</datalist>
				</td>
			</tr>
			
			<tr>
				<td class = "attribute">핸드폰</td>
				<td>
					<input type="text" id="tel1" name="tel1" placeholder = "010" style = "width : 50px">-
					<input type="text" id="tel2" name="tel2" placeholder = "1234" style = "width : 200px">-
					<input type="text" id="tel3" name="tel3" placeholder = "5678" style = "width : 200px">	
				</td>
			</tr>
			
			<tr>
				<td class = "attribute">주소</td>
				<td>
				<input type = "text" name = "zipcode" id = "zipcode" placeholder = "우편 번호" readonly>
				<input type = "button" value = "주소검색" onclick = "sample6_execDaumPostcode();">
				<input type = "text" name = "address1" id = "address1" placeholder = "기본 주소" readonly>
				<input type = "text" name = "address2" id = "address2" placeholder = "상세주소 입력 ">
				</td>
			</tr>
			
			<tr>
				<td colspan = 2 align = "center">
					<input type = "button" value = "회원정보수정" id = "checkValOrSubmit">
					<input type = "button" value = "다시작성" onclick = "updateFormReload();">
				</td>
			</tr>
			
		</table>
	</form>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src = "http://localhost:8080/miniProject/script/memberUpdateForm.js"></script>

</body>
</html>