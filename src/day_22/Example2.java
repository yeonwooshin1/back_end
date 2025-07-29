package day_22; // package

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Example2 { // class start
    public static void main(String[] args) {    // main start
        /*
            [ Random ] 난수 클래스
                1. 사용법
                    1) 랜덤 객체 생성
                        Random random = new Random();
                    2) 주요 메소드
                        .nextInt() : int 타입의 허용범위내 난수 생성
                        .nextInt(값) : 0부터 값-1 사이의 난수 생성
                        .nextInt(끝값)+ 시작값 : 시작값 부터 끝값 사이의 난수 생성

         */
        // 1. Random 객체 생성
        Random random = new Random();
        System.out.println(random); // java.util.Random@7cca494b

        // 2. 1~10 사이의 난수 생성 ( int 타입 )
        int value1 = random.nextInt();                  System.out.println( value1 );
        int value2 = random.nextInt(10) + 1;     System.out.println( value2 );

        // 3. 0 ~ 99 까지 난수 생성
        int value3 = random.nextInt(100);        System.out.println(value3);

        // 4. 0 과 1 사이의 실수 생성
        double value4 = random.nextDouble();            System.out.println(value4);

        // 5. true 과 false 생성
        boolean value5 = random.nextBoolean();          System.out.println(value5);

        // 활용1) 임의의 여러개 데이터중 하나 선택 하기
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("유재석");     nameList.add("강호동");   nameList.add("신동엽");
        int randomIndex = random.nextInt(nameList.size());    // .size()  : arrayList 길이 반환 메소드
        System.out.println("추천된 사람 : " + nameList.get(randomIndex));

        // 활용2) 새로운 비밀번호 , 인증코드 문자 난수 표현
        StringBuilder code = new StringBuilder();
        for (int i = 0; i <= 6; i++) {  // 6자리 만들기 위한 6회전 반복문
            // a : 97 ~ z : 122
            Random ran = new Random();
            int val = ran.nextInt( 26 ) + 97;   // a : 97 ~ z : 122
            char str = (char)val ;
            System.out.println( str );
            code.append(str);
        }   // for end
        System.out.println("생성된 코드 : "+ code);

        // 활용3] 아스키코드 패턴으로 난수 계산식 못만들 경우 직접 난수에 넣을 데이터를 배열로 선언
        char[] ranStr = { '0' , '1' , '2' , '3' , '4' , 'A' , 'a' , '!'};
        StringBuilder newPwd = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            Random ran = new Random();
            int index = ran.nextInt( ranStr.length );
            newPwd.append(ranStr[index]);
        }   // for end
        System.out.println("생성된 패스워드 : " + newPwd );

        // 활용4] 주사위 : 1~6 사이
        int dice = random.nextInt( 6 ) + 1;
        System.out.println( dice );

        // 활용5] 로또 번호 생성 : 1 ~ 45 사이의 중복없이 6개 생성
        ArrayList< Integer > lottoList = new ArrayList<>();
        for( ; ; ) {
            int lotto = random.nextInt(45) + 1; // 생성된 로또 번호
            if( lottoList.contains( lotto ) ){ // 리스트에 생성된 로또번호가 존재하면
                continue; // 이번 반복 무효처리
            }
            lottoList.add( lotto );  // 생성된 로또 번호를 리스트에 담기
            if( lottoList.size() == 6 ) break; // 로또 번호가 6개 이면 반복문 종료
        }
        System.out.println( lottoList );

        // 활용6] 하나의 문자열에서 추출한 문자로 문자열 난수 생성
        String ranStr2 =  "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int strlen = ranStr2.length(); // (1) 문자열 길이 구하기
        int ranIndex = random.nextInt( strlen ); // (2) 문자열 길이내 난수 생성
        char str = ranStr2.charAt( ranIndex ); // (3) 문자열내 인덱스 위치한 문자 1개 추출
        System.out.println( str );



    }   // main start
}   // class end
