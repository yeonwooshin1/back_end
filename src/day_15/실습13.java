package day_15; // package

import java.sql.SQLOutput;

public class 실습13 { // class start
    public static void main(String[] args) {    // main start
        // 1.
        Cat cat = new Cat();
        cat.makeSound();    // 야옹
        Dog dog = new Dog();
        dog.makeSound();    // 멍멍

        // 2.
        System.out.println(RemoteControl.MAX_VOLUME);   // 10
        System.out.println(RemoteControl.MIN_VOLUME);   // 0

        // 3.
        Runnable runner;
        runner = new Person();
        runner.run();
        runner = new Car();
        runner.run();

        // 4.
        Sword sword = new Sword();
        Gun gun = new Gun();
        Character character = new Character();
        character.useWeapon(sword); // 검으로 공격합니다.
        character.useWeapon(gun);   // 총으로 공격합니다.

        // 5.
        Duck duck = new Duck();
        duck.fly();              duck.swimmable();  // 오리날다 - 체리필터 -    ,    오리가 수영합니다.

        // 6.
        Object obj = new Duck();
        if(obj instanceof Flyable) {
            Flyable objFlyable = (Flyable) obj; // 강제 타입변환
            objFlyable.fly();   // 오리날다 - 체리필터 -
        }
        if(obj instanceof Swimmable){
            Swimmable objSwimmable = (Swimmable) obj;   // 강제 타입변환
            objSwimmable.swimmable();   // 오리가 수영합니다.
        }

        // 7.
        DataAccessObject dao;
        dao = new OracleDao();
        dao.save();             // "Oracle DB에 저장"
        dao = new MySqlDao();
        dao.save();             // "MySQL DB에 저장"

        // 8.
        Greeting greeting = new Greeting() {
            public void welcome() {
                System.out.println("환영합니다.");
            }
        };
        greeting.welcome();     // "환영합니다."

        // 9.
        Television tv = new Television();
        tv.turnOff();           // 티비를 끕니다.
        tv.turnOn();            // 티비를 켭니다.
        tv.setMute(true);       // 무음 처리합니다

        // 10.
        int plusResult =Calculator.plus( 10, 20);
        System.out.println(plusResult);             // 10 + 20 => !!30!!
    }   // main end
}   // class end
// 1.
interface Soundable {
    public abstract void makeSound();
}   // interface end
class Cat implements Soundable{
    public void makeSound(){
        System.out.println("야옹");
    }   // func end
}   // class end
class Dog implements Soundable{
    public void makeSound(){
        System.out.println("멍멍");
    }   // func end
}   // class end

// 2.
interface RemoteControl {
    public static final int MAX_VOLUME = 10;
    public static final int MIN_VOLUME = 0;
}  // interface end

// 3.
interface Runnable {
    void run(); // func end
}   // interface end
class Person implements Runnable{
    public void run(){
        System.out.println("사람이 달립니다.");
    }   // func end
}   // class end
class Car implements Runnable{
    public void run(){
        System.out.println("자동차가 달립니다.");
    }   // func end
}   // class end

// 4.
interface Attackable{   // interface start
    void attack();  // func end
}   // interface end
class Sword implements Attackable{
    public void attack() {
        System.out.println("검으로 공격합니다.");
    }   // func end
}   // class end
class Gun implements Attackable{
    public void attack() {
        System.out.println("총으로 공격합니다.");
    }   // func end
}   // class end
class Character {
    public void  useWeapon(Attackable weapon){
        weapon.attack();
    }   // func end
}   // class end

// 5.
interface Flyable {
    void fly(); // func end
}   // interface end
interface Swimmable {
    void swimmable();   // func end
}   // class end
class Duck implements Flyable , Swimmable {
    public void fly() {
        System.out.println("오리날다 - 체리필터 -");
    }   // func end
    public void swimmable() {
        System.out.println("오리가 수영합니다.");
    }   // func end
}   // class end

// 6. 5번 인터페이스 , 클래스 참조

// 7.
interface DataAccessObject {
    void save();    // func end
}   // interface end
class OracleDao implements DataAccessObject{
    public void save() {
        System.out.println("Oracle DB에 저장");
    }   // func end
}   // class end
class MySqlDao implements DataAccessObject{
    public void save() {
        System.out.println("MySQL DB에 저장");
    }   // func end
}   // class end

// 8.
interface Greeting {
    void welcome(); // func end
}   // interface end

// 9.
interface Device {
    void turnOn();  // func end
    void turnOff(); // func end
    public default void setMute(boolean mute) { // default 메소드 (오버라이딩 안해도 됨)
        System.out.println("무음 처리합니다.");
    }   // func end
}   // interface end
class Television implements Device {
    public void turnOn() {
        System.out.println("티비를 켭니다.");
    }   // func end
    public void turnOff() {
        System.out.println("티비를 끕니다.");
    }   // func end
}   // class end

// 10.
interface Calculator{
    static int plus(int x , int y){
        return x+y;         // 반환값  : x y 더한 값
    }    // func end
}   // interface end

