package project.controller;

public class MemberController { // class MemberController start
    // 멤버변수
    private static int logInMno;

    public static int getLogInMno(){
        return logInMno ;
    }

    // 싱글톤 만들기
    private MemberController(){}
    private static final MemberController memberController = new MemberController();
    public static MemberController getInstance(){
        return memberController;
    }


}   // class MemberController end
