package day_09; // package

public class 실습10 { // class start
    public static void main(String[] args) {    // main start
        // 1.

        Member member = new Member();   // 객체 선언
        member.setId("admin");          // setId 메소드 값 설정 setter
        String result = member.getId(); // getId 메소드 리턴값 result에 저장 getter
        System.out.println(result);     // System.out.println(result);

        // 2.

        Score score = new Score();  // 객체 선언
        score.setScore(85);         // setScore 메소드 호출
        score.setScore(120);        // setScore 메소드 호출

        // 3.

        BankAccount bankAccount = new BankAccount("123-456");   // 생성자에 계좌번호 인수값 넣기
        String result1 = bankAccount.getAccountNumber();  // getAccountNumber 메소드 리턴값 result1 저장 getter
        System.out.println(result1);                //  System.out.println(result1);

        // 4.

        CircleCalculator calculator = new CircleCalculator();   // 객체 생성
        calculator.printCircleArea(5);  // printCircleArea : 원넓이 계산하는 메소드

        // 5.

        TicketMachine machine1 = new TicketMachine();   // 객체 생성
        TicketMachine machine2 = new TicketMachine();   // 객체 생성
        TicketMachine machine3 = new TicketMachine();   // 객체 생성

        machine1.issueTicket(); machine1.issueTicket(); machine2.issueTicket(); // 객체당 issueTicket() 메소드 실행
        TicketMachine.printTotalTickets();  // printTotalTickets() 클래스메소드 출력 -- > 3

        // 6.

        System.out.println(GameConfig.GAME_TITLE);                  // 상수 출력 static 이니 클래스명.상수
        System.out.println("HP : " + GameConfig.MAX_HP );           // 상수 출력 static 이니 클래스명.상수
        System.out.println("LEVEL : " + GameConfig.MAX_LEVEL);      // 상수 출력 static 이니 클래스명.상수

    }   // main end
}   // class end
