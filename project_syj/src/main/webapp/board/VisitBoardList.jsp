<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2023-11-22
  Time: 오전 8:55
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
<div class="container">
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
            <th>글쓴이</th>
            <th>게시일</th>
            <th>조회수</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${empty visitBoardList}">
                <tr>
                    <td colspan="5">등록된 게시물이 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="item" items="${visitBoardList}" varStatus="loop">
                    <tr>
                        <td>${item.visit_idx}</td>
                        <td class="text-start">
                            <a href="/blog/visitBoardDetail.do?idx=${item.visit_idx}"
                               class="text-decoration-none text-reset">${item.visit_title}</a>
                        </td>
                        <td>${item.visit_name}</td>
                        <td>${item.visit_postdate}</td>
                        <td>${item.visit_visitcount}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
    <div class="row mt-3">
        <div class="col-sm">
            <div class="d-flex justify-content-end">
                <a href="/blog/visitBoardWrite.do" class="btn btn-primary">글쓰기</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>












