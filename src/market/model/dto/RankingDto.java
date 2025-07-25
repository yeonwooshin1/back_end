package market.model.dto;   // package

public class RankingDto {   // class start
    // 멤버변수
    private String pSeller;     // 판매자 이름
    private int count;          // 판매글 count

    // 생성자
    public RankingDto(){}

    public RankingDto(String pSeller, int count) {
        this.pSeller = pSeller;
        this.count = count;
    }

    // setter getter

    public String getpSeller() {
        return pSeller;
    }

    public void setpSeller(String pSeller) {
        this.pSeller = pSeller;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // toString
    @Override
    public String toString() {
        return "RankingDto{" +
                "pSeller='" + pSeller + '\'' +
                ", count=" + count +
                '}';
    }
}   // class end
