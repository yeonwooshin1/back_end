package project.view;

public class LogInView {
    private LogInView(){}
    private static final LogInView LogInView = new LogInView();
    public static LogInView getInstance(){
        return LogInView;
    }
}
