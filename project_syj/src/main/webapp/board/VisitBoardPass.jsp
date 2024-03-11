<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2023-11-22
  Time: 오전 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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

<div class="container mt-5">
    <section>
        <div class="row">
            <div class="col-sm">
                <form action= "/blog/visitBoardPass.do" method="post">
                    <div class="row mt-3">
                        <div class="col-sm-6 mx-auto">
                            <div class="input-group">
                                <div class="form-floating">
                                    <input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력해주세요">
                                    <label for="pw">글 비밀번호를 입력해주세요</label>
                                </div>
                                <button type="submit" class="btn btn-outline-success" style="width: 15%">확인</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="mode" value="${param.mode}">
                    <input type="hidden" name="idx" value="${param.idx}">
                </form>
            </div>
        </div>
    </section>
</div>

</body>
</html>












