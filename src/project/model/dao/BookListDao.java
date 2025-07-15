package project.model.dao;

import project.model.dto.BookListDto;

import java.util.ArrayList;

public class BookListDao {
    // 싱글톤 만들기
    private BookListDao(){}
    private static final BookListDao bookListDao = new BookListDao();
    public static BookListDao getInstance(){
        return bookListDao;
    }

    // booklistDB 객체 생성
    private ArrayList<BookListDto> booklistDB = new ArrayList<>();
}
