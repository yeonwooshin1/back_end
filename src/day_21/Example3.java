package day_21; // package
// (1) 유저1 클래스 [작업스레드1]
class User1 extends Thread{
    public Calculator calculator;
    @Override public void run() { // 작업스레드 메소드 구현
        calculator.setMemory( 100 ); // 계산기에 100 넣기
    }
} //class end
// (2) 유저 클래스 [작업스레드2]
class User2 extends Thread{
    public Calculator calculator;
    @Override  public void run() {
        calculator.setMemory( 200 ); // 계산기에 200 넣기
    }
} // class end
// (3) 계산기 클래스 [ 객체 ]
class Calculator{
    public int memory; // 멤버변수
    // 메소드
    public synchronized void setMemory( int memory ){
        // 두 개 이상의 스레드가 해당 메소드 사용시 먼저 요청한 스레드가 점령하고 종료될때까지 다른 스레드는 await(대기)만든다.
        // public void setMemory( int memory ){
        this.memory = memory; // 매개변수 대입
        try{ Thread.sleep( 2000 ); } // 2초간 일시정시
        catch ( Exception e ){}
        System.out.println( this.memory ); // 멤버변수 확인
        // user1 스레드가 2초간 일시정지 도중에 user2 스레드가 200으로 대입
        // 주의할점 : 두개 이상의 스레드가 하나의 메소드를 호출 할때 비동기 처리를 한다.
        // 동기화 : 두개 이상의 스레드가 하나의 메소드를 순서대로 호출하고 처리 할때 사용한다.
        // 동기화 목적 : 두개 이상의 스레드가 먼저 메소드를 호출하고 다른 스레드는 await 상태로 만든다.
        // 예] 유재석(thread1) 강호동(thread2) 신동엽(thread3) 가 달리기() 함수 실행한다.
        // -> 비동기화 : 동시에 달리기() , 동기화 : 순서대로 이어(기다렸다가) 달리기()
    }
} // class end

public class Example3 {
    public static void main(String[] args) {
        // [ 동기화 와 비동기화 ]
        /*
        [ synchronized ] 동기화
            1. 정의 : 메소드에 lock(락) 사용하여 메소드를 점령한다.
            2. 목적 : 여러 스레드가 동시에 하나의 스레드를 사용하면 멤버변수(코드) 충돌 생길 수 있다.
            3. 비교
                동기화                                비동기화(기본값)
                한번에 하나의 스레드가 처리             여러개의 스레드가 동시 처리
                처리 순서 보장 됨                      처리 순서 보장 안됨.
                synchronized                          x
                주문순서대로 음료 제조후 손님에게준다.   제조가 먼저 완성된 음료를 손님에게 준다.

            4. 사용법
                (방법1) 메소드 선언부 의 반환타입 앞에 'synchronized' 키워드 붙인다.
                (방법2) synchronized(this){ } 블럭 이용한다.
        */

        // 1. 계산기 객체를 *하나* 생성한다.
        Calculator calculator = new Calculator();
        // 2. 하나의 계산기를 두개의 스레드(객체)에 대입한다.
        User1 user1 = new User1();
        user1.calculator = calculator;

        User2 user2 = new User2();
        user2.calculator = calculator; // user1과 같은 객체
        // * 두 스레드는 동일한 (계산기)객체정보를 갖는다.

        // 3. 두 스레드 실행
        user1.start(); // user1은 100 넣기 : 200 -> synchronized -> 100
        user2.start(); // user2은 200 넣기 : 200 -> synchronized -> 200


    } // main end
} // clalss end
