package day_07; // pakage

public class example {  // class start
    public static void main(String[] args) {    // main start

        /*
            [ 메소드 ] , 멤버함수 또는 메소드
                1. 정의 : 하나의 기능을 수행하는 일련의 코드

                2. 메소드 선언/만들기
                    반환타입 메소드명( 타입 매개변수1 , 타입 매개변수2 ) {
                        실행코드;
                        return 반환값 | 생략가능
                    }

                3. 용어
                    1). 메소드명 : (1) 카멜표기법 권장 , myCarRun 같은 거
                    2). 매개변수 : 메소드 실행시 메소드 안으로 들어오는 값을 저장하는 변수
                        (1) 매개변수가 없을 수도 있다.
                        (2) *** 인수 값의 타입과 매개변수의 타입이 일치 해야한다. ***
                    3). 반환타입 : 메소드 실행 후 결과를 되돌려주는( return ) 값의 타입
                    4). 반환값   : 메소드 실행 후 결과를 되돌려( return ) 주는 값
                        (1) 반환값의 타입과 반환 타입 일치 해야한다.
                        (2) 반환값은 항상 자료 1개 만 가능 하다.
                        (3) 반환값이 없을 때는 void 반환타입 키워드 사용한다.
                    5). 인수값 : 메소드 호출시 메소드에게 전달하는 값 , 인수값 --대입 ( 중매 )--> 매개변수

                4. 메소드 호출하는 방법 :
                    [ 방법 1 ] 호출하고자 하는 메소드가 다른 클래스일 때
                        1) 클래스 변수명 = new 클래스명();
                        2) 변수명.메소드명();

         */

        // [1] 클래스 에서 메소드 선언

        // [2] 다른 클래스내 메소드 호출하기.
            // 1) 호출하고자 하는 메소드를 갖는 클래스로 객체생성
            Calculator cal1 = new Calculator();   // 객체 생성
            // 2) 호출하고자 하는 메소드를 갖는 객체 이용한 메소드 호출
            cal1.getPi();   // 객체.메소드명();

        // [3] 매개변수 X , 반환값 O : 반환값이 있을 때 *주로 **변수에 대입한다.
        Double result = cal1.getPi();
        System.out.println( result );

        // [4] 매개변수 X , 반환값 X
        cal1.PowerOn();
            // - 여러 객체들간의 멤버변수 주의할 점 -
        Calculator cal2 = new Calculator();
            // - new 연산자는 항상 새로운 객체를 만든다.
            // 즉] 객체 마다 멤버변수는 다르다.
        System.out.println( cal1.isPowerOn );   // true
        System.out.println( cal2.isPowerOn );   // false

        // [5] 매개변수 0 , 반환값 X
        cal1.printSum( 3 , 5 ); // 2개의 정수 인수값 x: 3 , y: 5

            // 오류발생 , 인수값 타입이 불일치
            // cal1.printSum( 2.14 , 5.1 );

            // isPowerOn이 false라 안됨~
            cal2.printSum(3 ,5);

        // [6] 매개변수 O , 반환값 O
        int result2 = cal1.add( 10 , 3 );
        // int : .add 함수의 반환값 타입이 int 라서.

        int a = 1;
        // int result3 = cal1.add( "안녕" , a );
        // 오류 발생 : 인수 값과 매개변수의 타입 일치 해야한다.


    }   // main end
}   // class end
