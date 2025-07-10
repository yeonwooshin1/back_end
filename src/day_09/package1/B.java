package day_09.package1;    // B 클래스의 폴더(패키지) 위치

public class B {
    public void 메소드(){
        A a = new A();
        System.out.println(a.공개변수);     // 가능
        // System.out.println(a.비공개변수);   // 불가능 , private
        System.out.println(a.일반변수);     //  가능 : A와 B는 같은 패키지에 있어서 가능
    }
}
