package 종합.예제9.model.dto;   // package

public class BoardDto {     // class start
    // 멤버변수

    private String content;     // 내용
    private String writer;      // 작성자

    // 생성자

    public BoardDto(){}

    public BoardDto(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    // setter getter toString

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}   // class end
