package projectYeonwoo.model.dto;  // package

public class BookListDto {  // class BookListDto start
    // 멤버변수
    private int bookLog;    // 도서 목록 코드
    private int bookNo;     // 도서 정보 코드 ( BookInfoDto )

    // 생성자
    public BookListDto(){}

    // 책 대출 생성자

    public BookListDto( int bookNo) {
        this.bookNo = bookNo;
    }   // func 책 대출 생성자 end


    // getter setter


    public int getBookLog() {
        return bookLog;
    }

    public void setBookLog(int bookLog) {
        this.bookLog = bookLog;
    }

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    // toString

    @Override
    public String toString() {
        return "BookListDto{" +
                "bookLog=" + bookLog +
                ", bookNo=" + bookNo +
                '}';
    }

}   // class BookListDto end
