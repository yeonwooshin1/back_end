package teamProject.controller;

import teamProject.model.dao.BookListDao;
import teamProject.model.dto.BookListDto;

import java.util.ArrayList;

public class BookListController {

    // 싱글톤 만들기
    private BookListController(){}
    private static final BookListController bookListController = new BookListController();
    public static BookListController getInstance(){
        return bookListController;
    }

    // 싱글톤 가져오기
    BookListDao bookListDao = BookListDao.getInstance();

    // 메소드

    // bookList 추가하기
    public void addBookNo( int bookNo ){
        bookListDao.addBookNo(bookNo);
    }

    // 배열 출력
    public ArrayList<BookListDto> bookList(){
        return bookListDao.bookList();
    }

}
