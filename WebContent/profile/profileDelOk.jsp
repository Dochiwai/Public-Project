<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<c:if test = "${result == 1 }">
		회원탈퇴 성공~☆
	</c:if>
	<c:if test = "${result != 1 }">
		회원탈퇴 실패TㅅT
	</c:if>
	<br><input type = "button" value = "메인으로" onclick = "location.href = '/test/index.jsp'"><br>
<jsp:include page = "/layout/footer.jsp"></jsp:include>