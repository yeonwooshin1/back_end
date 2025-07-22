package 종합.과제_JDBC.view;    // package

import 종합.과제_JDBC.controller.WaitingController;
import 종합.과제_JDBC.model.WaitingDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WaitingView {  // class start
    // 싱글톤 만들기
    private WaitingView(){}
    private static final WaitingView view = new WaitingView();
    public static WaitingView getInstance(){
        return view;
    }

    // 싱글톤 가져오기
    WaitingController controller = WaitingController.getInstance();

    // Scanner
    Scanner scan = new Scanner(System.in);

    // 메인 view
    public void index(){
        for(;;){
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("  1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 > ");
            try {
                int choose = scan.nextInt();
                if( choose == 1 )           listWrite();
                else if( choose == 2 )      listPrint();
                else System.out.println("[실패] 메뉴에 있는 숫자를 선택하세요.");
            } catch (InputMismatchException e) {    // scan에 int 대신 다른 걸 넣는 것에 대한 예외 처리
                System.out.println("[경고] 숫자만 입력하세요.");
                // 무한루프 걸리니 \n까지 처리해줌
                scan.nextLine();
            }   // catch end

        }   // 무한 for문
    }   // func end

    // 등록 메소드
    public void listWrite(){
        System.out.print("전화번호 : ");
        String phoneInput = scan.next();
        int countInput;
        for( ; ; ){ // 무한 for문
            try {
                System.out.print("인원수 : ");
                countInput = scan.nextInt();
                if(countInput > 0) break;   // 0 이상 치면 break;
                else System.out.println("[경고] 최소 1명 이상 선택하세요.");
            } catch (InputMismatchException e) {    // scan에 int 대신 다른 걸 넣는 것에 대한 예외 처리
                System.out.println("[경고] 숫자만 입력하세요.");
                scan.nextLine();    // 깔끔하게 처리
            }   // catch end
        }   // for end
        // controller.listWrite 에 매개변수 전달, 그리고 받은 반환값 result 변수에 저장
        boolean result = controller.listWrite(phoneInput , countInput);
        // 반환값에 따라 출력
        if (result) System.out.println("[안내] 대기 등록이 완료되었습니다.");
        else System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");
    }   // func end

    // 출력 메소드
    public void listPrint(){
        System.out.println("============= 대기 현황 =============");
        // controller 에서 반환값으로 ArrayList를 가져온다.
        ArrayList<WaitingDto> waitingDB = controller.listPrint();
        // ArrayList에 있는 대기명단에 따라 if문
        if(waitingDB.isEmpty()) System.out.println("대기 현황이 없습니다.");
        else {
            for (WaitingDto index : waitingDB) {    // 향상된 for문
                System.out.println( index.getSeq() +". 연락처 : " + index.getPhone() + " - 인원 :" + index.getCount() + "명");
                System.out.println("------------------------------------");
            }   // for end
        }   // if end
    }   // func end

}   // class end
