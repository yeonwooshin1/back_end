package 종합.과제6.view;    // package

import 종합.과제6.controller.WaitingController;
import 종합.과제6.model.WaitingDto;

import java.util.ArrayList;
import java.util.Scanner;

public class WaitingView {  // class WaitingView start
    // 싱글톤 만들기
    private WaitingView(){}
    private static final WaitingView view = new WaitingView();
    public static WaitingView getInstance(){
        return view;
    }

    // 싱글톤 가져오기

    private WaitingController controller = WaitingController.getInstance();

    // Scan 객체
    Scanner scan = new Scanner(System.in);

    // index 처음 메소드

    public void index(){
        for(;;){
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("  1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 ) addWaitingList();
            else if( choose == 2 ) getWaitingList();
        }   // 무한 for문
    }   // func end

    // 등록 메소드

    public void addWaitingList( ){
        System.out.print("전화번호 : ");
        String phoneInput = scan.next();
        System.out.print("인원수 : ");
        int countInput = scan.nextInt();

        boolean result = controller.addWaitingList(phoneInput , countInput); // WaitingController 값 받아옴

        if (result) System.out.println("[안내] 대기 등록이 완료되었습니다.");
        else System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");
    }   // func end

    // 출력 메소드
    public void getWaitingList(){
        System.out.println("============= 대기 현황 =============");

        ArrayList<WaitingDto> result = controller.getWaitingList(); // WaitingController 값 받아옴

        for( WaitingDto dto : result){
            System.out.println("1. 연락처 : "+ dto.getPhone() + " - 인원 :"+dto.getCount() +"명");
            System.out.println("------------------------------------");
        }   // for end
    }   // func end

}   // class Waiting end
