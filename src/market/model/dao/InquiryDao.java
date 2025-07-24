package market.model.dao;


import market.model.dto.InquiryDto;

import java.sql.*;
import java.util.ArrayList;

public class InquiryDao {   // class start
    // 싱글톤 생성
    private InquiryDao(){
        connectDB ();   // 드라이버 연동
    }
    private static final InquiryDao inquiryDao = new InquiryDao();
    public static InquiryDao getInstance() {
        return inquiryDao;
    }

    // DB 정보입력
    private String db_url = "jdbc:mysql://localhost:3306/marketDB";
    private String db_user = "root";
    private String db_password = "1234";

    // Connection 연결 메소드
    private Connection getConnection () throws SQLException {
        return DriverManager.getConnection( db_url , db_user , db_password );
    }   // func end

    // MySQL 드라이버 클래스 연동
    private void connectDB () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch ( ClassNotFoundException e) {
            System.out.println("[경고] mysql 드라이버 연동 실패 ");
        }   // catch end
    }   // func end


    // 익명 문의 남기기
    public boolean inquiryAdd ( InquiryDto dto ) {
        String sql = "insert into inquiry( iName, iContent , iPassword , pNo )" +
                " values (?,?,?,?)   ";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(4, dto.getpNo());
            ps.setString(1, dto.getiName());
            ps.setString(2, dto.getiContent());
            ps.setString(3, dto.getiPassword());

            int result = ps.executeUpdate();

            return result == 1;
        } catch (SQLIntegrityConstraintViolationException  e) {
            System.out.println("[경고] 존재하지 않는 상품 번호입니다.");
            return false;
        } catch (SQLException e) {
            System.out.println("[경고] 데이터베이스 등록 실패 ");
            return false;
        }  // catch end
    }   // func end

    // 익명 db 가져오기
    public ArrayList<InquiryDto> inquiryDetails(int pnoInput ) {
        String sql = "select iName , iContent from inquiry where pNo = ?";
        ArrayList<InquiryDto> inquiryDB = new ArrayList<>();

        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, pnoInput);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                InquiryDto dto = new InquiryDto();
                dto.setiName(rs.getString("iName"));
                dto.setiContent(rs.getString("iContent"));

                inquiryDB.add(dto);
            }   // while end
        } catch (SQLException e) {
            System.out.println("[실패] 데이터베이스 불러오기 실패");
        }   // catch end
        return inquiryDB;
    }   // func end

}   // class end
