package SnakeComponents;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    private int defX;
    private int defY;
    private Position pos;

    @Before
    public void setUp(){
        defX = 2;
        defY = 4;
        pos = new Position(defX,defY);
    }

    @Test
    public void getX() {
        int expected = defX;
        int actual = pos.getX();
        assertEquals(expected, actual);
    }

    @Test
    public void getY() {
        int expected = defY;
        int actual = pos.getY();
        assertEquals(expected, actual);
    }

    @Test
    public void setX() {
        int expected = 2;
        pos.setX(expected);
        int actual = pos.getX();
        assertEquals(expected, actual);
    }

    @Test
    public void setY() {
        int expected = 5;
        pos.setY(expected);
        int actual = pos.getY();
        assertEquals(expected, actual);
    }

    @Test
    public void compareEqual() {
        Position newPos = new Position(defX,defY);
        int expected = pos.compareTo(newPos);
        int actual = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void compareToHigherX() {
        Position newPos = new Position(defX+1,defY);
        int expected = pos.compareTo(newPos);
        int actual = +1;
        assertEquals(expected, actual);
    }

    @Test
    public void compareToLowerX() {
        Position newPos = new Position(defX-1,defY);
        int expected = pos.compareTo(newPos);
        int actual = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void compareToHigherY() {
        Position newPos = new Position(defX,defY+1);
        int expected = pos.compareTo(newPos);
        int actual = +1;
        assertEquals(expected, actual);
    }

    @Test
    public void compareToLowerY() {
        Position newPos = new Position(defX,defY-1);
        int expected = pos.compareTo(newPos);
        int actual = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void compareToHigherXY() {
        Position newPos = new Position(defX+1,defY+1);
        int expected = pos.compareTo(newPos);
        int actual = +1;
        assertEquals(expected, actual);
    }

    @Test
    public void compareToLowerXY() {
        Position newPos = new Position(defX-1,defY-1);
        int expected = pos.compareTo(newPos);
        int actual = -1;
        assertEquals(expected, actual);
    }
}