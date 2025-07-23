package 종합.예제10.view;   // package

import 종합.예제10.controller.BoardController;
import 종합.예제10.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardView {    // class start
    // 싱글톤 만들기
    private BoardView(){}
    private static final BoardView view = new BoardView();
    public static BoardView getInstance(){
        return view;
    }

    // 싱글톤 가져오기
    BoardController controller = BoardController.getInstance();

    // Scanner
    Scanner scan = new Scanner(System.in);

    // index 시작 view
    public void index () {
        for ( ; ; ) {
            System.out.println("=================== My Community ===================");
            System.out.println("1.게시물쓰기 | 2.게시물출력 | 3.게시물삭제 | 4.게시물수정 ");
            System.out.println("====================================================");
            System.out.print("선택 > ");
            try {
                int choose = scan.nextInt();
                if (choose == 1 )               BoardWrite();
                else if (choose == 2 )          BoardPrint();
                else if (choose == 3 )          BoardDelete();
                else if (choose == 4)           BoardUpdate();
                else System.out.println("번호를 다시 입력해주세요.");
            } catch (InputMismatchException e) {    // scan 값 예외처리
                System.out.println("[실패] 숫자만 입력하세요.");
                scan.nextLine();
            }   // catch end
        }   // for end
    }   // func end

    // Board 등록 view
    public void BoardWrite() {
        // Scanner 입력받기
        scan.nextLine();
        System.out.print("내용 : ");      String bcontentInput = scan.nextLine();
        System.out.print("작성자 : ");     String bwriterInput = scan.next();

        boolean result = controller.BoardWrite( bcontentInput , bwriterInput );
        if(result) System.out.println("[성공] 글쓰기 성공");
        else System.out.println("[실패] 글쓰기 실패");
    }   // func end

    // Board 출력 view
    public void BoardPrint() {
        System.out.println("============= 게시물 목록 =============");
        ArrayList<BoardDto> BoardDB = controller.BoardPrint();
        for (BoardDto index : BoardDB) {
            System.out.println("번호 : " + index.getBno());
            System.out.println("작성자 : " + index.getBwriter());
            System.out.println("내용 : " + index.getBcontent());
            System.out.println("------------------------------------");
        }   // for end
    }   // func end

    // Board 삭제 view
    public void BoardDelete() {
        System.out.println("============= 게시물 목록 =============");
        int bnoInput;
        for ( ; ; ){
            try {
                System.out.print("삭제할번호 : ");     bnoInput = scan.nextInt();
                if (bnoInput > 0) break;
                else System.out.println("[경고] 양수만 입력하세요.");
            } catch ( InputMismatchException e) {
                System.out.println("[경고] 숫자만 입력하세요.");
                scan.nextLine();
            }   // catch end
        }   // for end

        boolean result = controller.BoardDelete( bnoInput );
        if (result) System.out.println("[안내] 삭제 성공");
        else System.out.println("[경고] 삭제 실패");
    }   // func end

    // Board 수정 view
    public void BoardUpdate() {
        System.out.println("============= 게시물 목록 =============");
        int bnoInput;           String bcontentInput;
        for( ;; ) {
            try {
                System.out.print("수정할 번호 : ");  bnoInput = scan.nextInt();
                scan.nextLine();
                System.out.print("새로운 내용 : "); bcontentInput = scan.nextLine();

                if (bnoInput > 0) break;
                else System.out.println("[경고] 양수만 입력하세요.");
            } catch (InputMismatchException e) {
                System.out.println("[경고] 숫자만 입력하세요.");
            }   // catch end
        }   // for end

        boolean result = controller.BoardUpdate( bnoInput , bcontentInput );
        if (result) System.out.println("[안내] 수정 성공");
        else System.out.println("[경고] 수정 실패");
    }   // func end

}   // class end
