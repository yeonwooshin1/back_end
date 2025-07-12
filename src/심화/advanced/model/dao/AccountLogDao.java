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

    private AccountLogDto[] accountLogDB = new AccountLogDto[100];  // accountLogDB 배열 선언 : 배열길이 100개

    // 메소드 출력
    public AccountLogDto[] accountLogPrint(){
        return accountLogDB;
    }


}   // class BankAccountLogDao end
