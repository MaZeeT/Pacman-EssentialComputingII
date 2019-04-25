package UserControl;

import DataStructures.DepthFirst;
import Maze.IMaze;
import Maze.PacMan;
import Movement.DataStructureCrawlers.Crawler;
import Movement.IMover;
import Movement.UserControlled.IMoverControlled;
import Movement.UserControlled.MoveClockWise;
import javafx.scene.input.KeyCode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputManagerTest {
    private KeyCode keyCode;
    private IMover mover;
    private IMoverControlled moverControlled;
    private UserInput userInput;
    private InputManager inputManager;

    @Before
    public void setUp() {
        IMaze maze = new PacMan();
        keyCode = KeyCode.W;
        mover = new Crawler(maze, maze.getPlayer(), new DepthFirst());
        moverControlled = new MoveClockWise(maze, maze.getPlayer());
        userInput = new PlayerControl();
    }

    @Test
    public void controlledUpdateKeycodeW() {
        inputManager = new InputManager(moverControlled, userInput);
        inputManager.update(keyCode);

        char actual = 'w';
        char expected = moverControlled.getDirection();
        assertEquals(expected, actual);
    }

    @Test
    public void uncontrolledUpdateKeycodeW() {
        inputManager = new InputManager(mover, userInput);
        inputManager.update(keyCode);

        // "\0" is the "null" char
        char actual = '\0';
        char expected = moverControlled.getDirection();
        assertEquals(expected, actual);
    }

}
