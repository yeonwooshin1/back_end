package 심화.advanced_03_mvc_ArrayList.controller;


import 심화.advanced_03_mvc_ArrayList.model.dao.AccountDao;
import 심화.advanced_03_mvc_ArrayList.model.dao.AccountLogDao;
import 심화.advanced_03_mvc_ArrayList.model.dto.AccountDto;
import 심화.advanced_03_mvc_ArrayList.model.dto.AccountLogDto;


import java.util.ArrayList;

public class BankController {   // class BankController start
    // 싱글톤 만들기

    private BankController(){}

    private static final BankController controller = new BankController();

    public static BankController getInstance(){
        return controller;
    }

    // 싱글톤 가져오기

    AccountDao accountDao = AccountDao.getInstance();
    AccountLogDao accountLogDao = AccountLogDao.getInstance();

    // 메소드

    // 계좌생성 메소드

    public boolean accountCreate( String accountInput , int passwordInput ){
        boolean result = false;

        result = accountDao.accountCreate(accountInput , passwordInput );

        return result;
    }   // func end


    // 계좌 내역 생성 메소드

    public boolean accountLogCreate (String MyAccountNumber , String logType, int valueMoney, int balance){
        boolean result = false;

        result = accountLogDao.accountLogCreate(MyAccountNumber , logType ,valueMoney ,balance);   // 계좌에 계좌로그 넣어줄 메소드

        return result;
    }   // func end

    // 계좌 입금 메소드

    public int accountDeposit( String accountNumber, int password, int money ){
        ArrayList<AccountDto> accountDB = accountDao.accountPrint();  // 배열 가져오기

        for(AccountDto accountDto : accountDB) {    // accounts 배열 순회

            if (accountDto.getMyAccountNumber().equals(accountNumber) && accountDto.getPassword() == (password)){
                accountDto.setMoney(accountDto.getMoney() + money);

                boolean resultLogCreate = accountLogCreate(accountNumber ,"입금" , money , accountDto.getMoney());
                if(resultLogCreate){ return 1; }
                else { return 2; }
            }   // if end
        }   // for end
        return 3;   // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? false , 즉 계좌 정보가 없다는 것을 반환해준다.
    }   // func end

    // 계좌 출금 메소드

    public int accountWithdraw( String accountNumber, int password, int money ){
        ArrayList<AccountDto> accountDB = accountDao.accountPrint();  // 배열 가져오기

        for(AccountDto accountDto : accountDB) {    // accounts 배열 순회
            if (accountDto.getMyAccountNumber().equals(accountNumber) && accountDto.getPassword() == (password)) {

                if (isInsufficientMoney(accountDto, money)) return 0;          // 0 = 잔액 부족

                accountDto.setMoney(accountDto.getMoney() - money);

                boolean log = accountLogCreate(accountNumber, "출금" , - money , accountDto.getMoney());

                return log ? 1 : 2;
            }   // if end
        }   // for end
        return 3;   // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? false , 즉 계좌 정보가 없다는 것을 반환해준다.
    }   // func end


    // 계좌 잔액 확인

    public int accountBalance( String accountNumber , int password ){
        ArrayList<AccountDto> accountDB = accountDao.accountPrint();  // 배열 가져오기

        for(AccountDto accountDto : accountDB) {    // accounts 배열 순회
            if (accountDto.getMyAccountNumber().equals(accountNumber) && accountDto.getPassword() == (password)){
                return accountDto.getMoney();
            }   // if end
        }   // for end
        return -1;   // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? false , 즉 계좌 정보가 없다는 것을 반환해준다.
    }   // func end

    // 계좌 이체

    public String accountTransfer( String accountNumber , int password ,String receiveAccount , int sendMoney ){
        ArrayList<AccountDto> accountDB = accountDao.accountPrint();

        for(AccountDto sendDto : accountDB) {    // accounts 배열 순회
            if (sendDto != null && sendDto.getMyAccountNumber().equals(accountNumber) && sendDto.getPassword() == (password)){
                if (isInsufficientMoney( sendDto, sendMoney )) return "insufficient";

                for( AccountDto receiveDto : accountDB ){
                    if(receiveDto != null && receiveDto.getMyAccountNumber().equals(receiveAccount)){
                        if(sendDto == receiveDto) return "equalAccount";

                        sendDto.setMoney(sendDto.getMoney() - sendMoney);
                        receiveDto.setMoney(receiveDto.getMoney() + sendMoney);

                        boolean sendLog = accountLogCreate (accountNumber ,"출금", - sendMoney, sendDto.getMoney() );
                        boolean receiveLog = accountLogCreate (receiveAccount ,"입금" , + sendMoney, receiveDto.getMoney() );
                        return sendLog&&receiveLog ? "success" : "maxAccountLog" ;
                    }   // if end
                }   // for end
                return "notExitReceiveAccount";
            }   // if end
        }   // for end
        return "accountPwMismatch";   // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? false , 즉 계좌 정보가 없다는 것을 반환해준다.
    }   // func end

    // 계좌내역 출력 메소드

    public String accountLogPrint( String sendAccount, int password ) {
        ArrayList<AccountLogDto> accountLogDB = accountLogDao.accountLogPrint();
        ArrayList<AccountDto> accountDB = accountDao.accountPrint();
        for (int i = 0 ; i < accountDB.size(); i++) {
            AccountDto dto = accountDB.get(i);
            if (dto.getMyAccountNumber().equals(sendAccount) && dto.getPassword() == (password)) { // 만약 account 배열이 존재하고 계좌번호와 비밀번호가 매개변수와 일치한다면?
                String log = "";                // 출력해줄 String log 할당
                for (int j = 0; j < accountLogDB.size(); j++) { // 로그 배열 순회
                    AccountLogDto dtoLog = accountLogDB.get(j);         // 간소화
                    if(dtoLog.getMyAccountNumber().equals( dto.getMyAccountNumber() ) ) { // account 로그와 account의 계좌번호가 같은가?
                        if (dtoLog.getValueMoney() > 0) {                        // 출금인지 입금인지 판단하는 유효성 검사
                            log += "[" + dtoLog.getNow() + "] " + dtoLog.getLogType() + " | +" + dtoLog.getValueMoney() + "원 | 잔액 : " + dtoLog.getBalance() + "원" + "\n";  // 입금이면 +
                        } else {
                            log += "[" + dtoLog.getNow() + "] " + dtoLog.getLogType() + " | " + dtoLog.getValueMoney() + "원 | 잔액 : " + dtoLog.getBalance() + "원" + "\n";   // 출금이면 -
                        }
                    }   // if end
                }   // for j end
                return log;     // log(입출금, 이체 내역 출력한 값) 값 반환
            }   // if end
        }   // for end
        return "error";
    }   // func end


    // 잔액 부족 여부 헬퍼 메소드
    private boolean isInsufficientMoney(AccountDto accountDto, int money) {
        return accountDto.getMoney() < money;
    }

}   // class BankController end
