package day_09;    // package

public class CircleCalculator { // class CircleCalculator start
    final double PI = 3.14159;  // PI 값 상수 지정

    void printCircleArea(int radius){   //  int radius를 매개변수로 하는 printCircleArea 메소드
        double circleArea = radius * radius * PI;   // circleArea는 반지름 * 반지름 * PI
        System.out.println(circleArea);             // System.out.println(circleArea);
    }   // func end
}   // class CircleCalculator end
