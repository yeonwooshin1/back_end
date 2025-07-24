package market.model.dao;   // package


import market.model.dto.ProductDto;
import market.model.dto.RankingDto;
import market.model.dto.SearchDto;

import java.sql.*;
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



    // 중고 물품 등록
    public boolean productAdd( ProductDto dto ) {
        String sql = "insert into product( pSeller, pName , pContent , pPrice , pPassword ) " +
                "values (?,?,?,?,?)  ";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString(1, dto.getpSeller());
            ps.setString(2, dto.getpName());
            ps.setString(3, dto.getpContent());
            ps.setInt(4, dto.getpPrice());
            ps.setString(5, dto.getpPassword());
            int result = ps.executeUpdate();

            return result == 1;
        } catch (SQLException e) {
            System.out.println("[경고] 데이터베이스 등록 실패");
            return false;
        }   // catch end
    } // func end

    // 전체 물품 목록 조회
    public ArrayList<ProductDto> productPrint() {
        String sql = "select pNo , pName , pPrice , pSeller , pDate , pStatus from product order by pNo asc";
        ArrayList<ProductDto> productDB = new ArrayList<>();

        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                ProductDto dto = new ProductDto();

                dto.setpNo(rs.getInt("pNo"));
                dto.setpName(rs.getString("pName"));
                dto.setpPrice(rs.getInt("pPrice"));
                dto.setpSeller(rs.getString("pSeller"));
                dto.setpDate(rs.getString("pDate"));
                dto.setpStatus(rs.getInt("pStatus"));

                productDB.add(dto);
            }   // while end
        } catch (SQLException e) {
            System.out.println("[경고] 데이터베이스 조회 실패");
        }   // catch end
        return productDB;
    } // func end

    // 물품 정보 수정
    public boolean productUpdate( ProductDto dto ) {
        String sql = "update product set pName = ? , pContent = ? ," +
                " pPrice = ? , pStatus = ? where pNo = ?";

        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString(1, dto.getpName());
            ps.setString(2, dto.getpContent());
            ps.setInt(3, dto.getpPrice());
            ps.setInt(4, dto.getpStatus());
            ps.setInt(5, dto.getpNo());
            int result = ps.executeUpdate();

            return result == 1;
        } catch (SQLException e) {
            System.out.println("[경고] 데이터베이스 수정 실패");
            return false;
        }   // catch end
    } // func end

    // 등록 물품 삭제
    public boolean productDelete( ProductDto dto ) {
        String sql = "delete from product where pNo = ? and pPassword = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement( sql );

            ps.setInt(1, dto.getpNo());
            ps.setString(2 , dto.getpPassword());

            int result = ps.executeUpdate();

            return result == 1;
        } catch (SQLException e) {
            System.out.println("[경고] 데이터베이스 수정 실패");
            return false;
        }   // catch end
    } // func end

    // 물품 상세 조회
    public ProductDto productDetails(int pnoInput ) {
        String sql = "select pName , pPrice , pContent , pSeller , pDate , pStatus from product where pno = ?";
        ProductDto dto = new ProductDto();

        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement( sql );

            ps.setInt(1 ,pnoInput);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                dto.setpContent(rs.getString("pContent"));
                dto.setpName(rs.getString("pName"));
                dto.setpPrice(rs.getInt("pPrice"));
                dto.setpSeller(rs.getString("pSeller"));
                dto.setpDate(rs.getString("pDate"));
                dto.setpStatus(rs.getInt("pStatus"));
                return dto;
            }   // if end

        } catch (SQLException e) {
            System.out.println("[경고] 데이터베이스 조회 실패");
        }   // catch end
        return null;
    } // func end

    // 등록 랭킹 조회
    public ArrayList<RankingDto> rankingPrint() {
        String sql = "select pSeller , count(*) from product group by " +
                "pSeller order by count(*) desc , pSeller asc limit 0 , 10";

        ArrayList<RankingDto> rankingDB = new ArrayList<>();

        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                RankingDto dto = new RankingDto();
                dto.setpSeller(rs.getString("pSeller"));
                dto.setCount(rs.getInt("count(*)"));

                rankingDB.add(dto);
            }   // while end
        } catch (SQLException e) {
            System.out.println("[경고] 데이터베이스 조회 실패");
        }   // catch end
        return rankingDB;
    } // func end

    // 검색 조회
    public ArrayList<ProductDto> productSearch( SearchDto dto) {
        String value = dto.getValue();

        String sqlAnother = "select pName , pContent , pPrice , pSeller , pDate , " +
                "pStatus from product where " + value +" like ?";
        String sqlPrice = "select pName , pContent , pPrice , pSeller , pDate , pStatus from product where pPrice < ?";

        ArrayList<ProductDto> productDB = new ArrayList<>();

        try {
            Connection conn = getConnection();
            PreparedStatement ps;
            if (dto.getValue().equals("pPrice") ) {
                ps = conn.prepareStatement(sqlPrice);

                int search;
                try { search = Integer.parseInt(dto.getSearch()); }
                catch (NumberFormatException e) { return productDB; }    // 숫자로 타입변환 못할 때 예외

                ps.setInt(1, search);
            } else {
                ps = conn.prepareStatement(sqlAnother);

                ps.setString(1, "%"+ dto.getSearch() +"%");
            }   // if end
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                ProductDto productDto = new ProductDto();

                productDto.setpName(rs.getString("pName"));
                productDto.setpContent(rs.getString("pContent"));
                productDto.setpPrice(rs.getInt("pPrice"));
                productDto.setpSeller(rs.getString("pSeller"));
                productDto.setpDate(rs.getString("pDate"));
                productDto.setpStatus(rs.getInt("pStatus"));

                productDB.add(productDto);
            }   // while end
        } catch (SQLException e) {
            System.out.println("[경고] 데이터베이스 오류");
        }  // catch end
        return productDB;
    } // func end

    // 수정삭제 권한 유효성 검사
    public boolean identityCheck(ProductDto dto) {
        String sql = "select pNo from product where pNo = ? and pPassword = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setInt(1, dto.getpNo());
            ps.setString(2, dto.getpPassword());

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("[경고] 데이터베이스 조회 실패");
            return false;
        } // catch end
    }   // func end
}   // class end
