package 종합.과제_JDBC.model;   // package

import java.sql.*;
import java.util.ArrayList;

public class WaitingDao {   // class start
    // 싱글톤 만들기
    private WaitingDao(){
        // 생성자 실행될 때 DB 연동
        connectDB();
    }
    private static final WaitingDao dao = new WaitingDao();
    public static WaitingDao getInstance(){return dao;}


    // DB에 대한 정보 받아오기
    private String db_url = "jdbc:mysql://localhost:3306/waitingList";  // DB 주소
    private String db_user = "root";                                    // 이름
    private String db_password = "1234";                                // 비밀번호

    // connection 연결 메소드
    private Connection getConnection() throws SQLException {            // SQLException 던지기
        return DriverManager.getConnection(db_url, db_user, db_password);   // DriverManager.getConnection(매개변수값 3개)
    }

    // 연동 함수

    public void connectDB (){
        try{
            // mysql 를 지정한 Driver 클래스 가져오기
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch ( ClassNotFoundException e ) { System.out.println("[실패] mysql 드라이버 연동 실패"); } // 클래스 있는지 잘 연결됐는지 예외
    }   // func end



    // 등록 메소드
    public boolean listWrite ( WaitingDto waitingDto ) {
        try {
            Connection conn = getConnection();                              // 연동 결과 갖는 Connection 인터페이스
            String sql = "insert into list(phone , count) values (?,?)";    // sql 작성
            PreparedStatement ps = conn.prepareStatement(sql);              // 연동된 인터페이스에 sql값 준 것을 대입
            ps.setString(1, waitingDto.getPhone());             // setString (인덱스값이 1이면 phone , ?에 들어갈 줄 값 );
            ps.setInt(2, waitingDto.getCount());                // setInt (list의 뭐에 넣을 건지 , values에 들어갈 값);

            int result = ps.executeUpdate();                                // executeUpdate(); INSERT , UPDATE , DELETE 중의 결과값을 int로 반환한다.

            return result == 1;      // 1은 한 행이 추가된것, 2는 두 행이 추가 된 것 즉, 난 한 행만 추가했으니 result 값이 1이면 true 나머지는 false
        } catch (SQLException e) {                                          // sql 연동 예외
            System.out.println("[경고] 데이터베이스 접근 실패");
            return false;                                                   // 예외 생기면 false 반환
        } catch (NullPointerException e) {                                  // 혹시나 null 값이 뜬다면? 예외
            System.out.println("[경고] null 뜸");
            return false;                                                   // 예외 생기면 false 반환
        } // catch end
    }   // func end

    // 리스트 반환 메소드
    public ArrayList<WaitingDto> listPrint () {                             // ArrayList<WaitingDto>를 반환하는 메소드
        String sql = "select phone , count , seq from list order by seq asc";   // sql의 값을 넣어줌 select 해서 가져온다. 번호 내림차순
        ArrayList<WaitingDto> list = new ArrayList<>();                         // 리스트 생성
        try {
            Connection conn = getConnection();                                  // sql과 연동 결과를 갖는 Connection 인터페이스
            PreparedStatement ps = conn.prepareStatement(sql);                  // 연동된 인터페이스에 sql 값을 넣어줌
            ResultSet rs = ps.executeQuery();                                   // executeQuery 는 SELECT 문법 실행결과를 ResultSet 타입 반환해줌
            while (rs.next()){                                                  // while 문은 해당 안 값이 false가 될 때까지 실행함
                WaitingDto dto = new WaitingDto();                              // 담을 dto 생성
                dto.setPhone( rs.getString("phone"));                   // setter 해서 값 할당
                dto.setCount( rs.getInt("count"));                      // ResultSet.getString -> 현재 레코드에서 지정한 속성명의 값을 반환하는 함수
                dto.setSeq( rs.getInt("seq"));                          // ResultSet.getInt 는 int값 반환 getString 은 문자열 반환이죠
                list.add(dto);                                                  // ArrayList<WaitingDto> 에 dto를 .add()
            } // while end
        } catch (SQLException e) {                                              // sql 연동 예외
            System.out.println("[경고] 데이터베이스에서 불러오기 실패");
        }   // catch end
        return list;                                                            // ArrayList 값 반환
    }   // func end
}   // class end
