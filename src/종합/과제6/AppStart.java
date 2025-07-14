package 종합.과제6; // package

import 종합.과제6.view.WaitingView;

public class AppStart { // class AppStart start
    public static void main(String[] args) {    // main start

        // 싱글톤 가져오기
        WaitingView.getInstance().index();

    }   // main end
}   // class AppStart end
