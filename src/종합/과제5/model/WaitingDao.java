package 종합.과제5.model;

public class WaitingDao {   // class start
    // 싱글 톤 만들기
    private WaitingDao(){}

    private static final WaitingDao dao = new WaitingDao();

    public static WaitingDao getInstance(){
        return dao;
    }

    // 멤버변수
    private static final WaitingDto[] waitings = new WaitingDto[100]; // 배열 waiting

    // 등록 dao
    public boolean boardWrite( WaitingDto waitingDto ){
        for(int i = 0; i < waitings.length; i++){
            if(waitings[i] == null){
                waitings[i] = waitingDto;
                return true;
            }   // if end
        }   // for i end
        return false; // 찾지 못함
    }   // func end

    // 배열 출력 dao
    public WaitingDto[] boardPrint(){
        return waitings;
    }

}   // class end
