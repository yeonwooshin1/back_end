package day_06; // pakage

import java.util.Scanner;

public class 실습7 {  // class start

    public static void main(String[] args) {    // main start

        // 1.
        Book book1 = new Book();
        book1.title = "이것이 자바다";     book1.author = "신용권";  book1.price = 30000;
        Book book2 = new Book();
        book2.title = "자바의 정석";    book2.author = "남궁성";  book2.price = 28000;
        System.out.println( book1.title + book1.author + book1.price );
        System.out.println( book2.title + book2.author + book2.price );

        // 2.

        Pet pet1 = new Pet();
        pet1.name = "초코";   pet1.species = "푸들";    pet1.age = 3;
        Pet pet2 = new Pet();
        pet2.name = "나비";   pet2.species = "코리안숏헤어";    pet2.age = 5;
        System.out.println("이름 : " +pet1.name + ", 종류 : " +pet1.species +", 나이 : " + pet1.age +"살");
        System.out.println("이름 : " +pet2.name + ", 종류 : " +pet2.species +", 나이 : " + pet2.age +"살");

        // 3.

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;   rectangle.height = 5;
        System.out.println("넓이 : " + rectangle.width * rectangle.height);

        // 4.

        BankAccount bank = new BankAccount();
        bank.accountNumber = "111-222-3333";    bank.ownerName = "유재석";     bank.balance = 10000;
        bank.balance += 5000;
        System.out.println("입금 후 잔액 : " + bank.balance);
        bank.balance -= 3000;
        System.out.println("출금 후 잔액 : " + bank.balance);

        // 5.

        Product product1 = new Product();
        product1.name = "새우깡";   product1.price = 1500;
        Product product2 = new Product();
        product2.name = "콜라";   product2.price = 2000;

        if(product1.price > product2.price){
            System.out.println(product1.name);
        }else {
            System.out.println(product2.name);
        }
        System.out.println();

        // 6.

        Member member = new Member();
        member.id = "admin";    member.isLogin = false;
        System.out.println("로그인 전 상태 : " + member.isLogin);
        member.isLogin = true;
        System.out.println("로그인 후 상태 : " + member.isLogin);

        // 7.

        Television television = new Television();
        television.channel = 7; television.volume = 20;
        television.channel = 11;    television.volume -= 2;
        System.out.println(television.channel + "\t" + television.volume);

        // 8.

        Player player1 = new Player();
        player1.name = "손흥민";   player1.speed = 90;     player1.power = 95;
        Player player2 = new Player();
        player2.name = "이강인";   player2.speed = 85;     player2.power = 92;
        if((player1.speed + player1.power) > (player2.speed + player2.power)){
            System.out.println(player1.name);
        }else {
            System.out.println(player2.name);
        }

        // 9.

        MenuItem menuItem1 = new MenuItem();
        menuItem1.name = "김치찌개";    menuItem1.price = 8000; menuItem1.isSignature = true;

        MenuItem menuItem2 = new MenuItem();
        menuItem2.name = "된장찌개";    menuItem2.price = 8000; menuItem2.isSignature = false;

        MenuItem menuItem3 = new MenuItem();
        menuItem3.name = "계란찜";    menuItem3.price = 3000; menuItem3.isSignature = false;
        if(menuItem1.isSignature){
            System.out.println("대표메뉴  " + menuItem1.name +" : "+ menuItem1.price + "원");
        }
        if(menuItem2.isSignature){
            System.out.println("대표메뉴  " + menuItem2.name +" : "+ menuItem2.price + "원");
        }
        if(menuItem3.isSignature){
            System.out.println("대표메뉴  " + menuItem3.name +" : "+ menuItem3.price + "원");
        }

        // 10.

        UserProfile userProfile = new UserProfile();
        Scanner scan = new Scanner(System.in);
        System.out.print("이름 : ");      String nameInput = scan.next();
        System.out.print("나이 : ");      int ageInput = scan.nextInt();
        System.out.print("MBTI : ");     String mbtiInput = scan.next();

        userProfile.name = nameInput;   userProfile.age = ageInput; userProfile.mbti = mbtiInput;
        System.out.println("--- 프로필 ---");
        System.out.println("이름: "+ userProfile.name + ", 나이: "+ userProfile.age + ", MBTI: " + userProfile.mbti);






    }   // main end


} // class end
    // 한 파일에 클래스가 많으면 실무에서 유지보수 어려움
class Book {
    String title;
    String author;
    int price;
}
class Rectangle{
    int width;
    int height;
}
class BankAccount{
    String accountNumber;
    String ownerName;
    int balance;
}
class Product{
    String name ;
    int price;
}

class Member {
    String id;
    boolean isLogin;
}
class Television{
    int channel;
    int volume;
}
class Player{
    String name;
    int power;
    int speed;
}
class MenuItem{
    String name;
    int price;
    boolean isSignature;
}
class UserProfile{
    String name;
    int age;
    String mbti;
}