package 심화.advanced_03_mvc_ArrayList.model.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountLogDto {    // class BankAccountLogDto start

    // 멤버변수
    private String MyAccountNumber; // 식별 계좌번호
    private String logType;    // 입금 출금 타입 멤버변수
    private int valueMoney;     // 넣은 금액 멤버변수
    private int balance;        // 잔액 멤버변수
    private String now;         // 현재 시간 멤버변수

    // 생성자
    public AccountLogDto(){}

    public AccountLogDto(String MyAccountNumber ,String logType, int valueMoney, int balance) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");   // 날짜함수
        now = formatter.format(LocalDateTime.now());

        this.MyAccountNumber = MyAccountNumber;
        this.logType = logType;
        this.valueMoney = valueMoney;
        this.balance = balance;
    }   // func 생성자 end

    // setter getter

    // setter


    public String getMyAccountNumber() { return MyAccountNumber; }  // getter

    public void setMyAccountNumber(String myAccountNumber) { MyAccountNumber = myAccountNumber; }   // setter

    public String getLogType() { return logType; }  // getter

    public void setLogType(String logType) { this.logType = logType; } // setter

    public int getValueMoney() { return valueMoney;} // getter

    public void setValueMoney(int valueMoney) { this.valueMoney = valueMoney; } // setter

    // getter

    public int getBalance() { return balance; } // getter

    public void setBalance(int balance) { this.balance = balance; } // setter

    public String getNow() { return now; }  // getter

    public void setNow(String now) { this.now = now; }  // setter

    // toString


    @Override
    public String toString() {
        return "AccountLogDto{" +
                "MyAccountNumber='" + MyAccountNumber + '\'' +
                ", logType='" + logType + '\'' +
                ", valueMoney=" + valueMoney +
                ", balance=" + balance +
                ", now='" + now + '\'' +
                '}';
    }
}   // class BankAccountLogDto end
