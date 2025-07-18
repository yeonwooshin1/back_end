package day_15;     // package

import java.sql.SQLOutput;

// 인터페이스란 ? 상수와 추상메소드를 갖는 타입
interface 키보드{  // interface start

    // [1] 상수 : 초기(처음)값이 필수다.
    public static final String 제조사 = "인텔";
    String 제조일 = "2025-07-18";  // 상수 키워드 생략가능

    // [2] 추상메소드 : 구현부{} 제외한 선언부만 메소드 선언
    public abstract void aKey();
    void bKey();    // 추상 키워드 생략가능

}   // interface end

// 구현체란? 추상메소드를 구현한 클래스
class 격투게임 implements 키보드 { // class 사냥게임 implements 키보드
    // - implements 했을 경우 무조건 오버라이딩(구현) 해야한다.
    // 생성 -> 메소드 구현 자동으로 됨.
    public void aKey() { System.out.println("[공격]"); }
    public void bKey() { System.out.println("[방어]"); }
}   // class end

class 축구게임 implements 키보드 { // class 축구게임 implements 키보드
    public void aKey() { System.out.println("[슈팅]"); }
    public void bKey() { System.out.println("[태클]"); }
}   // class end


public class Example1 { // class start
    public static void main(String[] args) {    // main start

        // [1] 인터페이스는 객체 생성이 안된다.
        // new 키보드;

        // [2] 인터페이스/타입 변수 선언 된다.
        키보드 myKeyBoard;

        // [*] 변수내 구현체(진짜) 가 없다.
        // myKeyBoard.aKey();

        // [3] 구현체 대입
        myKeyBoard = new 격투게임();
        myKeyBoard.aKey();  // [공격]
        myKeyBoard.aKey();  // [공격]
        myKeyBoard.aKey();  // [공격]

        // [4] 다형성 특징 : 중간에 타입변환
        myKeyBoard = new 축구게임();
        myKeyBoard.aKey();  // [슈팅]
        myKeyBoard.aKey();  // [슈팅]

        // [5] 익명구현체 : 클래스 없이 (이름 없는) 객체 만들기
        // 타입 변수 = new 인터페이스(){};
        // 사용처 : 간단한 일회성 구현을 해야할 때 , 스프링에서 쓰는 용도가 있다고 함.
        키보드 yourKeyBoard = new 키보드(){
            // 클래스 선언 없이 [여기] 에서 구현(오버라이딩)
            public void aKey() {System.out.println("[ 키보드A ]");}
            public void bKey() {System.out.println("[ 키보드B ]");}
        };  // 세미콜론 필요함 무조건

        // [6] 익명ㅇ구현체로 메소드 실행
        yourKeyBoard.aKey();    // [ 키보드A ]


    }   // main end
}   // class end
