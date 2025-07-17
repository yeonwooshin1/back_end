package teamProject.model.dao;

import teamProject.model.dto.BookInfoDto;

import java.util.ArrayList;

public class BookInfoDao {

    // 싱글톤 만들기
    private BookInfoDao(){}
    private static final BookInfoDao bookInfodao = new BookInfoDao();
    public static BookInfoDao getInstance(){
        return bookInfodao;
    }

    // bookNo 추가
    int count;

    // bookInfoDB 객체 생성
    private ArrayList<BookInfoDto> bookinfoDB = new ArrayList<>();

    // 도서 등록 메소드
    public boolean addBook ( String bookNameInput , String bookAuthorInput ){
        boolean result = false;

        BookInfoDto bookInfoDto = new BookInfoDto(bookNameInput , bookAuthorInput);

        count += 1;              // count를 1 증가
        bookInfoDto.setBookNo(count);

        bookinfoDB.add(bookInfoDto);

        result = true;
        return result;

    }   // func end

    // 도서 번호 출력 메소드
    public int addBookNo(){
        return count;
    }

    // 배열 출력
    public ArrayList<BookInfoDto> bookInfoList(){
        return bookinfoDB;
    }

}
