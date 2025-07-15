package project.view;

import project.controller.BookInfoController;
import project.controller.BookListController;
import project.controller.LendingStatusController;
import project.model.dto.BookInfoDto;
import project.model.dto.BookListDto;
import project.model.dto.LendingStatusDto;

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
                //else if(choose == 5)      bookList();
                //else if(choose == 6)      logOut();

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

            bookListController.addBookNo(bookInfoController.addBookNo());   // bookList에 추가하기

            boolean result = bookInfoController.addBook(bookNameInput, bookAuthorInput);

            if (result) System.out.println("[안내] '" + bookNameInput + "' 도서 등록이 완료되었습니다.");
            else System.out.println("[경고] 등록에 실패하였습니다. 다시 시도해주세요.");
        } else System.out.println("[경고] 해당 메뉴는 관리자만 접근 가능합니다.");

    }

    // 도서 대출

    public void loanBook() {
        System.out.println("--- 도서 대출 ---");
        System.out.print("대출할 도서 번호 : ");
        int bookLogInput = scan.nextInt();

        String bookName = "";
        ArrayList<BookInfoDto> bookInfoDB = bookInfoController.bookInfoList();
        ArrayList<BookListDto> booklistDB = bookListController.bookList();
        for (BookInfoDto info : bookInfoDB) {
            for (BookListDto list : booklistDB) {
                if (info.getBookNo() == list.getBookNo()) {
                    bookName = info.getBookName();
                    break;
                }
            }
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

        String bookName = "";
        ArrayList<BookInfoDto> bookInfoDB = bookInfoController.bookInfoList();
        ArrayList<BookListDto> booklistDB = bookListController.bookList();

        for (BookInfoDto info : bookInfoDB) {
            for (BookListDto list : booklistDB) {
                if (info.getBookNo() == list.getBookNo()) {
                    bookName = info.getBookName();
                    break;
                }
            }
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

        for (LendingStatusDto lending : lendingStatusDB) {
            for (BookListDto list : booklistDB) {
                for (BookInfoDto info : bookInfoDB)
                    if (lending.getBookLog() == list.getBookLog() && list.getBookNo() == info.getBookNo()) {
                        if (who == -1) {
                            System.out.println("[" + lending.getLoanLog() + "] " + info.getBookName() + " | " + info.getBookAuthor() + " | 대출일: " + lending.getLoanDate() + " | 반납일: " + lending.getDueDate());
                        }
                        if (who == lending.getMemberNo() && lending.getDueDate() == null) {
                            System.out.println("[" + count++ + "] " + info.getBookName() + " | " + info.getBookAuthor() + " | 대출일: " + lending.getLoanDate());
                        }
                    }
            }
        }
    }
    /*
    // 도서목록

    public void bookList(){

    }

    // 로그아웃

    public void logOut(){

    }
    */
}
