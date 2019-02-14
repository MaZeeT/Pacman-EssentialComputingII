package SnakeLogic;

import SnakeComponents.PlayerControl;
import SnakeEntities.Player;
import SnakeGUI.Controller;
import SnakeGUI.View;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        View view = new View();
        GameManager gameManager = new GameManager(view);
        Controller controller = new Controller(view);
        Player player = new Player(gameManager.getRandomPosition());
        view.setPlayer(player);
        PlayerControl pc = new PlayerControl();

        primaryStage.setTitle("Snake");
        Scene scene = new Scene(view.pane, 800, 600);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                pc.keyPressed(event.getCode());
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
