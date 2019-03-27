package DataStructures;

import Components.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreedyTest extends DataStructuresTest{

    private Position target;

    //TODO look into tests with the target in between the different points.

    @Before
    public void setUp(){
        target = new Position(9,9); // move this position to 2,2 to break the tests.
        dataStructure = new Greedy(target);
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
