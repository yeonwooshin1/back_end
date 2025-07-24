package market.model.dto;   // package

public class SearchDto {    // class start
    // 멤버변수
    private int no;
    private String search;

    // 생성자

    public SearchDto(int no, String search) {
        this.no = no;
        this.search = search;
    }

    // setter getter

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    // toString
    @Override
    public String toString() {
        return "SearchDto{" +
                "no=" + no +
                ", search='" + search + '\'' +
                '}';
    }
}   // class end
