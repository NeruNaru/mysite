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
                <aside>
                    <h2>게시판</h2>
                    <ul>
                        <li><a href="/board/list">일반게시판</a></li>
                        <li><a href="">댓글게시판</a></li>
                    </ul>
                </aside>


				<main>

				    <div class="main-head clearfix">
                        <h3>일반게시판</h3>
                        <ol class="clearfix">
                            <li>홈</li>
                            <li>게시판</li>
                            <li>일반게시판</li>
                        </ol>
                    </div>
	
					<div id="board-editform">
						
						<form class="form-box" action="${pageContext.request.contextPath}/board/edit" method="get">
							<input type="hidden" name="no" value="${editorvo.no}">
							
							<!-- 작성자 -->
							<div class="info-row">
								<span class="info-title">작성자</span>
								<span>${editorvo.userName}</span>
							</div>
							
							<!-- 조회수 -->
							<div class="info-row">
								<span class="info-title">조회수</span>
								<span>${editorvo.hit}</span>
							</div>
							
							<!-- 작성일 -->
							<div class="info-row">
								<span class="info-title">작성일</span>
								<span>${editorvo.regDate}</span>
							</div>
							
							<!-- 제목 -->
							<div class="info-row">
								<label class="info-title" for="txt-title">제&nbsp;&nbsp;&nbsp;목</label>
								<input type="text" id="txt-title" name="title" value="${editorvo.title}">
							</div>
						
							<!-- 내용 -->
							<div class="info-row">
								<textarea id="txt-content" name="content">${editorvo.content}</textarea>
							</div>
							
                            <div class="btn-box">
                                <a class="btn btn-gray btn-md" href="/board/list">목록</a>
							    <button class="btn btn-blue btn-md" type="submit" >수정</button>
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