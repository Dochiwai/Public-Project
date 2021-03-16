<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<table border = "1" style = "width :100%;">
		<tr>
			<td colspan = "7">
				<h3>직업을 찾아보자..</h3>
			</td>
		</tr>
		<tr>
			<td colspan = "5" align = "center">
				지역
			</td>
			<td colspan = "1">
				나이
			</td>
			<td colspan = "1"> 
				성별
			</td>
		</tr>
		<tr>
			<td colspan = "2">
				어디?
			</td>
			<td colspan = "3">
				어디
			</td>
			<td>
				몇살?
			</td>
			<td>
				성별
			</td>
		</tr>
		<tr>
			<td colspan = "7">
				직종
			</td>
		</tr>
		<tr>
			<td colspan = "2">
				직종머리
			</td>
			<td colspan = "3">
				직종 미들
			</td>
			<td colspan = "2">
				직종엔드
			</td>
		</tr>
		<tr>
			<td colspan = "7">
				<input type = "text" style = "width : 90%;" placeholder="검색하기"><input type = "button" value = "검색">
			</td>
		</tr>
	</table>
<jsp:include page = "/layout/footer.jsp"></jsp:include>