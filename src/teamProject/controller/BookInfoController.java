package teamProject.controller;

import teamProject.model.dao.BookInfoDao;
import teamProject.model.dao.MemberDao;
import teamProject.model.dto.BookInfoDto;

import java.util.ArrayList;

public class BookInfoController {


    // 싱글톤 만들기
    private BookInfoController(){}
    private static final BookInfoController bookInfoController = new BookInfoController();
    public static BookInfoController getInstance(){
        return bookInfoController;
    }

    // 싱글톤 가져오기

    BookInfoDao bookInfoDao = BookInfoDao.getInstance();
    MemberDao memberDao = MemberDao.getInstance();

    teamProject.controller.MemberController controller = MemberController.getInstance();   // 컨트롤러 가져오기

    // 메소드
    // 도서 등록 메소드
    public boolean addBook (String bookNameInput , String bookAuthorInput ){
        boolean result = false;

        result = bookInfoDao.addBook( bookNameInput , bookAuthorInput );

        return result;
    }



    // 관리자 권한 가져오기
    public int who (){
        int memberNo = memberDao.getLogInMno();
        return memberNo;

    }

    // 도서 번호 가져오기
    public int addBookNo(){
        return bookInfoDao.addBookNo();
    }


    // 배열 출력
    public ArrayList<BookInfoDto> bookInfoList(){
        return bookInfoDao.bookInfoList();
    }
}
