<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<aside>
	<h2>유저</h2>
	<c:if test="${sessionScope.authuser != null}">
		<ul>
			<li><a href="/user/editform">회원정보</a></li>
			<li><a href="/user/logout">로그아웃</a></li>
		</ul>
	</c:if>
	<c:if test="${sessionScope.authuser == null}">
		<ul>
			<li><a href="/user/loginform">로그인</a></li>
			<li><a href="/user/joinform">회원가입</a></li>
		</ul>
	</c:if>
</aside>