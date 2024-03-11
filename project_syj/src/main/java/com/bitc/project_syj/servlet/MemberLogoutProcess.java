package com.bitc.project_syj.servlet;

import com.bitc.project_syj.utils.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="logout", value = "/member/logout.do")
public class MemberLogoutProcess extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession();

        session.removeAttribute("userId");
        session.removeAttribute("userName");

        session.invalidate();

        JSFunction.alertLocation("로그아웃 되었습니다.", "/blog/main.do", res);
    }
}
