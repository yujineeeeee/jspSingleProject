package com.bitc.project_syj.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "main", value = "/blog/main.do")
public class MainPageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException, ServletException {
        req.getRequestDispatcher("/Main.jsp").forward(req, res);
    }

}
