package day_02;

public class 실습1 {
    public static void main(String[] args) {
        // 문제1
        System.out.println(25);
        System.out.println("홍길동");

        // 문제2
        //int age = 23;
        //System.out.println(age);

        //문제3
        String name = "신연우";
        int age = 23;
        double height = 177.5;
        String motto = "피곤하게 살자";

        //문제4
        System.out.println("제 이름은" + name + ", 나이는 " + age + "세, 키는 " +height+"cm 입니다.");

        // 문제5
        System.out.printf("제 이름은 %s, 나이는 %d 세, 키는 %3.1f cm입니다.", name , age , height);
        System.out.println();

        //문제 6
        System.out.println("|\\_/|\n|q p|\t/}\n( 0 )\"\"\"\\\n|\"^\"`\t|\n||_=/\\\\__|");

        //문제7
        int num = 1;    // 정수 1 를 저장하고 있는 int 타입 'num' 변수 선언
        String writer = "유재석"; // 문자열 "유재석" 를 저장하고 있는 String타입 'writer' 변수 선언
        String content = "안녕하세요!"; // 문자열 "안녕하세요!"를 저장하고 있는 String타입 'content' 변수 선언

        System.out.printf("========== 방문록 ==========\n");
        System.out.printf("%-5s \t %-5s \t %-10s \n", "번호" , "작성자", "방문록");
        System.out.printf("%-6d \t %-5s \t %-10s \n", num , writer , content);
        System.out.printf("===========================\n");
    }
}
