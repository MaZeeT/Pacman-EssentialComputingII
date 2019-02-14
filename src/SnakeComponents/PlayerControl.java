package SnakeComponents;

import SnakeEntities.GameObject;
import javafx.scene.input.KeyCode;

public class PlayerControl {
    public KeyCode keyPressed = KeyCode.BACK_SPACE;

    public void keyPressed(KeyCode keyCode) {
        System.out.println("key pressed: " + keyCode);
        keyPressed = keyCode;
    }

    public int X;
    public int Y;

    /**
     * Game loop - executed continously during the game
     *
     * @param now game time in nano seconds
     */
    public void update(long now) {
        switch (keyPressed) {
            case S:
                this.Y++;
                break;
            case A:
                this.X--;
                break;
            case D:
                this.X++;
                break;
            case W:
                this.Y--;
                break;
        }
    }


}
