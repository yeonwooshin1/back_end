package 심화.과제3;

class BankController {   // 계좌의 이벤트들을 담당하고 배열을 저장하고 뭐든 다 해주는 BankController 클래스

    Account[] accounts = new Account[100]; // accounts 배열 선언 : 배열길이 100개

    boolean addAccount(String accountNumber, int password) {  // 계좌 추가 메소드        , 매개변수 : 추가할 계좌번호와 추가할 비밀번호
        Account account = new Account();    // Account 객체 선언

        account.setMyAccountNumber(accountNumber);  // setter에 매개변수 넣기
        account.setPassword(password);              // setter에 매개변수 넣기
        account.setMoney(0);                        // setter 초기값 0
        account.setAccountLogs(new AccountLog[100]);    // setter 배열 100개 세팅

        for (int i = 0; i < accounts.length; i++) {    // accounts 배열 순회합시다
            if (accounts[i] == null) {    // accounts 배열의 i 번째 객체가 없다면? 없는 곳에 넣어줘야겠져?
                accounts[i] = account;  // 매개변수로 할당받은 account 객체를 그 i번째 배열에 넣어줍니다.
                return true;    // 난 성공했으니 true를 반환하지
            }   // if end
        }   // for i end
        return false;   // 배열이 꽉찼구나,,, 실패를 반환하지~
    }   // func end

    boolean addMoney(String accountNumber, int password, int money) {  // 돈 입금 메소드     , 매개변수 : 계좌번호와 비밀번호와 입금할 돈
        for (Account account : accounts) {    // accounts 배열 순회
            // accounts 배열의 i번째 객체가 있다면? 그리고 계좌번호가 매개변수로 받은 계좌번호와 일치하고 비밀번호까지 매개변수로 받은 것과 일치한다면?
            if (account != null && account.getMyAccountNumber().equals(accountNumber) && account.getPassword() == (password)) {
                account.setMoney(account.getMoney() + money);  // getter로 돈 가져오고 돈 추가한 후 setter

                AccountLog accountLog = new AccountLog("입금", money, account.getMoney());    // AccountLog 객체 할당 생성자로 입금과 입금한 돈과 현재금액 넣기
                ForInputMethod( account, accountLog );      //  accountLog 넣어주는 메소드 실행

                return true;    // 계좌번호도 맞고 계좌도 존재하고 비밀번호도 맞고 입금도 잘 됐다면 true 반환
            }   // if end
        }   // for i end
        return false;   // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? false , 즉 계좌 정보가 없다는 것을 반환해준다.
    }   // func end

    int withdrawMoney(String accountNumber, int password, int money) { // 잔액 출금 메소드    , 매개변수 : 계좌번호와 비밀번호와 출금할 돈

        for (Account account : accounts) {    // accounts 배열 순회
            // accounts 배열의 i번째 객체가 있다면? 그리고 계좌번호가 매개변수로 받은 계좌번호와 일치하고 비밀번호까지 매개변수로 받은 것과 일치한다면?
            if (account != null && account.getMyAccountNumber().equals(accountNumber) && account.getPassword() == (password)) {
                if (account.getMoney() >= money) { // 만약 accounts의 i번째 객체의 돈이 매개변수로 받은 money 보다 크거나 같다면? 즉 잔액이 더 크면?
                    account.setMoney(account.getMoney() - money);  // getter 해서 원래 돈 가져오고 돈 출금해주고 다시 setter

                    AccountLog accountLog = new AccountLog("출금", -money, account.getMoney());   // AccountLog 객체 할당 생성자로 입금과 입금한 돈과 현재금액 넣기
                    ForInputMethod( account, accountLog );      //  accountLog 넣어주는 메소드 실행

                    return 1;   // 성공했으니 리턴값 1 ;
                } else return 2;  // 잔액도 부족하면서 감히 빼려고 했다면? 2를 리턴해준다.
            }   // if end
        }   // for i end
        return 3;   // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? 3 , 즉 계좌 정보가 없다는 것을 반환해준다.

    }   // func end

    int seeMoney(String accountNumber, int password) {  // 잔액조회 메소드     , 매개변수 : 잔액을 조회할 계좌번호와 비밀번호
        for (Account account : accounts) {    // accounts 배열 순회
            // accounts 배열의 i번째 객체가 있다면? 그리고 계좌번호가 매개변수로 받은 계좌번호와 일치하고 비밀번호까지 매개변수로 받은 것과 일치한다면?
            if (account != null && account.getMyAccountNumber().equals(accountNumber) && account.getPassword() == (password)) {
                return account.getMoney();   // accounts 배열의 i번째 객체의 돈을 반환해준다.
            }   // if end
        }   // for i end
        return -1;  // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? -1 , 즉 계좌 정보가 없다는 것을 반환해준다.
    }

    int sendMoney(String sendAccountNumber, int password, String receiveAccountNumber, int money) {    // 계좌이체 메소드  , 매개변수 : 보낼계좌번호와 비밀번호와 받을 계좌번호와 입금할 돈
        for (Account accountI : accounts) {   // 향상된 for문 Account 객체타입인 accountI라는 변수명을 가진 accounts 배열을 순회한다.
            if (accountI != null) {   // 만약 계좌가 하나도 없으면?
                if (accountI.getMyAccountNumber().equals(sendAccountNumber) && accountI.getPassword() == password) {  // accountI의 계좌번호와 비밀번호가 매개변수에 들어온 것과 일치한가?
                    for (Account accountJ : accounts) {   // 받을 계좌번호를 찾기 위한 향상된 for문 Account 객체타입인 accountJ라는 변수명을 가진 accounts 배열을 순회함
                        if (accountJ != null && accountJ.getMyAccountNumber().equals(receiveAccountNumber)) {    // 계좌번호가 있는지 매개변수로 받은 받는계좌와 그 안에 있는 계좌가 일치한지
                            if (accountJ == accountI) {   // 만약 받는 계좌와 보내는 계좌가 일치한다면?
                                return 0;   // 받는분과 보내는분 계좌가 일치합니다.
                            }   // 받는 계좌와 보내는 계좌가 같은지 확인하는 if end
                            if (accountI.getMoney() >= money) {  // 돈이 없는데 돈을 보내려고 해?
                                accountI.setMoney(accountI.getMoney() - money);   // 이체하는 사람 getter 해서 돈 가져오고 돈 빼고 setter
                                accountJ.setMoney(accountJ.getMoney() + money);   // 이체받는 사람 getter 해서 돈 가져오고 돈 넣고 setter

                                AccountLog accountLogWithdraw = new AccountLog("이체", -money, accountI.getMoney());  // 로그객체 초기값
                                AccountLog accountLogAdd = new AccountLog("이체", money, accountJ.getMoney());        // 로그객체 초기값

                                ForSendMethod(accountI.getAccountLogs(), accountLogWithdraw);  // 값 AccountLog 배열에 넣어주는 매소드
                                ForSendMethod(accountJ.getAccountLogs(), accountLogAdd);       // 값 AccountLog 배열에 넣어주는 매소드

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

    String seeAccountLog(String accountNumber, int password) {  // 계좌내역 출력 메소드        , 매개변수 : 추가할 계좌번호와 추가할 비밀번호
        for (Account account : accounts) {    // accounts 배열 순회합시다
            if (account != null && account.getMyAccountNumber().equals(accountNumber) && account.getPassword() == (password)) { // 만약 account 배열이 존재하고 계좌번호와 비밀번호가 매개변수와 일치한다면?
                String log = "";                // 출력해줄 String log 할당
                for (int j = 0; j < account.getAccountLogs().length; j++) { // 로그 배열 순회
                    if (account.getAccountLogs()[j] != null) {              // 존재한다면?
                        AccountLog L = account.getAccountLogs()[j];         // 간소화
                        if (L.getValueMoney() > 0) {                        // 출금인지 입금인지 판단하는 유효성 검사
                            log += "[" + L.getNow() + "] " + L.getRogValue() + " | +" + L.getValueMoney() + "원 | 잔액 : " + L.getBalance() + "원" + "\n";  // 입금이면 +
                        } else {
                            log += "[" + L.getNow() + "] " + L.getRogValue() + " | " + L.getValueMoney() + "원 | 잔액 : " + L.getBalance() + "원" + "\n";   // 출금이면 -
                        }
                    }   // if end
                }   // for j end
                return log;     // log(입출금, 이체 내역 출력한 값) 값 반환
            }   // if end
        }   // for end
        return "error";   // 비밀번호가 안 맞거나 계좌번호를 잘못 쳤거나 둘 중 하나면 error를 반환
    }   // func end

    public void ForSendMethod(AccountLog[] AccountLogsInput, AccountLog AccountLogInput) {  // 계좌이체 값 할당 헬퍼메소드
        for (int i = 0; i < AccountLogsInput.length; i++) {     // 누구 계좌의 배열인지 매개변수로 받고 AccountLogs 배열 순회
            if (AccountLogsInput[i] == null) {                  // 로그 배열의 값이 비어있다면?
                AccountLogsInput[i] = AccountLogInput;          // 매개변수로 받은 객체 넣기
                break;                                          // 메소드 종료
            }   // if end
        }   // for j end
    }   // func end

    public void ForInputMethod( Account account, AccountLog accountLog ){   // 입출금 값 할당 헬퍼메소드
        for (int j = 0; j < account.getAccountLogs().length; j++) { // 알맞은 계좌 매개변수로 받고 AccountLogs 배열 순회
            AccountLog accountLogs = account.getAccountLogs()[j];   // 간소화
            if (accountLogs == null) {                              // 계좌가 비었으면
                account.getAccountLogs()[j] = accountLog;           // 매개변수로 받은 객체 넣어줌
                break;                                              // 메소드 종료
            }   // if end
        }   // for j end
    }   // func end

}   // class BankController end
