package project.view;

import java.util.Scanner;

public class LogOutView {

    // 싱글톤 만들기
    private LogOutView(){}
    private static final LogOutView LogOutView = new LogOutView();
    public static LogOutView getInstance(){
        return LogOutView;
    }

    // Scanner
    Scanner scan = new Scanner(System.in);

    // 로그인 화면 view

    public void index(){
        for( ; ; ){
            System.out.println("=========== 도서관리 시스템  ===========");
            System.out.println("1.회원가입 | 2.로그인");
            System.out.println("======================================");
            int choose = scan.nextInt();
            if(choose == 1) signup();
            else if(choose == 2) login();
            else System.out.println("[경고] 다시 선택해주십시오");

        }
    }

    // 회원가입

    public void signup(){

    }

    // 로그인

    public void login(){

    }

}
