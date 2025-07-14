package day_11; // package

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Example1 { // class start
    public static void main(String[] args) { //  main start

        /*
            [ 배열 ] 고정길이 , 메소드/기능  없다.
            vs
            [ ArrayList ] 가변길이 , 다양한 메소드/기능 제공


            [ ArrayList ]

                - 자바 회사에서 미리 제공하는 클래스
                1. 정의 : 컬렉션 프레임워크 중 리스트 자료형 클래스
                2. 목적 : 가변 길이의 배열 지원
                3. 사용법
                    1) 선언방법
                    ArrayList< 항목타입 > 변수명 = new ArrayList<>();
                    * < 제네릭타입 > : 리스트에 저장할 항목/요소 들의 타입

                    2) 요소 추가
                        (1) 변수명.add( 요소값 );               : 마지막 인덱스 뒤로 요소 추가
                        (2) 변수명.add( 인덱스 , 요소값 );       : 지정한 인덱스에 요소 삽입 

                        * 인덱스란? 배열 또는 리스트 내에 저장된 (요소)값들의 저장 순서 번호 , 0번 시작
                        
                    3) 요소 전체 출력하기
                        (1) 변수명                      : 전체 요소값 문자열 출력
                        (2) 변수명.size();              : 리스트내 전체 요소 갯수 반환
                        (3) 변수명.get( 인덱스 );        : 지정한 인덱스 요소값 반환

                    4) 요소 수정
                        (1) 변수명.set( 수정할 인덱스 , 새로운값 ); : 지정할 인덱스에 요소 값 수정

                    5) 요소 삭제
                        변수명.remove( 인덱스 );         : 지정한 인덱스 요소값 삭제

                4. 리스트와 반복문 관계
                    (1) 일반 반복문
                        for (int i = 0; 리스트변수명.size(); i++ ){
                            항목타입 변수명 = 리스트변수명.get( i );

                        }

                    (2) 향상된 반복문
                        for ( 항목타입 변수명 : 리스트변수명 ){
                        }


         */
        // [1] ArrayList 객체 생성하기.
        ArrayList< String > 리스트객체 = new ArrayList<>();

        // [2] .add(); : 요소 추가 하기
        리스트객체.add("유재석");

        // [3] 변수명
        System.out.println( 리스트객체 );
        
        // ! 요소 추가 삽입
        리스트객체.add("강호동");
        리스트객체.add("신동엽");
        System.out.println( 리스트객체 );
        
        // ! 중간에 요소 추가 삽입
        리스트객체.add(1, "박명수");    // add.(중간에 들어갈 위치 인덱스 , 추가할놈)
        System.out.println( 리스트객체 );
        
        // [4] .set();      : 요소 수정 하기
        리스트객체.set( 1, "이명수" );          // 1번 인덱스의 요소값을 수정한다는 뜻
        System.out.println( 리스트객체 );

        // [5] .size();     : 리스트의 크기 확인 하기 vs 배열에서 사용한 .length랑 비슷하다.
        System.out.println( 리스트객체.size() );

        // [6] .get()       : 특정한 요소값 반환/출력 vs 배열에서 사용한 변수명[인덱스] 비슷하다.
        System.out.println( 리스트객체.get( 1 ) );   // 1번 인덱스의 요소값 반환 vs 변수명[1]

        // [7] .remove()    : 요소 삭제
        리스트객체.remove(1);            // 1번 인덱스 삭제
        System.out.println(리스트객체);

        // [8] 리스트객체와 반복문 관계
            // (1) 일반 반복문
        for (int i = 0; i < 리스트객체.size() ; i++) {
            String str = 리스트객체.get(i);  // i번째 인덱스 요소를 하나씩 순회;
            System.out.println( str );
        }

            // (2) 항상된 for문
        for (String str : 리스트객체) {  // 리스트 목록내 요소값 하나씩 str에 대입 반복
            System.out.println( str );
        }

        // [9] String 이 아닌 내가 만든 클래스( Member ) 타입

        // 1) 3개의 Member 객체 생성

        Member m1 = new Member("강호동" , 10);
        Member m2 = new Member("유재석" , 20);
        Member m3 = new Member("신동엽" , 30);

        // 2) Member 타입/클래스 의 객체 3개를 저앟라 ArrayList 객체 생성

        ArrayList< Member > memberList = new ArrayList<>(); // 꺽은괄호는 리스트/목록 내 저장할 항목의 타입

        // 3) 리스트에 객체들을 저장한다.

        memberList.add(m1);
        memberList.add(m2);
        memberList.add(m3);

        // 4) 리스트내 요소(객체)들을 순회 (하나씩 조회) 하기
        for (Member member : memberList){
            System.out.println("이름 : " + member.name + " 나이 : " + member.age);
        }   // for end


    }   // main end
}   // class end

class Member{   // class Member start

    // 멤버변수
    String name;    // 이름
    int age;     // 나이

    // 생성자
    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }   // 생성자 end
}   // class Member end