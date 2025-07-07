package day_06; // pakage

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class 실습6 {  // class start
    public static void main(String[] args) {    // main start

        // 1.
        int[] numbers = { 10, 20, 30, 40, 50 };
        System.out.println(numbers[1]);

        // 2.
        String[] season = new String[3];

        season[0]   = "봄";
        season[1]   = "여름";
        season[2]   = "가을";

        System.out.println(Arrays.toString(season));

        // 3.
        String[] fruit = { "사과" , "바나나" , "포도" , "딸기" };

        for(String i : fruit){
            System.out.println(i);
        }

        //4.
        int[] scores = {85, 92, 78, 65, 95};
        double sum = 0;
        for(int i : scores ){
            sum += i;
        }
        System.out.println(sum);
        System.out.println(sum/scores.length);

        //5.

        int[] scores1 = {77, 82, 100, 54, 96};

        for( int i : scores1 ){
            if(i == 100){
                System.out.println("만점자를 찾았습니다!");
                break;
            }
        }

        // 6.
        String[] bloodTypes = {"A", "B", "O", "AB", "A", "B", "A"};
        int bloodA = 0;
        for ( String i : bloodTypes ){
            if(i.equals("A")){
                ++bloodA;
            }
        }
        System.out.println(bloodA);

        // 7.
        int[] numbers2 = {23, 5, 67, 12, 88, 34};
        int number = 0;
        for ( int i : numbers2 ){
            if(number < i){
                number = i;
            }
        }
        System.out.println(number);

        // 8.

        String[] products = {"볼펜", "노트", "지우개"};
        int[] stock = {10, 5, 20};

        Scanner scan = new Scanner(System.in);
        System.out.print("구매할 상품명 : ");
        String questionStock = scan.next();
        System.out.print("구매할 수량 : ");
        int questionAmount = scan.nextInt();
        int check = 0;
        for(int i = 0; i< products.length; i++){
            String product = products[i];
            if(product.equals(questionStock)){
                if(questionAmount <= stock[i]){
                    stock[i] -= questionAmount;
                    check = 1;
                    break;
                }
                else{
                    check = 2;
                    break;
                }
            }
        }
        if(check == 0 ){
            System.out.println("없는 제품입니다.");
        } else if (check == 1) {
            System.out.println("구매완료");
        } else{
            System.out.println("재고가 부족합니다.");
        }



        // 9.
        String[] movieNames = {"히든페이스", "위키드", "글래디에이터2", "청설"};
        int[] movieRatings = {8, 4, 7, 6};

        for( int i = 0; i < movieNames.length; i++ ){
            System.out.print(movieNames[i]+"           ");

            for( int j = 0; j < 10 ; j++){
                if(movieRatings[i] > j){
                System.out.print('★');
                } else{
                    System.out.print('☆');
                }
            }

            System.out.println();
        }

        // 10.

        String[] carNumbers = {"210어7125", "142가7415", "888호8888", "931나8234"};
        int[] usageMinutes = {65, 30, 140, 420};

        for( int i = 0; i< carNumbers.length; i++ ){
            System.out.print(carNumbers[i]+": " + usageMinutes[i]+"분 주차, 최종 요금 : ");
            if(usageMinutes[i] > 30){
                int fee = (usageMinutes[i]-30)/10;
                if((fee * 500 + 1000) > 20000){
                    System.out.println(20000 + "원");
                }
                else{System.out.println( ((fee *500) + 1000) + "원"); }
            }
            else{
                System.out.println(1000 + "원");
            }
        }









    }   // main end
}   // class end
