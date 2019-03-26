package SnakeDataStructures;

import SnakeComponents.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class DataStructuresTest {

    IDataStructure dataStructure;

    @Test
    public void addAndContainsTrue() {
        Position pos = new Position(2, 3);
        dataStructure.add(pos);
        boolean actual = dataStructure.contains(pos);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void addAndContainsFalse() {
        Position pos = new Position(2, 3);
        dataStructure.add(pos);
        boolean actual = dataStructure.contains(new Position(3, 3));
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void checkNextNull() {
        Position actual = dataStructure.checkNext();
        Position expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void getNextNull() {
        Position actual = dataStructure.getNext();
        Position expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void getNextNull2() {
        Position pos1 = new Position(1, 1);
        dataStructure.add(pos1);
        dataStructure.getNext();

        Position actual = dataStructure.getNext();
        Position expected = null;
        assertEquals(expected, actual);
    }

}
