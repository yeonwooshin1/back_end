package 종합.과제4;     // package

import java.util.Scanner;

public class WaitingService {    // class start
    public static void main(String[] args) {    // main start

        Scanner scan = new Scanner(System.in);  // scan
        for(;;) {   // for 무한루프 실행
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("  1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();    // choose를 1 , 2 중에 받아서 등록을 할지 등록된 걸 보여줄 지 결정한다.
            if (choose == 1) {  // choose == 1이라면? 등록파트임
                System.out.print("전화번호 : ");         String phoneInput = scan.next();  // 전화번호를 scan 으로 받는다. 그것을 phoneInput 에다가 대입
                System.out.print("인원수 : ");       int countInput = scan.nextInt();      // 인원수를 scan 으로 받는다. 그것을 countInput 에다가 대입
                boolean alert = WaitingController.addWaiting( phoneInput , countInput ); // 클래스에서 직접 static 매소드를 호출 매개변수는 scan 값 넣어줌 => 반환값은 alert 변수에 대입
                if(alert){System.out.println("[안내] 대기 등록이 완료되었습니다.");}           // 반환값 alert가 true 라면 대기등록 완료
                else{ System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");}        // 반환값 alert가 false 라면 대기등록 실패
            }   // if choose == 1 end

            if (choose == 2) {  // choose == 2 이라면? 배열 출력파트
                Waiting[] waiting =  WaitingController.getWaitingList();    // controller의 배열 Waiting[] 속성 getWaitingList 메소드 호출, 매개변수 없음, 반환값(배열)은 waiting 변수에 대입
                for( Waiting i : waiting){  // Waiting은 객체타입, 변수명은 i 할당 : waiting은 순회할 배열 타입
                    if(i != null){  // i번째 배열이 비어있지 않는다면 ? == 배열에 객체가 들어있다면?
                        System.out.println("============= 대기 현황 =============");
                        System.out.println("1. 연락처 : " + i.getPhone() + " - 인원 : " + i.getCount() + "명"); // i번째 Waiting[] waiting 배열 안에 객체 중 phone과 count 멤버변수 나와라 getter로 나오게 함
                        System.out.println("------------------------------------");
                    }   // if end
                }   // 향상된 for문
            }   // if choose == 2 end
        }   // for 무한루프 end;







    }   // main end
}   // class end

class Waiting { // class Waiting start
    // 멤버변수
    private String phone;   // 전화번호
    private int count;      // 인원수

    // 생성자
    public Waiting( String phone ,int count ){  // 매개변수 2개
        this.phone = phone;
        this.count = count;
    }

    // setter and getter 메소드

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}   // class Waiting end

class WaitingController{    // class WaitingController start
    // 멤버변수

    private static final Waiting[] waitings = new Waiting[100]; // 접근제어자 private , static , 상수

    // 메소드

    public static boolean addWaiting(String phone, int count){
        Waiting waiting = new Waiting( phone , count );

        for(int i = 0; i < waitings.length; i++ ){
            if(waitings[i] == null ){
                waitings[i] = waiting;
                return true;
            }   // if end
        }   // for i end
        return false;
    }   // func end

    public static Waiting[] getWaitingList(){
        return waitings;
    }   // func end

}   // class WaitingController end