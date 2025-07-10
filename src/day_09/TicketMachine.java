package day_09; // package

public class TicketMachine {    // class TicketMachine start
    static int totalTickets = 0;

    void issueTicket(){
        totalTickets++;
        System.out.println("티켓 1장을 발권했습니다.");
    }

    static void printTotalTickets(){
        System.out.println(totalTickets);
    }   //
}   // class TicketMachine end
