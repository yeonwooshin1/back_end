package by_yeonwoo;

public class Throws_Exception {    // class start
}   // class end


/*
[ 신연우의 예외와 throws의 공부 ]

    1) 메소드에서 throws할 때 최상위 예외(Exception)을 줬을 경우
        -> main 호출부에서 하위 예외을 썼을 때 throws (= 던질 때) 예외처리가 되었지만 catch 에서 (예 : NullPointException)하위 예외만 처리해주면 다른 예외가 생길 경우 컴파일이 안되어 오류가 뜰 수 있음.

        !! 메소드에서 throws할 때 하위 예외 (NullPointException) 같은 걸 throws 해주면 나머지 catch 에서 상위 예외나 같은 예외를 써주면 예외 처리가 좀 쉬워지는 경향이 있음 !!

    2) 오버라이딩할 때 부모타입보다 자식타입이 더 큰 예외를 둘 수 없다.

        부모 메서드 선언 	        자식 메서드 throws 목록	            결과	            이유
        throws IOException	    없음	                                ✅ 허용	        예외 범위를 줄임
        throws IOException	    throws FileNotFoundException	    ✅ 허용	        같은 계열에서 더 구체(좁음)
        throws IOException	    throws Exception	                ❌ 오류	        더 넓음(IOException의 상위)
        throws IOException	    throws IOException, ParseException	❌ 오류	        새로운 체크 예외 추가
        없음                     throws IOException	                ❌ 오류	        원래는 예외가 없다고 약속했는데 새로 생김
        (언체크 없음)	            throws NullPointerException	        ✅ 허용	        NullPointException는 런타임이라 괜찮음.
        -> 새로운 체크 예외를 더 주면 안됨 , 더 상위 예외를 쓰면 안됨.
        * 단 (RuntimeException) 런타임 예외는 자식이 써도 됨 (컴파일 때 걸리지 않음) *


    3-1) throws 할 때 여러 예외를 던질 수 있다.
        void work() throws IOException, ParseException 예시로 이 메소드가 있다고 가정할 시,
        “IOException 또는 ParseException이 발생할 수도 있다”라는 가능성을 컴파일러에게 알리는 것.
        하지만 둘 다 동시에 던진다는 뜻은 아님 → 한 호출 흐름에서 실제로 throw 되는 건 항상 하나(또는 아무것도 안 던지고 정상 종료).

        호출부에서는 다시 throws 하거나 세가지 경우의 수에서 catch를 해야하는데

        1. 정상 종료	            : 예외 없음
        2. IOException 발생	    : 파일·네트워크 등 I/O 문제
        3. ParseException 발생	: 포맷·구문 오류                  이 셋 중 하나인 것!

        즉 결론은 “A만, B만, 둘 다 아님(정상)” 셋 중 하나로 귀결되어 처리해주면 됨.

    3-2-1) throws 할 때 부모타입의 예외와 자식 타입의 예외를 동시에 쓰면 중복이 되어 불필요하고 컴파일이 오류가 뜬다.
        throws Exception , NullPointException 예시를 들어서 Exception이 NullPointException 을 포함하고 있는데 부모를 적는 순간 이미 자식까지 커버되는 상황이 된다.
        → 같은 계층에서 둘 다 쓰면 구현적으로 의미가 없고 중복이 되어버린다.
        → 컴파일 에러가 뜬다 : exception java.io.FileNotFoundException is already declared in the throws clause.

    3-2-2) catch 에서도 자식예외를 먼저 catch로 잡고 부모예외를 써준다.
        예시)
        try {
        foo();
        } catch (IOException e) {           부모예외
        ...
        } catch (FileNotFoundException e) { 도달 불가 → 컴파일 오류
        ...
        }
        -> 부모를 먼저 잡으면 자식은 unreachable code가 되어 버림. 반대로 “자식 → 부모” 순서는 *허용* 되지만, 부모를 쓰지 않고 필요한 자식들만 명시하는 편이 더 깔끔한 코드긴 함.

    4) main 에서 throws를 쓰는 경우
    내가 이해 가능한 범위는 -> 체크 예외를 throws만 하고 내부에서 처리하지 않고, 예외가 실제로 던져지면 런타임이 콘솔에 오류를 찍고 프로그램을 비정상 종료하는 것
    -> 파일 못 찾음 등으로 바로 종료하고 싶을 때, 그리고 테스트 코드에서 throw new Exception("fail") 하고 싶을 때에 한다고 함.

    *** 결론! 그냥 여기 에러가 떴어! 만 하고 catch나 수정을 하고 싶지 않을 때 쓰는 거 같음. 나중에 더 자세히 써봐야겠음. ***



    * 그냥 읽어보기 *
    catch 절의 타입이 throws로 선언된 예외(throws 하위 예외 두 개라고 예) 또는 그 상위 클래스라면 컴파일 OK.
    같은 타입을 “그대로” 써야 한다는 강제는 없지만, 너무 넓게(예: Exception) 잡으면 어떤 예외가 났는지 놓치기 쉬우니 상황에 맞춰 범위를 선택하면 됨. (catch 에서 오류 범위가 넓어져서)

 */