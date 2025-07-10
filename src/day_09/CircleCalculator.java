package day_09;    // package

public class CircleCalculator { // class CircleCalculator start
    final double PI = 3.14159;  // PI 값 상수 지정

    void printCircleArea(int radius){
        double circleArea = radius * radius * PI;
        System.out.println(circleArea);
    }
}   // class CircleCalculator end
