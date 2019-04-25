package DataStructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {
    private MyQueue<Integer> queue;

    @Before
    public void setUp() {
        queue = new MyQueue<>();
    }

    @Test
    public void toStringEmpty() {
        String actual = queue.toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    public void toString1Item() {
        queue.add(6);

        String actual = queue.toString();
        String expected = "[6]";
        assertEquals(expected, actual);
    }

    @Test
    public void toString3Item() {
        queue.add(6);
        queue.add(3);
        queue.add(9);

        String actual = queue.toString();
        String expected = "[6, 3, 9]";
        assertEquals(expected, actual);
    }

}