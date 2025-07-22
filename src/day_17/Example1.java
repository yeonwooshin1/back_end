package day_17; // package

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.List;

public class Example1 { // class start
    public static void main(String[] args) {    // main start

        // OpenCSV 라이브러리 -> 목적 : CSV 규칙에 따른 자동 분해/분리
        // 각종 자바 관련 라이브러리 공유 : https://mvnrepository.com/
        // (1) OpenCSV : https://mvnrepository.com/artifact/net.sf.opencsv/opencsv/2.3
        // (2) [JAR] 다운로드 버튼 클릭
        // (3) 해당 패키지로 넣기
        // (4) 현재 프로젝트에 지정한 라이브버리 등록
        // 해당 .JAR 파일을 오른쪽 클릭 --> 가장 하단 [라이브러리 추가]

        // * OPENCSV 라이브러리 사용해보기
            // 1. new CSVReader( new FileReader( 파일 경로 ) ) : CSV 읽어오는 클래스
                // --> .readAll() : 데이터를 list<String[]> 타입으로 반환 하는 함수

            // 2. new CSVWriter( new FileWriter( 파일 경로 ) ) : CSV 출력하는 클래스
                // --> .writeAll( List객체 ) : list 객체를 CSV 로 내보내는 함수

        try {   // 예외처리
            // 1. 파일 경로 지정
            String path = "src/day_17/부평구_맛있는 집.csv";
            // 2. 파일 읽기모드 객체 생성 , 예외처리 , 한글 인코딩( 번역 ) : "EUC-KR" 또는 "UTF-8"
            FileReader fileReader = new FileReader( path , Charset.forName("EUC-KR"));
            // 3. CSVReader 클래스 이용한 file 읽어오기
            CSVReader csvReader = new CSVReader(fileReader);
            // 4. .readAll() : List<String[]> 반환
            List< String[] > inData = csvReader.readAll();
                // List 인터페이스 타입 : ArrayList는 구현체
            System.out.println( inData );
            // 5. 반복문을 이용한 순회
            for(String[] index : inData) {
                System.out.println("업소명 : " + index[0] + " , 지정메뉴 : " + index[1] );
            }   // for end

        } catch (Exception e) {
            System.out.println(e);  // 예외처리 Exception
        }   // catch end

    }   // main end
}   // class end
