package SnakeDataStructures;

import SnakeComponents.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepthFirstTest {

    private IDataStructure filo;

    @Before
    public void setUp() {
        filo = new DepthFirst();
    }

    @Test
    public void addAndContainsTrue() {
        Position pos = new Position(2, 3);
        filo.add(pos);
        boolean actual = filo.contains(pos);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void addAndContainsFalse() {
        Position pos = new Position(2, 3);
        filo.add(pos);
        boolean actual = filo.contains(new Position(3, 3));
        boolean expected = false;
        assertEquals(expected, actual);
    }


    @Test
    public void checkNext() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(2, 2);
        Position pos3 = new Position(3, 3);
        filo.add(pos1);
        filo.add(pos2);
        filo.add(pos3);

        Position actual = filo.checkNext();
        Position expected = pos3;
        assertEquals(expected, actual);
    }

    @Test
    public void checkNext2() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(2, 2);
        Position pos3 = new Position(3, 3);
        filo.add(pos1);
        filo.add(pos2);
        filo.add(pos3);
        filo.checkNext();
        filo.checkNext();
        Position actual = filo.checkNext();
        Position expected = pos3;
        assertEquals(expected, actual);
    }

    @Test
    public void checkNextNull() {
        Position actual = filo.checkNext();
        Position expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void getNext() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(2, 2);
        Position pos3 = new Position(3, 3);
        filo.add(pos1);
        filo.add(pos2);
        filo.add(pos3);

        Position actual = filo.getNext();
        Position expected = pos3;
        assertEquals(expected, actual);
    }

    @Test
    public void getNext2() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(2, 2);
        Position pos3 = new Position(3, 3);
        filo.add(pos1);
        filo.add(pos2);
        filo.add(pos3);
        filo.getNext();
        filo.getNext();

        Position actual = filo.getNext();
        Position expected = pos1;
        assertEquals(expected, actual);
    }

    @Test
    public void getNextNull() {
        Position actual = filo.getNext();
        Position expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void getNextNull2() {
        Position pos1 = new Position(1, 1);
        filo.add(pos1);
        filo.getNext();

        Position actual = filo.getNext();
        Position expected = null;
        assertEquals(expected, actual);
    }

}