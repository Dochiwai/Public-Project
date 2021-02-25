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
				<td rowspan = "4" align = "center">사진</td>
				<td colspan="3">개인정보</td>
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
				<td>주소</td>
				<td>지구</td>
			</tr>
			<tr>
				<td colspan="4">원하는 직업군</td>		
			</tr>
			<tr>
				<td>대충 내용들</td>
			</tr>
		</table>
		
		<%--
		<div class = "re_title_text_css">
			제목 : <input type = "text" name = "re_title" class = "re_title_name_css">
		</div>
		<div class = "re_picture_css">
			이곳은 사진을 넣을곳입니다...
		</div>
		<div class = "re_profile_css">
			이곳은 프로필 넣을곳입니다			
		</div>
		<div class = "re_wantjob_css">
			이곳은 원하는직업을 넣을 공간입니다.
		</div>
		 --%>
	</form>
<jsp:include page = "/layout/footer.jsp"></jsp:include>