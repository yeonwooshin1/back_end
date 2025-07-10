package 심화.과제3; // package

import java.util.Scanner;

public class BankService {  // class start
    public static void main(String[] args) {    // main start

        BankController bankController = new BankController();   // BankController 클래스 bs 객체 할당

        Scanner scan = new Scanner(System.in);  // 스캐너 할당 변수명 : scan

        for(;;){    // 무한으로 즐겨요 명륜진사 for문~
            System.out.println("========================== KB Bank =========================");
            System.out.println("  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체 |  6.거래내역 ");
            System.out.println("============================================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();    // choose scan 받기 1,2,3,4,5 중에
            if(choose == 1){    // 1이라면? 계좌등록
                System.out.println("--- 계좌 등록 ---");
                System.out.print("계좌번호 : ");         String accountInput =  scan.next();    // 인수값 계좌번호 받기
                System.out.print("비밀번호 : ");       int passwordInput =  scan.nextInt();     // 인수값 비밀번호 받기
                boolean alert = bankController.addAccount( accountInput , passwordInput );     // 계좌번호 추가 boolean 타입인 addAccount 메소드 호출 후 alert 변수명에 대입
                if(alert){System.out.println("[안내] 계좌 등록이 완료되었습니다.");}              // 만약 alert가 true 라면 ?
                else{ System.out.println("[경고] 계좌 한도에 도달 하셨습니다.");}                 // 만약 alert가 false 라면 ?
            }   // if choose 1 end

            if(choose == 2){    // 2라면? 입금
                System.out.println("--- 입금 ---");
                System.out.print("계좌번호 : ");         String accountInput = scan.next(); // 인수값 계좌번호 받기
                System.out.print("비밀번호 : ");       int passwordInput = scan.nextInt();  // 인수값 비밀번호 받기
                System.out.print("입금액 : ");       int moneyInput = scan.nextInt();      // 인수값 입금할 돈 받기
                boolean addAlert = bankController.addMoney( accountInput , passwordInput , moneyInput );    // 입금할 boolean 타입인 addMoney 메소드 호출 후 addAlert 변수명에 대입
                if(addAlert){System.out.println("[안내] 입금이 완료되었습니다.");}            // 만약 addAlert가 true 라면 ?
                else{ System.out.println("[경고] 계좌정보가 일치하지 않습니다.");}             // 만약 addAlert가 false 라면 ?
            }   // if choose 2 end

            if(choose == 3){    // 3이라면? 출금
                System.out.println("--- 출금 ---");
                System.out.print("계좌번호 : ");         String accountInput = scan.next(); // 인수값 계좌번호 받기
                System.out.print("비밀번호 : ");       int passwordInput = scan.nextInt();  // 인수값 비밀번호 받기
                System.out.print("출금액 : ");       int moneyInput = scan.nextInt();      // 인수값 출금할 돈 받기
                int withdrawAlert = bankController.withdrawMoney( accountInput , passwordInput , moneyInput );  // 출금할 int 타입인 withdrawMoney 메소드 호출 후 withdrawAlert 변수명에 대입
                if(withdrawAlert == 1 ){System.out.println("[안내] 출금이 완료되었습니다.");}   // 만약 withdrawAlert 리턴값이 1이라면?
                else if(withdrawAlert == 2){ System.out.println("[경고] 잔액이 부족합니다.");}    // 만약 withdrawAlert 리턴값이 2라면?
                else{System.out.println("[경고] 계좌정보가 일치하지 않습니다.");}                  // 만약 withdrawAlert 값이 1 2가 아닌 다른 값이라면?
            } // if choose 3 end

            if(choose == 4){    // 4라? 잔액확인
                System.out.println("--- 잔고 확인 ---");
                System.out.print("계좌번호 : ");         String accountInput = scan.next(); // 인수값 계좌번호 받기
                System.out.print("비밀번호 : ");       int passwordInput = scan.nextInt();  // 인수값 비밀번호 받기
                int seeAlert = bankController.seeMoney( accountInput ,  passwordInput); // 잔액확인할 int 타입인 seeMoney 메소드 호출 후 seeAlert 변수명에 대입
                if(seeAlert != -1){ // 만약 seeAlert 리턴값이 -1이 아니라면?
                    System.out.println("[잔고] "+ seeAlert+ "원"); // 잔고로 seeAlert 리턴값 출력
                }
                else{ System.out.println("[경고] 계좌정보가 일치하지 않습니다.");} // seeAlert 리턴값이 -1이라면?
            }   // if choose 4 end

            if(choose == 5){    // 5라면? 계좌이체
                System.out.println("--- 계좌 이체 ---");
                System.out.print("보내는 분 계좌번호 : ");         String sendAccountInput = scan.next();   // 인수값 보낼계좌명 받기
                System.out.print("비밀번호 : ");                  int passwordInput = scan.nextInt();       // 인수값 비밀번호 받기
                System.out.print("받는 분 계좌번호 : ");           String receiveAccountInput = scan.next();   // 인수값 받을계좌명 받기
                System.out.print("이체할 금액 : ");                int sendMoney = scan.nextInt();               // 인수값 보낼 돈 받기
                int sendAlert = bankController.sendMoney( sendAccountInput ,  passwordInput , receiveAccountInput , sendMoney );    // 계좌이체할 sendMoney 메소드 호출, sendAlert가 변수명
                if(sendAlert == 1){                                                     // 만약 seeAlert가 1이라면?
                    System.out.println("[안내] 이체가 완료되었습니다.");                    // 이체 완료 안내
                }
                else if(sendAlert == 2) System.out.println("[경고] 잔액이 부족합니다.");  // 만약 seeAlert가 2라면? 잔액 부족
                else if(sendAlert == 3) System.out.println("[경고] 받으실 계좌가 조회되지 않습니다.");    // 만약 seeAlert가 3이라면? 받는 계좌정보 없음
                else if(sendAlert == 0) System.out.println("[경고] 이체할 계좌와 이체 받을 계좌가 일치합니다.");    // 만약 seeAlert가 0이라면? 보낼 계좌번호와 받을 계좌번호 일치로 인한 오류
                else if(sendAlert == 4) System.out.println("[경고] 계좌정보가 일치하지 않습니다.");   // 만약 seeAlert가 리턴값이 4라면? 보낼 계좌번호에서 계좌번호가 없던가 비밀번호가 틀리던가 둘 중 하나겠죠
                else{ System.out.println("[경고] 에러가 발생했습니다."); }
            }   // if choose 5 end

            if(choose == 6){        // 6이라면 잔액확인
                System.out.println("--- 거래 내역 ---");
                System.out.print("계좌번호 : ");         String sendAccountInput = scan.next();             // 인수값 보낼계좌명 받기
                System.out.print("비밀번호 : ");         int passwordInput = scan.nextInt();               // 인수값 비밀번호 받기
                String checkAlert = bankController.seeAccountLog( sendAccountInput , passwordInput ) ;   // 로그값 출력할 seeAccountLog 출력
                if(checkAlert.equals("error")) System.out.println("[경고] 계좌 정보를 찾을 수 없습니다.");    // 리턴값 error 라면? 계좌 정보를 찾을 수 없습니다.
                else System.out.println(checkAlert);                                                     // 리턴값 log 라면? 내역 출력
            }   // if choose 6 end

        }   // for 무한루프 end
    }   // main end
}   // class end

