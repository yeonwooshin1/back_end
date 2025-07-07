package day_06; // pakage

import java.util.Arrays;

public class example1 { // class start
    public static void main(String[] args) { // main start

        /*

            [ 배열 ]
                1. 정의 : *동일한* 자료형(타입)의 여러 개 데이터를 순서대로 저장하는 타입
                2. 특징
                    1) 동일한 타입    : 서로 다른 타입 데이터를 같은 배열에 저장할 수 없다.
                    2) 고정 길이      : 배열은 한 번 생성 되면 길이를 수정할 수 없다.
                    3) 요소의 초기값   :  요소의 초기값이 없으면 자동으로 기본값 대입
                        정수는 0 , 실수는 0.0 , 논리는 false , 객체(배열)는 null

                3. 사용법
                    1) 선언/생성
                        (1) new 타입[길이];         ,   int [ ] 변수명 = new int[ 3 ];
                        (2) { 값1 , 값2 , 값3 };    ,   double[] 변수명  = { 3.14 , 5.1 , 78.67 };

                    2) 호출
                        (1) 변수명                     ,   배열(객체)의 주소값
                        (2) Arrays.toString( 변수명 )  ,   배열 내 요소 값 반환
                        (3) 변수명[인덱스]
                            * 인덱스란 ? 배열내 저장된 요소들의 순서번호, 0번부터 시작
                            * 변수명.length : 배열내 요소갯수 , 배열의 길이

                    3) 수정
                        (1) 변수명 = new 타입[3];       , 전체 배열 수정
                        (2) 변수명[ 인덱스 ] = 새로운값;  , 해당 인덱스의 값 수정

                    4) 삭제/추가 * 특정한 요소 삭제/추가는 존재하지 않는다, 자바 배열은 *고정 길이* 이므로 중간에 요소 총갯수 변경할 수 없다.

                    5) 배열과 반복문
                        (1) 일반 for문
                            for ( int index = 0; index <= 배열변수명.length - 1; index++ ){
                                타입 변수명 = 배열변수명[index];
                            }
                        (2) 향상된 for문    , 인덱스 없이 배열의 요소값 하나씩 변수에 대입 반복
                            for ( 타입 변수명 : 배열변수명 ){

                            }


         */
        // [1] 배열 선언1   : 선언만
        int[ ] array1 = new int[3];

        // [2] 배열 선언2   : 선언과 초기화
        String[ ] array2 = { "봄", "여름" , "가을" , "겨울" };

        // [3] 배열의 주소값 반환
        System.out.println( array1 );   // [I@f6f4d33 : 객체의 주소(컴퓨터가 사용하는 메모리 위치 정보)값
        System.out.println( array2 );   // [Ljava.lang.String;@23fc625e : 객체의 주소값

        // [4] 배열내 요소들을 문자열로 반환
        System.out.println(Arrays.toString(array1));    // [ 0, 0, 0 ] : 배열의 요소값들을 문자열로 반환
        System.out.println(Arrays.toString(array2));    // [ 봄, 여름, 가을, 겨울 ]

        // [5] 특정한 요소 값 반환
        System.out.println( array1[0] );                // 0
        System.out.println( array2[0] );                // 봄

        // [6] 배열내 총 요소 갯수 반환
        System.out.println( array2.length );            // 4 , 배열내 길이 반환

        // [7] 특정한 요소 값 수정
        array1[0] = 10;
        System.out.println( array1[0] );    // 10

        array2[0] = "Spring" ;
        System.out.println( array2[0] );    // "Spring"

        // [8] 배열은 삭제/수정 불가능
        // array1[3] = 40; // 오류 발생 : Index 3 out of bounds for length 3

        // [9] 일반 for문과 향상된 for 문의 배열 활용법
        for (int i = 0; i < array1.length ; i++) {  // i는 0부터 마지막 i까지 1씩 증가 반복

            int value = array1[i];  // i번째 요소 값 호출
            System.out.println( value );

        }   // for end

        for( String value : array2 ){   // 항상된 for문 , for( 요소타입 반복변수명 : 배열변수명 ) { }

            System.out.println( value );

        }   // for end



    } // main end
}   // class end
