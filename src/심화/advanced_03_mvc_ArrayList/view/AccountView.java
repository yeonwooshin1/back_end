package 심화.advanced_03_mvc_ArrayList.view;


import 심화.advanced_03_mvc_ArrayList.controller.BankController;

import java.util.Scanner;

public class AccountView {  // AccountView class start

    // 싱글톤 만들기
    private AccountView(){};

    private static final AccountView view = new AccountView();

    public static AccountView getInstance(){
        return view;
    }   // func end

    // BankController 싱글톤 받아오기

    BankController controller = BankController.getInstance();

    // scan 값 받기
    Scanner scan = new Scanner(System.in);



    // index 실행 메소드

    public void index(){
        for(;;){    // for (;;)
            System.out.println("========================== KB Bank =========================");
            System.out.println("  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체 |  6.거래내역 ");
            System.out.println("============================================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();    // choose scan 받기 1,2,3,4,5 중에
            if(choose == 1)             accountCreate();
            else if(choose == 2)        accountDeposit();
            else if(choose == 3)        accountWithdraw();
            else if(choose == 4)        accountBalance();
            else if(choose == 5)        accountTransfer();
            else if(choose == 6)        accountLogPrint();
            else System.out.println("[ 경고 ] 다시 입력해주세요.");

        }
    }

    // choose 1 계좌 생성 view   : 계좌번호 , 비밀번호 생성하는 view

    public void accountCreate(){
        System.out.println("--- 계좌 등록 ---");
        System.out.print("계좌번호 : ");         String accountInput =  scan.next();    // 인수값 계좌번호 받기
        System.out.print("비밀번호 : ");       int passwordInput =  scan.nextInt();     // 인수값 비밀번호 받기

        boolean alert = controller.accountCreate( accountInput , passwordInput );

        if(alert){System.out.println("[안내] 계좌 등록이 완료되었습니다.");}              // 만약 alert가 true 라면 ?
        else{ System.out.println("[경고] 계좌 한도에 도달 하셨습니다.");}                 // 만약 alert가 false 라면 ?

    }   // func end

    // choose 2 계좌 입금 view   : 계좌번호에 입금하는 view

    public void accountDeposit(){
        System.out.println("--- 입금 ---");
        System.out.print("계좌번호 : ");         String accountInput = scan.next(); // 인수값 계좌번호 받기
        System.out.print("비밀번호 : ");       int passwordInput = scan.nextInt();  // 인수값 비밀번호 받기
        System.out.print("입금액 : ");       int moneyInput = scan.nextInt();      // 인수값 입금할 돈 받기

        int alert = controller.accountDeposit( accountInput , passwordInput , moneyInput );

        if (alert == 1) { System.out.println("[안내] 입금이 완료되었습니다."); }
        else if (alert == 2) { System.out.println("[경고] 계좌내역이 가득찼습니다. 창구에 문의하세요. ");}
        else if (alert == 3) { System.out.println("[경고] 계좌정보가 일치하지 않습니다."); }
        else { System.out.println("[경고] 시스템 오류입니다. "); }

    }   // func end

    // choose 3 계좌 출금 view   : 계좌번호에 출금하는 view

    public void accountWithdraw(){
        System.out.println("--- 출금 ---");
        System.out.print("계좌번호 : ");         String accountInput = scan.next(); // 인수값 계좌번호 받기
        System.out.print("비밀번호 : ");       int passwordInput = scan.nextInt();  // 인수값 비밀번호 받기
        System.out.print("출금액 : ");       int moneyInput = scan.nextInt();      // 인수값 출금할 돈 받기

        int alert = controller.accountWithdraw( accountInput , passwordInput , moneyInput );

        if (alert == 0) { System.out.println("[경고] 잔액이 부족합니다."); }
        else if (alert == 1) { System.out.println("[안내] 출금이 완료되었습니다."); }
        else if (alert == 2) { System.out.println("[경고] 계좌내역이 가득찼습니다. 창구에 문의하세요. ");}
        else if (alert == 3) { System.out.println("[경고] 계좌정보가 일치하지 않습니다."); }
        else { System.out.println("[경고] 시스템 오류입니다. "); }

    }   // func end

    // choose 4 계좌 잔액 view   : 계좌번호에 들어있는 잔액 확인 view

    public void accountBalance(){
        System.out.println("--- 잔고 확인 ---");
        System.out.print("계좌번호 : ");         String accountInput = scan.next(); // 인수값 계좌번호 받기
        System.out.print("비밀번호 : ");       int passwordInput = scan.nextInt();  // 인수값 비밀번호 받기

        int alert = controller.accountBalance( accountInput , passwordInput );

        if(alert == -1 ) System.out.println("[경고] 계좌정보가 일치하지 않습니다.") ; // 잔고로 seeAlert 리턴값 출력
        else System.out.println("[잔고] "+ alert+ "원");


    }   // func end

    // choose 5 계좌 이체 view   : 계좌 이체 하는 view

    public void accountTransfer(){
        System.out.println("--- 계좌 이체 ---");
        System.out.print("보내는 분 계좌번호 : ");         String sendAccountInput = scan.next();   // 인수값 보낼계좌명 받기
        System.out.print("비밀번호 : ");                  int passwordInput = scan.nextInt();       // 인수값 비밀번호 받기
        System.out.print("받는 분 계좌번호 : ");           String receiveAccountInput = scan.next();   // 인수값 받을계좌명 받기
        System.out.print("이체할 금액 : ");                int sendMoney = scan.nextInt();               // 인수값 보낼 돈 받기
        String alert = controller.accountTransfer( sendAccountInput , passwordInput , receiveAccountInput , sendMoney );

        if(alert.equals("success"))System.out.println("[안내] 이체가 완료되었습니다.");
        else if(alert.equals("insufficient"))System.out.println("[경고] 잔액이 부족합니다.");
        else if(alert.equals("maxAccountLog"))System.out.println("[경고] 계좌내역이 가득 찼거나 오류입니다.");
        else if(alert.equals("equalAccount"))System.out.println("[경고] 이체할 계좌와 이체 받을 계좌가 일치합니다.");
        else if(alert.equals("notExitReceiveAccount"))System.out.println("[경고] 받으실 계좌가 조회되지 않습니다.");
        else if(alert.equals("accountPwMismatch"))System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
        else{ System.out.println("[경고] 에러가 발생했습니다."); }

    }   // func end

    // choose 6 계좌내역 view    : 해당 계좌 로그 출력하는 view

    public void accountLogPrint(){
        System.out.println("--- 거래 내역 ---");
        System.out.print("계좌번호 : ");         String sendAccountInput = scan.next();             // 인수값 보낼계좌명 받기
        System.out.print("비밀번호 : ");         int passwordInput = scan.nextInt();               // 인수값 비밀번호 받기

        String alert = controller.accountLogPrint(sendAccountInput , passwordInput );

        if(alert.equals("error"))    System.out.println("[경고] 계좌 정보를 찾을 수 없습니다.");
        else System.out.println(alert);

    }   // func end

}   // clas AccountView end
