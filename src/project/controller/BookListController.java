package project.controller;

public class BookListController {

    // 싱글톤 만들기
    private BookListController(){}
    private static final BookListController bookListController = new BookListController();
    public static BookListController getInstance(){
        return bookListController;
    }



}
