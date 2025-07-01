package day_03; // 패키지

public class Example1 { // class start
    public static void main(String[] args) { // main start
        /*

            조건문(IF)
                1. 조건에 따른 결과를 제어
                2. 종류
                    (1) if( 조건문 ) 참일 때 코드 ;
                    (2) if( 조건문 ) {
                            참일 때 명령어1;
                            참일 때 명령어2;
                        }
                    (3) if ( 조건문 ) { 참일 때 명령어 ;}
                        else {거짓일 때 명령어 ;}

                    (4) if ( 조건문1 ) {참일 때 명령어 ;}
                        else if( 조건문2 ) { 두번째 참일 때 명령어 ;}
                        else if( 조건문3 ) { 세번째 참일 때 명령어 ;}
                        else { 거짓일 때 명령어 ;}

                    (5) if ( 조건문1 ) { 참일 때 명령어; }
                        if ( 조건문2 ) { 참일 때 명령어; }
                        if ( 조건문3 ) { 참일 때 명령어; }

                    [6] if ( 조건문1 ) {
                            if ( 조건문2) { }
                            else { }
                        }
                    * 4번 : 여러 조건에 하나의 결과 추출
                    * 5번 : 여러 조건에 여러(하나일수도) 결과 추출

                 3. 주의할 점
                    (1) 조건문 자리에는 true / false 만 가능
                    (2) {} 중괄호 잘 챙기세요 저기,, 관리 잘하세요.
                    (3) if(); if 소괄호 뒤에 ;세미콜론 넣지 마라.
                    (4) if , if - else , if- else if- else 모두 다 하나의 결과를 낳는다.
         */
        // [1]
        int 온도 = 5;
        if ( 온도 <= 10 ) System.out.println("외투를 입는다.");

        // [2]
        int 나이 = 30;
        if ( 나이 >= 19){
            System.out.println("성인입니다.");
            System.out.println("19세 이상입니다.");
        }

        // [3]
        boolean 회원검사 = false;
        if (회원검사 == true ){
            System.out.println("hi 회원");
        }
        else{ System.out.println("비회원임"); }

        // [4]
        int 지갑돈 = 1750;
        if ( 지갑돈 > 3000 ){
            System.out.println("택시를 탄다.");}
        else if ( 지갑돈 > 1700 ){
            System.out.println("버스를 탄다.");
        } else if ( 지갑돈 > 1200) {
            System.out.println("자전거를 탄다.");
        } else {
            System.out.println("걸어간다.");
        }

        // [5]
        if ( 지갑돈 >= 3000 ) {
            System.out.println("take a taxi");
        }
        if ( 지갑돈 >= 1700 ){
            System.out.println("take a bus");
        }
        if ( 지갑돈 >= 1200 ){
            System.out.println("take a 자전겅");
        }

        // [6]
        int age = 25;
        char gender = 'W'; // 여자
        if( age > 19 ){
            System.out.println("성인입니다.");
            if(gender == 'W'){
                System.out.println("성인 여자");
            } else {
                System.out.println("성인 남자");
            }
        }else{
            System.out.println("미성년자");
        }


    } // main end
}   // class end
