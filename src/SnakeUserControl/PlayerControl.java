package SnakeUserControl;

import javafx.scene.input.KeyCode;

public class PlayerControl implements UserControl{
    public KeyCode keyPressed = KeyCode.BACK_SPACE;

    public void keyPressed(KeyCode keyCode) {
        System.out.println("key pressed: " + keyCode);
        keyPressed = keyCode;
    }

    char direction;

    private void update() {
        switch (keyPressed) {
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
    }

    public char getDirection() {
        keyPressed(keyPressed);
        update();
        return direction;
    }

}
