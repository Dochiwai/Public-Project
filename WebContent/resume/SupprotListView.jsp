<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<jsp:include page = "/layout/header.jsp"></jsp:include>
		<c:if test ="${dto_list != null }">
			<div>
				현재 지원한 회사 리스트<br>
			</div>
			<table border = "1" class="table table-bordered" align = "center" style = "width :80%;"  >
			<tr>
				<td align = "center">No.</td><td align = "center">지원한 회사</td>
			</tr>
				<c:forEach var = "list" items = "${dto_list}">
					<tr>
						<td align = "center">${list.work_no}</td>
						<td align = "center">
							<a class="btn btn-default" href="/test/worksearch/WorkViewLogic.jsp?no=${list.work_no}&&title=${list.work_title}&&id=${list.work_id}" style = "color:blue;">${list.work_title}</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test = "${dto_list == null }">
			현재 지원한 회사가 없습니다<br>
		</c:if>
<jsp:include page = "/layout/footer.jsp"></jsp:include>