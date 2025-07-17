package day_14; // package

public class 실습12 { // class start
    public static void main(String[] args) {    // main start
        // 1.
        // 문제 1) 3. main 함수에서 Student 객체를 생성하고,
        Student student = new Student();
        // 문제 1) 3. 상속받은 name과 자신의 studentId에 값을 저장한 뒤
        student.name = "신연우";   student.studentId = 23;
        // 문제 1) 3. 모두 출력하세요.
        System.out.println("이름 : " + student.name + " 나이 : "+student.studentId);

        // 2.
        // 문제 2) 3. main 함수에서 Cat 객체를 생성하고
        Animal cat = new Cat();
        // 문제 2) 3. makeSound() 메소드를 호출하여, 재정의된 내용이 출력되는지 확인하세요.
        cat.makeSound();    // 고양이가 야옹하고 웁니다.

        // 3.
        // 문제 3) 3. main 함수에서 Computer 객체를 생성할 때, 콘솔에 출력되는 생성자 호출 순서를 확인하세요.
        Computer computer = new Computer();  // 부모 클래스 생성자 실행 , 자식 클래스 생성자 실행 , 부모클래스 실행 후 자식 클래스 생성자 실행됨.

        // 4.
        // 문제 4) 3. main 함수에서 Triangle 객체를 생성하여 Figure 타입의 변수에 저장하는 코드를 작성하고, 이것이 가능한 이유를 주석으로 설명하세요.
        Figure triangle = new Triangle(); // Triangle 클래스가 Figure 클래스를 상속받기 때문에, Triangle 객체가 Figure도 같이(-> 먼저) 컴파일해서 Figure 타입의 변수도 잘 돌아감. *문제3 참고*

        // 5.
        // 문제 5) 3.main 함수에서 Shape shape = new Circle(); 코드를 작성한 뒤,
        Shape shape = new Circle();
        // 문제 5) 3. shape.draw()를 호출했을 때 어떤 결과가 나오는지 확인하고 그 이유를 주석으로 설명하세요.
        shape.draw();   // 출력 : 원을 그립니다. 이유. Shape 타입이지만 상속 받은 클래스인 Circle 객체가 들어갔으니 오버라이딩 된 Circle 메소드가 실행된다. // Shape 객체를 부여한게 아니라 Circle 객체기 때문.

        // 6.
        // 문제 6) 2. main 함수에서 Vehicle vehicle = new Bus(); 코드를 작성하세요.
        Vehicle vehicle = new Bus();
        // 문제 6) 3. if문과 instanceof 연산자를 사용하여 vehicle 변수가 Bus 타입인지 확인하세요.
        if(vehicle instanceof Bus){
            // 문제 6) 4. 만약 Bus 타입이 맞다면, Bus 타입으로 강제 변환한 뒤 checkFare() 메소드를 호출하세요.
            Bus bus = (Bus) vehicle;
            bus.checkFare();
        }
        else System.out.println("vehicle은 Bus 타입이 아닙니다. ");

        // 7.
        // 문제 7) 3. main 함수에서 Beverage 타입의 배열을 생성하고, 그 안에 Coke 객체와 Coffee 객체를 저장하세요.
        Beverage[] beverageArray = { new Coke() , new Coffee()};
        // 문제 7) 4. 반복문을 사용하여 배열의 모든 요소를 꺼내 drink() 메소드를 호출하고, 각기 다른 결과가 출력되는 것을 확인하세요.
        for(Beverage index : beverageArray){
            index.drink();  // "콜라를 마십니다." "커피를 마십니다."
        }   // for end

        // 8.
        // 문제 8) 3. main 함수에서 Sword 객체와 Gun 객체를 생성한 뒤,
        Sword sword = new Sword();          Gun gun = new Gun();
        // 문제 8) 3. 이 객체들을 Character의 use() 메소드에 인자로 전달하여 각기 다른 결과가 출력되는 것을 확인하세요.
        Character c = new Character();
        c.use(sword);           c.use(gun); // 검으로 공격합니다. // 총으로 공격합니다.  // 매개변수가 Weapon weapon 이여도 오버라이딩 된 자식클래스 메소드를 사용함.

        // 9.
        // 문제 9) 3. SuperClass obj = new SubClass(); 로 객체를 생성한 뒤,
        SuperClass obj = new SubClass();
        // 문제 9) 3. obj.name과 obj.method()를 각각 호출했을 때의 결과를 확인하고, 왜 다른 결과가 나오는지 주석으로 설명하세요.
        System.out.println(obj.name);   obj.method();   // "상위" , "하위 메소드"
        // 이유 : obj.method는 오버라이딩을 해주기 때문에 SubClass의 메소드를 실행해준다. 하지만 멤벼변수는 참조 변수의 타입 멤버변수를 보여줌. "상위"는 SuperClass(참조타입)의 멤버변수가 실행됨.

        // 10.
        // 문제 10) 4. main 함수에서 Laptop 객체를 생성한 뒤,
        Laptop laptop = new Laptop();
        // 문제 10) 4. 이 객체가 Electronic 타입과 Device 타입으로도 형 변환이 가능한지 instanceof 연산자로 확인하고 결과를 출력하세요.
        System.out.println("laptop instanceof Laptop: " + (laptop instanceof Laptop));         // true임
        System.out.println("laptop instanceof Electronic: " + (laptop instanceof Electronic)); // true임
        System.out.println("laptop instanceof Device: " + (laptop instanceof Device));         // true임

    }   // main end
}   // class end

// 문제 1) 1. name(문자열) 멤버 변수를 가진 Person 클래스를 만드세요.
class Person{   // class Person start
    // 멤버변수
    String name;

}   // class end
// 문제 1) 2. Person 클래스를 상속받는 Student 클래스를 만드세요. Student 클래스에는 studentId(정수) 멤버 변수를 추가하세요.
class Student extends Person{ // class Student extends Person
    // 멤버변수
    int studentId;
}   // class end


// 문제 2) 1. "동물이 소리를 냅니다."를 출력하는 makeSound() 메소드를 가진 Animal 클래스를 만드세요.
class Animal {  // class Animal start
    void makeSound(){   // 메소드
        System.out.println("동물이 소리를 냅니다.");
    }   // func end
}   // class end
// 문제 2) 2. Animal을 상속받고, makeSound() 메소드를 재정의하여 "고양이가 야옹하고 웁니다."를 출력하는 Cat 클래스를 만드세요.
class Cat extends Animal{ // class Cat extends Animal
    void makeSound(){   // 메소드
        System.out.println("고양이가 야옹하고 웁니다.");
    }   // func end
}   // class end


// 문제 3) 1. 생성자에서 "부모 클래스 생성자 실행"을 출력하는 Machine 클래스를 만드세요.
class Machine { // class Machine start
    Machine(){  // 생성자
        System.out.println("부모 클래스 생성자 실행");
    }   // 생성자 end
}   // class end
// 문제 3) 2. Machine을 상속받고, 생성자에서 "자식 클래스 생성자 실행"을 출력하는 Computer 클래스를 만드세요.
class Computer extends Machine{ // class Computer extends Machine
    Computer(){ // 생성자
        System.out.println("자식 클래스 생성자 실행");
    }   // 생성자 end
}   // class end


// 문제 4) 1. Figure 클래스를 만드세요.
class Figure { } //class Figure
// 문제 4) 2. Figure를 상속받는 Triangle 클래스를 만드세요.
class Triangle extends Figure { } // class Triangle extends Figure


// 문제 5) 1."도형을 그립니다."를 출력하는 draw() 메소드를 가진 Shape 클래스를 만드세요.
class Shape {   // class Shape start
    void draw(){   // 메소드
        System.out.println("도형을 그립니다.");
    }   // func draw() end
}   // class end
// 문제 5) 2.Shape을 상속받고, draw() 메소드를 재정의하여 "원을 그립니다."를 출력하는 Circle 클래스를 만드세요.
class Circle extends Shape {    // class Circle extends Shape
    void draw() {   // 메소드
        System.out.println("원을 그립니다.");
    }   // func draw() end
}   // class end


// 문제 6) 1. Vehicle 클래스와 이를 상속받는 Bus 클래스를 만드세요. Bus 클래스에만 checkFare() 메소드("요금을 확인합니다.")를 추가하세요.
class Vehicle { }   // class Vehicle
class Bus extends Vehicle { // class Bus extends Vehicle
    void checkFare(){   // 메소드
        System.out.println("요금을 확인합니다.");
    }   // func checkFare end
} // class end


// 문제 7) 1. "음료를 마십니다."를 출력하는 drink() 메소드를 가진 Beverage 클래스를 만드세요.
class Beverage { // class start
    void drink(){   // 메소드
        System.out.println("물을 마십니다.");
    }   // func drink end
}   // class end

// 문제 7) 2. Beverage를 상속받는 Coke와 Coffee 클래스를 만들고, 각 클래스에서 drink() 메소드를 오버라이딩하여 "콜라를 마십니다.", "커피를 마십니다."를 출력하도록 하세요.
class Coke extends Beverage{     //class Coke extends Beverage
    void drink(){   // 메소드
        System.out.println("콜라를 마십니다.");
    }   // func drink end
}   // class end
class Coffee extends Beverage{   // class Coffee extends Beverage
    void drink(){   // 메소드
        System.out.println("커피를 마십니다.");
    }   // func drink end
}   // class end


// 문제 8) 1. Weapon 클래스와 이를 상속받는 Sword, Gun 클래스를 만드세요. 각 클래스는 "무기로 공격합니다.", "검으로 공격합니다.", "총으로 공격합니다."를 출력하는 attack() 메소드를 가집니다. (오버라이딩 활용)
class Weapon {  // class Weapon start
    void attack(){  // 메소드
        System.out.println("무기로 공격합니다.");
    }   // func attack end
}   // class end
class Sword extends Weapon { // class Sword extends Weapon
    void attack(){  // 메소드
        System.out.println("검으로 공격합니다.");
    }   // func attack end
}   // class end
class Gun extends Weapon { // class Gun extends Weapon
    void attack(){  // 메소드
        System.out.println("총으로 공격합니다.");
    }   // func attack end
}   // class end
// 문제 8) 2. Weapon 타입의 매개변수를 받아 그 객체의 attack() 메소드를 호출하는 Character 클래스와 use(Weapon weapon) 메소드를 만드세요.
class Character {   // class Character start
    void use(Weapon weapon){    // func use
        weapon.attack();
    }   // func use end
}   // class end


// 문제 9) 1. String name = "상위"; 필드와 method() 메소드("상위 메소드" 출력)를 가진 SuperClass를 만드세요.
class SuperClass {  // class SuperClass start
    // 멤버변수
    String name = "상위";

    // 메소드
    void method(){  // 메소드
        System.out.println("상위 메소드");
    }   // func method end
}   // class end
// 문제 9) 2. SuperClass를 상속받고, String name = "하위"; 필드와 method() 메소드("하위 메소드" 출력)를 가진 SubClass를 만드세요.
class SubClass extends SuperClass { //class SubClass extends SuperClass
    // 멤버변수
    String name = "하위";

    // 메소드
    void method(){  // 메소드
        System.out.println("하위 메소드");
    }   // func method end
}   // class end

// 문제 10) 1. Device 클래스를 만드세요.
class Device { }// class Device
// 문제 10) 2. Device를 상속받는 Electronic 클래스를 만드세요.
class Electronic extends Device{} // class Electronic extends Device
// 문제 10) 3. Electronic을 상속받는 Laptop 클래스를 만드세요.
class Laptop extends Electronic{} // class Laptop extends Electronic
