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

        int width = 30;
        int height = 20;

        // Interfaced modules
        IManager gui = new Manager(width,height);
        UserControl userControl = new PlayerControl();

        // Game logic
        GameManager gameManager = new GameManager(width,height);

        // Setup scene and stage
        Scene scene = new Scene(gui.getView().pane, 800, 600);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                userControl.getDirection(event.getCode());
                gameManager.setDirection(userControl.getDirection(event.getCode()));
            }
        });
        primaryStage.setTitle("Snake");
        primaryStage.setScene(scene);
        primaryStage.show();

        // thread to run updates
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
