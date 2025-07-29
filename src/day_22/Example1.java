package day_22; // package

import java.util.Arrays;

public class Example1 { // class start
    public static void main(String[] args) {    // main start
        /*
        [ String 클래스 ] : 자바에서 문자열을 표현하는 방법
            - 컴퓨터는 문자 는 알고 문자열은 모른다.
            - 문자 번역 : 바이트 <-- 번역 방법 --> 문자
                1. 아스키코드    : (영문 / 슷자 / 특수문자)128문자 표현하는 규칙 , 7비트
                2. 유니코드     :  전세계 공용어(한글포함) , 자바가 사용하는 코드
            - 65 <---> 'A' , { 74 , 65, 86 ,65 } <---> [J, A, V, A] 등등

            1. 문자열을 사용하는 방법
                1) "문자열"                : ""큰따옴표 안에 문자열 표현
                2) new String( "문자열" )    : new String()생성자 이용한 문자열 표현

            2. 문자열 비교하는 방법
                1) 문자열 A == 문자열 B         : "리터럴" 문자만 비교 가능한다.
                2) 문자열 A.equals( 문자열 B )    : "리터럴"과 객체문자열을 비교 가능하다.

            3. 주요 메소드
                1) 문자열 A.concat( 문자열 B )                : 연결 메소드
                2) String.format( "형식문자" , 문자열 A )    : 지정된 형식으로 문자열 반환 멧호드
                3) StringBuilder builder = new StringBuilder()   : 문자열 연결 클래스
                    builder.append( 문자열 A );
                    builder.append( 문자열 B );
         */

        // 1. 배열을 이용한 문자열 표현
        char str = '유';                       // ' ' 작은 따옴표로 감싼 문자 1개는 char 타입
        char[] str2 = {'유' , '재' , '석'};    // '' 작은 따옴표 3개를 char 배열 타입

        // 2. char 타입의 아스키코드 10진수
        char str3 = 65;     System.out.println(str3);   // A
        char[] star4 = {74 , 65 , 86 , 65};   System.out.println(Arrays.toString(star4)); // [J, A, V, A]
        char str5 = '김';    System.out.println((int) str5); // 44608 ??

        // 3. 문자열 리터럴 : "" 큰따옴표 , String 클래스
        String str6 = "유재석";    // new String 사용하지 않고 문자열 생성할 경우
        String str7 = "유재석";    // 문자열이 동일경우 동일한 객체 취급
        String str8 = new String("유재석");    // -new String 사용시 동일한 문자열 이라도 다른 객체 취급

        // 4. ==  VS .equals( ) ,
        // 1) == 주소값(객체가 저장된 위치) 비교 ,
        // 2) .equals( ) : 문자열 비교 메소드
        System.out.println( str6 == str7 ); // true
        System.out.println( str7 == str8 ); // false
        System.out.println( str6.equals( str7 ) );  // true
        System.out.println( str6.equals(str8)) ;    // true

        // * 문자는 불변(변하지 않는다 / 수정이 없다)

        // 5. 주요 메소드
        // 1) .concat( )    : 문자열 연결 메소드
        String str9 = "자바".concat("프로그래밍");
        System.out.println(str9);                   // 자바프로그래밍
        System.out.println("자바" + "프로그래밍");    // 자바프로그래밍

        // 2) StringBuilder 클래스     : 문지열을 단계적으로 연결 하는 메소드 제공하는 클래스
        StringBuilder builder = new StringBuilder();
        builder.append("자바");
        builder.append("프로그래밍");
        System.out.println( builder );              // 자바프로그래밍 // 하나의 객체를 쓰기 때문에 메모리 효율 좋다

        // 3) String.format( "형식문자" , "문자열A" );
        String str10 = String.format("%s%s" , "자바" , "프로그래밍");  // 자바프로그래밍
        System.out.println(str10);

        // 4) + 연결연산자
        String str11 = "";
        str11 += "자바";
        str11 += "프로그래밍";
        System.out.println( str11 );

        // 활용] JDBC 에서 SQL의 매개변수 연결
        String name = "유재석";

            String sql1 = "insert into table(name) values("+name+")"; // 비권장

            String sql2 = String.format("insert into table(name) values(%s)" , name );

            String sql3 = "";  sql3 += "insert into ";  sql3 += "table(name) "; sql3+= "values("+name+")"; // 비권장

            StringBuilder builder2 = new StringBuilder();
            builder2.append("insert into");
            builder2.append("table(name)");
            builder2.append("value("+name+")");

        // 5) .charAt( 인덱스 )    : 지정한 인덱스 번호의 문자 1개 반환 메소드
        char gender = "012345-1230123".charAt(7);
        System.out.println( gender ); // 1
        // 활용] nextChar()[x] --> 문자 1개 입력 : scan.next().charAt(0)

        // 6) .length()     : 문자열내 문자수 반환 메소드
        System.out.println("012345-1230123".length() ); // 인덱스 : 0~13 , 길이 : 14
        // 활용] for( int i = 0; i < 문자열.length ; i++ ) { }

        // 7) .replace( 기존 문자열 , 새로운문자열 ) , replaceAll( 기존문자열 , 새로운 문자열 )
        // : 지정한 문자열내 기존문자열을 새로운 문자열 생성 후 반환 메소드
        String str12 = "자바 프로그래밍".replace( "자바" , "JAVA");
        System.out.println( str12 );    // JAVA 프로그래밍
        // 활용 ] HTML 줄바꿈 <br> ----> JAVA 줄바꿈 \n
        String htmlData = "유재석<br/>안녕하세요";
        String newData = htmlData.replaceAll("<br/>" , "\n");
        System.out.println( newData );

        // 8) .subString( 시작인덱스 , 끝인덱스 );   : 시작인덱스부터 끝인덱스까지 문자열 추출
        String str13 = "012345-1230123".substring( 0 , 6 ); // 0번 인덱스부터 6번인덱스 전까지
        System.out.println( str13 );    // 012345
        String str14 = "012345-1230123".substring(7);   // 끝 인덱스를 생략하면 7번 인덱스부터 (마지막 인덱스)까지 추출
        System.out.println( str14 );    // 1230123
        // 활용] 차량번호 조회 : 214가7531 , 차량번호 뒷자리 : 차량번호.subString ( 차량번호.length()-1-3 );

        // 9) .split( "구분문자" );     : 지정한 문자열 내 구분문자 기준으로 잘라서 배열로 반환 메소드
        String[] str15 = "012345-1230123".split("-");   // '-' 기준으로 문자열 쪼개기
        System.out.println( str15[0] ); // 012345
        System.out.println( str15[1] ); // 0123123
        // 활용1] CSV 형식 다루기 , CSV란 ,(쉼표)로 속성을 구분하고 \n 줄바꿈 구분 한다.
        // 활용2] 날짜( 연 / 월 / 일 )
        // 활용3] 주소( 시 , 군 , 구 , 동 )

        // 10) .indexOf("찾을문자열")    : 지정한 문자열내 찾을문자열이 존재하면 찾은 인덱스, 없으면 -1 반환 반환 메소드
        int findIndex = "자바 프로그램이 언어".indexOf("프로");
        System.out.println( findIndex );    // 3

        // 11) .contains("찾을문자열");  : 지정한 문자열내 찾을문자열이 존재하면 true 없으면 false 반환 메소드
        boolean findBool = "자바 프로그래밍 언어".contains("프로");
        System.out.println( findBool );     // true

        // 12) .getBytes() : 지정한 문자열을 byte[] 타입으로 반환하는 메소드
        byte[] str16 = "JAVA PROGRAM".getBytes();
        System.out.println(Arrays.toString(str16)); // [74, 65, 86, 65, 32, 80, 82, 79, 71, 82, 65, 77] -> 아스키 코드
        String str17 = new String( str16 );
        System.out.println( str17 );
        // 활용] 문자열을 바이트 변환 , 파일처리 , 네트워크 , 첨부파일 업로드 등

    }   // main end
}   // class end
