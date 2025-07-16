package project.view;   // package

import project.controller.MemberController;

import java.util.Scanner;

public class LogOutView {   // class start  // 로그인 전 view

    // View 싱글톤 만들기

    private LogOutView(){}
    private static final LogOutView LogOutView = new LogOutView();
    public static LogOutView getInstance(){
        return LogOutView;
    }

    // Scanner 받아오기
    Scanner scan = new Scanner(System.in);

    // 싱글톤 가져오기
    MemberController controller = MemberController.getInstance();   // MemberController class 가져오기
    LogInView logInView = LogInView.getInstance();

    // 로그인 전 화면 view

    public void index(){
        for( ; ; ){
            System.out.println("=========== 도서관리 시스템  ===========");
            System.out.println("1.회원가입 | 2.로그인");
            System.out.println("======================================");
            int choose = scan.nextInt();

            if(choose == 1)             signup();   // 회원가입 view
            else if(choose == 2)        login();    // 로그인 view

            else System.out.println("[경고] 다시 선택해주십시오. ");
        }   // for end
    }   // index func end

    // 회원가입 view

    public void signup(){
        System.out.println("--- 회원 가입 ---");
        System.out.print("아이디 : ");       String idInput =  scan.next();
        System.out.print("비밀번호 : ");      String pwInput = scan.next();
        System.out.print("이름 : ");         String nameInput = scan.next();
        System.out.print("연락처 : ");       String telInput = scan.next();

        int result = controller.getMember(idInput , pwInput , nameInput , telInput);   // 매개변수 id , pw , name , telNumber

        if(result == 1) System.out.println("[안내] 관리자 계정이 등록되었습니다.");
        else if(result == 2) System.out.println("[안내] 회원가입이 완료되었습니다.");
        else if(result == 3) System.out.println("[실패] 회원가입에 실패하였습니다.");
        else System.out.println("[실패] 시스템 오류입니다");
    }   // choose 1 func end


    // 로그인 화면
    public void  login(){
        System.out.println("--- 로그인 ---");
        System.out.println("아이디 : ");       String memberId = scan.next();
        System.out.println("비밀번호 : ");      String memberPwd = scan.next();
        int result1 = controller.login( memberId ,memberPwd );
        if( result1 == -1 ){
            System.out.println("[안내] 관리자 로그인 성공 ");
            logInView.adminlogin();
        } else if (result1 == 2) {
            System.out.println("[안내]일반 회원 로그인 성공 ");
            logInView.userlogin();

        }else if (result1 == 3 ){
            System.out.println("[경고] 아이디와 비밀번호를 확인해주세요. ");
        }
    } // func e


}
