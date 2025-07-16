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


    // loanLog 추가
    int count;

    // lendingStatusDB 객체 생성
    private ArrayList<LendingStatusDto> lendingStatusDB = new ArrayList<>();

    // 메소드 추가
    // 등록
    public boolean loanBook(int bookLogInput , int memberNo){

        // 도서 번호가 있는지 확인하는 유효성 검사
        for(LendingStatusDto dto : lendingStatusDB) {
            if (dto.getBookLog() == bookLogInput && dto.getDueDate() == null) {
                return false;
            }
        }
        LendingStatusDto lendingStatusDto = new LendingStatusDto(bookLogInput , memberNo);

        lendingStatusDto.setLoanLog(++count);  // count를 1 증가

        lendingStatusDB.add(lendingStatusDto);

        return true;
    }

    // 반납
    public boolean returnBook(int bookLogInput , int memberNo ){
        boolean result = false;
        // 도서 번호가 있는지 확인하는 유효성 검사
        for(LendingStatusDto dto : lendingStatusDB){
            if (dto.getBookLog() == bookLogInput && dto.getMemberNo() == memberNo && dto.getDueDate() == null) {
                // bookValue는 그냥 반납인지 대출인지 확인용

                dto.setDueDate();   // ★ 새 객체 만들 필요 없음
                return true;
            }  // if end
        }
        return result;
    }

    // 배열 리턴
    public ArrayList<LendingStatusDto> bookState(){
        return lendingStatusDB;
    }

}
