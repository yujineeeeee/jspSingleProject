package com.bitc.project_syj.database;

public class VisitBoardDTO {
    private int visit_idx;
    private String visit_name;
    private String visit_pw;
    private String visit_title;
    private String visit_content;
    private String visit_postdate;
    private int visit_visitcount;

    public int getVisit_idx() {
        return visit_idx;
    }

    public void setVisit_idx(int visit_idx) {
        this.visit_idx = visit_idx;
    }

    public String getVisit_name() {
        return visit_name;
    }

    public void setVisit_name(String visit_name) {
        this.visit_name = visit_name;
    }

    public String getVisit_pw() {
        return visit_pw;
    }

    public void setVisit_pw(String visit_pw) {
        this.visit_pw = visit_pw;
    }

    public String getVisit_title() {
        return visit_title;
    }

    public void setVisit_title(String visit_title) {
        this.visit_title = visit_title;
    }

    public String getVisit_content() {
        return visit_content;
    }

    public void setVisit_content(String visit_content) {
        this.visit_content = visit_content;
    }

    public String getVisit_postdate() {
        return visit_postdate;
    }

    public void setVisit_postdate(String visit_postdate) {
        this.visit_postdate = visit_postdate;
    }

    public int getVisit_visitcount() {
        return visit_visitcount;
    }

    public void setVisit_visitcount(int visit_visitcount) {
        this.visit_visitcount = visit_visitcount;
    }
}
