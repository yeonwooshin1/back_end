package day_09;

public class Member {   // class Member start
    private String id;  // private 접근제어자 id 멤버변수

    public void setId(String id){   // public 반환값 없는 setId 메소드 , setter
        this.id = id;   // id에 매개변수로 받은 id값 넣어줌
    }   // setter func end

    public String getId(){  // public 반환값 문자열인 getId 메소드 , getter
        return id;              // private 멤버변수 return;
    }   // getter func end
}   // class Member end
