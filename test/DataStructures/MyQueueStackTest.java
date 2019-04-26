package DataStructures;

import Components.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyQueueStackTest {

    private DataStructure<Position> dataStructure;

    @Before
    public void setUp() {
        dataStructure = new MyQueue<>();
    }

    @Test
    public void isEmptyTrue() {
        boolean actual = dataStructure.isEmpty();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void isEmptyFalse() {
        Position pos1 = new Position(1, 1);
        dataStructure.add(pos1);

        boolean actual = dataStructure.isEmpty();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void isEmptyTrueAfterNotEmpty() {
        Position pos1 = new Position(1, 1);
        dataStructure.add(pos1);
        dataStructure.getNext();

        boolean actual = dataStructure.isEmpty();
        boolean expected = true;
        assertEquals(expected, actual);
    }

}