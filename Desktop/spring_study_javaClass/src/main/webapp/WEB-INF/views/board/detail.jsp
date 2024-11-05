<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 페이지</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<jsp:include page="../layout/header.jsp" />

<div class="container mt-5">
    <h2 class="text-center text-dark mb-4"> 게시글 상세 정보 </h2>
    <hr>
    <!-- request 객체로 온 값은 ${bdto} -->
    <!-- c:set 은 값을 저장하는 용도 -->
    
    <c:set value="${bdto.bvo}" var="bvo"></c:set>
    
    <!-- 게시글 정보 -->
    <div class="card p-4 mb-4 shadow-sm">
        <div class="mb-3">
            <label for="n" class="form-label font-weight-bold"> 게시글 번호 </label>
            <input type="text" class="form-control" id="bno" name="bno" value="${bvo.bno}" readonly>
        </div>

        <div class="mb-3">
            <label for="t" class="form-label font-weight-bold">제목</label>
            <input type="text" class="form-control" id="title" name="title" value="${bvo.title}" readonly>
        </div>

        <div class="mb-3">
            <label for="writer" class="form-label font-weight-bold">작성자</label>
            <input type="text" class="form-control" id="writer" name="writer" value="${bvo.writer}" readonly>
        </div>

        <div class="mb-3">
            <label for="content" class="form-label font-weight-bold">내용</label>
            <textarea class="form-control" id="content" name="content" rows="5" readonly>${bvo.content}</textarea>
        </div>

        <div class="mb-3">
            <label for="regDate" class="form-label font-weight-bold">등록일</label>
            <input type="text" class="form-control" id="regDate" name="regDate" value="${bvo.regDate}" readonly>
        </div>

        <div class="mb-3">
            <label for="readCount" class="form-label font-weight-bold">조회수</label>
            <input type="text" class="form-control" id="readCount" name="readCount" value="${bvo.readCount}" readonly>
        </div>
        
    	<c:set value="${bdto.fileList}" var="fileList"></c:set>
       <div class="mb-3">
	    <ul class="list-group list-group-flush">
    <c:forEach items="${fileList}" var="fvo">
        <li class="list-group-item">
            <div class="d-flex justify-content-between align-items-center mb-2">
                <c:choose>
                    <c:when test="${fvo.fileType > 0}">
                        <img alt="" src="/upload/${fvo.saveDir}/${fvo.uuid}_${fvo.fileName}">
                        <a href="/upload/${fvo.saveDir}/${fvo.uuid}_${fvo.fileName}" download="${fvo.fileName}" class="d-flex align-items-center">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="d-flex  bi-image mr-2" viewBox="0 0 16 16">
                                <path d="M6.002 5.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0"/>
                                <path d="M2.002 1a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2zm12 1a1 1 0 0 1 1 1v6.5l-3.777-1.947a.5.5 0 0 0-.577.093l-3.71 3.71-2.66-1.772a.5.5 0 0 0-.63.062L1.002 12V3a1 1 0 0 1 1-1z"/>
                            </svg>
                            <span>${fvo.fileName} </span>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="d-flex  bi-download" viewBox="0 0 16 16">
							  <path d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5"/>
							  <path d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708z"/>
							</svg>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <!-- 일반 파일 -->
                        <a href="/upload/${fvo.saveDir}/${fvo.uuid}_${fvo.fileName}" download="${fvo.fileName}" class="d-flex align-items-center">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-paperclip mr-2" viewBox="0 0 16 16">
                                <path d="M4.5 3a2.5 2.5 0 0 1 5 0v9a1.5 1.5 0 0 1-3 0V5a.5.5 0 0 1 1 0v7a.5.5 0 0 0 1 0V3a1.5 1.5 0 1 0-3 0v9a2.5 2.5 0 0 0 5 0V5a.5.5 0 0 1 1 0v7a3.5 3.5 0 1 1-7 0z"/>
                            </svg>
                            <span>${fvo.fileName} </span>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="d-flex  bi-download" viewBox="0 0 16 16">
							  <path d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5"/>
							  <path d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708z"/>
							</svg>
                        </a>
                    </c:otherwise>
                </c:choose>
                <span class="badge badge-primary">${fvo.regDate} / ${fvo.fileSize}B</span>
            </div>
        </li>
    </c:forEach>
</ul>

	</div>


        <div class="d-flex justify-content-end">
            <a href="/board/modify?bno=${bvo.bno}" class="btn btn-primary text-white mr-2">수정</a>
            <a href="/board/delete?bno=${bvo.bno}" class="btn btn-danger text-white">삭제</a>
        </div>
    </div>
    
    <hr>

    <!-- 댓글 작성창 -->
    <h4 class="text-dark mb-3"> 댓글 작성하기 </h4>
    <!--<form action="/comment/post" method="post" class="mb-4">-->
        <input type="hidden" name="bno" value="${bvo.bno}">
        <div class="mb-3">
            <label for="commentWriter" class="form-label font-weight-bold"> 작성자 </label>
            <input type="text" class="form-control" id="cmtWriter" name="writer" placeholder="작성자를 입력해 주세요.">
        </div>
        <div class="mb-3">
            <label for="commentContent" class="form-label font-weight-bold"> 댓글 내용 </label>
            <textarea class="form-control" id="cmtText" name="content" rows="3" placeholder="댓글을 입력해 주세요."></textarea>
        </div>
        <button type="submit" class="btn btn-primary w-100 text-white" id="cmtAddBtn"> 댓글 작성 </button>
    <!--</form>-->

    <hr>

    <!-- 댓글 목록 -->
    <h4 class="text-dark mb-3"> 댓글 목록 </h4>
    <div class="card shadow-sm p-3">
		<ul id="cmtListArea" class="list-group list-group-flush">
		    <li class="list-group-item">
		        <div class="d-flex justify-content-between align-items-center mb-2">
		            <span class="fw-bold text-primary">${cvo.writer}</span>
		            <span class="badge badge-primary">${cvo.regDate}</span>
		        </div>
		        <p class="mb-0">${cvo.content}</p>
		        
		        <!-- 수정 및 삭제 버튼 -->
		        <div class="d-flex justify-content-end mt-2">
		            <button type="button" data-cno="${cvo.cno}" class="btn btn-outline-secondary btn-sm mr-2" data-bs-toggle="modal" data-bs-target="#myModal"> 수정 </button>
		            <button type="button" data-cno="${cvo.cno}" class="btn btn-outline-danger btn-sm"> 삭제 </button>
		        </div>
		    </li>
		</ul>
    </div>
    
    <!-- more 버튼 -->
    <div>
    	<button type="button" class="btn btn-dark" id="moreBtn" style="visibility:hidden;"> + </button>
    </div>
    
    <!-- 모달창 -->
    <div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
		        	<h1 class="modal-title fs-5" id="cmtWriterMod"></h1>
		        	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      	</div>
			<div class="modal-body">
				<form>
					<div class="mb-3"> <input type="text" class="form-control" id="cmtTextMod"> </div>
		        </form>
			</div>
		    <div class="modal-footer"> <button type="button" class="btn btn-primary" id="cmtModBtn"> 수정 완료 </button> </div>
		</div>
    </div>
</div>

    <!-- 스크립트 추가 -->
    <script type="text/javascript">
        let bnoVal = `<c:out value="${bvo.bno}" />`;
        console.log(bnoVal);
    </script>
    
    <script type="text/javascript" src="/resources/js/boardDetailComment.js"></script>
    
    <script type="text/javascript"> spreadCommentList(bnoVal); </script>
</div>

<jsp:include page="../layout/footer.jsp" />