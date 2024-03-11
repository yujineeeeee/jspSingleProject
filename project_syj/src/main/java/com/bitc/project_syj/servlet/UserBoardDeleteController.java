package com.bitc.project_syj.servlet;

import com.bitc.project_syj.database.UserBoardDAO;
import com.bitc.project_syj.utils.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "userBoardDelete", value = "/blog/userBoardDelete.do")
public class UserBoardDeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession session = req.getSession();

        int idx = Integer.parseInt(req.getParameter("idx"));
        String id = req.getParameter("name");

        if (session.getAttribute("userId") == null) {
            JSFunction.alertBack("로그인 후 이용 가능합니다.", res);
            return;
        }


        if (id.equals(session.getAttribute("userId").toString()) == false) {
            JSFunction.alertBack("작성자만 삭제 할 수 있습니다.", res);
        } else {
            UserBoardDAO dao = new UserBoardDAO();
            dao.dbOpen();

            int result = dao.deleteUserBoard(idx);
            if (dao.isOpen()) {
                dao.dbClose();
            }

            if (result == 1) {
                JSFunction.alertLocation("게시물이 삭제되었습니다.", "/blog/main.do", res);

            } else {
                JSFunction.alertBack("게시물 삭제 중 오류가 발생했습니다.", res);
            }
        }
    }
}
