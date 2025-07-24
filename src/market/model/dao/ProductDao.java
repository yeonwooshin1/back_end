package market.model.dao;   // package


import market.model.dto.ProductDto;
import market.model.dto.RankingDto;
import market.model.dto.SearchDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {   // class start
    // 싱글톤 생성
    private ProductDao(){
        connectDB(); // mysql 드라이버 연동
    }
    private static final ProductDao productDao = new ProductDao();
    public static ProductDao getInstance() {
        return productDao;
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
    // productDetails 유효한지 확인이 필요 안되면 숫자 잘못입력으로 처리함


    // 중고 물품 등록
    public boolean productAdd( ProductDto dto ) {

    } // func end

    // 전체 물품 목록 조회
    public ArrayList<ProductDto> productPrint() {

    } // func end

    // 물품 정보 수정
    public boolean productUpdate( ProductDto dto ) {

    } // func end

    // 등록 물품 삭제
    public boolean productDelete( ProductDto dto ) {

    } // func end

    // 물품 상세 조회
    public ProductDto productDetails(int pnoInput ) {

    } // func end

    // 등록 랭킹 조회
    public ArrayList<RankingDto> rankingPrint() {

    } // func end

    // 검색 조회
    public ArrayList<ProductDto> productSearch( SearchDto dto) {

    } // func end

    // 수정삭제 권한 유효성 검사
    public boolean identityCheck(ProductDto dto) {

    }   // func end
}   // class end
