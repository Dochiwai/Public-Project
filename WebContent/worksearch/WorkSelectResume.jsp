 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>이력서 선택하시오</title>
<script type="text/javascript">
/*
	function support(x,y){
		var work_no = document.getElementById("work_no").value;
		var user_id = document.getElementById("user_id").value;
		alert("ㅎㅇ");
	}
*/
</script>

</head>
	<body style = "background-color : gray;">
		<h1 align = "center" style = "background-color : red; margin-top: 0px;margin-bottom: 0px;">이력서를 선택해주세요</h1>
		<div style = "background-color : white; height: 480px;">	
		<input type = "hidden" id = "work_no" value = "${work_num }">
		<input type = "hidden" id = "user_id" value = "${sessionScope.currentid }">
			<table border = "1" style="width:100%;">
				<tr>
					<th colspan = "1" style = "width : 10%;">
						번호
					</th>
					<th colspan = "4" style = "width : 90%">
						제목
					</th>
				</tr>
				<c:forEach var = "list" items = "${resumelist}">
					<tr>
						<td colspan = "1" align = "center">
							<a href = "WorkSupportLogic.jsp?work_num=${work_num}&&user_id=${sessionScope.currentid}&&user_resume_num=${list.r_num}&&user_resume_title=${list.r_title}">
							${list.r_num }</a>
						</td>
						<td colspan = "3" align = "center">
							<a href = "WorkSupportLogic.jsp?work_num=${work_num}&&user_id=${sessionScope.currentid}&&user_resume_num=${list.r_num}&&user_resume_title=${list.r_title}">
							${list.r_title }</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>