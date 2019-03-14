package SnakeEntities;

import SnakeComponents.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WallTest {

    private Wall defWall;
    private Position defPos;
    private int defX;
    private int defY;

    @Before
    public void setUp() {
        defX = 2;
        defY = 3;
        defPos = new Position(defX, defY);
        defWall = new Wall(defPos);
    }

    @Test
    public void constructorPosition() {
        Position pos = new Position(defX, defY);
        Wall wall = new Wall(pos);

        Position expected = pos;
        Position actual = wall.getPosition();
        assertEquals(expected, actual);
    }

    @Test
    public void constructorXY() {
        int x = 1;
        int y = 5;
        Position pos = new Position(x, y);
        Wall wall = new Wall(x, y);

        int expected = 0;
        int actual = wall.getPosition().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void compareEqual() {
        Wall wall = new Wall(defPos);
        int expected = 0;
        int actual = defWall.compareTo(wall);
        assertEquals(expected, actual);
    }

    @Test
    public void compareToLower() {
        Wall wall = new Wall(new Position(defX-1,defY-1));
        int expected = -1;
        int actual = defWall.compareTo(wall);
        assertEquals(expected, actual);
    }

    @Test
    public void compareToHigher() {
        Wall wall = new Wall(new Position(defX+1,defY+1));
        int expected = 1;
        int actual = defWall.compareTo(wall);
        assertEquals(expected, actual);
    }
}