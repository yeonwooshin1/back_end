package day_07;     // pakage

public class 실습8 {  // class start
    public static void main(String[] args) {    // main start

        // 1.

        Printer printer = new Printer();
        printer.printMessage();

        // 2.

        Greeter greeter = new Greeter();
        greeter.greet("신연우");

        // 3.

        SimpleCalculator simpleCalculator = new SimpleCalculator();
        int result = simpleCalculator.add( 1, 4);
        System.out.println(result);

        // 4.

        Checker checker = new Checker();
        boolean result2 = checker.isEven(1);
        System.out.println(result2);

        // 5.

        Lamp lamp = new Lamp();
        lamp.turnOn();
        lamp.turnOff();

        // 6.

        Product product = new Product();
        product.stock = 10;
        boolean result3 = product.sell(5);
        System.out.println(result3);

        // 7.

        Visualizer visualizer = new Visualizer();
        String result4 = visualizer.getStars(5);
        System.out.println(result4);

        // 8.
        ParkingLot parkingLot = new ParkingLot();
        int result5 = parkingLot.calculateFee(65);
        int result6 = parkingLot.calculateFee(140);
        System.out.println(result5 + "원");
        System.out.println(result6 + "원");



    } // main end
}   // class end
class Printer{
    void printMessage(){
        System.out.println(" 안녕하세요, 메소드입니다." );
    }
}
class Greeter{
    void greet( String name){
        System.out.println( "안녕하세요, " + name + "님!" );
    }
}
class SimpleCalculator {
    int add( int a , int b ){
        int sum = a + b ;
        return sum;
    }
}
class Checker{
    boolean isEven( int x ){
        if(x%2 == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
class Lamp{
    boolean isOn;

    void turnOn(){
        isOn = true;
        System.out.println(isOn);
    }
    void turnOff(){
        isOn = false;
        System.out.println(isOn);
    }
}
class Product{
    String name;
    int stock;

    boolean sell(int amount){
        if(stock > amount){
            stock -= amount;
            return true;
        }else {
            System.out.println("재고 부족");
            return false;
        }
    }
}
class Visualizer{
    String getStars( int number ){
        String result = "";
        for(int i = 0; i < number; i++ ){
            result += "★";
        }   // for end
        return  result;
    }
}
class ParkingLot {
    int calculateFee (int minute){
        int fee = 0;
        if(minute > 30){
            fee = 1000 + (minute-30)/10*500;
            if(fee > 20000){
                fee = 20000;
                return fee;
            }
            else { return fee;}
        } else {
            fee = 1000;
            return fee;
        }
    } // func end
}