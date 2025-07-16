<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mysite.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user.css">
    	<!-- js -->
    	<script src="${pageContext.request.contextPath}/assets/js/jquery-3.7.1.js"></script>
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
                                <button id="btnCheck" class="btn btn-gray btn-input"  type="button">중복체크</button>
                            	<p id="checkMsg"></p>
                            	
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
<!-- javascript 버전
     <script>
     	document.addEventListener('DOMContentLoaded', function(){
			console.log('돔트리완료');
			
			let btnCheck = document.querySelector('#btnCheck');
			console.log(btnCheck);
			
			btnCheck.addEventListener('click', function(){
				console.log('버튼클릭 감지');
				
			});
     	});
     </script>
-->

	<script>
		$(document).ready(function(){
			console.log('돔트리완료');
			$('#btnCheck').on('click',function(){
				console.log('클릭감지');
				
				let id = $('#txt-idcheck').val();
				console.log(id);
				
				$.ajax({
					
					url : '${pageContext.request.contextPath}/user/idcheck',		
					type : 'post',
					//contentType : 'application/json',
					data : {id: id},

					dataType : 'json',
					success : function(result){
					    /*성공시 처리해야될 코드 작성*/
					    console.log(result);
					    console.log(result.isUse);
					    
						if(result.isUse == true){
							$('#checkMsg').html('사용할 수 있는 아이디 입니다.')
							$('#checkMsg').css('color', '#0000ff');	
							$('#checkMsg').css('font-weight', 'bold');
						}else {
							$('#checkMsg').html('<strong>이미 사용중인 아이디 입니다.</strong>');
							$('#checkMsg').css('color', '#ff0000');	
							$('#checkMsg').css('font-weight', 'bold');
						}
					    
					},
					error : function(XHR, status, error) {
						console.error(status + ' : ' + error);
					}
				});

			});
				
		});
	</script>
    </body>
</html>