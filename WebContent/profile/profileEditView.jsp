<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<form action = "" method = "post">
		<c:choose>
			<c:when test="${result == -1}">
				비밀번호가 잘못되었거나, 알 수 없는 오류가 발생하였습니다.
			</c:when>
			<c:otherwise>
				
			</c:otherwise>
		</c:choose>
	</form>
<jsp:include page = "/layout/footer.jsp"></jsp:include>