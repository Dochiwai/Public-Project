<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<form action = "/test/userlogin/LoginLogic.jsp" method = "post">
		<div class = "login_text">
			아이디
		</div>
		<div>
			<input type = "text" name = "login_id">
		</div>
		<div class = "login_text">
			패스워드
		</div>
		<div>		
			<input type = "password" name = "login_password">
		</div>
		<div class = "login_submit">
			<input type = "submit" value = "로그인">
		</div>
	</form>	
<jsp:include page = "/layout/footer.jsp"></jsp:include>