package com.bitc.project_syj.servlet;

import com.bitc.project_syj.database.VisitBoardDAO;
import com.bitc.project_syj.database.VisitBoardDTO;
import com.bitc.project_syj.utils.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "visitBoardWrite", value = "/blog/visitBoardWrite.do")
public class VisitBoardWriteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        req.getRequestDispatcher("/board/VisitBoardWrite.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        VisitBoardDTO visitBoard = new VisitBoardDTO();

        visitBoard.setVisit_name(req.getParameter("name"));
        visitBoard.setVisit_title(req.getParameter("title"));
        visitBoard.setVisit_pw(req.getParameter("pw"));
        visitBoard.setVisit_content(req.getParameter("content"));

        VisitBoardDAO dao = new VisitBoardDAO();
        dao.dbOpen();
        int result = dao.insertVisitBoard(visitBoard);
        if(dao.isOpen()){
            dao.dbClose();
        }

        if(result == 1){
            JSFunction.alertLocation("등록 되었습니다.", "/blog/main.do", res);
        }else {
            JSFunction.alertBack("글쓰기에 실패했습니다.", res);
        }
    }
}

