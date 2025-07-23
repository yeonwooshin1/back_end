package day_18;

import java.sql.*;

public class UserDao {
    // 관례적인 MVC 패턴에서의 (협업) 용어
    // D : DATA     데이터 ( 데이터베이스/DB )
    // A : ACCESS   접근
    // O : OBJECT   객체
    // (1) 데이터베이스 연동 코드(함수/메소드)
    private String db_url = "jdbc:mysql://localhost:3306/mydb0723"; // 연동할 DB서버의 주소 = jdbc:mysql://IP번호:PORT번호/DB명
    private String db_user = "root";                                // DB서버의 계정명    = root
    private String db_password = "1234";                            // DB서버의 비밀번호  = 1234
    private Connection conn ; // DB연동 결과를 조작하는 인터페이스 , import 주의 , java.sql
    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 1. MYSQL 드라이버/클래스 불러오기
            conn = DriverManager.getConnection( db_url , db_user , db_password );// 2. MYSQL DB서버 연동
        }
        catch ( ClassNotFoundException e ){  System.out.println("[경고] MYSQL 라이브러리 로드 실패");  }
        catch ( SQLException e ){ System.out.println("[경고] DB 서버와 연동 실패 "); }
    } // func end

    // (*) 싱글톤 : 주로 프로그램내 하나(싱글)의 객체(톤) 표현
    private UserDao(){ connect(); } // 싱글톤 생성시 connect 함수가 실행
    private static final UserDao instance = new UserDao();
    public static UserDao getInstance(){
        return instance;
    }

    // -> 주로 MVC패턴 에서 싱글톤 사용하는 레이어/계층 : view/controller/dao
    // 왜? 기능은 하나만 있어도 재사용 가능하니까. 즉] 메소드 위주  , 요리사사람1명 , 서빙사람1명
    // -> D(데이터)T(이동)O(객체) 에서는 싱글톤 사용하지 않는다.
    // 왜? 데이터(회원정보)1개만 존재하지 않는다. 즉] 멤버변수 위주

    // (2) 연동 성공 이후에 사용할 DML(테이블 조작) 하기
    // 1) USER 테이블에 INSERT 해보기
    public boolean userInsert( ){
        try {
            // 1. SQL 작성 - String sql = "SQL문법";
            String sql = "insert into user(uname,uage) values( '유재석' , 40 ); ";
            // 2. SQL 기재 - PreparedStatement ps = conn.prepareStatement( sql );
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 실행 - int count = ps.executeUpdate();
            int count = ps.executeUpdate(); // SQL 실행 결과 몇개의 INSERT 레코드를 했는지 반환
            // 4. SQL 결과 에 따른 확인/로직/리턴
            System.out.println( count );
            if( count >= 1 ) return true; // 성공
            else return false; // 실패
        } catch (Exception e) { System.out.println(e); }
        return false; // 실패
    }

    // 2) USER 테이블에 INSERT 해보기2 : 매개변수 사용
    public boolean userInsert2( String uname , int uage ){
        try {
            // 1. SQL 작성하기 , ?:sql에 들어갈 매개변수
            String sql = "insert into user(uname,uage) values( ? , ? )";
            // 2. SQL 기재하기
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL ?매개변수 대입하기 , set:저장 , get:호출
            // ps.setXXX( ?번호 , 값 ) : XXX 타입으로 ?번째에 값 대입
            ps.setString( 1 , uname );
            // SQL 문법내 첫번째 ?에 uname 변수값을 String 타입으로 대입한다.
            ps.setInt( 2 , uage );
            // SQL 문법내 두번쨰 ?에 uage 변수값을 int 타입으로 대입한다.
            // 4. SQL 실행하기
            int count =  ps.executeUpdate();
            // 5. SQL 결과에 따른 확인/로직/리턴
            if( count >= 1 ) return true; // 결과가 1이상 이면 성공
            return false; // 결과가 1미만이면 실패
        } catch (Exception e) { System.out.println(e); }
        return false; // 예외(catch) 발생하면 실패
    } // func end

    // 3) USER 테이블에 select 해보기
    public void userSelect(){
        try {
            // 1. SQL 작성하기
            String sql = "select * from user; ";
            // 2. SQL 기재하기
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입< ? 없으면 생략>
            // 4. SQL 실행하기
            // insert/update/delete -> 레코드 처리 개수(int) -> executeUpdate()
            // select -> 레코드 조회 (결과)테이블 -> executeQuery();
            ResultSet rs = ps.executeQuery();
            // ResultSet 조회결과 조작 인터페이스, import 주의 , java.sql
            // rs.next() : 조회결과 에서 레코드/행/가로 하나씩 조회/이동 함수
            // rs.getXXX( 가져올속성명 또는 순서번호 ); : 현재 레코드의 속성/열/컬럼 의 값 반환
            // 5. SQL 결과에 따른 로직/리턴/확인
            while ( rs.next() ){ // -- 다음 레코드가 존재하지 않을때 까지 반복
                // (1) 현재 순회/반복 중인 레코드의 열/속성/컬럼 값 반환
                System.out.printf("번호 : %d, 이름 : %s , 나이 : %s \n",
                        rs.getInt(1) , // -- 첫번째 열/속성/컬럼 의 값 반환
                        rs.getString( 2 ) , // - 두번째 열의 의 값 반환
                        rs.getInt(3) ); // - 세번째 열의 값 반환
                // (2) 현재 순회/반복 중인 레코드의 열/속성/컬럼 값을 DTO로 구성
                // CSV/데이터베이스 : 테이블 처럼 행과 열로 구성
                // 자바 : 객체지향 구성 , 즉] 레코드/행 1개 == 객체1개 , 여러개 레코드/행 == 리스트/배열
            }
        } catch (Exception e) { System.out.println( e ); }
    } // func end
} // class end