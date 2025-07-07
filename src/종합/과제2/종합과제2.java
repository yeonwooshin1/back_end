package 종합.과제2; // pakage

import java.util.Scanner;

public class 종합과제2 {    // class start
    public static void main(String[] args) {    // main start

        Waiting[] waitings = new Waiting[100];

        Scanner scan = new Scanner(System.in);
        for(;;){
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("  1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();
            if(choose == 1){
                boolean check = false;
                System.out.print("전화번호 : ");         String phoneInput = scan.next();
                System.out.print("인원수 : ");       int countInput = scan.nextInt();
                Waiting waiting = new Waiting();
                waiting.count = countInput;     waiting.phone = phoneInput;
                for( int i = 0; i< waitings.length; i++){
                    if(waitings[i] == null){
                        waitings[i] = waiting;
                        check = true;
                        break;
                    }   // if end
                }   // for i end
                if(check){System.out.println("[안내] 대기 등록이 완료되었습니다.");}
                else{ System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");}

            }   // choose == 1 if end
            if(choose ==2 ){
                for(Waiting i : waitings) {
                    if(i != null){
                        System.out.println("============= 대기 현황 =============");
                        System.out.print("연락처 : " + i.phone);
                        System.out.println(" - 인원 : " + i.count);
                        System.out.println("------------------------------------");

                    }   // if end
                }   // for i end
            }   // choose == 2 if end
        }   // for end


    }   // main end
}   // class end
class Waiting{
    String phone;
    int count;
}