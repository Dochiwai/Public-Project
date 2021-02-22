<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<form action = "ProfileEditLogic.jsp" method = "post">
		<div class = "profile_text">
			비밀번호를 입력해주세요.		
		</div>
		<div class = "profile_password_text">
			<input type = "password" name = "profile_password">
		</div>
		<div>
			<input type = "submit" value = "수정하기">
		</div>
	</form>
<jsp:include page = "/layout/footer.jsp"></jsp:include>