package 종합.예제8.controller;  // package

import 종합.예제8.model.BoardDao;
import 종합.예제8.model.BoardDto;

import java.util.ArrayList;

public class BoardController {  // class BoardController start
    // 싱글톤 만들기

    private BoardController(){};
    private static BoardController boardController = new BoardController();
    public static BoardController getInstance() {
        return boardController;
    }   // getter

    // 싱글톤 가져오기
    private BoardDao dao = BoardDao.getInstance();

    // addBoard

    public boolean addBoard (String content , String writer ){
        boolean result = false;
        result = dao.addBoard( content , writer );
        return result;
    }   // func end

    // getBoardList

    public ArrayList<BoardDto> getBoardList() {
        ArrayList< BoardDto > result = dao.getBoardList();
        return result;
    }   // func end

}   // class BoardController end
