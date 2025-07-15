package project.controller;

public class LendingStatusController {

    // 싱글톤 만들기

    private LendingStatusController(){}
    private static final LendingStatusController lendingStatusController = new LendingStatusController();
    public static LendingStatusController getInstance(){
        return lendingStatusController;
    }



}
