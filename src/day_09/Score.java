package day_09; // package

public class Score {    // class Score start
    private int score;  // 접근제어자 private int score 멤버변수 할당

    public void setScore(int score){    // setter 메소드 public 리턴값없음.
        if(score >= 0 && score <= 100){ // if 만약 매개변수로 받은 score값이 100 이하 0이상이라면?
            this.score = score; // 매개변수 score에 매개변수값 넣어줌
        }   // if
        else{   //  아니라면?
            System.out.println("유효하지 않은 점수입니다.");   // 유효하지 않은 값;
        }   // if end
    }   // func end

}   // class Score end
