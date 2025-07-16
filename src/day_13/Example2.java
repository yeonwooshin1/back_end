package day_13;

// * 자바의 모든 클래스는 자동으로 extends Object 이므로 자바는 100% 객체지향이다.

class A{                                     // 부모 : Object , 자식 : B/C  , 자손 : D/E
    A(){
        System.out.println("A 객체 탄생");
    }   // 생성자
}   // class A end

class B extends A{  // B는 A로부터 상속받음     // 부모 : A , 자식 : D
    B(){
        System.out.println("B 객체 탄생");
    }   // 생성자
}   // class B end

class C extends A{  // C는 A로부터 상속받음     // 부모 : A , 자식 : E
    C(){
        System.out.println("C 객체 탄생");
    }   // 생성자
}   // class C end

class D extends B{  // D는 B로부터 상속받음     // 부모 : B
    D(){
        System.out.println("D 객체 탄생");
    }   // 생성자
}   // class D end

class E extends C { // E는 C로부터 상속받음     //
    E(){
        System.out.println("E 객체 탄생");
    }   // 생성자
}   // class E end

public class Example2 { // class start
    public static void main(String[] args) {    // main start

        // (1) A 클래스로 객체 생성시 총 객체수 : 2개
        A a = new A();  // Object --> A
        System.out.println("============= A ==============");

        // (2) B 클래스로 객체 생성시 총 객체수 : 3개
        B b = new B();  // Object ---> A --> B 이 순으로 컴파일 됨.
        System.out.println("============= B =============");

        // (3) C 클래스로 객체 생성시 총 객체수  : 3개
        C c = new C();  // Object ---> A --> C 이 순으로 컴파일 됨.
        System.out.println("============= C =============");

        // (4) D 클래스로 객체 생성시 총 객체수  : 4개
        D d = new D();  // Object ---> A --> B -> D 이 순으로 컴파일 됨.
        System.out.println("============= D =============");

        // (5) D 클래스로 객체 생성시 총 객체수  : 4개
        E e = new E();  // Object ---> A --> C -> E 이 순으로 컴파일 됨.
        System.out.println("============= E =============");

        // (6) 자동 타입변환
        A a1 = b;       // b객체(값)는 B타입 ,, 아래에서 위로 올라가는 건 가능 B가 생성될 때 A도 같이 생성되기 때문에 가능하다.
        Object o1 = b;  // b객체(값)는 Object 타입 변환         // 타입만 바꾸는거지 값을 바꾸는 것은 아님!
        // B b = c;     // 불가능 상속을 받은 적이 없음.

        // (7) 강제 타입변환
        B b2 = (B)a1;   // 가능! a1태생을 확인하시고 대신 (반환타입) 강제 타입변환을 해줘야함.

        A a2 = e;       // 자동
        C c1 = (C)a2;   // 강제

        // B b3 = (B)a2;    // 강제 불가능
        // 문법 오류가 아닌 실행오류임

        // (8) 인스턴스(객체/값) 타입 확인 방법
        // 객체 instanceof 타입/클래스명 : 객체가 지정한 클래스 타입인지 확인
        // 강제타입 변환 전에 확인 목적
        System.out.println( a instanceof Object );  // true
        System.out.println( b instanceof A );       // true // b 객체는 A의 타입이야?
        //System.out.println( e instanceof B );     // false
        System.out.println(a2 instanceof C);        // true         a2 == e
        System.out.println(a2 instanceof B);        // false;       a2 == e , B를 상속하지 않았음

        // (9)
        // 1. 웹/앱 라이브러리
        // 2. 클래스 설계 단계
        //      코드 치다가 명령어(코드)가 중복되면 메소드화
        //      클래스 정의하다가 다른 클래스와 멤버변수 중복되면 상속화

    }   // main end

}   // class end
