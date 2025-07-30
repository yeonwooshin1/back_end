package day_23; // package

import java.util.*;

public class Example3 { // class start

    public static void main(String[] args) {    // main start
        /*
        [컬렉션 프레임워크3]
            List 인터페이스 : 순서(인덱스) 대로 저장하는 구조
            Set 인터페이스 : 순서(인덱스) 없이 저장하는 구조
            Map 인터페이스 : 순서(인덱스) 없이 key와 value를 한쌍(entry) 으로 여러 쌍 저장하는 구조
            -> JSON 이란 : 자바스크립트에서 사용하는 객체 형식
            -> 자바에는 json이 없어서 json 비슷한 형식은 map
         */
        // [1] HashMap 객체 생성 , < key 타입 , value 타입 >
        Map< String , Integer> map = new HashMap<>();
        // [2] 주요 메소드
        // 1) .put( key 자료 , value 자료2 ) : MAP 객체 내 KEY 와 VALUE 자료를 한쌍(ENTRY)을 저장한다.
        map.put( "유재석" , 95 );      // "유재석" 자료는 key(속성명) , 95 자료는 value(속성값)
        map.put( "강호동" , 100 );     // "강호동"속성(key)명에 100 대입/저장한다.
        map.put( "신동엽" , 75 );
        map.put( "유재석" , 67 );      // key(속성명) 중복이 불가능하다. (식별자가 겹치면 안된다.)
        map.put( "서장훈" , 100 );     // value(속성값) 중복이 가능하다.
        System.out.println(map);     // {서장훈=100, 유재석=67, 강호동=100, 신동엽=75}
            // 2) .get( key ) : MAP 객체내 지정한 KEY의 VALUE 반환
        System.out.println(map.get("유재석"));
            // .size( ) : MAP 객체내 entry(쌍) 갯수 반환
        System.out.println(map.size()); // 엔트리쌍 4쌍
            // 4). remove( key ) : MAP 객체 내 지정한 KEY의 entry(쌍) 삭제 한다.
        map.remove("유재석");
        System.out.println(map); // {서장훈=100, 강호동=100, 신동엽=75}
            // 5) .containsKey( key ) .containsValue( value ) : 키와 속성값의 여부를 boolean 타입으로 반환한다.
        System.out.println(map.containsValue(100));     // true
        System.out.println(map.containsKey("신연우"));   // false
            // 6) .clear() : MAP 객체 내 모든 entry 삭제한다.
        // map.clear();
            // 7) .isEmpty() : MAP 객체 내 entry 하나도 없으면 true , 1개 이상이면 false 반환
        System.out.println(map.isEmpty());                                  // false
            // + .entrySet() : MAP 객체 내 모든 entry 를 set 인터페이스 반환
        System.out.println( map.entrySet() );                           // [서장훈=100, 강호동=100, 신동엽=75]
            // + .keySet() : MAP 객체 내 모든 KEY 를 set 인터페이스 반환
        System.out.println( map.keySet() );                             // [서장훈, 강호동, 신동엽]
            // + .values() : MAP 객체 내 모든 VALUE를 List 인터페이스 반환
        System.out.println(map.values());                               // [100, 100, 75]

        // [3] MAP 과 반복문 관계
        // 1) 일반 FOR문 표현 못함. 인덱스가 없어서
        // 2) 향상된 FOR문
        for( String key : map.keySet() ){ // map 객체내 모든 키를 반복한다.
            System.out.println( key );              // key   * value 활용하여 key 호출 한다[x]
            System.out.println( map.get( key ) );   // value * key 활용하여 value 호출 한다[o]
        }
        // 3) forEach 문
        map.keySet().forEach( (key)->{
            System.out.println( key );
            System.out.println( map.get( key ) );
        });

        // 활용] JSON( javascript 객체 ) <----> MAP/DTO ( JAVA 객체 )

        // [4] 구현체
        // MAP 인터페이스 : key 와 value 를 (자료 2개)를 한쌍(entry 자료 1개) 으로 여러개 쌍을 저장

        // 1) HashMap           : key와 value로 구성된 entry 객체를 저장하는 구조
        HashMap<Integer , Object> hashMap = new HashMap<>();
        // 2) HashTable         : + 동기화 메소드 제공 ( 멀티 스레드 플렛폼 )
        Hashtable<Integer , Object> hashtable = new Hashtable<>();
        // 3) TreeMap           : + key 값 기준으로 자동 정렬 ( 오름차순 )
        TreeMap<Integer , Object> treeMap = new TreeMap<>();
        // 4) Properties        : + 제네릭이 없다. +주로 세팅/설정 파일 사용된다. Spring환경
        Properties properties = new Properties();

        // 다형성 기능
        Map<Integer , Object> map1;
        map1 = hashMap;     map1 = hashtable;       map1 = treeMap;
    }   // main end
}   // class end
