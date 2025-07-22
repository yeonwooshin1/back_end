package 종합.과제_JDBC.model;   // package

public class WaitingDto {   // class start

    // 멤버변수
    private String phone;
    private int count;

    // 생성자
    public WaitingDto(){}

    public WaitingDto(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }

    // getter setter 메소드 , toString()

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WaitingDto{" +
                "phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }

}   // class end
