package 종합.과제5.view;

import day_09.package2.C;
import 종합.과제5.controller.WaitingController;
import 종합.과제5.model.WaitingDto;

import java.util.Scanner;

public class WaitingView {

    // 싱글 톤 만들기
    private WaitingView(){}
    private static final WaitingView view = new WaitingView();
    public static WaitingView getInstance(){
        return view;
    } // func end

    // 입력 객체 Scanner 만들기

    private Scanner scan = new Scanner(System.in);

    // control 멤버변수 가져오기 싱글톤으로
    private WaitingController controller = WaitingController.getInstance();

    // 처음 view  : 최초로 보이는 무한루프 for
    public void index(){
        for(;;){
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("  1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 ) boardWrite();
            else if( choose == 2 ) boardPrint();
        }

    }
    // 등록 view : 전화번호 , 인원수 등록하는 view
    public void boardWrite(){
        System.out.print("전화번호 : ");
        String phoneInput = scan.next();
        System.out.print("인원수 : ");
        int countInput = scan.nextInt();
        boolean result = controller.boardWrite( phoneInput, countInput );
        if (result) System.out.println("[안내] 대기 등록이 완료되었습니다.");
        else System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");

    }
    // 출력 view : 명단 배열 출력하는 view
    public void boardPrint(){
        System.out.println("============= 대기 현황 =============");

        WaitingDto[] result = controller.boardPrint();

        for(int i =0; i< result.length; i++){
            WaitingDto waitingDto = result[i];
            if(result[i] != null){
                System.out.println("1. 연락처 : "+ waitingDto.getPhone() + " - 인원 :"+waitingDto.getCount() +"명");
                System.out.println("------------------------------------");
            }// if end
        }   // for i end
    }   // if end
}   // 무한루프 end
