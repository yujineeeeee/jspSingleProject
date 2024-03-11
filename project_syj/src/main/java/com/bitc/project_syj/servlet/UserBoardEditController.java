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

import java.io.IOException;
import java.rmi.server.ExportException;

@WebServlet(name = "userBoardEdit", value = "/blog/userBoardEdit.do")
@MultipartConfig(maxRequestSize = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 1)
public class UserBoardEditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        HttpSession session = req.getSession();

        int idx = Integer.parseInt(req.getParameter("idx"));
        String id = req.getParameter("name");

        if (session.getAttribute("userId") == null) {
            JSFunction.alertBack("로그인 후 이용 가능합니다.", res);
            return;
        }

        if(id.equals(session.getAttribute("userId").toString()) == false){
            JSFunction.alertBack("작성자만 수정할 수 있습니다.", res);
            return;

        }else {
            UserBoardDAO dao = new UserBoardDAO();
            dao.dbOpen();

            req.setAttribute("userBoard", dao.selectUserBoardDetail(idx));
            if(dao.isOpen()){
                dao.dbClose();
            }
        }

        req.getRequestDispatcher("/board/UserBoardEdit.jsp").forward(req, res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int idx = Integer.parseInt(req.getParameter("idx"));
        String oldSaveFile = req.getParameter("oldSaveFile");

        UserBoardDTO userBoard = new UserBoardDTO();
        userBoard.setBoard_idx(idx);
        userBoard.setBoard_title(title);
        userBoard.setBoard_content(content);

        String saveDir = "C:/upload";
        String oriFileName = "";
        try {
            oriFileName = FileUtil.uploadFile(req, saveDir);
        }
        catch (ExportException e){
            JSFunction.alertBack("파일 업로드 중 오류 발생.", res);
            return;
        }

        if(!oriFileName.equals("")){
            String saveFileName = FileUtil.renameFile(oriFileName, saveDir);

            userBoard.setOfile(oriFileName);
            userBoard.setSfile(saveFileName);

            FileUtil.deleteFile(saveDir, oldSaveFile);
        }

        UserBoardDAO dao = new UserBoardDAO();
        dao.dbOpen();

        int result = dao.updateUserBoard(userBoard);
        if(dao.isOpen()){
            dao.dbClose();
        }

        if(result == 1){
            res.sendRedirect("/blog/userBoardDetail.do?idx=" + idx);
        }else {
            JSFunction.alertLocation("게시글 수정이 실패했습니다. \n다시 진행해주세요.", "/blog/userBoardDetail.do?idx="+idx, res );
        }
    }
}
