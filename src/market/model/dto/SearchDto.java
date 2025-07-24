package market.model.dto;   // package

public class SearchDto {    // class start
    // 멤버변수
    private String value;
    private String search;

    // 생성자
    public SearchDto(){}

    public SearchDto(String value, String search) {
        this.value = value;
        this.search = search;
    }

    // setter getter

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
                "value='" + value + '\'' +
                ", search='" + search + '\'' +
                '}';
    }
}   // class end
