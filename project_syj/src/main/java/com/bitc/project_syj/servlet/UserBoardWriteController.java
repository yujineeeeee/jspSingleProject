package com.bitc.project_syj.servlet;

import com.bitc.project_syj.database.UserBoardDAO;
import com.bitc.project_syj.database.UserBoardDTO;
import com.bitc.project_syj.utils.FileUtil;
import com.bitc.project_syj.utils.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "userBoardWrite", value = "/blog/userBoardWrite.do")
@MultipartConfig(maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 10)
public class UserBoardWriteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        HttpSession session = req.getSession();

        if(session.getAttribute("userId") == null){
            JSFunction.alertBack("로그인 후 이용해 주세요", res);
            return;
        }

        req.getRequestDispatcher("/board/UserBoardWrite.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        UserBoardDTO userBoard = new UserBoardDTO();

        userBoard.setBoard_name(req.getParameter("name"));
        userBoard.setBoard_title(req.getParameter("title"));
        userBoard.setBoard_content(req.getParameter("content"));

//        파일 처리하기
        String saveDir = "c:/upload";
        String originalFileName = "";

        try {
            originalFileName = FileUtil.uploadFile(req, saveDir);
        }
        catch (Exception e){
            JSFunction.alertLocation("파일 업로드 오류가 발생했습니다.", "/blog/userBoardWrite.do", res);
            return;
        }

        if(!originalFileName.equals("")){
            String saveFileName = FileUtil.renameFile(originalFileName, saveDir);

            userBoard.setOfile(originalFileName);
            userBoard.setSfile(saveFileName);
        }

        UserBoardDAO dao = new UserBoardDAO();
        dao.dbOpen();
        int result = dao.insertUserBoard(userBoard);
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
