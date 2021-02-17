<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<form class = "join_form" action = "미정" method = "post"> 
		<div class = "id">
			<div class = "join_text_css">
				아이디 
			</div>
			<div class = "join_id_text">
				<input type = "text" name = "join_user_id" required>
			</div>
		</div>
		<div class = "password">
			<div class = "join_text_css">
				비밀번호 
			</div>
			<div class = "join_password_text">
				<input type = "text" name = "join_user_password" required>
			</div>
		</div>
		<div class = "name">
			<div class = "join_text_css">
				이름 
			</div>
			<div class = "join_name_text">
				<input type = "text" name = "join_user_name" required>
			</div>
		</div>
		<div class = "join_text_css">
			<div class = "join_user_gender">
				<input type="radio" name="join_user_gender" value="남자" checked="checked">남자
				<input type="radio" name="join_user_gender" value="여자">여자
				<label>나이</label>
				<input type="text" name = "join_user_age" required>
			</div>
		</div>
		<div class = "addr">
			<div class = "join_text_css">
				거주지 // 나중에 api를 추가할건데 일단 귀찮아서 패스.
			</div>
			<div class = "join_addr_text">
				<select>
					<c:forEach var = "list" items = "${headlist}" varStatus = "status">
						<option name = "join_head_addr" value = "${headlist[stauts.index]}">${headlist[status.index]}</option>
					</c:forEach>
	
				<%--
					<c:forEach var = "headnumlist" items = "${headnumberlist}" varStatus = "status">  
						<input type = "hidden" value = "${headnumberlist[status.index]}" name = "join_head_number">    
					</c:forEach>	
				--%>
				
					
				</select>
			</div>
		</div>
		<div class = "phone">
			<div class = "join_text_css">
				핸드폰번호 
			</div>
			<div class = "join_phone_text">
				<input type = "text" name = "join_user_phone" required>
			</div>
		</div>
		<div class = "email">
			<div class = "join_text_css">
				이메일 
			</div>
			<div class = "join_email_text">
				<input type = "email" name = "join_user_email" required>
			</div>
		</div>
		<div class = "submit">
			<div class = "join_submit">
				<input type = "submit" value = "회원가입">
				<input type = "reset" value = "초기화">
			</div>
		</div>
	</form>
<jsp:include page = "/layout/footer.jsp"></jsp:include>