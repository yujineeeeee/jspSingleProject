package com.bitc.project_syj.servlet;

import com.bitc.project_syj.database.UserBoardDAO;
import com.bitc.project_syj.database.UserBoardDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "userBoardDetail", value = "/blog/userBoardDetail.do")
public class UserBoardDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        int idx = Integer.parseInt(req.getParameter("idx"));

        UserBoardDAO dao = new UserBoardDAO();
        dao.dbOpen();

        dao.updateVisitCount(idx);

        UserBoardDTO userBoard = dao.selectUserBoardDetail(idx);
        if(dao.isOpen()){
            dao.dbClose();
        }

        req.setAttribute("userBoard", userBoard);

        req.getRequestDispatcher("/board/UserBoardDetail.jsp").forward(req, res);
    }
}
