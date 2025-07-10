package 종합.예제6;

class Board{
    // 1. 멤버변수 : 주로 멤버변수는 private 한다.
    // * 모델링에 들어갈 속성
    private String writer;
    private String content;

    // 2. 생성자 : *관례적* 기본생성자 1개 와 전체매개변수를 갖는 생성자 1개. ( 2개 )

    // 자동 : 해당 클래스에서 오른쪽클릭 -> [생성] -> [생성자] -> 모든 멤버변수 복수선택(ctrl)후 -> 확인

    // 1) 기본생성자
    public Board(){}

    // 2) 전체 매개변수 갖는 생성자
    public Board(String writer, String content) {
        this.writer = writer;
        this.content = content;
    }

    // 3. 메소드 :

    // 1) private 으로 선언된 멤버변수를 외부로부터 접근할 수 있도록 getter/setter 지원한다.
    // 자동 : 해당 클래스에서 오른쪽클릭 -> [생성] -> [getter 및 setter] -> 모든 멤버변수 복수선택(ctrl)후 -> 확인

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // 2) 개발자가 작업하면서 객체의 주소값이 아닌 객체내 멤버변수 값 확인용 , toString() 지원한다.
    // 자동 : 해당 클래스에서 오른쪽클릭 -> [생성] -> [toString] -> 모든 멤버변수 복수선택(ctrl)후 -> 확인

    @Override
    public String toString() {
        return "Board{" +
                "writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}   // class Board end
