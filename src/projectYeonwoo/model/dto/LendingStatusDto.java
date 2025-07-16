package projectYeonwoo.model.dto;  // package

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LendingStatusDto { // class LendingStatusDto start
    // 멤버변수
    private int loanLog;        // 대출코드

    private String loanDate;    // 대출 시작일
    private String dueDate;     // 대출 종료일

    private int bookLog;        // 도서 목록 코드 ( BookListDto )
    private int memberNo;       // 회원 코드 ( MemberDto )

    // 생성자
    public LendingStatusDto(){}

    // 대출 시작일 생성자
    public LendingStatusDto(int bookLog , int memberNo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        loanDate = formatter.format( LocalDateTime.now() ) ;
        this.bookLog = bookLog;
        this.memberNo = memberNo;

    }


    // 모든 생성자

    public LendingStatusDto(int loanLog, String loanDate, String dueDate, int bookLog, int memberNo) {
        this.loanLog = loanLog;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.bookLog = bookLog;
        this.memberNo = memberNo;
    }

    // 반납 메소드
    public void setDueDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        dueDate = formatter.format( LocalDateTime.now() ) ;
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
