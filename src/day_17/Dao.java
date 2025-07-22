package day_17; // package

// Data Access Object : 데이터(데이터베이스/파일) 접근 객체

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {  // class start
    // (!) 싱글톤
    private Dao(){
        connectDB();     // Dao 객체가 생성될 때 DB 연동
    }
    private static final Dao dao = new Dao();
    public static Dao getInstance() {
        return dao;
    }

    // (!) DB 연동에 필요한 정보
    private String db_url = "jdbc:mysql://localhost:3306/mydb0722";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;            // DB 연동 인터페이스

    // (1) 연동 함수
    public void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // mysql 드라이버/클래스 로드 함수
            conn = DriverManager.getConnection(db_url , db_user ,db_password);

        }
        catch (ClassNotFoundException e) { System.out.println("[실패] mysql 드라이버 연동 실패"); }
        catch (SQLException e) { System.out.println("[실패] 데이터베이스 연동 실패"); } // catch end
    }   // func end
}   // class end
