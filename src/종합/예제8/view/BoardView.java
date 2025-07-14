package 종합.예제8.view;

import 종합.예제8.controller.BoardController;
import 종합.예제8.model.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {    // class BoardView start
    // 싱글톤 만들기

    private BoardView(){}
    private static BoardView view = new BoardView();
    public  static BoardView getInstance( ){
        return view;
    }   // getter

    // 싱글톤 가져오기

    private BoardController controller = BoardController.getInstance();

    // SCAN

    Scanner scan = new Scanner(System.in);

    // 메인 view

    public void index(){
        for (;;){
            System.out.println("============= My Community =============");// (2) 출력
            System.out.println("  1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 )           addBoard();
            else if ( choose == 2 )     getBoardList();
        }   // 무한 for문 end
    }   // func end

    // 등록 addBoard 메소드

    public void addBoard (){
        System.out.print("내용 : ");      String content = scan.next();
        System.out.print("작성자 : ");     String writer = scan.next();

        boolean alert = controller.addBoard( content , writer );

        if(alert) System.out.println("[안내] 글쓰기 성공");
        else System.out.println("[경고] 글쓰기 실패");
    }   // func choose 1 ,addBoard end


    // 출력 getBoardList 메소드

    public void getBoardList (){
        System.out.println("============= 게시물 목록 =============");

        ArrayList< BoardDto > boardDto = controller.getBoardList();

        for(BoardDto dto : boardDto ){
            System.out.println("작성자 : " + dto.getWriter()) ;
            System.out.println("내용 : " + dto.getContent()) ;
            System.out.println("------------------------------------");
        }   // for end
    }   // func choose 2 ,addBoard end

}   // class BoardView end
