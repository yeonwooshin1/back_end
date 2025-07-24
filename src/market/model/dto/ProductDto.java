package market.model.dto;   // package

public class ProductDto {   // class start
    // 멤버변수
    private int pNo;
    private String pSeller;
    private String pName;
    private String pContent;
    private int pPrice;
    private String pPassword;
    private String pDate;
    private int pStatus;

    // 생성자
    public ProductDto(){}

    public ProductDto(String pSeller, String pName, String pContent, int pPrice, String pPassword) {
        this.pSeller = pSeller;
        this.pName = pName;
        this.pContent = pContent;
        this.pPrice = pPrice;
        this.pPassword = pPassword;
    }

    public ProductDto( int pNo, String pName, String pContent, int pPrice , int pStatus) {
        this.pName = pName;
        this.pNo = pNo;
        this.pContent = pContent;
        this.pPrice = pPrice;
        this.pStatus = pStatus;
    }

    public ProductDto(int pNo, String pPassword) {
        this.pNo = pNo;
        this.pPassword = pPassword;
    }

    // setter getter

    public int getpNo() {
        return pNo;
    }

    public void setpNo(int pNo) {
        this.pNo = pNo;
    }

    public String getpSeller() {
        return pSeller;
    }

    public void setpSeller(String pSeller) {
        this.pSeller = pSeller;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpContent() {
        return pContent;
    }

    public void setpContent(String pContent) {
        this.pContent = pContent;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public String getpPassword() {
        return pPassword;
    }

    public void setpPassword(String pPassword) {
        this.pPassword = pPassword;
    }

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public int getpStatus() {
        return pStatus;
    }

    public void setpStatus(int pStatus) {
        this.pStatus = pStatus;
    }

    // toString
    @Override
    public String toString() {
        return "ProductDto{" +
                "pNo=" + pNo +
                ", pSeller='" + pSeller + '\'' +
                ", pName='" + pName + '\'' +
                ", pContent='" + pContent + '\'' +
                ", pPrice=" + pPrice +
                ", pPassword='" + pPassword + '\'' +
                ", pDate='" + pDate + '\'' +
                ", pStatus=" + pStatus +
                '}';
    }
}   // class end
