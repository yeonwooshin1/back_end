package day_14;

class Car{ // 자동차
    Tire tire;
    void run() { this.tire.roll(); }
}
class Tire{ // 타이어
    void roll(){
        System.out.println("[일반] 타이어가 회전");
    }
}
// 일반타이어로 부터 상속받아 한국타이어에서 메소드 재정의
class HankookTire extends Tire{
    void roll(){
        System.out.println("[한국] 타이어가 회전(업그레이드)");
    }
}
// 일반타이어로 부터 상속받아 금호타이어에서 메소드 재정의
class KumhoTire extends Tire{
    void roll(){
        System.out.println("[금호] 타이어가 회전(업그레이드)");
    }
}

public class Example2 {
    public static void main(String[] args) {
        // (1) Car 객체 생성
        Car myCar = new Car();
        // myCar.run(); // [오류] 멤버변수(tire)가 null
        myCar.tire = new Tire(); // 멤버변수에 tire 객체 대입
        myCar.run(); // 이제는 null 아니기 때문에 '[일반] 타이어가 회전'
        // (2) 타이어 교체
        myCar.tire = new HankookTire(); // 멤버변수에 Htire 객체 대입
        myCar.run(); // [한국] 타이어가 회전(업그레이드)
        // (2) 타이어 교체
        myCar.tire = new KumhoTire();
        myCar.run(); // [금호] 타이어가 회전(업그레이드)
        // !! : Tire 타입의 멤버변수는 Tire객체,Htire객체,Ktire객체를 모두 대입 받을수 있다.
        // 이유 : 상속관계라서,(자동타입변환) 자식타입은 부모타입으로 자동

        System.out.println( myCar.tire instanceof Tire ); // true
        System.out.println( myCar.tire instanceof KumhoTire ); // true
        System.out.println( myCar.tire instanceof HankookTire ); // false
        // 이유 : KumhoTire 객체가 생성될떄 : KumhoTire , Tire 총2개 생성
        // 하위타입의 객체를 생성하면 상위타입의 객체도 같이 생성된다.
        // 즉] KumhoTire 객체가 생성될때 HankookTire 객체는 생성되지 않는다. (형제관계라서)

    } // main
} // class end