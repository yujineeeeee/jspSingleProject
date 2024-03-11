package com.bitc.project_syj.database;

import com.bitc.project_syj.utils.ErrorMessage;
import jakarta.servlet.ServletContext;

import java.sql.SQLException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class VisitBoardDAO extends JDBConnect{

    public VisitBoardDAO(){

    }

    public VisitBoardDAO(ServletContext app){
        super(app);
    }

    public VisitBoardDAO(String dbDriver, String dbUrl, String dbUserId, String dbUserPw){
        super(dbDriver, dbUrl, dbUserId, dbUserPw);
    }

    //    전체 리스트 가져오기
    public List<VisitBoardDTO> selectVisitBoardList(){
        List<VisitBoardDTO> visitBoardList = new ArrayList<>();

        try {
            String sql = "SELECT visit_idx, visit_name, visit_title, visit_postdate, visit_visitcount FROM tb_visit_board ORDER BY visit_idx DESC ";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){
                VisitBoardDTO board = new VisitBoardDTO();

                board.setVisit_idx(rs.getInt("visit_idx"));
                board.setVisit_title(rs.getString("visit_title"));
                board.setVisit_name(rs.getString("visit_name"));
                board.setVisit_postdate(rs.getString("visit_postdate"));
                board.setVisit_visitcount(rs.getInt("visit_visitcount"));

                visitBoardList.add(board);
            }

        }
        catch (SQLException e){
            ErrorMessage.printErrorMessage("조회", e.getMessage());
        }

        return visitBoardList;
    }


    //    글쓰기
    public int insertVisitBoard(VisitBoardDTO board){
        int result = 0;

        try {
            String sql = "INSERT INTO tb_visit_board (visit_name, visit_pw, visit_title, visit_content, visit_postdate) ";
            sql += "VALUES (? , ?, ? , ?, NOW()) ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, board.getVisit_name());
            pstmt.setString(2, board.getVisit_pw());
            pstmt.setString(3, board.getVisit_title());
            pstmt.setString(4, board.getVisit_content());

            result = pstmt.executeUpdate();

        }
        catch (SQLException e){
            ErrorMessage.printErrorMessage("추가", e.getMessage());
        }

        return result;
    }

    //    상세 보기
    public VisitBoardDTO selectVisitBoardDetail(int boardIdx){
        VisitBoardDTO board = new VisitBoardDTO();

        try {
            String sql = "SELECT visit_idx, visit_name, visit_pw, visit_title, visit_content, visit_postdate, visit_visitcount ";
            sql += "FROM tb_visit_board WHERE visit_idx = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardIdx);

            rs = pstmt.executeQuery();

            while (rs.next()){
                board.setVisit_idx(rs.getInt("visit_idx"));
                board.setVisit_title(rs.getString("visit_title"));
                board.setVisit_name(rs.getString("visit_name"));
                board.setVisit_content(rs.getString("visit_content"));
                board.setVisit_postdate(rs.getString("visit_postdate"));
                board.setVisit_visitcount(rs.getInt("visit_visitcount"));
            }

        }
        catch (SQLException e){
            ErrorMessage.printErrorMessage("조회", e.getMessage());
        }

        return board;
    }

    //    수정하기
    public int updateVisitBoard(VisitBoardDTO board){
        int result = 0;

        try {
            String sql = "UPDATE tb_visit_board SET visit_title = ?, visit_content = ? ";
            sql += "WHERE visit_idx = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, board.getVisit_title());
            pstmt.setString(2, board.getVisit_content());
            pstmt.setInt(3, board.getVisit_idx());

            result = pstmt.executeUpdate();

        }
        catch (SQLException e){
            ErrorMessage.printErrorMessage("수정", e.getMessage());
        }

        return result;
    }

    //    삭제하기
    public int deleteVisitBoard(int boardIdx){
        int result = 0;

        try {
            String sql = "DELETE FROM tb_visit_board WHERE visit_idx = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardIdx);

            result = pstmt.executeUpdate();

        }
        catch (SQLException e){
            ErrorMessage.printErrorMessage("삭제", e.getMessage());
        }

        return result;
    }

    //    조회수 올리기
    public void updateVisitCount(int boardIdx){
        try {
            String sql = "UPDATE tb_visit_board SET visit_visitcount = visit_visitcount+ 1  WHERE visit_idx = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardIdx);

            pstmt.executeUpdate();

        }
        catch (SQLException e){
            ErrorMessage.printErrorMessage("수정", e.getMessage());
        }
    }

//    게시글 비밀번호 확인
    public boolean checkPw(int boardIdx, String boardPw){
        boolean result = false;

        try {
            String sql = "SELECT COUNT(*) as cnt FROM tb_visit_board WHERE visit_idx = ? AND visit_pw = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardIdx);
            pstmt.setString(2, boardPw);

            rs = pstmt.executeQuery();

            while(rs.next()){
                if(rs.getInt("cnt") == 1){
                    result = true;
                }
            }
        }
        catch (SQLException e){
            ErrorMessage.printErrorMessage("조회", e.getMessage());
        }

        return result;
    }

}
