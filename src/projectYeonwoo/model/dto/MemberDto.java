package projectYeonwoo.model.dto;  // package

public class MemberDto {    // class MemberDto start
    // 멤버변수
    private int memberNo;       // 회원 코드
    private String memberId;    // 회원 아이디
    private String memberPwd;   // 회원 비밀번호
    private String memberTel;   // 회원 전화번호
    private String memberName;  // 회원 이름

    // 생성자
    public MemberDto(){}

    // 회원가입 생성자
    public MemberDto(String memberId, String memberPwd, String memberTel, String memberName) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberTel = memberTel;
        this.memberName = memberName;
    }

    // 로그인 생성자

    public MemberDto(String memberPwd, String memberId) {
        this.memberPwd = memberPwd;
        this.memberId = memberId;
    }


    // setter getter


    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getMemberTel() {
        return memberTel;
    }

    public void setMemberTel(String memberTel) {
        this.memberTel = memberTel;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    // toString


    @Override
    public String toString() {
        return "MemberDto{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", memberTel='" + memberTel + '\'' +
                ", memberName='" + memberName + '\'' +
                '}';
    }

}   // class MemberDto end
