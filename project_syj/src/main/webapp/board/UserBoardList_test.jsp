<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2023-11-20
  Time: 오전 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>

    <style>
        .card-title{
            overflow: hidden;
            text-overflow:ellipsis;
            white-space: nowrap;
        }
    </style>
    <script></script>

</head>
<body>
<div class="container d-flex"> <%-- 게시물 모여주기 --%>
    <div class="row">
        <div class="col-sm">
            <div class="row">
<%--                <c:choose>--%>
<%--                    <c:when test="${empty userBoardList}">--%>
<%--                        <p>등록된 게시물이 없습니다.</p>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <c:forEach var="item" items="${userBoardList}" varStatus="loop">--%>
<%--                            <div class="col my-2">--%>
<%--                                <div class="card" style="width: 18rem;">--%>
<%--                                    <img src="/images/green.jpg" class="card-img-top" alt="">--%>
<%--                                    <div class="card-body">--%>
<%--                                        <a href="/blog/userBoardDetail.do?idx=${item.board_idx}" class="text-decoration-none text-reset fw-bold fs-3">${item.board_title}</a>--%>
<%--                                        <p class="text-muted">${item.board_postdate}</p>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </c:forEach>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>
                <c:choose>
                    <c:when test="${empty userBoardList}">
                        <p>등록된 게시물이 없습니다.</p>
                    </c:when>
                    <c:otherwise>
                        <c:forEach  var="item" items="${userBoardList}" varStatus="loop">
                            <div class="col my-2">
                                <div class="card" style="width: 18rem;">
                                    <img src="/images/green.jpg" class="card-img-top" alt="기본사진">
                                    <div class="card-body">
                                        <a href="/blog/userBoardDetail.do?idx=${item.board_idx}" class="card-title text-decoration-none text-reset fw-bold fs-3">${item.board_title}</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
<%--    </div>--%>
<%--    <div class="row">--%>
<%--        <div class="col-sm">--%>
<%--            <div class="d-flex justify-content-end">--%>
<%--                <a href="/blog/userBoardWrite.do" class="btn btn-primary">글쓰기</a>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>
</div>
</body>
</html>












