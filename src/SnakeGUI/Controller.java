package SnakeGUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

//TODO write javaDoc
class Controller {
    private Manager manager;
    private Button btnStart;
    private Button btnPause;

    Controller(Manager manager, Button start, Button pause) {
        this.manager = manager;
        this.btnStart = start;
        this.btnPause = pause;
    }

    private void start() {
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                manager.startGame();
            }
        });
    }

    private void pause(){
        btnPause.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                manager.pauseGame();
            }
        });
    }

}
