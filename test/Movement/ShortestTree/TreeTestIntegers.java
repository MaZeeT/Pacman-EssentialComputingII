package Movement.ShortestTree;

import DataStructures.MyStack;
import Movement.ShortestTree.Tree;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TreeTestIntegers {
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
        tree.add(5,13);
        tree.add(5,3);
        tree.add(13,1);
        tree.add(3,8);

        int actual = tree.getSize();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void add5Times2AreEquals() {
        tree.add(5);
        tree.add(5, 3);
        tree.add(3, 13);
        tree.add(3, 1);
        tree.add(5, 3);

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
        tree.add(null, 3);

        boolean actual = tree.contain(5);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void findNotInLargerTree() {
        tree.add(3);
        tree.add(3, 13);
        tree.add(13, 1);
        tree.add(3, 9);
        tree.add(3, 7);

        boolean actual = tree.contain(5);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void findInLargerTree() {
        tree.add(3);
        tree.add(3,13);
        tree.add(13,1);
        tree.add(1,9);
        tree.add(3,7);
        tree.add(1,5);

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
        tree.add(i + 1);

        boolean actual = tree.contain(i);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void containInTreeOfSize10True() {
        int i = 32;
        for (int j = i+10; j > i; j--) {
            tree.add(j, j-1);
        }

        boolean actual = tree.contain(i);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void containInTreeOfSize15False() {
        for (int i = 0; i < 10; i++) {
            tree.add(i, i+1);
        }

        boolean actual = tree.contain(15);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void getAllParentsChildInTree() {
        tree.add(3);
        tree.add(3,13);
        tree.add(13,1);
        tree.add(1,9);
        tree.add(3,7);
        tree.add(1,5);

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(13);
        list.add(1);
        list.add(5);

        //Converts MyStack to a List
        List<Integer> stackList = new ArrayList<>();
        MyStack<Integer> stack = tree.getAllParents(5);
        while (!stack.isEmpty()){
            stackList.add(stack.getNext());
        }

        List<Integer> actual = stackList;
        List<Integer> expected = list;
        assertEquals(expected, actual);
    }

    @Test
    public void getAllParentsChildNotInTree() {
        tree.add(3);
        tree.add(3,13);
        tree.add(13,1);
        tree.add(1,9);
        tree.add(3,7);
        tree.add(1,5);

        //Converts MyStack to a List
        List<Integer> stackList = new ArrayList<>();
        MyStack<Integer> stack = tree.getAllParents(2);
        while (!stack.isEmpty()){
            stackList.add(stack.getNext());
        }

        List<Integer> actual = stackList;
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

}
