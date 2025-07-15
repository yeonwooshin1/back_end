package project.model.dao;

import project.model.dto.MemberDto;

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

    public HashMap<String, Object> getUserInfo(String memberId, String memberPwd) {
        HashMap<String, Object> map = new HashMap<>();
        int result = 3;
        int memberNo = 0;
        String memberName = "";
        for( MemberDto i : memberDB){
            if(i.getMemberId().equals(memberId) && i.getMemberPwd().equals(memberPwd)){
                memberNo = i.getMemberNo();
                memberName = i.getMemberName();
                if(i.getMemberId().equals("admin")) {
                    result = 1;
                    memberNo = -1;  // 관리자면 -1
                    break;
                } else {
                    result = 2;
                }
                break;
            }
        }
        map.put("result", result);
        map.put("memberNo", memberNo);
        map.put("memberName", memberName);
        return map;
    }



}
