package SnakeLogic;

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
        Manager gui = new Manager();
        UserControl userControl = new PlayerControl();

        // Game logic
        GameManager gameManager = new GameManager(gui.getView());
        gui.setGameObects(gameManager.getRenderableGameObjects());

        // Setup scene and stage
        Scene scene = new Scene(gui.getView().pane, 800, 600);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                userControl.keyPressed(event.getCode());
                gameManager.setDirection(userControl.getDirection());
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
                        sleep(100);
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
