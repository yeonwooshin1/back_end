package day_04; // pakage

import java.util.Scanner;

public class 실습4 { // class start
    public static void main(String[] args) { // main start
        Scanner scan = new Scanner(System.in);
        /*
        // 1.
        System.out.print("첫번째 점수 : ");
        int score1 = scan.nextInt();
        System.out.print("두번째 점수 : ");
        int score2 = scan.nextInt();

        if(score1+score2 >= 90) {
            System.out.println("성공!");
        }
        else {
            System.out.println("실패!");
        }

        // 2.
        System.out.print("첫번째 정수 : ");
        int iNum1 = scan.nextInt();
        System.out.print("두번째 정수 : ");
        int iNum2 = scan.nextInt();
        if(iNum1 >= iNum2){
            System.out.println(iNum1);
        } else if (iNum1< iNum2) {
            System.out.println(iNum2);
        }


        // 3.
        System.out.print("아이디 : ");
        String id = scan.next();
        System.out.print("비밀번호 : ");
        String password = scan.next();
        if( id.equals("admin") && password.equals("1234"){
            System.out.println("로그인 성공");
        }else {
            System.out.println("로그인 실패");
        }

        // 4.
        System.out.print("비밀번호를 입력하세요 : ");
        String input = scan.next();
        if(input.length() >= 12){
            System.out.println("보안등급 강함");
        } else if (input.length() >= 8){
            System.out.println("보안등급 보통");
        }else {
            System.out.println("보안등급 약함");
        }

        // 5.
        System.out.print("주민등록번호(-포함) 13자리를 입력하세요 : ");
        String id = scan.next();
        if(id.charAt(7) == '1' || id.charAt(7) == '3'){
            System.out.println("남자");
        } else if(id.charAt(7) == '2' || id.charAt(7) == '4'){
            System.out.println("여자");
        }


        // 6.
        System.out.print("점수를 입력하세요 : ");
        int gameScore = scan.nextInt();

        if (gameScore >= 900){
            System.out.println("A급 경품");
        } else if (gameScore >= 700) {
            System.out.println("B급 경품");
        } else if (gameScore >= 500) {
            System.out.println("C급 경품");
        } else {
            System.out.println("참가상");
        }

        // 7.
        System.out.print("역할을 입력하세요 : ");
        String role = scan.next();
        if(role.equals("admin")){
            System.out.println("모든 기능에 접근할 수 있습니다.");
        } else if (role.equals("editor")) {
            System.out.println("콘텐츠 수정 및 생성 기능에 접근할 수 있습니다.");
        } else if (role.equals("viewer")) {
            System.out.println("컨텐츠 조회만 가능합니다");}
        else {
            System.out.println("정의되지 않은 역할입니다.");
        }


        // 8.
        System.out.print("나이를 입력하세요 : ");
        int ageM = scan.nextInt();
        if (ageM >= 65){
            System.out.println("3,000원");
        } else if (ageM >= 20) {
            System.out.println("10,000원");
        }else if (ageM >= 8 ){
            System.out.println("5,000원");
        }else {
            System.out.println("무료");
        }

        // 9.
        System.out.print("점수를 입력하세요 : ");
        int studyScore = scan.nextInt();

        if (studyScore >= 90){
            System.out.println("A등급");
        } else if (studyScore >= 80) {
            System.out.println("B등급");
        } else if (studyScore >= 70) {
            System.out.println("C등급");
        } else {
            System.out.println("재시험");
        }

        // 10.
        System.out.print("총 구매 금액: ");
        int saleLate = scan.nextInt();

        if (saleLate >= 50000){
            System.out.println("최종결제금액 :" + (int)(saleLate*0.9)+"원");
        } else if (saleLate >= 30000 ) {
            System.out.println("최종결제금액 : "+ (int)(saleLate*0.95) +"원");
        }else if (saleLate >= 10000 ) {
            System.out.println("최종결제금액 : " + (int)(saleLate*0.99) +"원");
        } else{
            System.out.println("할인 없음");
        }

        // 11.
        System.out.print("월(1~12)을 입력하세요 : ");
        int month = scan.nextInt();

        if (month >= 3 && month <= 5){
            System.out.println("봄");
        } else if (month >= 6 && month <= 8) {
            System.out.println("여름");
        }else if (month >= 9 && month <= 11) {
            System.out.println("가을");
        }else if (month == 12 || month == 1 || month == 2 ) {
            System.out.println("겨울");
        } else{
            System.out.println("잘못된 월입니다.");
        }

        // 12.

        System.out.print("정수1 ");
        int intA = scan.nextInt();
        System.out.print("정수2 ");
        int intB = scan.nextInt();
        System.out.print("정수3 ");
        int intC = scan.nextInt();

        if(intA > intB && intA > intC){
            System.out.println("가장 큰 수 : " + intA);
        } else if (intB > intA && intB > intC) {
            System.out.println("가장 큰 수 : " + intB);
        } else if (intC > intA && intC > intB) {
            System.out.println("가장 큰 수 : " + intC);
        }


        // 13.
        System.out.print("연도를 입력하세요 : ");
        int years = scan.nextInt();

        if((years%4 == 0 && years%100 != 0)|| years%400 == 0 ){
            System.out.println(years +"년은 윤년입니다.");
        } else {
            System.out.println(years +"년은 평년입니다.");
        }


        // 14.
        System.out.print("정수1 ");
        int intI = scan.nextInt();
        System.out.print("정수2 ");
        int intJ = scan.nextInt();
        System.out.print("정수3 ");
        int intK = scan.nextInt();

        if(intI > intJ && intI > intK){
            if(intJ > intK){
                System.out.println(intI +","+ intJ +","+ intK);
            }else{ System.out.println(intI +","+ intK +","+ intJ); }
        } else if (intJ > intI && intJ > intK) {
            if(intI > intK){
                System.out.println(intJ +","+ intI +","+ intK);
            }else{
                System.out.println(intJ +","+ intK +","+ intI);
            }
        } else if (intK > intI && intK > intJ) {
            if(intI > intJ){
                System.out.println(intK +","+ intI +","+ intJ);
            }else{
                System.out.println(intK +","+ intJ +","+ intI);
            }
        }


        */
        // 15.
        System.out.print("플레이어1 ");
        int intP1 = scan.nextInt();
        System.out.print("플레이어2 ");
        int intP2 = scan.nextInt();

        if(intP1 == 0){
            if(intP2 == 1){
                System.out.println("플레이어2 승리");
            } else if (intP2 == 2) {
                System.out.println("플레이어1 승리");
            }
        } else if (intP1 == 1) {
            if(intP2 == 2){
                System.out.println("플레이어2 승리");
            } else if (intP2 == 0) {
                System.out.println("플레이어1 승리");
            }
        } else if (intP1 == 2) {
            if(intP2 == 0){
                System.out.println("플레이어2 승리");
            } else if (intP2 == 1) {
                System.out.println("플레이어1 승리");
            }
        } else if (intP1 == intP2) {
            System.out.println("무승부");
        }


    } // main end



}// class end
