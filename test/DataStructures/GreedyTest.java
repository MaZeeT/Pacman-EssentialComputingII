package DataStructures;

import Components.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreedyTest extends DataStructuresTest {

    private Position target;

    @Before
    public void setUp() {
        target = new Position(9, 9); // move this position to 2,2 to break the tests.
        dataStructure = new Greedy(target);
    }

    @Test
    public void checkNextX1() {
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
    public void checkNextX3() {
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
    public void getNextX1() {
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
    public void getNextX3() {
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

    @Test
    public void getNextX2ScrambledPositions() {
        dataStructure = new Greedy(new Position(4, 3));
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(2, 8);
        Position pos3 = new Position(7, 3);
        dataStructure.add(pos1);
        dataStructure.add(pos2);
        dataStructure.add(pos3);
        dataStructure.getNext();

        Position actual = dataStructure.getNext();
        Position expected = pos1;
        assertEquals(expected, actual);
    }

}
