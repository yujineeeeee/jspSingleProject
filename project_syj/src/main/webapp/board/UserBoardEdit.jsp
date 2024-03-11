<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2023-11-20
  Time: 오전 9:51
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
            $("#btn-list").on("click", function(){
                location.href = "/blog/main.do"
            });


        });
    </script>

</head>
<body>
<div class="container mt-5">
<%--    <c:import url="/layout/Header.jsp"></c:import>--%>
    <section>
        <div class="row">
            <div class="col-sm">
                <form action="/blog/userBoardEdit.do" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="idx" value="${userBoard.board_idx}">
                    <input type="hidden" name="oldSaveFile" value="${userBoard.sfile}">
                    <div class="row mt-3">
                        <div class="col-sm">
                            <input type="text" class="form-control" id="menu" name="menu" value="게시판" readonly>
                        </div>
                        <div class="col-sm">
                            <input type="text" class="form-control" id="name" name="name" value="${userBoard.board_name}" readonly>
                        </div>
                        <div class="col-sm">
                            <input type="text" class="form-control" id="postdate" name="postdate" value="${userBoard.board_postdate}" readonly>
                        </div>
                        <div class="col-sm">
                            <input type="text" class="form-control" id="visitcount" name="visitcount" value="${userBoard.board_visitcount}" readonly>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-sm">
                            <input type="text" class="form-control" id="title" name="title" value="${userBoard.board_title}">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-sm">
                            <textarea class="form-control" id="content" name="content" rows="5">${userBoard.board_content}</textarea>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-sm">
                            <input type="file" class="form-control" id="upload-files" name="uploadFiles">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-sm">
                            <button type="button" class="btn btn-secondary" id="btn-list">목록</button>
                        </div>
                        <div class="col-sm d-flex justify-content-end">
                            <button type="reset" class="btn btn-danger me-2" id="btn-delete">다시쓰기</button>
                            <button type="submit" class="btn btn-warning" id="btn-update">수정</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>


<c:import url="../layout/Footer.jsp" />
</body>
</html>












