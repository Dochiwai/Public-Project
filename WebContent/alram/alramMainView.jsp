 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>알림장</title>
<script type="text/javascript">
	function GoWorkWiew(){
		var values = document.getElementById("url_value_id").value;
		var url = '/test/worksearch/WorkViewLogic.jsp?'+values;
		opener.parent.location = url;
		window.close(); 
	}
	function GoWorkView(){
		var values = document.getElementById("url_value2_id").value;
		var url = '/test/worksearch/WorkViewLogic.jsp?'+values;
		opener.parent.location = url;
		window.close(); 
	}
</script>

</head>
	<body style = "background-color : gray;">
		<h1 align = "center" style = "background-color : red; margin-top: 0px;margin-bottom: 0px;">알림장</h1>
		<div style = "background-color : white; height: 480px;">	
			<table border = "1" style = "width :100%;">
				<tr>
					<th colspan = "1" style = "width :10%;">
						번호
					</th>
					<th colspan = "5">
						내용
					</th>
				</tr>
				<c:if test="${support_list != null}">
					<c:forEach var = "list" items = "${support_list}">
						<tr>
							<td>
								${list.no }
							</td>
							<td>
								<input type = "hidden" id = "url_value_id" value = "no=${list.work_no}&&id=${list.work_id}&&title=${list.work_title}">
								<a href = "/test/worksearch/WorkViewLogic.jsp?no=${list.work_no}&&id=${list.work_id}&&title=${list.work_title}"
								onclick = "GoWorkWiew()">
								${list.work_title}에 ${list.user_id }님이 지원했습니다!<br>지금 바로 확인해보세요!</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${arlam_list != null}">
					<c:forEach var = "list" items = "${arlam_list}">
						<tr>
							<td>
								${list.company_no }
							</td>
							<td>
								<input type = "hidden" id = "url_value2_id" value = "no=${list.company_no}&&title=${list.company_title}&&id=${list.id}&&userid=${list.user_id}">
								<a href = "/test/worksearch/WorkViewLogic.jsp?no=${list.company_no}&&title=${list.company_title}&&id=${list.id}&&userid=${list.user_id}"
								onclick = "GoWorkView()">
								${list.company_title} 의 지원한 이력서를 회사가 확인했습니다!.<br>지금 바로 확인해보세요!</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<div align ="center">
				<input type = "button" value = "닫기" onclick = "window.close()">
			</div>
		</div>
	</body>
</html>