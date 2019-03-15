package SnakeUserControl;

import javafx.scene.input.KeyCode;

public class PlayerControl implements UserControl {

    private char direction(KeyCode key) {
        char direction = ' ';
        switch (key) {
            case S:
                direction = 's';
                break;
            case A:
                direction = 'a';
                break;
            case D:
                direction = 'd';
                break;
            case W:
                direction = 'w';
                break;
        }
        return direction;
    }

    public char getDirection(KeyCode key) {
        System.out.println("key pressed: " + key);
        return direction(key);
    }

}
