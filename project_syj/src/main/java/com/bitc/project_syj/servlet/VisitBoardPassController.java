package com.bitc.project_syj.servlet;

import com.bitc.project_syj.database.VisitBoardDAO;
import com.bitc.project_syj.utils.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "visitBoardDelete", value = "/blog/visitBoardPass.do")
public class VisitBoardPassController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        int idx = Integer.parseInt(req.getParameter("idx"));

        req.setAttribute("idx", idx);

        req.getRequestDispatcher("/board/VisitBoardPass.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String mode = req.getParameter("mode");
        String pw = req.getParameter("pw");
        int idx = Integer.parseInt(req.getParameter("idx"));

        VisitBoardDAO dao = new VisitBoardDAO();
        dao.dbOpen();

        boolean confirmed = dao.checkPw(idx, pw);
        if(confirmed){
            switch (mode){
                case "update":
                    res.sendRedirect("/blog/visitBoardEdit.do?idx="+idx);
                    break;

                case "delete":
                    int result = dao.deleteVisitBoard(idx);
                    if(dao.isOpen()){
                        dao.dbClose();
                    }

                    if(result == 1){
                        JSFunction.alertLocation("삭제되었습니다." , "/blog/visitBoardList.do", res);
                    }else{
                        JSFunction.alertLocation("삭제 중 오류가 발생했습니다." , "/blog/visitBoardList.do", res);
                    }
                    break;
            }
        }else{
            JSFunction.alertBack("비밀번호가 옳지 않습니다.", res);
        }
    }
}

