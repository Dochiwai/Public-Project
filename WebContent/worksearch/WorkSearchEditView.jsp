 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(function() {
	   //formAction s  
	      $('#selectID').change(function() {
	      var city = $("#selectID").val();
	         $.ajax({
	        	  type:'GET',
	        	  async:'true',
	        	  url: '/test/userjoin/AddrMiddleSearch.do?city=' + city,
	        	  data: city,
	        	  dataType: 'text',
	            success: function(data) {
	               $("#selectID2").empty();
	               $("#selectID2").append(data);        
	            }, 
	            error: function(xhr, status) {
	            }
	         }); // $.ajax
	         return false;
	      }); //formAction e
	   });
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
</script>x
<script type="text/javascript">
	function gosubmit(){
		divvalue = document.getElementById("divval");
		text = document.getElementById("text_image_test");
		divvalue.value = text.innerText;
		document.searchForm.submit();
	}
</script>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<form name = "form_data" id = "form_data" method="post" action="WorkEditLogic.jsp" enctype="multipart/form-data" onsubmit = "return gosubmit(this);">
	<input type = "hidden" name = "get_no" value = "${get_no }">
	<input type = "hidden" name = "get_id" value = "${get_id }">
	<input type = "hidden" name = "get_title" value = "${get_title }">
		<table border = "1" style = "width :100%;">
			<tr>
				<td colspan = "7">
					<h3>직업을 수정해보자..</h3>
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
					<select id = "selectID" name = "r_want_head">
						<c:forEach var = "list" items = "${addr_head_list}" varStatus = "status">
							<option value = "${list.head_addr}" 
							<c:if test= "${userdto.work_where_head eq list.head_addr}">selected</c:if>
							>${list.head_addr}</option>
						</c:forEach>
					</select>
				</td>
				<td colspan = "3">
					<select id = "selectID2" name = "r_want_middle">
						<c:forEach var = "list" items = "${addr_middle_list}" varStatus = "status">
							<option value = "${list.detail_addr}"
							<c:if test= "${userdto.work_where_middle eq list.detail_addr}">selected</c:if>
							>${list.detail_addr}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name = "age_gogo">
						<c:forEach var = "list" items = "${agelist }" varStatus = "status">
							<option value = "${list}"
							<c:if test= "${userdto.work_age eq list}">selected</c:if>
							>${list}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name = "sex_gogo">
						<c:forEach var = "list" items = "${gender }" varStatus = "status">
							<option value = "${list}"
							<c:if test= "${userdto.work_gender eq list}">selected</c:if>
							>${list}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<tr>
				<td colspan = "5">
					직종
				</td>
				<td colspan = "1">
					<select name = "work_day">
						<c:forEach var = "list" items = "${position }" varStatus = "status">
							<option value = "${list}"
							<c:if test= "${userdto.work_position eq list}">selected</c:if>
							>${list}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name = "want_money">
						<c:forEach var = "list" items = "${money }" varStatus = "status">
							<option value = "${list}"
							<c:if test= "${userdto.work_money eq list}">selected</c:if>
							>${list}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan = "2">
					<c:forEach var = "list" items = "${job_head_list}" varStatus = "status">
						<input type = "radio" name = "j_head" id = "j_head_id" value = "${list.j_id }"
						<c:if test="${userdto.work_job_head eq list.j_id}">checked</c:if>>${list.j_head_job }<br>
					</c:forEach>
				</td>
				<td colspan = "3" id = "job_middle">
					<c:forEach var = "listt" items = "${job_mid_list}" varStatus = "status">
						<input type = "radio" name = "j_middle_name" id = "j_middle_id" value = "${listt.j_id}"
						 <c:if test="${userdto.work_job_middle eq listt.j_id}">checked</c:if>>${listt.j_middle_job }<br>
					</c:forEach>
				</td>
				<td colspan = "2" id = "job_end">
					<c:forEach var = "listtt" items = "${job_end_list}" varStatus = "status">
						<input type = "radio" name = "j_end_name" id = "j_end_id" value = "${listtt.j_id }"
						 <c:if test="${userdto.work_job_end eq listtt.j_keyid}">checked</c:if>>${listtt.j_end_job }<br>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan = "7">
					<input type = "text" value = "${userdto.work_title }"name = "title" style = "width : 100%;" placeholder="제목을 입력해주세요">
				</td>
			</tr>
			<tr>
				<td colspan = "7">
					<input type = "file" name = "file1" id = "file1">
					<input type = "file" name = "file2" id = "file2">
				</td>
			</tr>
			<tr>
				<td	colspan = "7" align = "center" style = "background-color : #E1E3E2; width : 100%; ">
					<div id = "text_image_test" contentEditable="true" style = "background-color : white; height : 100%; width : 80%; margin : 0px;" >
					<input type = "hidden" name = "divval" id = "divval" value = "">
					<img id = "print1" src="${image1 }" height = "200" alt="첫번째 이미지를 선택해주세요 이미지 미선택시 글작성 불가능">
					<img id = 'print2' src ="${image2 }" height = '200' alt = '두번째 이미지를 선택해주세요.'>
					${userdto.work_text }
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<input type = "hidden" name = "imageback_1" value = "${imageback_1 }">
					<input type = "hidden" name = "imageback_2" value = "${imageback_2 }">
					<input type = "submit" value = "전송!">
				</td>
			</tr>
		</table>
	</form>	
<script type="text/javascript">
var selFile1 = document.querySelector('#file1');
var selFile2 = document.querySelector('#file2');

selFile1.onchange = function () { 
    var getList = this.files;
    
    // 읽기
    var reader = new FileReader();
    
    reader.readAsDataURL(getList[0]);

    //로드 한 후
    reader.onload = function  () {
        document.querySelector('#print1').src = reader.result ;
    }; 
}; 

selFile2.onchange = function () { 
    var getList = this.files;
    // 읽기
    var reader = new FileReader();
    
    reader.readAsDataURL(getList[0]);

    //로드 한 후
    reader.onload = function  () {
        document.querySelector('#print2').src = reader.result ;
    }; 
}; 
</script>
<jsp:include page = "/layout/footer.jsp"></jsp:include>
