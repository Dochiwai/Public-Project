<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<form class = "join_form" action = "미정" method = "post"> 
		<div class = "id">
				<div class = "join_text_css">
				아이디 
			</div>
			<div class = "join_id_text">
				<input type = "text" name = "join_user_id">
			</div>
		</div>
		<div class = "password">
			<div class = "join_text_css">
				비밀번호 
			</div>
			<div class = "join_password_text">
				<input type = "text" name = "join_user_password">
			</div>
		</div>
		<div class = "nickname">
			<div class = "join_text_css">
				닉네임 
			</div>
			<div class = "join_nickname_text">
				<input type = "text" name = "join_user_nickname">
			</div>
		</div>
		<div class = "addr">
			<div class = "join_text_css">
				거주지 // 나중에 api를 추가할건데 일단 귀찮아서 패스.
			</div>
			<div class = "join_addr_text">
				<input type = "text" name = "join_user_addr">
			</div>
		</div>
		<div class = "phone">
			<div class = "join_text_css">
				이메일 
			</div>
			<div class = "join_phone_text">
				<input type = "email" name = "join_user_phone">
			</div>
		</div>
		<div class = "submit">
			<div class = "join_submit">
				<input type = "submit" value = "회원가입">
				<input type = "reset" value = "초기화">
			</div>
		</div>
	</form>
<jsp:include page = "/layout/footer.jsp"></jsp:include>