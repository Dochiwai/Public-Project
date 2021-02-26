<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<form action = "" method = "post">
		<table border = "1" align = "center" style = "width :100%;" >
			<tr>
				<td>타이틀</td>
				<td colspan ="6"><input type = "text" placeholder="이력서의 제목을 입력해주세요" style= "width: 100%;"></td>
			</tr>
			<tr>
				<td rowspan = "4" align = "center">사진</td>
				<td colspan="6"  width="90%" align = "center" >개인정보</td>
			</tr>
			<tr>
				<td width="10%" >이름</td>
				<td>${sessionScope.currentname }</td>
				<td>나이</td>
				<td >${sessionScope.currentage }</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>${sessionScope.currentgender }</td>
				<td>연락처</td>
				<td>${sessionScope.currentphone }</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${sessionScope.currentaddr_head } ${sessionScope.currentaddr_middle} ${sessionScope.currentaddr_end}</td>
				<td>이메일</td>
				<td>${sessionScope.currentemail}</td>
			</tr>
			<tr>
				<td colspan="7">원하는 직업군</td>		
			</tr>
			<tr>
				<td>
					
				</td>
			</tr>
		</table>
	</form>
<jsp:include page = "/layout/footer.jsp"></jsp:include>