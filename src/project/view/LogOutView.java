package project.view;

import project.controller.MemberController;

public class LogOutView {

    // 싱글톤 만들기
    private LogOutView(){}
    private static final LogOutView LogOutView = new LogOutView();
    public static LogOutView getInstance(){
        return LogOutView;
    }





}
