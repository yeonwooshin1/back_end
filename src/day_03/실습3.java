package day_03; // 패키지

import java.util.Scanner;

public class 실습3 { // class start
    public static void main(String[] args) { // main start
        Scanner scan = new Scanner(System.in);
        // 1.
        System.out.print("국어 점수 : ");
        int val1 = scan.nextInt();
        System.out.print("영어 점수 : ");
        int val2 = scan.nextInt();
        System.out.print("수학 점수 : ");
        int val3 = scan.nextInt();

        System.out.println("총점 : " + (val1 + val2+ val3));
        System.out.println("평균 : " + (val1 + val2+ val3)/3);

        // 2.
        System.out.print("반지름을 입력하세요 : ");
        double val4 = scan.nextDouble();
        System.out.println("원의 넓이 : " + val4*val4*3.14);


        // 3.
        System.out.print("첫 번째 실수 : ");
        double val5 = scan.nextDouble();
        System.out.print("첫 번째 실수 : ");
        double val6 = scan.nextDouble();

        System.out.println("비율 : " + (val5/val6)*100 +"%");


        // 4.
        System.out.print("정수를 입력하세요 : ");
        int val7 = scan.nextInt();
        boolean q1 = ( val7 % 2 ) == 0;
        System.out.println(q1);

        // 5.
        System.out.print("정수를 입력하세요 : ");
        int val8 = scan.nextInt();
        boolean q2 = ( val8 % 7 ) == 0;
        System.out.println(q2);


        // 6.
        System.out.print("아이디 : ");
        String val9 = scan.next();
        System.out.print("비밀번호 : ");
        String val10 = scan.next();
        System.out.println( val9.equals("admin") && val10.equals("1234") );


        // 7.
        System.out.print("정수를 입력하세요 : ");
        int val11 = scan.nextInt();
        boolean q6 = ( val11 % 2 ) == 0 && ( val11 % 7 )== 0;
        System.out.println(q6);


        // 8.
        System.out.print("1차 점수 : ");
        int val12 = scan.nextInt();
        System.out.print("2차 점수 : ");
        int val13 = scan.nextInt();

        String q7 = (val12+val13) >= 150 ? "합격" : "불합격";
        System.out.println("결과 : " +q7 );


        // 9.

        System.out.print("이름을 입력하세요 : ");
        String nameInput1 = scan.next();
        System.out.println( nameInput1.equals("유재석")? nameInput1 += "(방장)" : nameInput1 );


        // 10.

        System.out.print("밑변 : ");
        double value14 = scan.nextDouble();
        System.out.print("높이 : ");
        double value15 = scan.nextDouble();
        System.out.println("삼각형의 넓이 : " + value15*value14 / 2.0 );

        // 11.

        System.out.print("섭시 온도 : ");
        double value16 = scan.nextDouble();
        System.out.println("화씨 온도 : " + (value16 * 9.0 / 5.0 + 32 ) ) ;



        // 12.

        System.out.print("태어난 연도 : ");
        int value17 = scan.nextInt();
        System.out.println("2025년 기준 나이 : " + (2025 - value17)+"세");



        // 13.
        System.out.print("키(cm) : ");
        double value18 = scan.nextDouble();

        System.out.print("몸무게(kg) : ");
        double value19 = scan.nextDouble();

        System.out.println("BMI 지수 : " + value19/((value18*value18)/10000.0));


        // 14.
        System.out.print("아이디 : ");
        String value20 = scan.next();
        System.out.print("이메일 : ");
        String value21 = scan.next();

        System.out.println("결과 : " + (value20.equals("user1") && value21.equals("admin@test.com")? "관리자" : "일반 사용자"));



        // 15.
        System.out.print("점수를 입력하세요 : ");
        int value21 = scan.nextInt();
        System.out.println("등급 : " + (value21 >= 90 ? 'A' : (value21 >= 80 ? 'B' : 'C' )));



        // 16.

        System.out.print("나이를 입력하세요 : ");
        int value22 = scan.nextInt();
        System.out.println((value22 < 20 ? "이벤트 대상이 아닙니다." : (value22 > 29 ? "이벤트 대상이 아닙니다." : "이벤트 대상입니다. ")));




    } // main end
} // class end
