package 심화.advanced.controller;

import 심화.advanced.model.dao.AccountDao;
import 심화.advanced.model.dao.AccountLogDao;
import 심화.advanced.model.dto.AccountDto;
import 심화.advanced.model.dto.AccountLogDto;



public class BankController {   // class BankController start
    // 싱글톤 만들기

    private BankController(){}

    private static final BankController controller = new BankController();

    public static BankController getInstance(){
        return controller;
    }

    // 싱글톤 가져오기 : Dao DB 가져오기

    AccountDao accountDao = AccountDao.getInstance();
    AccountLogDao accountLogDao = AccountLogDao.getInstance();

    // 메소드

    // 계좌 생성 메소드

    public boolean accountCreate (String accountInput , int passwordInput ){
        accountLogCreate(); // 계좌내역 생성 메소드
        AccountDto accountDto = new AccountDto( accountInput, passwordInput , accountLogCreate() );

        boolean resultCreate = accountDao.accountCreate(accountDto);
        return resultCreate;

    }   // func end

    // 계좌 내역 생성 메소드

    public boolean accountLogCreateter (String accountNumber , String logType, int valueMoney, int balance){
        AccountLogDto accountLogDto = new AccountLogDto( logType, valueMoney , balance );

        boolean result = accountDao.accountLogInput(accountLogDto ,accountNumber);   // 계좌에 계좌로그 넣어줄 메소드
        return result;
    }   // func end


    // 계좌 생성시 계좌내역 생성 하기 헬퍼 메소드
    public AccountLogDto[] accountLogCreate ( ){
        AccountLogDto[] AccountLogDB = accountLogDao.accountLogPrint();
        return AccountLogDB;
    }

    // 계좌 입금 메소드

    public int accountDeposit( String accountNumber, int password, int money ){
        AccountDto[] accountDB = accountDao.accountPrint();  // 배열 가져오기

        for(AccountDto accountDto : accountDB) {    // accounts 배열 순회

            if (accountDto != null && accountDto.getMyAccountNumber().equals(accountNumber) && accountDto.getPassword() == (password)){
                accountDto.setMoney(accountDto.getMoney() + money);

                boolean resultLogCreate = accountLogCreateter(accountNumber ,"입금" , money , accountDto.getMoney());
                if(resultLogCreate){ return 1; }
                else { return 2; }
            }   // if end
        }   // for end
        return 3;   // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? false , 즉 계좌 정보가 없다는 것을 반환해준다.
    }


    // 계좌 출금 메소드

    public int accountWithdraw( String accountNumber, int password, int money ){
        AccountDto[] accountDB = accountDao.accountPrint();  // 배열 가져오기

        for(AccountDto accountDto : accountDB) {    // accounts 배열 순회
            if (accountDto != null && accountDto.getMyAccountNumber().equals(accountNumber) && accountDto.getPassword() == (password)) {

                if (isInsufficientMoney(accountDto, money)) return 0;          // 0 = 잔액 부족

                accountDto.setMoney(accountDto.getMoney() - money);

                boolean log = accountLogCreateter(accountNumber, "출금" , - money , accountDto.getMoney());

                return log ? 1 : 2;
            }   // if end
        }   // for end
        return 3;   // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? false , 즉 계좌 정보가 없다는 것을 반환해준다.
    }


    // 계좌 잔액 확인

    public int accountBalance( String accountNumber , int password ){
        AccountDto[] accountDB = accountDao.accountPrint();

        for(AccountDto accountDto : accountDB) {    // accounts 배열 순회
            if (accountDto != null && accountDto.getMyAccountNumber().equals(accountNumber) && accountDto.getPassword() == (password)){
                return accountDto.getMoney();
            }   // if end
        }   // for end
        return -1;   // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? false , 즉 계좌 정보가 없다는 것을 반환해준다.
    }   // func end

    // 계좌 이체

    public String accountTransfer( String accountNumber , int password ,String receiveAccount , int sendMoney ){
        AccountDto[] accountDB = accountDao.accountPrint();

        for(AccountDto sendDto : accountDB) {    // accounts 배열 순회
            if (sendDto != null && sendDto.getMyAccountNumber().equals(accountNumber) && sendDto.getPassword() == (password)){
                if (isInsufficientMoney( sendDto, sendMoney )) return "insufficient";

                for( AccountDto receiveDto : accountDB ){
                    if(receiveDto != null && receiveDto.getMyAccountNumber().equals(receiveAccount)){
                        if(sendDto == receiveDto) return "equalAccount";

                        sendDto.setMoney(sendDto.getMoney() - sendMoney);
                        receiveDto.setMoney(receiveDto.getMoney() + sendMoney);

                        boolean sendLog = accountLogCreateter (accountNumber ,"출금", - sendMoney, sendDto.getMoney() );
                        boolean receiveLog = accountLogCreateter (receiveAccount ,"입금" , + sendMoney, receiveDto.getMoney() );
                        return sendLog&&receiveLog ? "success" : "maxAccountLog" ;
                    }
                }
                return "notExitReceiveAccount";
            }   // if end
        }   // for end
        return "accountPwMismatch";   // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? false , 즉 계좌 정보가 없다는 것을 반환해준다.
    }




    //
    /** true = 잔액이 부족하다 */
    // 잔액 부족 여부 헬퍼 메소드
    private boolean isInsufficientMoney(AccountDto accountDto, int money) {
        return accountDto.getMoney() < money;
    }


}   // class BankController end
