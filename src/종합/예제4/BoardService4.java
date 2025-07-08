package 종합.예제4; // pakage

import java.util.Scanner;

public class BoardService4 {    // class start
    public static void main(String[] args) {    // main start

        Scanner scan = new Scanner(System.in);  // Scanner 하는 거 부여한다 어디다가? scan이라는 변수에다가

        BoardController bs = new BoardController();     // BoardController 클래스를 갖다써줄 객체( 클래스 분신 )를 부여한다 어디다가? bs라는 변수에다가

        for( ; ; ){
            System.out.println("============= My Community =============");
            System.out.println("1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 ){
                System.out.print("작성자 : ");   String writerInput  = scan.next();
                System.out.print("내용 : ");    String contentInput = scan.next();
                boolean alert = bs.doPost( contentInput, writerInput ); // boolean 타입인 메소드인 doPost를 데려오는데 매개변수는 scan받은 Writer와 content를 넣어줌 그것을 alert라는 변수에 할당
                if(alert){System.out.println("[안내] 등록 성공"); }   // alert가 true라면 등록 성공
                else{ System.out.println("[경고] 등록 실패");}    // alert가 false라면 등록 실패
            }   // if choose == 1 end
            if(choose == 2){
                Board[] boardArray = bs.doGet();        // 반환값이 Board[] 배열인 doGet을 가져오는데 변수는 boardArray에다가
                for(Board board : boardArray){          // boardArray == 배열을 모두 반복하는 반복문 돌리는데 그것의 인자들은 board
                    if( board != null ){
                        System.out.println("============= 게시물 목록 =============");
                        System.out.println("작성자 : " + board.writer);    // board 객체에 있는 멤버변수 writer를 가져온다.
                        System.out.println("내용 : " + board.content);     // board 객체에 있는 멤버변수 content를 가져온다.
                        System.out.println("------------------------------------");
                    }   // if end
                }   // for i end
            }   // if choose==2 end
        }   // for end

    }   // main end
}   // class end

class Board{
    // 멤버변수
    String content;
    String writer;
}   // class Board end

class BoardController{
    Board[] boards = new Board[100];

    // 등록 메소드
    boolean doPost(String content, String writer){

        Board board = new Board();
        board.content = content;
        board.writer = writer;
        for(int i = 0 ; i < boards.length; i++ ){
            if(boards[i] == null){
                boards[i] = board;
                return true;
            }   // if end
        }   // for i end
        return false;
    }   // func end

    // 조회 메소드
    Board[] doGet(){
        return boards;
    }   // func end
}
