<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(function() {
	      $('#edit_addr_head_id').change(function() {
	      var city = $("#edit_addr_head_id").val();
	         $.ajax({
	        	  type:'GET',
	        	  async:'true',
	        	  url: '/test/userjoin/AddrMiddleSearch.do?city=' + city,
	        	  data: city,
	        	  dataType: 'text',
	            success: function(data) {
	               $("#edit_addr_middle_id").empty();
	               $("#edit_addr_middle_id").append(data);        
	            }, 
	            error: function(xhr, status) {
	            	alert(xhr + ":" + status );
	            }
	         }); 
	         return false;
	      }); 
	   });
</script>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<c:choose>
		<c:when test="${result == -1}">
			비밀번호가 잘못되었거나, 알 수 없는 오류가 발생하였습니다.
		</c:when>
		<c:otherwise>
			<div class="container" align = "center">
			    <div class="col-md-5 col-md-offset-3 col-sm-8 col-sm-offset-2">
			        <div class="panel panel-success">
			            <div class="panel-body">
							<form action = "ProfileEditDoLogic.jsp" method = "post">
								<div class = "edit_id_text">
									아이디
								</div>
								<div class = "edit_id">
									<input type = "text" class="form-control" value = "${sessionScope.currentid}" readonly>
								</div>
								<div class = "edit_password_text">
									비밀번호
								</div>
								<div class = "edit_password">
									<input type = "password"  class="form-control" id = "edit_password_real" name = "re_edit_password" placeholder = "비밀번호 변경 시 입력">
								</div>
								<div class = "edit_password_onemore">
									<input type = "password"  class="form-control" id = "edit_password_onemore" name = "re_edit_password_onemore" placeholder = "비밀번호 변경 시 재입력">
								</div>
								<div class = "edit_name_text">
									이름
								</div>
								<div class = "edit_name">
									<input type = "text" class="form-control" value = "${sessionScope.currentname }" name = "re_edit_name" required>
								</div>
								<div class = "edit_age_text">
									나이
								</div>
								<div class = "edit_age">
									<input type = "text" class="form-control" value = "${sessionScope.currentage }" name = "re_edit_age" required>
								</div>
								<div class = "edit_gender_text">
									성별
								</div>
								<div class = "edit_gender">
									<c:if test = "${sessionScope.currentgender == '남자'}">
										<input type="radio" id="jb-radio-2" name="re_edit_gender" value="남자" checked="checked">남자
										<input type="radio" id="jb-radio-2" name="re_edit_gender" value="여자">여자
									</c:if>
									<c:if test = "${sessionScope.currentgender == '여자' }">
										<input type="radio" name="re_edit_gender" value="남자">남자
										<input type="radio" name="re_edit_gender" value="여자" checked="checked">여자
									</c:if>
								</div>
								<br/>
								<div class = "edit_addr_text">
									주소
								</div>
								<div class = "edit_addr">
									<select id = "edit_addr_head_id" name = "re_edit_addr_head">
										<c:forEach var = "list" items = "${headlist}">
											<option value = "${list.head_addr}" <c:if test="${list.head_addr == sessionScope.currentaddr_head}"> selected</c:if>>${list.head_addr}</option>
										</c:forEach>
									</select>
									광역시/도
									<select id = "edit_addr_middle_id" name = "re_edit_addr_middle">
										<c:forEach var = "list" items = "${middlelist}">
											<option value = "${list.detail_addr}" <c:if test="${list.detail_addr == sessionScope.currentaddr_middle}"> selected</c:if>>${list.detail_addr}</option>
										</c:forEach>
									</select>
									<br/><br/>
									<input type = "text" class="form-control" name = "re_edit_addr_end" value = "${sessionScope.currentaddr_end }" required>
								</div>
								<div class = "edit_phone_text">
									핸드폰
								</div>
								<div class = "edit_phone">
									<input type = "text" class="form-control" value = "${sessionScope.currentphone }" name = "re_edit_phone" required>
								</div>
								<div class = "edit_email_text">
									이메일
								</div>
								<div class = "edit_email">
									<input type = "text" class="form-control" value = "${sessionScope.currentemail }" name = "re_edit_email" required>
									<br><br>
								</div>
								<div class = "edit_submit">
									<input type = "submit" class="form-control btn btn-primary" value = "수정하기"><br/><br/>
									<input type = "button" class="form-control btn btn-primary" value = "삭제하기" onclick = "location.href = 'UserDelLogic.jsp'">
								</div>
							</form>
			            </div>
			        </div>
			    </div>
			</div>
		</c:otherwise>
	</c:choose>
<jsp:include page = "/layout/footer.jsp"></jsp:include>