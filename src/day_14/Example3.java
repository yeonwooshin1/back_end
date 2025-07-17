package day_14; // package

public class Example3 { // class start
    public static void main(String[] args) {    // main start
        /*
            [ 다형성 ] : 다양한 타입을 갖는 성질

            [ 인터페이스 ] :
                1. 정의 : 서로 다른 시스템이나 장치 사이에서 정보를 주고 받는 접점/경계면

                2. 생활속 예]
                    키보드     : 키우기( A:공격 ), 축구( A:슈팅 ) 등 서로 다른 게임/프로그램들을 하나의 키보드로 조작
                    TV 리모콘  : 삼성 TV , LG TV 등 서로 다른 회사/모델의 TV 들을 하나의 리모콘 조작
                    키오스크    : 국밥 키오스크 , 아이스크림 키오스크 등 서로 다른 업체들을 하나의 키오스크로 조작

                3. 목적 : 서로 다른 장치 사이의 동일한 목적으로 기능(함수/메소드) 를 서로 다르게 작동

                4. 특징
                    1) 객체의 교환(호환)성으르 높이고 다형성 구현
                    2) 서로 다른 클래스들 사이 중간 매개 역할

                5. 사용법
                    1) 선언할 패캐지 오른쪽 클릭 -> [ 새로 만들기 ] -> [ JAVA 클래스 ]
                    2) 하위에 ( 인터페이스 ) 선택 -> 인터페이스명 정하기 ( 첫글자를 대문자 )
                    - interface 인터페이스명{ }

                6. 인터페이스 타입의 멤버
                    1) 상수
                        public static final
                    2) 추상메소드
                        abstract

                7.      상속        vs           인터페이스
                       extends                  implements
                       객체생성o                 객체생성x(생성자 없다)
                       * 1번 밖에 안됨           * 여러개의 인터페이스 구현
                       * 오버라이딩(선택)         * 오버라이딩(구현) 필수

         */
        // [1] 인터페이스 만들기 , 타입==클래스==인터페이스

        // [2] 인터페이스 로 객체 만들기 , ** 불가능 **
        // TestInterface ti = new TestInterface();

        // [6] 상수 불러오기 , 타입명.상수명
        System.out.println( TestInterface.value2 );

        // [7] 추상메소드 불러오기 ,
        // 추상메소드는 구현{}이 없으면 사용 불가능
        // TestInterface.method2();

        // [8] 클래스가 인터페이스의 추상메소드 구현
        // 구현한 클래스로 객체 [ 구현(객)체 ]
        new Tool();
        Tool tool1 = new Tool();
        tool1.method2(); // 가능
        TestInterface tool2 = new Tool();
        tool2.method2(); // 가능



    }   // main end
}   // class end

// 클래스 선언부 : class 클래스명 implements 인터페이스명{}
// 지정한 인터페이스의 추상메소드를 구현하기 전까지 오류 발생!!
class Tool implements TestInterface {
    // -- (1) 추상메소드 구현하기 :
    // 추상 메소드와 선언부를 동일하게 하고 실행문{} 자유롭게
    public void method2(){
        System.out.println("추상메소드1 구현 완료");
    }
    // -- (2) 추상메소드 구현하기 :
    public boolean method3( int a ){
        System.out.println("추상메소드2 구현 완료");
        return a > 10;
    }
}
