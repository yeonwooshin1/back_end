package day_08; // package

class Student{
    // 멤버변수 = 속성/상태/특징/데이터

    String name;    // 이름
    String lunchBox;   // 점심도시락

    // 메소드 = 이벤트/행위/동작/사용법

    void eatFood(){
        System.out.println(name+ "는(은) " + lunchBox +"를 먹습니다.");
    }



}   // class Student end



public class example2 { // class start
    public static void main(String[] args) {    // main start

        Student student = new Student();
        student.name = "신연우";       student.lunchBox = "돈까스";
        student.eatFood();

        Student[] studentArray = new Student[100];
        studentArray[0] = student;
        studentArray[0].eatFood();

    }   // main end

}   // class end
