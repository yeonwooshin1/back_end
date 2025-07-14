package 심화.advanced_03_mvc_ArrayList.model.dao; // package

import 심화.advanced_03_mvc_ArrayList.model.dto.AccountLogDto;

import java.util.ArrayList;

public class AccountLogDao {    // class AccountLogDao start

    // 싱글톤 만들기
    private AccountLogDao(){}

    private static final AccountLogDao accountLogDao = new AccountLogDao();

    public static AccountLogDao getInstance(){
        return accountLogDao;
    }

    // 배열 생성
    ArrayList<AccountLogDto> accountLogDB = new ArrayList<>();

    // 배열 넣기

    public boolean accountLogCreate(String MyAccountNumber ,String logType, int valueMoney, int balance ){
        boolean result = false;
        AccountLogDto accountLogDto = new AccountLogDto( MyAccountNumber , logType , valueMoney ,balance );
        accountLogDB.add(accountLogDto);

        result = true;

        return result;
    }   // func end


    // 배열 반환

    public ArrayList<AccountLogDto> accountLogPrint(){
        return accountLogDB;
    }










}   // class AccountLogDao end
