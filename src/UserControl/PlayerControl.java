package UserControl;

import javafx.scene.input.KeyCode;

/**
 * The purpose of this class is to give the user a way to control the program.
 * Since the program uses chars for control the incoming keycode need to be converted.
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

    /**
     * {@inheritDoc}
     *
     * @param key {@inheritDoc}
     * @return {@inheritDoc}
     */
    public char getDirection(KeyCode key) {
        return direction(key);
    }

}
