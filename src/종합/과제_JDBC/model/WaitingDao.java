package 종합.과제_JDBC.model;   // package


import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WaitingDao {   // class start
    // 싱글톤 만들기
    private WaitingDao(){}
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

        // 반환값 true;
        return true;
    }   // func end

    // 리스트 반환 메소드
    public ArrayList<WaitingDto> listPrint () {
        return waitingDB;
    }   // func end



}   // class end
