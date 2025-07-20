<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
        <!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mysite.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/guestbook.css">
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
			<!-- left_user_box(박스) -------------------------------------------->
			<c:import url="/WEB-INF/views/include/asideGuestbook.jsp"></c:import>
			<!-- left_user_box(박스) -------------------------------------------->

				<main>
					
				    <div class="main-head clearfix">
                        <h3>ajax방명록</h3>
                        <ol class="clearfix">
                            <li>홈</li>
                            <li>방명록</li>
                            <li>ajax방명록</li>
                        </ol>
                    </div>

					<div id="guestbook-addlist">
						<form class="form-box" action="/guestbook/insert" method="post">
							<table>
								<colgroup>
									<col style="width: 70px;">
									<col style="width: 340px;">
									<col style="width: 70px;">
									<col style="width: 340px;">
								</colgroup>
								<tbody>
									<tr>
										<th>
											<label for="txt-name">이름</label>
										</th>
										<td>
											<input id="txt-name" type="text" name="userName" value="">
										</td>
										<th>
											<label for="txt-password">패스워드</label>
										</th>
										<td>
											<input id="txt-password"type="password" name="password" value="">
										</td>
									</tr>
									<tr>
										<td colspan="4">
											<textarea id="text-content" name="content"></textarea>
										</td>
									</tr>
									<tr>
										<td colspan="4" class="btn-box">
											<button class="btn btn-blue btn-lg" type="submit">등록</button>
										</td>
									</tr>
								</tbody>
								
							</table>
						</form>
						
						<button id="btn-List" class="btn btn-blue btn-md" type="button">전체데이터 요청</button>
						
						<div id="gbListArea">
						</div>
						
						<c:forEach items="${requestScope.gList}" var="guestbookvo">
							<table class="guestbook-item">
								<colgroup>
									<col style="width: 10%;">
									<col style="width: 40%;">
									<col style="width: 40%;">
									<col style="width: 10%;">
								</colgroup>
								<tbody>
									<tr>
										<td>${guestbookvo.no}</td>
										<td>${guestbookvo.userName}</td>
										<td>${guestbookvo.regDate}</td>
										<td class="txt-center">
											<a class="btn btn-gray btn-sm" href="/guestbook/removeform?no=${guestbookvo.no}">삭제</a>
										</td>
									</tr>
									<tr>
										<td colspan=4>${guestbookvo.content}</td>
									</tr>
								</tbody>
							</table>
						</c:forEach>
					</div>
			    
                </main>
            </div>
            
            <!-- footer(푸터) ------------------------------------------------>
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
			<!-- footer(푸터) ------------------------------------------------>

        </div>
     
    <script>
    	$(document).ready(function(){
			console.log('돔트리완료');
			
			//버튼 클릭할 때
			$('#btn-List').on('click', function(){
				console.log('버튼클릭');
				
				fetchList();	//리스트 데이터를 요청하여 출력하는 함수
			});
    	});
    	
    	function fetchList() {

    		$.ajax({
				
				url : '${pageContext.request.contextPath}/api/guestbook/list',		
				type : 'post',
				contentType : 'application/json',
				data : {name: '홍길동'},

				dataType : 'json',
				success : function(guestbookList){
				    /*성공시 처리해야될 코드 작성*/
				    console.log(guestbookList);
				    
				    //화면에 그린다
				    for(let i = 0 ; i<guestbookList.length ; i++) {
						render(guestbookList[i]);
				    }
				},
				error : function(XHR, status, error) {
					console.error(status + ' : ' + error);
				}
			});
    	}
    	
    	//guestbookvo 한개를 화면에 그린다
    	function render(guestbookvo){
			console.log(guestbookvo);
			console.log('그린다');
			
			let str= '';
			str += '<table class="guestbook-item">';
			str += '	<colgroup>';
			str += '		<col style="width: 10%;">';
			str += '		<col style="width: 40%;">';
			str += '		<col style="width: 40%;">';
			str += '		<col style="width: 10%;">';
			str += '	</colgroup>';
			
			str += '	<tbody>';
			str += '		<tr>';
			str += '			<td>' + guestbookvo.no+ '</td>';
			str += '			<td>' + guestbookvo.userName + '</td>';
			str += '			<td>' +guestbookvo.regDate + '</td>';
			str += '			<td class="txt-center">';
			str += '				<a class="btn btn-gray btn-sm" href="/guestbook/removeform?no=${guestbookvo.no}">삭제</a>';
			str += '			</td>';
			str += '		</tr>';
			str += '		<tr>';
			str += '			<td colspan=4>' + guestbookvo.content + '</td>';
			str += '		</tr>';
			str += '	</tbody>';
			str += '</table>';
			
			
			
			$('#gbListArea').append(str);
    	}
    	
    </script>
    
    </body>
</html>