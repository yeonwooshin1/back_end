package project.model.dao;

import project.model.dto.MemberDto;

import java.util.ArrayList;

public class MemberDao {
    // 싱글톤 만들기
    private MemberDao(){}
    private static final MemberDao memberDao = new MemberDao();
    public static MemberDao getInstance(){
        return memberDao;
    }

    // memberDB 객체 생성
    private ArrayList<MemberDto> memberDB = new ArrayList<>();
}
