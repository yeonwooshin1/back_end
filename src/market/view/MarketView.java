package market.view;    // package

import market.controller.InquiryController;
import market.controller.ProductController;
import market.model.dto.InquiryDto;
import market.model.dto.ProductDto;
import market.model.dto.RankingDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MarketView {   // class start
    // 싱글톤 생성
    private MarketView(){}
    private static final MarketView view = new MarketView();
    public static MarketView getInstance() {
        return view;
    }

    // 싱글톤 import
    ProductController productController = ProductController.getInstance();
    InquiryController inquiryController = InquiryController.getInstance();

    // Scanner
    Scanner scan = new Scanner(System.in);

    // 메인 view
    public void index () {
        for (;;) {
            System.out.println("======================== 편한 중고 물품 거래 뚝딱 마켓 ========================");
            System.out.println(" 1. 중고 물품 등록   | 2. 전체 물품 목록 조회 | 3. 물품 정보 수정 | 4. 등록 물품 삭제 ");
            System.out.println(" 5. 익명 문의 남기기 | 6. 물품 상세 조회      | 7. 등록 랭킹 조회 | 8. 검색 조회     ");
            System.out.println("===========================================================================");
            System.out.print("선택 > ");
            try {
                int choose = scan.nextInt();

                if (choose == 1) productAdd();
                else if (choose == 2) productPrint();
                else if (choose == 3) productUpdate();
                else if (choose == 4) productDelete();
                else if (choose == 5) inquiryAdd ();
                else if (choose == 6) productDetails();
                else if (choose == 7) rankingPrint();
                else if (choose == 8) productSearch();
                else System.out.println("[경고] 메뉴에 없는 선택입니다. ");
            } catch (InputMismatchException e) {
                System.out.println("[경고] 숫자만 입력하세요.");
                scan.nextLine();
            }   // catch end
        }   // for end
    }   // func end



    // 중고 물품 등록 view
    public void productAdd() {
        System.out.println("=================== 물품 등록 ===================");
        String pSellerInput; String pNameInput; String pContentInput;
        int pPriceInput; String pPasswordInput;
        while ( true ) {
            try {
                scan.nextLine();
                System.out.print("판매자 닉네임 : "); pSellerInput = scan.nextLine();
                System.out.print("물품명 : ");       pNameInput = scan.nextLine();
                System.out.print("설명 : ");         pContentInput = scan.nextLine();
                System.out.print("가격 : ");         pPriceInput = scan.nextInt();
                System.out.print("비밀번호 : ");       pPasswordInput = scan.next();
                if(pPriceInput > 0) break;
                else System.out.println("[경고] 1원 이상 입력해주세요.");
            } catch (InputMismatchException e) {
                System.out.println("[경고] 숫자 입력칸입니다. 다시 입력해주세요.");
                scan.nextLine();
            }   // catch end
        }   // while end
        System.out.println("===============================================");

        boolean result = productController.productAdd(pSellerInput , pNameInput , pContentInput , pPriceInput , pPasswordInput );

        if (result) System.out.println("[안내] 물품 등록이 완료 되었습니다.");
        else System.out.println("[경고] 물품 등록에 실패하였습니다.");
    }   // func end

    // 전체 물품 목록 조회 view
    public void productPrint() {
        System.out.println("======================================= 전체 물품 목록 ========================================");
        System.out.printf("%-5s %-20s %-10s %-12s %-20s %-8s%n",
                "No", "물품명", "가격", "닉네임", "등록일", "판매여부");   // gpt야 너밖에 없다,,
        System.out.println("=============================================================================================");
        ArrayList<ProductDto> productDB = productController.productPrint();
        for(ProductDto index : productDB) {
            System.out.printf("%-5d %-20s %-10s %-12s %-20s %-8s%n",
                    index.getpNo(),
                    index.getpName() ,
                    String.format("%,d", index.getpPrice()) + "원",                      // String.format(가격에 콤마 찍기) -> % : 명령어의 시작
                    index.getpSeller(),                                                 // , : 천 단위 구분자        d : 정수
                    index.getpDate(),
                    productController.toStringStatus(index));   // GPT 짱
            System.out.println("----------------------------------------------------" +
                    "-----------------------------------------");
        }   // for end
    }   // func end

    // 물품 정보 수정 view
    public void productUpdate() {
        System.out.println("================ 물품 정보 수정 ================");
        int pNoInput;      String pPasswordInput;
        while (true) {
            try {
                System.out.print("수정할 물품 번호 : ");
                pNoInput = scan.nextInt();
                System.out.print("비밀번호 입력 : ");
                pPasswordInput = scan.next();

                if (pNoInput <= 0) {System.out.println("[경고] 유효한 숫자를 입력해주세요."); continue; }

                boolean result = productController.identityCheck( pNoInput , pPasswordInput );
                if(result) break;
                else System.out.println("[경고] 비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
                System.out.println("----------------------------------------------------------------------------");
            } catch (InputMismatchException e) {
                System.out.println("[경고] 숫자 입력칸입니다. 다시 입력해주세요.");
                scan.nextLine();
            } // catch end
        }   // while end
        scan.nextLine();
        System.out.print("물품명(수정) : ");   String pNameInput = scan.nextLine();

        System.out.print("설명(수정) : ");    String pContentInput = scan.nextLine();

        int pPriceInput;
        boolean result;
        while (true) {
            try {
                System.out.print("가격(수정) : ");    pPriceInput = scan.nextInt();

                System.out.println("< 1. 판매중 2. 판매완료 >");
                System.out.print("판매 여부 수정 : ");        int pStatusInput = scan.nextInt();

                if(pPriceInput <= 0 ) {
                    System.out.println("[경고] 유효한 가격을 입력하세요.");
                    System.out.println("----------------------------------------------------------------------------"); continue;
                } else if (pStatusInput != 1 && pStatusInput != 2) {
                    System.out.println("[경고] 판매여부 선택은 1 , 2 중에만 가능합니다.");
                    System.out.println("----------------------------------------------------------------------------"); continue;
                }   // if end

                result = productController.productUpdate( pNoInput , pNameInput , pContentInput , pPriceInput , pStatusInput);
                break;
            } catch (InputMismatchException e) {
                System.out.println("[경고] 숫자 입력칸입니다. 다시 입력해주세요.");
                scan.nextLine();
            }   // catch end
        }   // while end
        if ( result ) { System.out.println("[안내] 물품 수정이 완료되었습니다.");}
        else System.out.println("[경고] 물품 수정 도중 오류가 발생했습니다.");
    }   // func end


    // 등록 물품 삭제 view
    public void productDelete() {
        System.out.println("================ 물품 정보 삭제 ================");
        int pNoInput;      String pPasswordInput;
        while (true) {
            try {
                System.out.print("삭제할 물품 번호 : ");
                pNoInput = scan.nextInt();
                System.out.print("비밀번호 입력 : ");
                pPasswordInput = scan.next();

                if (pNoInput <= 0) {System.out.println("[경고] 유효한 숫자를 입력해주세요."); continue; }

                boolean result1 = productController.identityCheck( pNoInput , pPasswordInput );
                if(!result1) {
                    System.out.println("[경고] 비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
                    System.out.println("----------------------------------------------------------------------------"); continue;
                }   // if end

                boolean result2 = productController.productDelete(pNoInput , pPasswordInput );

                if(result2) { System.out.println("[성공] 물품 삭제가 완료되었습니다."); break; }
                else System.out.println("[경고] 목록에 있는 숫자를 입력하세요.");
            } catch (InputMismatchException e) {
                System.out.println("[경고] 숫자 입력칸입니다. 다시 입력해주세요.");
                scan.nextLine();
            } // catch end
        }   // while end
    }   // func end

    // 익명 문의 남기기 view
    public void inquiryAdd () {
        System.out.println("================ 익명 문의 등록 ================");
        int pNoInput; String iNameInput; String iContentInput; String iPasswordInput;

        while ( true ) {
            try {
                System.out.print("물품번호 : "); pNoInput = scan.nextInt();
                scan.nextLine();
                System.out.print("문의자닉네임 : ");      iNameInput = scan.nextLine();
                System.out.print("문의내용 : ");         iContentInput = scan.nextLine();
                System.out.print("비밀번호 : ");         iPasswordInput = scan.next();
                if(pNoInput > 0) break;
                else System.out.println("[경고] 유효한 숫자를 입력하세요.");
            } catch (InputMismatchException e) {
                System.out.println("[경고] 숫자 입력칸입니다. 다시 입력해주세요.");
                scan.nextLine();
            }   // catch end
        }   // while end
        System.out.println("===============================================");

        boolean result = inquiryController.inquiryAdd(pNoInput, iNameInput, iContentInput, iPasswordInput);

        if (result) System.out.println("[안내] 문의가 등록되었습니다.");
        else System.out.println("[경고] 문의 등록에 실패하였습니다.");
    }   // func end

    // 물품 상세 조회 view
    public void productDetails() {
        System.out.println("============= 물품 상세 조회 =============");
        int pnoInput;
        ProductDto productDB;
        while ( true ) {
            try {
                System.out.print("조회할 물품 번호 : ");  pnoInput = scan.nextInt();
                if (pnoInput <= 0 ) {
                    System.out.println("[경고] 유효한 숫자를 입력하세요.");
                    continue;
                }   // if end
                productDB = productController.productDetails( pnoInput );
                if( productDB == null ) {
                    System.out.println("[경고] 해당 번호가 없습니다. 다시 입력해주세요.");
                    continue;
                }   // if end
                break;
            } catch (InputMismatchException e) {
                System.out.println("[경고] 목록에 있는 숫자를 입력하세요.");
                scan.nextLine();
            }   // catch end
        }   // while end

        System.out.println("=====================================");
        System.out.println("물품명 : " + productDB.getpName());
        System.out.println("설명 : " + productDB.getpContent());
        System.out.println("가격 : " + String.format("%,d", productDB.getpPrice()) + "원");    // String.format() "%" -> 포멧 시작 명령어   "," -> 천 단위 콤마  "d" -> 정수타입
        System.out.println("닉네임 : " + productDB.getpSeller());
        System.out.println("등록일 : " + productDB.getpDate());
        System.out.println("판매여부 : " + productController.toStringStatus(productDB));

        ArrayList<InquiryDto> inquiryDB = inquiryController.inquiryDetails( pnoInput );

        System.out.println("============= 익명 문의 목록 =============");

        if (inquiryDB.isEmpty()) System.out.println("[안내] 문의가 없습니다.");
        else {
            for( int i = 1; i <= inquiryDB.size(); i++ ) {
                InquiryDto index = inquiryDB.get(i -1);
                System.out.println("["+i+"]");
                System.out.println("닉네임 : " + index.getiName() );
                System.out.println("문의내용 : " + index.getiContent() );
                System.out.println("-----------------------------------------");
            }   // for end
        }   // if end
    }   // func end

    // 등록 랭킹 조회 view
    public void rankingPrint() {
        System.out.println("============= 등록 랭킹 =============");
        System.out.printf("%-4s %-15s %-6s%n", "순위", "닉네임", "등록수"); // gpt야 고맙다...
        System.out.println("===================================");
        ArrayList<RankingDto> rankingDB = productController.rankingPrint();
        if (rankingDB.isEmpty()) {
            System.out.println("[안내] 게시물이 없어요! 먼저 게시물을 달면 당신이 1등!");
        } else {
            for( int i = 1; i <= rankingDB.size(); i++ ) {
                RankingDto index = rankingDB.get(i -1);
                System.out.printf("%-4s %-15s %-6s%n", i + "등", index.getpSeller() , index.getCount() + "개"); // gpt 고맙다,,
                System.out.println("===================================");
            }   // for end
        }   // if end
    }   // func end

    // 검색 조회 view
    public void productSearch() {
        System.out.println("================= 검색창 ================");
        System.out.println("< 1. 물품명 2. 설명 3. 닉네임 4. 가격 >");
        String chooseValue;
        int no;
        while (true) {
            try {
                System.out.print("검색 대상 선택  : ");  no = scan.nextInt();
                if(no == 1) chooseValue = "물품명";  else if(no == 2) chooseValue = "설명";
                else if(no == 3) chooseValue = "닉네임"; else if(no == 4) chooseValue = "가격";
                else { System.out.println("[경고] 보기의 항목 중에 선택하세요. (4개 항목)"); continue; }

                break;
            } catch (InputMismatchException e) {
                System.out.println("[경고] 숫자 입력칸입니다. 다시 입력해주세요.");
                scan.nextLine();
            }   // catch end
        }   // while end

        scan.nextLine();
        System.out.println("<-- "+chooseValue+"에서 검색 -->" );

        if (no == 4) System.out.println("[정보] 검색한 가격 이하만 조회합니다.");

        System.out.print("검색 : "); String search = scan.nextLine();
        System.out.println("------------------------------------------------------------");

        ArrayList<ProductDto> productDB = productController.productSearch( no , search );
        if(productDB.isEmpty()) {
            System.out.println("[안내] 검색 결과가 없습니다.");
        } else {
            for ( int i = 1; i <= productDB.size(); i++ ) {
                ProductDto index = productDB.get( i -1 );

                System.out.println(i+".");
                System.out.println("물품명 : " + index.getpName());
                System.out.println("설명 : " + index.getpContent());
                System.out.println("가격 : " + String.format("%,d", index.getpPrice()) + "원");    // String.format() "%" -> 포멧 시작 명령어   "," -> 천 단위 콤마  "d" -> 정수타입
                System.out.println("닉네임 : " + index.getpSeller());
                System.out.println("등록일 : " + index.getpDate());
                System.out.println("판매여부 : " + productController.toStringStatus(index));
                System.out.println("-----------------------------------------------------------------");
            }   // for end
        } // if end
    }   // func end
}   // class end

