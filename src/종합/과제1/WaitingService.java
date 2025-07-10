package 종합.과제1; // pakage

import java.util.Scanner;

public class WaitingService { // class start
    public static void main(String[] args) { // main start
        String phone1 = null;  String phone2 = null;  String phone3 = null;
        int count1 = 0;     int count2 = 0;      int count3 = 0;

        for(;;){
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("  1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 > ");
            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();
            if(choose == 1){
                System.out.print("전화번호 : ");         String phone = scan.next();
                System.out.print("인원수 : ");       int count = scan.nextInt();
                if(phone1 == null){
                    phone1 = phone;
                    count1 = count;
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                } else if (phone2 == null) {
                    phone2 = phone;
                    count2 = count;
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                } else if (phone3 == null) {
                    phone3 = phone;
                    count3 = count;
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                } else{
                    System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");
                }
            } // if end
            if(choose == 2){
                System.out.println("============= 대기 현황 =============");
                if( phone1 != null ) {
                    System.out.print("연락처 : " + phone1);
                    System.out.println(" - 인원 : " + count1);
                    System.out.println("------------------------------------");
                }
                if( phone2 != null  ){
                    System.out.print("연락처 : " + phone2);
                    System.out.println(" - 인원 : " + count2);
                    System.out.println("------------------------------------");
                }
                if (phone3 != null) {
                    System.out.print("연락처 : " + phone3);
                    System.out.println(" - 인원 : " + count3);
                    System.out.println("------------------------------------");
                }
            } // if end
        } // for end

    } // main end
} //  class end
