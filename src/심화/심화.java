package 심화; // pakage

import java.util.Scanner;

public class 심화 {   // class start
    public static void main(String[] args) {    // main start

        BankController bankController = new BankController();
        BankService bankService = new BankService();


        for(;;){
            System.out.println("============== KB Bank  ==============");
            System.out.println("  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 ");
            System.out.println("======================================");
            System.out.print("선택 > ");
            int choose = bankService.inputInt();
            if(choose == 1){
                System.out.println("--- 계좌 등록 ---");
                System.out.print("계좌번호 : ");         String accountInput = bankService.inputString();
                System.out.print("비밀번호 : ");       int passwordInput = bankService.inputInt();
                boolean alert = bankController.addAccount( accountInput , passwordInput );
                if(alert){System.out.println("[안내] 계좌 등록이 완료되었습니다.");}
                else{ System.out.println("[경고] 계좌 한도에 도달 하셨습니다.");}
            }   // if end

            if(choose == 2){
                System.out.println("--- 입금 ---");
                System.out.print("계좌번호 : ");         String accountInput = bankService.inputString();
                System.out.print("비밀번호 : ");       int passwordInput = bankService.inputInt();
                System.out.print("입금액 : ");       int moneyInput = bankService.inputInt();
                boolean addAlert = bankController.addMoney( accountInput , passwordInput , moneyInput );
                if(addAlert){System.out.println("[안내] 입금이 완료되었습니다.");}
                else{ System.out.println("[경고] 계좌정보가 일치하지 않습니다.");}
            }   // if end

            if(choose == 3){
                System.out.println("--- 출금 ---");
                System.out.print("계좌번호 : ");         String accountInput = bankService.inputString();
                System.out.print("비밀번호 : ");       int passwordInput = bankService.inputInt();
                System.out.print("출금액 : ");       int moneyInput = bankService.inputInt();
                int withdrawAlert = bankController.withdrawMoney( accountInput , passwordInput , moneyInput );
                if(withdrawAlert == 1 ){System.out.println("[안내] 출금이 완료되었습니다.");}
                else if(withdrawAlert == 2){ System.out.println("[경고] 잔액이 부족합니다.");}
                else{System.out.println("[경고] 계좌정보가 일치하지 않습니다.");}
            }

            if(choose == 4){
                System.out.println("--- 잔고 확인 ---");
                System.out.print("계좌번호 : ");         String accountInput = bankService.inputString();
                System.out.print("비밀번호 : ");       int passwordInput = bankService.inputInt();
                int seeAlert = bankController.seeMoney( accountInput ,  passwordInput);
                if(seeAlert != -1){
                    System.out.println("[잔고] "+ seeAlert+ "원");
                }
                else{ System.out.println("[경고] 계좌정보가 일치하지 않습니다.");}
            }

        }   // for 무한루프 end


    }   // main end
}   // class end

class Account{
    String accountNumber; // 계좌번호 멤버변수
    int password;   // 비밀번호 멤버변수
    int money;
}   // class Account end

class BankController{
    Account[] accounts = new Account[100]; // accounts 배열 선언 : 배열길이 100개

    boolean addAccount( String accountNumber , int password ){
        Account account = new Account();    // Account 객체 선언

        account.accountNumber = accountNumber; account.password = password; account.money = 0; // 매개변수 받은 값 멤버변수에 넣기

        for(int i = 0; i< accounts.length; i++){
            if(accounts[i] == null){
                accounts[i] = account;
                return true;
            }
        }
        return false;
    }   // func end

    boolean addMoney(String accountNumber , int password , int money){
        Account account = new Account();    // Account 객체 선언

        account.accountNumber = accountNumber; account.password = password; account.money = money; // 매개변수 받은 값 멤버변수에 넣기
        boolean error = true;
        for(int i = 0; i< accounts.length; i++){
            if(accounts[i] != null && accounts[i].accountNumber.equals(account.accountNumber) && accounts[i].password == (account.password)){
                accounts[i].money += account.money;
                return true;
            }
        }
        return false;
    }   // func end

    int withdrawMoney(String accountNumber , int password , int money){
        Account account = new Account();    // Account 객체 선언

        account.accountNumber = accountNumber; account.password = password; account.money = money; // 매개변수 받은 값 멤버변수에 넣기

        for(int i = 0; i< accounts.length; i++){
            if(accounts[i] != null && accounts[i].accountNumber.equals(account.accountNumber) && accounts[i].password == (account.password)){
                if(accounts[i].money >= account.money){
                    accounts[i].money -= account.money;
                    return 1;
                }
                else return 2;
            }
        }
        return 3;
    }   // func end

    int seeMoney(String accountNumber , int password){
        Account account = new Account();    // Account 객체 선언

        account.accountNumber = accountNumber; account.password = password; // 매개변수 받은 값 멤버변수에 넣기

        for(int i = 0; i< accounts.length; i++){
            if(accounts[i] != null && accounts[i].accountNumber.equals(account.accountNumber) && accounts[i].password == (account.password)){

                return accounts[i].money;
            }
        }
        return -1;
    }

}   // class BankController end

class BankService{
    Scanner scan = new Scanner(System.in);  // scan

    String inputString(){

        String inputSt = scan.next();
        return inputSt;
    }   // func end

    int inputInt(){

        int inputIn = scan.nextInt();
        return inputIn;
    }   // func end

}