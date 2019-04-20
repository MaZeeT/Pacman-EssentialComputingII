package UserControl;

import Movement.IMover;
import Movement.IMoverControlled;
import javafx.scene.input.KeyCode;

/**
 * The purpose of this class is to connect {@link UserInput} with {@link IMover}s
 * that implements the {@link IMoverControlled} interface.
 * If the given {@link IMover} does NOT implement the interface the update method
 * will do nothing even though a {@link UserInput} is given.
 *
 * @author MaZeeT
 */
public class InputManager {
    private IMover mover;
    private UserInput userInput;
    private char direction;

    /**
     * Constructor of the InputManager.
     * Takes a {@link IMover} and a {@link UserInput} object, to get input from one and set it in the other object.
     *
     * @param mover     The object that need to have the direction set.
     * @param userInput The object the directions is got from.
     */
    public InputManager(IMover mover, UserInput userInput) {
        this.mover = mover;
        this.userInput = userInput;
    }

    //todo look into removing keyCodes

    /**
     * Update the direction of a {@link IMover} implementing the {@link IMoverControlled} interface,
     * else nothing is done.
     *
     * @param keyCode The keyCode that define the raw input which is converted to fit
     *                the program in the classes implementing the {@link UserInput} interface.
     */
    public void update(KeyCode keyCode) {
        if (mover instanceof IMoverControlled) {
            direction = ((IMoverControlled) mover).getDirection();
            direction = userInput.getDirection(keyCode);
            ((IMoverControlled) mover).setDirection(direction);
        }
    }

}
