package 심화.과제2; // package

import java.util.Scanner;

public class BankService {  // class start
    public static void main(String[] args) {    // main start

        BankController bankController = new BankController();   // BankController 클래스 bs 객체 할당

        Scanner scan = new Scanner(System.in);  // 스캐너 할당 변수명 : scan

        for(;;){    // 무한으로 즐겨요 명륜진사 for문~
            System.out.println("==================== KB Bank ===================");
            System.out.println("  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체 ");
            System.out.println("================================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();    // choose scan 받기 1,2,3,4,5 중에
            if(choose == 1){    // 1이라면? 계좌등록
                System.out.println("--- 계좌 등록 ---");
                System.out.print("계좌번호 : ");         String accountInput =  scan.next();    // 인자값 계좌번호 받기
                System.out.print("비밀번호 : ");       int passwordInput =  scan.nextInt();     // 인수값 비밀번호 받기
                boolean alert = bankController.addAccount( accountInput , passwordInput );     // 계좌번호 추가 boolean 타입인 addAccount 메소드 호출 후 alert 변수명에 대입
                if(alert){System.out.println("[안내] 계좌 등록이 완료되었습니다.");}              // 만약 alert가 true라면 ?
                else{ System.out.println("[경고] 계좌 한도에 도달 하셨습니다.");}                 // 만약 alert가 false라면 ?
            }   // if choose 1 end

            if(choose == 2){    // 2라면? 입금
                System.out.println("--- 입금 ---");
                System.out.print("계좌번호 : ");         String accountInput = scan.next(); // 인자값 계좌번호 받기
                System.out.print("비밀번호 : ");       int passwordInput = scan.nextInt();  // 인수값 비밀번호 받기
                System.out.print("입금액 : ");       int moneyInput = scan.nextInt();      // 인수값 입금할 돈 받기
                boolean addAlert = bankController.addMoney( accountInput , passwordInput , moneyInput );    // 입금할 boolean 타입인 addMoney 메소드 호출 후 addAlert 변수명에 대입
                if(addAlert){System.out.println("[안내] 입금이 완료되었습니다.");}            // 만약 addAlert가 true라면 ?
                else{ System.out.println("[경고] 계좌정보가 일치하지 않습니다.");}             // 만약 addAlert가 false라면 ?
            }   // if choose 2 end

            if(choose == 3){    // 3이라면? 출금
                System.out.println("--- 출금 ---");
                System.out.print("계좌번호 : ");         String accountInput = scan.next(); // 인자값 계좌번호 받기
                System.out.print("비밀번호 : ");       int passwordInput = scan.nextInt();  // 인수값 비밀번호 받기
                System.out.print("출금액 : ");       int moneyInput = scan.nextInt();      // 인수값 출금할 돈 받기
                int withdrawAlert = bankController.withdrawMoney( accountInput , passwordInput , moneyInput );  // 출금할 int 타입인 withdrawMoney 메소드 호출 후 withdrawAlert 변수명에 대입
                if(withdrawAlert == 1 ){System.out.println("[안내] 출금이 완료되었습니다.");}   // 만약 withdrawAlert 리턴값이 1이라면?
                else if(withdrawAlert == 2){ System.out.println("[경고] 잔액이 부족합니다.");}    // 만약 withdrawAlert 리턴값이 2라면?
                else{System.out.println("[경고] 계좌정보가 일치하지 않습니다.");}                  // 만약 withdrawAlert값이 1 2가 아닌 다른 값이라면?
            } // if choose 3 end

            if(choose == 4){    // 4라? 잔액확인
                System.out.println("--- 잔고 확인 ---");
                System.out.print("계좌번호 : ");         String accountInput = scan.next(); // 인자값 계좌번호 받기
                System.out.print("비밀번호 : ");       int passwordInput = scan.nextInt();  // 인수값 비밀번호 받기
                int seeAlert = bankController.seeMoney( accountInput ,  passwordInput); // 잔액확인할 int 타입인 seeMoney 메소드 호출 후 seeAlert 변수명에 대입
                if(seeAlert != -1){ // 만약 seeAlert 리턴값이 -1이 아니라면?
                    System.out.println("[잔고] "+ seeAlert+ "원"); // 잔고로 seeAlert 리턴값 출력
                }
                else{ System.out.println("[경고] 계좌정보가 일치하지 않습니다.");} // seeAlert 리턴값이 -1이라면?
            }   // if choose 4 end

            if(choose == 5){    // 5라면? 계좌이체
                System.out.println("--- 계좌 이체 ---");
                System.out.print("보내는 분 계좌번호 : ");         String sendAccountInput = scan.next();   // 인자값 보낼계좌명 받기
                System.out.print("비밀번호 : ");                  int passwordInput = scan.nextInt();       // 인수값 비밀번호 받기
                System.out.print("받는 분 계좌번호 : ");           String receiveAccountInput = scan.next();   // 인자값 받을계좌명 받기
                System.out.print("이체할 금액 : ");                int sendMoney = scan.nextInt();               // 인수값 보낼 돈 받기
                int sendAlert = bankController.sendMoney( sendAccountInput ,  passwordInput , receiveAccountInput , sendMoney );    // 계좌이체할 sendMoney 메소드 호출, sendAlert가 변수명
                if(sendAlert == 1){                                                     // 만약 seeAlert가 1이라면?
                    System.out.println("[안내] 이체가 완료되었습니다.");                    // 이체 완료 안내
                }
                else if(sendAlert == 2) System.out.println("[경고] 잔액이 부족합니다.");  // 만약 seeAlert가 2라면? 잔액 부족
                else if(sendAlert == 3) System.out.println("[경고] 받는 분 계좌정보가 없습니다.");    // 만약 seeAlert가 3이라면? 받는 계좌정보 없음
                else if(sendAlert == 0) System.out.println("[경고] 입금 계좌와 받을 계좌가 일치합니다.");    // 만약 seeAlert가 0이라면? 보낼 계좌번호와 받을 계좌번호 일치로 인한 오류
                else System.out.println("[경고] 계좌정보가 일치하지 않습니다.");   // 만약 seeAlert가 다른 리턴값을 가진다면? 보낼 계좌번호에서 계좌번호가 없던가 비밀번호가 틀리던가 둘 중 하나겠죠
            }   // if choose 5 end

        }   // for 무한루프 end


    }   // main end
}   // class end

class Account{  // 객체를 담당하는 Account 클래스 생성
    String MyAccountNumber; // 계좌번호 멤버변수
    String receiveAccountNumber;   // 받는 사람 계좌번호 멤버변수
    int password;   // 비밀번호 멤버변수
    int money;  // 돈 돈 돈!
}   // class Account end

class BankController{   // 계좌의 이벤트들을 담당하고 배열을 저장하고 뭐든 다 해주는 BankController 클래스

    Account[] accounts = new Account[100]; // accounts 배열 선언 : 배열길이 100개

    boolean addAccount( String accountNumber , int password ){  // 계좌 추가 메소드        , 매개변수 : 추가할 계좌번호와 추가할 비밀번호
        Account account = new Account();    // Account 객체 선언

        account.MyAccountNumber = accountNumber; account.password = password; account.money = 0; // 매개변수 받은 값 멤버변수에 넣기
        account.receiveAccountNumber = accountNumber;   // 매개변수 값 멤버변수에 넣기
        for(int i = 0; i< accounts.length; i++){    // accounts 배열 순회합시다
            if(accounts[i] == null){    // accounts 배열의 i 번째 객체가 없다면? 없는 곳에 넣어줘야겠져?
                accounts[i] = account;  // 매개변수로 할당받은 account 객체를 그 i번째 배열에 넣어줍니다.
                return true;    // 난 성공했으니 true를 반환하지
            }
        }
        return false;   // 배열이 꽉찼구나,,, 실패를 반환하지~
    }   // func end

    boolean addMoney(String accountNumber , int password , int money){  // 돈 입금 메소드     , 매개변수 : 계좌번호와 비밀번호와 입금할 돈
        Account account = new Account();    // Account 객체 선언

        account.MyAccountNumber = accountNumber; account.password = password; account.money = money; // 매개변수 받은 값 멤버변수에 넣기
        for(int i = 0; i< accounts.length; i++){    // accounts 배열 순회
            // accounts 배열의 i번째 객체가 있다면? 그리고 계좌번호가 매개변수로 받은 계좌번호와 일치하고 비밀번호까지 매개변수로 받은 것과 일치한다면?
            if(accounts[i] != null && accounts[i].MyAccountNumber.equals(account.MyAccountNumber) && accounts[i].password == (account.password)){
                accounts[i].money += account.money; // 더해주고 대입 ;;;;   입금할 금액 만큼 그냥 주는 은행이 있다? 무한 show me the money(?) -신연우-
                return true;    // 계좌번호도 맞고 계좌도 존재하고 비밀번호도 맞고 입금도 잘 됐다면 true 반환
            }   // if end
        }   // for i end
        return false;   // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? false , 즉 계좌 정보가 없다는 것을 반환해준다.
    }   // func end

    int withdrawMoney(String accountNumber , int password , int money){ // 잔액 출금 메소드    , 매개변수 : 계좌번호와 비밀번호와 출금할 돈
        Account account = new Account();    // Account 객체 선언

        account.MyAccountNumber = accountNumber; account.password = password; account.money = money; // 매개변수 받은 값 멤버변수에 넣기

        for(int i = 0; i< accounts.length; i++){    // accounts 배열 순회
            // accounts 배열의 i번째 객체가 있다면? 그리고 계좌번호가 매개변수로 받은 계좌번호와 일치하고 비밀번호까지 매개변수로 받은 것과 일치한다면?
            if(accounts[i] != null && accounts[i].MyAccountNumber.equals(account.MyAccountNumber) && accounts[i].password == (account.password)){
                if(accounts[i].money >= account.money){ // 만약 accounts의 i번째 객체의 돈이 매개변수로 받은 money보다 크거나 같다면? 즉 잔액이 더 크면?
                    accounts[i].money -= account.money; // 빼주고 대입
                    return 1;   // 성공했으니 리턴값 1 ;
                }
                else return 2;  // 잔액도 부족하면서 감히 빼려고 했다면? 2를 리턴해준다.
            }   // if end
        }   // for i end
        return 3;   // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? 3 , 즉 계좌 정보가 없다는 것을 반환해준다.

    }   // func end

    int seeMoney(String accountNumber , int password){  // 잔액조회 메소드     , 매개변수 : 잔액을 조회할 계좌번호와 비밀번호
        Account account = new Account();    // Account 객체 선언

        account.MyAccountNumber = accountNumber; account.password = password; // 매개변수 받은 값 멤버변수에 넣기

        for(int i = 0; i< accounts.length; i++){    // accounts 배열 순회
            // accounts 배열의 i번째 객체가 있다면? 그리고 계좌번호가 매개변수로 받은 계좌번호와 일치하고 비밀번호까지 매개변수로 받은 것과 일치한다면?
            if(accounts[i] != null && accounts[i].MyAccountNumber.equals(account.MyAccountNumber) && accounts[i].password == (account.password)){

                return accounts[i].money;   // accounts 배열의 i번째 객체의 돈을 반환해준다.
            }   // if end
        }   // for i end
        return -1;  // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? -1 , 즉 계좌 정보가 없다는 것을 반환해준다.
    }

    int sendMoney ( String sendAccountNumber , int password , String receiveAccountNumber , int money ){    // 계좌이체 메소드  , 매개변수 : 보낼계좌번호와 비밀번호와 받을 계좌번호와 입금할 돈
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
