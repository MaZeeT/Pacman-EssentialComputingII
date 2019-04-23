package WorkInProgress;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {
    Tree<Integer> tree;

    @Before
    public void setUp() {
        tree = new Tree<>();
    }

    @Test
    public void getSizeZero() {
        int actual = tree.getSize();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void add1() {
        tree.add(3);

        int actual = tree.getSize();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void addSame() {
        tree.add(3);
        tree.add(3);

        int actual = tree.getSize();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void add5TimesNonIsEqual() {
        tree.add(5);
        tree.add(13);
        tree.add(3);
        tree.add(1);
        tree.add(8);

        int actual = tree.getSize();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void add5Times2AreEquals() {
        tree.add(5);
        tree.add(13);
        tree.add(3);
        tree.add(1);
        tree.add(3);

        int actual = tree.getSize();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void findNonAddedToTree() {
        boolean actual = tree.contain(5);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void findNotInTree() {
        tree.add(null,3);

        boolean actual = tree.contain(5);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void findNotInLargerTree() {
        tree.add(3);
        tree.add(13);
        tree.add(1);
        tree.add(9);
        tree.add(7);

        boolean actual = tree.contain(5);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void findInLargerTree() {
        tree.add(3);
        tree.add(13);
        tree.add(1);
        tree.add(9);
        tree.add(7);
        tree.add(5);

        boolean actual = tree.contain(5);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void containInTreeOfSize1True() {
        int i = 32;
        tree.add(i);

        boolean actual = tree.contain(i);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void containInTreeOfSize1False() {
        int i = 32;
        tree.add(i+1);

        boolean actual = tree.contain(i);
        boolean expected = false;
        assertEquals(expected, actual);
    }


    @Test
    public void containInTreeOfSize10True() {
        int i = 32;
        for (int j = -5; j < 10; j++){
            tree.add(i+j);
        }

        boolean actual = tree.contain(i);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void containInTreeOfSize15False() {
        int i = 32;
        for (int j = -5; j < 10; j++){
            tree.add(i+j);
        }
//todo should fail at this moment
        boolean actual = tree.contain(i);
        boolean expected = false;
        assertEquals(expected, actual);
    }


}
