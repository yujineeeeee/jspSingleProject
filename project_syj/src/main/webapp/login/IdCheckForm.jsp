<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2023-11-21
  Time: 오전 11:39
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
<form action="/member/idCheck.do" method="post">
    <div class="row my-3">
        <div class="col-sm">
            <div class="input-group">
                <span class="input-group-text">아이디 : </span>
                <input type="text" class="form-control" id="id-check" name="id-check" value="${param.id}">
                <button type="submit" class="btn btn-primary">중복확인</button>
            </div>
        </div>
    </div>
</form>
</div>
</body>
</html>












