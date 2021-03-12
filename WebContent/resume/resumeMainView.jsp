<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<c:choose>
		<c:when test ="${list != null }">
			<div>
				현재 작성한 이력서<br>
			</div>
			<table border = "1" align = "center" style = "width :80%;"  >
			<tr>
				<td align = "center">No.</td><td align = "center">이력서 제목</td>
			</tr>
				<c:forEach var = "list" items = "${list}">
					<tr>
						<td align = "center">${list.r_num}</td>
						<td align = "center">
							<a href="/test/resume/resumeEditViewLogic.jsp?num=${list.r_num}&&title=${list.r_title}" style = "color:blue;">${list.r_title}</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			현재 등록된 이력서가 없어영 ㅠㅠ<br>
		</c:otherwise>
	</c:choose>
	<input type = "button" value = "이력서 작성하기" onclick = "location.href = 'ResumeWriteViewLogic.jsp'">
<jsp:include page = "/layout/footer.jsp"></jsp:include>