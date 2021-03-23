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
	<form name = "form_data" id = "form_data" method="post" action="WorkInsertLogic.jsp" enctype="multipart/form-data" onsubmit = "return gosubmit(this);">
		<table border = "1" style = "width :100%;">
			<tr>
				<td colspan = "7">
					<h3>직업을 등록해보자..</h3>
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
						<c:forEach var = "list" items = "${addrlist}" varStatus = "status">
							<option value = "${list.head_addr}">${list.head_addr}</option>
						</c:forEach>
					</select>
				</td>
				<td colspan = "3">
					<select id = "selectID2" name = "r_want_middle">
						<option></option>
					</select>
				</td>
				<td>
					<select name = "age_gogo">
						<c:forEach var = "list" items = "${age_list }" varStatus = "status">
							<option value = "${list}">${list}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name = "sex_gogo">
						<c:forEach var = "list" items = "${sex }" varStatus = "status">
							<option value = "${list}">${list}</option>
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
						<option value = "신입">신입</option>
						<option value = "경력">경력</option>
						<option value = "무관">무관</option>
					</select>
				</td>
				<td>
					<select name = "want_money">
						<option value = "회사내규">연봉선택</option>
						<option value = "2400~2600">2400~2600</option>
						<option value = "2600~3000">2600~3000</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan = "2">
					<c:forEach var = "list" items = "${joblist}" varStatus = "status">
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
					<input type = "text" name = "title" style = "width : 100%;" placeholder="제목을 입력해주세요">
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
					<img id = "print1" src = "" height = "200" alt = "첫번째 이미지를 선택해주세요 이미지 미선택시 글작성 불가능">
					<img id = "print2" src = "" height = "200" alt = "두번째 이미지를 선택해주세요."></div>
				</td>
			</tr>
			<tr>
				<td>
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
