package market.controller;  // package

import market.model.dao.InquiryDao;
import market.model.dto.InquiryDto;

import java.util.ArrayList;

public class InquiryController {    // class start
    // 싱글톤 생성
    private InquiryController(){}
    private static final InquiryController inquiryController = new InquiryController();
    public static InquiryController getInstance() {
        return inquiryController;
    }

    // 싱글톤 import
    InquiryDao dao = InquiryDao.getInstance();

    // 메소드

    // 익명 문의 남기기
    public boolean inquiryAdd (int pNoInput, String iNameInput, String iContentInput, String iPasswordInput) {
        InquiryDto dto = new InquiryDto(pNoInput , iNameInput , iContentInput , iPasswordInput );

        return dao.inquiryAdd(dto);
    }   // func endD

    // 익명 db 가져오기
    public ArrayList<InquiryDto> inquiryDetails( int pnoInput ) {
        return dao.inquiryDetails(pnoInput);
    }   // func end

}   // class end
