package 종합.예제8.model;   // package

import java.util.ArrayList;

public class BoardDao { // class BoardDao start
    // 싱글톤 만들기
    private BoardDao(){}
    private static BoardDao boardDao = new BoardDao();
    public static BoardDao getInstance() {
        return boardDao;
    }

    // 매개변수
    ArrayList< BoardDto > boardDB = new ArrayList<>();  // 빈 ArrayList

    // 넣기
    public boolean addBoard ( String content , String writer ){
        boolean result = false;

        BoardDto boardDto = new BoardDto( content , writer );
        boardDB.add(boardDto);

        result = true;

        return result;
    }   // func end

    // ArrayList 반환

    public ArrayList<BoardDto> getBoardList(){
        return boardDB; // return ArrayList<BoardDto>
    }   // func end


}   // class BoardDao end
