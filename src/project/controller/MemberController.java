package project.controller;

public class MemberController { // class MemberController start
    // 멤버변수
    private int logInMno;

    public int getLogInMno(){
        return logInMno ;
    }

    // 싱글톤 만들기
    private MemberController(){}
    private static final MemberController memberController = new MemberController();
    public static MemberController getInstance(){
        return memberController;
    }


}   // class MemberController end
