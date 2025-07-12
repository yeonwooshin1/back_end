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
    public boolean accountLogCreate (String logType, int valueMoney, int balance){
        AccountLogDto accountLogDto = new AccountLogDto( logType, valueMoney , balance );

        boolean resultLogCreate = accountLogDao.accountLogCreate(accountLogDto);
        return resultLogCreate;

    }   // func end


    // 계좌 생성시 계좌내역 생성 하기 헬퍼 메소드
    public AccountLogDto[] accountLogCreate ( ){
        AccountLogDto[] AccountLogDB = accountLogDao.accountLogPrint();
        return AccountLogDB;
    }

    // 계좌 번호 입금 메소드

    public int accountDeposit( String accountNumber, int password, int money ){
        AccountDto[] accountDB = accountDao.accountPrint();  // 배열 가져오기

        for (AccountDto accountdto : accountDB) {    // accounts 배열 순회

            if (accountdto != null && accountdto.getMyAccountNumber().equals(accountNumber) && accountdto.getPassword() == (password)) {
                accountdto.setMoney(accountdto.getMoney() + money);

                boolean resultLogCreate = accountLogCreate("입금" , money , accountdto.getMoney());
                if(resultLogCreate){ return 1; }
                else { return 2; }
            }   // if end
        }   // for i end
        return 3;   // 만약 if 조건문을 부합하지 않고 반복문이 끝났다면? false , 즉 계좌 정보가 없다는 것을 반환해준다.
    }





}   // class BankController end
