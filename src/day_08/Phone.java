package day_08; // package

public class Phone {    // class start
    // 클래스 멤버
    // 1. 멤버변수
    String model;   // 핸드폰 모델명
    String color;   // 핸드폰 색상
    int price;      // 핸드폰 가격

    // 2. 생성자
    // 1) 기본 생성자 :
        // -> 클래스내 생성자가 하나도 없으면 자동으로 (컴파일될 때) 생성된다.
        // -> 클래스내 생성자가 하나 이상이라도 있으면 직접 기본생성자 정의해야함.
    Phone(){
        System.out.println("Phone 기본생성자 실행");
    }

    // 2) 매개변수가 있는 생성자
        // -> 생성자는 매개변수는 있지만 반환값이 없다.
    Phone( String pModel , String pColor ){
        // 매개변수로 받은 인자/인수값을 멤버변수에 저장한다.
        model = pModel;
        color = pColor;

        // 초기값을 임의로 고정한다. 120만원
        price = 1200000;
    }
    // 3) 생성자의 오버로드
        // -> 기존 생성자와 매개변수가 매개변수의 타입/순서/개수 다르면 오버로드
    Phone( String Model , String Color , int Price){
        // ---> 멤버변수 : 객체내 변수
        // ---> 매개변수 : 메소드/생성자가 사용되는 인수값 저장변수
        // 문제점 : 이름이 같네....
        // -> model = model; // ?? 누가 멤버변수고 누가 매개변수인지 컴퓨터는 모른다. 멍청한놈
        // 해결책 : this 키워드 : 현재 메소드/생성자를 호출한 객체를 가르킨다.
        this.model = Model;
        this.color = Color;
        this.price = Price;
        // 김아무개 왈 : this 안쓰고 이름을 다르게 할게요;;;;;
        // [관례적] 초기화 값은 멤버변수명와 매개변수명을 동일하게 한다.
    }

    // 3. 메소드

}   // class end
