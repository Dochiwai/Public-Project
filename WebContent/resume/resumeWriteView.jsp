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
	        	  url: './ResumeMiddleSearch.jsp?job_head=' + job_head,
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
	        	  url: './ResumeEndSearch.jsp?job_middle=' + job_middle,
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
	   //formAction s  
	      $(ficture_id).change(function() {
	      var ficture=$('ficture_id').val();
	      var data = "<img scr = '"+data+"'>";
	      $("#ficture_box").empty();
	      $("#ficture_box").append(data);
	         return false;
	      }); //formAction e
	   });
var count = 0;
function add_textbox(){
	if(count < 4){		
		document.getElementById("self_id").innerHTML +=
		"<td align = 'center'><input type = 'text' placeholder = '제목' name = 'title"+ count +"'><br><textarea name = 'area"+ count+"'></textarea></td>";	
		count = count + 1;
	}else{
		alert("더이상 생성불가");
	}
}
</script>
<jsp:include page = "/layout/header.jsp"></jsp:include> 
	<form action = "" method = "post">
		<table border = "1" align = "center" style = "width :100%;" >
			<tr>
				<td>타이틀</td>
				<td colspan ="6"><input type = "text" placeholder="이력서의 제목을 입력해주세요" style= "width: 100%;"></td>
			</tr>
			<tr>
				<td><input type = "file" name = "ficture_name" id = "ficture_id"><div id= "ficture_box">섹</div>사진업로드</td>
				<td colspan="6"  width="90%" align = "center" >개인정보</td>
			</tr>
			<tr>
				<td width="10%" >이름</td>
				<td>${sessionScope.currentname }</td>
				<td>나이</td>
				<td >${sessionScope.currentage }</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>${sessionScope.currentgender }</td>
				<td>연락처</td>
				<td>${sessionScope.currentphone }</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${sessionScope.currentaddr_head } ${sessionScope.currentaddr_middle} ${sessionScope.currentaddr_end}</td>
				<td>이메일</td>
				<td>${sessionScope.currentemail}</td>
			</tr>
		</table>
		<table border = "1" align ="center" style = "width : 100%;">
			<tr>
				<td colspan="7">원하는 직업군</td>		
			</tr>
			<tr>
				<td colspan = "1"> 
					<c:forEach var = "list" items = "${list}" varStatus = "status">
						<input type = "radio" name = "j_head" id = "j_head_id" value = "${list.j_id }">${list.j_head_job }<br>
					</c:forEach>
				</td>
				<td colspan = "2" id = "job_middle" >
					
				</td>
				<td colspan = "4" id = "job_end">
				
				</td>
			</tr>
		</table>
		<table border = "1" id = "self_id" align = "center" style = "width : 100%;">
			<tr>
				<td align = "center">자기소개서 작성<br><input type = "button" value = "추가하기" onclick = "add_textbox()"></td>
			</tr>
		</table>
	</form>
<jsp:include page = "/layout/footer.jsp"></jsp:include>