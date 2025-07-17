package day_14;

class 상위클래스{
    int value1 = 10;    int value2 = 20; // 멤버변수
    상위클래스(){ System.out.println("[상위클래스 인스턴스생성]");} // 생성자
    void showValue(){  //메소드
        System.out.println(">>상위클래스의 메소드 실행<<");
    } // func end
} // class end

class 하위클래스 extends 상위클래스 { // 클래스B extends 클래스A{ }
    int value3 = 30;    int value2 = 40;
    하위클래스(){ System.out.println("[하위클래스 인스턴스생성]"); }
    void showValue2(){ // 메소드
        System.out.println(">>하위클래스의 메소드2 실행<< ");
    }
    void showValue(){ // 메소드2
        System.out.println(">>하위클래스의 메소드 실행<<");
    }
}

public class Example1 {
    public static void main(String[] args) {

        // (1) 상위클래스 객체 생성
        상위클래스 obj1 = new 상위클래스();
        obj1.showValue();
        // obj1.showValue2(); // 하위클래스 의 멤버 접근불가

        // (2) 하위클래스 객체 생성
        하위클래스 obj2 = new 하위클래스();
        obj2.showValue(); // 현재타입
        obj2.showValue2(); // 상위타입 접근 가능

        // (3) 멤버변수명이 동일할때 구분 : 멤버변수는 객체마다 할당
        // 상위클래스의 멤버변수
        System.out.println( obj2.value1 ); // 10
        // 현재클래스의 멤버변수
        System.out.println( obj2.value3 ); // 30
        // 상위타입/하위타입내 동일한 멤버변수명 존재할때 *현재 타입 우선*
        System.out.println( obj2.value2 ); // 40
        // 하위타입에서 상위타입으로 변환후 동일한 멤버변수 호출시
        상위클래스 obj3 = obj2;
        System.out.println( obj3.value2 ); // 20

        // (4) 메소드명이 동일할때 구분 : 오버라이딩
        // 메소드는 객체마다 할당이 아니고 메소드는 모든 객체들이 공유
        // 오버로딩 vs 오버라이딩( 상위클래스로부터 메소드를 재정의 )
        // 주의할점 : 메소드가 동일할때 오버라이딩 메소드 *최우선*
        obj2.showValue(); // obj2(하위타입) 일때 현재타입 메소드 실행

        상위클래스 obj4 = obj2;
        obj4.showValue();   // obj4(상위타입) 일때 '태생'타입 메소드 우선

        상위클래스 obj5 = new 상위클래스();
        obj5.showValue();


    } // main end
} // class end
