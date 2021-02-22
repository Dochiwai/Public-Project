<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<c:if test = "${dto != null }">
		환영합니다 ${dto.user_id } 님<br>
	</c:if>
	<c:if test = "${dto == null }">
		누구세요?<br>
	</c:if>
	<input type = "button" value = "메인화면으로 돌아가기" onclick = "location.href = '/test/index.jsp'">
<jsp:include page = "/layout/footer.jsp"></jsp:include>