package project.controller;

import project.model.dao.MemberDao;
import project.model.dto.MemberDto;

import java.util.HashMap;

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

    // 싱글톤 가져오기
    MemberDao memberDao = MemberDao.getInstance();

    // 메소드 - 회원가입
    public int signup( String memberId , String memberPwd , String memberName ,String memberTel ){

        return memberDao.signup( memberId , memberPwd , memberTel , memberName );

    }   // func end

    // 메소드 - 로그인
    public HashMap<String, Object> login (String memberId , String memberPwd ){

        HashMap<String, Object> map = memberDao.getUserInfo (memberId, memberPwd );

        logInMno = (int) map.get("memberNo");
        return map;
    }
    // 메소드 로그아웃
    public void logOut(){
        logInMno = 0;
    }


}   // class MemberController end
