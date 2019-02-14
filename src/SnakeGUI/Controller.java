package SnakeGUI;

import javafx.event.ActionEvent;

public class Controller {
    View view;

   public Controller(View view){
        this.view = view;
    }

    public void btnStartAction(ActionEvent event) {
        System.out.println("btn clicked");
        view.drawCanvas();
    }
}
