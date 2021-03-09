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
	            	alert(xhr + " :"+ status)
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
	      var file = document.getElementById('ficture_id');
	      var ficture= file.value;
	      alert(ficture);
	      var data = "<img scr = '"+ficture+"'>";
	      $("#ficture_box").empty();
	      $("#ficture_box").append(data);
	         return false;
	      }); //formAction e
	   });
var count = 0;
function add_textbox(){
	if(count < 4){		
		document.getElementById("self_id").innerHTML +=
		"<td align = 'center'><input type = 'text' align = 'center' placeholder = '제목'  style= 'width: 100%; height :30;' name = 'title"+ count +"'><br><textarea style= 'width: 100%; height :100;' name = 'area"+ count+"'></textarea></td>";	
		count = count + 1;
	}else{
		alert("더이상 생성불가");
	}
}
</script>
<jsp:include page = "/layout/header.jsp"></jsp:include> 
	<form action = "ResumeJoinLogic.jsp" method = "post" enctype="multipart/form-data">
		<table border = "1" align = "center" style = "width :100%;" >
			<tr>
				<td>타이틀</td>
				<td colspan ="6"><input type = "text" name = "r_main_title" placeholder="이력서의 제목을 입력해주세요" style= "width: 100%;"></td>
			</tr>
			<tr>
				<td rowspan="5"><img id="print" src="" height = "200" alt="이미지를 선택해 주세요"><br><input type="file" id="sel-file" name = "r_ficture" accept="image/*">
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
		<table border = "1" align = "center" style = "width : 100%;">
			<tr>
				<td align = "center">
					원하는 근무 지역
				</td>
			</tr>
			<tr>
				<td align = "center">
					<div class = "join_addr_text">
						<select id = "selectID" name = "r_want_head">
							<c:forEach var = "list" items = "${headlist}" varStatus = "status">
								<option value = "${list.head_addr}">${list.head_addr}</option>
							</c:forEach>
						</select>
						광역시/도
						<select id = "selectID2" name = "r_want_middle">
							<option value = "" required></option>
						</select>
						시/군/구<br>
					</div>
				</td>
			</tr>
		</table>
		<table border = "1"  style = "width : 100%;">
			<tr>
				<td colspan="7"  align ="center">원하는 직업군</td>		
			</tr>
			<tr>
				<td colspan = "1"  align ="center"> 
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
		<table border = "1" style = "width : 100%;">
			<tr align = "center"> 
				<td><input type = "submit" value = "작성완료">        <input type = "button" value = "초기화하기"></td>
			</tr>
		</table>
	</form>
<script type="text/javascript">
var selFile = document.querySelector('#sel-file');

selFile.onchange = function () { 
    var getList = this.files;
    
    // 읽기
    var reader = new FileReader();
    reader.readAsDataURL(getList[0]);

    //로드 한 후
    reader.onload = function  () {
        document.querySelector('#print').src = reader.result ;
    }; 
}; 
</script>
<jsp:include page = "/layout/footer.jsp"></jsp:include>