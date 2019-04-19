package UserControl;

import Movement.IMoverControlled;
import javafx.scene.input.KeyCode;

//todo javaDoc
//todo make tests
public class InputManager {
    private IMoverControlled mover;
    private UserInput userInput;
    private char direction;
    private boolean setDefaultDirection = true;

    public InputManager(IMoverControlled mover) {
        this.mover = mover;
        direction = 'a';
    }

    public InputManager(IMoverControlled mover, UserInput userInput) {
        this.mover = mover;
        this.userInput = userInput;
        direction = 'a';
    }

    //todo look into removing keyCodes
    public void update(KeyCode keyCode) {
        direction = mover.getDirection();
        direction = userInput.getDirection(keyCode);
        mover.setDirection(direction);
    }

    /*
    public void update() {
        direction = mover.getDirection();
        if (userInput == null && setDefaultDirection) {
            mover.setDirection(direction);
            setDefaultDirection = false;
        }
    }*/

}
