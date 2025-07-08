package 종합.과제3; // pakage

import java.util.Scanner;

public class 종합과제3 {    // class start
    public static void main(String[] args) {    // main start

        WaitingController controller = new WaitingController();

        Scanner scan = new Scanner(System.in);
        for(;;) {
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("  1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();
            if (choose == 1) {
                System.out.print("전화번호 : ");         String phoneInput = scan.next();
                System.out.print("인원수 : ");       int countInput = scan.nextInt();
                boolean alert = controller.addWaiting( phoneInput , countInput );
                if(alert){System.out.println("[안내] 대기 등록이 완료되었습니다.");}
                else{ System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");}
            }   // if choose == 1 end

            if (choose == 2) {
                Waiting[] waiting = controller.getWaitingList();
                for( Waiting i : waiting){
                    if(i != null){
                        System.out.println("============= 대기 현황 =============");
                        System.out.println("1. 연락처 : " + i.phone + " - 인원 : " + i.count + "명");
                        System.out.println("------------------------------------");
                    }   // if end
                }   // 향상된 for문
            }   // if choose == 2 end
        }   // for 무한루프 end;

    }   // main end
}   // class end
class Waiting{
    String phone;
    int count;
}   // class Waiting end

class WaitingController{
    Waiting[] waitings = new Waiting[100];

    boolean addWaiting(String phone, int count){
        Waiting waiting = new Waiting();
        waiting.phone = phone;  waiting.count = count;

        for(int i = 0; i < waitings.length; i++){
            if(waitings[i] == null){
                waitings[i] = waiting;
                return true;
            }
        }
        return false;
    }

    Waiting[] getWaitingList(){
        return waitings;
    }
}   // class WaitingController end
