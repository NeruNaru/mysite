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
                        <li><a href="board/list3">일반게시판</a></li>
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
					
                    <div id="board-list">
                        <form action="" method="">
                            <input type="text" name="kwd" value="">
                            <button class="btn btn-gray btn-input" type="submit">검색</button>
                        </form>

                        <table>
							<colgroup>
									<col style="width: 10%;">
									<col style="width: 45%;">
									<col style="width: 10%;">
									<col style="width: 10%;">
									<col style="width: 15%;">
									<col style="width: 10%;">
								</colgroup>
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>글쓴이</th>
									<th>조회수</th>
									<th>작성일</th>
									<th>관리</th>
								</tr>
							</thead>
							<c:forEach items="${requestScope.pMap.boardList}" var="boardvo">
							<tbody>
								<tr>
									<td>${boardvo.no}</td>
									<td class="txt-left"><a href="/board/read?no=${boardvo.no}">${boardvo.title}</a></td>
									<td>${boardvo.userName}</td>
									<td>${boardvo.hit}</td>
									<td>${boardvo.regDate}</td>
									<td>
										<c:if test="${sessionScope.authuser != null}">
    										<c:if test="${sessionScope.authuser.no == boardvo.userNo}">
       											<button class="btn btn-white btn-sm" type="button">삭제</button>
    										</c:if>
										</c:if>
                                    </td>
								</tr>
							</tbody>
							</c:forEach>
						</table>

                        <div class="paging">
							<ul class="clearfix">
								<c:choose>
									<c:when test="${requestScope.pMap.prev == true}">
										<li><a href="http://localhost:8888/board/list3?crtpage=${requestScope.pMap.startPageBtnNo-1}&kwd=${param.kwd}">◀</a></li>
									</c:when>
									<c:otherwise>
									<li style="visibility: hidden;"><span>◀</span></li>
									</c:otherwise>
								</c:choose>
								<c:forEach begin="${requestScope.pMap.startPageBtnNo}" 
									end="${requestScope.pMap.endPageBtnNo}"
										step="1"
											var="page">
										<c:choose>
											<c:when test="${param.crtpage == page}">												
												<li class="active"><a href="http://localhost:8888/board/list3?crtpage=${page}&kwd=${param.kwd}">${page}</a></li>
											</c:when>
											<c:otherwise>
													<li><a href="http://localhost:8888/board/list3?crtpage=${page}&kwd=${param.kwd}">${page}</a></li>											
											</c:otherwise>
										</c:choose>
								</c:forEach>
								<c:choose>
									<c:when test="${requestScope.pMap.next == true}">
										<li><a href="http://localhost:8888/board/list3?crtpage=${requestScope.pMap.endPageBtnNo+1}&kwd=${param.kwd}">▶</a></li>
									</c:when>
									<c:otherwise>&nbsp;</c:otherwise>
								</c:choose>
							</ul>
						</div>
                        <div class="btn-box">
                        	<c:if test="${sessionScope.authuser.no != null}">
                            	<a class="btn btn-blue btn-md" href="/board/writeform">글쓰기</a>
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