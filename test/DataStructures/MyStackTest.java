package DataStructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {

    private MyStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new MyStack<>();
    }

    @Test
    public void toStringEmpty() {
        String actual = stack.toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    public void toString1Item() {
        stack.add(6);

        String actual = stack.toString();
        String expected = "[6]";
        assertEquals(expected, actual);
    }

    @Test
    public void toString3Item() {
        stack.add(6);
        stack.add(3);
        stack.add(9);

        String actual = stack.toString();
        String expected = "[6, 3, 9]";
        assertEquals(expected, actual);
    }

}
