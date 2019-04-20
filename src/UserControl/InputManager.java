package UserControl;

import Movement.IMover;
import Movement.IMoverControlled;
import javafx.scene.input.KeyCode;

//todo make tests

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

    //todo javaDoc

    /**
     * @param mover
     * @param userInput
     */
    public InputManager(IMover mover, UserInput userInput) {
        this.mover = mover;
        this.userInput = userInput;
    }

    //todo look into removing keyCodes
    //todo javaDoc

    /**
     * @param keyCode
     */
    public void update(KeyCode keyCode) {
        if (mover instanceof IMoverControlled) {
            direction = ((IMoverControlled) mover).getDirection();
            direction = userInput.getDirection(keyCode);
            ((IMoverControlled) mover).setDirection(direction);
        }
    }

}
