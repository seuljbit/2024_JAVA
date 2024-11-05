<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>

<jsp:include page="../layout/header.jsp" />

<c:set value="${bdto.bvo}" var="bvo"></c:set>

<div class="container">
    <h2>게시글 수정</h2>
    <hr>
    <form action="/board/update" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="n" class="form-label"> 게시글 번호 </label>
            <input type="text" class="form-control" id="bno" name="bno" value="${bvo.bno}" readonly>
        </div>

        <div class="mb-3">
            <label for="t" class="form-label"> 제목 </label>
            <input type="text" class="form-control" id="title" name="title" value="${bvo.title}">
        </div>

        <div class="mb-3">
            <label for="writer" class="form-label"> 작성자 </label>
            <input type="text" class="form-control" id="writer" name="writer" value="${bvo.writer}" readonly>
        </div>

        <div class="mb-3">
            <label for="content" class="form-label"> 내용 </label>
            <textarea class="form-control" id="content" name="content" rows="5">${bvo.content}</textarea>
        </div>
        
        <div class="mb-3">
            <label for="file" class="form-label">첨부 파일</label>
            <input type="file" class="form-control d-none" id="file" name="files" multiple="multiple">
            <button type="button" class="btn btn-outline-primary w-100" id="trigger">파일 선택</button>
        </div>
        
        <div id="fileZone" class="mb-3"></div>
        
        <c:set value="${bdto.fileList}" var="fileList"></c:set>
        <div class="mb-3">
    		<ul class="list-group list-group-flush">
    			<c:forEach items="${fileList }" var="fvo">
    				<li class="list-group-item">
    					<c:choose>
    						<c:when test="${fvo.fileType > 0 }">
    							<div class="d-flex justify-content-between align-items-center mb-2">
    								<img alt="" src="/upload/${fvo.saveDir }/${fvo.uuid}_${fvo.fileName}">
    							</div>
    						</c:when>
    						<c:otherwise>
    						</c:otherwise>
    					</c:choose>
    					<div class="d-flex justify-content-between align-items-center mb-2">
		            		<span class="fw-bold">${fvo.fileName}</span>
		           		    <span class="badge badge-primary">${fvo.regDate} / ${fvo.fileSize } </span>
		        			<button type="button" class="btn btn-outline-secondary btn-sm mr-2 file-x" data-uuid=${fvo.uuid }> x </button>
		        		</div>
    				</li>
    			</c:forEach>
			</ul>
        </div>

        <div class="mb-3">
            <label for="regDate" class="form-label"> 등록일 </label>
            <input type="text" class="form-control" id="regDate" name="regDate" value="${bvo.regDate}" readonly>
        </div>

        <div class="mb-3">
            <label for="readCount" class="form-label"> 조회수 </label>
            <input type="text" class="form-control" id="readCount" name="readCount" value="${bvo.readCount}" readonly>
        </div>

        <button type="submit" id="regBtn"> 수정 완료 </button>
    </form>
    <script type="text/javascript" src="/resources/js/Modify.js"></script>
</div>

<jsp:include page="../layout/footer.jsp" />
<script src="/resources/js/boardRegister.js"></script>