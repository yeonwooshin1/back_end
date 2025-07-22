package 종합.과제_JDBC.controller;  // package

import 종합.과제_JDBC.model.WaitingDao;
import 종합.과제_JDBC.model.WaitingDto;

import java.util.ArrayList;

public class WaitingController {    // class start
    // 싱글톤 만들기
    private WaitingController(){}
    private static final WaitingController controller = new WaitingController();
    public static WaitingController getInstance(){
        return controller;
    }

    // 싱글톤 가져오기
    WaitingDao dao = WaitingDao.getInstance();

    // 등록 메소드
    public boolean listWrite ( String phone , int count ) {
        // 매개변수로 받은 값 dto 생성자 매개변수에 넣기
        WaitingDto dto = new WaitingDto(phone , count);
        // 그 dto를 dao의 매개변수로 주기 그리고 그 값의 리턴값을 다시 리턴
        return dao.listWrite(dto);
    }   // func end

    // 리스트 반환 메소드
    public ArrayList<WaitingDto> listPrint (){
        // dao 배열 반환값 다시 반환
        return dao.listPrint();
    }   // func end

}   // class end
