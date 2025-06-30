<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mysite.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user.css">
    </head>

    <body>
       <div class="wrap">
			<!-- header(헤더) ------------------------------------------------>
			<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
			<!-- header(헤더) ------------------------------------------------>  
            
            <!-- nav ------------------------------------------------>
			<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>
			<!-- nav ------------------------------------------------>

            <div class="content2 clearfix">
                <!-- left_user_box(좌측유저박스) ------------------------------------------------>
				<c:import url="/WEB-INF/views/include/left_user_box.jsp"></c:import>
				<!-- left_user_box(좌측유저박스) ------------------------------------------------>


                <main>
                    <div class="main-head clearfix">
                        <h3>회원가입</h3>
                        <ol class="clearfix">
                            <li>홈</li>
                            <li>유저</li>
                            <li>회원가입</li>
                        </ol>
                    </div>

                    <div id="user-joinform">
                        
                        <form class="form-box" action="http://localhost:8888/user/join" method="post">
                            <div class="info-row">
                                <label class="info-title" for="txt-idcheck">아이디</label>
                                <input id="txt-idcheck" type="text" name="id" value="">
                                <button id="" class="btn btn-gray btn-input"  type="button">중복체크</button>
                            </div>
                            <div class="info-row">
                                <label class="info-title" for="txt-pwd">패스워드</label>
                                <input id="txt-pwd" type="password" name="password" value="">
                            </div>
                            <div class="info-row">
                                <label class="info-title" for="txt-name">이름</label>
                                <input id="txt-name" type="text" name="name" value="">
                            </div>
                            <div class="info-row">
                                <span class="info-title">성별</span>
                                <label>남</label>
                                <input type="radio" name="gender" value="male">
                                <label>여</label>
                                <input type="radio" name="gender" value="female">
                            </div>
                            <div class="info-row">
                                <span class="info-title">약관동의</span>
                                <input type="checkbox" name="" value="">
                                <lable>서비스 약관에 동의합니다.</lable>
                            </div>
                            <div class="btn-group">
                                <button class="btn btn-blue btn-lg" type="submit">회원가입</button>
                            </div>
                        </form>
                        
                    </div>

                    
                </main>
            </div>
            
            <!-- footer(푸터) ------------------------------------------------>
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
			<!-- footer(푸터) ------------------------------------------------>

        </div>
     
    </body>
</html>