package Entities;

import Components.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest extends MovableEntityTest {

    @Before
    public void setUp() {
        defX = 2;
        defY = 3;
        defPos = new Position(defX, defY);
        defMovable = new Player(defPos);
    }

    @Test
    public void manipulationOfStoredPositionUp() {

        int expected = 0;
        int actual = defMovable.moveUp().compareTo(defPos);
        assertEquals(expected, actual);
    }

    @Test
    public void manipulationOfStoredPositionDown() {

        int expected = 0;
        int actual = defMovable.moveDown().compareTo(defPos);
        assertEquals(expected, actual);
    }

    @Test
    public void manipulationOfStoredPositionLeft() {

        int expected = 0;
        int actual = defMovable.moveLeft().compareTo(defPos);
        assertEquals(expected, actual);
    }

    @Test
    public void manipulationOfStoredPositionRight() {

        int expected = 0;
        int actual = defMovable.moveRight().compareTo(defPos);
        assertEquals(expected, actual);
    }

}
