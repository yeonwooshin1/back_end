package project.controller;

import project.model.dao.LendingStatusDao;
import project.model.dao.MemberDao;
import project.model.dto.LendingStatusDto;

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
    MemberDao memberDao = MemberDao.getInstance();   // 회원번호 컨트롤러 가져오기


    // 메소드 만들기
    // 등록
    public boolean loanBook( int bookLogInput ){
        int memberNo = memberDao.getLogInMno();

        boolean result = false;
        result = lendingStatusDao.loanBook(bookLogInput , memberNo);

        return result;
    }

    // 반납
    public boolean returnBook( int bookLogInput ){
        int memberNo = memberDao.getLogInMno();
        boolean result = false;
        result = lendingStatusDao.returnBook(bookLogInput , memberNo );

        return result;
    }

    // 도서 리스트 출력
    public ArrayList<LendingStatusDto> bookState(){
        return lendingStatusDao.bookState();
    }

}
