package 종합.예제5;

import java.util.Scanner;

public class BoardService5 {
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

// 담당이 필요한 이유!! : 복잡한 로직/코드를 역할/담당 나누어 유지보수 관리 한다.
// 1인 식당은 테이블 3개라서 사장님 혼자서 주문받고, 요리하고 , 냉장고 관리
// 테이블 100개라서 역할/담당 , 1. 서빙담당(Service) , 2. 요리사담당(Controller) , 3. 냉장고담당 (Board)

class Board{
    // 1. 멤버변수
    String content;
    String writer;

    // 2. 생성자
        // --> 인텔리제이에서 자동 생성자 지원
        // 1. 코드파일내 빈공간을 오른쪽 클릭
        // 2. [ 생성 ] --> 생성자
        // 3. ctrl키 이용한 멤버변수 복수 선택 후 --> [ 선택 ]

    Board(String content , String writer){
        this.content = content;
        this.writer = writer;
    }
}   // class Board end

class BoardController{  // (2) (게시물 이벤트) 기느으 제어/로직 담당
    Board[] boards = new Board[100];    // 배열 100개 생성

    // 1. 등록 메소드
    boolean doPost(String content, String writer){

        Board board = new Board(content , writer);

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
