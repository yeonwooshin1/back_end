package projectYeonwoo.model.dao;

import projectYeonwoo.model.dto.MemberDto;

import java.util.ArrayList;
import java.util.HashMap;

public class MemberDao {

    // 싱글톤 만들기
    private MemberDao(){}
    private static final MemberDao memberDao = new MemberDao();
    public static MemberDao getInstance(){
        return memberDao;
    }

    // memberDB 객체 생성
    private ArrayList<MemberDto> memberDB = new ArrayList<>();

    // memberNo 추가
    int count;

    // 메소드

    // 배열에 객체 넣기

    public int signup( String memberId , String memberPwd , String memberTel , String memberName ){
        int result = 3; // 실패

        MemberDto memberDto = new MemberDto( memberId , memberPwd , memberTel , memberName );
        count++;              // count를 1 증가
        memberDto.setMemberNo(count);

        memberDB.add(memberDto);
        if(memberDto.getMemberId().equals("admin")) return 1;
        return 2;
    }   // func end

    // 로그인

    public HashMap<String, Object> login(String memberId, String memberPwd) {

        // HashMap<String , Object> => String : 문자열 변수명 , Object => 모든객체
        HashMap<String, Object> map = new HashMap<>();

        int result = 3;             // 초기값 지정
        int memberNo = 0;           // 초기값 지정
        String memberName = "";     // 초기값 지정

        for( MemberDto i : memberDB){
            if(i.getMemberId().equals(memberId) && i.getMemberPwd().equals(memberPwd)){
                memberNo = i.getMemberNo();             // 일치한 회원번호 넣기
                memberName = i.getMemberName();         // 일치한 이름 넣기
                if(i.getMemberId().equals("admin")) {   // admin 이라면?
                    result = 1;                         // 관리자 result = 1
                    memberNo = -1;  // 관리자면 -1        // 관리자는 -1
                    break;
                } else {
                    result = 2;                         // 일반사용자는 result = 2
                }
                break;
            }
        }
        map.put("result", result);                      // result 라는 변수명엔 result를
        map.put("memberNo", memberNo);                  // memberNo 라는 변수명엔 memberNo를
        map.put("memberName", memberName);              // memberName 라는 변수명에는 memberName를 map에 .add
        return map;                                     // map 반환
    }



}
