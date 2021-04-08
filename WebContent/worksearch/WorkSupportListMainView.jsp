 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>지원자 목록</title>
</head>
		<h1 align = "center" style = "margin-top: 0px;margin-bottom: 0px;">지원자를 선택해주세요</h1>
		<div style = "background-color : white; height: 480px;">
			<table border = "1" class="table table-bordered" style="width:100%;">
				<tr>
					<th colspan = "1" style = "width : 10%;">
						이름
					</th>
					<th colspan = "4" style = "width : 90%">
						제목
					</th>
				</tr>
				<!-- 
				private String user_id;
				private String user_resume;
				private String user_resume_title;
				 -->
				<c:forEach var = "list" items = "${support_list}">
					<tr>
						<td>
							<input type = "hidden" value = "${list.user_resume}">
							<a class="btn btn-default" href = "/test/resume/ResumeViewLogic.jsp?work_no=${list.work_no}&&work_title=${list.work_title}&&id=${list.user_id}&&num=${list.user_resume}&&title=${list.user_resume_title}&&trigger=${list.no}" target="_blank">${list.user_id }</a>
						</td>
						<td>
							<a class="btn btn-default" href = "/test/resume/ResumeViewLogic.jsp?work_no=${list.work_no}&&work_title=${list.work_title}&&id=${list.user_id}&&num=${list.user_resume}&&title=${list.user_resume_title}&&trigger=${list.no}" target="_blank">${list.user_id }</a>						
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
</html>