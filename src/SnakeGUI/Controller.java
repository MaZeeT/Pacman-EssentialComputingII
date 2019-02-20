package SnakeGUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Controller {
    View view;
    Button btnStart;

    public Controller(View view) {
        this.view = view;
        this.btnStart = view.btnStart;
        setUpBtn(this.btnStart);
    }

    private void setUpBtn(Button btn) {
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                start();
            }
        });
    }

    public void start() {
        System.out.println("btn clicked");
        view.drawCanvas();
    }
}
