<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<form action = "" method = "post">
		<table border = "1" align = "center">
			<tr>
				<td>타이틀</td>
				<td><input type = "text"></td>
			</tr>
			<tr>
				<td rowspan = "5" align = "center">사진</td>
				<td colspan="2" align = "center" >개인정보</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>홍길동</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>18</td>
				
			</tr>
			<tr>
				<td>성별</td>
				<td>중성</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>지구</td>
			</tr>
			<tr>
				<td colspan="4">원하는 직업군</td>		
			</tr>
			<tr>
				<td>
					<input type = "text">
				</td>
			</tr>
		</table>
	</form>
<jsp:include page = "/layout/footer.jsp"></jsp:include>