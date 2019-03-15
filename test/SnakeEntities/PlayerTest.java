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
    public void setUp() {
        defX = 2;
        defY = 3;
        defPos = new Position(defX, defY);
        defPlayer = new Player(defPos);
    }

    @Test
    public void moveUp() {
        Position pos = new Position(defX, defY - 1);

        int expected = 0;
        int actual = defPlayer.moveUp().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void moveDown() {
        Position pos = new Position(defX, defY + 1);

        int expected = 0;
        int actual = defPlayer.moveDown().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void moveLeft() {
        Position pos = new Position(defX - 1, defY);

        int expected = 0;
        int actual = defPlayer.moveLeft().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void moveRight() {
        Position pos = new Position(defX + 1, defY);

        int expected = 0;
        int actual = defPlayer.moveRight().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void move() {
        Position pos = new Position(defX + 1, defY);

        int expected = 0;
        int actual = defPlayer.moveRight().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void checkUp() {
        Position pos = new Position(defX, defY - 1);

        int expected = 0;
        int actual = defPlayer.checkUp().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void checkUp2() {
        int expected = -1;
        int actual = defPos.compareTo(defPlayer.checkUp());
        assertEquals(expected, actual);
    }

    @Test
    public void checkDown() {
        Position pos = new Position(defX, defY + 1);

        int expected = 0;
        int actual = defPlayer.checkDown().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void checkDown2() {
        int expected = +1;
        int actual = defPos.compareTo(defPlayer.checkDown());
        assertEquals(expected, actual);
    }

    @Test
    public void checkLeft() {
        Position pos = new Position(defX - 1, defY);

        int expected = 0;
        int actual = defPlayer.checkLeft().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void checkLeft2() {
        int expected = -1;
        int actual = defPos.compareTo(defPlayer.checkLeft());
        assertEquals(expected, actual);
    }

    @Test
    public void checkRight() {
        Position pos = new Position(defX + 1, defY);

        int expected = 0;
        int actual = defPlayer.checkRight().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void checkRight2() {
        int expected = +1;
        int actual = defPos.compareTo(defPlayer.checkRight());
        assertEquals(expected, actual);
    }

    @Test
    public void manipulationOfStoredPositionUp() {

        int expected = 0;
        int actual = defPlayer.moveUp().compareTo(defPos);
        assertEquals(expected, actual);
    }

    @Test
    public void manipulationOfStoredPositionDown() {

        int expected = 0;
        int actual = defPlayer.moveDown().compareTo(defPos);
        assertEquals(expected, actual);
    }

    @Test
    public void manipulationOfStoredPositionLeft() {

        int expected = 0;
        int actual = defPlayer.moveLeft().compareTo(defPos);
        assertEquals(expected, actual);
    }

    @Test
    public void manipulationOfStoredPositionRight() {

        int expected = 0;
        int actual = defPlayer.moveRight().compareTo(defPos);
        assertEquals(expected, actual);
    }
}