package projectYeonwoo.model.dto;  // package

public class BookInfoDto {  // class BookInfoDto start
    // 멤버변수
    private int bookNo;         // 책 정보 코드
    private String bookName;    // 책 이름
    private String bookAuthor;  // 책 저자

    // 생성자
    public BookInfoDto(){}

    // 도서등록 생성자
    public BookInfoDto(String bookName, String bookAuthor) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }   // func 생성자 end


    // getter setter


    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    // toString

    @Override
    public String toString() {
        return "BookInfoDto{" +
                "bookNo=" + bookNo +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }

}   // class BookInfoDto end
