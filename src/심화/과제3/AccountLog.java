package 심화.과제3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class AccountLog { // class AccountLog start
    private String rogValue;    // 입금인지 출금인지 알려주는것
    private int valueMoney;     // 얼마를 넣었는지
    private int balance;        // 잔액을 알려줌
    private String now;         // 시간을 알려줌

    public AccountLog(String rogValue, int valueMoney, int balance) {   // 생성자 AccountLog 입금, 출금, 계좌이체인지 확인하는 것 , 얼마를 줬는지 확인하는 돈, 잔액 남은거 찍을 매개변수
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");   // 날짜함수
        now = formatter.format(LocalDateTime.now());                                        // 시간 나타냄
        this.rogValue = rogValue;                                                           // 멤버변수 할당
        this.valueMoney = valueMoney;                                                       // 멤버변수 할당
        this.balance = balance;                                                             // 멤버변수 할당
    }   // 생성자 AccountLog end

    public int getValueMoney() {
        return valueMoney;
    }   // getter

    public String getRogValue() {
        return rogValue;
    }   // getter

    public int getBalance() {
        return balance;
    }   // getter

    public String getNow() {
        return now;
    }   // getter

    public void setRogValue(String rogValue) {  // setter
        this.rogValue = rogValue;
    }

    public void setValueMoney(int valueMoney) { // setter
        this.valueMoney = valueMoney;
    }

    public void setBalance(int balance) {   // setter
        this.balance = balance;
    }

    public void setNow(String now) {    // setter
        this.now = now;
    }
}   // class AccountLog end
