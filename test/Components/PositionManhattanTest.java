package Components;

import Entities.Player;
import Entities.WayPoint;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;
import static org.junit.Assert.*;

public class PositionManhattanTest extends PositionTest {

    private WayPoint wayPoint;
    private Player player;

    @Before
    public void setUp() {
        wayPoint = new WayPoint(new Position(1, 1));
        player = new Player(new Position(3, 3));
        this.pos = new PositionManhattan(this.defX, this.defY);
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
    public void distance1ToPosition() {
        Position position = new Position(1, 2);
        PositionManhattan manhattan = new PositionManhattan(2, 2);

        int expected = 1;
        int actual = manhattan.getDistanceTo(position);
        assertEquals(expected, actual);
    }

    @Test
    public void distance2ToPosition() {
        Position position = new Position(1, 4);
        PositionManhattan manhattan = new PositionManhattan(1, 2);

        int expected = 2;
        int actual = manhattan.getDistanceTo(position);
        assertEquals(expected, actual);
    }

    @Test
    public void distance8ToPosition() {
        Position position = new Position(1, 1);
        PositionManhattan manhattan = new PositionManhattan(5, 5);

        int expected = 8;
        int actual = manhattan.getDistanceTo(position);
        assertEquals(expected, actual);
    }

    @Test
    public void distanceToXY() {
        int x = 3;
        int y = 5;
        PositionManhattan manhattan = new PositionManhattan(5, 5);

        int expected = 2;
        int actual = manhattan.getDistanceTo(x, y);
        assertEquals(expected, actual);
    }

    @Test
    public void getDistance() {
        PositionManhattan manhattan = new PositionManhattan(5, 5);
        manhattan.getDistanceTo(player.getPosition());

        int expected = 4;
        int actual = manhattan.getDistance();
        assertEquals(expected, actual);
    }

    @Test
    public void comparePositiveToNegativeDistance() {
        PositionManhattan pos1 = new PositionManhattan(1, 1);
        PositionManhattan pos2 = new PositionManhattan(5, 5);

        int expected = pos1.getDistanceTo(pos2);
        int actual = pos2.getDistanceTo(pos1);
        assertEquals(expected, actual);
    }

    @Test
    public void compareToLowerDistance() {
        PositionManhattan pos1 = new PositionManhattan(7, 7);
        PositionManhattan pos2 = new PositionManhattan(5, 5);
        pos1.getDistanceTo(wayPoint.getPosition());
        pos2.getDistanceTo(wayPoint.getPosition());

        int expected = -1;
        int actual = pos1.compareTo(pos2);
        assertEquals(expected, actual);
    }

    @Test
    public void compareToHigherDistance() {
        PositionManhattan pos1 = new PositionManhattan(2, 1);
        PositionManhattan pos2 = new PositionManhattan(2, 2);
        pos1.getDistanceTo(wayPoint.getPosition());
        pos2.getDistanceTo(wayPoint.getPosition());

        int expected = 1;
        int actual = pos1.compareTo(pos2);
        assertEquals(expected, actual);
    }

    @Test
    public void compareToDistanceSameHigherX() {
        PositionManhattan pos1 = new PositionManhattan(2, 1);
        PositionManhattan pos2 = new PositionManhattan(1, 2);
        pos1.getDistanceTo(wayPoint.getPosition());
        pos2.getDistanceTo(wayPoint.getPosition());

        int expected = -1;
        int actual = pos1.compareTo(pos2);
        assertEquals(expected, actual);
    }

    @Test
    public void compareToDistanceSameHigherY() {
        PositionManhattan pos1 = new PositionManhattan(1, 2);
        PositionManhattan pos2 = new PositionManhattan(2, 1);
        pos1.getDistanceTo(wayPoint.getPosition());
        pos2.getDistanceTo(wayPoint.getPosition());

        int expected = +1;
        int actual = pos1.compareTo(pos2);
        assertEquals(expected, actual);
    }

    @Test
    public void sortPositionManhattan() {
        List<PositionManhattan> arr = new ArrayList<>();
        arr.add(new PositionManhattan(1, 3));
        arr.add(new PositionManhattan(4, 4));
        arr.add(new PositionManhattan(1, 2));
        arr.add(new PositionManhattan(2, 3));
        arr.add(new PositionManhattan(3, 3));
        arr.add(new PositionManhattan(4, 3));
        arr.add(new PositionManhattan(5, 4));

        PositionManhattan expected = new PositionManhattan(6, 6);
        arr.add(expected);

        for (PositionManhattan arrPos : arr) {
            arrPos.getDistanceTo(new Position(9, 9));
        }

        arr.sort(reverseOrder());

        PositionManhattan actual = arr.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void isEqual() {
        int x = 9;
        int y = 9;
        PositionManhattan pos1 = new PositionManhattan(defX, defY);
        PositionManhattan pos2 = new PositionManhattan(defX, defY);
        pos1.getDistanceTo(x, y);
        pos2.getDistanceTo(x, y);

        boolean expected = true;
        boolean actual = pos1.equals(pos2);
        assertEquals(expected, actual);
    }

    @Test
    public void isNotEqual() {
        int x = 9;
        int y = 9;
        PositionManhattan pos1 = new PositionManhattan(defX, defY);
        PositionManhattan pos2 = new PositionManhattan(defX + 1, defY + 1);
        pos1.getDistanceTo(x, y);
        pos2.getDistanceTo(x, y);

        boolean expected = false;
        boolean actual = pos1.equals(pos2);
        assertEquals(expected, actual);
    }

    @Test
    public void isEqualWrongTypeString() {
        PositionManhattan pos1 = new PositionManhattan(defX, defY);
        pos1.getDistanceTo(1, 1);
        String string = "test";

        boolean expected = false;
        boolean actual = pos1.equals(string);
        assertEquals(expected, actual);
    }

    @Test
    public void isEqualWrongTypePosition() {
        PositionManhattan pos1 = new PositionManhattan(defX, defY);
        Position pos2 = new Position(defX, defY);
        pos1.getDistanceTo(1, 1);

        boolean expected = false;
        boolean actual = pos1.equals(pos2);
        assertEquals(expected, actual);
    }

    @Test
    public void notEqualHashcode() {
        int x = 7;
        int y = 3;
        PositionManhattan pos1 = new PositionManhattan(defX, defY);
        PositionManhattan pos2 = new PositionManhattan(defX + 1, defY + 1);
        pos1.getDistanceTo(x, y);
        pos2.getDistanceTo(x, y);

        boolean expected = false;
        boolean actual = pos1.hashCode() == pos2.hashCode();
        assertEquals(expected, actual);
    }

    @Test
    public void equalHashcode() {
        int x = 5;
        int y = 11;
        PositionManhattan pos1 = new PositionManhattan(defX, defY);
        PositionManhattan pos2 = new PositionManhattan(defX, defY);
        pos1.getDistanceTo(x, y);
        pos2.getDistanceTo(x, y);

        boolean expected = true;
        boolean actual = pos1.hashCode() == pos2.hashCode();
        assertEquals(expected, actual);
    }

}
