package day_16; // package

import java.io.File;
import java.io.FileInputStream;

public class Example5 { // class start
    public static void main(String[] args) {    // main start

        // 예제2 : 공공데이터포털 에서 CSV 파일 다루기
        // CSV 이란? 데이터들 간의 속성을 ,(쉼표) 구분 하고 행 간의 구분은 \n 구분 한다.
        // 1.
        // 2. '부평구 맛있는 집' 검색
        // 3. "인천광역시 부평구_맛있는 집(맛집) 현황" 클릭
        // 4. https://www.data.go.kr/data/15103411/fileData.do
        // 5. 현재 패키지에 저장(부평구_맛있는 집.CSV)

        try {  // (4) 모든 코드를 감싼 예외 처리

            // (1) 파일 존재 여부 확인 : 경로 참조 복사 -> 컨텐츠 루트로부터의 경로
            String path = "src/day_16/부평구_맛있는 집.csv";   // 상대 경로
            File file = new File(path);
            System.out.println(file.exists());  // 경로에 파일이 존재하면 true;

            // (2) 존재하면 파일 읽어오기
            if (file.exists()) {
                FileInputStream fin = new FileInputStream(path);            // (3) 파일 입력 객체 생성

                byte[] bytes = new byte[ (int)file.length() ];              // (5) 읽어온 바이트를 저장할 바이트 배열을 용량

                fin.read( bytes );                                          // (6) 바이트 읽어서 배열에 저장

                String str = new String( bytes , "EUC-KR" );    // (7) 읽어온 바이트를 문자열로 변환 ,
                // --> "EUC-KR" : 파일내 (한글) 인코딩 안될 경우 String 생성자 인수 두 번째에 추가.

                System.out.println( str );

                // (8) ******************************* CSV 분해하기 ************************************

                // - 속성(열) 구분 : ,(쉼표)     ||      -행 구분 : \n

                // "문자열".split("구분문자") : 지정한 구분문자 기준으로 쪼개서 배열로 반환 함수

                System.out.println( str.split("\n")[0] );                       // 첫 번째 행           : 연번,업 소 명,소재지,지정메뉴,전화번호,업태
                System.out.println( str.split("\n")[1].split(",")[1] );   // 두번째 행에 두번째 열  : (주)온누리푸드온누리장작구이

                //========================================= 배열로 만들어서 for문 =================================================

                String[] 행데이터 = str.split("\n");                             //행 단위로 쪼개서 배열에 저장
                for(String index : 행데이터 ){
                        // System.out.println(index);  // 한 줄(행/row) 씩 출력

                    String[] 열데이터 = index.split(",");   // 행을 열 단위로 쪼개서 배열에 저장
                        // System.out.println(열데이터[1]);   -> 업소명
                        // System.out.println(열데이터[3]);   -> 지정메뉴

                    System.out.println("업소명 : " + 열데이터[1] +" 지정메뉴 : " + 열데이터[3] );

                }   // for end
            }   // if end

        } catch ( Exception e ) { System.out.println(e); }  // 예외 처리 catch



    }   // main end
}   // class end
