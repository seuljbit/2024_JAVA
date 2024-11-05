<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../layout/header.jsp" />

<div class="container-md">
    <h1> 목록 </h1> ${ph}
    
    <form action="/board/list" method="get">
        <div class="input-group mb-3">
            <select class="form-select border-end-0" name="type" id="inputGroupSelect01" style="flex: 0 0 25%; border-top-right-radius: 0; border-bottom-right-radius: 0;">
                <option value="twc" ${ph.pgvo.type eq null ? 'selected' : ''}> 전체 </option>
                <option value="t" ${ph.pgvo.type eq 't' ? 'selected' : ''}> 제목 </option>
                <option value="w" ${ph.pgvo.type eq 'w' ? 'selected' : ''}> 작성자 </option>
                <option value="c" ${ph.pgvo.type eq 'c' ? 'selected' : ''}> 내용 </option>
                <option value="tc" ${ph.pgvo.type eq 'tc' ? 'selected' : ''}> 제목 + 내용 </option>
                <option value="tw" ${ph.pgvo.type eq 'tw' ? 'selected' : ''}> 제목 + 작성자 </option>
                <option value="wc" ${ph.pgvo.type eq 'wc' ? 'selected' : ''}> 작성자 + 내용 </option>
            </select>
            
            <input type="text" class="form-control" name="keyword" placeholder="검색어를 입력하세요." value="${ph.pgvo.keyword}" aria-label="Search" aria-describedby="button-addon2" style="border-top-left-radius: 0; border-bottom-left-radius: 0;">
            <input type="hidden" name="pageNo" value="1">
            <input type="hidden" name="qty" value="${ph.pgvo.qty}">
            
            <button class="btn btn-success position-relative" type="submit" id="button-addon2"> 검색
                <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    ${ph.totalCount}
                    <span class="visually-hidden">unread messages</span>
                </span>
            </button>
        </div>
    </form>

    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col"> # </th>
                <th scope="col"> 제 목 </th>
                <th scope="col"> 작성자 </th>
                <th scope="col"> 작성일 </th>
                <th scope="col"> 조회수 </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="bvo">
                <tr>
                    <td> ${bvo.bvo.bno} </td>
                    <td>
                        <a href="/board/detail?bno=${bvo.bvo.bno}"> ${bvo.bvo.title} </a>
                        
                        <!-- 댓글 수 표시 -->
                        <c:if test="${bvo.bvo.cmtQty > 0}">
                            <span class="text-muted">[${bvo.bvo.cmtQty}]</span>
                        </c:if>

                        <!-- 첨부파일 아이콘 표시 -->
                        <c:if test="${bvo.hasImageFile}">
                            <!-- 이미지 파일 아이콘 -->
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-image" viewBox="0 0 16 16">
                                <path d="M6.002 5.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0"/>
                                <path d="M2.002 1a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2zm12 1a1 1 0 0 1 1 1v6.5l-3.777-1.947a.5.5 0 0 0-.577.093l-3.71 3.71-2.66-1.772a.5.5 0 0 0-.63.062L1.002 12V3a1 1 0 0 1 1-1z"/>
                            </svg>
                        </c:if>
                        
                        <c:if test="${bvo.hasNonImageFile}">
                            <!-- 일반 파일 아이콘 -->
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-paperclip" viewBox="0 0 16 16">
                                <path d="M4.5 3a2.5 2.5 0 0 1 5 0v9a1.5 1.5 0 0 1-3 0V5a.5.5 0 0 1 1 0v7a.5.5 0 0 0 1 0V3a1.5 1.5 0 1 0-3 0v9a2.5 2.5 0 0 0 5 0V5a.5.5 0 0 1 1 0v7a3.5 3.5 0 1 1-7 0z"/>
                            </svg>
                        </c:if>
                    </td>
                    <td> ${bvo.bvo.writer} </td>
                    <td> ${bvo.bvo.regDate} </td>
                    <td> ${bvo.bvo.readCount} </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item ${ph.prev eq false ? 'disabled' : '' }">
                <a class="page-link" href="/board/list?pageNo=${ph.startPage-1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}" aria-label="Previous">
                    <span aria-hidden="true"> &laquo; 이전 </span>
                </a>
            </li>
            
            <c:forEach begin="${ph.startPage}" end="${ph.endPage}" var="i">
                <li class="page-item ${ph.pgvo.pageNo eq i ? 'active' : '' }">
                    <a class="page-link" href="/board/list?pageNo=${i}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">
                        <span> ${i} </span>
                    </a>
                </li>
            </c:forEach>
            
            <li class="page-item ${ph.next eq false ? 'disabled' : '' }">
                <a class="page-link" href="/board/list?pageNo=${ph.endPage+1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}" aria-label="Next">
                    <span aria-hidden="true"> 다음 &raquo; </span>
                </a>
            </li>
        </ul>
    </nav>
</div>

<jsp:include page="../layout/footer.jsp" />