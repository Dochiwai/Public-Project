<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<c:if test = "${result == 1 }">
		정보변경 성공했습니다.
	</c:if>
	<c:if test = "${result != 1 }">
		정보변경 실패했습니다.
	</c:if>
	<br><input type = "button" class="btn btn-primary" value = "메인으로" onclick = "location.href = '/test/index.jsp'"><br>
<jsp:include page = "/layout/footer.jsp"></jsp:include>