package market.model.dto;   // package

public class InquiryDto {   // class start
    // 멤버변수
    private int pNo;            // FK값 제품글 코드

    private int iNo;            // 익명 문의글 코드
    private String iName;       // 익명 문의 닉네임
    private String iContent;    // 익명 문의 글내용
    private String iPassword;   // 익명글 비밀번호
    private String iDate;       // 익명글 올린 날짜

    // 생성자
    public InquiryDto(){}

    public InquiryDto(int pNo, String iName, String iContent, String iPassword) {
        this.pNo = pNo;
        this.iName = iName;
        this.iContent = iContent;
        this.iPassword = iPassword;
    }

    // setter getter

    public int getiNo() {
        return iNo;
    }

    public void setiNo(int iNo) {
        this.iNo = iNo;
    }

    public int getpNo() {
        return pNo;
    }

    public void setpNo(int pNo) {
        this.pNo = pNo;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public String getiContent() {
        return iContent;
    }

    public void setiContent(String iContent) {
        this.iContent = iContent;
    }

    public String getiPassword() {
        return iPassword;
    }

    public void setiPassword(String iPassword) {
        this.iPassword = iPassword;
    }

    public String getiDate() {
        return iDate;
    }

    public void setiDate(String iDate) {
        this.iDate = iDate;
    }

    // toString
    @Override
    public String toString() {
        return "InquiryDto{" +
                "iNo=" + iNo +
                ", pNo=" + pNo +
                ", iName='" + iName + '\'' +
                ", iContent='" + iContent + '\'' +
                ", iPassword='" + iPassword + '\'' +
                ", iDate='" + iDate + '\'' +
                '}';
    }
}   // class end
