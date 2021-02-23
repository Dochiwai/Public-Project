<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<c:choose>
		<c:when test="${result == -1}">
			비밀번호가 잘못되었거나, 알 수 없는 오류가 발생하였습니다.
		</c:when>
		<c:otherwise>
			<form action = "어디로가야하죠 아저씨" method = "post">
				<div class = "edit_id_text">
					아이디
				</div>
				<div class = "edit_id">
					<input type = "text" value = "${sessionScope.currentid}" readonly>
				</div>
				<div class = "edit_password_text">
					비밀번호
				</div>
				<div class = "edit_password">
					<input type = "password" id = "edit_password_real">
				</div>
				<div class = "edit_password_onemore">
					<input type = "password" id = "edit_password_onemore" name = "re_edit_password">
				</div>
				<div class = "edit_name_text">
					이름
				</div>
				<div class = "edit_name">
					<input type = "text" value = "${sessionScope.currentname }" name = "re_edit_name" required>
				</div>
				<div class = "edit_age_text">
					나이
				</div>
				<div class = "edit_age">
					<input type = "text" value = "${sessionScope.currentage }" name = "re_edit_age" required>
				</div>
				<div class = "edit_gender_text">
					성별
				</div>
				<div class = "edit_gender">
					<c:if test = "${sessionScope.currentgender == '남자'}">
						<input type="radio" name="re_edit_gender" value="남자" checked="checked">남자
						<input type="radio" name="re_edit_gender" value="여자">여자
					</c:if>
					<c:if test = "${sessionScope.currentgender == '여자' }">
						<input type="radio" name="re_edit_gender" value="남자">남자
						<input type="radio" name="re_edit_gender" value="여자" checked="checked">여자
					</c:if>
				</div>
				<div class = "edit_addr_text">
					주소
				</div>
				<div class = "edit_addr">
					<input type = "text" value = "${sessionScope.currentaddr }" name = "re_edit_addr" required>
				</div>
				<div class = "edit_phone_text">
					핸드폰
				</div>
				<div class = "edit_phone">
					<input type = "text" value = "${sessionScope.currentphone }" name = "re_edit_phone" required>
				</div>
				<div class = "edit_email_text">
					이메일
				</div>
				<div class = "edit_email">
					<input type = "text" value = "${sessionScope.currentemail }" name = "re_edit_email" required>
					<br><br>
				</div>
				<div class = "edit_submit">
					<input type = "submit" value = "수정하기">
				</div>
			</form>
		</c:otherwise>
	</c:choose>
<jsp:include page = "/layout/footer.jsp"></jsp:include>