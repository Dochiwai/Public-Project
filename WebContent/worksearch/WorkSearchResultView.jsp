 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(function() {
	   //formAction s  
	      $(j_head_id).change(function() {
	      var job_head=$('[name=j_head]:checked').val();
	         $.ajax({
	        	  type:'GET',
	        	  async:'true',
	        	  url: '/test/resume/ResumeMiddleSearch.jsp?job_head=' + job_head,
	        	  data: job_head,
	        	  dataType: 'text',
	            success: function(data) {
	               $("#job_middle").empty();
	               $("#job_middle").append(data);   
	               $("#job_end").empty();
	            }, 
	            error: function(xhr, status) {
	            	alert(xhr + ":" + status)
	            }
	         }); // $.ajax
	         return false;
	      }); //formAction e
	   });
$(function() {
	   //formAction s  
	      $(job_middle).change(function() {
	      var job_middle=$('[name=j_middle_name]:checked').val();
	         $.ajax({
	        	  type:'GET',
	        	  async:'true',
	        	  url: '/test/resume/ResumeEndSearch.jsp?job_middle=' + job_middle,
	        	  data: job_middle,
	        	  dataType: 'text',
	            success: function(data) {    
		           $("#job_end").empty();
		           $("#job_end").append(data);  
	            }, 
	            error: function(xhr, status) {
	            	alert(xhr + ":" + status)
	            }
	         }); // $.ajax
	         return false;
	      }); //formAction e
	   });
$(function() {
	      $('.search_btn').click(function() {
	      btn = $('.search_btn')
	      alert(btn);
	         $.ajax({
	        	  type:'GET',
	        	  async:'true',
	        	  url: '/test/index.jsp',
	        	  data: btn,
	        	  dataType: 'text',
	            success: function(data) {    
	            }, 
	            error: function(xhr, status) {
	            	alert(xhr + ":" + status)
	            }
	         }); // $.ajax
	         return false;
	      });
	   });
</script>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<form action = "WorkSearchSearchLogic.jsp" method = "post">
		<table border = "1" class="table table-bordered" style = "width :100%;">
			<tr>
				<td colspan = "7">
					<h3>구인게시판</h3>
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
				<td colspan = "5">
					<c:forEach var = "list" items = "${addr_head_list}" varStatus = "status">
						<input type="radio" name="where_name" value="${list.head_addr}">${list.head_addr}
					</c:forEach>
				</td>
				<td>
					<select name = "age_gogo">
						<c:forEach var = "list" items = "${agelist}" varStatus = "status">
							<option value = "${list}">${list}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name = "sex_gogo">
						<c:forEach var = "list" items = "${gender }" varStatus = "status">
							<option value = "${list}">${list}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan = "5">
					직종
				</td>
				<td colspan = "1">
					<select name = "work_day">
						<c:forEach var = "list" items = "${position}" varStatus = "status">
							<option value = "${list}">${list}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name = "want_money">
						<c:forEach var = "list" items = "${money}" varStatus = "status">
							<option value = "${list}">${list}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan = "2">
					<c:forEach var = "list" items = "${job_head_list}" varStatus = "status">
						<input type = "radio" name = "j_head" id = "j_head_id" value = "${list.j_id }">${list.j_head_job }<br>
					</c:forEach>
				</td>
				<td colspan = "3" id = "job_middle">
					직종 미들
				</td>
				<td colspan = "2" id = "job_end">
					직종엔드
				</td>
			</tr>
			<tr>
				<td colspan = "7">
					<input type = "text" class="form-control" style = "width : 100%;" name = "title_name" placeholder="검색하기">
					<input type = "submit" class="btn btn-primary" value = "검색">
					<input type = "button" class="btn btn-primary" value = "리셋" onclick = "window.location.reload()">
					<a class="btn btn-primary" href="/test/worksearch/WorkSearchWriteViewLogic.jsp">쓰기</a>
				</td>
			</tr>
				<tr>
					<td colspan = "1" align = "center">
						번호
					</td>
					<td colspan = "1" align = "center">
						이름
					</td>
					<td colspan = "5" align = "center">
						정보 
					</td>
				</tr>
				<c:forEach var = "list" items = "${resultlist}" varStatus = "status">
				<tr>
					<td colspan = "1"  align = "center">
						${list.no}
					</td>
					<td colspan = "1"  align = "center">
						${list.id}
					</td>
					<td colspan = "5">
						<table border = "1" style = "width :100%;">
							<tr>
								<td colspan = "2">
									<a class="table table-bordered" href="WorkViewLogic.jsp?no=${list.no}&&id=${list.id}&&title=${list.work_title}">제목 : ${list.work_title}</a> 
								</td>
							</tr>
							<tr>
								<td colspan = "1">
									<a class="table table-bordered" href="WorkViewLogic.jsp?no=${list.no}&&id=${list.id}&&title=${list.work_title}">성별 : ${list.work_gender}	</a>	
								</td>
								<td colspan = "1">
									<a class="table table-bordered" href="WorkViewLogic.jsp?no=${list.no}&&id=${list.id}&&title=${list.work_title}">나이 : ${list.work_age }</a>	
								</td>
							</tr>
							<tr>
								<td colspan = "1">
									<a class="table table-bordered" href="WorkViewLogic.jsp?no=${list.no}&&id=${list.id}&&title=${list.work_title}">연봉 : ${list.work_money}</a>	
								</td>
								<td colspan = "1">
								<a class="table table-bordered" href="WorkViewLogic.jsp?no=${list.no}&&id=${list.id}&&title=${list.work_title}">지역 : ${list.work_where_head}</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				</c:forEach>
		</table>
	</form>
<jsp:include page = "/layout/footer.jsp"></jsp:include>