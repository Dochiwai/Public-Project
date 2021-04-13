<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<%-- ajax 통신용 스크립트입니다. --%>
<script type="text/javascript">
$(function() {
	   //formAction s  
	      $('#user_input_id').keyup(function() {
	      var userid = $("#user_input_id").val();
	      var idcheck = "사용 가능한 아이디입니다.";
	      var realid = "";
	         $.ajax({
	        	  type:'GET',
	        	  async:'true',
	        	  url: './IdoverlapcheckLogic.do?userid=' + userid,
	        	  data: userid,
	        	  dataType: 'text',
	            success: function(data) {
	               $("#id_overlap_result").empty();
	               $("#id_overlap_result").append(data);
	               realid = data;
	               yourealwantthisid(realid,idcheck); // 아이디를 체크하는 함수
	            }, 
	            error: function(xhr, status) {
	            	alert(xhr + " : " + status)
	            }
	         }); // $.ajaㅌ
	         return false;
	      }); //formAction e
	   });
	   
	   //아이디 체크하는 함수
	   function yourealwantthisid(realid ,idcheck){
		   var joinbtn = document.getElementById('join_go');
		   var pscheckreal = document.getElementById('password_result').innerText;  
		   var pscheck = "비밀번호가 일치합니다.";
		   if(realid == idcheck){
			   if(pscheckreal == pscheck){
				   joinbtn.disabled = false;
			   }
		   }else{
			   joinbtn.disabled = true;
		   }
	   }
	   //비밀번호 체크 함수
	   $(function() {
		      $('#password2').keyup(function() {
		    	  var joinbtn = document.getElementById('join_go');
		    	  var idcheckreal = document.getElementById('id_overlap_result').innerText;
		    	  var idcheck = "사용 가능한 아이디입니다.";
		    	  var ps1 = $("#password1").val();
		    	  var ps2 = $("#password2").val();
		    	  if(ps1 == ps2){
		    		  $("#password_result").empty();
		    		  $("#password_result").append("비밀번호가 일치합니다.");
		    		  if(idcheckreal == idcheck){
		    			  joinbtn.disabled = false;
		    		  }
		    	  }else{
		    		  $("#password_result").empty();
		    		  $("#password_result").append("비밀번호가 일치하지않습니다.");
		    		  joinbtn.disabled = true;
		    	  }
		      return false;
		      }); //formAction e
		   });
</script>
<script>
function searchAddr(){
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = "";
            
            if(data.userSelectedType === 'R'){
            	addr = data.roadAddress;
            }else{
            	addr = data.jibunAddress;
            }
            
            document.getElementById('join_addr_headAndMiddle').value = addr;
        }
    }).open();
}
</script>
<%-- submit 버튼용 스크립트입니다. --%>
<jsp:include page = "/layout/header.jsp"></jsp:include>
<div class="container" align = "center">
    <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-2">
        <div class="panel panel-success">
            <div class="panel-heading">
                <div class="panel-title">환영합니다!</div>
            </div>
            <div class="panel-body">
                <form id="login-form" action = "./JoinLogic.jsp" method = "post">
                <div class = "id">
					<div class = "join_text_css">
						아이디 
					</div>
					<div class = "join_id_text">
						<input type = "text" class="form-control" name = "join_user_id" id = "user_input_id" required>
					</div>
					<div class = "id_overlap_check">
						<div id = "id_overlap_result">
							
						</div>
					</div>
				</div>
				<div class = "password">
					<div class = "join_text_css">
						비밀번호 
					</div>
					<div class = "join_password_text">
						<input type = "password" class="form-control" placeholder="password" name = "join_user_password" id = "password1" required>
					</div>
					<div class = "join_password_text">
						<input type = "password" class="form-control" placeholder="password" name = "join_user_password_onemore" id = "password2" required>
					</div>
					<div class = "join_password_equel_result" id = "password_result">
						
					</div>
				</div>
				<div class = "name">
					<div class = "join_text_css">
						이름 
					</div>
					<div class = "join_name_text">
						<input type = "text" class="form-control" name = "join_user_name" required>
					</div>
				</div>
				<div class = "join_text_css">
					<div class = "join_user_gender">
						<input type="radio" name="join_user_gender" value="남자" checked="checked">남자
						<input type="radio" name="join_user_gender" value="여자">여자
						<label>나이</label>
						<input type="text" style = "width : 50px;"name = "join_user_age" required>
					</div>
				</div>
				<div class = "addr">
					<div class = "join_text_css">
						거주지를 선택해주세요<input type = "button" value = "주소지 선택" onclick = "searchAddr()">
					</div>
					<div class = "join_addr_text">
						일반주소 <input type = "text" id = "join_addr_headAndMiddle" name = "join_addr_head" style = "width : 80%;" readonly="readonly"><br/>
						상세주소 <input type = "text" name = "join_addr_end" style = "width : 80%;">
					</div>
				</div>
				<div class = "phone">
					<div class = "join_text_css">
						핸드폰번호 
					</div>
					<div class = "join_phone_text">
						<input type = "text" class="form-control" name = "join_user_phone" required>
					</div>
				</div>
				<div class = "email">
					<div class = "join_text_css">
						이메일 
					</div>
					<div class = "join_email_text">
						<input type = "email" class="form-control" name = "join_user_email" required>
					</div>
				</div>
				<div class = "submit">
					<div class = "join_submit">
						<input type = "submit" class="form-control btn btn-primary"  name = "join_go" value = "회원가입" id = "join_go" disabled=""><br/><br/>
						<input type = "reset" class="form-control btn btn-primary"  value = "초기화">
					</div>
				</div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page = "/layout/footer.jsp"></jsp:include>