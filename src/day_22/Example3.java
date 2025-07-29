package day22;

import java.util.ArrayList;

class Box1{
    String content;
}
class Box2{
    int content;
}
// [3] < T > 제네릭 타입
// 클래스 정의할때 타입 정하지 않고 매개 표현
// content 변수에 String/int 처럼 타입 정하지 않는다.
// 인스턴스 생성시 T에 대해서 타입 정한다.
class Box< T >{
    T content;
}
// 배열 이용한 arrayList 표현
class miniArrayList< E > {
    E[] data = (E[]) new Object[10];
}
// [4]
// 관례적으로 제네릭이름은 대문자1개
class Dto< T , E >{
    T value1;   // T : 정해지지 않은 타입
    E value2;   // E : 정해지지 않은 타입
}

public class Example3 {
    public static void main(String[] args) {
        /*
        [ 제네릭 타입 ]
            1. 정의 : 여러 가지 타입에서 동작할 수 있도록 만든 키워드/문법
            2. 목적 : 클래스 정의할때 변수 타입을 정하지 않고 인스턴스를 생성할때 변수 타입 정한다.
                -> 다양한 타입의 데이터를 처리할 수 있다.
            3. 사용법 : < > 꺽은괄호 이용한 표현
                1) 클래스 정의
                    class 클래스명< 제네릭타입명 >{
                        제네릭타입명 변수명;
                    }
                    class 클래스명< 제네릭타입명A , 제네릭타입명B > {
                        제네릭타입명A 변수명A;
                        제네릭타입명B 변수명B;
                    }
                2) 인스턴스 생성
                    클래스명< 타입명 > 변수명 = new 생성자명<>();
                    클래스명< 타입명A, 타입명B > 변수명 = new 생성자명<>();
            4. 활용처 : 컬렉션프레임워크(실무중요)
                ArrayList< 제네릭타입 >
                - ArrayList 객체
                - < 제네릭타입 > : ArrayList 객체내 여러개 요소들을 저장할 항목타입
            5. 특징 : 변수의 타입 유연성 , 코드중복제거 , 잘못된 타입 방지
            6. 주의할점 : 기본타입(8가지) 로는 제네릭타입으로 사용불가능 ,
                -> 기본타입 --> 래퍼클래스 , int --> Integer
        */

        // [1] String 타입 멤버변수에 String 자료
        Box1 box1 = new Box1();
        box1.content = "안녕하세요";      // 저장
        String content1 = box1.content; // 호출

        // [2] int 타입 멤버변수에 int 자료
        Box2 box2 = new Box2();
        box2.content = 100;             // 저장
        int content2 = box2.content;    // 호출

        // [3] 제네릭타입
        Box< String > box3 = new Box<>();
        // Box< int > box4 = new Box<>();
        // * 기본타입으로 제네릭타입 사용불가능.
        Box< Integer > box4 = new Box<>();
        // * 뒤에 생성자에는 제네릭타입을 생략 가능하다.
        box3.content = "자바";
        box4.content = 200;
        // * 즉] 동일한 타입내 서로 다른 멤버변수 타입 가능하다.

        // [활용처] 컬렉션 프레임워크
        ArrayList< String > sList = new ArrayList<>();
        ArrayList< Integer > ilist = new ArrayList<>();
        // * ArrayList : 타입/클래스 , < String > : ArrayList 안에서 사용할 타입

        // [4] 제네릭타입 여러개
        Dto< String , Integer > dto = new Dto<>();
        dto.value1 = "문자열";
        dto.value2 = 400;

        Dto< Double , Byte > dto2 = new Dto<>();
        dto2.value1 = 3.14;
        dto2.value2 = 99;
        // - 같은 클래스에서 서로다른 멤버변수 타입 사용한다.**

        // [ 활용1 ] 제네릭 중첩
        Dto< Integer , ArrayList< String > > dto3 = new Dto<>();
        // dto3 : Integer value1;  ArrayList<String > value2
        dto3.value1 = 3;
        dto3.value2 = new ArrayList<>();


    } // main end
} // class end