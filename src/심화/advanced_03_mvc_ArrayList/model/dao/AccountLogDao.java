package 심화.advanced_03_mvc_ArrayList.model.dao; // package

import 심화.advanced_03_mvc_ArrayList.model.dto.AccountDto;
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

    public ArrayList<AccountLogDto> accountLogArray(){
        return accountLogDB;
    }

    // 배열 출력
    public String accountLogPrint (String getMyAccount ){
        String log = "";
        for(AccountLogDto logDB : accountLogDB ){
            if(logDB.getMyAccountNumber().equals(getMyAccount) ){
                if(logDB.getValueMoney() > 0 ){
                    log += "[" + logDB.getNow() + "] " + logDB.getLogType() + " | +" + logDB.getValueMoney() + "원 | 잔액 : " + logDB.getBalance() + "원" + "\n";   // 입금이면 +
                } else {
                    log += "[" + logDB.getNow() + "] " + logDB.getLogType() + " | " + logDB.getValueMoney() + "원 | 잔액 : " + logDB.getBalance() + "원" + "\n";   // 출금이면 -
                }   // if, else end
            }   // if end
        }   // 향상된 for문 end
        return log; // 있는 값 반환해주기
    }   // func end



}   // class AccountLogDao end
