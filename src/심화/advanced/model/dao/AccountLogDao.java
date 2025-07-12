package 심화.advanced.model.dao;

import 심화.advanced.model.dto.AccountDto;
import 심화.advanced.model.dto.AccountLogDto;

public class AccountLogDao {    // class BankAccountLogDao start
    // 싱글톤 만들기

    private AccountLogDao(){}

    private static final AccountLogDao accountLogDao = new AccountLogDao();

    public static AccountLogDao getInstance() {
        return accountLogDao;
    }

    // 멤버변수 : 배열 ( DB ) 선언

    private static final AccountLogDto[] accountLogDB = new AccountLogDto[100];  // accountLogDB 배열 선언 : 배열길이 100개


    // 메소드

    public boolean accountLogCreate ( AccountLogDto accountLogDto ){
        for( int i = 0; i < accountLogDB.length; i++ ){
            AccountLogDto DB = accountLogDB[i];
            if(DB == null){
                DB = accountLogDto;
                return true;    // 계좌생성 true 반환
            }   // if end
        }   // for i end
        return false;   // DB 다 차있으면 false 반환
    }   // func end

    // 메소드 출력
    public AccountLogDto[] accountLogPrint(){
        return accountLogDB;
    }





}   // class BankAccountLogDao end
