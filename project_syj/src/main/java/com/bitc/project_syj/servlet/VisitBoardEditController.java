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

@WebServlet(name = "visitBoardEdit", value = "/blog/visitBoardEdit.do")
public class VisitBoardEditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        int idx = Integer.parseInt(req.getParameter("idx"));

        VisitBoardDAO dao = new VisitBoardDAO();
        dao.dbOpen();



        req.setAttribute("visitBoard", dao.selectVisitBoardDetail(idx));
        if (dao.isOpen()) {
            dao.dbClose();
        }

        req.getRequestDispatcher("/board/VisitBoardEdit.jsp").forward(req, res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int idx = Integer.parseInt(req.getParameter("idx"));

        VisitBoardDTO visitBoard = new VisitBoardDTO();
        visitBoard.setVisit_idx(idx);
        visitBoard.setVisit_title(title);
        visitBoard.setVisit_content(content);

        VisitBoardDAO dao = new VisitBoardDAO();
        dao.dbOpen();

        int result = dao.updateVisitBoard(visitBoard);
        if (dao.isOpen()) {
            dao.dbClose();
        }

        if (result == 1) {
//            res.sendRedirect("/blog/visitBoardDetail.do?idx=" + idx);
            JSFunction.alertLocation("수정 되었습니다.", "/blog/visitBoardDetail.do?idx=" + idx, res);
        } else {
            JSFunction.alertLocation("게시글 수정이 실패했습니다. \n다시 진행해주세요.", "/blog/visitBoardDetail.do?idx=" + idx, res);
        }
    }

}
