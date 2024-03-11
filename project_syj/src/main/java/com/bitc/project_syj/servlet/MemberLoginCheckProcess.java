package com.bitc.project_syj.servlet;

import com.bitc.project_syj.utils.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "loginCheck", value = "/member/loginCheck.do")
public class MemberLoginCheckProcess extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        HttpSession session = req.getSession();

        if(session.getAttribute("userId") == null){
            JSFunction.alertLocation("로그인 후 이용해주세요.","/blog/main.do" ,res );
        }
    }
}
