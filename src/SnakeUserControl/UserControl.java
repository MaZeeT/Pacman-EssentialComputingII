package SnakeUserControl;

import javafx.scene.input.KeyCode;

public interface UserControl {
    char getDirection();
    void keyPressed(KeyCode event);
}
