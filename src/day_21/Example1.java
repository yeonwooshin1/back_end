package day_21;

import java.awt.*;

class 작업스레드1 implements Runnable {
    // implements : 인터페이스 타입 구현 키워드
    // Runnable : 멀티스레드 인터페이스
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for( int i = 1 ; i <= 5 ; i++ ){
            toolkit.beep();
            try{ Thread.sleep( 1000 );}
            catch (Exception e ){}
        }
    }
} // class end

class 작업스레드2 extends Thread {
    // extends : 클래스 타입을 물려받는 키워드
    // Thread : 멀티 스레드 클래스
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 6; i++) {
            toolkit.beep();
            try{
                Thread.sleep(1000);
            } catch (Exception e){}
        }
    }
}

public class Example1 {
    public static void main(String[] args) {
        /*
        - 프로그램 : 코드(명령어)들의 집합
        - 프로세스 : 실행중인 프로그램
        - 멀티 태스킹 : **두가지 이상의 작업을 동시** 처리

        - 멀티 프로세스 : 운영체제가 동시에 여러개 프로세스 동시 처리
            -> 프로그램 단위의 *멀티 태스킹*
        - 멀티 스레드 : 프로세스 내에서 실행되는 작업 처리
            -> 하나의 프로그램 내 *멀티 태스킹*

        [ 스레드 Thread  ]
            1. 정의 : 하나의 프로세스 내에서 실행되는 작업 단위 , 실행 흐름의 단위
            2. 목적 : 코드(명령어)를 읽어드리고 CPU 가 명령어 처리한다.
            3. 자바 에서의 스레드
                1) main메소드 : public static void main( String[] args ){} 에는 main스레드가 내장 됨
            4. 사용법
                1) 자바 프로그램은 항상 main메소드(Thread)로 부터 실행 흐름 시작된다.
                - public static void main( String[] args ){}

        [ 멀티스레드 Muti-Thread ]
            1. 정의 : main스레드 외 새로운 *작업스레드*를 생성하여 동시 작업
            2. 목적 : *병렬 처리* , 동시에 여러 작업을 수행
            3. 사용처 : 웹/앱 , 채팅/첨부파일/JDBC , 동기화/비동기화 처리
            4. 사용법
            - 단일(싱글) : 1차선 도로
            - 병렬(멀티) : 다차선 도로
                (1) 익명 구현체
                    Thread thread = new Thread( new Runnable(){
                        @Override public void run(){
                            // 작업스레드가 처리할 코드
                        }
                    });
                    thread.start();

                (2) 구현체
                    class 작업클래스 implements Runnable{
                        @Override public void run(){
                            // 작업스레드가 처리할 코드
                        }
                    };
                    ----
                    Thread thread = new Thread( new 작업클래스() );
                    thread.start();

                (3)

            5. 주요 클래스/인터페이스
                (1) Thread 클래스
                    1) start 메소드 : 구현된 run메소드를 실행 메소드
                (2) Runnable 인터페이스
                    1) run 추상메소드 : 작업스레드가 실행하는 최초 시작점 처리 메소드
        */

        Toolkit toolkit = Toolkit.getDefaultToolkit(); // java ui 제공하는 패키지 ( java.awt )
        // [1] 단일(싱글) 스레드 예 : 위에서 아래 순으로 실행
        // 2) 소리 5번
        for( int i = 1 ; i<=5; i++ ){
            toolkit.beep(); // '띵' 소리 제공하는 메소드( 띵 하는 도중에 반복문 종료된다.)
            try {  Thread.sleep(1000); }   // Thread.sleep( 밀리초 ) : 현재 스레드를 밀리초 만큼 일시정시*예외처리
            catch ( Exception e ){ }
        } // for

        // 1) 출력 5번
        for( int i = 1 ; i<=5 ; i++ ){
            System.out.println("[1] MAIN 스레드가 읽어드리는 코드"+i); // main메소드가 처리하는 코드
        } // for end


        // [2] 멀티 스레드 예 : 익명 구현체 : 인터페이스타입을 클래스없이 직접 구현
        // 1) 소리 5번 : 익명 구현체 , new 인터페이스타입(){ 추상메소드구현; };
        Runnable runnable1 = new Runnable(){
            @Override  // run 추상메소드구현 // 오버라이딩 // 재정의
            public void run() {
                for( int i = 1 ; i<=5 ; i++ ){
                    toolkit.beep();
                    try{ Thread.sleep( 1000 ); }
                    catch ( Exception e ){ }
                }
            }
        };
        Thread thread1 = new Thread( runnable1 ); // run 구현한 runnable 타입을 Thread 생성자에 대입
        thread1.start(); // run 구현된 runnable 타입을 갖는 thread 객체가 작업 스레드 .start() 실행

        // 2) 출력 5번
        for( int i = 1 ; i<=5 ; i++ ){
            System.out.println("[2] MAIN 스레드가 읽어드리는 코드"+i); // main메소드가 처리하는 코드
            try{ Thread.sleep( 1000 ); }
            catch ( Exception e ){ }
        } // for end

        // [3] 멀티 스레드 예2 : 구현체
        // 1) 소리 5번
        작업스레드1 작업스레드1 = new 작업스레드1(); // 구현체
        Thread thread2 = new Thread( 작업스레드1 ); // 구현체를 Thread 객체에 대입
        thread2.start(); // 구현체를 갖는 Thread 객체가 start

        // 2) 출력 5번
        for( int i = 1 ; i<=5 ; i++ ){
            System.out.println("[3] MAIN 스레드가 읽어드리는 코드"+i); // main메소드가 처리하는 코드
            try{ Thread.sleep( 1000 ); }
            catch ( Exception e ){ }
        } // for end

        // [4]
        작업스레드2 작업스레드2 = new 작업스레드2();


    } // main end
}// class end