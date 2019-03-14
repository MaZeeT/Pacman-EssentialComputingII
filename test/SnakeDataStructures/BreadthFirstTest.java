package SnakeDataStructures;

import SnakeComponents.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BreadthFirstTest {


    IDataStructure fifo;

    @Before
    public void setUp() {
        fifo = new BreadthFirst();
    }

    @Test
    public void addAndContainsTrue() {
        Position pos = new Position(2, 3);
        fifo.add(pos);
        boolean actual = fifo.contains(pos);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void addAndContainsFalse() {
        Position pos = new Position(2, 3);
        fifo.add(pos);
        boolean actual = fifo.contains(new Position(3, 3));
        boolean expected = false;
        assertEquals(expected, actual);
    }


    @Test
    public void checkNext() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(2, 2);
        Position pos3 = new Position(3, 3);
        fifo.add(pos1);
        fifo.add(pos2);
        fifo.add(pos3);

        Position actual = fifo.checkNext();
        Position expected = pos1;
        assertEquals(expected, actual);
    }

    @Test
    public void checkNext2() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(2, 2);
        Position pos3 = new Position(3, 3);
        fifo.add(pos1);
        fifo.add(pos2);
        fifo.add(pos3);
        fifo.checkNext();
        fifo.checkNext();
        Position actual = fifo.checkNext();
        Position expected = pos1;
        assertEquals(expected, actual);
    }

    @Test
    public void getNext() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(2, 2);
        Position pos3 = new Position(3, 3);
        fifo.add(pos1);
        fifo.add(pos2);
        fifo.add(pos3);

        Position actual = fifo.getNext();
        Position expected = pos1;
        assertEquals(expected, actual);
    }

    @Test
    public void getNext2() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(2, 2);
        Position pos3 = new Position(3, 3);
        fifo.add(pos1);
        fifo.add(pos2);
        fifo.add(pos3);
        fifo.getNext();
        fifo.getNext();

        Position actual = fifo.getNext();
        Position expected = pos3;
        assertEquals(expected, actual);
    }
}