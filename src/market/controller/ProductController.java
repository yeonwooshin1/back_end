package market.controller;  // package


import market.model.dao.ProductDao;
import market.model.dto.ProductDto;
import market.model.dto.RankingDto;
import market.model.dto.SearchDto;

import java.util.ArrayList;

public class ProductController {    // class start
    // 싱글톤 생성
    private ProductController(){}
    private static final ProductController productController = new ProductController();
    public static ProductController getInstance() {
        return productController;
    }

    // 싱글톤 import
    ProductDao dao = ProductDao.getInstance();

    // 메소드

    // 중고 물품 등록
    public boolean productAdd(String pSellerInput , String pNameInput , String pContentInput , int pPriceInput , String pPasswordInput ) {
        ProductDto dto = new ProductDto(pSellerInput , pNameInput , pContentInput , pPriceInput , pPasswordInput);

        return dao.productAdd(dto);
    } // func end

    // 전체 물품 목록 조회
    public ArrayList<ProductDto> productPrint() {
        return dao.productPrint();
    } // func end

    // 물품 정보 수정
    public boolean productUpdate( int pNoInput , String pNameInput , String pContentInput , int pPriceInput , int pStatusInput) {
        ProductDto dto = new ProductDto(pNoInput , pNameInput , pContentInput , pPriceInput , pStatusInput);

        return dao.productUpdate(dto);
    } // func end

    // 등록 물품 삭제
    public boolean productDelete( int pNoInput , String pPasswordInput ) {
        ProductDto dto = new ProductDto(pNoInput , pPasswordInput);

        return dao.productDelete(dto);
    } // func end

    // 물품 상세 조회
    public ProductDto productDetails(int pnoInput ) {
        return dao.productDetails(pnoInput);
    } // func end

    // 등록 랭킹 조회
    public ArrayList<RankingDto> rankingPrint() {
        return dao.rankingPrint();
    } // func end

    // 검색 조회
    public ArrayList<ProductDto> productSearch( int no , String search ) {
        String value;
        if ( no == 1 ) value = "pName" ;
        else if ( no == 2) value = "pContent";
        else if ( no == 3) value = "pSeller";
        else value = "pPrice";

        SearchDto dto = new SearchDto( value , search );

        return dao.productSearch(dto);
    } // func end

    // 수정삭제 권한 유효성 검사
    public boolean identityCheck( int pNoInput , String pPasswordInput ) {
        ProductDto dto = new ProductDto(pNoInput , pPasswordInput);

        return dao.identityCheck(dto);
    }

    // int 인 pStatus 를 "판매중" , "판매완료"로 바꿔주는 헬퍼 메소드
    public String toStringStatus (ProductDto dto) {
        if (dto == null) return "불러오기 오류";
        else if (dto.getpStatus() == 1) return "판매중";
        else if (dto.getpStatus() == 2) return "판매완료";
        else return "불러오기 오류";
    }   // func end

}   // class end
