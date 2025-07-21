package day_16; // package

public class 실습14 { // class start
    // 7. throws로 예외 떠넘기기
    // Thread.sleep(1000); 코드를 포함하는 pauseOneSecond() 메소드를 만드세요.
    // 이 메소드는 try-catch 대신 throws InterruptedException를 사용하여 예외를 떠넘기도록 선언하세요.
    public static void pauseOneSecond() throws InterruptedException {
        Thread.sleep(1000);
    } // func end

    public static void main(String[] args) {    // main start
        // 1. ArithmeticException 처리
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {   // ArithmeticException : 나누기 0을 하면 발생하는 예외
            System.out.println("0으로 나눌 수 없습니다.");
        }

        // 2. NumberFormatException 처리
        try {
            String notANumber = "오류";               // 문자열
            int value = Integer.parseInt(notANumber);   // 오류 뜸 -> "오류"를 숫자로 변환하려고 했기 때문.
        } catch (NumberFormatException e) {             // NumberFormatException : 숫자로 변환하는 도중 문자열이 숫자형식이 아니라면 발생하는 예외
            System.out.println("잘못된 숫자 형식입니다.");
        }

        // 3. ArrayIndexOutOfBoundsException 처리
        try {
            String[] fruits = {"사과", "바나나"};         // 인덱스 0 , 1만 존재
            System.out.println(fruits[2]);              // 인덱스 2의 값은 없음
        } catch (ArrayIndexOutOfBoundsException e) {    // ArrayIndexOutBoundsException : 존재하지 않는 인덱스 값을 출력하려고 할 때 발생하는 예외
            System.out.println("잘못된 인덱스에 접근했습니다.");
        }

        // 4. NullPointerException 처리
        try {
            String text = null;         // text 의 값은 null
            System.out.println("글자 수: " + text.toUpperCase());  // null 값을 대문자화 할 수 없음.
        } catch (NullPointerException e) {  // NullPointerException : 값이 null (초기화 안 된) 참고변수에 객체의 필드, 메서드 , 배열 등이 호출을 시도할 때 발생하는 예외.
            System.out.println("객체가 초기화되지 않았습니다.");
        }

        // 5. finally 블록으로 리소스 정리하기
        try {
            System.out.println("데이터베이스 연결을 시작합니다.");
        } finally {                                             // 예외 발생여부와 상관없이 실행되는 finally
            System.out.println("데이터베이스 연결을 종료합니다.");
        }

        // 6. 다중 catch 블록
        try {
            String text = null;     // Null 값의 길이를 알려고 시도함
            text.length();

            int result = 5 / 0;     // 5를 0으로 나누는건 논리 오류

        } catch (NullPointerException e) {  // NullPointerException : Null인 참조변수에 필드 , 메소드 , 배열 등이 호출을 시도할 때 발생하는 예외
            System.out.println("객체가 초기화 되지 않았습니다.");
        } catch (ArithmeticException e) {   // ArithmeticException : 숫자를 0으로 나누려고 할 때 생기는 예외
            System.out.println("0으로 나눌 수 없습니다.");
        }       // -> 가장 먼저 발견된 하나의 예외만 출력하기 때문에 "객체가 초기화 되지 않았습니다" 라고 뜸

        // 7. [문제 7] throws로 예외 떠넘기기
        try {
            pauseOneSecond();           // Thread.sleep(1000); // 1초간 프로그램 일시정지
        } catch (InterruptedException e) {  // InterruptedException :  스레드가 일시 정지(sleep, wait 등) 상태일 때,다른 스레드가 그 스레드를 깨우면(interrupt) 발생하는 예외
            System.out.println("1초 프로그램 정지");
        }

        // 8. Exception 클래스로 모든 예외 처리
        try {
            int[] arr = new int[2];
            System.out.println(arr[5]);
        } catch (Exception e) {     // 예외 처리 모든 걸 담당하는 Exception
            System.out.println("알 수 없는 오류가 발생했습니다.");
        }

    }   // main end
}   // class end
