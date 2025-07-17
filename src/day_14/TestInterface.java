package day_14;

public interface TestInterface {
    // [6] 상수 , public static final , 생략가능 // 인터페이스는 상수만 가능해서
    // 주의할 점 : 상수는 무조건 초기값이 있어야함
    public static final int value2 = 10 ;
    int value3 = 20 ; // 상수 키워드 생략 가능

    // [7] 추상메소드 : 선언부만 선언하고 실행문{}이 없는 메소드
    // public abstract 반환타입 메소드();
    // 실행문은 각 클래스가 구현(오버라이딩) 한다.
    public abstract void method2();
    boolean method3( int a ); // 상수 키워드 생략 가능


    // [3] 멤버변수 , **불가능**
    // int value1;

    // [4] 생성자 , **불가능**
    // TestInterface(){}

    // [5] 메소드 , **불가능**
    // void method1(){}




}
