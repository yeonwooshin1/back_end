package day_01; // 패키지명

public class Example3 { // class start
    public static void main(String[] args) { // main start
        /*
            [ 출력 함수 ] :
                System : 시스템 관련 기능 제공하는 클래스
                out :  출력 관련 객체 반환
                (1) System.out.print();                     : 출력 함수
                (2) System.out.println();                   : 출력 후 줄바꿈 함수
                (3) System.out.printf( "형식: , "값" );      : f(format) 형식 맞게 출력 함수
                    [ 형식 ]
                    %s : 문자열 위치        %c : 문자 위치
                    %d : 정수 위치          %f : 실수 위치

                    [ 자릿수 맞춤 ]
                    %자릿수d   : 자릿수만큼 자릿수 차지 , 만일 비어있으면 공백 , 오른쪽 정렬
                    %-자릿수d  : 자릿수만큼 자릿수 차지 , 만일 비어있으면 공백 , 왼쪽 정렬
                    %0자릿수d  : 자릿수만큼 자릿수 차지 , 만일 비어있으면 0채움

                    [ 소수점 자릿수 맞춤 ]
                    %전체자릿수.소수점자릿수f  : (소수점포함)전체 자릿수 만큼 자릿수 차지 , 각자 따로임


            [ 자동 완성 ] :
                System.out.print()   : 자동완성 없음.
                System.out.println() : sout + 엔터
                System.out.printf()  : souf + 엔터

            [ 이스케이프 / 제어 문자 ] : 특수문자의 기능이 포함.
            \n : 줄바꿈
            \t : 들여쓰기
            \\ : '\' 백슬래시 하나 출력
            \' : '작은 따옴표 출력
            \" : "큰 따옴표 출력
        */

        // [1]

        System.out.println("Hello World 1");    // 자료 출력 후 줄바꿈처리.
        System.out.println("Hello World 2");

        System.out.print("Hello World 3");      // 자료 출력
        System.out.println("Hello World 4");

        System.out.printf("%s" , "Hello World 5");

        // [2]

        String name = "유재석"; // String(문자열타입) name(변수명) =(대입) "유재석"(자료) ;(마침)
        int age = 40;          // int(정수타입)     age(변수명)  =(대입) 40(자료) ;(마침)
        System.out.printf(" 저는 %s 이고 나이는 %d 입니다." , name , age);
        // printf        ( "~~~~~~~ 형식 자리 ~~~~~~~~~~* , 값1 ,  값2  ) ==> %s 에는 name값 대입 , %d 에는 age 값 대입
        // vs
        System.out.println("저는 " + name + " 이고 나이는 " + age +" 입니다." );      // +연결 연산자 사용

        System.out.printf("저는 %s 이고 나이는 %6d 입니다. \n" , name , age );        // %6d , 6자릿수 안에 정수 표현 , 오른쪽 정렬
        System.out.printf("저는 %s 이고 나이는 %-6d 입니다. \n", name , age );        // %-6d , 6자릿수 안에 정수 표현 , 왼쪽 정렬
        System.out.printf("저는 %s 이고 나이는 %06d 입니다. \n" , name ,age );        // %06d , 6자릿수 안에 정수표현 , 빈칸은 0채움
        System.out.printf("저는 %s 이고 신장은 %5.4f 입니다. \n", name , 1885.2575 ); // %5.4f , 5개 자릿수 안에 4개의 소숫점 표현

        // [3] 이스케이프 문자

        System.out.println( "안녕1\n안녕2" );           // \ n은 줄바꿈 처리를 한다.
        System.out.println( "안녕3\t안녕4" );           // \t 는 들여쓰기가 된다 (tab)같은 표과
        System.out.println( "안녕5\'안녕6" );           // \' 는 '작은따옴표를 출력한다.
        System.out.println( "안녕7\"안녕8" );           // \" 는 "큰 따옴표를 출력한다.
        System.out.println( "안녕9\\안녕10" );          // \\ 는 '\'가 출력된다.







    } // main end
} // class end
