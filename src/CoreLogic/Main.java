package CoreLogic;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Starting point for the program.
 *
 * @author MaZeeT
 */
public class Main extends Application {

    /**
     * instantiate the program and make a window for the program to show to.
     *
     * @param primaryStage the variable for the stage that need to get pasted the scene from the running program.
     */
    @Override
    public void start(Stage primaryStage) {
        // launch the program and grabs the output gui as a scene
        Launcher launcher = new Launcher();
        primaryStage.setScene(launcher.getScene());
        primaryStage.setTitle("PacMan");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
