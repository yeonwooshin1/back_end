package day_09; // package

class D{
    // final int 최종변수; // 초기값을 무조건 정의해줘야한다.
    final int 최종변수 = 10;

    // static
    static int 비멤버공유변수; // 객체내 포함하지 않고 클래스가(new) 하지 않아도 사용가능

    // 상수 만들기
    static final int 상수 = 10;

    // [5]
    void 멤버메소드1(){} // static이 아닌 메소드
    static void 비멤버메소드2(){} // static 메소드

    void 멤버메소드2(){  // 그냥 일반 메소드

        멤버메소드1();    // 들어갈 수 있다.

        비멤버메소드2();  // 들어갈 수 있다.
    }
}




public class example2 { // class start

    // static 아닌 메소드

    void 멤버메소드 (){}

    // static인 메소드

    static void 비멤버메소드(){}


    public static void main(String[] args) {    // main start

        // [1] 멤버변수 호출 가능 , 수정 불가능

        D d = new D();
        System.out.println(d.최종변수); // 호출 가능
        // d.최종변수 = 20;             // 수정 불가능

        // [2] static 정적변수에 호출 , 클래스명.정적변수명;

        System.out.println(D.비멤버공유변수);    // 객체 없이 static 가능
        D.비멤버공유변수 = 20;
        System.out.println(d.비멤버공유변수);    // 객체도 static 가능.     // 20 모든걸 공유함

        // [3] static fianl 상수 호출   , 클래스명.상수명;

        System.out.println( D.상수 ); // 상수

        // [4] static 메소드 내 static 유무 메소드 호출
        // 멤버메소드();     // 불가능 , static이 아니니까 메모리할당이 안됨

        example2 ex2 = new example2(); // 객체 할당
        ex2.멤버메소드();    // 가능   객체 선언 new로 해줬으니 가능

        비멤버메소드();       // 가능 static이니까 객체 할당없이 가능함

        // [5] static 메소드가 아닌 static 유무 메소드 호출
        // D 클래스로 가시오.

        /*

        [ final ] *최후 ,마지막의

            1. 고정 상태를 정의할 때 사용되는 키워드
            2. 사용법
                final 타입 멤버변수
            3. 주의할 점 : 초기값이 무조건 존재해야한다.

        [ static ] *정적인

            1. 프로그램이 컴파일될 때 *메모리가 할당*되고 프로그램이 종료될 때 메모리가 삭제되는 키워드
            2. 사용법 : static 타입 멤버변수 -------> static(정적)변수
            3. 주의할 점 : 멤버변수( 객체 내 변수 ) 공유X 각자 new로 할당 VS static( 객체 외 변수 ) 공유 O
                1) 프로그램내 딱 1개만 존재하는 변수들을 선언할 때 사용 , 서로 다른 객체들이 공유해서 사용한다.

        [ 상수 ] : 변하지 않는 변수

            1. 사용법 : static final 타입 상수명;
            2. 주의할 점 : 1) 수정불가능 2) 프로그램내 딱 1개 존재  3) 상수명 대문자 사용

        [ static 유무 중요한 이유 ]

            !!!!! : static 으로 선언된 메소드는 같은 클래스내 메소드를 호출할 수 없다.
            // 방법1 : 객체를 생성하여 객체를 통해 static 아닌 메소드 호출한다.

            class Test {
                static void main3(){}
                void main2(){}

                static void main(){
                    main2();            // 불가능 : main 함수는 우선할당이 되면서 main2가 누구세요?
                    Test 객체 = new Test();
                    객체.main2(); // 가능 : static이 없는 경우 객체를 통해서 가능.
                    main3();            // 가능   : main 함수는 우선할당이 되면서 main3를 알고 있다.
                }
            }


        */
    }   // main end


}   // class end
