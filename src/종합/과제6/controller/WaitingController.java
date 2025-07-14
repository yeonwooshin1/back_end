package 종합.과제6.controller;  // package


import 종합.과제6.model.WaitingDao;
import 종합.과제6.model.WaitingDto;

import java.util.ArrayList;

public class WaitingController {    // class WaitingController start
    // 싱글톤 만들기
    private WaitingController(){}
    private static final WaitingController controller = new WaitingController();
    public static WaitingController getInstance() {
        return controller;
    }   // getter

    // 싱글톤 가져오기

    private final WaitingDao dao = WaitingDao.getInstance();    // WaitingDao


    // 1. 등록 메소드 addWaitingList()

    public boolean addWaitingList( String phoneInput , int countInput ){
        boolean result = false; // false

        result = dao.addWaitingList( phoneInput , countInput ); // 넘겨주기

        return result;  // 값 받아오기
    }   // func end


    // 2. 출력 메소드 getWaitingList()

    public ArrayList<WaitingDto> getWaitingList(){
        return dao.getWaitingList();    // 배열 받아오기
    }   // func end



}   // class WaitingController end
