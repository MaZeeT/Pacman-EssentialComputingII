package SnakeMaze;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeEntities.Wall;
import SnakeEntities.WayPoint;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArrayGetTest {
    private int[][] array;
    private ArrayGet arrayGet;

    @Before
    public void setUp() {
        arrayGet = new ArrayGet(5, 6);

        array = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 2, 1, 0, 3},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };

    }

    @Test
    public void ArrayGetPlayer() {
        Position testPosition = new Position(1, 1);
        Position actualPosition = arrayGet.player(array).getPosition();

        int expected = 0;
        int actual = actualPosition.compareTo(testPosition);
        assertEquals(expected, actual);
    }

    @Test
    public void ArrayGetNullPlayer() {
        ArrayGet arrGet = new ArrayGet(3, 3);
        int[][] arr = new int[][]{
                {1, 1, 1},
                {1, 1, 3},
                {1, 1, 1}
        };

        Player actual = arrGet.player(arr);
        assertNull(actual);
    }

    @Test
    public void ArrayGetWayPoint() {
        Position testPosition = new Position(1, 4);
        Position actualPosition = arrayGet.wayPoint(array).getPosition();

        int expected = 0;
        int actual = actualPosition.compareTo(testPosition);
        assertEquals(expected, actual);
    }

    @Test
    public void ArrayGetNullWayPoint() {
        ArrayGet arrGet = new ArrayGet(3, 3);
        int[][] arr = new int[][]{
                {1, 1, 1},
                {1, 1, 2},
                {1, 1, 1}
        };

        WayPoint actual = arrGet.wayPoint(arr);
        assertNull(actual);
    }


    @Test
    public void ArrayGetWalls() {
        boolean actual = false;
        List<GameObject> walls = arrayGet.walls(array);
        GameObject wall = new Wall(new Position(2, 2));
        for (GameObject go : walls) {
            if (wall.compareTo(go) == 0) actual = true;
        }
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void walls() {
        ArrayGet arrGet = new ArrayGet(3, 3);
        int[][] arr = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        int expected = 9;
        int actual = arrGet.walls(arr).size();
        assertEquals(expected, actual);
    }

}
