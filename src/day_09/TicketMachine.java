package day_09; // package

public class TicketMachine {    // class TicketMachine start
    static int totalTickets = 0;    // static totalTickets

    void issueTicket(){ // issueTicket 메소드
        totalTickets++; // 메소드 실행시 ++
        System.out.println("티켓 1장을 발권했습니다.");   // 티켓 1장 발권했습니다 출력
    }   // func end

    static void printTotalTickets(){    // static printTotalTickets 총 티켓 발권 메소드
        System.out.println(totalTickets);   //  System.out.println(totalTickets);
    }   // func end
}   // class TicketMachine end
