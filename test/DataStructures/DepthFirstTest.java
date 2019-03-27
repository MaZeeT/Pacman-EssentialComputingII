package DataStructures;

import Components.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepthFirstTest extends DataStructuresTest {

    @Before
    public void setUp() {
        dataStructure = new DepthFirst();
    }

    @Test
    public void checkNext() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(2, 2);
        Position pos3 = new Position(3, 3);
        dataStructure.add(pos1);
        dataStructure.add(pos2);
        dataStructure.add(pos3);

        Position actual = dataStructure.checkNext();
        Position expected = pos3;
        assertEquals(expected, actual);
    }

    @Test
    public void checkNext2() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(2, 2);
        Position pos3 = new Position(3, 3);
        dataStructure.add(pos1);
        dataStructure.add(pos2);
        dataStructure.add(pos3);
        dataStructure.checkNext();
        dataStructure.checkNext();
        Position actual = dataStructure.checkNext();
        Position expected = pos3;
        assertEquals(expected, actual);
    }

    @Test
    public void getNext() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(2, 2);
        Position pos3 = new Position(3, 3);
        dataStructure.add(pos1);
        dataStructure.add(pos2);
        dataStructure.add(pos3);

        Position actual = dataStructure.getNext();
        Position expected = pos3;
        assertEquals(expected, actual);
    }

    @Test
    public void getNext2() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(2, 2);
        Position pos3 = new Position(3, 3);
        dataStructure.add(pos1);
        dataStructure.add(pos2);
        dataStructure.add(pos3);
        dataStructure.getNext();
        dataStructure.getNext();

        Position actual = dataStructure.getNext();
        Position expected = pos1;
        assertEquals(expected, actual);
    }

}
