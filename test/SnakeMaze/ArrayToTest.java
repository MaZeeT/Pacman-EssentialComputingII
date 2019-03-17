package SnakeMaze;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Wall;
import SnakeEntities.WayPoint;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArrayToTest {
    private List<GameObject> list;
    private int[][] array;
    private ArrayTo arrTo;

    @Before
    public void setUp() {
        arrTo = new ArrayTo();

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
    public void ArrayToListSize() {

        int expected = 22;
        int actual = arrTo.list(array).size();
        assertEquals(expected, actual);
    }

    @Test
    public void ArrayToListWayPoint() {
        boolean actual = false;
        list = arrTo.list(array);
        WayPoint wp = new WayPoint(new Position(2,4));
        for (GameObject go: list){
            if (wp.compareTo(go) == 0) actual = true;
        }

        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void ArrayToListWall() {
        boolean actual = false;
        list = arrTo.list(array);
        GameObject wall = new Wall(new Position(1,1));
        for (GameObject go: list){
            if (wall.compareTo(go) == 0) actual = true;
        }
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void walls() {
        int [][] arr = new int[][]{
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };

        int expected = 9;
        int actual = arrTo.list(arr).size();
        assertEquals(expected, actual);
    }

    @Test
    public void players() {
        int [][] arr = new int[][]{
                {2,2,2},
                {2,2,2},
                {2,2,2}
        };

        int expected = 9;
        int actual = arrTo.list(arr).size();
        assertEquals(expected, actual);
    }

    @Test
    public void wayPoints() {
        int [][] arr = new int[][]{
                {3,3,3},
                {3,3,3},
                {3,3,3}
        };

        int expected = 9;
        int actual = arrTo.list(arr).size();
        assertEquals(expected, actual);
    }

}