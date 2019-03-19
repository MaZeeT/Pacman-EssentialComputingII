package SnakeUserControl;

import javafx.scene.input.KeyCode;

/**
 * The purpose of this class is to give the user a way to control the program.
 * Since the program uses chars for control the incomming keycode need to be converted.
 *
 * @author MaZeeT
 */
public class PlayerControl implements UserControl {

    /**
     * Convert the KeyCode to a char.
     *
     * @param key input key from user.
     * @return Return char depending on input from user.
     */
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


    // inherit javaDoc
    //TODO check if this is the proper way to inherit javaDocs
    public char getDirection(KeyCode key) {
        System.out.println("key pressed: " + key);
        return direction(key);
    }

}
