package day_16; // package

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class 실습15 { // class start
    public static void main(String[] args) {    // main start

        // 1. 파일에 일기 쓰기

        String path = "src/day_16/diary.txt";   // 문자열 경로 = String path

        try {
            FileOutputStream fout = new FileOutputStream( path ); // new FileOutputStream( 파일경로 );

            fout.write("오늘 날씨는 맑았다. 자바 공부는 재미있다?".getBytes());  // 변수명.write("문자열".getBytes() ) 바이트로 변환해야함!

        } catch (Exception e) { // 예외 처리 Exception
            System.out.println(e);
        }   // catch end


        try {
            // 3. File 클래스로 파일 정보 확인하기
            File file = new File( path );
            System.out.println( file.exists() );    // true
            System.out.println( file.getPath() );   // src\day_16\diary.txt
            System.out.println( file.getName() );   // diary.txt
            System.out.println( file.length() );    // 58

            // 2. 파일에 작성된 일기 읽기

            if (file.exists()) {  // file이 존재한다면?
                FileInputStream fin = new FileInputStream(path);  // new FileInputStream( 파일 경로 );

                byte[] bytes = new byte[(int)file.length()];      // file 타입이 long 이라서 int로 강제 타입변환 후 배열에 넣기

                fin.read(bytes);                                  // 바이트 배열 읽어오기
                String str = new String(bytes);                   // 읽어온 바이트 배열 문자열로 바꾸기
                System.out.println(str);                          // 그 문자열롤 바꾼 걸 println 해서 콘솔 출력
            }   // if end
        } catch (Exception e) { // 예외처리 Exception
            System.out.println(e);
        }   // catch end



        // 4. 방문 로그 누적 기록하기
        // 아래 방법으로 해도 되지만 append를 써서 FileOutputStream(불러올 파일 경로 , false면 덮어쓰기 또는 true 면 있던 거에 추가 ) 할 수 있다. -> 참고하세용.

        Scanner scan = new Scanner(System.in);          // Scanner 생성
        try {
            String paths = "src/day_16/visit_log.txt";  // 경로 생성 변수

            File file = new File(paths);                // 지정된 경로의 파일의 정보를 제공하는 객체 file 생성

            if(file.exists()){                          // file이 존재한다면?
                FileInputStream fin = new FileInputStream(paths);   // 파일 입력 객체 생성

                byte[] bytes = new byte[(int)file.length()];        // byte 타입의 배열에 file.length를 써서 공간 확보
                fin.read( bytes );                                  // .read 로 불러오기
                String str = new String( bytes );                   // 문자열로 변환하기

                FileOutputStream fout = new FileOutputStream(paths);  // FileOutputStream 객체 생성 ("파일경로");
                System.out.print("이름 입력 : ");     String name = scan.next();      // 이름 입력 받기

                byte[] byteOut = (str + name+" 님이 방문했습니다. \n").getBytes();              // 원래 있던 str 문자열 +scan 받은 거 바이트로 변환

                fout.write(byteOut);                  // 변수명.write(바이트 값); -> 바이트로 내보내기

            } else {                    // 존재하지 않는다면?
                FileOutputStream fout = new FileOutputStream(paths);   // FileOutputStream 객체 생성 ("파일경로");

                System.out.print("이름 입력 : ");     String name = scan.next();      // 이름 입력 받기

                byte[] byteOut = (name+" 님이 방문했습니다. \n").getBytes();              // scan 받은 거 바이트로 변환

                fout.write(byteOut);                  // 변수명.write(바이트 값); -> 바이트로 내보내기
            }

        } catch (Exception e) { // 예외처리 Exception
            System.out.println(e);
        }   // catch end


        // 5. 연락처를 CSV 형식으로 파일에 저장하기
        try {
            System.out.print("이름 : ");          String name = scan.next();           // scan 값 받기
            System.out.print("전화번호 : ");        String telNum = scan.next();        // scan 값 받기
            System.out.print("사는 도시 : ");       String whereLive = scan.next();     // scan 값 받기

            String str = name +","+ telNum+"," + whereLive;         // 입력받은 데이터 쉼표로 하나의 문자열 만들기

            String path1 = "src/day_16/contacts.csv";               // 저장할 값 받기
            FileOutputStream fout = new FileOutputStream(path1);    // 주소값 넣어서 파일 쓰는 객체에 넣기

            byte[] bytes = str.getBytes();                      // String byte로 타입변환

            fout.write(bytes);                                  // write로 내보내기

        } catch (Exception e) { // 예외처리 Exception
            System.out.println(e);
        }   // catch end


        try {
            // --------------------------- [6] 영화 감상평을 파일에 저장하기 ---------------------//
            System.out.print("좋아하는 영화 제목 : ");      String movieName = scan.next();           // scan 값 받기
            System.out.print("그 영화의 감상평 : ");       String movieReview = scan.next();           // scan 값 받기

            String movies = "영화 제목 : " + movieName + " 감상평 : " + movieReview;                  // 받은 거 한줄로
            String pathMovie = "src/day_16/movie_review.txt";                                   // 파일 경로 지정
            FileOutputStream fout = new FileOutputStream(pathMovie);    // 파일 생성 객체 (주소값);

            byte[] bytes = movies.getBytes();          // String 을 바이트로 변환

            fout.write(bytes);                      // 변환된 바이트 내보내기

            // ---------------------------- [7] 저장된 감상평 파일 읽기 ---------------------------//

            FileInputStream fin = new FileInputStream(pathMovie);   // 파일 가져오는 객체 (주소값);

            File file = new File(pathMovie);                    // 지정한 파일의 정보를 제공하는 객체
            byte[] bytes1 = new byte[ (int)file.length() ];     // 해당 경로의 파일의 글자수를 반환 , long 타입이라 int로 강제 타입변환 필요

            fin.read(bytes1);                                   // fin을 불러온다. byte 배열로
            String str = new String(bytes1);                    // 읽어온 바이트 배열을 문자열로 변환
            System.out.println(str);                            // 콘솔 출력

        } catch ( Exception e ) {   // 예외처리 Exception
            System.out.println(e);
        }   // catch end



        // 8. 공공데이터 CSV 파일 읽고 분석하기
        try {
            String fileCSV = "src/day_16/bupyeong_population.csv";  // 경로 문자열

            File file = new File(fileCSV);          // file 객체 생성 경로는 fileCSV
            if(file.exists()){                      // file의 경로에 존재한다면?
                FileInputStream fin = new FileInputStream( fileCSV ); // FileInputStream 객체 생성 불러오는거

                byte[] bytes = new byte[(int)file.length()];    // int화 시킨 length를 byte[] 에 넣기

                fin.read(bytes);                                // fin을 읽어와서 저장. 바이트 배열로

                String str = new String(bytes , "EUC-KR"); // (주의: 한글 깨짐 방지를 위해 new String(bytes, "EUC-KR") 사용)

                String[] rowsData = str.split("\n"); // 문자열 배열을 만드는데 str(가져온 것)을 행으로 쪼갠 배열이다.
                for(String rows : rowsData ){
                    String[] columnsData = rows.split(","); // 반복하는 n번째 행을 열로 또 쪼개서 열 배열을 만든다.
                    System.out.println("동별: "+ columnsData[0] + ", 총인구수 : " + columnsData[1] + "명");   // 동별은 0번째 열이고 총인구수는 1번째 열이니 넣어서 알아서 배열 출력한다.
                }   // for end
            }   // if end


        } catch (Exception e) { // 예외처리 Exception
            System.out.println(e);
        }   // catch end

    }   // main end
}   // class end

