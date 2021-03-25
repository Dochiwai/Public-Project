<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>테스트스트</title>
<script type="text/javascript">
	$(document).ready(function(){
		var id = document.getElementById("session_user_id").value;
		var alrambtn = document.getElementById("alram_id");
		if(id == ""){
			return false;
		}
        $.ajax({
       	  type:'GET',
       	  async:'true',
       	  url: '/test/checkalramLogic.jsp?id=' + id,
       	  data: id,
       	  dataType: 'text',
           success: function(data) {
        	   alrambtn.value = data;
        	  
        	   if(data == "알람"){
        		   alrambtn.style.background = 'white';
        	   }else{
        		   alrambtn.style.background = 'red';
        	   }
           }, 
           error: function(xhr, status) {
        	   alert(xhr + " : " + status);
           }
        }); 
        return false;
     }); 
</script>
<script type="text/javascript">
	function alramcheck(){
		var id = document.getElementById("session_user_id").value;
		var url = '/test/alram/alramMainViewLogic.jsp?id=' + id;
		var title = '알람';		// 윈도우 이름
		var option = 'top=100px, left=100px, width=500px height=600px';	// 윈도우 옵션
		window.open(url, title, option);
	}
</script>
<link rel="stylesheet" type="text/css" href="/test/layout/layout.css">
</head>
	<body>	
		<input type = "hidden" id = "session_user_id" value = "${sessionScope.currentid }">
        <div class = "header" align = "center">
        	<h1><a href = "/test/index.jsp">사라민</a></h1>
        </div>
        <div class = "side">
        	<ul>
        		<c:if test = "${sessionScope.currentid != null }">
        			<li>
        				<input type = "button" value = "회사검색" onclick = "location.href = '/test/worksearch/WorkSearchMainViewLogic.jsp'">
        			</li>
        			<li>
        				<input type = "button" value = "이력서관리" onclick = "location.href = '/test/resume/ResumeMainViewLogic.jsp'">
        			</li>
        		</c:if>
        		<li>
        			<c:if test = "${sessionScope.currentid == null }">
        				<input type = "button" value = "회원가입" onclick = "location.href = '/test/userjoin/UserJoinViewLogic.jsp'">
        			</c:if>
        			<c:if test = "${sessionScope.currentid != null}"> 
        				<input type = "button" value = "내정보수정" onclick = "location.href = '/test/profile/profilepasswordView.jsp'">
        			</c:if>
        		</li>
        		<li>
        			<c:if test = "${sessionScope.currentid == null }">
        				<input type = "button" value = "로그인" onclick = "location.href = '/test/userlogin/LoginView.jsp'">
        			</c:if>
        			<c:if test = "${sessionScope.currentid != null }">
        				<input type = "button" value = "로그아웃" onclick = "location.href = '/test/userlogin/LogoutLogic.jsp'">
        			</c:if>
        		</li>
        		<li>
        			<c:if test = "${sessionScope.currentid != null }">
        				<input type = "button" value = "알람" id = "alram_id" style = "background-color : white;" 
        						onclick = "alramcheck()">
        			</c:if>
        		</li>
        	</ul>
        </div>
        <div class = "body">

			