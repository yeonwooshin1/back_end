package day_08; // package

import java.util.Scanner;

public class 실습9 {  // class start

    public static void main(String[] args) {    // main start

        // 1.

        Book book1 = new Book("이것이 자바다", "신용권", 30000);
        Book book2 = new Book("자바의 정석","남궁성" ,28000);
        System.out.println( book1.title + book1.author + book1.price );
        System.out.println( book2.title + book2.author + book2.price );

        // 2.

        Pet pet1 = new Pet("초코","푸들", 3);
        Pet pet2 = new Pet("나비","코리안숏헤어",  5);
        System.out.println("이름 : " +pet1.name + ", 종류 : " +pet1.species +", 나이 : " + pet1.age +"살");
        System.out.println("이름 : " +pet2.name + ", 종류 : " +pet2.species +", 나이 : " + pet2.age +"살");

        // 3.

        Rectangle rectangle = new Rectangle(10, 5 );
        int result = rectangle.getArea();
        System.out.println(result);

        // 4.

        BankAccount bank = new BankAccount( "111-222-3333" ,"유재석" ,10000 );
        bank.deposit(5000);         int result2 = bank.withdraw(3000);
        System.out.println(result2);

        // 5.

        Goods goods1 = new Goods();
        System.out.println("제품명 : " + goods1.name+ " 가격 : " + goods1.price+ "원");
        Goods goods2 = new Goods("콜라", 2000);
        System.out.println("제품명 : " + goods2.name+ " 가격 : " + goods2.price + "원");

        // 6.

        Member member = new Member();
        System.out.println( member.id +member.isLogin);

        // 7.

        Television television = new Television( 7 ,20);
        System.out.println(television.channel + "\t" + television.volume);

        // 8.

        Player player1 = new Player("손흥민" ,90 , 95);
        Player player2 = new Player("이강인" , 85 , 92);
        System.out.println(player1.name + player1.speed + player1.power);
        System.out.println(player2.name + player2.speed + player2.power);

        // 9.

        MenuItem menuItem = new MenuItem("김치찌개" , 8000 , true);
        if(menuItem.isSignature){
            System.out.println("대표메뉴  " + menuItem.name +" : "+ menuItem.price + "원");
        }

        // 10.

        Scanner scan = new Scanner(System.in);
        System.out.print("이름 : ");      String nameInput = scan.next();
        System.out.print("나이 : ");      int ageInput = scan.nextInt();
        System.out.print("MBTI : ");     String mbtiInput = scan.next();
        UserProfile userProfile = new UserProfile(nameInput , ageInput , mbtiInput );
        System.out.println("--- 프로필 ---");
        System.out.println("이름: "+ userProfile.name + ", 나이: "+ userProfile.age + ", MBTI: " + userProfile.mbti);


    }   // main end
}   // class end

class Book {

    String title;
    String author;
    int price;

    Book(String title , String author,int price ){
        this.title = title ;
        this.author = author ;
        this.price = price ;
    }   // 생성자 end
}   // class Book end

class Pet {

    String name;
    String species;
    int age;

    Pet( String name , String species , int age){
        this.name = name;
        this.species = species;
        this.age = age;
    }   // 생성자 end
}   // class Pet end

class Rectangle{

    int width;
    int height;
    Rectangle( int width , int height ){
        this.width = width;
        this.height = height;
    }   // 생성자 end

    int getArea(){
        int result = width * height ;
        return result;
    }   // func getArea end

}   // class Rectangle end

class BankAccount{

    String accountNumber;
    String ownerName;
    int balance;

    BankAccount( String accountNumber, String ownerName ,int balance  ){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }   // 생성자 end

    int deposit( int money ){
        balance += money;
        return balance;
    }   // func deposit end

    int withdraw( int money ){
        balance -= money;
        return  balance;
    }   // func withdraw end

}   // class BankAccount end

class Goods{

    String name ;
    int price;

    Goods(){
        this("미정", 0);
    }   // 생성자 초기값 end

    Goods(String name,int price){
        this.name = name;
        this.price = price;
    }   // 생성자 매개변수 end

}   // class Goods end

class Member {

    String id;
    boolean isLogin;

    Member(){
        id = "guest";
        isLogin = false;
    }   // 생성자 end

}   // class Member end

class Television{

    int channel;
    int volume;

    Television( int channel, int volume ){
        this.channel = channel;
        this.volume = volume;
    }   // 생성자 end

}   // class Television end

class Player{

    String name;
    int power;
    int speed;

    Player( String name , int power , int speed ){
        this.name = name;
        this.power = power;
        this.speed = speed;
    }   // 생성자 end

}   // class Player end

class MenuItem{

    String name;
    int price;
    boolean isSignature;

    MenuItem(String name , int price, boolean isSignature){
        this.name = name;
        this.price = price;
        this.isSignature = isSignature;
    }   // 생성자 end

}   // class MenuItem end

class UserProfile{

    String name;
    int age;
    String mbti;

    UserProfile( String name , int age , String mbti){
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }   // 생성자 end

}   // class UserProfile end