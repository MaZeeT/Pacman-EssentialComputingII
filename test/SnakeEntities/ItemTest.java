package SnakeEntities;

import SnakeComponents.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    private Item defItem;
    private Position defPos;

    @Before
    public void setUp() {
        int defX = 2;
        int defY = 3;
        defPos = new Position(defX, defY);
        defItem = new Item(defPos);
    }

    @Test
    public void constructorPosition() {
        Position expected = defPos;
        Position actual = defItem.getPosition();
        assertEquals(expected, actual);
    }

}