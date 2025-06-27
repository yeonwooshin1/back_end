package day_01; // 현재 .java 파일 위치한 폴더명

import java.sql.SQLOutput;

public class Example2 { // class start : 모든 자바코드는 클래스 안에 존재한다.

    // (1) main 함수 선언 : main + 엔터 ( 자동완성 )
    public static void main(String[] args) { // main start
        // (2) 리터럴 : (JAVA) 언어 들이 미리 정의한 데이터
            // 3 , '김' , "김현수" , 3.14 , true    * JS에서는 '작은따옴표 와 " 큰따옴표 구분이 없다.
            // 리터럴의 모든 정수는 int , 모든 실수는 double

        // (3) 출력함수 : System.out.print( 리터럴 / 변수 / 연산 / 함수 등 );
            // JS : console.log( ) * JS에서는 ;(세미콜론) 선택 이지만 , 자바는 무조건 명령어 끝에 ; 넣는다.
            // sout + 엔터(자동완성)

        // (4) main함수 실행 : ctrl + shift + f10 또는 실행버튼
        System.out.println( 3 );            // 리터럴 3 출력      , 명령어 끝에 ;(세미클론) 필수!!!!!
        System.out.println( 3.14 );         // 리터럴 3.14 출력
        System.out.println( '신');          // 리터럴 '신' 출력
        System.out.println( "신연우" );       // 리터럴 "신연우" 출력
        System.out.println( true );        // 리터럴 true 출력

        // (5) 자료형/타입   , 8가지           * 기본 자료형
            // 정수 : byte , short , int(*) , long
            // 실수 : float , double(*)
            // 문자 : char           문자열 : String
            // 논리 : boolean

        // (6) 리터럴 값을 변수 ( *하나의 자료를 저장* )에 대입하기.
        // ======== 자료형 변수명 = 리터럴; ========
            // 1. boolean 타입 : true 와 false 만 저장
        boolean bool1 = true;       // 리터럴 true를 저장 가능한 타입
        boolean bool2 = false;
        // boolean bool3 = 3;       // 3이라는 리터럴은 boolean에 저장 불가능.
        System.out.println(bool1);
        System.out.println(bool2);

            // 2. char 타입 : ' 작은 따옴표로 감싼 문자 1개 저장
        char ch1 = 'A';
        // char ch2 = 'ABC';        // 불가능. 문자열(문자 여러개)
        // char ch3 = "ABC";        // ""로 감싼 것도 불가능
        System.out.println(ch1);

            // 3. String 클래스타입 : "큰따옴표 으로 감싼 문자 여러개 저장
        String str1 = "ABC";
        // String str2 = 'ABC';     // '' 작은 따옴표로 감싼 자료 불가능
        System.out.println(str1);
            // 4. byte 타입   : 정수 -128 ~ +128          1바이트
            // 5. short 타입  : 정수 +- 3만정도            2바이트
            // 6. int 타입    : 정수 +-21억정도            4바이트 , 정수 리터럴*
            // 7. long 타입   : 정수 +-21억정도 이상        8바이트 , 리터럴 뒤에 l/L 붙여야함

        byte b1 = 100;
        // byte b2 = 200;            // 범위 넘어가서 불가능
        System.out.println(b1);

        short s1 = 32000;
        // short s2 = 50000;         // 범위 넘어가서 불가능
        System.out.println(s1);

        int i1 = 2100000000;
        // int i2 = 21000000000;     // 범위 넘어가서 불가능
        System.out.println(i1);

        //long l1 = 1231452342234234;  // 키보드로 입력한 모든 값은 리터럴인데 정수가 Int 여서 뒤에 L 붙여줘야함
        long l2 = 213213123123123123L;
        System.out.println(l2);

            // 8. double 타입 : 실수 소수점 17자리 까지 표현 , 실수 리터럴*

        double d1 = 0.12345678910;      // 0.1234567891 까지만 표현 되고 나머지는 짤림
        System.out.println(d1);

            // 9. float 타입  : 실수 소수점 8자리 까지 표현 , 리터럴 뒤에 f/F 붙여야함

        float f1 = 0.123456789123456789F;    // 리터럴 뒤에 F 붙인다.
        System.out.println(f1);     // 0.12345679 나머지는 짤림

        //**************** 주의할 점 : double(기본타입)과 Double(참조타입) 서로 다름 *********************************//


    } // main end

} // class end
