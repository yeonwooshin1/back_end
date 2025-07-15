package project.view;

import java.util.Scanner;

public class LogInView {

    // 싱글톤 가져오기

    private LogInView(){}
    private static final LogInView LogInView = new LogInView();
    public static LogInView getInstance(){
        return LogInView;
    }

    // Scanner
    Scanner scan = new Scanner(System.in);

    // 출력 부분

    public void index(){
        for( ; ; ){
            System.out.println("=========== 도서관리 시스템  ===========");
            System.out.println("1.회원가입 | 2.로그인");
            System.out.println("======================================");

        }
    }





}
