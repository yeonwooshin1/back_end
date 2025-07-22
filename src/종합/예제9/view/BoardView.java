package 종합.예제9.view;    // package

import 종합.예제9.controller.BoardController;
import 종합.예제9.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardView {    // class start
    // 싱글톤 만들기
    private BoardView(){}
    private static final BoardView boardView = new BoardView();
    public static BoardView getInstance(){
        return boardView;
    }

    // 싱글톤 가져오기
    BoardController controller = BoardController.getInstance();
    // Scanner 객체
    private Scanner scan = new Scanner(System.in);

    // 메인 view
    public void index(){
        for( ; ; ) {
            System.out.println("============= My Community =============");
            System.out.println("  1.등록 | 2.전체조회 ");
            System.out.println("========================================");
            System.out.print("선택 > ");
            try {
                int choose = scan.nextInt();
                if (choose == 1) BoardWrite();
                else if (choose == 2) BoardPrint();
                else System.out.println("번호를 다시 입력해주세요.");
            } catch (InputMismatchException e) {    // scan 값 예외처리

                scan.nextLine();            // 예외처리 후 nextLine 으로 예외난 부분 비워줌
                // -> nextLine()은 공백 , \n 까지 다 비워준다.
                // -> nextInt() 같은 애들은 123\n 같은 값을 남긴다.
                // -> \n = 엔터다. nextLine()으로 오류난 값을 완전 비워줘야 한다.
                // -> next() 같은 애들은 \n까지 처리하지는 못해 안전성이 떨어진다.
                // ---> 결론은 nextLine()을 쓰자.

                System.out.println("옳바른 값을 입력해주세요.");
            }   // catch end

        }   // for end
    }   // func end

    // 등록 view
    public void BoardWrite() {
        // Scanner 입력받기
        System.out.print("내용 : ");      String content = scan.next();
        System.out.print("작성자 : ");     String writer = scan.next();
        // 2. controller 에게 입력받은 값 전달하고 결과 받기
        boolean result = controller.boardWrite( content , writer );
        // 3. 결과에 따른 출력
        if ( result ) System.out.println("[안내] 글쓰기 성공");
        else System.out.println("[경고] 글쓰기 실패");
    }   // func end

    // 조회 view
    public void BoardPrint() {
        System.out.println("============= 게시물 목록 =============");
        // 1. controller 에서 반환 해준 결과 받기
        ArrayList< BoardDto > boardDB = controller.boardPrint();
        // 향상된 for문 사용하여 결과 출력
        for ( BoardDto dto : boardDB ) {
            System.out.println("작성자 : " + dto.getWriter()) ;
            System.out.println("내용 : " + dto.getContent()) ;
            System.out.println("------------------------------------");
        }   // for end
    }   // func end
}   // class end
