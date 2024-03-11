package com.bitc.project_syj.database;

import jakarta.servlet.ServletContext;

import java.sql.*;

public class JDBConnect {
    protected Connection conn;
    protected Statement stmt;
    protected PreparedStatement pstmt;
    protected ResultSet rs;

    private String dbDriver;
    private String dbUrl;
    private String dbUserId;
    private String dbUserPw;
    protected boolean dbIsOpen = false;

    public JDBConnect() {
        this(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/project_db_syj?characterEncoding=UTF-8&serverTimezone=UTC",
                "test1",
                "fullstack501"
        );
    }

    public JDBConnect(ServletContext app) {
        this(
                app.getInitParameter("MySqlDriver"),
                app.getInitParameter("MySqlUrl"),
                app.getInitParameter("MySqlUserId"),
                app.getInitParameter("MySqlUserPw")
        );
    }

    public JDBConnect(String dbDriver, String dbUrl, String dbUserId, String dbUserPw) {
        this.dbDriver = dbDriver;
        this.dbUrl = dbUrl;
        this.dbUserId = dbUserId;
        this.dbUserPw = dbUserPw;
    }

    public boolean isOpen() {
        return this.dbIsOpen;
    }

    public void dbOpen() {
        try {
            Class.forName(this.dbDriver);
            conn = DriverManager.getConnection(this.dbUrl, this.dbUserId, this.dbUserPw);
            this.dbIsOpen = true;
            System.out.println("----- 데이터 베이스가 연결되었습니다. -----");
        }
        catch (Exception e) {
            this.dbIsOpen = false;
            System.out.println("----- 데이터 베이스 연결이 실패하였습니다. -----");
            System.out.println(e.getMessage());
        }
    }

    public void dbClose() {
        try {
            if (rs != null) { rs.close(); }
            if (stmt != null) { stmt.close(); }
            if (pstmt != null) { pstmt.close(); }
            if (conn != null) { conn.close(); }
            this.dbIsOpen = false;
            System.out.println("----- 데이터 베이스 리소스를 모두 해제하였습니다. -----");
        }
        catch (Exception e) {
            System.out.println("----- 데이터 베이스 리소스 해제 중 오류가 발생했습니다.");
        }
    }
}