package com.bitc.project_syj.database;

import com.bitc.project_syj.utils.ErrorMessage;
import jakarta.servlet.ServletContext;

public class MemberDAO extends JDBConnect{

    public MemberDAO(){

    }

    public MemberDAO(ServletContext app){
        super(app);
    }

    public MemberDAO(String dbDriver, String dbUrl, String dbUserId, String dbUserPw){
        super(dbDriver, dbUrl, dbUserId, dbUserPw);
    }



//    회원 가입
    public int insertMember(MemberDTO member){
        int result = 0;

        try {
            String sql = "INSERT INTO tb_user (user_id, user_pw, user_name, user_email, user_phone, user_regidate) ";
            sql += "VALUES (?, ?, ?, ?, ?, NOW()) ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getUser_id());
            pstmt.setString(2, member.getUser_pw());
            pstmt.setString(3, member.getUser_name());
            pstmt.setString(4, member.getUser_email());
            pstmt.setString(5,member.getUser_phone());

            result = pstmt.executeUpdate();
        }
        catch (Exception e){
            ErrorMessage.printErrorMessage("삽입", e.getMessage());
        }

        return result;
    }

//    회원 가입 여부 확인
    public boolean isMemeber(String userId, String userPw){
        boolean result = false;

        try {
            String sql = "SELECT COUNT(*) AS cnt FROM tb_user WHERE user_id = ? AND user_pw = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, userPw);

            rs = pstmt.executeQuery();

            while(rs.next()){
                if(rs.getInt("cnt") == 1){
                    result = true;
                }
            }

        }
        catch (Exception e){
            ErrorMessage.printErrorMessage("조회", e.getMessage());
        }

        return result;
    }

//    회원 정보 보기
    public MemberDTO selectMember(String userId){
        MemberDTO member = new MemberDTO();

        try {
            String sql = "SELECT user_id, user_name, user_email, user_phone, user_regidate FROM tb_user WHERE user_id = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            while(rs.next()){
                member.setUser_id(rs.getString("user_id"));
                member.setUser_name(rs.getString("user_name"));
                member.setUser_email(rs.getString("user_email"));
                member.setUser_phone(rs.getString("user_phone"));
                member.setUser_regidate(rs.getString("user_regidate"));
            }

        }
        catch (Exception e){
            ErrorMessage.printErrorMessage("조회", e.getMessage());
        }

        return member;
    }

//    회원 정보 수정
    public int updateMember(MemberDTO member){
        int result = 0;

        try {
            String sql = "UPDATE tb_user SET user_pw = ?, user_name = ?, user_email = ?, " ;
            sql += "user_phone = ? WHERE user_id = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getUser_pw());
            pstmt.setString(2, member.getUser_name());
            pstmt.setString(3, member.getUser_email());
            pstmt.setString(4, member.getUser_phone());
            pstmt.setString(5, member.getUser_id());

            result = pstmt.executeUpdate();

        }
        catch (Exception e){
            ErrorMessage.printErrorMessage("수정", e.getMessage());
        }

        return result;
    }

//    회원 탈퇴
    public void deleteMember(String userId, String userPw){
        try {
            String sql = "DELETE FROM tb_user WHERE user_id = ? AND user_pw = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, userPw);

        }
        catch (Exception e){
            ErrorMessage.printErrorMessage("삭제", e.getMessage());
        }
    }

//    id 중복 확인
    public boolean idCheck(String userId){
        boolean result = false;

        try {
            String sql = "SELECT COUNT(*) AS cnt FROM tb_user WHERE user_id = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            while(rs.next()){
                if(rs.getInt("cnt") == 1){
                    result = true;
                }
            }
        }
        catch (Exception e){
            ErrorMessage.printErrorMessage("조회", e.getMessage());
        }

        return result;
    }

}
