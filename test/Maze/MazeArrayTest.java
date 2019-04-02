package Maze;

import Components.Position;
import Entities.GameObject;
import Entities.Player;
import Entities.Wall;
import Entities.WayPoint;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MazeArrayTest {
    private int[][] array;
    private MazeArrayBased arrayGet;

    @Before
    public void setUp() {
        arrayGet = new MazeArrayTestable(5, 6);

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
        Position actualPosition = arrayGet.players(array).get(0).getPosition(); //TODO list support

        int expected = 0;
        int actual = actualPosition.compareTo(testPosition);
        assertEquals(expected, actual);
    }

    @Test
    public void ArrayGetNullPlayer() {
        MazeArrayBased arrGet = new MazeArrayTestable(3, 3);
        int[][] arr = new int[][]{
                {1, 1, 1},
                {1, 1, 3},
                {1, 1, 1}
        };


          boolean actual = arrGet.players.isEmpty();
          boolean expected = true;
          assertEquals(expected,actual);

        //Player actual = arrGet.players(arr).get(0);//TODO list support
        //assertNull(actual);
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
        MazeArrayBased arrGet = new MazeArrayTestable(3, 3);
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
        MazeArrayBased arrGet = new MazeArrayTestable(3, 3);
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
