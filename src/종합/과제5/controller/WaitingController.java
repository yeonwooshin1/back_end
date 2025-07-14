package 종합.과제5.controller;

import 종합.과제5.model.WaitingDao;
import 종합.과제5.model.WaitingDto;

public class WaitingController {    // class start
    // 싱글톤 만들기
    private WaitingController(){}

    private static final WaitingController control = new WaitingController();

    public static WaitingController getInstance(){
        return control;
    }

    // dao 멤버변수 가져오기 싱글톤으로
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // boardWrite 등록 메소드

    public boolean boardWrite ( String phoneInput , int countInput ){
        WaitingDto waitingDto = new WaitingDto( phoneInput , countInput );
        return waitingDao.boardWrite(waitingDto);

    }   // func end

    // boardPrint 출력 메소드

    public WaitingDto[] boardPrint(){
        WaitingDto[] result = waitingDao.boardPrint();
        return result;
    }   // func end

}   // class end
