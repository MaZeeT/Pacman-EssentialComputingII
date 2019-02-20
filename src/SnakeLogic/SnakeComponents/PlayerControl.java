package SnakeLogic.SnakeComponents;

import javafx.scene.input.KeyCode;

public class PlayerControl implements UserControl{
    public KeyCode keyPressed = KeyCode.BACK_SPACE;

    public void keyPressed(KeyCode keyCode) {
        System.out.println("key pressed: " + keyCode);
        keyPressed = keyCode;
    }

    char direction;

    public void update(long now) {
        switch (keyPressed) {
            case S:
                direction = 's';
                break;
            case A:
                direction = 'w';
                break;
            case D:
                direction = 'e';
                break;
            case W:
                direction = 'n';
                break;
        }
    }

    public char getDirection() {
        keyPressed(keyPressed);
        update(0);
        return direction;
    }

}