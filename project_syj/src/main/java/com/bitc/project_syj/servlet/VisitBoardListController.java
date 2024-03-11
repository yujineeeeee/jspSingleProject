package com.bitc.project_syj.servlet;

import com.bitc.project_syj.database.UserBoardDAO;
import com.bitc.project_syj.database.UserBoardDTO;
import com.bitc.project_syj.database.VisitBoardDAO;
import com.bitc.project_syj.database.VisitBoardDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "visitBoardList", value = "/blog/visitBoardList.do")
public class VisitBoardListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        VisitBoardDAO dao = new VisitBoardDAO();

        dao.dbOpen();
        List<VisitBoardDTO> visitBoardList = dao.selectVisitBoardList();
        if(dao.isOpen()){
            dao.dbClose();
        }

        req.setAttribute("visitBoardList", visitBoardList);

        req.getRequestDispatcher("/board/VisitBoardList.jsp").forward(req, res);
    }
}
