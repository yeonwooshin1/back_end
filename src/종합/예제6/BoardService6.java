package 종합.예제6; // package

import java.util.Scanner;

public class BoardService6 {
    public static void main(String[] args) {
        // 예제 4와 5와 다르게 static 으로 구성된 메소드는 객체가 필요 없다.


        for( ; ; ) {// (1) 무한루프 : 프로그램 계속적으로 실행하기 위해서
            System.out.println("============= My Community =============");// (2) 출력
            System.out.println("  1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            Scanner scan = new Scanner( System.in ); // (3) 입력
            int choose = scan.nextInt();
            if( choose == 1 ) { // (4) 입력 에 따른 화면 출력
                System.out.print("내용 : ");      String content = scan.next();
                System.out.print("작성자 : ");     String writer = scan.next();
                boolean result = BoardController.doPost(content , writer);
                if(result) System.out.println("[안내] 글쓰기 성공");
                else{ System.out.println("[경고] 등록 실패");}
            }else if( choose == 2 ) {
                System.out.println("============= 게시물 목록 =============");
                Board[] boards = BoardController.doGet();
                for(int i = 0; i < boards.length; i++){
                    Board board = boards[i];
                    if(board != null){
                        System.out.println("작성자 : " + board.getContent() );
                        System.out.println("내용 : " + board.getWriter() );
                        System.out.println("------------------------------------");
                    }

                }
            }
        } // for end
    }
}

// [1] 데이터 모델 : 게시물 모델링

