package 종합.예제9.controller;  // package


import 종합.예제9.model.dao.BoardDao;
import 종합.예제9.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {  // class start
    // 싱글톤 만들기
    private BoardController(){}
    private static final BoardController boardController = new BoardController();
    public static BoardController getInstance(){
        return boardController;
    }

    // 싱글톤 가져오기 - controller는 dao만 호출할 수 있다.
    BoardDao dao = BoardDao.getInstance();


    // (1) 등록 - 관례적으로 dto는 컨트롤러에서 처리후 dao에 매개변수로 전달한다.
    public boolean boardWrite (String content , String writer) {
        BoardDto boardDto = new BoardDto(content , writer);
        return dao.boardWrite(boardDto);
    }   // func end

    // (2) 출력
    public ArrayList<BoardDto> boardPrint () {
        return dao.boardPrint();
    }   // func end

}   // class end
