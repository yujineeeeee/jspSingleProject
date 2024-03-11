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

    <style></style>
    <script></script>

</head>
<body>
<div class="container"> <%-- 게시물 모여주기 --%>
    <table class="table table-hover text-center">
        <colgroup>
            <col style="width: 10%">
            <col style="width: 45%">
            <col style="width: 15%">
            <col style="width: 20%">
            <col style="width: 10%">
        </colgroup>
        <thead>
        <tr>
            <th>글번호</th>
            <th>글제목</th>
            <th>ID</th>
            <th>게시일</th>
            <th>조회수</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${empty userBoardList}">
                <tr>
                    <td colspan="5">등록된 게시물이 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="item" items="${userBoardList}" varStatus="loop">
                    <tr>
                        <td>${item.board_idx}</td>
                        <td class="text-start">
                            <a href="/blog/userBoardDetail.do?idx=${item.board_idx}" class="text-decoration-none text-reset">${item.board_title}</a>
                        </td>
                        <td>${item.board_name}</td>
                        <td>${item.board_postdate}</td>
                        <td>${item.board_visitcount}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
    <div class="row mt-3">
        <div class="col-sm">
            <div class="d-flex justify-content-end">
                <a href="/blog/userBoardWrite.do" class="btn btn-primary">글쓰기</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>












