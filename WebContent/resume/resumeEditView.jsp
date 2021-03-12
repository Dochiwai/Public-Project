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
	function showTr(){
	var set0 = document.getElementById("titleset0");
	var set1 = document.getElementById("titleset1");
	var set2 = document.getElementById("titleset2");
	var set3 = document.getElementById("titleset3");
	for(i = 0; i <4; i++){
		if(set0.style.display == "none"){
			set0.style.display = "";
			count = count + 1;
			break;
		}
		if(set1.style.display == "none"){
			set1.style.display = "";
			count = count + 1;
			break;
		}
		if(set2.style.display == "none"){
			set2.style.display = "";
			count = count + 1;
			break;
		}
		if(set3.style.display == "none"){
			set3.style.display = "";
			count = count + 1;
			break;
		}
	}	
		if(count == 4){
			alert("생성불가");
		}
	
}
</script>
<script type="text/javascript">
function delSet0(){
	var set0 = document.getElementById("titleset0");
	var titleset = document.getElementById("titleid0");
	var areaset = document.getElementById("textid0");
	titleset.value = "";
	areaset.value = "";
	set0.style.display = "none";
}
function delSet1(){
	var set1 = document.getElementById("titleset1");
	var titleset = document.getElementById("titleid1");
	var areaset = document.getElementById("textid1");
	titleset.value = "";
	areaset.value = "";
	set1.style.display = "none";
}
function delSet2(){
	var set2 = document.getElementById("titleset2");
	var titleset = document.getElementById("titleid2");
	var areaset = document.getElementById("textid2");
	titleset.value = "";
	areaset.value = "";
	set2.style.display = "none";
}
function delSet3(){
	var set0 = document.getElementById("titleset3");
	var titleset = document.getElementById("titleid3");
	var areaset = document.getElementById("textid3");
	titleset.value = "";
	areaset.value = "";
	set3.style.display = "none";
}
</script>
<jsp:include page = "/layout/header.jsp"></jsp:include> 
	<form action = "ResumeJoinLogic.jsp" method = "post" enctype="multipart/form-data">
		<table border = "1" align = "center" style = "width :100%;"  >
			<tr>
				<td>타이틀</td>
				<td colspan ="6"><input type = "text" name = "r_main_title" value = "${dto.r_title }"placeholder="이력서의 제목을 입력해주세요" style= "width: 100%;"></td>
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
		<table border = "1" style = "width : 100%;">
			<tr>
				<td align = "center">
					원하는 근무 지역
				</td>
			</tr>
			<tr>
				<td align = "center">
					<div class = "join_addr_text">
						<select id = "selectID" name = "r_want_head">
							<c:forEach var = "list" items = "${addrlist}" varStatus = "status">
								<option value = "${list.head_addr }"
								<c:if test= "${dto.r_where_head eq list.head_addr}">selected</c:if>
								> ${list.head_addr}</option>
							</c:forEach>
						</select>
						광역시/도
						<select id = "selectID2" name = "r_want_middle">
							<c:forEach var = "list" items = "${addr_detail_list}" varStatus = "status">
								<option value = "${list.detail_addr }"
								<c:if test= "${dto.r_where_end eq list.detail_addr}">selected</c:if>
								> ${list.detail_addr}</option>
							</c:forEach>
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
					<c:forEach var = "list" items = "${joblist}" varStatus = "status">
						<input type = "radio" name = "j_head" id = "j_head_id" value = "${list.j_id }"
						 <c:if test="${dto.r_wantjob_head eq list.j_id}">checked</c:if>>${list.j_head_job }<br>
					</c:forEach>
				</td>
				<td colspan = "2" id = "job_middle" >
					<c:forEach var = "listt" items = "${job_mid_list}" varStatus = "status">
						<input type = "radio" name = "j_middle_name" id = "j_middle_id" value = "${listt.j_id }"
						 <c:if test="${dto.r_wantjob_middle eq 'job_mid_list.j_keyid'}">checked</c:if>>${listt.j_middle_job }<br>
					</c:forEach>
				</td>
				<td colspan = "4" id = "job_end">
				<c:forEach var = "listtt" items = "${job_end_list}" varStatus = "status">
						<input type = "radio" name = "j_end_name" id = "j_end_id" value = "${listtt.j_id }"
						 <c:if test="${dto.r_wantjob_end eq listtt.j_id}">checked</c:if>>${listtt.j_end_job }<br>
					</c:forEach>
				</td>
			</tr>
		</table>
		<table border = "1" id = "self_id" style = "width : 100%;">
			<tr >
				<td align = "center">자기소개서 작성<br><input type = "button" value = "추가하기" onclick = "showTr()"></td>
			</tr>
			<tr id = titleset0 style="display:none;">
				<td align = 'center'>
				<input type = 'text' placeholder = '제목'  style= 'width: 100%; height :30;' id = 'titleid0'name = 'title0"
						count + "'><br>
				<textarea style= 'width: 100%; height :100;' id = 'textid0' name = 'area0'></textarea>
				<input type = 'button' value = '삭제' onclick = "delSet0()"></td>
			</tr>
			<tr id = titleset1 style="display:none;">
				<td align = 'center'>
				<input type = 'text' placeholder = '제목'  style= 'width: 100%; height :30;' id = 'titleid1'name = 'title1"
						count + "'><br>
				<textarea style= 'width: 100%; height :100;' id = 'textid1' name = 'area1'></textarea>
				<input type = 'button' value = '삭제' onclick = "delSet1()"></td>
			</tr>
			<tr id = titleset2 style="display:none;">
				<td align = 'center'>
				<input type = 'text' placeholder = '제목'  style= 'width: 100%; height :30;' id = 'titleid2'name = 'title2"
						count + "'><br>
				<textarea style= 'width: 100%; height :100;' id = 'textid2' name = 'area2'></textarea>
				<input type = 'button' value = '삭제' onclick = "delSet2()"></td>
			</tr>
			<tr id = titleset3 style="display:none;">
				<td align = 'center'>
				<input type = 'text' placeholder = '제목'  style= 'width: 100%; height :30;' id = 'titleid3'name = 'title3"
						count + "'><br>
				<textarea style= 'width: 100%; height :100;' id = 'textid3' name = 'area3'></textarea>
				<input type = 'button' value = '삭제' onclick = "delSet3()"></td>
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