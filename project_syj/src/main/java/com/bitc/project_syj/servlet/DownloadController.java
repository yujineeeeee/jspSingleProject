package com.bitc.project_syj.servlet;

import com.bitc.project_syj.database.UserBoardDAO;
import com.bitc.project_syj.utils.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="download", value = "/blog/download.do")
public class DownloadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        String ofile = req.getParameter("ofile");
        String sfile = req.getParameter("sfile");
        int idx = Integer.parseInt(req.getParameter("idx"));

        FileUtil.download(ofile, sfile, "c:/upload", req, res);
    }
}
