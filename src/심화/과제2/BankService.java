package 심화.과제2; // package

import java.util.Scanner;

public class BankService {  // class start
    public static void main(String[] args) {    // main start

        BankController bankController = new BankController();

        Scanner scan = new Scanner(System.in);  // scan


        for(;;){
            System.out.println("==================== KB Bank ===================");
            System.out.println("  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체 ");
            System.out.println("================================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();
            if(choose == 1){
                System.out.println("--- 계좌 등록 ---");
                System.out.print("계좌번호 : ");         String accountInput =  scan.next();
                System.out.print("비밀번호 : ");       int passwordInput =  scan.nextInt();
                boolean alert = bankController.addAccount( accountInput , passwordInput );
                if(alert){System.out.println("[안내] 계좌 등록이 완료되었습니다.");}
                else{ System.out.println("[경고] 계좌 한도에 도달 하셨습니다.");}
            }   // if end

            if(choose == 2){
                System.out.println("--- 입금 ---");
                System.out.print("계좌번호 : ");         String accountInput = scan.next();
                System.out.print("비밀번호 : ");       int passwordInput = scan.nextInt();
                System.out.print("입금액 : ");       int moneyInput = scan.nextInt();
                boolean addAlert = bankController.addMoney( accountInput , passwordInput , moneyInput );
                if(addAlert){System.out.println("[안내] 입금이 완료되었습니다.");}
                else{ System.out.println("[경고] 계좌정보가 일치하지 않습니다.");}
            }   // if end

            if(choose == 3){
                System.out.println("--- 출금 ---");
                System.out.print("계좌번호 : ");         String accountInput = scan.next();
                System.out.print("비밀번호 : ");       int passwordInput = scan.nextInt();
                System.out.print("출금액 : ");       int moneyInput = scan.nextInt();
                int withdrawAlert = bankController.withdrawMoney( accountInput , passwordInput , moneyInput );
                if(withdrawAlert == 1 ){System.out.println("[안내] 출금이 완료되었습니다.");}
                else if(withdrawAlert == 2){ System.out.println("[경고] 잔액이 부족합니다.");}
                else{System.out.println("[경고] 계좌정보가 일치하지 않습니다.");}
            }

            if(choose == 4){
                System.out.println("--- 잔고 확인 ---");
                System.out.print("계좌번호 : ");         String accountInput = scan.next();
                System.out.print("비밀번호 : ");       int passwordInput = scan.nextInt();
                int seeAlert = bankController.seeMoney( accountInput ,  passwordInput);
                if(seeAlert != -1){
                    System.out.println("[잔고] "+ seeAlert+ "원");
                }
                else{ System.out.println("[경고] 계좌정보가 일치하지 않습니다.");}
            }

            if(choose == 5){
                System.out.println("--- 계좌 이체 ---");
                System.out.print("보내는 분 계좌번호 : ");         String sendAccountInput = scan.next();
                System.out.print("비밀번호 : ");                  int passwordInput = scan.nextInt();
                System.out.print("받는 분 계좌번호 : ");           String receiveAccountInput = scan.next();
                System.out.print("이체할 금액 : ");                int sendMoney = scan.nextInt();
                int sendAlert = bankController.sendMoney( sendAccountInput ,  passwordInput , receiveAccountInput , sendMoney );
                if(sendAlert == 1){
                    System.out.println("[안내] 이체가 완료되었습니다.");
                }
                else if(sendAlert == 2) System.out.println("[경고] 잔액이 부족합니다.");
                else if(sendAlert == 3) System.out.println("[경고] 받는 분 계좌정보가 없습니다.");
                else if(sendAlert == 0) System.out.println("[경고] 입금 계좌와 받을 계좌가 일치합니다.");
                else System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
            }
        }   // for 무한루프 end


    }   // main end
}   // class end

class Account{
    String MyAccountNumber; // 계좌번호 멤버변수
    String receiveAccountNumber;   // 받는 사람 계좌번호 멤버변수
    int password;   // 비밀번호 멤버변수
    int money;
}   // class Account end

class BankController{
    Account[] accounts = new Account[100]; // accounts 배열 선언 : 배열길이 100개

    boolean addAccount( String accountNumber , int password ){
        Account account = new Account();    // Account 객체 선언

        account.MyAccountNumber = accountNumber; account.password = password; account.money = 0; // 매개변수 받은 값 멤버변수에 넣기
        account.receiveAccountNumber = accountNumber;
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

        account.MyAccountNumber = accountNumber; account.password = password; account.money = money; // 매개변수 받은 값 멤버변수에 넣기
        boolean error = true;
        for(int i = 0; i< accounts.length; i++){
            if(accounts[i] != null && accounts[i].MyAccountNumber.equals(account.MyAccountNumber) && accounts[i].password == (account.password)){
                accounts[i].money += account.money;
                return true;
            }
        }
        return false;
    }   // func end

    int withdrawMoney(String accountNumber , int password , int money){
        Account account = new Account();    // Account 객체 선언

        account.MyAccountNumber = accountNumber; account.password = password; account.money = money; // 매개변수 받은 값 멤버변수에 넣기

        for(int i = 0; i< accounts.length; i++){
            if(accounts[i] != null && accounts[i].MyAccountNumber.equals(account.MyAccountNumber) && accounts[i].password == (account.password)){
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

        account.MyAccountNumber = accountNumber; account.password = password; // 매개변수 받은 값 멤버변수에 넣기

        for(int i = 0; i< accounts.length; i++){
            if(accounts[i] != null && accounts[i].MyAccountNumber.equals(account.MyAccountNumber) && accounts[i].password == (account.password)){

                return accounts[i].money;
            }
        }
        return -1;
    }

    int sendMoney ( String sendAccountNumber , int password , String receiveAccountNumber , int money ){
        Account account = new Account();    // 객체 부여

        account.MyAccountNumber = sendAccountNumber;            account.password = password;    // 보내는 계좌번호와 그에 맞는 비밀번호 매개변수로 받은 거 멤버변수 대입
        account.receiveAccountNumber = receiveAccountNumber;   account.money = money;           // 받는 계좌번호와 보낼 돈 매개변수로 받은 거 멤버변수 대입

        for(Account accountI : accounts){   // 향상된 for문 Account 객체타입인 accountI라는 변수명을 가진 accounts 배열을 순회한다.
            if(accountI != null){   // 만약 계좌가 하나도 없으면?
                if(accountI.MyAccountNumber.equals(account.MyAccountNumber) && accountI.password == account.password){  // accountI의 계좌번호와 비밀번호가 매개변수에 들어온 것과 일치한가?
                    for(Account accountJ : accounts){   // 받을 계좌번호를 찾기 위한 향상된 for문 Account 객체타입인 accountJ라는 변수명을 가진 accounts 배열을 순회함
                        if(accountJ != null && accountJ.receiveAccountNumber.equals(account.receiveAccountNumber)) {    // 계좌번호가 있는지 매개변수로 받은 받는계좌와 그 안에 있는 계좌가 일치한지
                            if(accountJ == accountI){   // 만약 받는 계좌와 보내는 계좌가 일치한다면?
                                return 0;   // 받는분과 보내는분 계좌가 일치합니다.
                            }   // 받는 계좌와 보내는 계좌가 같은지 확인하는 if end
                            if (accountI.money >= account.money) {  // 돈이 없는데 돈을 보내려고 해?
                                accountI.money -= account.money; // 돈 빼고 대입
                                accountJ.money += account.money;    // 돈 더하고 대입
                                return 1;  // 돈이 이체 됐습니다.
                            } else return 2;   // 이체금액보다 내 잔액이 더 많은지 if end ,, 계좌 잔액이 부족합니다.
                        }   //  받는 계좌가 있는지 없는지 확인 if end
                    }   // for J end
                    return 3; // 받는 분 계좌가 없습니다.
                }   // 내 계좌 비밀번호 맞는지 확인 if end
            }   // 계좌번호 순회하면서 없는지 있는지 확인 if end
        }   // for I end
        return 4;  // 계좌정보가 일치하지 않습니다.
    }
}   // class BankController end
