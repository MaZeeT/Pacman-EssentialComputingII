import SnakeGUI.IManager;
import SnakeLogic.GameManager;
import SnakeUserControl.PlayerControl;
import SnakeGUI.Manager;
import SnakeUserControl.UserControl;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Interfaced modules
        IManager gui = new Manager();
        UserControl userControl = new PlayerControl();

        // Game logic
        GameManager gameManager = new GameManager(gui.getView());

        // Setup scene and stage
        Scene scene = new Scene(gui.getView().pane, 800, 600);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                userControl.getDirection(event.getCode());
                //userControl.keyPressed(event.getCode());
                gameManager.setDirection(userControl.getDirection(event.getCode()));
            }
        });
        primaryStage.setTitle("Snake");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread() { //this check for modifications of the external datafile
            public void run() {
                for (; ; ) {
                    try {
                        gameManager.update();
                        gui.update(gameManager.getGameObjects());
                        sleep(500);
                    } catch (Exception e) {
                    }
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
