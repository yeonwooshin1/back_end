package day_21; // package

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example4 {
    public static void main(String[] args) {
        /*
        [ 스레드풀 ]
            1. 정의 : 미리 일정 개수의 스레드를 생성하고 필요에 따라 재사용하는 방식
            2. 목적 : 작업이 들어올때 마다 새로운 스레드가 아닌 기존 스레드 이용한다.
            3. 효과 : 스레드 재사용, 자원 효율성, 과부하 방지 등등
            4. 구조 : 작업의 요청을 '큐'라는 자료구조로 배치하여 순서대로 스레드풀에서 대기중인 스레드에게 작업 배정
                * 큐? 자료의 데이터들을 요청 순서대로 처리 방법 , 먼저 들어온 요청이 먼저 처리된다.
                ------------------------------------
                input [요청3] [요청2] [요청1]  output
                ------------------------------------
            5. 생활속예시 : 콜센터 , 유재석이 콜센터에 전화 하면 대기중인 직원1(스레드)가 존재하면 처리 아니면 대기
                                        스레드풀
                                            직원1( 스레드 )
                콜요청 --------->            직원2( 스레드 )
                                            직원3( 스레드 )
            6. 사용처 : 1)톰캣[자바웹클래스] 2)JDBC 3)업로드/다운로드 4)채팅
            7. 사용법
        */
        // [1] 작업스레드를 배정하기 , 스레드풀(여러개 스레드가 들어오는곳)
        // ExecutorService executorService = Executors.newFixedThreadPool( 스레드풀에 저장할 스레드수 );
        ExecutorService executorService = Executors.newFixedThreadPool( 3 );
        // [2] 반복문을 이용하여 각각 10개 스레드를 생성하여 스레드풀에 넣어주기
        for( int i = 1 ; i <= 10 ; i++ ){
            String name = "Thread " + i;
            // [3] 스레드 생성 , 익명 구현체
            Runnable runnable = new Runnable(){
                @Override public void run() {
                    try{ Thread.sleep(2000);}
                    catch ( Exception e ){}
                    System.out.println("Task Thread : " + name );
                } // run end
            }; // 익명구현체 end
            // [4] 생성된 스레드를 스레드풀에 넣어주기/등록한다/배정한다.
            executorService.submit( runnable );
        } // for end
        // [5] 스레드풀( 스레드풀 저장된 모든 스레드 ) 종료
        executorService.shutdown();
    } // main end
} // class end
