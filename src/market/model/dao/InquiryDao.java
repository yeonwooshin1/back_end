package market.model.dao;


import market.model.dto.InquiryDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    }   // func end

    // 익명 db 가져오기
    public ArrayList<InquiryDto> inquiryDetails(int pnoInput ) {

    }   // func end

}   // class end
