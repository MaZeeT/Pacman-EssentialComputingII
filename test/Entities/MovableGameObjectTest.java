package Entities;

import Components.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class MovableGameObjectTest {
     MovableGameObject defMovable;
     Position defPos;
     int defX;
     int defY;

    @Test
    public void moveUp() {
        Position pos = new Position(defX, defY - 1);

        int expected = 0;
        int actual = defMovable.moveUp().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void moveDown() {
        Position pos = new Position(defX, defY + 1);

        int expected = 0;
        int actual = defMovable.moveDown().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void moveLeft() {
        Position pos = new Position(defX - 1, defY);

        int expected = 0;
        int actual = defMovable.moveLeft().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void moveRight() {
        Position pos = new Position(defX + 1, defY);

        int expected = 0;
        int actual = defMovable.moveRight().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void move() {
        Position pos = new Position(defX + 1, defY);

        int expected = 0;
        int actual = defMovable.moveRight().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void checkUp() {
        Position pos = new Position(defX, defY - 1);

        int expected = 0;
        int actual = defMovable.checkUp().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void checkUp2() {
        int expected = -1;
        int actual = defPos.compareTo(defMovable.checkUp());
        assertEquals(expected, actual);
    }

    @Test
    public void checkDown() {
        Position pos = new Position(defX, defY + 1);

        int expected = 0;
        int actual = defMovable.checkDown().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void checkDown2() {
        int expected = +1;
        int actual = defPos.compareTo(defMovable.checkDown());
        assertEquals(expected, actual);
    }

    @Test
    public void checkLeft() {
        Position pos = new Position(defX - 1, defY);

        int expected = 0;
        int actual = defMovable.checkLeft().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void checkLeft2() {
        int expected = -1;
        int actual = defPos.compareTo(defMovable.checkLeft());
        assertEquals(expected, actual);
    }

    @Test
    public void checkRight() {
        Position pos = new Position(defX + 1, defY);

        int expected = 0;
        int actual = defMovable.checkRight().compareTo(pos);
        assertEquals(expected, actual);
    }

    @Test
    public void checkRight2() {
        int expected = +1;
        int actual = defPos.compareTo(defMovable.checkRight());
        assertEquals(expected, actual);
    }

}
