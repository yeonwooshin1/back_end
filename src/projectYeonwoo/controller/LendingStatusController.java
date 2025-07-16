package projectYeonwoo.controller;

import projectYeonwoo.model.dao.LendingStatusDao;
import projectYeonwoo.model.dto.LendingStatusDto;

import java.util.ArrayList;

public class LendingStatusController {

    // 싱글톤 만들기

    private LendingStatusController(){}
    private static final LendingStatusController lendingStatusController = new LendingStatusController();
    public static LendingStatusController getInstance(){
        return lendingStatusController;
    }



    // 싱글톤 가져오기
    LendingStatusDao lendingStatusDao = LendingStatusDao.getInstance();
    MemberController memberController = MemberController.getInstance();   // 회원번호 컨트롤러 가져오기
    BookInfoController bookInfoController = BookInfoController.getInstance();   // 책이름 컨트롤러 가져오기

    // 메소드 만들기
    // 등록
    public boolean loanBook( int bookLogInput ){
        int memberNo = memberController.getLogInMno();

        boolean result = false;
        result = lendingStatusDao.loanBook(bookLogInput , memberNo);

        return result;
    }

    // 반납
    public boolean returnBook( int bookLogInput ){
        int memberNo = memberController.getLogInMno();
        boolean result = false;
        result = lendingStatusDao.returnBook(bookLogInput , memberNo );

        return result;
    }

    // 도서 리스트 출력
    public ArrayList<LendingStatusDto> bookState(){
        return lendingStatusDao.bookState();
    }

}
