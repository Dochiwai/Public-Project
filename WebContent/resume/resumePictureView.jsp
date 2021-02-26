<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function setParentText(){
		opener.document.getElementById("sex").value = document.getElementById("cInput").value
	}
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진 등록</title>
</head>
	<body>
		<form action = "uploadAction.jsp" method = "post" enctype = "multipart/form-data">
			파일 : <input type = "file" name = "file"><br>
			<input type = "submit" value = "업로드">
			 
			    <br>
			    <b><font size="5" color="gray">자식창</font></b>
			    <br><br>
			 
			    <input type="text" id="cInput"> <input type="button" value="전달하기" onclick="setParentText()">
			    <br><br>
			    <input type="button" value="창닫기" onclick="window.close()">
		</form>
	</body>
</html>