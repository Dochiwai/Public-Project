<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<c:if test = "${result == 1 }">
		회원가입 성공
	</c:if>
	<c:if test = "${result != 1 }">
		회원가입 실패
	</c:if>
	<br><input type = "button" value = "로그인하기" onclick = "location.href = '나중에 로그인페이지 만들면 할 것'"><br>
	<input type = "button" value = "메인으로" onclick = "location.href = '/test/index.jsp'">
<jsp:include page = "/layout/footer.jsp"></jsp:include>