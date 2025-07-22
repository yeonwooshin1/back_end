package 종합.예제9.model.dao;   // package


import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import 종합.예제9.model.dto.BoardDto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {     // class start
    // 싱글톤 만들기
    // 싱글톤이란 ? 지정한 클래스내 하나의 객체를 미리 만들고 프로그램내 하나의 객체만 존재
    private BoardDao(){
        openCSV(); // -- 싱글톤 생성시 csv 로드
    }
    private static final BoardDao boardDao = new BoardDao();
    public static BoardDao getInstance(){
        return boardDao;
    }

    // DB 대신할 리스트 선언
    ArrayList<BoardDto> boardDB = new ArrayList<>();

    // (1) 등록
    public boolean boardWrite (BoardDto boardDto) {
        boardDB.add(boardDto);

        saveCSV();  // * CSV 저장
        return true;
    }   // func end


    // (2) 출력
    public ArrayList<BoardDto> boardPrint () {
        return boardDB;
    }   // func end



    // (*) CSV 파일 경로 지정한다.
    private String path = "src/종합/예제9/data.csv";

    // ------------------------------ 1. CSV 파일 연동 함수 ------------------------------ //
    public void openCSV (){
        File file = new File(path); // (1) 파일 객체 생성한다.
        if(file.exists()) {         // (2) 만약에 파일이 존재한다면 정보 불러오기
            loadCSV();
        } else {                    // (2) 아니면 파일 생성 .createNewFile() 지정한 경로에 파일 생성함수
            try {file.createNewFile();   // 파일 생성
            } catch (Exception e) {System.out.println(e);}  // 예외 처리
        }   // if end
    }   // func end

    // ------------------------------ 2. CSV 입력(호출) 함수 ------------------------------ //
    public void loadCSV () {
        try {
            FileReader fileReader = new FileReader( path );             // (1) FileReader 이용한 읽기모드 객체 생성
            CSVReader csvReader = new CSVReader( fileReader );          // (2) CSVReader 에 FileReader 대입하여 CSV 객체 생성
            List<String[]> inData = csvReader.readAll();                // (3) .readAll() 함수로 모든 CSV 정보를 읽어온다.
            for ( String[] row : inData ){                              // (4) 향상된 for 문을 이용한 행 순회
                String content = row[0];                                // 첫번째 열
                String writer = row[1];                                 // 두번째 열
                BoardDto boardDto = new BoardDto( content , writer );   // (5) 각 열들을 하나의 dto로 생성
                boardDB.add( boardDto );    // (6) 생성된 dto를 리스트에 저장
            }   // for end
            csvReader.close();  // (7) csvReader 안전하게 닫기 (메모리 누수 방지 )
        } catch (Exception e) { System.out.println(e); }
    }   // func end


    // ------------------------------ 3. CSV 출력(저장) 함수 ------------------------------ //
        public void saveCSV () {
            try {
                // (1) FileWriter 파일 쓰기모드 객체 생성
                FileWriter fileWriter = new FileWriter(path);
                // (2) CSVWriter에 filewriter 객체를 대입하여 생성
                CSVWriter csvWriter = new CSVWriter(fileWriter);
                // (3) 빈 리스트 생성
                List<String[]> outData = new ArrayList<>();
                // ArrayList(구현체) , List (인터페이스)
                // (4) 현재 모든 정보(boardDB)를 outData에 담아낸다.
                for (BoardDto boardDto : boardDB) {
                    // (5) dto 하나씩 내용과 작성자를 행으로 구성
                    String[] row = {boardDto.getContent(), boardDto.getWriter()};
                    // (6) outData에 저장한다.
                    outData.add(row);
                } // for end
                // (7) 최종적으로 outData를 CSV 내보내기 한다.
                csvWriter.writeAll(outData);
                csvWriter.close();  // (8) 안전하게 객체 닫기
            } catch ( Exception e ) { System.out.println(e); }   // 예외 처리
        }   // func end

}   // class end
