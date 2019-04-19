package Entities;

import Components.Position;
import DataStructures.BreadthFirst;
import Maze.PacMan;
import Movement.Crawler;
import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GhostTest extends MovableEntityTest {

    @Before
    public void setUp() {
        defX = 2;
        defY = 3;
        defPos = new Position(defX, defY);
        defMovable = new Ghost(defPos);
        defMover = new Crawler(new PacMan(), defMovable, new BreadthFirst());
    }

    @Test
    public void getDefaultColor() {
        Color expected = Color.RED;
        Color actual = defMovable.getColor();
        assertEquals(expected, actual);
    }

    @Test
    public void setConstructorColor() {
        Color color = Color.BLUE;
        MovableEntity movable = new Ghost(new Position(1, 1), color);

        Color expected = color;
        Color actual = movable.getColor();
        assertEquals(expected, actual);
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
