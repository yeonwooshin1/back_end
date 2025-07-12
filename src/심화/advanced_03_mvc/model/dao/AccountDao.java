package 심화.advanced_03_mvc.model.dao;


import 심화.advanced_03_mvc.model.dto.AccountDto;
import 심화.advanced_03_mvc.model.dto.AccountLogDto;

public class AccountDao {   // class BankAccountDao start

    // 싱글톤 만들기

    private AccountDao(){}

    private static final AccountDao accountDao = new AccountDao();

    public static AccountDao getInstance() {
        return accountDao;
    }

    // 멤버변수 : 배열 ( DB ) 선언

    private static final AccountDto[] accountDB = new AccountDto[100]; // accountDB 배열 선언 : 배열길이 100개

    // 메소드
    // 계좌생성 메소드
    public boolean accountCreate ( AccountDto accountDto ){
        for( int i = 0; i < accountDB.length; i++ ){
            if(accountDB[i] == null){
                accountDB[i] = accountDto;
                return true;    // 계좌생성 true 반환
            }   // if end
        }   // for i end
        return false;   // DB 다 차있으면 false 반환
    }   // func end

    // 메소드 2
    // 계좌내역 출력 메소드
    public boolean accountLogInput(AccountLogDto accountLogDto , String accountNumber){
        for (int i = 0; i < accountDB.length; i++) {
            if(accountDB[i].getMyAccountNumber().equals(accountNumber)){
                for (int j = 0; j < accountDB[i].getAccountLogDB().length; j++) {
                    if(accountDB[i].getAccountLogDB()[j] == null){
                        accountDB[i].getAccountLogDB()[j] = accountLogDto;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 매소드 호출

    public AccountDto[] accountPrint(){
        return accountDB;
    }


}   // class BankAccountDao end
