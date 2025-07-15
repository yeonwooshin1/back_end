package project.model.dao;

import project.model.dto.BookInfoDto;

import java.util.ArrayList;

public class BookInfoDao {
    // 싱글톤 만들기
    private BookInfoDao(){}
    private static final BookInfoDao bookInfodao = new BookInfoDao();
    public static BookInfoDao getInstance(){
        return bookInfodao;
    }

    // bookinfoDB 객체 생성
    private ArrayList<BookInfoDto> bookinfoDB = new ArrayList<>();

}
