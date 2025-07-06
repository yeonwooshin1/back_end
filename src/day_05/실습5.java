package day_05; // pakage 1

import java.util.Scanner;

public class 실습5 {  // class start
    public static void main(String[] args) { // main start

        // 1.
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }

        // 2.
        for (int i = 10; i > 0 ; i--) {
            System.out.println(i);
        }
        // 3.

        int sum = 0;
        for (int i = 1; i < 51; i++) {
            sum += i;
        }
        System.out.println("1부터 50의 합계 : " + sum);

        // 4.

        for (int i = 1; i < 21; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }

        // 5.
        for (int i = 1; i < 31; i++) {
            if (i % 3 == 0){
                continue;
            }
            System.out.println(i);
        }

        //6.
        int sum2 = 0;
        for (int i = 1; i < i+1; i++) {
            sum2 += i;
            if(sum2 > 100){
                System.out.println(i+"까지 더했을 때 합계가 " + sum2 +"으로 100을 넘습니다.");
                break;
            }
        }

        //7.

        for (int i = 1; i < 6; i++) {
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 8.

        for (int i = 5; i > 0; i--) {
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }


        // 9.
        Scanner scan = new Scanner(System.in);
        int count = 1;
        while(true){
            System.out.print( count + "회 입력 : ");
            String input = scan.next();
            if( input.equals("end")){
                System.out.println("[안내] 프로그램을 종료합니다. [총 "+ (count-1) +"회 입력]" );
                break;
            }
            count++;
        }

        // 10.

        int july1 = 3532100;    int july11 = july1/10000;
        int july2 = 9123700;    int july22 = july2/10000;
        int july3 = 5183400;    int july33 = july3/10000;
        int july4 = 11738700;   int july44 = july4/10000;

        for (int i = 1; i <= july11/100; i++) {
            System.out.print("■ " );
        }
        System.out.println(july11 + "만원");
        for (int i = 1; i <= july22/100; i++) {
            System.out.print("■ " );
        }
        System.out.println(july22 + "만원");
        for (int i = 1; i <= july33/100; i++) {
            System.out.print("■ " );
        }
        System.out.println(july33 + "만원");
        for (int i = 1; i <= july44/100; i++) {
            System.out.print("■ " );
        }
        System.out.println(july44 + "만원");


        // 11.

        int balance = 0;
        for( ; ; ) {

            System.out.println("-------------------------------------");
            System.out.println("1 : 입금 | 2 : 출금 | 3 : 잔고 | 4 : 종료");
            System.out.println("-------------------------------------");
            System.out.print("선택 > ");

            int choose = scan.nextInt();
            if( choose == 1 ){
                System.out.print("입금액> ");
                int money = scan.nextInt();
                balance += money;

            }else if( choose == 2 ){
                System.out.print("출금액> ");
                int money = scan.nextInt();
                if( balance >= money ){ balance -= money;  }
                else{ System.out.println("[안내] 잔고가 부족합니다. ");  }

            }else if( choose == 3 ){
                System.out.println("잔고> " + balance );

            } else if( choose == 4 ){
                System.out.println("프로그램을 종료합니다.");
                break; // 무한루프 종료

            }
        }

    } // main end
} // class end
