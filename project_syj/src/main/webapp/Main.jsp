<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2023-11-21
  Time: 오후 4:06
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

    <script src="./resources/jquery-3.7.1.js"></script>

    <style>
        #MainImg{
            background-image: url("/images/blogMain.JPG");
        }
    </style>
    <script>

    </script>


</head>
<body>
<div class="container mt-5">
    <c:import url="./layout/Header.jsp"></c:import>
    <section>
        <div class="my-3">
            <div> <%-- 블로그 대문 사진 --%>
                <div class="container d-grid justify-content-center bg-dark" id="MainImg" style="width: 100%; height: 300px">
                </div>
            </div>
            <div class="container mt-3">
                <div class="row"> <%-- 게시물, 사용자 정보 보이는 부분 --%>
                    <div class="col-sm-9"> <%-- 게시물 리스트 --%>
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item" role="presentation">
                                <button class="nav-link active text-reset" id="home-tab" data-bs-toggle="tab"
                                        data-bs-target="#home" type="button" role="tab" aria-controls="home"
                                        aria-selected="true">게시판
                                </button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link text-reset" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile"
                                        type="button" role="tab" aria-controls="profile" aria-selected="false">방명록
                                </button>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <c:import url="/blog/userBoardList.do"></c:import>
                            </div>
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                <c:import url="/blog/visitBoardList.do"></c:import>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm"> <%-- 사용자 정보 보이기 --%>
                        <div class="d-flex flex-column align-items-center ">
                            <c:choose>
                                <c:when test="${empty sessionScope.userId}">
                                    <div class="d-flex bg-light flex-column align-items-center">
                                        <div class="p-2 d-flex justify-content-center">
                                            <img src="/images/main.JPG" alt="profile" class="rounded-circle"
                                                 style="width: 60%; height: 60%">
                                        </div>
                                        <div class="p-2">초록 블로그</div>
                                        <div class="p-2">로그인이 필요합니다.</div>
                                        <div class="p-2"><a href="/member/login.do"
                                                            class="btn btn-outline-success">로그인</a></div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="d-flex bg-light flex-column align-items-center">
                                        <div class="p-2 d-flex justify-content-center">
                                            <img src="/images/main.JPG" alt="profile" class="rounded-circle"
                                                 style="width: 60%; height: 60%">
                                        </div>
                                        <div class="p-2">초록이 블로그</div>
                                        <div class="p-2">${sessionScope.userName}님 방문을 환영합니다.</div>
                                        <div class="p-2">
                                            <a href="/member/logout.do" class="btn btn-outline-dark">로그아웃</a>
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<c:import url="/layout/Footer.jsp"></c:import>
</body>

</html>












