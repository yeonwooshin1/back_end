package project.model.dao;

import project.model.dto.LendingStatusDto;

import java.util.ArrayList;

public class LendingStatusDao {
    // 싱글톤 만들기
    private LendingStatusDao(){}
    private static final LendingStatusDao lendingStatusDao = new LendingStatusDao();
    public static LendingStatusDao getInstance(){
        return lendingStatusDao;
    }

    // lendingStatusDB 객체 생성
    private ArrayList<LendingStatusDto> lendingStatusDB = new ArrayList<>();
}
