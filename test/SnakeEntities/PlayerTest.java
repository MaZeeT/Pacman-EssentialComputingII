package SnakeEntities;

import SnakeComponents.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player defPlayer;
    private Position defPos;
    private int defX;
    private int defY;


    @Before
    public void setUp(){
        defX = 2;
        defY = 3;
        defPos = new Position(defX, defY);
        defPlayer = new Player(defPos);
    }

    @Test
    public void moveUp() {
        Position pos = new Position(defX,defY-1);

        int expected = 0;
        int actual = defPlayer.moveUp().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void moveDown() {
        Position pos = new Position(defX,defY+1);

        int expected = 0;
        int actual = defPlayer.moveDown().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void moveLeft() {
        Position pos = new Position(defX-1,defY);

        int expected = 0;
        int actual = defPlayer.moveLeft().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void moveRight() {
        Position pos = new Position(defX+1,defY);

        int expected = 0;
        int actual = defPlayer.moveRight().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void manipulationOfStoredPosition() {

        int expected = 0;
        int actual = defPlayer.moveRight().compareTo(defPos);
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        boolean expected = false;
        boolean actual = defPlayer.update();
        assertEquals(expected, actual);
    }
}