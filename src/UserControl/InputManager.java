package UserControl;

import Movement.IMover;
import Movement.IMoverControlled;
import javafx.scene.input.KeyCode;

//todo javaDoc
//todo make tests
public class InputManager {
    private IMover mover;
    private UserInput userInput;
    private char direction;

    public InputManager(IMover mover, UserInput userInput) {
        this.mover = mover;
        this.userInput = userInput;
    }

    //todo look into removing keyCodes
    public void update(KeyCode keyCode) {
        if (mover instanceof IMoverControlled) {
            direction = ((IMoverControlled)mover).getDirection();
            direction = userInput.getDirection(keyCode);
            ((IMoverControlled)mover).setDirection(direction);
        }
    }

}
