package SnakeComponents;

import SnakeEntities.Player;
import SnakeEntities.WayPoint;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionManhattanTest {

    private WayPoint wayPoint;
    private Player player;

    @Before
    public void setUp() {
        wayPoint = new WayPoint(new Position(1, 1));
        player = new Player(new Position(3, 3));
    }

    @Test
    public void xyConstructor() {
        int x = 4;
        int y = 5;
        Position manhattan = new PositionManhattan(x, y);

        boolean expected = true;
        boolean actual = manhattan.getX() == x && manhattan.getY() == y;
        assertEquals(expected, actual);
    }

    @Test
    public void positionConstructor() {
        int x = 4;
        int y = 5;
        Position position = new Position(x, y);
        Position manhattan = new PositionManhattan(position);

        boolean expected = true;
        boolean actual = manhattan.getX() == x && manhattan.getY() == y;
        assertEquals(expected, actual);
    }

    @Test
    public void comparePositionAndManhattanPositionTrue() {
        int x = 4;
        int y = 5;
        Position position = new Position(x, y);
        Position manhattan = new PositionManhattan(x, y);

        boolean expected = true;
        boolean actual = position.equals(manhattan);
        assertEquals(expected, actual);
    }

    @Test
    public void comparePositionAndManhattanPositionFalse() {
        int x = 4;
        int y = 5;
        Position position = new Position(2, 3);
        Position manhattan = new PositionManhattan(x, y);

        boolean expected = false;
        boolean actual = position.equals(manhattan);
        assertEquals(expected, actual);
    }

    @Test
    public void castTypeFalse() {
        boolean expected = false;
        boolean actual = wayPoint.getPosition() instanceof PositionManhattan;
        assertEquals(expected, actual);
    }

    @Test
    public void castTypeTrue() {
        wayPoint.setPosition(new PositionManhattan(1, 2));
        boolean expected = true;
        boolean actual = wayPoint.getPosition() instanceof PositionManhattan;
        assertEquals(expected, actual);
    }

    @Test
    public void distance0() {
        Position position = new Position(1, 2);
        PositionManhattan manhattan = new PositionManhattan(1, 2);

        int expected = 0;
        int actual = manhattan.getDistanceTo(position);
        assertEquals(expected, actual);
    }

    @Test
    public void distance1() {
        Position position = new Position(1, 2);
        PositionManhattan manhattan = new PositionManhattan(2, 2);

        int expected = 1;
        int actual = manhattan.getDistanceTo(position);
        assertEquals(expected, actual);
    }

    @Test
    public void distance2() {
        Position position = new Position(1, 4);
        PositionManhattan manhattan = new PositionManhattan(1, 2);

        int expected = 2;
        int actual = manhattan.getDistanceTo(position);
        assertEquals(expected, actual);
    }

    @Test
    public void distance8() {
        Position position = new Position(1, 1);
        PositionManhattan manhattan = new PositionManhattan(5, 5);

        int expected = 8;
        int actual = manhattan.getDistanceTo(position);
        assertEquals(expected, actual);
    }

    @Test
    public void distanceXY() {
        int x = 3;
        int y = 5;
        PositionManhattan manhattan = new PositionManhattan(5, 5);

        int expected = 2;
        int actual = manhattan.getDistanceTo(x,y);
        assertEquals(expected, actual);
    }

}
