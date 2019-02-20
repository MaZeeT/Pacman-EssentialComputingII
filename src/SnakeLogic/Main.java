package SnakeLogic;

import SnakeUserControl.PlayerControl;
import SnakeEntities.Player;
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
        Manager gui = new Manager();
        GameManager gameManager = new GameManager(gui.getView());
        Player player = new Player(gameManager.getRandomPosition());
        UserControl userControl = new PlayerControl();

        primaryStage.setTitle("Snake");
        Scene scene = new Scene(gui.getView().pane, 800, 600);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                userControl.keyPressed(event.getCode());
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
