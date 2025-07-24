package market.model.dto;   // package

public class InquiryDto {   // class start
    // 멤버변수
    private int pNo;

    private int iNo;
    private String iName;
    private String iContent;
    private String iPassword;
    private String iDate;

    // 생성자

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
