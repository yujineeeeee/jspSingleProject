package com.bitc.project_syj.servlet;

import com.bitc.project_syj.database.MemberDAO;
import com.bitc.project_syj.database.MemberDTO;
import com.bitc.project_syj.utils.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "join", value = "/member/join.do")
public class MemberJoinProcess extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException, ServletException {
        req.getRequestDispatcher("/login/JoinForm.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        MemberDTO member = new MemberDTO();
        member.setUser_id(id);
        member.setUser_pw(pw);
        member.setUser_name(name);
        member.setUser_email(email);
        member.setUser_phone(phone);

        MemberDAO dao = new MemberDAO();
        dao.dbOpen();
        int result = dao.insertMember(member);
        if(dao.isOpen()){
            dao.dbClose();
        }

        if(result == 1){
            JSFunction.alertLocation("회원가입 되었습니다.", "/blog/main.do", res);

        }else{
            JSFunction.alertBack("회원가입 중 오류가 발생했습니다.", res);
        }

    }

}
