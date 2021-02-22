<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트스트</title>
<link rel="stylesheet" type="text/css" href="/test/layout/layout.css">
</head>
	<body>	
        <div class = "header" align = "center">
        	<h1><a href = "/test/index.jsp">허억허억</a></h1>
        </div>
        <div class = "side">
        	<ul>
        		<li>
        			<c:if test = "${sessionScope.currentid == null }">
        				<input type = "button" value = "회원가입" onclick = "location.href = '/test/userjoin/UserJoinViewLogic.jsp'">
        			</c:if>
        			<c:if test = "${sessionScope.currentid != null}"> 
        				<input type = "button" value = "내정보수정" onclick = "location.href = '미정이가 누구야'">
        			</c:if>
        		</li>
        		<li>
        			<c:if test = "${sessionScope.currentid == null }">
        				<input type = "button" value = "로그인" onclick = "location.href = '/test/userlogin/LoginView.jsp'">
        			</c:if>
        			<c:if test = "${sessionScope.currentid != null }">
        				<input type = "button" value = "로그아웃" onclick = "location.href = '미정이가누구야'">
        			</c:if>
        		</li>
        	</ul>
        </div>
        <div class = "body">

			