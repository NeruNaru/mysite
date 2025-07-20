<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
    	<!-- css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mysite.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/gallery.css">
    
    </head>

<body>
	<div class="wrap">
         	<!-- 해더 + 네비 ------------------------------------>
            <c:import url="/WEB-INF/views/include/header.jsp"></c:import>
            <!-- 해더 + 네비 ----->
            
           	<!-- nav ------------------------------------------------>
			<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>
			<!-- nav ------------------------------------------------>
            
            <div class="content2 clearfix">
                <!-- left_user_box(박스) -------------------------------------------->
				<c:import url="/WEB-INF/views/include/asideGallery.jsp"></c:import>
				<!-- left_user_box(박스) -------------------------------------------->
                
                <main>
					<div class="main-head clearfix">
                        <h3>첨부파일연습</h3>
                        <ol class="clearfix">
                            <li>홈</li>
                            <li>갤러리</li>
                            <li>첨부파일연습</li>
                        </ol>
                    </div>
					
					<div id="attach-form">
						<form method="post" action="${pageContext.request.contextPath }/attach/upload" enctype="multipart/form-data">
							<table>
								<tr>
									<td>첨부파일</td>
									<td><input type="file" name="file"></td>
									<td><button class="btn btn-blue btn-md" type="submit">파일업로드</button></td>
								</tr>
							</table>
						</form>
					</div>
				</main>
			</div>
            
			<!-- footer -->
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
			<!-- //footer -->
			
		</div>
     
	</body>
</html>	
	