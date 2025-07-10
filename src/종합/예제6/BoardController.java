package 종합.예제6; // package

import day_09.package1.B;

// (2) 컨트롤러 : 기능/제어
class BoardController { // class start
    // 1. 멤버변수
    private static final Board[] boards = new Board[100];
        // private  : 현재 클래스에서만 접근 키워드
        // static   : 객체 없이 접근 가능한 키워드
        // final    : 수정 불가능 키워드
    // 2. 생성자
    // 3. 메소드
    // 1) 등록 메소드 : public : 다른 클래스에서 접근
    public static boolean doPost( String content , String writter ){
        Board board = new Board( content , writter );

        // (2) 배열(boards)내 빈공간을 찾아서 생성한 객체 대입한다.

        for(int i =0; i< boards.length; i++){
            if ( boards[i] == null){
                boards[i] = board;
                return true;    // 저장성공을 뜻을 true로 부여하여 반환
            }   // if end
        }   // for i end
        return false;   // 저장실패 뜻을 false로 부여하여 반환
    }   // func end
    // 조회메소드
    public static Board[] doGet(){
        return boards;
    }   // func end

}   // class end
