package day_10;
class Controller{   // class Controller
    // 1. 기본생성자 private 한다. < 외부에서 new 사용금지 >
    private Controller(){};
    // 2. private static final 이요한 인스턴스 하나 만든다.< 싱글톤 >
    private static final Controller controller = new Controller();
    // 3. public static 이용한 인스턴스 getter 메소드를 만든다. < 싱글톤 반환 >
    public static Controller getInstance(){
        return controller;
    }   // getter end

}   // class end

public class Example1 { // class start
    public static void main(String[] args) {    // main start
        // 4. 싱글톤 불러오기
        Controller.getInstance();   // vs new Controller();

    }   // main end
}   // class end
