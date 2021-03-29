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
	function openSelectWindow(){
		var id = document.getElementById("now_user_id").value;
		var workno = document.getElementById("get_no").value;
		var workid = document.getElementById("get_id").value;
		var worktitle = document.getElementById("get_title").value;
		var url = './WorkSelectResumeLogic.jsp?id=' + id + "&&workid=" + workid + "&&workno=" + workno + "&&worktitle=" + worktitle;	// 새로 띄울 창에 표시할 페이지
		var title = '이력서 선택';		// 윈도우 이름
		var option = 'top=100px, left=100px, width=500px height=600px';	// 윈도우 옵션
		window.open(url, title, option);
	}
	function openSupportWindow(){
		var workno = document.getElementById("get_no").value;
		var workid = document.getElementById("get_id").value;
		var worktitle = document.getElementById("get_title").value; 
		var url = '/test/worksearch/WorkSupportListLogic.jsp?no='+ workno +'&&id=' + workid + '&&title=' + worktitle;	// 새로 띄울 창에 표시할 페이지
		var title = '지원자 보기';		// 윈도우 이름
		var option = 'top=100px, left=100px, width=500px height=600px';	// 윈도우 옵션
		window.open(url, title, option);
	}
		
</script>
<jsp:include page = "/layout/header.jsp"></jsp:include>
	<form name = "form_data" id = "form_data" method="post" action="WorkEditLogic.jsp" enctype="multipart/form-data" onsubmit = "return gosubmit(this);">
	<input type = "hidden" id = "get_no" name = "get_no" value = "${get_no }">
	<input type = "hidden" id = "get_id" name = "get_id" value = "${get_id }">
	<input type = "hidden" id = "get_title"name = "get_title" value = "${get_title }">
	<input type = "hidden" id = "now_user_id" value = "${sessionScope.currentid }">
	<input type = "hidden" id = "support_list_id" value = "${support_list}">
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
					<select id = "selectID" name = "r_want_head" disabled>
						<c:forEach var = "list" items = "${addr_head_list}" varStatus = "status">
							<option value = "${list.head_addr}" 
							<c:if test= "${userdto.work_where_head eq list.head_addr}">selected</c:if>
							>${list.head_addr}</option>
						</c:forEach>
					</select>
				</td>
				<td colspan = "3">
					<select id = "selectID2" name = "r_want_middle" disabled>
						<c:forEach var = "list" items = "${addr_middle_list}" varStatus = "status">
							<option value = "${list.detail_addr}"
							<c:if test= "${userdto.work_where_middle eq list.detail_addr}">selected</c:if>
							>${list.detail_addr}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name = "age_gogo" disabled>
						<c:forEach var = "list" items = "${agelist }" varStatus = "status">
							<option value = "${list}"
							<c:if test= "${userdto.work_age eq list}">selected</c:if>
							>${list}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name = "sex_gogo" disabled>
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
					<select name = "work_day" disabled>
						<c:forEach var = "list" items = "${position }" varStatus = "status">
							<option value = "${list}"
							<c:if test= "${userdto.work_position eq list}">selected</c:if>
							>${list}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name = "want_money" disabled>
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
						<c:if test="${userdto.work_job_head eq list.j_id}">checked</c:if> disabled>${list.j_head_job }<br>
					</c:forEach>
				</td>
				<td colspan = "3" id = "job_middle">
					<c:forEach var = "listt" items = "${job_mid_list}" varStatus = "status"> 
						<input type = "radio" name = "j_middle_name" id = "j_middle_id" value = "${listt.j_id}" 
						 <c:if test="${userdto.work_job_middle eq listt.j_id}">checked</c:if> disabled>${listt.j_middle_job }<br>
					</c:forEach>
				</td>
				<td colspan = "2" id = "job_end">
					<c:forEach var = "listtt" items = "${job_end_list}" varStatus = "status">
						<input type = "radio" name = "j_end_name" id = "j_end_id" value = "${listtt.j_id }" 
						 <c:if test="${userdto.work_job_end eq listtt.j_id}">checked</c:if> disabled>${listtt.j_end_job }<br>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan = "7">
					<input type = "text" value = "${userdto.work_title }"id = "work_id_desu" name = "title" style = "width : 100%;" placeholder="제목을 입력해주세요" readonly>
				</td>
			</tr>
			<tr>
				<td colspan = "7">
				</td>
			</tr>
			<tr>
				<td	colspan = "7" align = "center" style = "background-color : #E1E3E2; width : 100%; " >
					<div id = "text_image_test" style = "background-color : white; height : 100%; width : 80%; margin : 0px;" >
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
					<c:if test = "${userdto.id == sessionScope.currentid}">
						<input type = "button" value = "수정!" onclick = "location.href = 'WorkEditViewLogic.jsp?no=${get_no}&&id=${get_id}&&title=${get_title}'">
						<input type = "button" value = "삭제!" onclick = "location.href = 'WorkSearchDeleteLogic.jsp?no=${get_no}&&id=${get_id}&&title=${get_title}'">
						<input type = "button" value = "지원자보기" onclick = "openSupportWindow()">
					</c:if>
					<c:if test = "${userdto.id != sessionScope.currentid}" >
						<input type = "button" value = "지원하기!" onclick = "openSelectWindow()">
					</c:if>
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
