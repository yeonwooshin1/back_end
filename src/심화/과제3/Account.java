package 심화.과제3;

class Account {  // 객체를 담당하는 Account 클래스 생성
    private String MyAccountNumber; // 계좌번호 멤버변수
    private int password;   // 비밀번호 멤버변수
    private int money;  // 돈 돈 돈!
    private AccountLog[] accountLogs;   // 하나의 계좌에 로그를 출력할 배열

    public String getMyAccountNumber() {
        return MyAccountNumber;
    }   //getter

    public int getPassword() {
        return password;
    }   // getter

    public int getMoney() {
        return money;
    }   // getter

    public AccountLog[] getAccountLogs() {
        return accountLogs;
    }   // getter

    public void setMyAccountNumber(String myAccountNumber) {
        MyAccountNumber = myAccountNumber;
    }   // setter

    public void setPassword(int password) {
        this.password = password;
    }   // setter

    public void setMoney(int money) {
        this.money = money;
    }   // setter

    public void setAccountLogs(AccountLog[] accountLogs) {
        this.accountLogs = accountLogs;
    }   // setter
}   // class Account end
