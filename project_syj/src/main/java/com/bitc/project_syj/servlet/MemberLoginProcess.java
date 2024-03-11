package com.bitc.project_syj.servlet;

import com.bitc.project_syj.database.MemberDAO;
import com.bitc.project_syj.database.MemberDTO;
import com.bitc.project_syj.utils.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "login", value = "/member/login.do")
public class MemberLoginProcess extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException, ServletException{
        req.getRequestDispatcher("/login/LoginForm.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        HttpSession session = req.getSession();

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        MemberDAO dao = new MemberDAO();
        dao.dbOpen();

        boolean isMember = dao.isMemeber(id, pw);
        if(isMember){
            MemberDTO member = dao.selectMember(id);
            if(dao.isOpen()){
                dao.dbClose();
            }

            session.setAttribute("userId", member.getUser_id());
            session.setAttribute("userName", member.getUser_name());
            session.setMaxInactiveInterval(60 * 60);

            res.sendRedirect("/blog/main.do");
        }
        else{
            JSFunction.alertBack("아이디 혹은 비밀번호가 틀렸습니다.", res);
        }
    }
}
