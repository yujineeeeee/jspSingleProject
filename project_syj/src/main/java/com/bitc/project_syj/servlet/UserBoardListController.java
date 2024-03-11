package com.bitc.project_syj.servlet;

import com.bitc.project_syj.database.UserBoardDAO;
import com.bitc.project_syj.database.UserBoardDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "userBoardList", value = "/blog/userBoardList.do")
public class UserBoardListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        UserBoardDAO dao = new UserBoardDAO();

        dao.dbOpen();
        List<UserBoardDTO> userBoardList = dao.selectUserBoardList();
        if(dao.isOpen()){
            dao.dbClose();
        }

        req.setAttribute("userBoardList", userBoardList);

//        req.getRequestDispatcher("/board/UserBoardList.jsp").forward(req, res);
        req.getRequestDispatcher("/board/UserBoardList.jsp").forward(req, res);
    }
}
