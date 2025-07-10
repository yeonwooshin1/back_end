package day_09; // package

public class BankAccount {  // class BankAccount start

    private String accountNumber;   // 접근제어자 private 문자열인 accountNumber 멤버변수

    public BankAccount( String accountNumber){  // 접근제어자 public BankAccount 생성 매개변수 accountNumber을 받는
        this.accountNumber = accountNumber;     // 받은 매개변수값 accountNumber에 대입
    }   // 생성자  end

    public String getAccountNumber(){   // getter public 접근제어자 메소드
        return accountNumber;           // 리턴값 private 멤버변수
    }   // func getter end
}   // class BankAccount end
