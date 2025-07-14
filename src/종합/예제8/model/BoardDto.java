package 종합.예제8.model;   // package

public class BoardDto { // class BoardDto start

    // 매개변수

    private String writer;
    private String content;

    // 생성자

    public BoardDto(){}

    public BoardDto(String writer, String content) {
        this.writer = writer;
        this.content = content;
    }   // 생성자

    // setter getter


    public String getWriter() { return writer; }    // getter

    public void setWriter(String writer) { this.writer = writer; }  // setter

    public String getContent() { return content; }  // getter

    public void setContent(String content) { this.content = content; }  // setter

    // toString

    @Override

    public String toString() {
        return "BoardDto{" +
                "writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}   // class BoardDto end
