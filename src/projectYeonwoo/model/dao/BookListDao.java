package projectYeonwoo.model.dao;

import projectYeonwoo.model.dto.BookListDto;

import java.util.ArrayList;

public class BookListDao {
    // 싱글톤 만들기
    private BookListDao(){}
    private static final BookListDao bookListDao = new BookListDao();
    public static BookListDao getInstance(){
        return bookListDao;
    }

    // bookLog 추가
    int count;

    // booklistDB 객체 생성
    private ArrayList<BookListDto> booklistDB = new ArrayList<>();

    // 메소드

    // 등록
    public void addBookNo( int bookNo ){
        BookListDto bookListDto = new BookListDto( bookNo );

        count++;              // count를 1 증가
        bookListDto.setBookLog(count);

        booklistDB.add(bookListDto);

    }

    // 배열 출력
    public ArrayList<BookListDto> bookList(){
        return booklistDB;
    }


}
