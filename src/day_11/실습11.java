package day_11; // package

import java.util.ArrayList;
import java.util.Scanner;

public class 실습11 { // class start
    public static void main(String[] args) { // main start
        // 1.

        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("유재석");
        nameList.add("강호동");
        nameList.add("신동엽");
        System.out.println(nameList);

        // 2.

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("사과"); fruits.add("바나나"); fruits.add("딸기");
        for (int i = 0; i < fruits.size(); i++) {
            String fruit = fruits.get(i);
            System.out.println("인덱스 " + i + ": "+ fruit);
        }

        // 3.

        for(String fruit : fruits){
            System.out.println("과일 : "+ fruit);
        }

        // 4.

        ArrayList< String > english = new ArrayList<>();
        english.add("A"); english.add("B"); english.add("C"); english.add("D"); english.add("E");
        english.remove(2);
        System.out.println(english);

        // 5.

        ArrayList< String > deprogramming = new ArrayList<>();
        deprogramming.add("자바"); deprogramming.add("파이썬"); deprogramming.add("C++");
        deprogramming.add(1, "자바스크립트");
        System.out.println(deprogramming);

        // 6.

        Book book1 = new Book("나는코딩" , "신코딩");
        Book book2 = new Book("나는자바" , "박자바");
        Book book3 = new Book("나는씨쁠" , "이씨쁠");

        ArrayList< Book > library = new ArrayList<>();

        library.add(book1);
        library.add(book2);
        library.add(book3);

        for( Book book : library){
            System.out.println("책제목 : " + book.title + " 저자 : " + book.author );
        }

        // 7.

        Scanner scan = new Scanner(System.in);

        ArrayList< String > scanInput = new ArrayList<>();

        for( ; ; ){
            System.out.print("SCAN값 입력하기 : ");
            String input =  scan.next();
            if(input.equals("종료")) {
                System.out.println(scanInput);
                break;
            }   // if end
            scanInput.add(input);
        }   // 무한루프 for

        // 8.
        ArrayList< String > subjects = new ArrayList<>();
        subjects.add("국어"); subjects.add("수학"); subjects.add("사회"); subjects.add("과학");
        subjects.set( 1 , "영어" );
        System.out.println(subjects);


    }   // main end
}   // class end


class Book{ // class Book start

    // 멤버변수
    String title;
    String author;

    // 생성자
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }   // 생성자

}   // class Book end