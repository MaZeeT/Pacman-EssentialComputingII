package SnakeUserControl;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public interface UserControl {
    char getDirection();
    void keyPressed(KeyCode event);
}
