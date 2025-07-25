<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mysite.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/board.css">
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
                <!-- left_board_box(박스) ------------------------------------------->
				<c:import url="/WEB-INF/views/include/left_board_box.jsp"></c:import>
				<!-- left_board_box(박스) ------------------------------------------->


				<main>
					<div class="main-head clearfix">
                        <h3>일반게시판</h3>
                        <ol class="clearfix">
                            <li>홈</li>
                            <li>게시판</li>
                            <li>일반게시판</li>
                        </ol>
                    </div>

	
					<div id="board-read">

						<!-- 작성자 -->
						<div class="info-row">
							<span class="info-title">작성자</span>
							<span>${readervo.userName}</span>
						</div>
						
						<!-- 조회수 -->
						<div class="info-row">
							<span class="info-title">조회수</span>
							<span>${readervo.hit}</span>
						</div>
						
						<!-- 작성일 -->
						<div class="info-row">
							<span class="info-title">작성일</span>
							<span>${readervo.regDate}</span>
						</div>
						
						<!-- 제목 -->
						<div class="info-row">
							<span class="info-title">제 목</span>
							<span>${readervo.title}</span>
						</div>
					
						<!-- 내용 -->
						<div class="info-row">
							<div class="outline" >
								${readervo.content}
							</div>
						</div>
						
						<div class="btn-box">
							<a class="btn btn-gray btn-md" href="/board/list">목록</a>
							<c:if test="${sessionScope.authuser != null}">
    							<c:if test="${sessionScope.authuser.no == readervo.userNo}">
									<a class="btn btn-blue btn-md" href="/board/editform?no=${readervo.no}">수정</a>
								</c:if>
							</c:if>
						</div>
						
					</div>

				 </main>
            </div>
            
            <!-- footer(푸터) ------------------------------------------------>
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
			<!-- footer(푸터) ------------------------------------------------>

        </div>
     
    </body>
</html>