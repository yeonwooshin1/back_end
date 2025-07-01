package day_03; // pakage name

import java.util.Scanner;

public class 실습2 { // class start
    public static void main(String[] args) { // main start

        // 1.

        byte a = 10;
        int b = 200;
        long c = a + b;
        System.out.println(c);

        // 2.
        double z = 3.141592;
        int zInt = (int)z;
        System.out.println("원본 double의 값 : " + z);
        System.out.println("변환된 int의 값 : " + zInt);

        // 3.   Scanner scan = new Scanner( System.in );
        Scanner scan = new Scanner( System.in );

        System.out.print("이름을 입력하세요 : ");
        String str3 = scan.next();
        System.out.print("나이를 입력하세요 : ");
        String str4 = scan.next();
        System.out.println(str3 +"님의 나이는" + str4 +"세 입니다.");

        // 4.   Scanner scan = new Scanner( System.in );

        System.out.print("게시물 번호 : ");
        int i = scan.nextInt();
        scan.nextLine();
        System.out.print("제목 : ");
        String str1 = scan.nextLine();
        System.out.print("내용 : ");
        String str2 = scan.nextLine();
        System.out.println( "["+ i + "번 게시물 ]");
        System.out.println("제목 : " + str1);
        System.out.println("내용 : " + str2);


        // 5. Scanner scan = new Scanner( System.in );

        System.out.print("성별을 입력하세요. (남/여) : ");
        char value1 = scan.next().charAt(0);
        System.out.println("입력하신 성별은 "+  value1 + "입니다." );

        // 6. Scanner scan = new Scanner( System.in );

        System.out.print("키를 입력하세요.");
        double value2 = scan.nextDouble();
        System.out.println("당신의 키는 약 " + (int)value2 +"cm 이군요.");


        // 7. Scanner scan = new Scanner( System.in );

        System.out.print("이름 : ");
        String str5 = scan.next();
        System.out.print("나이 : ");
        int value4 = scan.nextInt();
        System.out.print("키 : ");
        double value5 = scan.nextDouble();
        System.out.print("프로게이머입니까? true/false");
        boolean value6 = scan.nextBoolean();

        System.out.println("--- 자기 소개 ---");
        System.out.println("이름 : " + str5);
        System.out.println("나이 : " + value4);
        System.out.println("키 : " + value5 +"cm");
        System.out.println("프로게이머 여부 : " + value6);


    } // main end
}// class end
