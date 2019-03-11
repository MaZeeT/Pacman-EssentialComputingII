package SnakeGUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

class Controller {
    private View view;
    private Button btnStart;

    Controller(View view) {
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

    private void start() {
        System.out.println("btn clicked");
        view.drawCanvas();
    }
}
