package com.bitc.project_syj.database;

public class UserBoardDTO {
    private int board_idx;
    private String board_name;
    private String board_title;
    private String board_content;
    private String board_postdate;
    private String ofile;
    private String sfile;
    private int board_visitcount;

    public int getBoard_idx() {
        return board_idx;
    }

    public void setBoard_idx(int board_idx) {
        this.board_idx = board_idx;
    }

    public String getBoard_name() {
        return board_name;
    }

    public void setBoard_name(String board_name) {
        this.board_name = board_name;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    public String getBoard_content() {
        return board_content;
    }

    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }

    public String getBoard_postdate() {
        return board_postdate;
    }

    public void setBoard_postdate(String board_postdate) {
        this.board_postdate = board_postdate;
    }

    public String getOfile() {
        return ofile;
    }

    public void setOfile(String ofile) {
        this.ofile = ofile;
    }

    public String getSfile() {
        return sfile;
    }

    public void setSfile(String sfile) {
        this.sfile = sfile;
    }

    public int getBoard_visitcount() {
        return board_visitcount;
    }

    public void setBoard_visitcount(int board_visitcount) {
        this.board_visitcount = board_visitcount;
    }
}
