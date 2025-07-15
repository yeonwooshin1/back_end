package project.controller;

public class BookInfoController {
    // 싱글톤 만들기
    private BookInfoController(){}
    private static final BookInfoController bookInfoController = new BookInfoController();
    public static BookInfoController getInstance(){
        return bookInfoController;
    }

}
