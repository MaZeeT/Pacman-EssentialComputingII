package UserControl;

import javafx.scene.input.KeyCode;

/**
 * The purpose of this interface, is to define what is needed for a input for a user to control the movement in the program.
 *
 * @author MaZeeT
 */
public interface UserInput {

    /**
     * Get the input of the user in form of a char with a value of w (up), s (down), a (left) and d (right).
     *
     * @param keyCode The keyCode from javaFX.
     * @return Returns the direction as a char.
     */
    char getDirection(KeyCode keyCode);
}
