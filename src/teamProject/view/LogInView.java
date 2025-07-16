package teamProject.view;

import teamProject.controller.BookInfoController;
import teamProject.controller.BookListController;
import teamProject.controller.LendingStatusController;
import teamProject.controller.MemberController;
import teamProject.model.dto.BookInfoDto;
import teamProject.model.dto.BookListDto;
import teamProject.model.dto.LendingStatusDto;

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

    // 로그인 후 메뉴 (일반 회원)
    public void userlogin(){
        for( ; ; ) {
            System.out.println("=========== 로그인 후 메뉴 (일반회원) ===========");
            System.out.println("  1.도서등록 | 2.도서대출 | 3.도서반납 | 4.내대출현황 | 5.도서목록 | 6.로그아웃");
            System.out.println("=============================================");
            System.out.println("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 ){
                System.out.println("[경고] 해당 메뉴는 관리자만 접근 가능합니다.");
                userlogin();
            }
            else if (choose == 2 ) loanBook();
            else if (choose == 3 ) returnBook();
            else if (choose == 4 ) bookState();
            else if (choose == 5 ) bookList();
            else if (choose == 6 ) logOut();
        } // for e
    } // func e

    // 로그인 후 메뉴 (관리자 모드)
    public void adminlogin(){

        for( ; ; ) {
            System.out.println("=========== 로그인 후 메뉴 (관리자) ===========");
            System.out.println("  1.도서등록 | 2.도서대출 | 3.도서반납 | 4.내대출현황 | 5.도서목록 | 6.로그아웃");
            System.out.println("=============================================");
            System.out.println("선택 > ");
            int choose = scan.nextInt();
            if( choose == 1 ) addBook();
            else if (choose == 2 ) loanBook();
            else if (choose == 3 ) returnBook();
            else if (choose == 4 ) bookState();
            else if (choose == 5 )bookList();
            else if (choose == 6 ) logOut();
        } // for e
    } // func e


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

        boolean result = lendingStatusController.loanBook(bookLogInput);

        if (result) System.out.println("[안내] '" +  "' 도서 대출이 완료되었습니다.");
        else System.out.println("[경고] 도서 대출에 실패하였습니다. 다시 시도해주세요.");

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

        ArrayList<teamProject.model.dto.LendingStatusDto> lendingStatusDB = lendingStatusController.bookState();
        ArrayList<teamProject.model.dto.BookInfoDto> bookInfoDB = bookInfoController.bookInfoList();
        ArrayList<teamProject.model.dto.BookListDto> booklistDB = bookListController.bookList();

        int who = bookInfoController.who();


        for (int i = 0; i < lendingStatusDB.size(); i++) {
            LendingStatusDto lendingStatus = lendingStatusDB.get(i);
            int bookNo = 0;
            for (int j = 0; j < booklistDB.size(); j++) {
                BookListDto bookList = booklistDB.get(j);
                if (bookList.getBookLog() == lendingStatus.getBookLog()) {
                    bookNo = bookList.getBookNo();

                    break;
                }
            }
            BookInfoDto bookinfo2 = null;
            for (int h = 0; h < bookInfoDB.size(); h++) {
                BookInfoDto bookinfo = bookInfoDB.get(h);
                if (bookNo == bookinfo.getBookNo()) {
                    bookinfo2 = bookinfo;
                    break;
                }
            }
            if(bookinfo2 == null) continue;

            if (who == -1) {
                System.out.println("[경고] 관리자입니다");
            } else {
                System.out.println("[" + lendingStatus.getLoanLog() + "] " + bookinfo2.getBookName() + " | " + bookinfo2.getBookAuthor() + " | 대출일: " +
                        lendingStatus.getLoanDate() + " | 반납일: ");
            }
        }
    }

    // 도서목록

    public void bookList() {
        ArrayList<teamProject.model.dto.LendingStatusDto> lendingStatusDB = lendingStatusController.bookState();
        ArrayList<teamProject.model.dto.BookInfoDto> bookInfoDB = bookInfoController.bookInfoList();
        ArrayList<teamProject.model.dto.BookListDto> booklistDB = bookListController.bookList();

        // 도서 목록 출력

        for (int i = 0; i < booklistDB.size(); i++) {
            BookListDto bookList = booklistDB.get(i);
            boolean onLoan = false;          // 대출 여부 플래그
            for (int j = 0; j <= lendingStatusDB.size(); j++) {
                LendingStatusDto lendingStatus = lendingStatusDB.get(j);
                if (lendingStatus.getBookLog() == bookList.getBookLog() && lendingStatus.getDueDate() == null) {
                    onLoan = true;
                }
            }
            if (onLoan == true) {
                continue;
            }
            String bookName = "";
            String bookAuthor = "";

            for (int h = 0; h < bookInfoDB.size(); h++) {
                BookInfoDto bookInfo = bookInfoDB.get(h);
                if (bookInfo.getBookNo() == bookList.getBookNo()) {
                    bookName = bookInfo.getBookName();
                    bookAuthor = bookInfo.getBookAuthor();
                    break;
                }
            }
            System.out.println("[" + bookList.getBookLog() + "] " + bookName + " | " + bookAuthor);

        }
    }
    // 로그아웃
    public void logOut(){
        memberController.logOut();
        System.out.println("[안내] 로그아웃 되었습니다.");
        LogOutView.getInstance().index();
    } // func e

}

