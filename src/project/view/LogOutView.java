package project.view;

import project.controller.MemberController;

import java.util.HashMap;
import java.util.Scanner;

public class LogOutView {

    // 싱글톤 만들기

    private LogOutView(){}
    private static final LogOutView LogOutView = new LogOutView();
    public static LogOutView getInstance(){
        return LogOutView;
    }

    // Scanner 받아오기
    Scanner scan = new Scanner(System.in);

    // 싱글톤 가져오기
    MemberController controller = MemberController.getInstance();   // MemberController class 가져오기


    // 로그인 화면 view

    public void index(){
        for( ; ; ){
            System.out.println("=========== 도서관리 시스템  ===========");
            System.out.println("1.회원가입 | 2.로그인");
            System.out.println("======================================");
            int choose = scan.nextInt();

            if(choose == 1)             signup();
            else if(choose == 2)        login();

            else System.out.println("[경고] 다시 선택해주십시오. ");
        }
    }

    // 회원가입 view

    public void signup(){
        System.out.println("--- 회원 가입 ---");
        System.out.print("아이디 : ");       String idInput =  scan.next();
        System.out.print("비밀번호 : ");      String pwInput = scan.next();
        System.out.print("이름 : ");         String nameInput = scan.next();
        System.out.print("연락처 : ");       String telInput = scan.next();

        int result = controller.signup(idInput , pwInput , nameInput , telInput);

        if(result == 1) System.out.println("[안내] 관리자 계정이 등록되었습니다.");
        else if(result == 2) System.out.println("[안내] 회원가입이 완료되었습니다.");
        else if(result == 3) System.out.println("[실패] 회원가입에 실패하였습니다.");
        else System.out.println("[실패] 시스템 오류입니다");
    }   // choose 1 func end

    // 로그인 view

    public void login(){
        System.out.println("--- 로그인 ---");
        System.out.print("아이디 : ");       String idInput =  scan.next();
        System.out.print("비밀번호 : ");      String pwInput = scan.next();
        HashMap<String, Object> userInfo = controller.login(idInput, pwInput);

        int result = (int) userInfo.get("result");
        String memberName = userInfo.get("memberName").toString();

        if (result == 1) {
            System.out.println("회원님은 현재 관리자 권한입니다.");
            System.out.println(memberName + "님, 환영합니다!");
            LogInView.getInstance().index();
        } else if (result == 2) {
            System.out.println("회원님은 현재 사용자 권한입니다.");
            System.out.println(memberName + "님, 환영합니다!");
            LogInView.getInstance().index();

        } else {
            System.out.println("회원 정보가 없습니다. 아이디와 비밀번호를 다시 입력해 주세요.");
        }
    }

}
