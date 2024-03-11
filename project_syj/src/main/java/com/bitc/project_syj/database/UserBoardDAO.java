package com.bitc.project_syj.database;

import com.bitc.project_syj.utils.ErrorMessage;
import jakarta.servlet.ServletContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBoardDAO extends JDBConnect{
    public UserBoardDAO(){

    }

    public UserBoardDAO(ServletContext app){
        super(app);
    }

    public UserBoardDAO(String dbDriver, String dbUrl, String dbUserId, String dbUserPw){
        super(dbDriver, dbUrl, dbUserId, dbUserPw);
    }


//    전체 리스트 가져오기
    public List<UserBoardDTO> selectUserBoardList(){
        List<UserBoardDTO> userBoardList = new ArrayList<>();

        try {
            String sql = "SELECT board_idx, board_title, board_name, board_postdate, board_visitcount FROM tb_board ORDER BY board_idx DESC ";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){
                UserBoardDTO board = new UserBoardDTO();

                board.setBoard_idx(rs.getInt("board_idx"));
                board.setBoard_title(rs.getString("board_title"));
                board.setBoard_name(rs.getString("board_name"));
                board.setBoard_postdate(rs.getString("board_postdate"));
                board.setBoard_visitcount(rs.getInt("board_visitcount"));

                userBoardList.add(board);
            }

        }
        catch (SQLException e){
            ErrorMessage.printErrorMessage("조회", e.getMessage());
        }

        return userBoardList;
    }


    //    글쓰기
    public int insertUserBoard(UserBoardDTO board){
        int result = 0;

        try {
            String sql = "INSERT INTO tb_board (board_name, board_title, board_content, ofile, sfile, board_postdate) ";
            sql += "VALUES (?, ?, ?, ?, ?, NOW()) ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, board.getBoard_name());
            pstmt.setString(2, board.getBoard_title());
            pstmt.setString(3, board.getBoard_content());
            pstmt.setString(4, board.getOfile());
            pstmt.setString(5, board.getSfile());

            result = pstmt.executeUpdate();

        }
        catch (SQLException e){
            ErrorMessage.printErrorMessage("추가", e.getMessage());
        }

        return result;
    }

    //    상세 보기
    public UserBoardDTO selectUserBoardDetail(int boardIdx){
        UserBoardDTO board = new UserBoardDTO();

        try {
            String sql = "SELECT board_idx, board_title, board_name, board_content, board_postdate, ofile, sfile, board_visitcount ";
            sql += "FROM tb_board WHERE board_idx = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardIdx);

            rs = pstmt.executeQuery();

            while (rs.next()){
                board.setBoard_idx(rs.getInt("board_idx"));
                board.setBoard_title(rs.getString("board_title"));
                board.setBoard_name(rs.getString("board_name"));
                board.setBoard_content(rs.getString("board_content"));
                board.setBoard_postdate(rs.getString("board_postdate"));
                board.setOfile(rs.getString("ofile"));
                board.setSfile(rs.getString("sfile"));
                board.setBoard_visitcount(rs.getInt("board_visitcount"));
            }

        }
        catch (SQLException e){
            ErrorMessage.printErrorMessage("조회", e.getMessage());
        }

        return board;
    }

    //    수정하기
    public int updateUserBoard(UserBoardDTO board){
        int result = 0;

        try {
            String sql = "UPDATE tb_board SET board_title = ?, board_content = ?, ofile = ?, sfile = ? ";
            sql += "WHERE board_idx = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, board.getBoard_title());
            pstmt.setString(2, board.getBoard_content());
            pstmt.setString(3, board.getOfile());
            pstmt.setString(4, board.getSfile());
            pstmt.setInt(5, board.getBoard_idx());

            result = pstmt.executeUpdate();

        }
        catch (SQLException e){
            ErrorMessage.printErrorMessage("수정", e.getMessage());
        }

        return result;
    }

    //    삭제하기
    public int deleteUserBoard(int boardIdx){
        int result = 0;

        try {
            String sql = "DELETE FROM tb_board WHERE board_idx = ? ";

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
            String sql = "UPDATE tb_board SET board_visitcount = board_visitcount+ 1 WHERE board_idx = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardIdx);

            pstmt.executeUpdate();

        }
        catch (SQLException e){
            ErrorMessage.printErrorMessage("수정", e.getMessage());
        }
    }

}
