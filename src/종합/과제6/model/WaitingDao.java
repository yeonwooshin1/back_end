package 종합.과제6.model;   // package

import java.util.ArrayList;

public class WaitingDao {   // class WaitingDao start

    // 싱글톤 만들기
    private WaitingDao(){}
    private static final WaitingDao waitingDao = new WaitingDao();
    public static WaitingDao getInstance() {
        return waitingDao;
    }   // getter

    // 멤버변수 배열 ArrayList

    ArrayList< WaitingDto > waitingDB = new ArrayList<>();  // WaitingDto 객체 ArrayList에 넣기

    // 등록 메소드
    public boolean addWaitingList( String phoneInput , int countInput ) {
        boolean result = false; // 초기값 false
        WaitingDto waitingDto = new WaitingDto(phoneInput, countInput); // 매개변수 받은 거 생성자로 넣기
        waitingDB.add(waitingDto);  // add.(waitingDto 넣기)
        result = true;  // 값 true로 지정
        return result;  // 그 값 반환
    }   // func end


    // 출력 메소드

    public ArrayList< WaitingDto > getWaitingList(){
        return waitingDB;   // ArrayList 배열 리턴
    }   // func end

}   // clas WaitingDao end
