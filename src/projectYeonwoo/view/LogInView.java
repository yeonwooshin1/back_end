package projectYeonwoo.view;

import projectYeonwoo.controller.BookInfoController;
import projectYeonwoo.controller.BookListController;
import projectYeonwoo.controller.LendingStatusController;
import projectYeonwoo.controller.MemberController;
import projectYeonwoo.model.dto.BookInfoDto;
import projectYeonwoo.model.dto.BookListDto;
import projectYeonwoo.model.dto.LendingStatusDto;

import java.util.ArrayList;
import java.util.Scanner;

public class LogInView {

    // 싱글톤 만들기

    private LogInView() {
    }

    private static final LogInView LogInView = new LogInView();

    public static LogInView getInstance() {
        return LogInView;
    }

    // 싱글톤 가져오기


    BookInfoController bookInfoController = BookInfoController.getInstance();
    BookListController bookListController = BookListController.getInstance();
    LendingStatusController lendingStatusController = LendingStatusController.getInstance();
    MemberController memberController = MemberController.getInstance();

    // Scanner
    Scanner scan = new Scanner(System.in);

    // 출력 부분

    public void index() {
        for (; ; ) {
            System.out.println("============================= 도서관 메뉴 ==============================");
            System.out.println(" 1.도서등록 | 2.도서대출 | 3.도서반납 | 4.내대출현황 | 5.도서목록 | 6.로그아웃 ");
            System.out.println("======================================================================");

            int choose = scan.nextInt();

            if (choose == 1) addBook();
            else if (choose == 2) loanBook();
            else if (choose == 3) returnBook();
            else if (choose == 4) bookState();
            else if (choose == 5) bookList();
            else if(choose == 6)  logOut();

            else System.out.println("[경고] 다시 선택해주십시오. ");
        }   // for end
    }

    // 도서 등록

    public void addBook() {
        int who = bookInfoController.who();
        if (who == -1) {
            System.out.println("--- 도서 등록 --- ");
            System.out.print("도서명 : ");
            String bookNameInput = scan.next();
            System.out.print("저자 : ");
            String bookAuthorInput = scan.next();

            boolean result = bookInfoController.addBook(bookNameInput, bookAuthorInput);

            bookListController.addBookNo(bookInfoController.addBookNo());   // bookList에 추가하기

            if (result) System.out.println("[안내] '" + bookNameInput + "' 도서 등록이 완료되었습니다.");
            else System.out.println("[경고] 등록에 실패하였습니다. 다시 시도해주세요.");
        } else System.out.println("[경고] 해당 메뉴는 관리자만 접근 가능합니다.");

    }

    // 도서 대출

    public void loanBook() {
        System.out.println("--- 도서 대출 ---");
        System.out.print("대출할 도서 번호 : ");
        int bookLogInput = scan.nextInt();

        String bookName = null;
        ArrayList<BookInfoDto> bookInfoDB = bookInfoController.bookInfoList();
        ArrayList<BookListDto> booklistDB = bookListController.bookList();
        for (BookInfoDto info : bookInfoDB) {
            for (BookListDto list : booklistDB) {
                if (bookLogInput == list.getBookLog() && info.getBookNo() == list.getBookNo()) {
                    bookName = info.getBookName();
                    break;
                }
            }
            break;
        }
        if(bookName == null){
            System.out.println("[경고] 해당 도서 번호가 존재하지 않습니다.");
            return;
        }

        boolean result = lendingStatusController.loanBook(bookLogInput);

        if (result) System.out.println("[안내] '" + bookName + "' 도서 대출이 완료되었습니다.");
        else System.out.println("[경고] 도서 대출에 실패하였습니다. 다시 시도해주세요.");
    }


    // 도서 반납

    public void returnBook() {
        System.out.println("--- 도서 반납 ---");
        System.out.print("반납할 도서 번호 : ");
        int bookLogInput = scan.nextInt();

        String bookName = null;
        ArrayList<BookInfoDto> bookInfoDB = bookInfoController.bookInfoList();
        ArrayList<BookListDto> booklistDB = bookListController.bookList();

        for (BookInfoDto info : bookInfoDB) {
            for (BookListDto list : booklistDB) {
                if (info.getBookNo() == list.getBookNo()) {
                    bookName = info.getBookName();
                    break;
                }
            }
            break;
        }
        if(bookName == null){
            System.out.println("[경고] 해당 도서 번호가 존재하지 않습니다.");
            return;
        }

        boolean result = lendingStatusController.returnBook(bookLogInput);

        if (result) System.out.println("[안내] '" + bookName + "' 도서 반납이 완료되었습니다.");
        else System.out.println("[경고] 도서 반납에 실패하였습니다. 다시 시도해주세요.");
    }


    // 내대출현황

    public void bookState() {
        ArrayList<LendingStatusDto> lendingStatusDB = lendingStatusController.bookState();
        ArrayList<BookInfoDto> bookInfoDB = bookInfoController.bookInfoList();
        ArrayList<BookListDto> booklistDB = bookListController.bookList();

        int count = 1;
        int who = bookInfoController.who();

        for (LendingStatusDto lend : lendingStatusDB) {

            String lendPerson = null;
            int bookNo = 0;
            for (BookListDto list : booklistDB) {
                if (list.getBookLog() == lend.getBookLog()) {
                    bookNo = list.getBookNo();

                    break;                      // bookNo를 찾았으면 탈출
                }
            }
            if(bookNo == 0) continue;          // 매칭 목록이 없으면 다음 레코드

            BookInfoDto bookInfo = null;
            for (BookInfoDto info : bookInfoDB) {
                if (info.getBookNo() == bookNo) {
                    bookInfo = info;
                    break;
                }
            }
            if (bookInfo == null) continue;         // 책 정보가 없으면 건너뛰기

            //--//

            if(who == -1){
                System.out.println("[" + lend.getLoanLog() + "] " + bookInfo.getBookName() + " | " + bookInfo.getBookAuthor() + " | 대출일: " + lend.getLoanDate()
                        + " | 반납일: " + (lend.getDueDate() == null ? "미반납" : lend.getDueDate()));    // 관리자
            }

            else if (who == lend.getMemberNo() && lend.getDueDate() == null) {
                System.out.println("[" + count++ + "] " + bookInfo.getBookName() + " | " + bookInfo.getBookAuthor()
                        + " | 대출일: " + lend.getLoanDate());     // 회원
            }

        }
        if(who != -1 && count == 1) System.out.println("[안내] 현재 대출 중인 도서가 없습니다.");  // 회원이고 출력이 없었다면 없다고 말하기
    }

    // 도서목록

    public void bookList() {
        ArrayList<LendingStatusDto> lendingStatusDB = lendingStatusController.bookState();
        ArrayList<BookInfoDto> bookInfoDB = bookInfoController.bookInfoList();
        ArrayList<BookListDto> booklistDB = bookListController.bookList();

        int count = 0;

        for(BookListDto list : booklistDB){
            boolean onLoan = false;          // 대출 여부 플래그
            for (LendingStatusDto lending : lendingStatusDB){
                if(lending.getBookLog() == list.getBookLog()     // 같은 책 로그이고
                        && lending.getDueDate() == null){        // 아직 반납 안 됨
                    onLoan = true;
                    break;                                        // 더 볼 필요 없음
                }
            }
            if(onLoan) continue;          // 빌려 간 상태면 이번 책은 건너뛰기

            String bookName = "";
            String bookAuthor = "";

            for(BookInfoDto info : bookInfoDB){
                if(info.getBookNo() == list.getBookNo()){
                    bookName = info.getBookName();
                    bookAuthor = info.getBookAuthor();
                    count = 1;
                    break;
                }
            }
            System.out.println("[" + list.getBookLog() + "] " + bookName + " | " + bookAuthor);
        }
        if(count == 0) System.out.println("[안내] 도서목록이 없습니다.");
    }

    public void logOut(){
        memberController.logOut();
        System.out.println("[안내] 로그아웃 되었습니다.");
        LogOutView.getInstance().index();

    }

}

