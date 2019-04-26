package UserControl;

import javafx.scene.input.KeyCode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerControlTest {

    private UserInput userInput;

    @Before
    public void setUp() {
        userInput = new PlayerControl();
    }

    @Test
    public void directionW() {
        char actual = 'w';
        KeyCode key = KeyCode.W;

        char expected = userInput.getDirection(key);
        assertEquals(expected, actual);
    }

    @Test
    public void directionS() {
        char actual = 's';
        KeyCode key = KeyCode.S;

        char expected = userInput.getDirection(key);
        assertEquals(expected, actual);
    }

    @Test
    public void directionA() {
        char actual = 'a';
        KeyCode key = KeyCode.A;

        char expected = userInput.getDirection(key);
        assertEquals(expected, actual);
    }

    @Test
    public void directionD() {
        char actual = 'd';
        KeyCode key = KeyCode.D;

        char expected = userInput.getDirection(key);
        assertEquals(expected, actual);
    }

    @Test
    public void directionSHIFT() {
        char actual = ' ';
        KeyCode key = KeyCode.SHIFT;

        char expected = userInput.getDirection(key);
        assertEquals(expected, actual);
    }

}
