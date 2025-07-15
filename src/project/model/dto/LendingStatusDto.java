package project.model.dto;  // package

public class LendingStatusDto { // class LendingStatusDto start
    // 멤버변수
    private int loanLog;        // 대출코드

    private String loanDate;    // 대출 시작일
    private String dueDate;     // 대출 종료일

    private int bookLog;        // 도서 목록 코드 ( BookListDto )
    private int memberNo;       // 회원 코드 ( MemberDto )

    // 생성자
    LendingStatusDto(){}

    // 대출 시작일 생성자
    public LendingStatusDto(String loanDate, int loanLog, int bookLog, int memberNo) {
        this.loanDate = loanDate;
        this.loanLog = loanLog;
        this.bookLog = bookLog;
        this.memberNo = memberNo;
    }

    // 대출 종료일 생성자

    public LendingStatusDto( int bookLog, int memberNo, int loanLog , String dueDate ) {
        this.dueDate = dueDate;
        this.bookLog = bookLog;
        this.memberNo = memberNo;
        this.loanLog = loanLog;
    }

    // 모든 생성자

    public LendingStatusDto(int loanLog, String loanDate, String dueDate, int bookLog, int memberNo) {
        this.loanLog = loanLog;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.bookLog = bookLog;
        this.memberNo = memberNo;
    }

    // setter getter


    public int getLoanLog() {
        return loanLog;
    }

    public void setLoanLog(int loanLog) {
        this.loanLog = loanLog;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getBookLog() {
        return bookLog;
    }

    public void setBookLog(int bookLog) {
        this.bookLog = bookLog;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    // toString

    @Override
    public String toString() {
        return "LendingStatusDto{" +
                "loanLog=" + loanLog +
                ", loanDate='" + loanDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", bookLog=" + bookLog +
                ", memberNo=" + memberNo +
                '}';
    }

}   // class LendingStatusDto end
