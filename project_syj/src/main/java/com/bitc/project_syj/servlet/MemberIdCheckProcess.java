package com.bitc.project_syj.servlet;

import com.bitc.project_syj.database.MemberDAO;
import com.bitc.project_syj.utils.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="idCheck", value = "/member/idCheck.do")
public class MemberIdCheckProcess extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String id = req.getParameter("id");

        if(id.equals("")){
            JSFunction.alertBack("아이디를 입력해주세요.", res);

        }
        else{
            MemberDAO dao = new MemberDAO();
            dao.dbOpen();

            boolean idCheck = dao.idCheck(id);

            boolean isIdCheck = false;

            if(idCheck){
//            JSFunction.alert("아이디가 존재합니다.", res);
                JSFunction.alertBack("이미 존재하는 아이디 입니다.", res);
            }
            else {
                JSFunction.alertBack("사용 가능한 아이디 입니다.", res);
            }
        }



    }
}
