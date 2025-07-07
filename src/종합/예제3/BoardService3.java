package 종합.예제3; // pakage

import java.util.Scanner;

public class BoardService3 {    // class start
    public static void main(String[] args) {    // main start

        Scanner scan = new Scanner(System.in);  // Scanner

        Board[] boards = new Board[100];    // 배열 100개

        for( ; ; ){
            System.out.println("============= My Community =============");
            System.out.println("1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();
            if(choose == 1){
                System.out.print("작성자 : ");   String writerInput  = scan.next();
                System.out.print("내용 : ");    String contentInput = scan.next();

                Board board = new Board();  // 객체 new Board();
                board.content = contentInput;   board.writer = writerInput;
                boolean check = false;
                for(int i = 0; i < boards.length; i++){
                    if( boards[i] == null ){
                        boards[i] = board;
                        check = true;
                        break;
                    }   // if end
                }   // for end
                if(check){System.out.println("[안내] 글쓰기 성공"); }
                else{ System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");}
            }   // choose == 1 if end
            else if (choose == 2) {
                for(int i = 0; i< boards.length; i++){
                    if(boards[i] != null) {
                        System.out.println("============= 게시물 목록 =============");
                        System.out.println("작성자 : " + boards[i].writer);
                        System.out.println("내용 : " + boards[i].content);
                        System.out.println("------------------------------------");
                    } // if end
                } // for end

            }// choose == 2 if end
        }   // for 무한루프 end



    }   // main end


} // class end
class Board{
    String writer;
    String content;
}