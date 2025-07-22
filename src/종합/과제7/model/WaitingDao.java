package 종합.과제7.model;   // package


import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WaitingDao {   // class start
    // 싱글톤 만들기
    private WaitingDao(){
        openCSV();      // WaitingDao 생성될 때 CSV 파일 연동 함수 실행
    }
    private static final WaitingDao dao = new WaitingDao();
    public static WaitingDao getInstance(){
        return dao;
    }

    // 임시 ArrayList로 DB 만들기
    ArrayList<WaitingDto> waitingDB = new ArrayList<>();

    // 등록 메소드
    public boolean listWrite ( WaitingDto waitingDto ) {
        // 매개변수로 받은 Dto DB에 .add
        waitingDB.add(waitingDto);
        // ArrayList에 dto 넣을 때 파일 쓰는 함수 실행
        saveCSV ();
        // 반환값 true;
        return true;
    }   // func end


    // 리스트 반환 메소드
    public ArrayList<WaitingDto> listPrint () {
        return waitingDB;
    }   // func end



    // CSV 파일 경로
    private String path = "src/종합/과제7/waitingList.csv";

    // CSV 파일 연동 함수
    public void openCSV () {
        // file 객체를 생성함
        File file = new File( path );
        // file 객체의 여부 확인
        if (file.exists()) {    // 존재한다면?
            loadCSV();          // loadCSV() 실행
        } else {                // 존재하지 않는다면?
            try {
                file.createNewFile();       // 지정한 그 경로에 새로운 파일을 생성함.
            } catch (IOException e) {       // 입출력 작업 중에 발생하는 예외
                System.out.println("[경고] 입출력 작업 중 오류가 발생함.");
            }   // catch end
        }   // if end
    }   // func end


    // CSV 파일 입력 함수
    public void loadCSV () {
        try {
            // FileReader 있는 거 읽는 객체
            FileReader fileReader = new FileReader( path );
            // 그 읽은 fileReader을 다시 넣어 CSV 객체 생성
            CSVReader csvReader = new CSVReader( fileReader );
            // .readAll() : CSV 데이터를 list<String[]> 타입으로 반환 하는 함수
            List<String[]> inData = csvReader.readAll();
            // 불러온 문자열배열 반복문으로 순회
            for(String[] index : inData) {  // 향상된 for문
                // index[0] : 해당 인덱스행의 1번째 열
                // index[1] : 해당 인덱스행의 2번째 열
                String phone = index[0];
                String stCount = index[1];
                // count는 int 타입이니까  문자열으르 정수로 타입변환
                int count = Integer.parseInt(stCount);
                // dto 생성 후 생성자에 매개변수로 넣기
                WaitingDto dto = new WaitingDto( phone , count );
                // ArrayList에 dto 저장
                waitingDB.add(dto);
            } // for end
            // 안전하게 csvReader 닫기
            csvReader.close();
        // FileNotFoundException 보다 IOException 이 더 상위라서 IOException을 더 나중에 catch함
        } catch ( FileNotFoundException e) {    // 파일 불러올 때 발생하는 예외
            System.out.println("[경고] 파일을 불러오는데 실패");
        } catch ( IOException e) {              // 입출력처리 중 발생하는 예외
            System.out.println("[경고] 입출력에 오류가 발생");
        }   // catch end
    }   // func end


    // CSV 파일 출력(실제로 파일에 쓰는) 함수
    public void saveCSV () {
        try {
            // FileWriter 파일 쓰는 객체
            FileWriter fileWriter = new FileWriter( path );
            // FileWriter 객체를 이용하여 CSVWriter 객체 생성 (라이브러리)
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            // 문자열 배열인 리스트에 구현체인 ArrayList<>() 객체 대입.
            List<String[]> outData = new ArrayList<>();
            // DB 순회하면서 하나하나 outData에 넣는 걸 할 거임
            for (WaitingDto dto : waitingDB ) {  // 향상된 for문
                // 문자열 배열인 row에 전화번호랑 인원수 넣기
                // string.valueOf() : 문자열 아닌 애를 문자열로 바꿔줌.
                String[] row = { dto.getPhone() , String.valueOf(dto.getCount())};
                // outData에 row .add
                outData.add(row);
            }   // for end
            // 받은 outData들 CSV로 내보내기   * writeAll() : list 객체를 CSV 로 내보내는 함수
            csvWriter.writeAll(outData);
            // 안전하게 csvWriter 닫기
            csvWriter.close();
        } catch (IOException e) {   // 입출력처리 중 발생하는 예외
            System.out.println("[경고] 입출력에 오류가 발생");
        }   // catch end
    }   // func end
}   // class end
