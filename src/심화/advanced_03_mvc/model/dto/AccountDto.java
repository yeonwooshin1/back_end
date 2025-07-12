package 심화.advanced_03_mvc.model.dto;


public class AccountDto {   // class BankAccountDto start

    // 멤버변수
    private String MyAccountNumber; // 계좌번호 멤버변수
    private int password;           // 비밀번호 멤버변수
    private int money;              // 돈 멤버변수
    private AccountLogDto[] accountLogDB = new AccountLogDto[100];   // 하나의 계좌에 로그를 출력할 배열
    // 생성자
    public AccountDto(){}

    public AccountDto(String myAccountNumber, int password ) {
        this( myAccountNumber ,password , 0 );
    }   // func 생성자 end

    public AccountDto(String myAccountNumber, int password, int money ) {
        MyAccountNumber = myAccountNumber;
        this.password = password;
        this.money = money;
    }   // func 생성자 end


    // setter getter 메소드

        // getter

    public String getMyAccountNumber() {
        return MyAccountNumber;
    }   //getter

    public int getPassword() {
        return password;
    }   // getter

    public int getMoney() { return money; }   // getter

    public AccountLogDto[] getAccountLogDB() { return accountLogDB; }   // getter

    // setter

    public void setMyAccountNumber(String myAccountNumber) { MyAccountNumber = myAccountNumber; }   // setter

    public void setPassword(int password) { this.password = password; }   // setter

    public void setMoney(int money) { this.money = money; }   // setter

    public void setAccountLogDB(AccountLogDto[] accountLogDB) { this.accountLogDB = accountLogDB;}  // setter

// toString

    @Override
    public String toString() {
        return "AccountDto{" +
                "MyAccountNumber='" + MyAccountNumber + '\'' +
                ", password=" + password +
                ", money=" + money +
                '}';
    }   // func toString end

}   // class BankAccountDto end
