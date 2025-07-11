package 종합.예제7.model.dao;


import 종합.예제7.model.dto.BoardDto;

// (역할) 실제 데이터가 존재하면 데이터 접근하는 기능 ( CRUD )
public class BoardDao { // class BoardDao
    // * (싱글톤)
    private BoardDao(){};

    private static final BoardDao dao = new BoardDao();

    public static BoardDao getInstance(){
        return dao;
    }


    // * 데이터베이스 : 추후에 데이터베이스로 변경할 예정
    private BoardDto[] boardDB = new BoardDto[100];

    // 1. 등록 처리 메소드 : controller 로 부터 db(배열)에 저장할 객체를 받아서 저장한다.
        // 매개변수 : BoardDto , 반환값 : boolean
    public boolean boardWrite( BoardDto boardDto ){
        for( int i = 0 ; i < boardDB.length; i++){
            if(boardDB[i] == null ){
                boardDB[i] = boardDto;
                return true;
            }
        }
        return false;   // 실패의 의미로 "false" 반환
    }   // func end
    // 2. 조회 처리 메소드 : controller 로 부터 모든 db(배열) 반환 한다.
        // 매개변수 X , 반환값 : BoardDto[]

    public BoardDto[] boardPrint(){
        return boardDB;
    } // func end

}   // class end
