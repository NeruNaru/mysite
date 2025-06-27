<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<header class="clearfix">
		<h1><a href="http://localhost:8888/">MySite</a></h1>
                         
		<c:if test="${sessionScope.authuser != null}">
			<ul class="clearfix">
				<li><span class="user-welcome"> ${sessionScope.authuser.name}님 안녕하세요^^</span></li>
				<li>
					<a class="btn btn-white btn-sm" href="/user/logout">로그아웃</a>
				</li>
				<li>
					<a class="btn btn-white btn-sm" href="/user/editform">정보수정</a>
				</li>
			</ul>
		</c:if>
                
		<c:if test="${sessionScope.authuser == null}">
			<ul class="clearfix">
				<li>
					<a class="btn btn-white btn-sm" href="/user/loginform">로그인</a>
				</li>
				<li>
					<a class="btn btn-white btn-sm" href="/user/joinform">회원가입</a>
				</li>
			</ul>
		</c:if>
	</header>
</html>