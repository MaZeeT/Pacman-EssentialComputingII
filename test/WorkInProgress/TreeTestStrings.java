package WorkInProgress;

import WorkInProgress.ShortestTree.Tree;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TreeTestStrings {
    Tree<String> tree;

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
        tree.add("ff");

        int actual = tree.getSize();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void addSame() {
        tree.add("ff");
        tree.add("ff");

        int actual = tree.getSize();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void add5TimesNonIsEqual() {
        tree.add("ff");
        tree.add("ff", "fa");
        tree.add("ff", "gf");
        tree.add("gf", "ab");
        tree.add("fa", "abc");

        int actual = tree.getSize();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void add5Times2AreEquals() {
        tree.add("ff");
        tree.add("ff", "fa");
        tree.add("ff", "gf");
        tree.add("gf", "ab");
        tree.add("fa", "ab");

        int actual = tree.getSize();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void findNonAddedToTree() {
        boolean actual = tree.contain("a");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void findNotInTree() {
        tree.add(null, "c");

        boolean actual = tree.contain("b");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void findNotInLargerTree() {
        tree.add("ff");
        tree.add("ff", "fa");
        tree.add("ff", "gf");
        tree.add("gf", "ab");
        tree.add("fa", "abc");

        boolean actual = tree.contain("ce");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void findInLargerTree() {
        tree.add("ff");
        tree.add("ff", "fa");
        tree.add("ff", "gf");
        tree.add("gf", "ab");
        tree.add("fa", "abc");

        boolean actual = tree.contain("abc");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void containInTreeOfSize1True() {
        String s = "myString";
        tree.add(s);

        boolean actual = tree.contain(s);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void containInTreeOfSize1False() {
        String s = "hiding";
        tree.add("plainSight");

        boolean actual = tree.contain(s);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void containInTreeOfSize10True() {
        String s1 = "niels";
        String s2 = "jens";
        String s3 = "kim";
        String s4 = "hansen";
        String s5 = "mads";

        tree.add(s1);
        tree.add(s1, s2);
        tree.add(s1, s3);
        tree.add(s2, s4);
        tree.add(s4, s5);

        boolean actual = tree.contain("mads");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void containInTreeOfSize5False() {
        String s1 = "niels";
        String s2 = "jens";
        String s3 = "kim";
        String s4 = "hansen";
        String s5 = "mads";

        tree.add(s1);
        tree.add(s1, s2);
        tree.add(s1, s3);
        tree.add(s2, s4);
        tree.add(s4, s5);

        boolean actual = tree.contain("ebbe");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void getAllParentsChildInTree() {
        String s1 = "niels";
        String s2 = "jens";
        String s3 = "kim";
        String s4 = "hansen";
        String s5 = "mads";

        tree.add(s1);
        tree.add(s1, s2);
        tree.add(s1, s3);
        tree.add(s2, s4);
        tree.add(s4, s5);

        List<String> list = new ArrayList<>();
        // list is returned backwards (from child to grandparents)
        list.add(s5);
        list.add(s4);
        list.add(s2);
        list.add(s1);

        List<String> actual = tree.getAllParents("mads");
        List<String> expected = list;
        assertEquals(expected, actual);
    }

    @Test
    public void getAllParentsChildNotInTree() {
        String s1 = "niels";
        String s2 = "jens";
        String s3 = "kim";
        String s4 = "hansen";
        String s5 = "mads";

        tree.add(s1);
        tree.add(s1, s2);
        tree.add(s1, s3);
        tree.add(s2, s4);
        tree.add(s4, s5);

        List<String> actual = tree.getAllParents("ebbe");
        List<String> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

}
