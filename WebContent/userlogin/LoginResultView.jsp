<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<c:if test = "${dto != null }">
		환영합니다 ${dto.user_id } 님<br>
	</c:if>
	<c:if test = "${dto == null }">
		로그인 실패했습니다.<br>
		다시 시도해주세요.<br/>
	</c:if>
	<input type = "button" class="btn btn-primary" value = "메인화면으로 돌아가기" onclick = "location.href = '/test/index.jsp'">
<jsp:include page = "/layout/footer.jsp"></jsp:include>