package day_07;

    // - 클래스 목적
    // (1) 실행 클래스 : main 함수 갖는 클래스
    // (2) 객체 설계 클래스 : 객체 만들기 위한 객체 정의클래스

public class Calculator {   // Calculator class start

    // 클래스 멤버( 객체 내 포함 )

    // 1. 멤버 변수 : 객체마다 각각 할당
    Boolean isPowerOn = false;  // 전원상태

    // 2. 생성자

    // 3. 메소드    : 하나의 메소드는 여러 객체들이 공유

    // (1) 매개변수 X 반환값 O
    double getPi( ){
        // double   : return( 반환 )할 값의 타입이 실수
        // getPi    : 메소드명 , 카멜표기법 권장 , 아무거나
        // ()       : 매개변수 , 없다.

        return 3.14159;
        // return 값 : 메소드를 호출 했던 곳으로 반환하는 값;
    }   // func end

    // (2) 매개변수 X 반환값 X ( void )
    void PowerOn(){
        // void : return 값이 없다.
        // { } : 메소드 실행 될 때 처리할 코드들
            System.out.println("계산기 전원을 켭니다.");
            isPowerOn = true;
        // isPowerOn : *해당 메소드를 호출한 객체의 ****멤버변수****
            // cal1가 메소드를 호출했으니 cal1의 isPowerOn은 true이지만
            // 새로 할당된 cal2는 호출한 적이 없으니 false이다.
    }   // func end

    // (3) 매개변수 O , 반환값 X ( void )
    void printSum( int x , int y ){
        // (int x , int y) : 메소드 호출시 인수값을 정수 2개로 저장하는 변수
        if( isPowerOn ){    // 만약에 전원이 켜져있으면?
            int sum = x + y;
            System.out.println( sum );
            return;
        }else {
            System.out.println("전원이 켜져있지 않습니다.");
            return;
        }   // if end
    }   // func end

    // (4) 매개변수 O , 반환값 O
    int add( int x , int y ){
        if( isPowerOn ){
            int result = x + y;
            return result;
        }else{
            System.out.println("전원이 꺼져있다.");
            return 0;
        }

    }



}   // Calculator class end
