import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        int width = 30; // width of maze
        int height = 20; // height of maze
        int runSpeed = 500; // milliseconds between each update

        Launcher launcher = new Launcher(width, height, runSpeed);

        primaryStage.setTitle("Snake");
        primaryStage.setScene(launcher.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
