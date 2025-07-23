package 종합.예제10.controller; // package

import 종합.예제10.model.dao.BoardDao;
import 종합.예제10.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {  // class start
    // 싱글톤 만들기
    private BoardController(){}
    private static final BoardController controller = new BoardController();
    public static BoardController getInstance() {
        return controller;
    }

    // 싱글톤 가져오기
    BoardDao dao = BoardDao.getInstance();

    // Board 등록 메소드
    public boolean BoardWrite( String bcontent ,String bwriter ) {
        BoardDto dto = new BoardDto( bcontent , bwriter );

        return dao.BoardWrite( dto );
    }   // func end

    // Board 출력 메소드
    public ArrayList<BoardDto> BoardPrint() {
        return dao.BoardPrint();
    }   // func end

    // Board 삭제 메소드
    public boolean BoardDelete( int bno ) {
        return dao.BoardDelete( bno );
    }   // func end

    // Board 수정 메소드
    public boolean BoardUpdate( int bno, String bcontent ) {
        BoardDto dto = new BoardDto(bno , bcontent);

        return dao.BoardUpdate(dto);
    }   // func end

}   // class end

