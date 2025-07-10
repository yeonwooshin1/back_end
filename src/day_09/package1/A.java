package day_09.package1;    // A 클래스의 폴더(패키지) 위치

public class A {    // * 클래스에는 private 키워드 불가능 *
    public  int  공개변수  = 1;  // public
    private  int 비공개변수 = 2; // private
    int 일반변수 = 3;           // (default) 생략

    public void 메소드(){
        System.out.println( this.공개변수 );    // 가능
        System.out.println( 비공개변수 );        // 가능 같은 클래스내라서
        System.out.println( 일반변수 );         // 가능
    }
}
