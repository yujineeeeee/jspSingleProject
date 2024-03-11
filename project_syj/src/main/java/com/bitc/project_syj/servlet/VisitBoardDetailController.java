package com.bitc.project_syj.servlet;

import com.bitc.project_syj.database.VisitBoardDAO;
import com.bitc.project_syj.database.VisitBoardDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "visitBoardDetail", value = "/blog/visitBoardDetail.do")
public class VisitBoardDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        int idx = Integer.parseInt(req.getParameter("idx"));

        VisitBoardDAO dao = new VisitBoardDAO();
        dao.dbOpen();

        dao.updateVisitCount(idx);

        VisitBoardDTO visitBoard = dao.selectVisitBoardDetail(idx);
        if(dao.isOpen()){
            dao.dbClose();
        }

        req.setAttribute("visitBoard", visitBoard);

        req.getRequestDispatcher("/board/VisitBoardDetail.jsp").forward(req, res);
    }

}
