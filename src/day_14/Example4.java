package day_14; // package

class 자동차{
    타이어 tire; //멤버변수

    void run(){ this.tire.roll();}  // 메소드

}   // class 자동차 end
interface 타이어{    // 인터페이스
    void roll();    // 추상메소드 : {}없다.
}   // interface end
class 한국타이어 implements 타이어{
    // @Override 생략 가능
    public void roll() {
        System.out.println("[한국] 타이어가 회전(구현)");
    }
}   // class 한국타이어 end
class 금호타이어 implements 타이어{
    // 추상메소드 자동완성 : (방법1) ctrl+스페이스바 (방법2) 오른쪽클릭 -> [생성] -> [메소드 구현]
    @Override
    public void roll() {
        System.out.println("[금호] 타이어가 회전(구현)");
    }
}   // class 금호타이어 end


public class Example4 { // class start
    public static void main(String[] args) {    // main start

        자동차 myCar = new 자동차();
        // myCar.run(); // 오류발생

        // 인터페이스는 생성자가 없다. // 인터페이스로 객체생성 불가능
        // MyCar.tire = new 타이어();

        // [1] 구현체
        myCar.tire = new 한국타이어();
        myCar.run();    // [한국] 타이어가 회전(구현)

        myCar.tire = new 금호타이어();
        myCar.run();    // [금호] 타이어가 회전(구현)

        // tire 멤버변수는 '타이어' 타입인데
        // 왜? '한국타이어'/'금호타이어' 타입이 대입될까?
        // - 한국타이어 와 금호타이어는 타이어 타입을 구현 했기 때문에

        System.out.println( myCar.tire instanceof 타이어 );    // true
        System.out.println( myCar.tire instanceof  금호타이어 );  // true
        System.out.println(myCar.tire instanceof 한국타이어 );   // false

    }   // main end
}   // class end
