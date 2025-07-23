package 종합.예제10.model.dao;  // package

public class BoardDao { // class start
    // 싱글톤 만들기
    private BoardDao(){}
    private static final BoardDao dao = new BoardDao();
    public static BoardDao getInstance() {
        return dao;
    }
    // DB 정보입력

    // Connection 연결 메소드

    // DB 연동 메소드 Class.forName("com.mysql.cj.jdbc.Driver");

    // Board 등록 메소드

    // Board 출력 메소드

    // Board 삭제 메소드

    // Board 수정 메소드


}   // class end
