package Entities;

import Components.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WayPointTest {

    private WayPoint defWayPoint;
    private Position defPos;

    @Before
    public void setUp() {
        int defX = 2;
        int defY = 3;
        defPos = new Position(defX, defY);
        defWayPoint = new WayPoint(defPos);
    }

    @Test
    public void constructorPosition() {
        Position expected = defPos;
        Position actual = defWayPoint.getPosition();
        assertEquals(expected, actual);
    }

}
