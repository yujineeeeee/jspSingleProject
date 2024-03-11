<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2023-11-21
  Time: 오전 10:11
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

    <script src="../resources/jquery-3.7.1.js"></script>

    <style></style>
    <script>
        $(document).ready(function(){
            $("#btn-join").on("click", function(){
                location.href = "/member/join.do";
            });
        });
    </script>

</head>
<body>

<div class="container mt-5">
    <h2 class="text-center">로그인</h2>
    <div class="row">
        <div class="col-sm-4 mx-auto">
            <form action="/member/login.do" method="post">
                <div class="row mt-3">
                    <div class="col-sm">
                        <div class="form-floating">
                            <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요">
                            <label for="id">아이디를 입력하세요</label>
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-sm">
                        <div class="form-floating">
                            <input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력하세요">
                            <label for="pw">비밀번호를 입력하세요</label>
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-sm d-grid">
                        <button type="submit" class="btn btn-outline-success">로그인</button>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-sm d-flex justify-content-end">
                        <a type="button" class="btn btn-link text-decoration-none text-primary" id="btn-join">회원가입</a>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<c:import url="../layout/Footer.jsp"></c:import>

</body>
</html>












