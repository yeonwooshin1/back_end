package 종합.예제4; // pakage

import java.util.Scanner;

public class BoardService4 {    // class start
    public static void main(String[] args) {    // main start

        Scanner scan = new Scanner(System.in);

        BoardController bs = new BoardController();

        for( ; ; ){
            System.out.println("============= My Community =============");
            System.out.println("1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 ){
                System.out.print("작성자 : ");   String writerInput  = scan.next();
                System.out.print("내용 : ");    String contentInput = scan.next();
                boolean alert = bs.doPost( contentInput, writerInput );
                if(alert){System.out.println("[안내] 등록 성공"); }
                else{ System.out.println("[경고] 등록 실패");}
            }   // if choose == 1 end
            if(choose == 2){
                Board[] boardArray = bs.doGet();
                for(Board board : boardArray){
                    if( board != null ){
                        System.out.println("============= 게시물 목록 =============");
                        System.out.println("작성자 : " + board.writer);
                        System.out.println("내용 : " + board.content);
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
