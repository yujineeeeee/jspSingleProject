<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2023-11-17
  Time: 오전 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="container">
<%--    <nav class="navbar navbar-expand-sm navbar-dark fixed-top py-2">--%>
    <nav class="navbar navbar-expand-sms ">
        <div class="container">
            <a href="/blog/main.do" class=""><img src="/images/homeIcon.png" alt="홈아이콘" style="width: 30px"></a>
            <div class="ms-auto">
                <c:choose>
                    <c:when test="${empty sessionScope.userId}">
                        <a href="/member/login.do" class="btn btn-sm btn-outline-success">로그인</a>
                    </c:when>
                    <c:otherwise>
                        <span>${sessionScope.userName}님</span>
                        <a href="/member/logout.do" class="btn btn-sm btn-outline-dark">로그아웃</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </nav>
</div>


<%--</header>--%>









