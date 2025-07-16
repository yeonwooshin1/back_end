package project.model.dao;

import project.model.dto.MemberDto;

import java.util.ArrayList;

public class MemberDao {

    // logInMno 변수생성
    private int logInMno; ;

    public int getLogInMno() {
        return logInMno;
    }

    public void setLogInMno(int logInMno) {
        this.logInMno = logInMno;
    }

    // 싱글톤
    private MemberDao(){}
    private static final MemberDao memberDao = new MemberDao();
    public static MemberDao getInstance(){
        return memberDao;
    }

    // 여러개의 memberDB 객체 생성
    private ArrayList<MemberDto> memberDB = new ArrayList<>();
    // new ArrayList<>() : ArrayList 객체를 새로 만든다는 의미
    // 여러개 데이터를 저장할 수 있고 , 필요하면 크기를 자동으로 늘려주는 동적 배열 객체
    // memeberDB는? : 변수명
    // ArrayList<MemberDto> : memberDB의 타입
    // ArrayList 안에 저장할 데이터가 MemberDto 타입의 객체들임을 뜻함
    // MemberDto : 회원 한명 한명의 정보가 담긴 객체의 클래스명


    // 중복 Id 확인 메소드
    private boolean isDuplicateId(String memberId){
        for( MemberDto m : memberDB ){
            // memberDB의 모든 회원 꺼내서 m에 넣고 반복 실행
            if( m.getMemberId().equals(memberId)) return true;
            // 만약 memberDB의 memberId가 입력받은 memberId랑 같으면 실행
        } // for e
        return false;
    } // func e

    // 회원 등록 메소드 // 아이디 , 비번, 전화번호 , 이름을 매개로 갖는
    public int insertMember(String memberId , String memberPwd , String memberTel , String memberName){
        if(isDuplicateId(memberId)) return -1; // 아이디 중복 : 실패!!
        // 중복 id 메소드 실행 해서 중복된 id 존재하면 바로 메소드 종료 , -1 반환

        int newMno = ++logInMno; // 자동번호 증가 저장
        MemberDto member = new MemberDto( newMno , memberId , memberPwd , memberTel , memberName );
        // 입력받은 값들과 , newMno로 구성된 새로운 회원 객체인 member 생성
        memberDB.add(member);
        // 그 회원을 ArrayList 타입 객체인 memberDB에 저장
        return newMno; // 등록 성공 // 새로운 회원번호 반환
    } // func e

    // 회원 찾는 메소드 // 반환 타입 MemberDto 객체 , 찾은 회원정보 없으면  null 반환
    public MemberDto findMember(String memberId , String memberPwd ){
        for(MemberDto m : memberDB ){
            // memberDB의 모든 회원 꺼내서 m 에 넣고 반복 실행
            if( m.getMemberId().equals(memberId) && m.getMemberPwd().equals(memberPwd)){
                // 입력받은 아이디 , 비번가 저장된 회원의 아이디와 비번 모두 같으면
                logInMno = m.getMemberNo(); // 로그인한 회원번호 static 변수에 저장 , 다른 곳에서 로그인한 회원 번호 참조가능.
                return m; // 조건 맞는 , 일치한 유저 찾으면 그 회원 객체 반환
            }
        }
        return null; // 일치하는 유저 객체 없으면 null
    }

    // 전체 데이터 반환 메소드
    public ArrayList<MemberDto> getAll(){
        return memberDB;
    } // func e


} // class e