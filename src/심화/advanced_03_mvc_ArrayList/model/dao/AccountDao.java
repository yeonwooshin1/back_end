package 심화.advanced_03_mvc_ArrayList.model.dao;

import 심화.advanced_03_mvc_ArrayList.model.dto.AccountDto;

import java.util.ArrayList;

public class AccountDao {   // class AccountDao
    // 싱글톤 만들기
    private AccountDao (){}
    private static final AccountDao accountDao = new AccountDao();
    public static AccountDao getInstance(){
        return accountDao;
    }

    // 배열 생성
    ArrayList< AccountDto > accountDB = new ArrayList<>();

    // 배열에 객체 넣기

    public boolean accountCreate( String accountInput , int passwordInput ){
        boolean result = false;

        AccountDto accountDto = new AccountDto( accountInput , passwordInput );
        accountDB.add(accountDto);

        result = true;
        return result;
    }


    // 배열 반환

    public ArrayList< AccountDto > accountPrint(){
        return accountDB;
    }   // func end


}   // AccountDao
