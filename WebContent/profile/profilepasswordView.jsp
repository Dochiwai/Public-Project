<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/layout/header.jsp"></jsp:include>

	<div class="container" align = "center">
    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-success">
        <br/><br/>
            <div class="panel-heading">
                <div class="panel-title">비밀번호를 입력해주세요!</div>
            </div>
            <br/>
            <div class="panel-body">
                <form id="login-form" action = "ProfileEditLogic.jsp" method = "post">
                    <div>
                        <input type="text" class="form-control" name="profile_password" placeholder="password" autofocus>
                    </div>
                    <br/>
                    <div>
                        <button type="submit" class="form-control btn btn-primary">입력완료</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page = "/layout/footer.jsp"></jsp:include>