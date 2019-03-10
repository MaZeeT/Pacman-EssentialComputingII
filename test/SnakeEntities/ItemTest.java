package SnakeEntities;

import SnakeComponents.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    private Item defItem;
    private Position defPos;
    private int defX;
    private int defY;


    @Before
    public void setUp() {
        defX = 2;
        defY = 3;
        defPos = new Position(defX, defY);
        defItem = new Item(defPos);
    }

    @Test
    public void constructorPosition() {
        Position expected = defPos;
        Position actual = defItem.getPosition();
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        boolean expected = false;
        boolean actual = defItem.update();
        assertEquals(expected, actual);
    }
}